package Switch1;

import java.util.Scanner;


public class switch_{
    public static void main(String[] args){
        int day;
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter the day of the week (1-7):");
        day = sc.nextInt();


        switch(day){
            case 1:System.out.println("Monday");
                break;

            case 2:System.out.println("Tuesday");
                break;

            case 3:System.out.println("Wednesday");
                break;

            case 4:System.out.println("Thursday");
                break;

            case 5:System.out.println("Friday");
                break;

            case 6:System.out.println("Saturday");
                break;

            case 7:System.out.println("Sunday");
                break;
        }

    }

}