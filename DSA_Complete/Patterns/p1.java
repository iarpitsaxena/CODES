package Patterns;
import java.util.*;

public class p1{

    public static void patternprint(int N){
        for(int i = 0; i<N;i++){
            for(int j = 0; j< N;j++){
                System.out.print("*" + " ");
        }
        System.out.println();
    }
    }
    public static void main(String Args[]){
        int N = 5;
        patternprint(N);
}

}
