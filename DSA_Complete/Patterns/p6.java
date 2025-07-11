package Patterns;
import java.util.*;

public class p6{

    public static void patternprint(int N){
        for(int i = 1; i<N;i++){
            for(int j = N; j>i ;j--){
                System.out.print(N - j + 1 + " ");
        }
        System.out.println();
    }
    }
    public static void main(String Args[]){
        int N = 6;
        patternprint(N);
}

}
