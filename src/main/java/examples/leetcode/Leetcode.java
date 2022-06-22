package examples.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode {
    public static void main(String[] args) {
        int n = -3;
        String  result = "_";
        ListNode x5 = new ListNode(5);
        ListNode x4 = new ListNode(4, x5);
        ListNode x3 = new ListNode(3, x4);
        ListNode x2 = new ListNode(2, x3);
        ListNode x1 = new ListNode(1, x2);

        return;
        //        rotate(new int[]{4,1,2,1,2}, 3);
    }


// 1. Two Sum (Easy)
// 2. Add Two Numbers (Medium)
// 3. Longest Substring Without Repeating Characters (Medium)
// 11. Container With Most Water (Medium)
// 15. 3Sum (Medium)
// 19. Remove Nth Node From End of List (Medium)
// 21. Merge Two Sorted Lists (Easy)
// 29. Divide Two Integers (Medium)
// 33. Search in Rotated Sorted Array (Medium)
// 34. Find First and Last Position of Element in Sorted Array (Medium)
// 35. Search Insert Position (Easy)
// 46. Permutations (Medium)
// 67. Add Binary (Easy)
// 70. Climbing Stairs (Easy)
// 74. Search a 2D Matrix (Medium)
//* 77. Combinations (Medium)
// 82. Remove Duplicates from Sorted List II (Medium)
// 88. Merge Sorted Array (Easy)
// 116. Populating Next Right Pointers in Each Node (Medium)
// 120. Triangle (Medium)
// 136. Single Number (Easy)
// 153. Find Minimum in Rotated Sorted Array (Medium)
// 154. Find Minimum in Rotated Sorted Array II (Hard)
// 162. Find Peak Element (Medium)
// 167. Two Sum II - Input Array Is Sorted (Medium)
// 189. Rotate Array (Medium)
// 190. Reverse Bits (Easy)
// 191. Number of 1 Bits (Easy)
// 198. House Robber (Medium)
// 206. Reverse Linked List (Easy)
// 209. Minimum Size Subarray Sum (Medium)
// 231. Power of Two (Easy)
// 278. First Bad Version (Easy)
// 283. Move Zeroes (Easy)
// 344. Reverse String (Easy)
// 438. Find All Anagrams in a String (Medium)
// 542. 01 Matrix (Medium)
// 557. Reverse Words in a String III (Easy)
// 567. Permutation in String (Medium)
// 617. Merge Two Binary Trees (Easy)
// 653. Two Sum IV - Input is a BST (Easy)
// 695. Max Area of Island (Medium)
// 704. Binary Search (Easy)
// 705. Design HashSet (Easy)
// 707. Design Linked List (Medium)
// 733. Flood Fill (Easy)
// 784. Letter Case Permutation (Medium)
// 844. Backspace String Compare (Easy)
// 876. Middle of the Linked List (Easy)
// 994. Rotting Oranges (Medium)
// 977. Squares of a Sorted Array (Easy)
// 986. Interval List Intersections (Medium)


// 1. Two Sum (Easy)
/*      Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        You can return the answer in any order.*/
    public int[] lc_1_TwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] result = null;

        int i = 0;
        do {
            int dif = target - nums[i];
            if (map.containsKey(dif)) {
                result = new int[]{map.get(dif), i};
            }
            else {
                map.put(nums[i], i);
            }
            i++;

        }
        while (result == null && i <= nums.length - 1);

        return result;
    }

// 2. Add Two Numbers (Medium)
/*      You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
        and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
        You may assume the two numbers do not contain any leading zero, except the number 0 itself.*/
    public ListNode lc_2_addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode firstNode = null;
        ListNode privNode = null;
        int last = 0;
        do {
            int s1 = (l1 != null) ? l1.val : 0;
            int s2 = (l2 != null) ? l2.val : 0;
            int sum = last + s1 + s2;
            if (sum > 9) {
                last = 1;
                sum -= 10;
            }
            else {
                last = 0;
            }

            ListNode listNode = new ListNode(sum);
            if (firstNode == null) {
                firstNode = listNode;
            }
            else {
                privNode.next = listNode;
            }
            privNode = listNode;

            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;

        }
        while (l1 != null || l2 != null);

        if (last > 0) {
            ListNode listNode = new ListNode(last);
            privNode.next = listNode;
        }

        return firstNode;
    }

