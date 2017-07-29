package com.android.grafika;

public class FPSCounter {

    private long previousTimestamp;
    private long[] timestamp;
    private int timestampCounter = 0;
    private final int count;

    public FPSCounter(int count) {
        this.count = count;
        timestamp = new long[count];
    }

    public boolean tick() {
        long t = System.currentTimeMillis();
        timestamp[timestampCounter] = t - previousTimestamp;
        previousTimestamp = t;

        timestampCounter++;
        if (timestampCounter == count) {
            timestampCounter = 0;
            return true;
        }
        return false;
    }

    public double getAverageFps() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += timestamp[i];
        }

        return (1000 / (sum / count));
    }
}
