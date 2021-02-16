package Coding30days;

import java.util.*;

public class day28 {

    public static int minimum_index(int[] seq) {
        if (seq.length == 0) {
            throw new IllegalArgumentException("Cannot get the minimum value index from an empty sequence");
        }
        int min_idx = 0;
        for (int i = 1; i < seq.length; ++i) {
            if (seq[i] < seq[min_idx]) {
                min_idx = i;
            }
        }
        return min_idx;
    }

    static class TestDataEmptyArray {
        public static int[] get_array() {
            // complete this function
            int [] arr = new int [0];
            return arr;
        }
    }

    static class TestDataUniqueValues {
        public static int[] get_array() {
            // complete this function
            int [] arr = new int [2];
            arr[0] = 3;
            arr[1] = 2;
            return arr;
        }

        public static int get_expected_result() {
            // complete this function
            return 1;
        }
    }

    static class TestDataExactlyTwoDifferentMinimums {
        public static int[] get_array() {
            // complete this function
            int [] arr = new int [2];
            arr[0] = 2;
            arr[1] = 2;
            return arr;
        }

        public static int get_expected_result() {
            // complete this function
            return 0;
        }
    }

    