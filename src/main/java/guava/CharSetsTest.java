package guava;

import com.google.common.base.Charsets;

public class CharSetsTest {
    public static void main(String[] args) {
        String string = "hello world";
        byte[] bytes = string.getBytes(Charsets.UTF_8);

    }
}
