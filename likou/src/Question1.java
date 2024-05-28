package src;

import java.util.HashMap;
import java.util.Map;

/**
 * 力扣第一题 两数之和
 */
public class Question1 {
    public static void main(String[] args) {
        for (int i = 0; i < twoSum(new int[]{1, 2, 3, 45}, 4).length; i++) {
            System.out.println(twoSum(new int[]{1, 2, 3, 45}, 4)[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 1) {
            return null;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }

        return null;
    }
}
