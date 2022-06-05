package 笔试真题.Shoope;

import javax.print.DocFlavor;

/**
 * @author liuke
 * @date 2022/6/4 0:31
 */
public class Main_成对的69 {
    /**
     * https://www.nowcoder.com/questionTerminal/c544c6177b87478a93205c2430b2a6af
     *
     * 思路：
     * 缺6,往前补6；缺9，往后补9
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Paired69("66696999"));
    }

    /**
     * @param S string字符串
     * @return string字符串
     */
    public static String Paired69 (String S) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0; //记录6的个数
        for (char c : S.toCharArray()){
            if (c == '6'){
                cnt++;
            }else {
                if (cnt == 0){
                    sb.insert(0, "6");
                }else {
                    cnt--;
                }
            }
            sb.append(c);
        }
        for (int i = 0; i < cnt; i++) {
            sb.append("9");
        }
        return sb.toString();
    }

    private static boolean check(String str) {
        if (str.length() == 0){
            return true;
        }
        if (str.length() % 2 != 0){
            return false;
        }
        boolean flag1 = false, flag2;
        if (str.charAt(0) == '6' && str.charAt(str.length() - 1) =='9'){
            flag1 = check(str.substring(1, str.length() - 1));
        }
        flag2 = check(str.substring(0, str.length() / 2)) && check(str.substring(str.length() / 2));
        return flag1 || flag2;
    }

    public static String[] getList(String S){
        return new String[]{"6"+S, "9"+S, S+"6", S+"9"};
    }
}
