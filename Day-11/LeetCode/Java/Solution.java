/**
 * Problem: Element Appearing More Than 25% In Sorted Array
 * Description: Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time, return that integer.
 */
class Solution {
    public int findSpecialInteger(int[] arr) {
        int num = arr[0], count = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == num){
                count++;
            } else {
                num = arr[i];
                count = 1;
            }
            if(count > arr.length/4){
                return num;
            }
        }
        return num;
    }
}