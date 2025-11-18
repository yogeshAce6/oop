import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
public class LogAnalyzer {    // Shared thread-safe map for keyword counts
    static ConcurrentHashMap<String, Integer> globalCount = new ConcurrentHashMap<>();

    // Worker class for analyzing a single file
    static class LogWorker implements Callable<Map<String, Integer>> {
        private File file;
        private List<String> keywords;

        LogWorker(File file, List<String> keywords) {
            this.file = file;
            this.keywords = keywords;
        }

        @Override
        public Map<String, Integer> call() throws Exception {
            Map<String, Integer> localCount = new HashMap<>();

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                br.lines().forEach(line -> {
                    keywords.forEach(key -> {
                        if (line.contains(key)) {
                            localCount.merge(key, 1, Integer::sum);
                        }
                    });
                });
            }

            return localCount;
        }
    }

    public static void main(String[] args) throws Exception {

        // -------- CHANGE FOLDER PATH HERE ----------
        String folderPath = "logs";   // folder containing .txt log files
        List<String> keywords = Arrays.asList("ERROR", "WARN", "INFO");

        File folder = new File(folderPath);
        File[] files = folder.listFiles((dir, name) -> name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("No log files found!");
            return;
        }

        // Create thread pool
        int N = 4;   // Fixed thread pool size
        ExecutorService executor = Executors.newFixedThreadPool(N);

        long start = System.currentTimeMillis();

        List<Future<Map<String, Integer>>> futures = new ArrayList<>();

        // Submit each file to executor
        for (File f : files) {
            futures.add(executor.submit(new LogWorker(f, keywords)));
        }

        // Wait for results and aggregate
        for (Future<Map<String, Integer>> future : futures) {
            Map<String, Integer> result = future.get();
            result.forEach((key, val) ->
                    globalCount.merge(key, val, Integer::sum)
            );
        }

        executor.shutdown();

        long end = System.currentTimeMillis();
        long timeTaken = end - start;

        // Sort results using Streams
        Map<String, Integer> sortedSummary =
                globalCount.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (a, b) -> a,
                                LinkedHashMap::new
                        ));

        // Print summary
        System.out.println("\n===== LOG ANALYSIS SUMMARY =====");
        sortedSummary.forEach((k, v) ->
                System.out.println(k + " : " + v)
        );
        System.out.println("Execution Time: " + timeTaken + " ms");

        // Write summary to file
        File output = new File("result_summary.txt");
        try (PrintWriter pw = new PrintWriter(output)) {
            pw.println("===== LOG ANALYSIS SUMMARY =====");
            sortedSummary.forEach((k, v) -> pw.println(k + " : " + v));
            pw.println("Execution Time: " + timeTaken + " ms");
        }

        System.out.println("Summary saved to result_summary.txt");
    }
}


