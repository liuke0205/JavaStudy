package 笔试真题.Shoope;

public class Main_替换字符串中的数字成num {
    public static void main(String[] args) {
        System.out.println(replaceStr("abvhjb123ddd3"));
    }
    public static String replaceStr (String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9'){
                flag = true;
            }else {
                if (flag){
                    sb.append("num");
                    flag = false;
                }
                sb.append(c);
            }
        }
        if (flag){
            sb.append("num");
        }
        return sb.toString();
    }
}
