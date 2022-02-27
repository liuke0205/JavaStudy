import java.util.HashMap;

/**
 * @author liuke
 * @date 2022/2/26 11:32
 */
public class SlidingWindow {
    // 滑动窗口 https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247485141&idx=1&sn=0e4583ad935e76e9a3f6793792e60734&scene=21#wechat_redirect
    public static void slidingWindow(String str){
        int left = 0, right = 0;
        HashMap<Character, Integer> window, need;
        int valid = 0;

        while (right < str.length()){
            // c 是将要移入窗口的字符
            char c = str.charAt(right);
            right++; //窗口右移
            // 进行窗口内数据的一系列更新


            //判断左侧窗口是否要收缩
            while (true){
                // d是将移除窗口的字符
                char d = str.charAt(left);
                //窗口左移
                left++;

                //进行窗口数据的一系列更新


            }
        }
    }
}
