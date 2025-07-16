/*
package SOLID;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) throws Exception {
        Singleton s1 = Singleton.getSingleton();
        //Singleton s2 = Singleton.getSingleton();

        //System.out.println(s1.hashCode());
        //System.out.println(s2.hashCode());

        //Singleton break
        // Singleton s3 = new Singleton(); // This line will cause a compilation error because the constructor is private.

        //we have reflection api to break singleton
        // Singleton s4 = (Singleton) Class.forName("SOLID.Singleton").newInstance(); // This line will also cause a compilation error.
        // However, using reflection to break singleton is not recommended as it goes against the design principle of singleton.
        // Instead, we should use the getSingleton() method to get the singleton instance.

        // If you want to break the singleton pattern using reflection, you can do it like this:
        // try {
        //     Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        //     constructor.setAccessible(true); // This allows us to access the private constructor
        //     Singleton s4 = constructor.newInstance(); // This will create a new instance of Singleton
        //     System.out.println(s4.hashCode());
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        Constructor<Singleton> singleton = Singleton.class.getDeclaredConstructor();
        singleton.setAccessible(true); // This allows us to access the private constructor
        Singleton s3 = singleton.newInstance();
        System.out.println(s1.hashCode());
        System.out.println(s3.hashCode());

        String file = "/Users/arpit/Desktop/output.txt.rtf";
        FileOutputStream f = new FileOutputStream(file);
        ObjectOutputStream o =  new ObjectOutputStream(f);
        o.writeObject(s);
        FileInputStream f1 = new FileInputStream(file);
        ObjectInputStream o1 = new ObjectInputStream(f1);
        Student s1 = (Student)o1.readObject();




    }

}*/

package SOLID;

import java.io.*;
import java.lang.reflect.Constructor;

public class Client {
    public static void main(String[] args) throws Exception {
        // Original Singleton instance
        Singleton s1 = Singleton.getSingleton();

        // Reflection break
        Constructor<Singleton> singletonConstructor = Singleton.class.getDeclaredConstructor();
        singletonConstructor.setAccessible(true);
        Singleton s2 = singletonConstructor.newInstance();

        System.out.println("Original Singleton hashCode: " + s1.hashCode());
        System.out.println("Reflection Singleton hashCode: " + s2.hashCode());

        // Serialize Singleton to file
        String file = "/Users/arpit/Desktop/output.txt.rtf";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(s1);
        out.close();

        // Deserialize Singleton from file
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Singleton s3 = (Singleton) in.readObject();
        in.close();

        System.out.println("Deserialized Singleton hashCode: " + s3.hashCode());
    }
}
