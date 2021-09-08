public class Longestsubarraycontainsonly1s_625 {
    //Given an array of integers that contains only 0s and 1s and a positive integer k, you can flip at most k 0s to 1s,
    //return the longest subarray that contains only integer 1 after flipping.

    //Assumptions:
    //1. Length of given array is between [1, 20000].
    //2. The given array only contains 1s and 0s.
    //3. 0 <= k <= length of given array.

    //Example 1:
    //Input: array = [1,1,0,0,1,1,1,0,0,0], k = 2
    //Output: 7
    //Explanation: flip 0s at index 2 and 3, then the array becomes [1,1,1,1,1,1,1,0,0,0], so that the length of longest
    //subarray that contains only integer 1 is 7.

    //Example 2:
    //Input: array = [1,1,0,0,1,1,1,0,0,0], k = 0
    //Output: 3
    //Explanation: k is 0 so you can not flip any 0 to 1, then the length of longest subarray that contains only integer 1 is 3.

    public int longestConsecutiveOnes(int[] arrays, int k) {
        if (arrays == null || arrays.length == 0) {
           return 0;
        }
        int globalMax = 0;
        int count = 0; //count k
        int slow = 0;
        int fast = 0;
        while (fast < arrays.length) {
            if (arrays[fast] == 1) {
                globalMax = Math.max(globalMax, ++fast - slow);
            } else if (count < k) {
                count++;
                globalMax = Math.max(globalMax, ++fast - slow);
            } else if (arrays[slow++] == 0){
                count--;
            }
        }
        return globalMax;
    }
}
