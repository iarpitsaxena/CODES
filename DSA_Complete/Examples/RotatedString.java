package Examples;

import java.util.Scanner;

public class RotatedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        int steps = transform(s,t);
        System.out.println(steps);
    }
    static Integer transform(String s, String t){
        int len = s.length();
        String rotated = s;
        for (int i = 1; i < len; i++) {
            if(rotated.equals(t)){
                return i;
            }
            rotated = rotated.substring(1) + rotated.charAt(0);
        }
        return -1;
    }
}
