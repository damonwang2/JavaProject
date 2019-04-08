package IOAndNIO;

import java.io.*;

public class BlockIO {
    public static void main(String[] args) {
        try {
            InputStream input = new FileInputStream("c:\\data\\...");
            System.out.println("File opened...");
        } catch (IOException e) {
            System.err.println("File opening failed:");
            e.printStackTrace();
        }

        byte[] data = "浙江大学".getBytes();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try{
            String nameLine   = reader.readLine();
            String ageLine    = reader.readLine();
            String emailLine  = reader.readLine();
            String phoneLine  = reader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
