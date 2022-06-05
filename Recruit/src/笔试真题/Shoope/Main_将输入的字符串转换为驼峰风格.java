package 笔试真题.Shoope;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuke
 * @date 2022/6/5 20:31
 */
public class Main_将输入的字符串转换为驼峰风格 {
    public static void main(String[] args) {
        System.out.println(camelCase("CapitalizedWordsTest"));
//        System.out.println(camelCase("hello"));
//        System.out.println(camelCase("Hello"));
//        System.out.println(camelCase("hello9_world"));
//        System.out.println(camelCase("hello98world"));
    }
    public static String camelCase (String name) {
        if (name.length() == 0){
            return "shopee";
        }
        List<String> nums = new ArrayList<>();
        if (!isContain(name)) {
            StringBuilder sb = new StringBuilder();
            for (char c : name.toCharArray()) {
                if (isNumOrChar(c)) {
                    sb.append(c);
                } else {
                    nums.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
            if (sb.length() != 0) {
                nums.add(sb.toString());
            }
        }else {
            nums.add(name);
        }
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < nums.size(); i++) {
            if (!"".equals(nums.get(i)) && nums.get(i) != null){
                String strs = nums.get(i).toLowerCase();
                if (sb.length() == 0){
                    sb.append(strs);
                }else {
                    sb.append(upperCase(strs));
                }
            }
        }
        return sb.length() == 0 ? "shopee" : sb.toString();
    }

    public static boolean isContain(String str){
        for (char c : str.toCharArray()){
            if (!isNumOrChar(c)){
                return false;
            }
        }
        return true;
    }

    public static boolean isNumOrChar(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
}
