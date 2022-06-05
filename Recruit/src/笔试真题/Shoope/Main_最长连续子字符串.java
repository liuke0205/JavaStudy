package 笔试真题.Shoope;

/**
 * @author liuke
 * @date 2022/6/4 13:11
 */
public class Main_最长连续子字符串 {
    /**
     * https://www.nowcoder.com/questionTerminal/2b7412d2f92f4b9ca4a4e5f33c64dbc1
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(findLongestSubstr("LLLLLLLlllllooooolllll"));
    }
    public static String findLongestSubstr (String str) {
        int left = 0, right = 0;
        int max = 0, cnt = 0, start = 0;
        while (right < str.length()){
            if (isEqual(str.charAt(left), str.charAt(right))){
                right++;
                cnt++;
            }else {
                if (cnt > max){
                    start = left;
                    max = cnt;
                }
                left = right;
                cnt = 0;
            }
        }
        if (cnt > max){
            start = left;
            max = cnt;
        }
        return str.substring(start, start + max);
    }

    public static boolean isEqual(char a, char b){
        if (a >= 'A' && a <= 'Z'){
            a = (char) (a + 32);
        }
        if (b >= 'A' && b <= 'Z'){
            b = (char) (b + 32);
        }
       return a == b;
    }
}
