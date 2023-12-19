package onlineExamination.huawei2021;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HuaWei {
    public static void main(String[] args) {
        String[] words1 = new String[]{"cat","bt","hat","tree"};
        String chars1 = "atach";
        int test1 = solution(words1, chars1);
        System.out.println(test1);
        String[] words2 = new String[]{"hello","world","leetcode"};
        String chars2 = "welldonehoneyr";
        System.out.println(solution(words2, chars2));

    }

    private static int solution(String[] words, String chars) {
        // 可用char[]数组优化
        Map<Character, Integer> char2count = new HashMap<>(chars.length());
        for (char c : chars.toCharArray()) {
            int count = char2count.getOrDefault(c, 0);
            count++;
            char2count.put(c, count);
        }

        int result = 0;
        for (String word : words) {
            Map<Character, Integer> characterIntegerMap = new HashMap<>(char2count);

            boolean success = true;
            for (char c : word.toCharArray()) {
                Integer count = characterIntegerMap.get(c);
                if (count == null || count == 0) {
                    success = false;
                    break;
                }
                count--;
                characterIntegerMap.put(c, count);
            }
            if (success) {
                result += word.length();
            }
        }
        return result;
    }
}