// 3. Longest Substring Without Repeating Characters (Medium)
/*      Given a string s, find the length of the longest substring without repeating characters. */
    public int lengthOfLongestSubstring(String s) {
    if (s.length() < 2) return s.length();

    int result = -1;
    int i = 0;
    int j = 0;
    int[] set = new int[128];

    do {
        if (set[s.charAt(j)] == 1){
            set[s.charAt(i)] = 0;
            i++;
        }
        else{
            set[s.charAt(j)] = 1;
            result = Math.max(result, j + 1 - i);
            j++;
        }
    }
    while (j < s.length());

    return result;
}
    public int lengthOfLongestSubstring1(String s) {
        if (s.length() < 2) return s.length();

        int result = -1;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();

        do {
            if (set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            else{
                set.add(s.charAt(j));
                result = Math.max(result, set.size());
                j++;
            }
        }
        while (j < s.length());

        return result;
    }


// 11. Container With Most Water (Medium)
/*      You are given an integer array height of length n.
        There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
        Find two lines that together with the x-axis form a container, such that the container contains the most water.
        Return the maximum amount of water a container can store.*/
    public int lc_11_maxArea(int[] height) {
        int result = 0;
        int l1 = 0;
        int l2 = height.length - 1;

        while (l1 < l2) {
            result = Math.max(result, Math.min(height[l1], height[l2]) * (l2 - l1));

            if (height[l1] > height[l2]) {
                l2--;
            }
            else {
                l1++;
            }
        }

        return result;
    }

// 15. 3Sum (Medium)
/*    Given an integer array nums, return all the triplets
      [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
      Notice that the solution set must not contain duplicate triplets.*/
    public List<List<Integer>> lc_15_threeSum(int[] nums) {
        if (nums.length < 3) return Collections.emptyList();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                lc_15_threeSum_twoSum(result, i + 1, nums, nums[i]);
            }
        }

        return result;
    }
    public void lc_15_threeSum_twoSum(List<List<Integer>> result, int start, int[] numbers, int target) {
        int l1 = start;
        int l2 = numbers.length - 1;

        int lastV = -10_001;
        do {
            int delta = target + numbers[l1] + numbers[l2];
            if (delta == 0) {
                if (lastV != numbers[l1]) {
                    result.add(Arrays.asList(target, numbers[l1], numbers[l2]));
                    lastV = numbers[l1];
                }
                l1++;
                l2--;
            }
            else {
                if (delta < 0) {
                    l1++;
                }
                else {
                    l2--;
                }
            }
        }
        while (l1 < l2);
    }

// 19. Remove Nth Node From End of List (Medium)
/*      Given the head of a linked list, remove the nth node from the end of the list and return its head.*/
    public ListNode le_19_removeNthFromEnd_v1(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode pr = null;
        ListNode x1 = head;
        ListNode x2 = head;

        int i = 1;
        while (x2.next != null) {
            x2 = x2.next;
            if (i >= n){
                pr = x1;
                x1 = x1.next;
            }
            else{
                i++;
            }
        }
        if (pr == null){
            return x1.next;
        }
        else{
            pr.next = x1.next;
            return head;
        }
    }
    public ListNode le_19_removeNthFromEnd(ListNode head, int n) {
        ListNode x1 = head;

        int i = 1;
        while (i <= n) {
            x1 = x1.next;
            i++;
        }
        if (x1 == null) {
            return head.next;
        }

        ListNode x2 = head;
        while (x1.next != null) {
            x1 = x1.next;
            x2 = x2.next;

        }
        x2.next = x2.next.next;
        return head;
    }

// 21. Merge Two Sorted Lists (Easy)
/*      You are given the heads of two sorted linked lists list1 and list2.
        Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
        Return the head of the merged linked list.*/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode startNode = null;
        ListNode node = null;

        do{
            ListNode tmpNode;
            if (list2 == null || (list1 != null && list1.val < list2.val)) {
                tmpNode = list1;
                list1 = list1.next;
            }
            else{
                tmpNode = list2;
                list2 = list2.next;
            }

            if (startNode == null){
                startNode = tmpNode;
                node =  tmpNode;
            }
            else{
                node.next = tmpNode;
                node = tmpNode;
            }
        }
        while (list1 != null || list2 != null);

        return startNode;
    }

// 29. Divide Two Integers (Medium)
/*    Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
      The integer division should truncate toward zero, which means losing its fractional part.
      For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
      Return the quotient after dividing dividend by divisor.
      Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed
      integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1,
      and if the quotient is strictly less than -231, then return -231.*/
    public int le_29_divideTwoIntegers(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;

        boolean negative = (divisor < 0);
        if (dividend < 0) negative = !negative;

        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);

        int result = 0;
        if (divisor == -1) {
            result = -dividend;
        }
        else if (divisor == dividend) {
            result = 1;
        }
        else if (divisor == 0 || divisor < dividend) {
            result = 0;
        }
        else {
            result = le_29_divideRecursively(dividend, divisor);
        }

        return (negative) ? -result : result;
    }
    public int le_29_divideRecursively(int dividend, int divisor) {
        if (divisor < dividend || dividend == 0) return 0;

        int result = 1;
        int sum = divisor;
        while (sum + sum < sum && sum + sum >= dividend) {
            sum += sum;
            result += result;
        }

        return result + le_29_divideRecursively(dividend - sum, divisor);
    }

// 33. Search in Rotated Sorted Array (Medium)
/*    There is an integer array nums sorted in ascending order (with distinct values).
      Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
      such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
      For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
      Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
      or -1 if it is not in nums.
      You must write an algorithm with O(log n) runtime complexity.*/
    public int le_33_search(int[] nums, int target) {
        int result = -1;
        int l1 = 0;
        int l2 = nums.length - 1;

        do {
            int mid = (l1 + l2) / 2;
            int midVal = nums[mid];

            if (midVal == target) {
                result = mid;
            }
            else {
                int l1Val = nums[l1];
                int l2Val = nums[l2];

                if (l1Val < l2Val) {
                    if (target > midVal) {
                        l1 = mid + 1;
                    }
                    else {
                        l2 = mid - 1;
                    }
                }
                else {
                    if ((l1Val <= target && target < midVal)
                            || (midVal < l2Val && (target < midVal || target > l2Val))) {
                        l2 = mid - 1;
                    }
                    else {
                        l1 = mid + 1;
                    }
                }
            }
        }
        while (result == -1 && l1 <= l2);

        return result;
    }

