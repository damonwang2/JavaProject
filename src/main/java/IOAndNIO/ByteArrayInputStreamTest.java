package IOAndNIO;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamTest {

        public static void main(String[] args) {
            byte[] data = "浙江大学".getBytes();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);

            //查看字节数组信息
            System.out.println("字节数组长度："  + data.length);
            for(byte d : data){
                System.out.print(d + " ");
            }
            System.out.println();

            byte[] data1 = new byte[data.length];
            try {
                //Reads some number of bytes from the input stream and stores them into the buffer array data1.
                inputStream.read(data1);
                //传入一个byte数组初始化String
                System.out.println(new String(data1));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
