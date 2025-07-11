package Examples;
import java.util.*;
public class MagicCalculator {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int startValue = sc.nextInt();
        int target = sc.nextInt();
        int minSteps = calculate(startValue,target);
        System.out.println(minSteps);
    }

    static Integer calculate(int startValue, int target){
        int steps = 0;
        while(target > startValue){
            if(target % 2 == 0){
                target /= 2;
            } else{
                target +=1;
            }
            steps ++;
        }
        return steps + (startValue - target);
    }
}
