import java.util.*;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		sol.reverseBits(1);

	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	 }
	
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
        return 0;
    }
    
    /*
     #12 Integer to Roman 
     Given an integer, convert it to a roman numeral.
	 Input is guaranteed to be within the range from 1 to 3999.
     */
    public String intToRoman(int num) {
        
    	return null;
    }
    
    /*
     #13 Roman to Integer
     */
    public int romanToInt(String s) {
        
    	return 0;
    }
    
	//reverse bits
	public int reverseBits(int n) {
       String b = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        System.out.println(b);
        StringBuilder sb = new StringBuilder(b);
        System.out.println(sb.reverse().toString());
        int ret = 0;
        try{
          String i = sb.reverse().toString();
          ret = Integer.parseInt("10000000000000000000000000000000", 2);
          System.out.println(ret);
        }catch (Exception e){
            return Integer.MAX_VALUE;
        }
        return ret;
        
    }
	
	//Length of Last Word
	public int lengthOfLastWord(String s) {
        if(s == null)
            return 0;
        
        
        char[] c_array = s.toCharArray();
        int ret = 0;
        int index = 0;
        
        if(c_array.length == 0)
            return 0;
            
        
        for(int i=c_array.length-1; i >= 0; --i)
        {
            if(c_array[i] == ' ')
            {
                if(ret == 0)
                    continue;
                else
                    return ret;
            }
            
            ++ret;
        }
        
        return ret;
    }
	
	//Valid Parentheses
	public boolean isValid(String s) {
        char[] c_array = s.toCharArray();
        
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        Stack<Character> stack = new Stack<Character>();
        
        for(Character c : c_array)
        {
            if(map.containsKey(c)){
                stack.push(c);      
            }else if(map.containsValue(c)){
                if(!stack.isEmpty() && map.get(stack.peek()) == c){
                    stack.pop();
                }
                else
                    return false;
            }
        }
        
        return stack.isEmpty();
        
    }
	
	//Majority Element
	public int majorityElement(int[] num) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        for(int i : num)
        {
            if(!map.containsKey(i)){
                map.put(i, 1);
            }else{
                map.put(i, map.get(i)+1);
            }
        }
        
        for(int i : map.keySet())
        {
            if(map.get(i) > num.length/2)
                return i;
        }
        return -1;
        
    }
	
	//Excel Sheet Column Title 
	public String convertToTitle(int n) {
        
        String s = "";
        
        while(n > 0)
        {
            int i = 0;
            --n;
            i = n % 26;
            n = n / 26;
            s = ((char)('A' + i)) + s;
            
        }
        
        return s;
    }
	
	

}
