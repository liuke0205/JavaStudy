import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/4/5 13:16
 */
public class  Solution_G回文日期 {
    static boolean isFlag1, isFlag2;
    static int[] month = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        //  10000101
        Scanner scanner = new Scanner(System.in);
        String str1 = null, str2 = null;
        int date = Integer.parseInt(scanner.nextLine());
        for (int i = date + 1; i < 89991231; i++) {
            String str = String.valueOf(i);
            if (check(str)){
                if (isFlag1 && isFlag2){
                    break;
                }
                if (!isFlag1){
                    if (isHuiWen(str)){
                        str1 = str;
                        isFlag1 = true;
                    }
                }
                if (!isFlag2){
                    if (isABABBABA(str)){
                        str2 = str;
                        isFlag2 = true;
                    }
                }
            }
        }
        System.out.println(str1);
        System.out.println(str2);
    }

    private static boolean check(String date) {
        int y = Integer.parseInt(date.substring(0, 4));
        int m = Integer.parseInt(date.substring(4, 6));
        int d = Integer.parseInt(date.substring(6, 8));

        if ((y % 4 == 0 && y % 100 != 0) || y% 400  == 0) {
            month[2] = 29;
        }else {
            month[2] = 28;
        }
        return y >= 1000 && y <= 9000 &&
                m >= 1 && m <= 12 &&
                d >= 1 && d <= month[m];
    }

    public static boolean isHuiWen(String str){
        int i = 0,j = str.length() - 1;
        while (i < j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isABABBABA(String str){
        if (!isHuiWen(str)){
            return false;
        }
        char a = str.charAt(0), b = str.charAt(1);
        return a == str.charAt(2) && a == str.charAt(5) && a == str.charAt(7)
                && b == str.charAt(3) && b == str.charAt(4) && b == str.charAt(6);
    }
}
