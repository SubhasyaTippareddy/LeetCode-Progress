// 1239. Maximum Length of a Concatenated String with Unique Characters - WORK

// You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.

// Return the maximum possible length of s.

// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

// Example 1:

// Input: arr = ["un","iq","ue"]
// Output: 4
// Explanation: All the valid concatenations are:
// - ""
// - "un"
// - "iq"
// - "ue"
// - "uniq" ("un" + "iq")
// - "ique" ("iq" + "ue")
// Maximum length is 4.
// Example 2:

// Input: arr = ["cha","r","act","ers"]
// Output: 6
// Explanation: Possible longest valid concatenations are "chaers" ("cha" + "ers") and "acters" ("act" + "ers").
// Example 3:

// Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
// Output: 26
// Explanation: The only string in arr has all 26 characters.
 

// Constraints:

// 1 <= arr.length <= 16
// 1 <= arr[i].length <= 26
// arr[i] contains only lowercase English letters.

// Solution -

class Solution {
    public int res = 0;
    public int maxLength(List<String> arr) {

        backtrack(arr,"",0);
        return res;
    }

    public void backtrack(List<String> arr, String curr, int index){
        if(isUnique(curr)){
            if(res<curr.length()) res = curr.length();
        }
        else{
            return;
        }
        if(index == arr.size()) return;
        for(int i = index;i<arr.size();i++){
            backtrack(arr, curr+arr.get(i),i+1);
        }
    }

    public boolean isUnique(String curr){
        int[] arr = new int[26];
        for(char ch:curr.toCharArray()){
            arr[ch-'a']++;
            if(arr[ch-'a']>1) return false;
        }
        return true;
    }
}