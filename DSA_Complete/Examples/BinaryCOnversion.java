package Examples;

//public class BinaryCOnversion {
//    public static void main(String[] args) {
//        int num = 25;
//        StringBuilder sb = new StringBuilder();
//        while(num > 0){
//            sb.append(num%2);
//            num/=2;
//        }
//        System.out.println(sb.reverse().toString());
//    }
//
//
//}



public class BinaryCOnversion {
    public static String decimalToBinary(int num){
        StringBuilder sb = new StringBuilder();
        if(num == 0){
            return "0";
        }
        while(num>0){
            sb.append(num&1);
            num>>=1;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int num = 73;
        System.out.println(decimalToBinary(num));
    }
}


