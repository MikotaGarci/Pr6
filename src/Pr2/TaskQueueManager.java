package Pr2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TaskQueueManager {
    private final BlockingQueue<Runnable> taskQueue;
    private final WorkerThread[] workerThreads;

    public TaskQueueManager(int capacity, int numThreads) {
        this.taskQueue = new ArrayBlockingQueue<>(capacity);
        this.workerThreads = new WorkerThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            this.workerThreads[i] = new WorkerThread(this);
        }
    }

    public void start() {
        for (WorkerThread workerThread : workerThreads) {
            workerThread.start();
        }
    }

    public void addTask(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Runnable getTask() throws InterruptedException {
        return taskQueue.take();
    }

    public void stop() {
        for (WorkerThread workerThread : workerThreads) {
            workerThread.interrupt();
        }
    }
}