package com.github.smarteist;

public class MyBenchmark {
    private long startedMicros = 0;

    public void start() {
        this.startedMicros = System.nanoTime();
    }


    public long stop() {
        if (startedMicros != 0)
            return System.nanoTime() - startedMicros;
        return startedMicros;
    }
}
