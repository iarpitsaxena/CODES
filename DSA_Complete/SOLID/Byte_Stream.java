package SOLID;

import java.io.*;

public class Byte_Stream {
    // This class is a placeholder for the Byte_Stream functionality.
    // It can be used to implement methods related to byte streams,
    // such as reading from or writing to byte streams, processing data, etc.

    // Example method to read bytes from a stream
    public void readBytes() {
        // Implementation for reading bytes from a stream
    }

    // Example method to write bytes to a stream
    public void writeBytes() {
        // Implementation for writing bytes to a stream
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s = new Student();
        s.name = "John Doe";
        s.age = 20;
        String file = "/Users/arpit/Desktop/output.txt.rtf";
        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream o =  new ObjectOutputStream(f);
        o.writeObject(s);
        FileInputStream f1 = new FileInputStream(file);
        ObjectInputStream o1 = new ObjectInputStream(f1);
        Student s1 = (Student)o1.readObject();
        System.out.println(s1.hashCode());


    }

}
class Student implements Serializable {
    String name;
    int age;

}
