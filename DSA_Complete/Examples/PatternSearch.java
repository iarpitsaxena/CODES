package Examples;

public class PatternSearch {
    public static void main(String[] args) {
        String a = "1001100100";
        System.out.println(removeSubstring(a));
    }
    public static int removeSubstring(String a){
        int tempLen = 0, maxLen = 0;
        for(int i = 0; i <= a.length() - 3; i++) {
            if (a.charAt(i) == '1' && a.charAt(i + 1) == '0' && a.charAt(i + 2) == '0') {
                tempLen = 3;
                int j = i + 3;
                while (j <= a.length() - 3 && a.charAt(j) == '1' && a.charAt(j + 1) == '0' && a.charAt(j + 2) == '0') {
                    tempLen += 3;
                    j += 3;
                }
                maxLen = Math.max(maxLen, tempLen);
            }
        }
        return maxLen;
    }
}
