package 笔试真题.快手;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/29 18:35
 */
public class Main_验证IP地址 {
    /**
     * https://www.nowcoder.com/questionTerminal/54fbe83400964042a237eca44610a308
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.split("\\.").length == 4){
            // 判定是否为IPV4
            if (isIPv4(str)){
                System.out.println("IPv4");
            }else {
                System.out.println("Neither");
            }
        }else if (str.split(":").length == 8){
            if (isIPv6(str)){
                System.out.println("IPv6");
            }else {
                System.out.println("Neither");
            }
        }else {
            System.out.println("Neither");
        }
    }

    private static boolean isIPv6(String str) {
        String[] nums = str.split(":");
        for(String num : nums){
            if ((num.length() != 4 && !num.equals("0")) || num.equals("0000")){
                return false;
            }
        }
        return true;
    }

    private static boolean isIPv4(String str) {
        try {
            String[] nums = str.split("\\.");
            for(String num : nums) {
                if (num.length() >= 2 && num.charAt(0) == '0'){
                    return false;
                }
                int integer = Integer.parseInt(num);
                if (integer < 0 || integer > 255){
                    return false;
                }
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
