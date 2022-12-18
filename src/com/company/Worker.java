package com.company;

public class Worker {
    private final OnTaskDoneListener callback;
    private final OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }

    public void start() {
        for (int i = 1; i < 100; i++) {
            if (i == 33) {
                errorCallback.onError("ERROR!!! Task " + i + " is undone");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}
