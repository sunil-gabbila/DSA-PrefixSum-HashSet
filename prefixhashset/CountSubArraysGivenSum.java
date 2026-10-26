
package com.kodnest.prefixhashset;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Problem: Count Subarrays With Sum Equal to Target
 *
 * Description:
 * This program counts the total number of contiguous subarrays
 * whose sum is equal to a given target value.
 *
 * Approach:
 * Uses the Prefix Sum technique and HashMap to efficiently
 * count subarrays without checking every possible subarray.
 *
 * Time Complexity: O(n) average case
 * Space Complexity: O(n)
 * Uses one main class to static method in same class.
 */
public class CountSubArraysGivenSum {

    public static void main(String[] args) {

        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Read the size of the array
        int n = sc.nextInt();

        // Declare an array of size n
        int [] arr = new int[n];

        // Read the array elements
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Read the target sum
        int k = sc.nextInt();

        // Call the method and print the total count of valid subarrays
        System.out.println(countSubArraysSumEqualsTarget(n, arr, k));

        // Close the Scanner
        sc.close();
    }

    /**
     * Counts the number of contiguous subarrays whose sum equals target.
     *
     * Logic:
     * 1. Maintain a running prefix sum.
     * 2. Calculate need = pref - target.
     * 3. If need exists in the HashMap, its frequency tells us
     *    how many subarrays ending at the current position have
     *    the required sum.
     * 4. Add that frequency to count.
     * 5. Store the current prefix sum and update its frequency.
     *
     * @param n      Number of elements in the array
     * @param arr    Input array
     * @param target Required subarray sum
     * @return Total number of contiguous subarrays with sum equal to target
     */
    public static int countSubArraysSumEqualsTarget(int n, int [] arr, int target) {

        // Store each prefix sum and the number of times it has occurred
        HashMap<Integer, Integer> map = new HashMap<>();

        // Running sum of array elements
        int pref = 0;

        // Stores the total number of valid subarrays
        int count = 0;

        // An empty prefix sum of 0 occurs once.
        // This handles subarrays that start from index 0.
        map.put(0, 1);

        // Traverse each element in the array
        for(int i : arr) {

            // Update the running prefix sum
            pref += i;

            // Find the previous prefix sum needed to make the
            // current subarray sum equal to the target
            int need = pref - target;

            // If the required prefix sum exists, add its frequency
            // because each occurrence represents a valid subarray
            if(map.containsKey(need)) {
                count += map.get(need);
            }

            // Store the current prefix sum or increase its frequency
            map.put(pref, map.getOrDefault(pref, 0) + 1);
        }

        // Return the total number of valid subarrays
        return count;
    }
}
