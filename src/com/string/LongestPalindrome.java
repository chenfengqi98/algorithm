package com.string;

/**
 * @Description : TODO
 * @Author : chen qi
 * @Date: 2021-09-18 11:06
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = palindromeHelper(s, i, i);
            String s2 = palindromeHelper(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    public String palindromeHelper(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
    }
}

