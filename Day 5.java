// 907. Sum of Subarray Minimums

// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

 

// Example 1:

// Input: arr = [3,1,2,4]
// Output: 17
// Explanation: 
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.
// Example 2:

// Input: arr = [11,81,94,43,3]
// Output: 444
 

// Constraints:

// 1 <= arr.length <= 3 * 10^4
// 1 <= arr[i] <= 3 * 10^4


// Solution - 


class Solution {
    public int sumSubarrayMins(int[] arr) {
        long result = 0;
        int[] l = new int[arr.length];
        int[] r = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();

        Arrays.fill(l,-1);
        Arrays.fill(r, arr.length);
        for(int i = 0; i< arr.length;i++){
            while(!stack.isEmpty() && arr[i] <=arr[stack.peek()] ){
                stack.pop();
            }
            if(!stack.isEmpty()){
                l[i] = stack.peek();

            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            stack.pop();
        }

        for(int i = arr.length -1 ; i>=0;i--){
            while(!stack.isEmpty() && arr[i] <arr[stack.peek()] ){
                stack.pop();
            }
            if(!stack.isEmpty()){
                r[i] = stack.peek();

            }
            stack.push(i);
        }

        for(int i = 0;i<arr.length;i++){
            result+=(long)(i-l[i])*(r[i]-i)*(long)arr[i];
            result%=1000000007;
        }
        
        return (int)result;
    }
}