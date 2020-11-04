package com.example.leetCode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class InsertIntervalTest {

    private static InsertInterval insertInterval;

    @BeforeAll
    static void setup() {
        insertInterval = new InsertInterval();
    }

    @Test
    void test1() {
        int[][] ans = insertInterval.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {12, 16}}, new int[]{10, 11});
        assertThat(ans[0], is(new int[]{1, 2}));
        assertThat(ans[1], is(new int[]{3, 5}));
        assertThat(ans[2], is(new int[]{6, 7}));
        assertThat(ans[3], is(new int[]{10, 11}));
        assertThat(ans[4], is(new int[]{12, 16}));
    }

    @Test
    void test2() {
        int[][] ans = insertInterval.insert(new int[][]{{1, 2}}, new int[]{10, 11});
        assertThat(ans[0], is(new int[]{1, 2}));
        assertThat(ans[1], is(new int[]{10, 11}));
    }

    @Test
    void test3() {
        int[][] ans = insertInterval.insert(new int[][]{}, new int[]{10, 11});
        assertThat(ans[0], is(new int[]{10, 11}));
    }

    @Test
    void test4() {
        int[][] ans = insertInterval.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        assertThat(ans[0], is(new int[]{1, 5}));
        assertThat(ans[1], is(new int[]{6, 9}));
    }

    @Test
    void test5() {
        int[][] ans = insertInterval.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        assertThat(ans[0], is(new int[]{1, 2}));
        assertThat(ans[1], is(new int[]{3, 10}));
        assertThat(ans[2], is(new int[]{12, 16}));
    }
}