/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        Example:

        Given nums = [2, 7, 11, 15], target = 9,

        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].*/

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class One {
    @Test
    public void testImplIn1() {
        int [] input = {-1, 0, 1, 2, -1, -4};
        int [] lists = twoSum(input, 0);

        Assert.assertEquals(2, lists.length);
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0,0};
    }
}
