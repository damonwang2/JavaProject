package guava;

import com.google.common.math.IntMath;

public class MathTest {
    public static void main(String[] args) {
        try {
            IntMath.checkedAdd(Integer.MAX_VALUE, 1);
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

    }
}