// 34. Find First and Last Position of Element in Sorted Array (Medium)
/*    Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
      If target is not found in the array, return [-1, -1].
      You must write an algorithm with O(log n) runtime complexity.*/
    public int[] le_34_searchRange(int[] nums, int target) {
        int mid = le_34_getIndex(nums, target);
        if (mid > -1) {
            int l1 = le_34_getBorder(nums, target, 0, mid, true);
            int l2 = le_34_getBorder(nums, target, mid, nums.length - 1, false);
            return new int[]{l1, l2};
        }
        else {
            return new int[]{-1, -1};
        }
    }
    public int le_34_getIndex(int[] nums, int target) {
        int result = -1;
        int l1 = 0;
        int l2 = nums.length - 1;
        while (l1 <= l2 && result == -1) {
            int mid = (l1 + l2) / 2;
            if (nums[mid] == target) {
                result = mid;
            }
            else if (nums[mid] > target) {
                l2 = mid - 1;

            }
            else {
                l1 = mid + 1;
            }

        }
        return result;
    }
    public int le_34_getBorder(int[] nums, int target, int l1, int l2, boolean dir) {
        int result = -1;
        if (nums[l1] == nums[l2]) {
            return (dir) ? l1 : l2;
        }

        do {
            int mid = (l1 + l2) / 2;
            dir = nums[l1] == target;
            if ((l1 + 1 == l2) || (mid == l2)) {
                result = (nums[mid] == target) ? mid
                        : (dir) ? l1 : l2;
            }
            else if (nums[mid] == target) {
                l1 = (!dir) ? l1 : mid;
                l2 = (!dir) ? mid : l2;
            }
            else {
                l1 = (dir) ? l1 : mid;
                l2 = (dir) ? mid : l2;
            }
        }
        while (l1 <= l2 && result == -1);

        return result;

    }

// 35. Search Insert Position (Easy)
/*    Given a sorted array of distinct integers and a target value, return the index if the target is found.
      If not, return the index where it would be if it were inserted in order.
      You must write an algorithm with O(log n) runtime complexity.*/
    public int le_35_searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int l1 = 0;
        int l2 = nums.length - 1;

    //        int result = -1;
        do {
            int mid = (l1 + l2) / 2;
            if (nums[mid] == target){
                return mid;
    //                l1 = mid;
            }
            else if (nums[mid] < target) {
                l1 = mid + 1;
            }
            else{
                l2 = mid - 1;
            }
        }
        while ( l1 <= l2 ); // result == -1 &&

        return l1;
    }

// 46. Permutations (Medium)
/*      Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order. */
    public List<List<Integer>> le_46_permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        le_46_permute(nums, result, new ArrayList<>());
        return result;
    }
    public void le_46_permute(int[] nums, List<List<Integer>> result, List<Integer> tmp) {
        if (tmp.size() == nums.length){
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (!tmp.contains(nums[i])){
                tmp.add(nums[i]);
                le_46_permute(nums, result, tmp);
                tmp.remove(tmp.size()-1);
            }
        }

    }

// 67. Add Binary (Easy)
/*      Given two binary strings a and b, return their sum as a binary string.*/
    public String le_67_addBinary(String a, String b) {
        byte[] aa = a.getBytes();
        byte[] bb = b.getBytes();

        int len = Math.max(a.length(), b.length());
        byte[] result = new byte[len];

        int add = 0;
        int sa = len - a.length();
        int sb = len - b.length();

        for (int i = len-1; i >=0; i--){
            int va = (i-sa >= 0)? aa[i-sa] - 48: 0;
            int vb = (i-sb >= 0)? bb[i-sb] - 48: 0;

            int v = add + va + vb;
            add = (v > 1)? 1 : 0;
            result[i] = (byte)((v % 2 == 1)? 49: 48);
        }

        String resStr = new String(result);
        if (add == 1) resStr = "1"+ resStr;
        return resStr;
    }

// 70. Climbing Stairs (Easy)
/*      You are climbing a staircase. It takes n steps to reach the top.
        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?*/
    public int le_70_climbStairs(int n) {
        if (n < 3) return n;

        int[] dp = new int[n];
        dp[0]=1;
        dp[1]=2;

        for(int i = 2; i < n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
    public int le_70_v2_climbStairs(int n) {
        if (n == 1) return 1;

        return le_70_v2_climbStairs(n, 0, new int[n]);
    }
    private int le_70_v2_climbStairs(int n, int result, int[] arr) {
        if (result >= n)  return (result == n) ? 1 : 0;
        if (arr[result] > 0) return arr[result];

        int val = le_70_v2_climbStairs(n, result + 1, arr) + le_70_v2_climbStairs(n, result + 2, arr);
        arr[result] = val;
        return val;
    }


// 74. Search a 2D Matrix (Medium)
/*      Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
      This matrix has the following properties:
       Integers in each row are sorted from left to right.
       The first integer of each row is greater than the last integer of the previous row.*/
    public boolean le_74_searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        int l1 = 0;
        int l2 = matrix.length - 1;
        int i = 0;

        int mid = 0;
        do {
            mid = (l2 + l1) / 2;

            if (matrix[mid][0] == target) {
                result = true;
            }
            else {
                if (matrix[mid][0] > target) {
                    l2 = mid - 1;
                }
                else {
                    l1 = mid + 1;
                    i = mid;
                }
            }
        }
        while (!result && l2 >= l1);

        l1 = 0;
        l2 = matrix[0].length - 1;

        if (!result && matrix[i][l2] >= target) {
            do {
                mid = (l2 + l1) / 2;

                if (matrix[i][mid] == target) {
                    result = true;
                }
                else {
                    if (target < matrix[i][mid]) {
                        l2 = mid - 1;
                    }
                    else {
                        l1 = mid + 1;
                    }
                }
            }
            while (!result && l1 <= l2);
        }

        return result;
    }

//* 77. Combinations (Medium)
/*      Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
        You may return the answer in any order.*/
    public List<List<Integer>> le_77_combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        le_77_combine(n, k, result, new ArrayList<>(), 0);
        return result;
    }
    public void le_77_combine(int n, int k, List<List<Integer>> result, List<Integer> temp, int start){

        if (temp.size() == k){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start+1; i <= n; i++){
            temp.add(i);
            le_77_combine(n, k, result, temp, i);
            temp.remove(temp.size() - 1);
        }
    }

    // 82. Remove Duplicates from Sorted List II (Medium)
