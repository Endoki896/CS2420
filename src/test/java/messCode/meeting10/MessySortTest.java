package messCode.meeting10;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MessySortTest {

    @Test
    void mergeSort() {
        Integer[] nums = new Integer[]{8, 2, 84, 2, 74, 10, 8};
        MessySort.mergeSort(nums, Integer::compare);
        System.out.println(Arrays.toString(nums));
        assert Arrays.equals(nums, new Integer[]{2, 2, 8, 8, 10, 74, 84});
    }
}