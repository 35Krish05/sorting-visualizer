package com.example.sortingvisualizer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.example.sortingvisualizer.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/sort")
@CrossOrigin(origins = "*")
public class SortingController {

    @Autowired
    private SortingService sortingService;
    
    @GetMapping("/test")
    public String testApi() {
        return "Server is running successfully!";
    }
    
    

    @PostMapping("/{type}")
    public List<List<Integer>> sortArray(@PathVariable String type, @RequestBody List<Integer> numbers) {
        switch (type.toLowerCase()) {
            case "bubble":
                return sortingService.bubbleSortSteps(numbers);
            case "selection":
                return sortingService.selectionSortSteps(numbers);
            case "insertion":
                return sortingService.insertionSortSteps(numbers);
            default:
                throw new IllegalArgumentException("Invalid sorting type");
        }
    }

   
}
