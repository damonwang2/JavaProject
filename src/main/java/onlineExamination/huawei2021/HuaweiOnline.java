package onlineExamination.huawei2021;

import java.util.stream.Collectors;
import java.util.*;
import java.util.ArrayList;

public class HuaweiOnline {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String line = in.nextLine();

            solution2(line);
        }
    }

    private static void solution1(String line) {

        List<int[]> pairList = new ArrayList<>();
        int count = 0;
        for (String str : line.split(",")) {
            int value = Integer.parseInt(str);
            pairList.add(new int[]{value, count++});
        }
        Comparator<int[]> comparator = (pair1, pair2) -> pair2[0] - pair1[0];
        pairList.sort(comparator.reversed());
        String result = pairList.stream().map(pair -> String.valueOf(pair[1]))
                .collect(Collectors.joining(","));
        System.out.println(result);
    }

    private static void solution2(String line) {
        String[] strs = line.split(",");
        int[] values = new int[strs.length];
        List<Integer> resultList = new ArrayList<>();
        Queue<int[]> taskQueue = new LinkedList<>();
        int count = 0;
        for (String str : strs) {
            if (str == null || str.isEmpty()) {
                continue;
            }
            int value = Integer.parseInt(str);
            values[count] = value;
            taskQueue.add(new int[]{count, value});
            count++;
        }
        Arrays.sort(values);
        count--;
        while (!taskQueue.isEmpty()) {
            int[] task = taskQueue.poll();

            if (task[1] < values[count]) {
                taskQueue.add(task);
            } else if (task[1] == values[count]) {
                count--;
                resultList.add(task[0]);
            }

        }

        String result = resultList.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(result);

    }
}
