package ArraysAndStrings;

import java.util.*;

// Merge / Sort two arrays with no duplicates
public class MergeTwoArraysNoDuplicates {
    public static void main(String[] args) {
        int[] a1 = new int[]{4,-1,9,3};       
        int[] a2 = new int[]{7,-7,5,-1,9};   
        Set<Integer> set = new TreeSet<Integer>(); // Alternate: sort both arrays and merge; while merging use > instead of >= to avoid copying duplicates

        for(int i: a1) {
            set.add(i);
        }
        for(int i: a2) {
            set.add(i);
        }

        set.forEach(e -> System.out.println(e));
    }
}

// TC: O(n log n); SC: O(n)