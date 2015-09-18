import java.util.*;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
 }

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	
	/*
	 #1 two sum
	 Input: numbers={2, 7, 11, 15}, target=9
	 Output: index1=1, index2=2
	 */
    public int[] twoSum(int[] numbers, int target) {
        
        int[] res = new int[2];
        if(numbers.length == 0){
            return res;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i < numbers.length; ++i){
            int diff = target - numbers[i];
            if(map.containsKey(diff)){
                res[1] = i+1;
                res[0] = map.get(diff)+1;
                return res;
            }else{
                map.put(numbers[i], i);
            }
        }
        
        return res;
    }
    
    /*
     #2 add two number
     Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 Output: 7 -> 0 -> 8
     */ 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry =0;
 
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3=newHead;
 
        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }
 
            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }
 
            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }
 
        if(carry==1) 
            p3.next=new ListNode(1);
 
        return newHead.next;
    }
    
    /*
     #3 Longest Substring Without Repeating Characters
     Given a string, find the length of the longest substring without repeating characters. 
     For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
     */
    public int lengthOfLongestSubstring(String s) {
        
    	return 0;
    }
    
    /*
     #4 Median of Two Sorted Arrays 
     There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
    	return 0;
    }
	
    /*
     #5 Longest Palindromic Substring 
     Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
     */
    public String longestPalindrome(String s) {
        int max = 0;
        int len = s.length();
        boolean[][] p = new boolean[len][len];
        int start = 0, end = 0;
        
        for(int i=0; i < s.length(); ++i){
            for(int j=0; j < i; ++j){
                p[j][i] = ((s.charAt(i) == s.charAt(j)) && (i-j < 2 || p[j+1][i-1]));
                if(p[j][i] && max < (i - j + 1)){
                    max = i - j + 1;
                    start = j;
                    end = i;
                }
            }
            p[i][i] = true;
        }
        
        return s.substring(start, end+1);
    }
    
    /*
     #6 ZigZag Conversion 
     convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
     */
    public String convert(String s, int nRows) {  
        if(s == null || s.length()==0 || nRows <=0)  
            return "";  
        if(nRows == 1)  
            return s;
            
        StringBuilder res = new StringBuilder();  
        int size = 2*nRows-2;  
        for(int i=0;i<nRows;i++){  
            for(int j=i;j<s.length();j+=size){  
                res.append(s.charAt(j));  
                if(i != 0 && i != nRows - 1){//except the first row and the last row
                    int temp = j+size-2*i;
                    if(temp<s.length())
                        res.append(s.charAt(temp));
                }
            }                  
        }  
        return res.toString();  
    }
    
    /*
     #7 Reverse Integer 
     Example1: x = 123, return 321
	 Example2: x = -123, return -321
     */
    public int reverse(int x) {
        int flag = 1;
        if(x < 0){
            flag = -1;
            x = x*-1;
        }
        
        int res = 0;
        while(x > 0){
            int temp = x % 10;
            if(res >  214748364 ){
                return 0;
            }
            res = res * 10 + temp;
            x = x/10;
        }
        return res * flag;
    }
    
    /*
     #8 String to Integer (atoi) 
     Implement atoi to convert a string to an integer.
     */
    public int myAtoi(String str) {
        int flag = 1;
        int ahead = 0;
        double res = 0;
        str = str.trim();
        if(str.length() == 0)
            return 0;
        if(str.charAt(0) == '-'){
            flag = -1;
            ahead++;
        }else if(str.charAt(0) == '+'){
            ahead++;
        }
        for(int i= ahead; i <= str.length()-1; ++i){
            if(res > 2147483647){
                if (flag == -1){
                    return -2147483648;
                }
                return 2147483647;
            }
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                return (int)(res*flag);
            }
            res = res * 10 + (str.charAt(i) - '0');
        }
        
        return (int)(res * flag);
    }
    
    /*
     #9 Palindrome Number
     */
    public boolean isPalindrome(int x) {
        
        String s = String.valueOf(x);
        
        return is_p(s);
    }
    
    public boolean is_p(String s) {
        int i=0, j = s.length()-1;
        while(i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }
    
    /*
     #10 Regular Expression Matching (hard)
     Implement regular expression matching with support for '.' and '*'.
     Some examples:
	isMatch("aa","a") ¡ú false
	isMatch("aa","aa") ¡ú true
	isMatch("aaa","aa") ¡ú false
	isMatch("aa", "a*") ¡ú true
	isMatch("aa", ".*") ¡ú true
	isMatch("ab", ".*") ¡ú true
	isMatch("aab", "c*a*b") ¡ú true
     */
    public boolean isMatch(String s, String p) {
        return true;
    }
    
    /*
     #11 Container With Most Water 
     Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
     Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     */
    public int maxArea(int[] height) {
        if(height == null || height.length < 2)
            return 0;
        
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        
        while(left < right){
            max = Math.max(max, (right-left) * Math.min(height[right], height[left]));
            if(height[left] > height[right])
                right--;
            else
                left++;
        }
        
        return max;
    }
    
    /*
     #12 Integer to Roman 
     Given an integer, convert it to a roman numeral.
	 Input is guaranteed to be within the range from 1 to 3999.
     */
    public String intToRoman(int num) {
        String str = "";  
        String symbol[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};  
        int value[]=    {1000,900,500,400, 100, 90,  50, 40,  10, 9,   5,  4,   1}; 
        for(int i=0;num!=0;++i)
        {
            while(num>=value[i])
            {
                num-=value[i];
                str+=symbol[i];
            }
        }
        return str;
    }
    
    /*
     #13 Roman to Integer
     */
    public int romanToInt(String s) {
    	Map<Character, Integer> romans = new HashMap<Character, Integer>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
        char[] cs = s.toCharArray();
        int num = 0;
        int val;
        for (int i = 0; i < cs.length; i++) {
            val = romans.get(cs[i]);
            if (i == cs.length - 1 || romans.get(cs[i + 1]) <= val) {
                num += val;
            } else {
                num -= val;
            }
        }
        return num;
    }
    
    /*
     #14 Longest Common Prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
     
        int minLen=Integer.MAX_VALUE;
        for(String str: strs){
            if(minLen > str.length())
                minLen = str.length();
        }
        if(minLen == 0) return "";
     
        for(int j=0; j<minLen; j++){
            char prev='0';
            for(int i=0; i<strs.length ;i++){
                if(i==0) {
                    prev = strs[i].charAt(j);
                    continue;
                }
     
                if(strs[i].charAt(j) != prev){
                    return strs[i].substring(0, j);
                }
            }
        }
     
        return strs[0].substring(0,minLen);
    }
    
    /*
     #15 3Sum
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
 
    	if (nums.length < 3)
    		return result;
    		
    	Arrays.sort(nums);
    	
    	for(int i=0; i < nums.length-2; i++){
    	    
    	    if (i == 0 || nums[i] > nums[i - 1]) {
        	    int neg = -1*nums[i];
        	    
        	    int start = i+1;
        	    int end = nums.length-1;
        	    
        	    while(start < end){
        	        if(nums[start]+nums[end] == neg){
        	            ArrayList<Integer> temp = new ArrayList<Integer>();
        	            temp.add(nums[i]);
        	            temp.add(nums[start]);
        	            temp.add(nums[end]);
        	            result.add(temp);
        	            start++;
        	            end--;
        	            while (end < nums.length-1&&start < end && nums[end] == nums[end + 1]){
    						end--;
    					}
     
    					while (start < end && nums[start] == nums[start - 1]){
    						start++;
    					}
    					
        	            
        	        }else if(nums[start]+nums[end] < neg){
        	            start++;
        	        }else{
        	            end--;
        	        }
        	    }
    	    }
    	}
    	
    	return result;
    }
    
    /*
     #16 3 Sum closest
     */
    public int threeSumClosest(int[] nums, int target) {

    	if (nums.length < 3)
    		return 0;
    		
    	Arrays.sort(nums);
    	
    	int closest = 0;
    	int abs = Integer.MAX_VALUE;
    	
    	for(int i=0; i < nums.length-2; i++){
    	    int start = i+1;
    	    int end = nums.length-1;
    	    
    	    while(start < end){
    	        int total = nums[start]+nums[end]+nums[i];
    	        int temp_abs = Math.abs(total - target);
    	        if(temp_abs < abs){
                    closest = total;
                    abs = temp_abs;
    	        }
    	        
    	        if(total - target < 0){
    	            start++;
    	        }else{
    	            end--;
    	        }
    	    }
    	    
    	}
    	
    	return closest;
    }
    
    /*
     #17 Letter Combinations of a Phone Number
     */
    public static String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        
        List<String> lst = new ArrayList<String>();
        
        if(digits == null || digits.length() == 0)
            return lst;
        
        letterCombinationsHelper(digits, 0, "", lst);
        
        return lst;
    }
    
    public void letterCombinationsHelper(String digits, int index, String prefix, List<String> lst){
        if(index == digits.length()){
            lst.add(prefix);
            return;
        }
        
        int m_index = digits.charAt(index) - '0';
        String button = map[m_index];
        for(int i=0; i < button.length(); ++i){
            String prefix_next = prefix + button.charAt(i);
            letterCombinationsHelper(digits, index+1, prefix_next, lst);
        }
    }
    
    /*
     #18 4 Sum
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
 
    	HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
     
    	for (int i = 0; i < num.length; i++) {
    		for (int j = i + 1; j < num.length; j++) {
    			int k = j + 1;
    			int l = num.length - 1;
     
    			while (k < l) {
    				int sum = num[i] + num[j] + num[k] + num[l];
     
    				if (sum > target) {
    					l--;
    				} else if (sum < target) {
    					k++;
    				} else if (sum == target) {
    					ArrayList<Integer> temp = new ArrayList<Integer>();
    					temp.add(num[i]);
    					temp.add(num[j]);
    					temp.add(num[k]);
    					temp.add(num[l]);
     
    					if (!hashSet.contains(temp)) {
    						hashSet.add(temp);
    						result.add(temp);
    					}
     
    					k++;
    					l--;
    				}
    			}
    		}
    	}
     
    	return result;
    }
    
    /*
     #19 Remove Nth Node From End of List
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode beg = head;
        ListNode end = head;
        for (int i = 0; i < n; i++) {
            // the n can be invalid
            if (end == null) {
                return head;
            }
            end = end.next;
        }
        if (end == null) {
            return head.next;
        }
        while (end.next != null) {
            end = end.next;
            beg = beg.next;
        }
        beg.next = beg.next.next;
        return head;
    }
    
    /*
     #20 Valid Parentheses 
     */
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
    	map.put('(', ')');
    	map.put('[', ']');
    	map.put('{', '}');
     
    	Stack<Character> stack = new Stack<Character>();
     
    	for (int i = 0; i < s.length(); i++) {
    		char curr = s.charAt(i);
     
    		if (map.keySet().contains(curr)) {
    			stack.push(curr);
    		} else if (map.values().contains(curr)) {
    			if (!stack.empty() && map.get(stack.peek()) == curr) {
    				stack.pop();
    			} else {
    				return false;
    			}
    		}
    	}
     
    	return stack.empty();
    }
    
	/*
	 #21 Merge Two Sorted Lists 
	 */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
 
        ListNode fakeHead = new ListNode(0);
        ListNode p = fakeHead;
 
        while(p1 != null && p2 != null){
          if(p1.val <= p2.val){
              p.next = p1;
              p1 = p1.next;
          }else{
              p.next = p2;
              p2 = p2.next;
          }
 
          p = p.next;
        }
 
        if(p1 != null)
            p.next = p1;
        if(p2 != null)
            p.next = p2;
 
        return fakeHead.next;
    }
    
    /*
     #22 Generate Parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        String cur = "";
        if(n!=0){
            helper(res, cur, 0, n, 0, 0);
            
        }
        return res;
    }
    
    public void helper(List<String> res, String cur, int deep, int n, int left, int right){
        if(deep == 2*n){
            res.add(cur);
            return;
        }
        
        if(left < n){
            cur += "(";
            helper(res, cur, deep+1, n, left+1, right);
            cur = cur.substring(0, cur.length()-1);
        }
        
        if(right < left){
            cur += ")";
            helper(res, cur, deep+1, n, left, right+1);
            cur = cur.substring(0, cur.length()-1);
        }
    }
    
	
	/*
	 #23 Merge k Sorted Lists
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		return null;
        
    }
	
	/*
	 #24 swap in pairs
	 */
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = head.next;
        ListNode cur = head;
        ListNode post = dummy;
        
        while(pre!=null){
            ListNode temp = pre.next;
            pre.next = cur;
            cur.next = temp;
            post.next = pre;
            post = cur;
            if(post.next == null) break;
            cur = post.next;
            pre = cur.next;
        }
        
        return dummy.next;
    }
    
    /*
     #25 Reverse Nodes in k-Group 
     */
    public ListNode reverseKGroup(ListNode head, int k) {
		return head;
        
    }
    
    /*
     #26 Remove Duplicates from Sorted Array 
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int cur = nums[0];
        int count = 1;
        for(int i=0; i < nums.length; ++i){
            if(nums[i] != cur){
                nums[count++] = nums[i];
                cur = nums[i];
            }
        }
        
        return count;
    }
    
    /*
     #27 Remove Element 
     */
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        
        int count = 0;
        for(int i=0; i < nums.length; ++i){
            if(nums[i] != val){
                nums[count++] = nums[i];
            }
        }
        
        return count;
    }
    
    /*
     #28 Implement strStr()
     */
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length())
            return -1;
        if(needle.length() == 0)
            return 0;
        
        for(int i=0; i < haystack.length(); ++i){
            if(haystack.charAt(i) == needle.charAt(0) && haystack.length() >= i + needle.length()){
                boolean in = true;
                for(int j=0; j < needle.length(); ++j){
                    if(haystack.charAt(i+j) != needle.charAt(j)){
                        in = false;
                        break;
                    }
                }
                
                if(in)
                    return i;
            }
        }
        
        return -1;
    }
    
    /*
     #29 Divide Two Integers
     */
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
        {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = (dividend^divisor)>>>31 == 1;
        int res = 0;
        if(dividend == Integer.MIN_VALUE)
        {
            dividend += Math.abs(divisor);
            if(divisor == -1)
            {
                return Integer.MAX_VALUE;
            }
            res++;
        }
        if(divisor == Integer.MIN_VALUE)
        {
            return res;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int digit = 0;
        while(divisor <= (dividend>>1))
        {
            divisor <<= 1;
            digit++;
        }
        while(digit>=0)
        {
            if(dividend>=divisor)
            {
                res += 1<<digit;
                dividend -= divisor;
            }
            divisor >>= 1;
            digit--;
        }
        return isNeg?-res:res;
    }
    
    /*
     #30 Substring with Concatenation of All Words
     */
    public List<Integer> findSubstring(String s, String[] words) {
		return null;
        
    }
    
    /*
     #31 Next permutation
     */
    public void nextPermutation(int[] num) {
        if(num==null || num.length==0)
            return;
        int i = num.length-2;
        while(i>=0 && num[i]>=num[i+1])
        {
            i--;
        }
        if(i>=0)
        {
            int j=i+1;
            while(j<num.length && num[j]>num[i])
            {
                j++;
            }
            j--;
            int temp = num[i];
            num[i] = num[j];
            num[j] = temp;
        }
        reverse(num, i+1);
    }
    private void reverse(int[] num, int index)
    {
        int l = index;
        int r = num.length-1;
        while(l<r)
        {
            int temp = num[l];
            num[l] = num[r];
            num[r] = temp;
            l++;
            r--;
        }
    }
    
    /*
     #32 Longest Valid Parentheses
     */
    
    /*
     #33 Search in Rotated Sorted Array
     */
    
    /*
     #34 Search for a Range
     */
    //1,2,2,3,4,4,4,5,5,5,6,7,8,9,10,11
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        int start = 0;
        int end = nums.length -1;
        int mid = 0;
        boolean found = false;
        
        if(nums.length == 0) return res;
        
         if(nums.length == 1 && nums[0] == target){
             res[0] = 0;
             res[1] = 0;
             return res;
         }
        
        while(start < end){
            mid = (start+end)/2;
            if(nums[mid] == target){
                found = true;
                break;
            }else if(nums[start] == target){
                mid = start;
                found = true;
                break;
            }else if(nums[end] == target){
                mid = end;
                found = true;
                break;
            }else if(nums[mid] < target){
                start = mid+1;
            }else if(nums[mid] > target) {
                end = mid;
            }
        }
         
        if(found){
            start = mid;
            while(start > 0 && nums[start-1] == target)
                start--;
            
            end = mid;
            while(end < nums.length-1 && nums[end+1] == target)
                end++;
            
            res[0] = start;
            res[1] = end;
            
            return res;
        }else
            return res;
        
    }
    
    /*
     #35 Search Insert Position 
     */
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0) return 0;
        
        if(nums[0] > target) return 0;
        
        if(nums.length == 1 && nums[0] < target) return 1;
        
        if(nums[nums.length-1] < target) return nums.length;
        
        int start = 0;
        int end = nums.length-1;
        int mid = 0;
        
        while(start < end){
            mid = (start+end)/2;
            if(nums[start] == target){
                return start;
            }else if(nums[end] == target){
                return end;
            }else if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target&& nums[mid-1] < target){
                return mid;
            }else if(nums[mid] < target&& nums[mid+1] > target){
                return mid+1;
            }else if(nums[mid] > target){
                end = mid;
            }else if(nums[mid] < target){
                start = mid+1;
            }
        }
        
        return 0;
    }
    
    /*
     #36 Valid Sudoku 
     */
    public boolean isValidSudoku(char[][] board) {
        
        for(int i=0; i<board[0].length; i++){
            HashSet<Character> test = new HashSet<Character>();
            for(int j=0; j<board.length; j++){
                if(board[j][i]!='.' && !test.add(board[j][i])) return false;
            }
        }
        
        // rule2, row
        for(int i=0; i<board.length; i++){
            HashSet<Character> test = new HashSet<Character>();
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]!='.' && !test.add(board[i][j])) return false;
            }
        }   
        
        // rule3, sub-box
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){// for each sub-box
                HashSet<Character> test = new HashSet<Character>();
                for(int m=i*3; m<i*3+3; m++){//row
                    for(int n=j*3; n<j*3+3; n++){//column
                        if(board[m][n]!='.' && !test.add(board[m][n])) return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    /*
     #37 Sudoku Solver 
     */
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9)
            return;
        helper(board, 0, 0);
    }
    
    public boolean helper(char[][] board, int i, int j){
        
        if(j>=9){
            return helper(board, i+1, 0);
        }
        
        if(i == 9)
            return true;
        
        if(board[i][j] == '.'){
            for(int k=1; k <= 9; ++k){
                board[i][j] = (char)('0'+k);
                if(isValid(board, i, j)){
                    if(helper(board, i, j+1))
                        return true;
                }
                board[i][j] = '.';
            }
        }else{
            return helper(board, i, j+1);
        }
        
        return false;
    }
    
    public boolean isValid(char[][] board, int i, int j){
        int n = board[i][j];
        for(int a=0; a < board[i].length; ++a){
            if(a!=j && board[i][a] == n)
                return false;
        }
        
        for(int a=0; a < board.length; ++a){
            if(a!=i && board[a][j] == n)
                return false;
        }
        
        for(int m=i/3*3; m < i/3*3+3; ++m){
            for(int l=j/3*3; l < j/3*3+3; ++l){
                if(m!=i && l!= j && board[m][l] == n)
                    return false;
            }
        }
        
        return true;
    }
    
    
    /*
     #38 Count and Say
     */
    public String countAndSay(int n) {
        if(n<=0)
            return null;
        
        String result = "1";
        int i = 1;
        
        while(i < n){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j=1; j < result.length(); ++j){
                if(result.charAt(j) == result.charAt(j-1)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(result.charAt(j-1));
                    count = 1;
                }
            }
            
            sb.append(count);
            sb.append(result.charAt(result.length()-1));
            result = sb.toString();
            i++;
        }
        
        return result;
    }
    
    
    /*
     #39 Combination Sum
     */
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0) return res;
        
        ArrayList<Integer> cur = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        
        combinationSumhelper(candidates, target, res, cur, 0);
        
        return res;
        
    }
    
    public void combinationSumhelper(int[] candidates, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> current, int pos){
        if(target == 0){
            ArrayList<Integer> cur = new ArrayList<Integer>(current);
            res.add(cur);
            return; 
        }
        
        for(int i=pos; i < candidates.length; ++i){
            if(target < candidates[i])
                return;
            current.add(candidates[i]);
            combinationSumhelper(candidates, target - candidates[i], res, current, i);
            current.remove(current.size()-1);
        }
    }
    
    /*
     #40 Combination Sum 2
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) return res;
        
        List<Integer> cur = new ArrayList<Integer>();
        
        Arrays.sort(candidates);
        
        combinationSum2helper(candidates, target, res, cur, 0);
        
        return res;
        
    }
    
    public void combinationSum2helper(int[] candidates, int target, List<List<Integer>> res, List<Integer> current, int pos){
        if(target == 0 && !res.contains(current)){
            List<Integer> cur = new ArrayList<Integer>(current);
            res.add(cur);
            return; 
        }
        
        for(int i=pos; i < candidates.length; ++i){
            if(target < candidates[i])
                return;
            current.add(candidates[i]);
            combinationSum2helper(candidates, target - candidates[i], res, current, i+1);
            current.remove(current.size()-1);
        }
    }
    
    /*
     #41 First Missing Positive
     */
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;     
        
        Arrays.sort(nums);
        
        for(int i=1; i<nums.length;++i){
            if(Math.abs(nums[i]-nums[i-1]) > 1){
                int t = nums[i-1]+1;
                if(t > 0)
                    return t;
                else
                    return 1;
            }
               
        }
        
        if(nums[0] > 1)
            return nums[0]-1;
        else
            return nums[nums.length-1]+1;
    }
    
    /*
     #42 Trapping Rain Water 
     */
    
    /*
     #43 Multiply Strings
     */
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        // even 99 * 99 is < 10000, so maximaly 4 digits
        int[] d = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                d[i + j] += a * b;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < d.length; i++) {
            int digit = d[i] % 10;
            int carry = d[i] / 10;
            sb.insert(0, digit);
            if (i < d.length - 1)
                d[i + 1] += carry;
        }
        //trim starting zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    } 
    
    /*
     #44 Wildcard Matching
     */
    
    /*
     #45 Jump Game II
     */
    
    /*
     #46 Permutations
     */
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums.length == 0 || nums == null) return res;
        
        List<Integer> current = new ArrayList<Integer>();
        
        boolean[] visited = new boolean[nums.length];
        
        permute_helper(nums, current, res, visited);
        
        return res;
    }
    
    public void permute_helper(int[] nums, List<Integer> cur, List<List<Integer>> res, boolean[] visited ){
        if(cur.size() == nums.length){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        
        for(int i=0; i < nums.length; ++i){
            if(!visited[i]){
                cur.add(nums[i]);
                visited[i] = true;
                permute_helper(nums, cur, res, visited);
                cur.remove(cur.size()-1);
                visited[i] = false;
            }
        }
    }
    
    /*
     #47 Permutation II
     */
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return res;
        Arrays.sort(num);
        permute(num, 0, res);
        return res;
    }
    
    public void permute(int[] num, int pos, List<List<Integer>> res) {
        if (pos == num.length) {
            List<Integer> row = new ArrayList<Integer>();
            for (int a : num) row.add(a);
            res.add(row);
            return;
        }
        for (int i = pos; i < num.length; i++) {
            // skip if we have duplicates of current element before i
            boolean skip = false;
            for (int j = pos; j < i; j++) {
                if (num[j] == num[i]) {
                    skip = true;
                    break;
                }
            }
            if (skip) continue;
            swap(num, pos, i);
            permute(num, pos + 1, res);
            swap(num, pos, i); // reset
        }
    }

    public void swap(int[] num, int i, int j) {
        if (i == j) return;
        num[i] = num[j] - num[i];
        num[j] = num[j] - num[i];
        num[i] = num[j] + num[i];
    }
    
    /*
     #48 Rotate image
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;
        for (int i = 0; i < n / 2 ; i++) {
            for (int j = i; j < n - i - 1 ; j++) {
                int tmp = matrix[i][j]; // save in tmp var
                matrix[i][j] = matrix[n-j-1][i]; // first col
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1]; // last row
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1]; // last col
                matrix[j][n-i-1] = tmp;
            }
        }
    }
    
    
    /*
     #49 Anagrams
     */
    public List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        if (strs == null || strs.length == 0) return res;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i++) { // traverse the array
            /*generate key*/
            char[] word = strs[i].toCharArray(); 
            Arrays.sort(word);
            String key = new String(word);
            if (map.containsKey(key)) {
                res.add(strs[i]); // add this string
                if (map.get(key) >= 0) { // key string not added
                    res.add(strs[map.get(key)]); 
                    map.put(key, -1); // mark already added as -1
                }
            } else map.put(key, i); // first put sorted string and index
        }
        return res;
    }
	
	public List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> ret = new ArrayList<List<String>>();
		Set<String> temp = new HashSet<String>();
		
		if (strs == null || strs.length == 0) return ret;
		
		for (int i=0; i < strs.length; ++i) {
			char [] tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
			temp.add(new String(tmp));
		}
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for (String s : temp) {
			map.put(s, new ArrayList<String>());
		}
		
		for (int i=0; i < strs.length; ++i) {
			char [] tmp = strs[i].toCharArray();
			Arrays.sort(tmp);
			String key = new String(tmp);
			map.get(key).add(strs[i]);
		}
		
		for (String s : map.keySet()) {
			ret.add(map.get(s));
		}
		
        return ret;
    }
	
	
    
    /*
     #50 pow(x,n);
     */
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        
        if (n < 0)
            return 1 / pow_helper(x, n);
        else
            return pow_helper(x, n);

    }
    
    public double pow_helper(double x, int n) {
        if (n == 0) return 1;
        double v = pow_helper(x, n/2);
        if (n%2 == 0) {
            return v*v;
        } else {
            return v*v*x;
        }
    }
    
    /*
     * #51 N-Queen
     */
    
    /*
     * #52 N-Queen II
     */
    
    /*
     #53 Maximum subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int maxSoFar = nums[0];
        int maxAll = nums[0];
        
        for(int i=1; i < nums.length; ++i) {
            maxSoFar = Math.max(maxSoFar+nums[i], nums[i]);
            maxAll = Math.max(maxSoFar, maxAll);
        }
        
        return maxAll;
    }
    
    /*
     #54 spiral matrix
     */
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return res;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int lv = 0;
        
        while (2 * lv < m && 2 * lv < n) { // note 2 * level
            for (int i = lv; i < n - lv; i++) res.add(matrix[lv][i]); // right
            
            for (int i = lv + 1; i < m - lv; i++) res.add(matrix[i][n-lv-1]); // down
            
            if (2 * lv == m - 1 || 2 * lv == n - 1) break; // reach last row/col
            
            for (int i = n - lv - 2; i >= lv; i--) res.add(matrix[m-lv-1][i]);
            
            for (int i = m - lv - 2; i >= lv+1; i--) res.add(matrix[i][lv]);
            
            lv++;
        }
        return res;
    }
    
    /*
     * #55 Jump Game
     */
    public boolean canJump(int[] nums) {
        if(nums.length == 0)
            return false;
        
        if(nums.length == 1)
            return true;
        
        int maxCover = 0;
        
        for(int start=maxCover; start <= maxCover && start < nums.length; ++start) {
            if(nums[start]+start > maxCover) {
                maxCover = nums[start]+start;
            }
            if(maxCover >= nums.length-1)
                return true;
        }
        
        return false;

    }
    
    /*
     * #56 Merge Intervals
     */
	public List<Interval> merge(List<Interval> intervals) {
		 
		if (intervals == null || intervals.size() <= 1)
			return intervals;
 
		// sort intervals by using self-defined Comparator
		Collections.sort(intervals, new IntervalComparator());
 
		List<Interval> result = new ArrayList<Interval>();
 
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
 
			if (prev.end >= curr.start) {
				// merged case
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = curr;
			}
		}
 
		result.add(prev);
 
		return result;
	}
	
	class IntervalComparator implements Comparator<Interval> {
    	public int compare(Interval i1, Interval i2) {
    		return i1.start - i2.start;
    	}
    }
       
       
    /*
     * #57 Insert Interval
     */
  
	/*
	 * #58 Length of Last Word
	 */
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        
        String s1 = s.trim();
        int index = s1.length()-1;
        int count = 0;
        
        for(int i=index; i >= 0; --i){
            if(s.charAt(i) == ' '){
                break;
            } else {
                count++;
            }
        }        
        return count;
    }
    
    /*
     * #59 Spiral Matrix II
     */
    public int[][] generateMatrix(int n) {
        
        int[][] res = new int[n][n];
        int num = 1;
        int x = 0;
        int y = 0;
        
        while(n>0){
            
            if(n == 1) {
                res[x][x] = num;
                break;
            }
 
            //below, process a circle
 
            //top - move right
            for(int i=0;i<n-1;i++){
                res[x][y++] = num++;
            }
 
            //right - move down
            for(int i=0;i<n-1;i++){
                res[x++][y] = num++;
            }
 
            //bottom - move left
            for(int i=0;i<n-1;i++){
                res[x][y--] = num++;
            }
 
            //left - move up
            for(int i=0;i<n-1;i++){
                res[x--][y] = num++;
            }
 
            x++;
            y++;
            n=n-2;
        }
        return res;
    }
    
    /*
     * #60 Permutation Sequence 
     */
	public String getPermutation(int n, int k) {
		 
		// initialize all numbers
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}
 
		// change k to be index
		k--;
 
		// set factorial of n
		int mod = 1;
		for (int i = 1; i <= n; i++) {
			mod = mod * i;
		}
 
		String result = "";
 
		// find sequence
		for (int i = 0; i < n; i++) {
			mod = mod / (n - i);
			// find the right number(curIndex) of
			int curIndex = k / mod;
			// update k
			k = k % mod;
 
			// get number according to curIndex
			result += numberList.get(curIndex);
			// remove from list
			numberList.remove(curIndex);
		}
 
		return result.toString();
	}
    
    /*
     * #61 Rotate List 
     */
    public ListNode rotateRight(ListNode head, int k) {
    	if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        // get length and move fast to the end of list
        int len;
        for (len = 0; fast.next != null; len++) fast = fast.next;
        // get the len-n%len th node
        for (int j = len - k % len; j > 0; j--) slow = slow.next;
        fast.next = dummy.next; 
        dummy.next = slow.next;
        slow.next = null; // break linkedlist
        return dummy.next;
    }
    
    /*
     * #62 Unique Paths
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        
        int[][] d_array = new int[m][n];
        
        for(int i=0; i < m; ++i) {
            d_array[i][0] = 1;
        }
        
        for(int i=0; i < n; ++i) {
            d_array[0][i] = 1;
        }
        
        for(int i=1; i < m; ++i) {
            for(int j=1; j < n; ++j) {
                d_array[i][j] = d_array[i-1][j] + d_array[i][j-1];
            }
        }
        
        return d_array[m-1][n-1];
    }
    
    /*
     * #63 Unique Paths II
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if (m == 0 || n == 0) return 0;
        
        int[][] d_array = new int[m][n];
        
        for(int i=0; i < m; ++i) {
            if(obstacleGrid[i][0] == 1) {
                if (i ==0 ) return 0;
                break;
            }
            d_array[i][0] = 1;
        }
        
        for(int i=0; i < n; ++i) {
            if(obstacleGrid[0][i] == 1) {
                if (i ==0 ) return 0;
                break;
            }
            d_array[0][i] = 1;
        }
        
        for(int i=1; i < m; ++i) {
            for(int j=1; j < n; ++j) {
                if(obstacleGrid[i][j] == 1) {
                    continue;
                }
                
                if (obstacleGrid[i][j-1] == 1 && obstacleGrid[i-1][j] != 1) {
                    d_array[i][j] = d_array[i-1][j];
                    continue;
                }
                
                if (obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] != 1) {
                    d_array[i][j] = d_array[i][j-1];
                    continue;
                }
                
                if (obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] == 1) {
                    continue;
                }
                
                d_array[i][j] = d_array[i-1][j] + d_array[i][j-1];
                
                
            }
        }
        
        return d_array[m-1][n-1];
    }
    
    /*
     * #64 Minimum Path Sum 
     */
    public int minPathSum(int[][] grid) {
        if(grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        
        if (m == 0 || n == 0) return 0;
        
        int[][] d_array = new int[m][n];
        
        d_array[0][0] = grid[0][0];
        
        for(int i=1; i < m; ++i) {
            d_array[i][0] = d_array[i-1][0] + grid[i][0];
        }
        
        for(int i=1; i < n; ++i) {
            d_array[0][i] = d_array[0][i-1] + grid[0][i];
        }
        
        for(int i=1; i < m; ++i) {
            for(int j=1; j < n; ++j) {
                d_array[i][j] = Math.min(d_array[i-1][j], d_array[i][j-1]) + grid[i][j];
            }
        }
        
        return d_array[m-1][n-1];
    }
    
    /*
     * #65 Valid Number 
     */
    
    
    /*
     * #66 plus one
     */
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0)  return digits;

        int carry = 0;
        
        for(int i=digits.length-1; i>=0; --i){
            if(i == digits.length-1){
                carry = digits[i] + 1;
            } else {
                carry = digits[i] + carry;
            }
            if(carry >= 10){
                digits[i] = carry%10;
            }else{
                digits[i] = carry;
            }
            carry /= 10;
        }
        
        if(carry == 1){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for(int i=1; i < res.length; i++){
                res[i] = digits[i-1];
            }
            
            return res;
        }
        
        return digits;
    }
    
    /*
     * #67 Add Binary 
     */
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        
        int a_l = a.length();
        int b_l = b.length();
        
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        
        for(int i=0; i < Math.max(a_l, b_l); ++i) {
            if (i >= b_l) {
                carry += (int)(a.charAt(i) - '0');
            } else if(i >= a_l){
                carry += (int)(b.charAt(i) - '0');
            } else {
                carry += (int)(a.charAt(i) - '0') + (int)(b.charAt(i) - '0');
            }
            
            sb.append((char)(carry%2 + '0'));
            carry = carry/2;
        }
        
        if (carry > 0) {
            sb.append((char)(carry + '0'));
        }
        return sb.reverse().toString();
    }
    
    /*
     * #68 Text Justification
     */
    
    /*
     * #69 Sqrt(x)
     */
    public int mySqrt(int x) {
        if(x<0) return -1;
        if(x==0) return 0;
        int l=1;
        int r=x/2+1;
        while(l<=r)
        {
            int m = (l+r)/2;
            if(m<=x/m && x/(m+1)<m+1)
                return m;
            if(x/m<m) {
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return 0;
    }
    
    /*
     * #70 Climbing Stairs
     */
    
    /*
     * #71 Simplify Path
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
 
        //stack.push(path.substring(0,1));
     
        while(path.length()> 0 && path.charAt(path.length()-1) =='/'){
            path = path.substring(0, path.length()-1);
        }
     
        int start = 0;
        for(int i=1; i<path.length(); i++){
            if(path.charAt(i) == '/'){
                stack.push(path.substring(start, i));
                start = i;
            }else if(i==path.length()-1){
                stack.push(path.substring(start));
            }
        }
     
        LinkedList<String> result = new LinkedList<String>();
        int back = 0;
        while(!stack.isEmpty()){
            String top = stack.pop();
     
            if(top.equals("/.") || top.equals("/")){
                //nothing
            }else if(top.equals("/..")){
                back++;
            }else{
                if(back > 0){
                    back--;
                }else{
                    result.push(top);
                }
            }
        }
     
        //if empty, return "/"
        if(result.isEmpty()){
            return "/";
        }
     
        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()){
            String s = result.pop();
            sb.append(s);
        }
     
        return sb.toString();
    }
    
    /*
     * #72 Edit Distance
     */
    
    /*
     * #73 Set Matrix Zeros
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        
        List<Integer> col = new ArrayList<Integer>();
        List<Integer> row = new ArrayList<Integer>();
        
        for(int i=0; i < matrix.length; ++i) {
            for (int j=0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for(Integer in : row){
            for (int i=0; i < matrix[0].length; ++i) {
                matrix[in][i] = 0;
            }
        }
        
        for(Integer in : col){
            for (int i=0; i < matrix.length; ++i) {
                matrix[i][in] = 0;
            }
        }
        
    }
    
    public void setZeros(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                }
            }
        }

        for (int i = row - 1; i > 0; i--) {
            if (matrix[i][0] == 0) {
                for (int j = col - 1; j > 0; j--) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = col - 1; j > 0; j--) {
            if (matrix[0][j] == 0) {
                for (int k = row - 1; k > 0; k--) {
                    matrix[k][j] = 0;
                }
            }
        }

        if (firstRow) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
    
    /*
     * #74 Search a 2D Matrix
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        
        for (int i=0; i < matrix.length-1; ++i) {
            for (int j=0; j < matrix[0].length; ++j) {
                if (matrix[i+1][j] < target) {
                    break;
                }
                
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        
        for(int i=0; i < matrix[0].length; ++i) {
            if (matrix[matrix.length-1][i] == target) {
                return true;
            }
        }
        return false;
    }
    
    /*
     * #75 Sort Colors 
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int red = 0, green = 0, blue = 0;
        for (int i=0; i < nums.length; ++i) {
            int t = nums[i];
            if (t==0){
                red++;
            } else if (t==1) {
                green++;
            } else {
                blue++;
            }
        }
        
        for (int i=0; i < nums.length; ++i) {
            if (i < red) {
                nums[i] = 0;
            } else if (i < red+green) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
    
    
    /*
     * #76 Minimum Window Substring 
     */
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) 
            return "";
        String result = "";
     
        //character counter for t
        HashMap<Character, Integer> target = new HashMap<Character, Integer>();
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);    
            if(target.containsKey(c)){
                target.put(c,target.get(c)+1);
            }else{
                target.put(c,1);  
            }
        }
     
        // character counter for s
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int left = 0;
        int minLen = s.length()+1;
     
        int count = 0; // the total of mapped characters
     
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
     
            if(target.containsKey(c)){
                if(map.containsKey(c)){
                    if(map.get(c)<target.get(c)){
                        count++;
                    }
                    map.put(c,map.get(c)+1);
                }else{
                    map.put(c,1);
                    count++;
                }
            }
     
            if(count == t.length()){
                char sc = s.charAt(left);
                while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
                    if (map.containsKey(sc) && map.get(sc) > target.get(sc))
                        map.put(sc, map.get(sc) - 1);
                    left++;
                    sc = s.charAt(left);
                }
     
                if (i - left + 1 < minLen) {
                    result = s.substring(left, i + 1);
                    minLen = i - left + 1;
                }
            }
        }
     
        return result;
    }
    
    /*
     * #77 Combination
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n == 0 || k == 0) return res;

        LinkedList<Integer> current = new LinkedList<Integer>();
        combine_helper(res, current, n, k, 0);
        
        return res;
    }
    
    public void combine_helper(List<List<Integer>> res, LinkedList<Integer> cur, int n, int k, int pos) {
        if (cur.size() == k) {
            List<Integer> tmp = new LinkedList<Integer>(cur);
            res.add(tmp);
            return;
        }
        
        for (int i=pos; i < n; ++i) {
            cur.add(i+1);
            combine_helper(res, cur, n, k, i+1);
            cur.removeLast();
        }
    }
    
    /*
     * #78 Subsets
     */
    public List<List<Integer>> subsets(int[] S) {

    	if (S == null)
    		return null;
     
    	Arrays.sort(S);
     
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
     
    	for (int i = 0; i < S.length; i++) {
    		List<List<Integer>> temp = new ArrayList<List<Integer>>();
     
    		//get sets that are already in result
    		for (List<Integer> a : result) {
    			temp.add(new ArrayList<Integer>(a));
    		}
     
    		//add S[i] to existing sets
    		for (List<Integer> a : temp) {
    			a.add(S[i]);
    		}
     
    		//add S[i] only as a set
    		List<Integer> single = new ArrayList<Integer>();
    		single.add(S[i]);
    		temp.add(single);
     
    		result.addAll(temp);
    	}
     
    	//add empty set
    	result.add(new ArrayList<Integer>());
     
    	return result;
    
    }
    
    /*
     * #79 Word Search
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        for (int i=0; i < board.length; ++i) {
            for (int j=0; j < board[0].length; ++j) {
                if (board[i][j] == word.charAt(0)){
                    if (search(word, board, i, j, 1)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public boolean search(String word, char[][] board, int i, int j, int pos) {
        if (pos == word.length()) {
            return true;
        }
        System.out.println(pos);
        for (int m=i-1; m <= i+1; ++m) {
            for (int n=j-1; n <= j+1; ++n) {
            	System.out.println(m + " " +n + " " + i + " " +j);
                if (m >= 0 && n >= 0 && m < board.length && n < board[0].length && m != i && n != j) {
                    if (pos < word.length() && board[m][n] == word.charAt(pos)) {
                    	System.out.println("in");
                        return search(word, board, m, n, pos+1);
                    }
                }
            }
        }
        
        return false;
    }
    
    /*
     * #80 Remove Duplicates from Sorted Array II
     */
    public int removeDuplicates_2(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return nums.length;
        
        int count = 1;
        int local = 0;
        for (int i=1; i < nums.length; ++i) {
            if (nums[i] == nums[i-1]) {
                if (local == 0) {
                    nums[count++] = nums[i];
                    local++;
                } else {
                    local++;
                    continue;
                }
            } else {
                local = 0;
                nums[count++] = nums[i];
            }
        }
        
        return count;
    }
    
    /*
     * #82 	Remove Duplicates from Sorted List II
     */
    public ListNode deleteDuplicates_2(ListNode head) {
        if (head == null) return null;
        
        if (head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = null;
        
        
        int cur_v = head.val;
        int pass_value = 999999;
        
        while (head.next != null) {
            if (head.val == head.next.val) {
                pass_value = head.val;
            }
            
            if (head.val != pass_value) {
                if (cur == null) {
                    cur = new ListNode(head.val);
                    dummy.next = cur;
                    head = head.next;
                    continue;
                }
                cur.next = new ListNode(head.val);
                cur = cur.next;
            }
            head = head.next;
        }
        
        if (head != null && head.val != pass_value) {
            if (cur == null) {
                cur = new ListNode(head.val);
                dummy.next = cur;
            } else {
                cur.next = new ListNode(head.val);
            }
           
        }
        
        return dummy.next;
    }
    
    //better
    public ListNode deleteDuplicates2_b(ListNode head) {
        ListNode t = new ListNode(0);
        t.next = head;
     
        ListNode p = t;
        while(p.next!=null&&p.next.next!=null){
            if(p.next.val == p.next.next.val){
                int dup = p.next.val;
                while(p.next!=null&&p.next.val==dup){
                    p.next = p.next.next;
                }
            }else{
                p=p.next;
            }
     
        }
     
        return t.next;
    }
    
    /*
     * #83 Remove Duplicates from Sorted List
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next; // skip next node
            }
            cur = cur.next; // to next node
        }
        return head;
    }
    
    /*
     * #84 Largest Rectangle in Histogram 
     */
    
    
    /*
     * #85 Maximal Rectangle
     */
    
    /*
     * #86 Partition List
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        
        ListNode fake1 = new ListNode(0);
        ListNode fake2 = new ListNode(0);
        
        ListNode cur = null;
        ListNode cur2 = null;
        fake2.next = cur2;
        fake1.next = cur;
        
        while (head != null) {
            if (head.val < x) {
                if (cur == null) {
                    cur = new ListNode(head.val);
                    fake1.next = cur;
                } else {
                    cur.next = new ListNode(head.val);
                    cur = cur.next;   
                }

            } else {
                if (cur2 == null) {
                    cur2 = new ListNode(head.val);
                    fake2.next = cur2;
                } else {
                    cur2.next = new ListNode(head.val);
                    cur2 = cur2.next;
                }
            }
            head = head.next;
        }
        
        if (cur != null && fake2.next != null) {
            cur.next = fake2.next;
        } else if (cur == null && fake2.next != null) {
            fake1.next = fake2.next;
        }
        
        return fake1.next;
    }
    
    //better in-place
    public ListNode partition_b(ListNode head, int x) {
        if(head == null) return null;
 
        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;
 
        ListNode p = head;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;
 
        while(p != null){
            if(p.val < x){
                p = p.next;
                prev = prev.next;
            }else{
 
                p2.next = p;
                prev.next = p.next;
 
                p = prev.next;
                p2 = p2.next;
            } 
        }
 
        // close the list
        p2.next = null;
 
        prev.next = fakeHead2.next;
 
        return fakeHead1.next;
    }
    
    /*
     * #87 Scramble String
     */
    
    /*
     * #88 Merge Sorted Array
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        int i = m-1;
        int j = n-1;
        
        while (k >= 0) {
            if (j < 0 || (i>=0 && nums1[i] > nums2[j])) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }
    
    /*
     * #89 Gray Code
     */
    public List<Integer> grayCode(int n) {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(0);
        for(int i=0;i<n;i++){
            int inc = 1<<i;
            for(int j=arr.size()-1;j>=0;j--){
                arr.add(arr.get(j)+inc);
            }
        }
        return arr;
    }
    
    /*
     * #90 Subsets II
     */
    public List<List<Integer>> subsetsWithDup(int[] S) {
        if (S == null)
    		return null;
     
    	Arrays.sort(S);
     
    	Set<List<Integer>> result = new HashSet<List<Integer>>();
     
    	for (int i = 0; i < S.length; i++) {
    		List<List<Integer>> temp = new ArrayList<List<Integer>>();
     
    		//get sets that are already in result
    		for (List<Integer> a : result) {
    			temp.add(new ArrayList<Integer>(a));
    		}
     
    		//add S[i] to existing sets
    		for (List<Integer> a : temp) {
    			a.add(S[i]);
    		}
     
    		//add S[i] only as a set
    		List<Integer> single = new ArrayList<Integer>();
    		single.add(S[i]);
    		temp.add(single);
     
    		result.addAll(temp);
    	}
     
    	//add empty set
    	result.add(new ArrayList<Integer>());
    	
    	List<List<Integer>> ret = new ArrayList<List<Integer>>();
    	
    	ret.addAll(result);
     
    	return ret;
    }
    
    /*
     * #91 Decode Ways
     */
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int prev1 = 1;
        int prev2 = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            int code1 = Integer.valueOf(s.substring(i - 1, i)); // 1 digit
            int code2 = Integer.valueOf(s.substring(i - 2, i)); // 2 digits
            int temp = prev2;
            prev2 = (code1 != 0 ? prev2 : 0) + (code2 <= 26 && code2 > 9 ? prev1 : 0);
            prev1 = temp;
        }
        return prev2;
    }
    
    /*
     * #92 Reverse Linked List II
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (m >= n || head == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) pre = pre.next;
        
        ListNode cur = pre.next;
        for (int i = m; i < n; i++) { // insert next to head to reverse
            ListNode temp = cur.next.next;
            cur.next.next = pre.next;
            pre.next = cur.next;
            cur.next = temp;
        }
        return dummy.next;
    }
    
    /*
     * #93 Restore IP Addresses
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        
        if (s == null || s.length() == 0) return res;
        
        restore_helper(res, 0, 1, s, "");
        
        return res;
    }
    
    public void restore_helper(List<String> res, int index, int segment, String s, String item) {
        if (index >= s.length()) 
            return;
        if (segment == 4) {
            String str = s.substring(index);
            if (isValid_restore(str)) {
                res.add(item+"."+str);
            }
            return;
        }
        for(int i=1; i<4&&(i+index<=s.length()); ++i) {
            String str = s.substring(index, index+i);
            if (isValid_restore(str)) {
                if (segment == 1) {
                    restore_helper(res, index+i, segment+1, s, str);
                } else {
                    restore_helper(res, index+i, segment+1, s, item+"."+str);
                }
            }
        }
    }
    
    private boolean isValid_restore(String str)  
    {  
        if(str==null || str.length()>3)  
            return false;  
        int num = Integer.parseInt(str);  
        if(str.charAt(0)=='0' && str.length()>1)  
            return false;  
        if(num>=0 && num<=255)  
            return true;  
        return false;  
    }  
    
    /*
     * #94 Inorder traversal
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        inorderTraversal_helper(res, root);
        
        return res;
    }
    
    public void inorderTraversal_helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        
        if (root.left != null){
            inorderTraversal_helper(res, root.left);
        }
        res.add(root.val);
        if (root.right!= null) {
            inorderTraversal_helper(res, root.right);
        }
    }
    
    //iterative
    public List<Integer> inorderTraversal_itr(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (!s.isEmpty() || root != null) {
            // check whether current node is null
            if (root != null) { // current node is not null
                s.push(root);
                root = root.left;
            } else { // current node is null, pop and go right
                root = s.pop();
                result.add(root.val); // visit()
                root = root.right;
            }
        }
        return result;
    }
    
    /*
     * #95 Unique Binary Search Trees II
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
     
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> list = new LinkedList<>();
     
        if (start > end) {
            list.add(null);
            return list;
        }
     
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }
     
        return list;
    }
    
    /*
     * #96 Unique Binary Search Trees 
     */
    public int numTrees(int n) {
    	int[] count = new int[n + 1];
    	count[0] = 1;
    	count[1] = 1;
     
    	for (int i = 2; i <= n; i++) {
    		for (int j = 0; j <= i - 1; j++) {
    			count[i] = count[i] + count[j] * count[i - j - 1];
    		}
    	}
     
    	return count[n];
    }
    
    /*
     * #97 Interleaving String 
     */
    
    /*
     * #98 Validate Binary Search Tree
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);    
    }
     
    public boolean isValidBST(TreeNode p, double min, double max){
        if(p==null) 
            return true;
     
        if(p.val <= min || p.val >= max)
            return false;
     
        return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
    }
    
    /*
     * #99 Recover Binary Search Tree
     */
    
    /*
     * #100 Same Tree
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;      
        return isSameTree_helper(p, q);
    }
    
    public boolean isSameTree_helper(TreeNode p, TreeNode q) {
        if(p == null){
            return q == null;
        }
        if(q == null){
            return p == null;
        }      
        return (p.val == q.val) && isSameTree_helper(p.left, q.left) && isSameTree_helper(p.right, q.right);
    }
    
    /*
     * #101 Symmetric Tree
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric_helper(root.left, root.right);
    }
    
    public boolean isSymmetric_helper(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) return n1 == n2;
        return n1.val == n2.val && isSymmetric_helper(n1.left, n2.right) && isSymmetric_helper(n1.right, n2.left);
    }
	
    /*
     * #102 Binary Tree Level Order Traversal 
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> cur = new ArrayList<Integer>();
        q.add(root);
        TreeNode rightMost = root;
        TreeNode b = null;
        
        while(!q.isEmpty()){

            TreeNode n = q.remove();
            cur.add(n.val);
            
            if(n == rightMost){
                res.add(cur);
                cur = new ArrayList<Integer>();
                if(n.right != null){
                    rightMost = n.right;
                } else if(n.left != null){
                    rightMost = n.left;
                } else {
                    rightMost = b;
                }
            }
            
            if(n.left != null){;
                q.add(n.left);
                b = n.left;
            }
            
            if(n.right != null){
                q.add(n.right);
                b = n.right;
            }
            
        }
        return res;
    }
    
    /*
     * #103 Binary Tree Zigzag Level Order Traversal
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;
        
        currLevel.push(root);
        boolean normalOrder = true;
        
        while (!currLevel.isEmpty()) {
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();
            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);
                
                if (normalOrder) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }
            result.add(currLevelResult);
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
        }
        
        return result;
    }
    
    /*
     * #104 Maximum Depth of Binary Tree
     */
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        
        return maxDepth_helper(root);
    }
    
    public int maxDepth_helper(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth_helper(root.left), maxDepth_helper(root.right));
    }
    
    /*
     * #105 Construct Binary Tree from Inorder and Preorder Traversal 
     */
    public TreeNode buildTree_pre_in(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length-1;
        int inStart = 0;
        int inEnd = inorder.length-1;
     
        return construct(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }
     
    public TreeNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart>preEnd||inStart>inEnd){
            return null;
        }
     
        int val = preorder[preStart];
        TreeNode p = new TreeNode(val);
     
        //find parent element index from inorder
        int k=0;
        for(int i=0; i<inorder.length; i++){
            if(val == inorder[i]){
                k=i;
                break;
            }
        }
     
        p.left = construct(preorder, preStart+1, preStart+(k-inStart), inorder, inStart, k-1);
        p.right= construct(preorder, preStart+(k-inStart)+1, preEnd, inorder, k+1 , inEnd);
     
        return p;
    }
    
    /*
     * #106 Construct Binary Tree from Inorder and Postorder Traversal 
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	int inStart = 0;
    	int inEnd = inorder.length - 1;
    	int postStart = 0;
    	int postEnd = postorder.length - 1;
     
    	return buildTree(inorder, inStart, inEnd, postorder, postStart, postEnd);
    }
     
    public TreeNode buildTree(int[] inorder, int inStart, int inEnd,
    		int[] postorder, int postStart, int postEnd) {
    	if (inStart > inEnd || postStart > postEnd)
    		return null;
     
    	int rootValue = postorder[postEnd];
    	TreeNode root = new TreeNode(rootValue);
     
    	int k = 0;
    	for (int i = 0; i < inorder.length; i++) {
    		if (inorder[i] == rootValue) {
    			k = i;
    			break;
    		}
    	}
     
    	root.left = buildTree(inorder, inStart, k - 1, postorder, postStart,
    			postStart + k - (inStart + 1));
    	// Becuase k is not the length, it it need to -(inStart+1) to get the length
    	root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k- inStart, postEnd - 1);
    	// postStart+k-inStart = postStart+k-(inStart+1) +1
     
    	return root;
    }
    
    /*
     * #107 Binary Tree Level Order Traversal II
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
       if(root == null) return res;
       
       Queue<TreeNode> q = new LinkedList<TreeNode>();
       List<Integer> cur = new ArrayList<Integer>();
       q.add(root);
       TreeNode rightMost = root;
       TreeNode b = null;
       
       while(!q.isEmpty()){

           TreeNode n = q.remove();
           cur.add(n.val);
           
           if(n == rightMost){
               res.add(cur);
               cur = new ArrayList<Integer>();
               if(n.right != null){
                   rightMost = n.right;
               } else if(n.left != null){
                   rightMost = n.left;
               } else {
                   rightMost = b;
               }
           }
           
           if(n.left != null){;
               q.add(n.left);
               b = n.left;
           }
           
           if(n.right != null){
               q.add(n.right);
               b = n.right;
           }
           
       }
       List<List<Integer>> res2 = new ArrayList<List<Integer>>();
       for(int i=res.size()-1; i >= 0 ; --i){
           res2.add(res.get(i));
       }
       
       return res2;
   }
    
    /*
     * #108 sorted array to BST
     */
    public TreeNode sortedArrayToBST(int[] num) {
		if (num.length == 0)
			return null;
 
		return sortedArrayToBST(num, 0, num.length - 1);
	}
 
	public TreeNode sortedArrayToBST(int[] num, int start, int end) {
		if (start > end)
			return null;
 
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, start, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, end);
 
		return root;
	}
	/*
	 * #109 Convert Sorted List to Binary Search Tree 
	 */
    static ListNode h;
    
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        h = head;
        int len = getLength(head);
        return sortedListToBST(0, len - 1);
        
    }
    
    public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
 
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
	
	public TreeNode sortedListToBST(int start, int end) {
	    if (start > end) return null;
	    
	    int mid = (start + end) / 2;
	    
	    TreeNode left = sortedListToBST(start, mid - 1);
	    TreeNode root = new TreeNode(h.val);
	    h = h.next;
	    TreeNode right = sortedListToBST(mid + 1, end);
	    
	    root.left = left;
	    root.right = right;
	    
	    return root;
	    
	}
    
    /*
     * #110 Balanced Binary Tree
     */
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        if(isBalanced_helper(root) == -1){
            return false;
        }
        
        return true;
        
    }
    
    public int isBalanced_helper(TreeNode root) {
        if(root == null)
            return 0;
        
        int left = isBalanced_helper(root.left);
        int right = isBalanced_helper(root.right);
        
        if(left == -1 || right == -1){
            return -1;
        }
        
        if(Math.abs(left - right) > 1)
            return -1;
            
        return 1 + Math.max(left, right);
        
    }
    
    /*
     * #111 Minimum Depth of Binary Tree
     */
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        return minDepth_helper(root);
    }
    
    public int minDepth_helper(TreeNode root){
        if(root.left == null && root.right == null)
            return 1;
        else if(root.left != null && root.right == null)
            return 1 + minDepth_helper(root.left);
        else if(root.left == null && root.right != null)
            return 1 + minDepth_helper(root.right);
        else
            return 1 + Math.min(minDepth_helper(root.left), minDepth_helper(root.right));
    }
    
    public int minDepth_better(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0) return right + 1;
        if (right == 0) return left + 1;
        return Math.min(left, right) + 1; // plus root
    }
    
    /*
     * #112 Path Sum
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)  return false;
        
        return hasPathSum_helper(root, sum, 0);
    }
    
    public boolean hasPathSum_helper(TreeNode root, int sum, int cur) {
        if(root.left == null && root.right == null){
            cur += root.val;
            return cur == sum;
        } else if(root.left != null && root.right == null){
            cur += root.val;
            return hasPathSum_helper(root.left, sum, cur);
        } else if (root.left == null && root.right != null){
            cur += root.val;
            return hasPathSum_helper(root.right, sum, cur);
        } else {
            cur += root.val;
            return hasPathSum_helper(root.left, sum, cur) || hasPathSum_helper(root.right, sum, cur);
        }
    }
    
    //cleaner code
    public boolean hasPathSum_clean(TreeNode root, int sum) {
    	if (root == null)
    		return false;
    	if (root.val == sum && (root.left == null && root.right == null))
    		return true;
     
    	return hasPathSum_clean(root.left, sum - root.val) || hasPathSum_clean(root.right, sum - root.val);
    }
    
    /*
     * #113 Path Sum II
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        pathSum_helper(root, sum, new ArrayList<Integer>(), res);
        
        return res;
    }
    
    public void pathSum_helper(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) return;
        sum -= root.val;
        cur = new ArrayList<Integer>(cur);
        cur.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            res.add(cur);
            return;
        }
        pathSum_helper(root.left, sum, cur, res);
        pathSum_helper(root.right, sum, cur, res);
    }
    
    /*
     * #114 Flatten Binary Tree to Linked List 
     */
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) { // check left child
                TreeNode n = root.left;
                while (n.right != null) n = n.right; // rightmost child of left
                n.right = root.right; // insert right subtree to its right
                root.right = root.left; // set left subtree as right subtree
                root.left = null; // set left to null
            }
            root = root.right; // move to right child
        }
    }
    
    static class TreeLinkNode{
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
    }
    
    /*
     * #116 Populating Next Right Pointers in Each Node
     */
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode pre = root;
        TreeLinkNode cur = null;
        while (pre.left != null) { // no more level if left child is null
            cur = pre;
            while (cur != null) { // work on next level
                cur.left.next = cur.right; // connect left and right
                // connect right child with next node's left child
                if (cur.next != null) cur.right.next = cur.next.left;
                cur = cur.next; // move current to next node
            }
            pre = pre.left; // move to next line
        }
    }
    
    /*
     * #118 Pascal's Triangle 
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if (numRows <= 0) return triangle;
    
        List<Integer> firstRow = new ArrayList<Integer>();
        firstRow.add(1);
        triangle.add(firstRow);
    
        for (int i = 1; i < numRows; i++) {
            List<Integer> lastRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<Integer>(i + 1);
        
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }
    
    /*
     * #119 Pascal's Triangle II 
     */
    public List<Integer> getRow(int k) {
        List<Integer> row = new ArrayList<Integer>(k + 1);
        row.add(1);
        for (int i = 1; i <= k; i++) { // repeat k times
            for (int j = i - 1; j >= 1; j--) { // do it backwards
                row.set(j, row.get(j - 1) + row.get(j));
            }
            row.add(1); // add 1 at the end
        }
        return row;
    }
    
    /*
     * #120 Triangle 
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int level = triangle.size() - 1;
        List<Integer> res = new ArrayList<Integer>(triangle.get(level));
        
        for (int i = level - 1; i >= 0; i--) { // start from second last row
            for (int j = 0; j <= i; j++) { // go through each node
                int n = Math.min(res.get(j), res.get(j + 1)) + triangle.get(i).get(j); // add the smaller one 
                res.set(j, n);
            }
        }
        return res.get(0);
    }
    
    /*
     * #121 Best Time to Buy and Sell Stock 
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0; // need at least 2
        int max = 0;
        int min = prices[0]; // track the minimum of profit array before cur ele
        for (int i = 1; i < prices.length; i++) { // note that i starts from 1
            min = Math.min(min, prices[i]); // update min
            if (prices[i] > prices[i - 1]) max = Math.max(max, prices[i] - min);
        }
        return max;
    }
    
    /*
     * #122 Best Time to Buy and Sell Stock II 
     */
    public int maxProfit_2(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++)
            if (prices[i + 1] > prices[i]) max += prices[i + 1] - prices[i];
        return max;
    }
    
    /*
     * #125 Valid Palindrome
     */
    public boolean isPalindrome(String s) {
        if(s==null||s.length()==0) return true;
 
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		for(int i = 0; i < s.length() ; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
				return false;
			}
		}
 
		return true;
    }
    
    /*
     * #127 word ladder
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null || dict.isEmpty()) return 0;
        dict.add(end);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(start, 1);
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        while (!q.isEmpty()) {
            String word = q.poll();
            if (word.equals(end)) break;
            for (int i = 0; i < word.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    char[] ch = word.toCharArray();
                    if (ch[i] == j) continue;
                    ch[i] = j;
                    String newWord = new String(ch);
                    if (dict.contains(newWord) && !map.containsKey(newWord)) {
                        map.put(newWord, map.get(word) + 1);
                        q.add(newWord);
                    }
                }
            }
        }
        return map.containsKey(end) ? map.get(end) : 0;
    }
    
    /*
     * #129 Sum Root to Leaf Numbers
     */
    public int sumNumbers(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        return sumNumbers_helper(root, 0);
    }
    
     public int sumNumbers_helper(TreeNode root, int x) {
        if (root.right == null && root.left == null) return 10 * x + root.val;
        
        int val = 0;
        if (root.left != null) val += sumNumbers_helper(root.left, 10 * x + root.val);
        if (root.right != null) val += sumNumbers_helper(root.right, 10 * x + root.val);
        return val;
    }
     
    /*
     * #130 surronded regions
     */
    public void solve(char[][] board) {
         if (board == null || board.length == 0 || board[0].length == 0) return;
         
         Queue<Integer> q = new LinkedList<Integer>();
         int m = board.length;
         int n = board[0].length;
         boolean[][] visited = new boolean[m][n];
         int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
         
         for (int i = 0; i < m; i++) {
             for (int j = 0; j < n; j++) {
                 if (board[i][j] == 'O' && !visited[i][j]) {
                     boolean surround = true;
                     List<Integer> pointsToChange = new ArrayList<Integer>();
                     q.add(i * n + j); // add root
                     visited[i][j] = true; // set root visited
                     while (q.size() > 0) { // BFS
                         int point = q.poll(); // get from queue
                         pointsToChange.add(point);
                         int x = point / n; // get coordinates
                         int y = point % n;
                         // try 4 direction
                         for (int k = 0; k < dir.length; k++) { 
                             int nextX = x + dir[k][0];
                             int nextY = y + dir[k][1];
                             if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) { // within board
                                 if (board[nextX][nextY] == 'O' && !visited[nextX][nextY]) // add to queue
                                     q.add(nextX * n + nextY);
                                 visited[nextX][nextY] = true; // set visited
                             } else surround = false; // false if on the boundry
                         }
                     }
                     if (surround) for (int p : pointsToChange) board[p / n][p % n] = 'X'; // set to 'X'
                 }
             }
         }
    }
    
    /*
     * #133 Clone Graph 
     */
    
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        q.add(node);
        while (!q.isEmpty()) { // BFS
            UndirectedGraphNode cur = q.poll();
            if (!map.containsKey(cur.label)) map.put(cur.label, new UndirectedGraphNode(cur.label)); // put in map to set visited
            if (cur.neighbors != null) {
                for (UndirectedGraphNode n : cur.neighbors) {
                    if (!map.containsKey(n.label)) {
                        q.add(n);
                        map.put(n.label, new UndirectedGraphNode(n.label));
                    }
                    // add to neighbors
                    map.get(cur.label).neighbors.add(map.get(n.label));
                }
            }
        }
        return map.get(node.label);
    }
    
    
    /*
     * #134 Gas Station
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int restGas = 0; // gas remain for current trip
        int previous = 0; // negative gas for previous trips
        int start = 0; // start index of current trip
        for (int i = 0; i < gas.length; i++) {
            restGas += gas[i] - cost[i];
            if (restGas < 0) {
                previous += restGas; // gas needed for previous trips
                restGas = 0; // reset restGas
                start = i + 1; // set start index to next station
            }
        }
        return previous + restGas >= 0 ? start : -1;
    }
    
    /*
     * #136 Single Number
     */
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) res ^= nums[i];
        return res;
    }
    
    /*
     * #137 Single number II
     */
    public int singleNumberII(int[] A) {
        int ones = 0, twos = 0;
        for (int i = 0; i < A.length; i++) {
            ones = (ones ^ A[i]) & ~twos; // in ones not in twos
            twos = (twos ^ A[i]) & ~ones; // in twos not in ones
        }
        return ones; // only appeared once
    }
    
    /*
     * #139 Word Break
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0 || dict == null) return false;
        int len = s.length();
        boolean[] can = new boolean[len + 1];
        can[0] = true;
        
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && dict.contains(s.substring(j, i))) {
                    can[i] = true;
                    break;
                }
            }
        }
        return can[len];
    }
    
    /*
     * #141 Linked List Cycle 
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
    
    /*
     * #142 Linked List Cycle II 
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true; 
                break;
            }
        }
        if (!hasCycle) return null;
        slow = head;
        while (slow != fast) { // move x steps further
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    
    /*
     * #143 Reorder List 
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // find mid point use runner's technique
        ListNode mid = head;
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            mid = mid.next;
            tail = tail.next.next;
        }
        ListNode cur = mid.next;
        mid.next = null; // split mid and mid.next
        // reverse list 2 
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = mid.next; // insert after mid
            mid.next = cur;
            cur = temp; // move to next node
        }
        // reorder list
        ListNode left = head; 
        ListNode right = mid.next;
        while (right != null) { // latter half has fewer elements
            mid.next = right.next;
            right.next = left.next;
            left.next = right;
            // move to next node
            left = right.next;
            right = mid.next;
        }
    }
    
    /*
     * #144 Binary Tree Preorder Traversal
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        preorderTraversal_helper(res, root);
        
        return res;
    }
    
    public void preorderTraversal_helper(List<Integer> res, TreeNode root) {
        if (root == null) return;
        res.add(root.val);
        if (root.left != null) {
            preorderTraversal_helper(res, root.left);
        }
        
        if (root.right != null) {
            preorderTraversal_helper(res, root.right);
        }
    }
    
    public List<Integer> preorderTraversal_itr(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode curNode = s.pop();
            res.add(curNode.val); // visit
            if (curNode.right != null) s.push(curNode.right);
            if (curNode.left != null) s.push(curNode.left); // left pop first
        }
        return res;
    }
    
    /*
     * #145 Binary Tree Postorder Traversal
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
      
        postorderTraversal_helper(res, root);
      
        return res;
    }
      
    public void postorderTraversal_helper(List<Integer> res, TreeNode root) {
          if (root == null) return;

          if (root.left != null) {
              postorderTraversal_helper(res, root.left);
          }
          
          if (root.right != null) {
              postorderTraversal_helper(res, root.right);
          }
          
          res.add(root.val);
    }
      
    /*
     * #147 Insertion Sort List 
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        
        for (ListNode p = head.next, prev = head; p != null; prev = p, p = p.next) {
            for (ListNode c = pre; c.next != p; c = c.next) {
                if (c.next.val > p.val) { 
                    prev.next = p.next; // skip p
                    p.next = c.next; // insert between cur and cur.next
                    c.next = p;
                    p = prev; // p is inserted to somewhere in the front, reset
                    break;
                }
            }
        }
        return pre.next;
    }
    
    /*
     * #148 Sort List
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        int len = 0;
        while (tail != null) {
            tail = tail.next;
            len++;
        }
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        head = mergeSort(dummy, head, len);
        return head;
    }
    
    public ListNode mergeSort(ListNode preHead, ListNode head, int len) {
        if (head == null || len <= 1) return head;
        int left = len / 2;
        int right = len - left;
        // sort left
        head = mergeSort(preHead, head, left);
        // sort right
        ListNode pMid = head;
        for (int i = 0; i < left - 1; i++) pMid = pMid.next;
        mergeSort(pMid, pMid.next, right);
        // merge
        ListNode pre1 = preHead;
        ListNode p1 = head;
        ListNode pre2 = pMid;
        ListNode p2 = pMid.next;
        if (p1.val > p2.val) head = p2; // switch head
        while (left > 0 && right > 0) {
            // merge second half to first half
            if (p1.val > p2.val) {
                pre2.next = p2.next; // insert p2 before p1
                p2.next = p1;
                pre1.next = p2;
                // set to next
                pre1 = p2;
                p2 = pre2.next;
                right--;
            } else {
                // set to next
                pre1 = p1;
                p1 = p1.next;
                left--;
            }
        }
        return head;
    }
    
    /*
     * #150 Evaluate Reverse Polish Notation
     */
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<String> s = new Stack<String>();
        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            String cur = tokens[i];
            if (isOperator(cur)) {
                int t2 = Integer.valueOf(s.pop());
                int t1 = Integer.valueOf(s.pop());
                int res = calculate(t1, t2, cur);
                s.push(res + "");
            } else s.push(cur);
        }
        return Integer.valueOf(s.peek());
    }
    
    /**
     * Helper function to check whether a token is operator or not
     */
    private boolean isOperator(String c) {
        if (c.equalsIgnoreCase("+")) return true;
        if (c.equalsIgnoreCase("-")) return true;
        if (c.equalsIgnoreCase("*")) return true;
        if (c.equalsIgnoreCase("/")) return true;
        return false;
    }
    
    /**
     * Helper function to do calculation
     */
    private int calculate(int t1, int t2, String operator) {
        int res = 0;
        if (operator.equalsIgnoreCase("+")) res = t1 + t2;
        else if (operator.equalsIgnoreCase("-")) res = t1 - t2;
        else if (operator.equalsIgnoreCase("*")) res = t1 * t2;
        else if (operator.equalsIgnoreCase("/")) res = t1 / t2;
        return res;
    } 
    
    /*
     * #151 Reverse Words in a String 
     */
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        s = s.trim();
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                res.append(words[i]);
                if (i != 0) res.append(" ");
            }
        }
        return res.toString(); // remove last space
    }
    
    /*
     * #152 Maximum Product Subarray 
     */
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) return 0;

        int max = A[0], min = A[0], res = A[0];
        for (int i = 1; i < A.length; i++) {
            int preMax = max, preMin = min; // results of last loop
            max = Math.max(Math.max(A[i], preMax * A[i]), preMin * A[i]);
            min = Math.min(Math.min(A[i], preMax * A[i]), preMin * A[i]);
            res = Math.max(max, res);
        }
        return res;
    }
    
    /*
     * #153 Find Minimum in Rotated Sorted Array 
     */
    public int findMin(int[] num) {
        return findMin(num, 0, num.length - 1);
    }
    
    public int findMin(int[] num, int left, int right) {
		if (left == right)
			return num[left];
		if ((right - left) == 1)
			return Math.min(num[left], num[right]);
	 
		int middle = left + (right - left) / 2;
	 
		// not rotated
		if (num[left] < num[right]) {
			return num[left];
	 
		// go right side
		} else if (num[middle] > num[left]) {
			return findMin(num, middle, right);
	 
		// go left side
		} else {
			return findMin(num, left, middle);
		}
	}
    
    /*
     * #155 Min Stack
     */
    private Stack<Integer> s = new Stack<Integer>();
    /**
     * Standard solution, two ss
     * a minStack to store minimums
     */
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        s.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) { // even smaller
            minStack.push(x);
        }
    }

    public void pop() {
        if (s.pop().equals(minStack.peek())) minStack.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
    
    /*
     * #160 Intersection of Two Linked Lists
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = length(headA);
        int lenB = length(headB);
        int diff = Math.abs(lenA - lenB);
        
        if (lenA > lenB) while(diff-- > 0) headA = headA.next;
        else while(diff-- > 0) headB = headB.next;
        
        for (; headA != null && headB != null; headA = headA.next, headB = headB.next) if (headA.equals(headB)) return headA;
        return null;
    }
    
    private int length(ListNode n) {
        if (n == null) return 0;
        int length = 0;
        while (n != null) {
            length++;
            n = n.next;
        }
        return length;
    }
    
    /*
     * #162 Find Peak Element 
     */
    public int findPeakElement(int[] num) {
        if (num == null || num.length == 0) return 0;
        int n = num.length;
        if (n <= 1) return 0;
        // handle the first and last element in num[]
        if (num[0] > num[1]) return 0;
        if (num[n - 1] > num[n - 2]) return n - 1;
        
        int left = 1, right = n - 2;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) return mid;
            else if (num[mid] > num[mid + 1]) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
    
    /*
     * #165 Compare Version Numbers 
     */
    public int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null) return 0; // same
        if (version1 == null || version2 == null) return version1 == null ? -1 : 1;
        String[] list1 = version1.split("\\."); // back slash
        String[] list2 = version2.split("\\.");
        int i = 0;
        while (i < list1.length || i < list2.length) {
            int a = i < list1.length ? Integer.valueOf(list1[i]) : 0;
            int b = i < list2.length ? Integer.valueOf(list2[i]) : 0;
            if (a < b) return -1;
            else if (a > b) return 1;
            i++; // update i
        }
        return 0;
    }
    
    /*
     * #166 Fraction to Recurring Decimal 
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        if (numerator == 0) return "0";
        
        StringBuilder res = new StringBuilder();
        Long n = new Long(numerator); // convert to long
        Long d = new Long(denominator);
        if ((n < 0 && d > 0) || (n > 0 && d < 0)) res.append("-"); // negative
        
        n = Math.abs(n); // to abstract value
        d = Math.abs(d);
        res.append(n / d); // before dot 
        if (n % d == 0) return res.toString(); // no fraction
        
        res.append("."); // add dot
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        Long r = n % d; // get first remainder
        while (r > 0) {
            if (map.containsKey(r)) { // remainder appeared before
                res.insert(map.get(r), "("); // insert an open paren
                res.append(")"); // append a close paren
                break;
            }
            map.put(r, res.length()); // save remainder and the length
            r *= 10; // simulate long division
            res.append(r / d);
            r %= d; // get next remainder
        }
        return res.toString();
    }
    
    /*
     * #168 Excel Sheet Column Title 
     */
    
    
    /*
     * # 226 Invert Binary Tree
     */
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null ||(root.left == null && root.right == null)) return root;
        
        TreeNode newRoot = new TreeNode(root.val);
        
        invert_helper(root, newRoot);
        
        return newRoot;
    }
    
    public void invert_helper(TreeNode root,TreeNode newRoot) {
        if(root.left != null){
            newRoot.right = new TreeNode(root.left.val);
            invert_helper(root.left, newRoot.right);
        } 
        
        if (root.right != null){
            newRoot.left = new TreeNode(root.right.val);
            invert_helper(root.right, newRoot.left);
        }
        
        if(root.left == null && root.right == null)
            newRoot = new TreeNode(root.val);

    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		//sol.reverseBits(1);
		/*
		int i = sol.romanToInt("DCXXI");
		String[] strs = {"tea","and","ate","eat","dan"};
		List<String> s = sol.anagrams(strs);
		int[][] matrix = {{1,2},{3,4}};
		sol.rotate(matrix);
		for(String s1 : s) System.out.println(s1);
		int[] nums = {3,4,-1,1};
		ArrayList<ArrayList<Integer>> a = sol.threeSum(nums);
		int fr = sol.firstMissingPositive(nums);
		List<Interval> intervals = new ArrayList<Interval>();
		Interval i1 = new Interval(1, 4);
		Interval i2 = new Interval(1, 5);
		intervals.add(i1);
		intervals.add(i2);
		List<Interval> res = sol.merge(intervals);
		for(Interval i : res) {
			System.out.println("s " + i.start);
			System.out.println("e " + i.end);
		}
		
		sol.getPermutation(3, 6);
		*/
		char[][] board = {{'a','a'}};
		String word = "aa";
		System.out.println(sol.exist(board, word));
		
		//System.out.println(fr);

	}
}
