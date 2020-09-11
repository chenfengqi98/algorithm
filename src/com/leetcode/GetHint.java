package com.leetcode;

import java.util.HashMap;

/**
 * @author chenqi
 * @date 2020-06-17 17:40
 * @Descripion 299. 猜数字游戏
 */
public class GetHint {
    public static String getHint(String secret, String guess) {
        if (secret == null || guess == null) {
            return "0A0B";
        }
        int A = 0, B = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                A++;
            }
        }
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapG = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            mapS.put(secret.charAt(i), mapS.getOrDefault(secret.charAt(i), 0) + 1);
            mapG.put(guess.charAt(i), mapG.getOrDefault(guess.charAt(i), 0) + 1);
        }
        for (Character key : mapG.keySet()) {
            int n1 = mapG.getOrDefault(key, 0);
            int n2 = mapS.getOrDefault(key, 0);
            B = B + Math.min(n1, n2);
        }
        return A + "A" + (B - A) + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1234","1321"));
    }
}
