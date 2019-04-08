package oj.jianzhiOffer;

public class Print1ToNBit {
    public static void main(String[] args) {
        Print1ToNBit object = new Print1ToNBit();
        object.Print1ToMaxOfDigits(2);
        int[] a = {11,22,33};
    }

    public void Print1ToMaxOfDigits(int n){
        if(n <= 0)
            return ;

        char[] numbers = new char[n];

        Print1ToMaxOfDigitsRecursively(numbers, n, 0);
    }

    public void Print1ToMaxOfDigitsRecursively(char[] numbers, int length, int index){
        if(index == length){
            System.out.println(String.valueOf(numbers));
            return;
        }
        for(int i = 0; i < 10; i++){
            numbers[index] = (char) (i + '0');
            Print1ToMaxOfDigitsRecursively(numbers, length, index + 1);
        }
    }
}
