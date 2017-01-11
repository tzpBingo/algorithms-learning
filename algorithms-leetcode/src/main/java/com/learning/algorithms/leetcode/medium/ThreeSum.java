package com.learning.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 16/5/22.
 * LeetCode 15
 * Question:https://leetcode.com/problems/3sum/
 * 关键题设：must not contain duplicate triplets
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        return null;
    }

    /**
     * 可拆分为two sum问题,然后利用双指针计算two sum
     * 首先排序,然后每次固定一个数,对剩下的数组进行two sum
     * 重点在于去重
     * 1.固定一个数后,只在其右边的部分找另外两个
     * 2.有重复的数跳过
     *
     * 边界问题特别需要注意!
     * 1.若nums长度少于3,要返回引用,不是空,也不是null
     * 2.每次选取固定的数时,重复的跳过
     * 3.在two sum 里跳过重复的数时,确保不要越界
     *
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     */
    public class ThreeSum0 extends ThreeSum {
        @Override
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> all = new ArrayList<List<Integer>>();
            if (nums == null || nums.length < 3) {
                //throw new IllegalArgumentException("at least 3 numbers");
                return all;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }//continue,not i++

                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int twoSum = nums[left] + nums[right];
                    int reTarget = 0 - nums[i];
                    if (twoSum == reTarget) {
                        List<Integer> match = new ArrayList<Integer>(3);
                        match.add(nums[i]);
                        match.add(nums[left]);
                        match.add(nums[right]);
                        all.add(match);

                        left++;
                        right--;

                        //跳过重复的,确保left<right,否则会出现越界,如[0,0,0]
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;

                    } else if (twoSum < reTarget) {
                        left++;
                    } else {
                        right--;
                    }

                }
            }

            return all;
        }
    }
}


/*
参考链接:
http://bangbingsyb.blogspot.com/2014/11/leetcode-3sum.html
http://blog.csdn.net/linhuanmars/article/details/19711651
http://blog.csdn.net/whuwangyi/article/details/14104589
 */