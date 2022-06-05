package 笔试真题.Shoope;

/**
 * @author liuke
 * @date 2022/6/4 17:54
 */
public class Main_掰花瓣 {
    /**
     * https://www.nowcoder.com/questionTerminal/10bf01da91914c01b0035d7c8648cf05
     * @param args
     */
    public static void main(String[] args) {

    }
    public int petalsBreak (int[] petals) {
        // write code here
        int sum = 0;
        for (int i = 0; i <petals.length; i++) {
            if (petals[i] % 2 == 0){
                sum += petals[i] / 2;
            }else {
                sum += petals[i] / 2 + 1;
            }
        }
        return sum;
    }
}
