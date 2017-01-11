package com.learning.algorithms.leetcode.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by admin on 2016/4/26.
 */
public class RemoveDuplicatesfromSortedArrayTest {

    private RemoveDuplicatesfromSortedArray testObject;

    int[] nums = new int[] {1, 1, 2, 2, 3, 4, 7, 7, 15};
    int result = 6;

    @Before
    public void SetUp() {
        testObject = new RemoveDuplicatesfromSortedArray().new RemoveDuplicatesfromSortedArray0();
    }

    @Test
    public void testremoveDuplicates() {
        Assert.assertEquals(result, testObject.removeDuplicates(nums));
    }
}
