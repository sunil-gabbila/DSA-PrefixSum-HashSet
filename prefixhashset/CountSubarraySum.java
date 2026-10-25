
package com.kodnest.prefixhashset;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Problem: Count Subarrays With Sum Equal to Zero
 *
 * Description:
 * This program counts the total number of contiguous subarrays
 * whose sum is equal to zero.
 *
 * Approach:
 * Uses the Prefix Sum technique and HashMap to track the frequency
 * of previously encountered prefix sums. Whenever a prefix sum
 * repeats, the elements between the corresponding positions have
 * a sum of zero.
 *
 * Time Complexity: O(n) average case
 * Space Complexity: O(n)
 */
public class CountSubarraySum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        // Create a Scanner object to read input from the user
        Scanner sc = new Scanner(System.in);

        // Read the size of the array
        int n = sc.nextInt();

        // Create an array of size n
        int [] arr = new int[n];

        // Read the array elements
        for(int i = 0; i <  n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call the method and print the total number of
        // contiguous subarrays whose sum equals zero
        System.out.println(countSubArraysSumEqualsZero(n, arr));

        // Close the Scanner
        sc.close();
    }

    /**
     * Counts the number of contiguous subarrays whose sum is zero.
     *
     * Logic:
     * 1. Initialize the prefix sum and subarray count to zero.
     * 2. Store prefix sum 0 with frequency 1 to handle subarrays
     *    that start from index 0.
     * 3. Traverse the array and calculate the running prefix sum.
     * 4. Check whether the current prefix sum exists in the HashMap.
     * 5. If it exists, add its frequency to the count because each
     *    previous occurrence represents a zero-sum subarray.
     * 6. Update the frequency of the current prefix sum.
     *
     * @param n   Number of elements in the array
     * @param arr Input integer array
     * @return Total number of contiguous subarrays with sum zero
     */
    public static int countSubArraysSumEqualsZero(int n, int [] arr) {

        // Store each prefix sum and the number of times it occurs
        HashMap<Integer, Integer> map = new HashMap<>();

        // Running prefix sum
        int pref = 0;

        // Stores the total number of zero-sum subarrays
        int count = 0;

        // Initialize prefix sum 0 with frequency 1.
        // This accounts for zero-sum subarrays starting at index 0.
        map.put(0, 1);

        // Traverse each element in the array
        for(int i : arr) {

            // Update the running prefix sum
            pref += i;

            // Calculate the required previous prefix sum.
            // Since the target is zero, need = pref - 0.
            int need = pref - 0;

            // If the prefix sum exists, add its frequency to count.
            // Each occurrence represents a zero-sum subarray
            // ending at the current position.
            if(map.containsKey(need)) {
                count += map.get(need);
            }

            // Store the current prefix sum or increase its frequency
            map.put(pref, map.getOrDefault(pref, 0)+1);
        }

        // Return the total count of zero-sum subarrays
        return count;
    }

}
