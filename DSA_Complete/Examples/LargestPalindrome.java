package Examples;

import java.util.*;

public class LargestPalindrome {
    public static String largestPalindrome(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder halfPalindrome = new StringBuilder();
        char oddChar = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            int count = freq[c - 'a'];
            if (count % 2 == 1) {
                if (oddChar == 0 || c < oddChar) {
                    oddChar = c;
                }
            }
            for (int i = 0; i < count / 2; i++) {
                halfPalindrome.append(c);
            }
        }

        String half = halfPalindrome.toString();
        StringBuilder result = new StringBuilder(half);
        if (oddChar != 0) {
            result.append(oddChar);
        }
        result.append(new StringBuilder(half).reverse());

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            String s = scanner.nextLine();
            System.out.println(largestPalindrome(s));
        }
        scanner.close();
    }
}









/*
Hari and Palindrome Hari is an intelligent village student. He is a topper in all the subjects except English.
Hari's class teacher is very kind and wants him to be topper in all subjects. So she arranges a small Retest torhim.
The teacher gives Hari a string s. Hari has to find the largest palindrome that can be formed using the characters of the string s.
If many such palindromes exist, the teacher asks Hari to output the lexicographically smallest. Help Hari to be the topper.

Input format - The first line contains a single integer T, denoting the number of test cases.
             - The next T lines consist of a string S of lowercase English alphabets. Output format For each test case, print the the largest palindrome that can be formed using the characters of the string s .
Constraints
1≤T≤100
1≤∣S∣≤10
5

​

Sample Output Sample Input 3 adsasda
 adskassda
 talent
 decrypt
**/