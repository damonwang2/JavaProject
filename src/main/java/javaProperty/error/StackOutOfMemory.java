package javaProperty.error;

public class StackOutOfMemory {
    private int stackLength = 1;

    public void stackLengthAdd(){
        stackLength++;
        stackLengthAdd();
    }
    public static void main(String[] args) {
        //栈溢出
        StackOutOfMemory object = new StackOutOfMemory();
        try{
            object.stackLengthAdd();
        }catch (Exception e){
            System.out.println("Exception");
        }
        //内存溢出
    }
}
