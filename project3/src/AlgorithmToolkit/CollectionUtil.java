package AlgorithmToolkit;

import java.util.LinkedList;

/**
 * Generic Stack and Queue implementation.
 */
public class CollectionUtil {

    /** Generic Stack */
    public static class Stack<T> {
        private LinkedList<T> list = new LinkedList<>();

        public void push(T value) { list.addFirst(value); }
        public T pop() { return list.removeFirst(); }
        public T peek() { return list.getFirst(); }
        public boolean isEmpty() { return list.isEmpty(); }
    }

    /** Generic Queue */
    public static class Queue<T> {
        private LinkedList<T> list = new LinkedList<>();

        public void enqueue(T value) { list.addLast(value); }
        public T dequeue() { return list.removeFirst(); }
        public T peek() { return list.getFirst(); }
        public boolean isEmpty() { return list.isEmpty(); }
    }
}
