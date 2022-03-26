package 笔试真题.网易;

/**
 * @author liuke
 * @date 2022/3/27 0:03
 */
public class PV操作 {
    static boolean[] flag = new boolean[2];
    static int trun = 0;
    public static void main(String[] args) {

    }

    void P0(){
        while (true){
            flag[0] = true;
            trun = 1;
            while (flag[1] && (trun == 1));
            // 临界区
            flag[0] = false;
        }
    }

    void P1(){
        while (true){
            flag[1] = true;
            trun = 1;
            while (flag[0] && (trun == 1));
            // 临界区
            flag[1] = false;
        }
    }

}
