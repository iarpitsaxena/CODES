package Patterns;
import java.util.*;

public class p3{

    public static void patternprint(int N){
        for(int i = 1; i<N;i++){
            for(int j = 1; j<= i;j++){
                System.out.print(j + " ");
        }
        System.out.println();
    }
    }
    public static void main(String Args[]){
        int N = 6;
        patternprint(N);
}

}
