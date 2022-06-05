package 笔试真题.Shoope;

/**
 * @author liuke
 * @date 2022/6/4 16:46
 */
public class Main_压缩字符串 {
    /**
     * https://www.nowcoder.com/questionTerminal/c43a0d72d29941c1b65c857d8ac9047e
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(compressString("abcccaaaa"));
    }
    public static String compressString (String param) {
        if (param.length() == 0){
            return param;
        }
        int cnt = 0;
        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();

        while (right < param.length()){
            if (param.charAt(right) == param.charAt(left)){
                right++;
                cnt++;
            }else {
                sb.append(param.charAt(left));
                if (cnt > 0){
                    sb.append(cnt);
                }
                cnt = 0;
                left = right;
            }
        }
        sb.append(param.charAt(left));
        if (cnt > 0){
            sb.append(cnt);
        }
        return sb.toString().length() < param.length() ? sb.toString() : param;
    }
}
