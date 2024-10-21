package org.example.ex1;

import java.util.Arrays;

public class Notes {
    private final float[] notes;

    public Notes(float[] notes) {
        this.notes = notes;
    }

    public void sortAndShow() {
        Arrays.sort(notes);
        System.out.println("Le tri des notes : " + Arrays.toString(notes));
    }

    public float getAverage() {
        float sum = 0;
        for (float num : notes) {
            sum += num;
        }
        return sum / notes.length;
    }

    public float getMin() {
        float min = notes[0];
        for (float num : notes) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public float getMax() {
        float max = notes[0];
        for (float num : notes) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public int getRepeatedNote(int note) {
        int count = 0;
        for (float num : notes) {
            if (num == (float) note) {
                count++;
            }
        }
        return count;
    }
}
