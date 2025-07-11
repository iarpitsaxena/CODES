package Examples;

public class StringPalindrome {
    public static void main(String[] args) {
        System.out.println(palindrome("madam"));
        System.out.println(palindrome("maddam"));
        System.out.println(palindrome("madafdam"));

    }

    public static boolean palindrome(String str){
        int left = 0, right = str.length()-1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
