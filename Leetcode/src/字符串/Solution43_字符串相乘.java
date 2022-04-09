package 字符串;

/**
 * @author liuke
 * @date 2022/4/8 21:53
 */
public class Solution43_字符串相乘 {
    public static void main(String[] args) {

    }
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String res = "";
        int cnt = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            res = add(res, mult(num2, num1.charAt(i), cnt));
            cnt++;
        }
        return res;
    }

    public String mult(String num, char c, int cnt){
        StringBuilder sb = new StringBuilder();
        while (cnt-- > 0){
            sb.append("0");
        }
        int i = num.length() - 1;
        int sum = 0;
        while (i >= 0 || sum > 0){
            if (i >= 0){
                sum += (num.charAt(i--) - '0') * (c - '0');
            }
            sb.append(sum % 10);
            sum /= 10;
        }
        return sb.reverse().toString();
    }

    public String add(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int num = 0;
        while (i >= 0 || j >= 0 || num > 0){
            int a = 0, b = 0;
            if (i >= 0){
                a = num1.charAt(i--) - '0';
            }
            if (j >= 0){
                b = num2.charAt(j--) - '0';
            }
            num += a + b;
            sb.append(num % 10);
            num /= 10;
        }
        return sb.reverse().toString();
    }
}
