package oj.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new MinWindow().minWindow(s, t));

    }
        public String minWindow(String s, String t) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : t.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            Map<Character, Integer> curMap = new HashMap<>();
            String res = "";

            int left = 0;
            int right = 0;
            while (left <= s.length() - t.length() && right <= s.length()) {
                System.out.println(left + " " + right);
                Map<Character, Integer> gagMap = contains(curMap, map);
                System.out.println("gagMap:" + gagMap);
                System.out.println("");

                    while (gagMap.size() > 0) {

                        if (right == s.length()) {
                            return  res;
                        }
                        Character c = s.charAt(right);
                        right++;
                        if (gagMap.containsKey(c)) {
                            int newValue = gagMap.get(c) + 1;
                            if (newValue == 0) {
                                gagMap.remove(c);
                            } else {
                                gagMap.put(c, newValue);
                            }
                        }
                        curMap.put(c, curMap.getOrDefault(c, 0) + 1);
                    }

                    System.out.println("phase1");
                    String curRes = s.substring(left, right);
                    if ("".equals(res)) {
                        res = curRes;
                    } else {
                        res = curRes.length() > res.length() ? res : curRes;
                    }
                    char c = s.charAt(left);
                    curMap.put(c, curMap.getOrDefault(c, 0) - 1);
                    left++;


            }
            return res;
        }

        private Map<Character, Integer> contains(Map<Character, Integer> map1, Map<Character, Integer> map2) {
            Map<Character, Integer> gapMap = new HashMap<>();
            for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
                int value1 = map1.getOrDefault(entry.getKey(), 0);
                int gap = value1 - entry.getValue();
                if (gap < 0) {
                    gapMap.put(entry.getKey(), gap);
                }
            }
            return gapMap;
        }
    }
