package javaProperty.reflect;


/**
 * Created by pojun on 2019/1/11.
 */
public class Father {
    public String mFatherName;
    public int mFatherAge;

    public String getmFatherName() {
        return mFatherName;
    }

    public void setmFatherName(String mFatherName) {
        this.mFatherName = mFatherName;
    }

    public static void printFatherMsg() {
        System.out.println("father");
    }
}
