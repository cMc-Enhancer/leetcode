package com.example.leetCode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SlidingWindowMedianTest {

    private static SlidingWindowMedian median;

    @BeforeAll
    static void setUp() {
        median = new SlidingWindowMedian();
    }

    @Test
    void medianSlidingWindow() {
        int[] array = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        assertThat(median.medianSlidingWindow(array, 0)).isEmpty();
        assertThat(median.medianSlidingWindow(array, 1)).contains(1, 3, -1, -3, 5, 3, 6, 7);
        assertThat(median.medianSlidingWindow(array, 2)).contains(2, 1, -2, 1, 4, 4.5, 6.5);
        assertThat(median.medianSlidingWindow(array, 3)).contains(1, -1, -1, 3, 5, 6);
        assertThat(median.medianSlidingWindow(array, 4)).contains(0, 1, 1, 4, 5.5);
        assertThat(median.medianSlidingWindow(array, 5)).contains(1, 3, 3, 5);
        assertThat(median.medianSlidingWindow(array, 6)).contains(4, 3, 4);
        assertThat(median.medianSlidingWindow(array, 7)).contains(3, 3);
        assertThat(median.medianSlidingWindow(array, 8)).contains(3);
        assertThat(median.medianSlidingWindow(array, 9)).isEmpty();
    }

    @Test
    void reorderArray() {
        int[] array = new int[]{1, 3, 3, 5, 8, 11};

        median.reorderArray(array, 3, 2);
        assertThat(array).contains(1, 2, 3, 5, 8, 11);

        median.reorderArray(array, 3, 8);
        assertThat(array).contains(1, 2, 5, 8, 8, 11);

        median.reorderArray(array, 2, 3);
        assertThat(array).contains(1, 3, 5, 8, 8, 11);
    }

}