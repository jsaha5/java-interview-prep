package twopointer;

import org.jp.leetcode.twopointer.FindTwoNumsThatAddUpTotheTarget;
import org.junit.jupiter.api.Test;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class TwoPointerTest {
    private final FindTwoNumsThatAddUpTotheTarget instance = new FindTwoNumsThatAddUpTotheTarget();

    @Test
    void testTwoSumFound() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        Optional<int[]> result = instance.twoSumSorted(numbers, target);

        assertTrue(result.isPresent());
        assertArrayEquals(new int[]{0, 1}, result.get());
    }

    @Test
    void testTwoSumNotFound() {
        int[] numbers = {1, 2, 3};
        int target = 10;
        Optional<int[]> result = instance.twoSumSorted(numbers, target);

        assertFalse(result.isPresent());
    }

    @Test
    void testTwoSumNegativeNumbers() {
        int[] numbers = {-3, 4, 3, 90};
        int target = 0;
        Optional<int[]> result = instance.twoSumSorted(numbers, target);

        assertTrue(result.isPresent());
        assertArrayEquals(new int[]{0, 2}, result.get());
    }

    @Test
    void testTwoSumWithDuplicates() {
        int[] numbers = {3, 3};
        int target = 6;
        Optional<int[]> result = instance.twoSumSorted(numbers, target);

        assertTrue(result.isPresent());
        assertArrayEquals(new int[]{0, 1}, result.get());
    }

    @Test
    void testTwoSumSingleElement() {
        int[] numbers = {5};
        int target = 5;
        Optional<int[]> result = instance.twoSumSorted(numbers, target);

        assertFalse(result.isPresent());
    }

    @Test
    void testTwoSumEmptyArray() {
        int[] numbers = {};
        int target = 5;
        Optional<int[]> result = instance.twoSumSorted(numbers, target);

        assertFalse(result.isPresent());
    }
    // unsorted data

    @Test
    void testTwoSumUnsortedData() {
        int[] numbers = {11, 2, 15, 7};
        int target = 9;
        Optional<int[]> result = instance.twoSumUnsorted(numbers, target);

        assertTrue(result.isPresent());
        assertArrayEquals(new int[]{1, 3}, result.get()); // indices for values 2 and 7
    }

    @Test
    void testTwoSumUnsortedDataNegativeNumbers() {
        int[] numbers = {10, -3, 5, 2, -8};
        int target = -6;
        Optional<int[]> result = instance.twoSumUnsorted(numbers, target);

        assertTrue(result.isPresent());
        assertArrayEquals(new int[]{3, 4}, result.get()); // indices for values -3 and -8
    }

    @Test
    void testTwoSumUnsortedDataWithDuplicates() {
        int[] numbers = {4, 3, 5, 4};
        int target = 8;
        Optional<int[]> result = instance.twoSumUnsorted(numbers, target);

        assertTrue(result.isPresent());
        assertArrayEquals(new int[]{0, 3}, result.get()); // indices for duplicate values 4 and 4
    }

    @Test
    void testTwoSumUnsortedDataNotFound() {
        int[] numbers = {6, 8, 12, 14};
        int target = 5;
        Optional<int[]> result = instance.twoSumUnsorted(numbers, target);

        assertFalse(result.isPresent()); // No two numbers sum up to 5
    }
}