/*      Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only
      distinct numbers from the original list. Return the linked list sorted as well.*/
    public ListNode le_82_deleteDuplicates(ListNode head) {
        ListNode start = null;
        ListNode cur = head;
        ListNode lastNotDouble = null;

        int lastDoubleVal = -101;
        while (cur != null) {
            if (cur.val != lastDoubleVal && (cur.next == null || cur.val != cur.next.val)) {
                if (start == null) start = cur;
                if (lastNotDouble != null) lastNotDouble.next = cur;
                lastNotDouble = cur;
            }
            else {
                if (lastNotDouble != null && lastNotDouble.next != null) {
                    lastNotDouble.next = null;
                }
            }

            lastDoubleVal = cur.val;
            cur = cur.next;
        }

        return start;
    }

// 88. Merge Sorted Array (Easy)
/*    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
      representing the number of elements in nums1 and nums2 respectively.
      Merge nums1 and nums2 into a single array sorted in non-decreasing order.
      The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
      To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
      and the last n elements are set to 0 and should be ignored. nums2 has a length of n.*/
    public void le_88_merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            }
            else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

// 116. Populating Next Right Pointers in Each Node (Medium)
/*      You are given a perfect binary tree where all leaves are on the same level, and every parent has two children
        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
        Initially, all next pointers are set to NULL.*/
    public Node le_116_connect(Node root) {
        if (root == null) return null;

        le_116_setNext(root, root.left);
        le_116_setNext(root, root.right);
        le_116_connect(root.left);
        le_116_connect(root.right);

        return root;
    }
    private void le_116_setNext(Node parent, Node node){
        if (node != null && parent != null){
            if (parent.right != null && parent.right != node){
                node.next = parent.right;
            }
            else if (parent.next != null){
                node.next = parent.next.left;
            }
        }
    }

// 120. Triangle (Medium)
/*  Given a triangle array, return the minimum path sum from top to bottom.
    For each step, you may move to an adjacent number of the row below.
    More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.*/
    public int le_120_minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int[] rez = new int[ triangle.size()+1];

        for (int i = triangle.size() - 1; i >= 0 ; i-- ){
            for (int j = 0; j < triangle.get(i).size(); j++ ){
                rez[j] = triangle.get(i).get(j) + Math.min(rez[j], rez[j + 1]);
            }
        }
        return rez[0];
    }

