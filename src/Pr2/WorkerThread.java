package Pr2;

public class WorkerThread extends Thread {
    private final TaskQueueManager taskQueueManager;

    public WorkerThread(TaskQueueManager taskQueueManager) {
        this.taskQueueManager = taskQueueManager;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Runnable task = taskQueueManager.getTask();
                task.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


