package guosai;

/**
 * @author liuke
 * @date 2022/5/26 13:37
 */
public class B_含2天数 {
    public static void main(String[] args) {
        int[] m = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int cnt = 0;
        for (int year = 1900; year <= 9999; year++) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                m[2] = 29;
            }else {
                m[2] = 28;
            }
            for (int month = 1; month <= 12; month++) {
                for (int day = 1; day <= m[month]; day++) {
                    if (isEqual2(year, month, day)){
//                        System.out.printf("%d:%d:%d", year, month, day);
//                        System.out.println();
                        cnt++;
                    }
                }
            }
        }
        // 1994240
        System.out.println(cnt);
    }

    private static boolean isEqual2(int year, int month, int day) {
        if (year % 10 == 2 || year / 10 % 10 == 2 || year / 100 % 10 == 2 || year / 1000 % 10 == 2){
            return true;
        }
        if (month == 2 || month == 12){
            return true;
        }
        if (day == 2 || (day > 10 && (day % 10 == 2 || day / 10 % 10 == 2))){
            return true;
        }
        return false;
    }
}