// 136. Single Number (Easy)
/*  Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    You must implement a solution with a linear runtime complexity and use only constant extra space.*/
    public int le_136_singleNumber(int[] nums) {
// XORing 2 same numbers results in zero (and n ^ 0 = n), so res will be equal to the single number
        int ans = nums[0];
        for(int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

// 153. Find Minimum in Rotated Sorted Array (Medium)
/*    Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
      For example, the array nums = [0,1,2,4,5,6,7] might become:
          [4,5,6,7,0,1,2] if it was rotated 4 times.
          [0,1,2,4,5,6,7] if it was rotated 7 times.
      Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
      Given the sorted rotated array nums of unique elements, return the minimum element of this array.
      You must write an algorithm that runs in O(log n) time.*/
    public int le_153_findMin(int[] nums) {
        Integer result = null;
        int l1 = 0;
        int l2 = nums.length - 1;

        do {
            if (nums[l1] <= nums[l2]) {
                result = nums[l1];
            }
            else if (l1 + 1 == l2) {
                result = nums[l2];
            }
            else {
                int mid = (l1 + l2) / 2;
                if (nums[l1] < nums[mid]) {
                    l1 = mid;
                }
                else {
                    l2 = mid;
                }
            }
        }
        while (result == null && l1 <= l2);

        return result;
    }

// 154. Find Minimum in Rotated Sorted Array II (Hard)
/*    Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example,
      the array nums = [0,1,4,4,5,6,7] might become:
          [4,5,6,7,0,1,4] if it was rotated 4 times.
          [0,1,4,4,5,6,7] if it was rotated 7 times.
      Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
      Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
      You must decrease the overall operation steps as much as possible.*/
    public int le_154_findMin2(int[] nums) {
        int l1 = 0;
        int l2 = nums.length - 1;

        while (l1 < l2) {
            if (nums[l1] < nums[l2]) {
                l2 = l1;
            }
            else if (l1 + 1 == l2) {
                l1 = l2;
            }
            else {
                int mid = (l1 + l2) / 2;
                if (nums[mid] > nums[l2]) {
                    l1 = mid;
                }
                else {
                    l2 = (nums[mid] == nums[l2]) ? l2 - 1 : mid;
                }
            }
        }
        return nums[l1];
    }

// 162. Find Peak Element (Medium)
/*  A peak element is an element that is strictly greater than its neighbors.
    Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
    You may imagine that nums[-1] = nums[n] = -∞.
    You must write an algorithm that runs in O(log n) time.*/
    public int le_162_findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        int l1 = 0;
        int l2 = nums.length - 1;
        while (l1 < l2) {
            int mid = (l1 + l2) / 2;

            if (nums[mid] < nums[mid + 1]) {
                l1 = mid + 1;
            }
            else {
                l2 = mid;
            }
        }
        return l1;
    }

// 167. Two Sum II - Input Array Is Sorted (Medium)
/*  Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
    find two numbers such that they add up to a specific target number.
    Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
    Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
    The tests are generated such that there is exactly one solution. You may not use the same element twice. */
public int[] lc_167_TwoSumII_InputArrayIsSorted(int[] numbers, int target) {
        int[] result = null;

        int l1 = 0;
        int l2 = numbers.length - 1;

        do {
            int delta = target - numbers[l1] - numbers[l2];
            if (delta == 0) {
                result = new int[]{l1 + 1, l2 + 1};
            }
            else {
                if (delta > 0) {
                    l1++;
                }
                else {
                    l2--;
                }
            }

        }
        while (result == null && l1 < l2);

        return result;
    }

// 189. Rotate Array (Medium)
/*      Given an array, rotate the array to the right by k steps, where k is non-negative.*/
    public void lc_189_rotate_v1(int[] nums, int k) {
        if (nums.length < 2) return;
        k = k % nums.length;
        if (k == 0) return;

        int[] arr = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < nums.length; i++){
            int j = i - k;
            if (j < 0){
                j = nums.length + j;
            }
            nums[i] = arr[j];
        }
    }
    public void lc_189_rotate_v2(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
    public void lc_189_rotate_v2(int[] nums, int k) {
        int n = nums.length;
        if(k > n)
            k %= n;

        lc_189_rotate_v2(nums, 0, n - 1);
        lc_189_rotate_v2(nums, 0, k - 1);
        lc_189_rotate_v2(nums, k, n - 1);
    }

// 190. Reverse Bits (Easy)
/*      Reverse bits of a given 32 bits unsigned integer.
        Note:
            Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given
            as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same,
            whether it is signed or unsigned.
            In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2
            above, the input represents the signed integer -3 and the output represents the signed integer -1073741825. */
    public int lc_190_reverseBits(int n) {
        int result = 0;
        for (int i=31; i >=0; i--){
            result += (n & 1) * (1 << i);
            n = n >> 1;
        }
        return result;
    }

// 191. Number of 1 Bits (Easy)
/*    Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
      Note:
        Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given
        as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same,
        whether it is signed or unsigned.
        In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3,
        the input represents the signed integer. -3.*/
    public int lc_191_hammingWeight(int n) {
        int result = 0;
        do{
            result = result + (n & 1);
            n = n >>> 1;
        }
        while (n != 0);
        return result;
    }

// 198. House Robber (Medium)
/*  You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
    the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected
    and it will automatically contact the police if two adjacent houses were broken into on the same night.
    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can
    rob tonight without alerting the police.*/
    public int lc_198_rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);

        lc_198_rob(nums, 0, 0, arr);
        lc_198_rob(nums, 1, 0, arr);

        return Math.max(arr[nums.length-1], arr[nums.length-2]);
    }
    public void lc_198_rob(int[] nums, int pos, int result, int[] arr) {
        if (pos > nums.length - 1) return;

        result = result + nums[pos];
        if (result <= arr[pos]) return;
        arr[pos] = result;

        if (pos < nums.length - 2) lc_198_rob(nums, pos + 2, result, arr);
        if (pos < nums.length - 3) lc_198_rob(nums, pos + 3, result, arr);
    }

// 206. Reverse Linked List (Easy)
/*  Given the head of a singly linked list, reverse the list, and return the reversed list.*/
    public ListNode lc_206_reverseList(ListNode head) {
        if (head == null) return null;
        ListNode priv = null;
        ListNode node = head;

        do {
            ListNode next = node.next;
            node.next = priv;
            priv = node;
            node = next ;
        }
        while (node != null);

        return priv;
    }

// 209. Minimum Size Subarray Sum (Medium)
/*    Given an array of positive integers nums and a positive integer target, return the minimal length of
      a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
      If there is no such subarray, return 0 instead.*/
    public int lc_209_minSubArrayLen(int k, int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int sum = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= k) {
                min = Math.min(min, i - j + 1);

                sum -= nums[j++];
            }
        }
        return (min == Integer.MAX_VALUE) ? 0 : min;
    }

