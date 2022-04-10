package 贪心;

/**
 * @author liuke
 * @date 2022/4/7 0:34
 */
public class Solution860_柠檬水找零 {
    /**
     * https://leetcode-cn.com/problems/lemonade-change/
     */
    public boolean lemonadeChange(int[] bills) {
        int cnt_5 = 0, cnt_10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5){
                cnt_5++;
            }else if (bills[i] == 10){
                cnt_5--;
                cnt_10++;
                if (cnt_5 < 0){
                    return false;
                }
            }else {
                if (cnt_10 > 0 && cnt_5 > 0){
                    cnt_5--;
                    cnt_10--;
                }else if (cnt_5 >= 3){
                    cnt_5-=3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
