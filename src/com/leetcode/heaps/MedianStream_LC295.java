package com.leetcode.heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianStream_LC295 {

    public static void main(String[] args) {
        int[] arr = { 2, 11, 2, 3, 3, 4, 5, 8, 5, 10};
        int[] ans = MedianFinder(arr);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] MedianFinder(int[] arr) {
        int len = arr.length;
        if(len==0) return new int[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] result = new int[len];

        maxHeap.offer(arr[0]);
        result[0] = arr[0];

        for(int i=1; i<len; i++){
            System.out.println("The top of maxHeap is " + maxHeap.peek());
            if(arr[i]>maxHeap.peek()){
                minHeap.offer(arr[i]);
                System.out.println("The top of minHeap is " + minHeap.peek());
            }
            else{
                maxHeap.offer(arr[i]);
            }

            if(Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                if(maxHeap.size()<minHeap.size()){
                    maxHeap.offer(minHeap.poll());
                } else {
                    minHeap.offer(maxHeap.poll());
                }
            }

            if(maxHeap.size()<minHeap.size()){
                result[i] = minHeap.peek();
                System.out.println("When minHeap size is greater " + Arrays.toString(result));
            } else if(maxHeap.size()>minHeap.size()){
                result[i] = maxHeap.peek();
                System.out.println("When maxHeap size is greater " + Arrays.toString(result));
            } else {
                System.out.println("When size is equal " + maxHeap.peek() + " is from maxHeap " +" ; " + minHeap.peek() + " is from minHeap " );
                result[i] = (int) (((long) maxHeap.peek() + minHeap.peek())/2);
                System.out.println("When minHeap size is equal to maxHeap " + Arrays.toString(result));
            }
        }
        return result;
    }
}
