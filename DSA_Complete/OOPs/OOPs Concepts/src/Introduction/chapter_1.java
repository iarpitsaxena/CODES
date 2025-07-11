package Introduction;

import java.util.Arrays;

public class chapter_1 {
    public static void main(String[] args) {
        student[] students = new student[5];
        student kunal = new student();
        kunal.rollno = 1;
        kunal.name = "kunal kushwaha";
        kunal.marks = 85.5f;
        System.out.println(kunal.rollno);

    }
}

class student{
    int rollno;
    String name;
    float marks;

}