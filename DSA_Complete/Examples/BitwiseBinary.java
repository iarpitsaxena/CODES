package Examples;

public class BitwiseBinary {
    public static void main(String[] args) {
        int num = 23;
        StringBuilder binary = new StringBuilder();
        while(num > 0){
            binary.insert(0,(num&1));
            num = num >> 1;
        }
        System.out.println(binary);
    }
}
