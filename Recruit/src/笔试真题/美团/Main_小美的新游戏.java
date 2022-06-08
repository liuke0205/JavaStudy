package 笔试真题.美团;

import javax.sql.rowset.BaseRowSet;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/6/8 23:00
 */
public class Main_小美的新游戏 {
    /**
     * https://www.nowcoder.com/questionTerminal/79bf0fa54f094f0fb2dee942b1ecc359
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int p = scanner.nextInt(), q = scanner.nextInt();
        scanner.nextLine();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = scanner.nextLine().toCharArray();
        }
        int x = 0, y = 0;//机器人的初始坐标
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (chars[i][j] == 'S'){
                    x = i;
                    y = j;
                }
            }
        }
        char[] query = scanner.nextLine().toCharArray();
        int score = 0;
        for (int i = 0; i < query.length; i++) {
            switch (query[i]){
                case 'W': x-=1;break;
                case 'A': y-=1;break;
                case 'S': x+=1;break;
                case 'D': y+=1;break;
            }
            if (x < 0 || y < 0 || x >= n || y >= m || chars[x][y] == '#'){
                switch (query[i]){
                    case 'W': x+=1;break;
                    case 'A': y+=1;break;
                    case 'S': x-=1;break;
                    case 'D': y-=1;break;
                }
                continue;
            }
            switch (chars[x][y]){
                case 'O': score+=p; chars[x][y] = '+'; break;
                case 'X': score-=q; chars[x][y] = '+'; break;
            }
        }
        System.out.println(score);
    }
}
