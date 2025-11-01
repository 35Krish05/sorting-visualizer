package com.example.sortingvisualizer.service;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SortingService {

    // Ye function array ke har step return karega
    public List<List<Integer>> bubbleSortSteps(List<Integer> arr) {
        List<List<Integer>> steps = new ArrayList<>();
        List<Integer> a = new ArrayList<>(arr);

        int n = a.size();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (a.get(j) > a.get(j+1)) {
                    int temp = a.get(j);
                    a.set(j, a.get(j+1));
                    a.set(j+1, temp);
                }
                steps.add(new ArrayList<>(a)); // current step save
            }
        }
        return steps;
    }

    public List<List<Integer>> selectionSortSteps(List<Integer> arr) {
        List<List<Integer>> steps = new ArrayList<>();
        List<Integer> a = new ArrayList<>(arr);
        int n = a.size();
        for (int i = 0; i < n-1; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                if (a.get(j) < a.get(minIdx)) minIdx = j;
            }
            int temp = a.get(minIdx);
            a.set(minIdx, a.get(i));
            a.set(i, temp);
            steps.add(new ArrayList<>(a));
        }
        return steps;
    }

    public List<List<Integer>> insertionSortSteps(List<Integer> arr) {
        List<List<Integer>> steps = new ArrayList<>();
        List<Integer> a = new ArrayList<>(arr);
        int n = a.size();
        for (int i = 1; i < n; i++) {
            int key = a.get(i);
            int j = i - 1;
            while (j >= 0 && a.get(j) > key) {
                a.set(j+1, a.get(j));
                j--;
                steps.add(new ArrayList<>(a));
            }
            a.set(j+1, key);
            steps.add(new ArrayList<>(a));
        }
        return steps;
    }
}
