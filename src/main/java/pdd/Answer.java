package pdd;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

/**
 * @author pojun
 * @date 2019/5/22
 */
public class Answer {
    public static void main(String[] args) {
        Set<String> all = new HashSet<>();
        Set<String> passed = new HashSet<>();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if ("A".equals(line)) {
                break;
            }
            all.addAll(Arrays.asList(line.split("\\s+")));
        }

        System.out.println("input passed");

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (StringUtils.isBlank(line)) {
                continue;
            }
            passed.add(line);
        }

        System.out.println("output not passed");

        all.removeAll(passed);
        System.out.println(all.size());
        System.out.println(all);

        Answer[] a = new Answer[5];
        Arrays.copyOf(a, 5);
    }

    @Override
    protected Answer clone() throws CloneNotSupportedException {
        try {
            // 直接调用父类的clone()方法
            return (Answer) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
