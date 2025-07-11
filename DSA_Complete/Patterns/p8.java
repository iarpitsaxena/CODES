package Patterns;
import java.util.*;

public class p8{

    public static void patternprint(int N){
        for(int i = 1; i<N;i++){
            for(int j = 1; j<i ;j++){
                System.out.print(" ");
        }

            for(int j=0;j<N*2-(2*i+1);j++){
                System.out.print("*");
            }

            for(int j = N; j<i ;j++){
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
