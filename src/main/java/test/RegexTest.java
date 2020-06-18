package test;

import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;

/**
 * TODO
 *
 * @author pojun
 * @date 2019/9/15
 */
public class RegexTest {

    final static Pattern pattern = Pattern.compile("\\w+");

    public static void main(String[] args) {

        System.out.println(JSON.parseObject(null, Object.class));

        System.out.println("1_134".matches("\\w+"));

        System.out.println(pattern.matcher("asdf2134").matches());
    }
}