// 231. Power of Two (Easy)
/*      Given an integer n, return true if it is a power of two. Otherwise, return false.
        An integer n is a power of two, if there exists an integer x such that n == 2^x.*/
    public boolean lc_231_isPowerOfTwo1(int n) {
        if (n <= 0) return false;

        int result = 0;
        do{
            result = result + (n & 1);
            n = n >> 1;
        }
        while (n != 0 && result < 2);
        return (result < 2);
    }
    public boolean lc_231_isPowerOfTwo(int n) {
        if (n < 1) return false;
        return (n & -n) == n;
    }


// 278. First Bad Version (Easy)
/*    You are a product manager and currently leading a team to develop a new product. Unfortunately,
      the latest version of your product fails the quality check. Since each version is developed based on the previous version,
      all the versions after a bad version are also bad.
      Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
      You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version.
      You should minimize the number of calls to the API.*/
    public int le_278_firstBadVersion(int n) {
        int l1 = 0;
        int l2 = n;

        do {
            int mid = l1 + (l2 - l1) / 2;
            if (le_278_isBadVersion(mid)){
                l2 = mid - 1;
            }
            else{
                l1 = mid + 1;
            }
        }
        while (l1 <= l2);
        return l1;
    }
    private boolean le_278_isBadVersion(int mid){return true;}

// 283. Move Zeroes (Easy)
/*      Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
        Note that you must do this in-place without making a copy of the array. */
    public void le_283_moveZeroes(int[] nums) {
        if (nums.length < 2) return;

        int notNull = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                if (i != notNull){
                    nums[notNull] = nums[i];
                    nums[i] = 0;
                }
                notNull++;
            }
        }
    }

// 344. Reverse String (Easy)
/*      Write a function that reverses a string. The input string is given as an array of characters s.
        You must do this by modifying the input array in-place with O(1) extra memory.*/
    public void le_344_reverseString(char[] s) {
        if (s.length < 2) return;

        int i = 0;
        int j = s.length - 1;
        do {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }
        while (i < j);
    }

// 438. Find All Anagrams in a String (Medium);
/*    Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
      An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
      typically using all the original letters exactly once.
      Constraints:
          1 <= s.length, p.length <= 3 * 104
          s and p consist of lowercase English letters.*/
    public List<Integer> lc_438_findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }

// 542. 01 Matrix (Medium)
/*      Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
        The distance between two adjacent cells is 1.*/
    public int[][] lc_542_updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                result[i][j] = rows + cols;
            }
        }

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (mat[i][j] == 0){
                    result[i][j] = 0;
                }
                else {
                    if (i > 0) result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                    if (j > 0) result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                }
            }
        }

        for (int i = rows - 1; i >= 0; i--){
            for (int j = cols - 1; j >= 0; j--){
                if (mat[i][j] == 0){
                    result[i][j] = 0;
                }
                else {
                    if (i < rows - 1) result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                    if (j < cols - 1) result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                }
            }
        }

        return result;
    }

// 557. Reverse Words in a String III (Easy)
/*      Given a string s, reverse the order of characters in each word within a sentence
        while still preserving whitespace and initial word order. */
    public String lc_557_reverseWords(String s) {
        if (s.length() < 2) return s;

        StringBuilder result = new StringBuilder();
        int i = 1;
        int j = 0;
        do {
            if (s.charAt(i) == ' '){
                result.append(lc_557_revereStr(s.substring(j, i))).append(" ");
                i++;
                j = i;
            }
            i++;
        }
        while(i < s.length());

        if (i != j){
            result.append(lc_557_revereStr(s.substring(j, i)));
        }

        return result.toString();
    }
    private String lc_557_revereStr(String s){
        if (s.length() < 2) return s;

        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0 ; i--){
            result.append(s.charAt(i));
        }
        return result.toString();
    }

// 567. Permutation in String (Medium)
/*      Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
        In other words, return true if one of s1's permutations is the substring of s2.*/
    public boolean lc_checkInclusion(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() > s2.length()) return false;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i=0; i < s1.length(); i++){
            arr1[s1.charAt(i) - 'a'] ++;
            arr2[s2.charAt(i) - 'a'] ++;
        }

        for (int i=0; i < s2.length() - s1.length(); i++){
            if (lc_567_mach(arr1, arr2)) return true;
            arr2[s2.charAt(i) - 'a']--;
            arr2[s2.charAt(i + s1.length()) - 'a']++;
        }

        return lc_567_mach(arr1, arr2);
    }
    private boolean lc_567_mach(int[] arr1, int[] arr2){
        for (int i=0; i < 26; i++){
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

// 617. Merge Two Binary Trees (Easy)
/*  You are given two binary trees root1 and root2.
    Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
    You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
    Otherwise, the NOT null node will be used as the node of the new tree.
    Return the merged tree.
    Note: The merging process must start from the root nodes of both trees.*/
    public TreeNode lc_617_mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root1.val += root2.val;
        root1.right = lc_617_mergeTrees(root1.right, root2.right);
        root1.left = lc_617_mergeTrees(root1.left, root2.left);
        return root1;
    }

// 653. Two Sum IV - Input is a BST (Easy)
/*    Given the root of a Binary Search Tree and a target number k, return true if there exist two elements in the BST
      such that their sum is equal to the given target.*/
    public boolean lc_653_findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return lc_653_check(root, set, k);
    }
    public boolean lc_653_check(TreeNode root, HashSet set, int k) {
        if(root == null ) return false;
        if(set.contains(k-root.val)) return true;
        set.add(root.val);
        return lc_653_check(root.left, set, k) || lc_653_check(root.right, set, k);
    }

