package AlgorithmToolkit;

/**
 * Utility to measure execution time of algorithms.
 */
public class AnalysisUtil {

    /**
     * Measures runnable execution time in milliseconds.
     */
    public static long measureTime(Runnable task) {
        long start = System.currentTimeMillis();
        task.run();
        return System.currentTimeMillis() - start;
    }
}
