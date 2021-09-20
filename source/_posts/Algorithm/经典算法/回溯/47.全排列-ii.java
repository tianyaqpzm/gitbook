import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(res, new ArrayList<>(), nums, new boolean[nums.length]);
        return res;
    }

    void backTrack(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] use) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (use[i] || (i > 0 && nums[i] == nums[i - 1] && !use[i - 1])) {
                continue;
            }
            use[i] = true;
            tempList.add(nums[i]);
            backTrack(res, tempList, nums, use);
            tempList.remove(tempList.size() - 1);
            use[i] = false;
        }
    }

    // public static void main(String[] args) {
    // Solution1 solution = new Solution1();
    // int[] candidates = new int[] { 1, 2, 2 };
    // solution.permuteUnique(candidates);
    // }
}
// @lc code=end
