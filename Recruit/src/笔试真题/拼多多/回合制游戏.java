package 笔试真题.拼多多;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/5/22 0:56
 */
public class 回合制游戏 {
    /**
     * https://www.nowcoder.com/questionTerminal/17a083854661490e85e5bb6c4b26e546
     *
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int HP = scanner.nextInt();
        int normalAttack = scanner.nextInt();
        int buffedAttack = scanner.nextInt();
        if (buffedAttack > 2 * normalAttack){
            int num = HP % buffedAttack;
            int res = HP / buffedAttack * 2;
            if (num == 0){
                System.out.println(res);
            }else if (num <= normalAttack){
                System.out.println(1 + res);
            }else {
                System.out.println(res + 2);
            }
        }else {
            int res = (HP % normalAttack == 0) ? HP / normalAttack : HP / normalAttack + 1;
            System.out.println(res);
        }
    }
}
