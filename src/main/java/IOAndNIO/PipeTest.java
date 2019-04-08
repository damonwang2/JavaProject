package IOAndNIO;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

@Slf4j
public class PipeTest {
    public static void main(String[] args) throws IOException {
        final PipedOutputStream outputStream = new PipedOutputStream();
        final PipedInputStream inputStream = new PipedInputStream(outputStream);

        new Thread(() -> {
            try {
                outputStream.write("hello world".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        new Thread(() -> {
            try {
                int data;
                while ((data = inputStream.read()) != -1) {
                    System.out.println((char) data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
