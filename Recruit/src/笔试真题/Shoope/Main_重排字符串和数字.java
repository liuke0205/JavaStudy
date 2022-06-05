package 笔试真题.Shoope;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author liuke
 * @date 2022/6/3 23:51
 */
public class Main_重排字符串和数字 {
    /**
     * https://www.nowcoder.com/questionTerminal/70be97a0060c474ebf5b2edce171f0ec
     *
     */
    public String char_and_num_return (String text_source) {
        String[] strs = text_source.split(" ");
        ArrayList<Long> nums = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            try {
                long num = Long.parseLong(strs[i]);
                nums.add(num);
            }catch (Exception e){
                sb.append(strs[i]).append(" ");
            }
        }
        Collections.sort(nums);
        for (int i = 0; i < nums.size(); i++) {
            sb.append(nums.get(i)).append(" ");
        }
        return sb.toString().trim();
    }
}
