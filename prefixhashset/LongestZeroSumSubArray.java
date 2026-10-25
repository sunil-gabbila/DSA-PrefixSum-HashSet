
package com.kodnest.prefixhashset;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Problem: Find the Longest Zero Sum Subarray
 *
 * Description:
 * This program finds the length of the longest contiguous subarray
 * whose sum is equal to zero.
 *
 * Approach:
 * Uses the Prefix Sum technique and HashMap to store each prefix
 * sum with its earliest index. When the same prefix sum appears
 * again, the elements between those indices form a zero-sum subarray.
 *
 * Time Complexity: O(n) average case
 * Space Complexity: O(n)
 */
public class LongestZeroSumSubArray {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Read the size of the array
        int n = sc.nextInt();

        // Create an integer array of size n
        int [] arr = new int[n];

        // Read the array elements
        for(int i = 0; i <  n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call the method and print the length of the longest zero-sum subarray
        System.out.println(checkingLongestSubArraySumEqualsZero(n, arr));

        // Close the Scanner
        sc.close();
    }

    /**
     * Finds the length of the longest contiguous subarray whose sum is zero.
     *
     * Logic:
     * 1. Initialize the prefix sum and maximum length to zero.
     * 2. Store prefix sum 0 at index -1 to handle subarrays
     *    that start from index 0.
     * 3. Traverse the array and calculate the running prefix sum.
     * 4. Check whether the current prefix sum already exists in the HashMap.
     * 5. If it exists, calculate the subarray length using the current
     *    index and the earliest index of that prefix sum.
     * 6. Update the maximum length if a longer zero-sum subarray is found.
     * 7. If the prefix sum has not been encountered before, store its index.
     *    Keeping the earliest index helps maximize the subarray length.
     *
     * @param n   Number of elements in the array
     * @param arr Input integer array
     * @return Length of the longest contiguous subarray with sum zero
     */
    public static int checkingLongestSubArraySumEqualsZero(int n, int [] arr) {

        // Store each prefix sum and its earliest occurrence index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Running prefix sum
        int pref = 0;

        // Stores the maximum length of a zero-sum subarray
        int maxLength = 0;

        // Store prefix sum 0 at index -1.
        // This allows zero-sum subarrays starting at index 0 to be counted.
        map.put(0, -1);

        // Traverse the array using indices
        for(int i = 0; i < n;  i++) {

            // Update the running prefix sum
            pref += arr[i];

            // Calculate the required prefix sum for a zero-sum subarray
            int need = pref - 0;

            // If the prefix sum already exists, the elements between
            // its earliest index and the current index have sum zero
            if(map.containsKey(need)) {

                // Calculate the length of the current zero-sum subarray
                int curLength = i - map.get(need);

                // Update the maximum length if the current subarray is longer
                maxLength = Math.max(maxLength, curLength);
            }

            // Store the prefix sum only if it has not appeared before.
            // This preserves the earliest index to obtain the longest subarray.
            if(!map.containsKey(pref)) {
                map.put(pref,i);
            }
        }

        // Return the length of the longest zero-sum subarray
        return maxLength;
    }

}
