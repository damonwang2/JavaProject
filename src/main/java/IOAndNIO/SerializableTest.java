package IOAndNIO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest {
    public static void main(String[] args) {
        try{
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.data"));
            MyClass object = new MyClass();
            output.writeObject(object); //etc.
            output.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class MyClass implements Serializable{
    int i;
}
