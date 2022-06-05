package 笔试真题.Shoope;

/**
 * @author liuke
 * @date 2022/6/4 12:48
 */
public class Main_小驼峰格式转换 {
    /**
     * https://www.nowcoder.com/questionTerminal/284b2a44e4f9445c96d1bb45ef1b505d
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(format("Platform"));
    }
    public static String format (String name) {
        if (name.length() == 0){
            return name;
        }
        String[] nums;
        if (name.contains("_")){
            nums = name.split("_");
        }else {
            nums = new String[100];
            int idx = 0;
            int start = 0, end = 0;
            while (end < name.length()){
                char c = name.charAt(end);
                if (c >= 'A' && c <= 'Z'){
                    nums[idx++] = name.substring(start, end);
                    start = end;
                }
                end++;
            }
            nums[idx] = name.substring(start, end);
        }
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (!"".equals(nums[i]) && nums[i] != null){
                nums[i] = nums[i].toLowerCase();
                if (sb.length() == 0){
                    sb.append(nums[i]);
                }else {
                    sb.append(upperCase(nums[i]));
                }
            }
        }
        return sb.toString();
    }

    public static String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
}
