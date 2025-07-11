package Examples;

public class Contains {
    public static void main(String[] args) {
        String s = "hello world";
        String p = "wold";
        isContains(s,p);
    }
    static void isContains(String s, String p){
        System.out.println(s.contains(p)? "pattern found" : "not found");
    }
}
