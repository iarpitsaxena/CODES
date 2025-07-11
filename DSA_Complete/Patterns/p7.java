package Patterns;
import java.util.*;

public class p7{

    public static void patternprint(int N){
        for(int i = 1; i<N;i++){
            for(int j = 0; j<N-i+1 ;j++){
                System.out.print(" ");
        }

            for(int j=0;j<i*2+1;j++){
                System.out.print("*");
            }

            for(int j = 0; j<N-i+1 ;j++){
                System.out.print(" ");
        }
    



        
    System.out.println();
    }
    }
    public static void main(String Args[]){
        int N = 6;
        patternprint(N);
}

}