// 695. Max Area of Island (Medium)
/*    You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally
      (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
      The area of an island is the number of cells with a value 1 in the island.
      Return the maximum area of an island in grid. If there is no island, return 0.*/
    public int lc_695_maxAreaOfIsland(int[][] grid) {
        int result = 0;
        for (int i=0; i < grid.length; i++){
            for (int j=0; j < grid[i].length; j++){
                if (grid[i][j] == 1){
                    result = Math.max(result, lc_695_getIslandArea(grid, i, j));
                }
            }
        }
        return result;
    }
    private int lc_695_getIslandArea(int[][] grid, int i, int j){
        grid[i][j] = -1;
        int result = 1;

        if (i-1 >= 0 && grid[i-1][j] == 1){
            result += lc_695_getIslandArea(grid, i-1, j);
        }
        if (j-1 >= 0 && grid[i][j-1] == 1){
            result += lc_695_getIslandArea(grid, i, j-1);
        }
        if (i+1 < grid.length && grid[i+1][j] == 1){
            result += lc_695_getIslandArea(grid, i+1, j);
        }
        if (j+1 < grid[i].length && grid[i][j+1] == 1){
            result += lc_695_getIslandArea(grid, i, j+1);
        }


        return result;
    }

// 704. Binary Search (Easy)
/*    Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
      If target exists, then return its index. Otherwise, return -1.
      You must write an algorithm with O(log n) runtime complexity.*/
    public int lc_704_search(int[] nums, int target) {
        int result = -1;
        int l1 = 0;
        int l2 = nums.length - 1;

        do {
            int mid = (l1 + l2) / 2;
            if (nums[mid] == target){
                result = mid;
            }
            else if (nums[mid] > target){
                l2 = mid - 1;

            }
            else {
                l1 = mid + 1;
            }

        }
        while (l1 <= l2 && result == -1);

        return result;
    }

// 733. Flood Fill (Easy)
/*      An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
    You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
    To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color
    as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
    Replace the color of all of the aforementioned pixels with color.
    Return the modified image after performing the flood fill.*/
    public int[][] lc_733_floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        return (color == oldColor)
                ? image
                : lc_733_floodFill(image, sr, sc, color, oldColor);
    }
    private int[][] lc_733_floodFill(int[][] image, int sr, int sc, int color, int oldColor) {
        if (image[sr][sc] == oldColor){
            image[sr][sc] = color;
            if (sr > 0) lc_733_floodFill(image, sr-1, sc, color, oldColor);
            if (sc > 0) lc_733_floodFill(image, sr, sc-1, color, oldColor);
            if (sr < image.length - 1) lc_733_floodFill(image, sr + 1, sc, color, oldColor);
            if (sc < image[sr].length - 1) lc_733_floodFill(image, sr, sc + 1, color, oldColor);
        }
        return image;
    }

// 705. Design HashSet (Easy)
/*    Design a HashSet without using any built-in hash table libraries.
      Implement MyHashSet class:
          void add(key) Inserts the value key into the HashSet.
          bool contains(key) Returns whether the value key exists in the HashSet or not.
          void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.*/
    public Lc_705_MyHashSet lc_705_MyHashSet;

// 707. Design Linked List (Medium)
    public Lc_707_MyLinkedList lc_707_MyLinkedList;

// 784. Letter Case Permutation (Medium)
/*      Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
        Return a list of all possible strings we could create. Return the output in any order.*/
    public List<String> Lc_784_letterCasePermutation(String s) {
        //   a: "97", A: "65", 0: 48, 1: "49"
        List<String> result = new ArrayList<>();
        Lc_784_letterCasePermutation(s.toLowerCase().toCharArray(), "", result, 0);
        return result;
    }
    public void Lc_784_letterCasePermutation(char[] arr, String s, List<String> result, int pos) {
        if (pos == arr.length){
            result.add(s);
            return;
        }

        Lc_784_letterCasePermutation(arr, s.concat(Character.toString(arr[pos])), result, pos+1);
        if (arr[pos] > 64){
            Lc_784_letterCasePermutation(arr, s.concat(Character.toString((char)(arr[pos] - 32))), result, pos+1);
        }
    }


// 844. Backspace String Compare (Easy)
/*      Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
        Note that after backspacing an empty text, the text will continue empty.*/
    public boolean lc_844_backspaceCompare(String s, String t) {
        byte[] sb = s.getBytes();
        byte[] tb = t.getBytes();

        int i_sb = sb.length;
        int i_tb = tb.length;

        boolean result = true;
        do {
            i_sb = lc_844_getNext(sb, i_sb - 1);
            i_tb = lc_844_getNext(tb, i_tb - 1);
            result = ((i_sb == -1)?-1:sb[i_sb]) == ((i_tb == -1)?-1:tb[i_tb]);
        }
        while (result && (i_sb > 0 || i_tb > 0));

        return result;
    }
    private int lc_844_getNext(byte[] b, int indexFromEnd){
        if (0 > indexFromEnd) return -1;

        int result = -1;
        int skips = 0;
        do {
            if (b[indexFromEnd] != 35){
                if (skips > 0){
                    skips --;
                    indexFromEnd = indexFromEnd - 1;
                }
                else {
                    result = indexFromEnd;
                }
            }
            else{
                indexFromEnd = indexFromEnd - 1;
                skips++;
            }
        }
        while (indexFromEnd >= 0 && result == -1);
        return result;
    }

