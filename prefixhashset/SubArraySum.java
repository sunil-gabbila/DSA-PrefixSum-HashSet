package com.kodnest.prefixhashset;

import java.util.HashSet;
import java.util.Scanner;

public class SubArraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i = 0; i <  n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		
		System.out.println(subarraySumEqualsTarget(n, arr, k));
		sc.close();
	}
	
	public static String subarraySumEqualsTarget(int n,  int [] arr, int k) {
		HashSet<Integer> visited = new HashSet<>();
		
		int pref = 0;
		for(int i : arr) {
			pref += i;
			int need = pref - k;
			if(visited.contains(need))
				return "YES";
			visited.add(pref);
		}
		
		return "NO";
	}

}
