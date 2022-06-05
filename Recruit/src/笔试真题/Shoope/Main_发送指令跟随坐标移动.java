package 笔试真题.Shoope;

/**
 * @author liuke
 * @date 2022/6/4 16:21
 */
public class Main_发送指令跟随坐标移动 {
    /**
     * https://www.nowcoder.com/questionTerminal/5507711a5a984a9782dd3ab965a4cbbd
     * @param args
     */
    public static void main(String[] args) {
        int[] res = GetEndPoint("1000a1000d1000w900s");
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] GetEndPoint (String order) {
        order = order.toUpperCase();
        int num = 0;
        int x = 0, y = 0;
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (c >= '0' && c <= '9'){
                num = num * 10 +(c - '0');
            }else {
                if (num == 0){
                    num = 1;
                }
                switch (c){
                    case 'W': y += num;break;
                    case 'S': y -= num;break;
                    case 'A': x-= num; break;
                    case 'D': x+= num; break;
                }
                num = 0;
            }
        }
        return new int[]{x, y};
    }
}