// 876. Middle of the Linked List (Easy)
/*      Given the head of a singly linked list, return the middle node of the linked list.
        If there are two middle nodes, return the second middle node.   */
    public ListNode lc_876_middleNode(ListNode head) {
        if (head.next == null) return head;

        ListNode x1 = head.next;
        ListNode x2 = head.next.next;

        while(x2 != null && x2.next != null) {
            x1 = x1.next;
            x2 = x2.next.next;
        }
        return x1;
    }

// 994. Rotting Oranges (Medium)
/*  You are given an m x n grid where each cell can have one of three values:
            0 representing an empty cell,
            1 representing a fresh orange, or
            2 representing a rotten orange.
    Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
    Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.*/
    public int orangesRotting(int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 2){
                    lc_944_rotting(grid, i, j, 2);
                }
            }
        }

        int result = 2;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == 1) return -1;
                result = Math.max(grid[i][j], result);
            }
        }
        return result-2;
    }
    public void lc_944_rotting(int[][] grid, int i, int j, int time) {
        if (grid[i][j] == 1 || grid[i][j] >= time){
            grid[i][j] = time;
            if (i > 0)                  lc_944_rotting(grid, i-1, j, time+1);
            if (j > 0)                  lc_944_rotting(grid, i, j-1, time+1);
            if (i < grid.length -1)     lc_944_rotting(grid, i+1, j, time+1);
            if (j < grid[0].length - 1) lc_944_rotting(grid, i, j+1, time+1);
        }
    }

    // 977. Squares of a Sorted Array (Easy)
/*    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order. */
    public int[] lc_977_sortedSquares(int[] nums) {
        int i = 0;
        int[] arr = new int[nums.length];
        while (i < nums.length && nums[i] < 0){
            arr[i] = nums[i] * nums[i];
            i++;
        }

        int j = i;
        i--;
        int k = 0;
        while (i >= 0 && j < nums.length){
            int sq = nums[j] * nums[j];
            if (sq > arr[i]){
                nums[k] = arr[i];
                i--;
                k++;
            }
            else{
                nums[k] = sq;
                j++;
                k++;
            }
        }
        while (j < nums.length){
            nums[k] = nums[j] * nums[j];
            j++;
            k++;
        }
        while (i >= 0){
            nums[k] = arr[i];
            i--;
            k++;
        }
        return nums;
    }

// 986. Interval List Intersections  (Medium)
/*    You are given two lists of closed intervals, firstList and secondList,
      where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
      Return the intersection of these two interval lists.
      A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
      The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval.
      For example, the intersection of [1, 3] and [2, 4] is [2, 3].*/
    public int[][] lc_986_intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < firstList.length && j < secondList.length){
            int min = Math.max(firstList[i][0], secondList[j][0]);
            int max = Math.min(firstList[i][1], secondList[j][1]);

            if (min <= max) result.add(new int[]{min, max});

            if (firstList[i][1] == secondList[j][1]){
                i++;
                j++;
            }
            else if (firstList[i][1] > secondList[j][1]){
                j++;
            }
            else{
                i++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

}

class Lc_707_MyLinkedList {
    int listLength = 0;
    Lc_707_Node startNode;

    public Lc_707_MyLinkedList() {

    }

    public int get(int index) {
        int result = -1;
        if (index < listLength){
            return getNodeByIndex(index).value;
        }
        return result;
    }

    public void addAtHead(int val) {
        if (startNode == null){
            startNode = new Lc_707_Node(val);
        }
        else{
            Lc_707_Node node = new Lc_707_Node(val);
            node.next = startNode;
            startNode = node;
        }
        listLength++;

    }

    public void addAtTail(int val) {
        if (listLength == 0){
            startNode = new Lc_707_Node(val);
        }
        else{
            Lc_707_Node node = new Lc_707_Node(val);
            Lc_707_Node lastNode = getNodeByIndex(listLength - 1);
            lastNode.next = node;
        }
        listLength++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0){
            addAtHead(val);
            listLength++;
        }
        else if (index <= listLength){
            Lc_707_Node indexNode = getNodeByIndex(index-1);
            Lc_707_Node node = new Lc_707_Node(val);
            node.next = indexNode.next;
            indexNode.next = node;
            listLength++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0){
            startNode = startNode.next;
            listLength--;
        }
        else if (index < listLength){
            Lc_707_Node previousNode = getNodeByIndex(index - 1);
            Lc_707_Node node = previousNode.next;
            previousNode.next = node.next;
            listLength--;
        }
    }

    private Lc_707_Node getNodeByIndex(int index){
        int i = 0;
        Lc_707_Node node = startNode;
        while (i != index){
            node = node.next;
            i++;
        }
        return node;
    }
}

class Lc_707_Node{
    int value;
    Lc_707_Node next;

    Lc_707_Node(int value){
        this.value = value;
    }
}

class Lc_705_MyHashSet {
    int[] data;

    public Lc_705_MyHashSet() {
        data = new int[1_000_001];
        Arrays.fill(data,-1);
    }

    public void add(int key) {
        data[key] = key;
    }

    public void remove(int key) {
        data[key] = -1;
    }

    public boolean contains(int key) {
        return data[key] != -1;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};