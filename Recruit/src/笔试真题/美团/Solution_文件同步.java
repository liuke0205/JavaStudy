package 笔试真题.美团;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/3/19 11:59
 */
public class Solution_文件同步 {
    /**
     *  小团觉得每天把自己25斤重的游戏本在家和公司之间来回青的这一行为效事过于低下，于量他决定将自己2的台老爷帆
     *  放在公司。经过时间的推移，小团意识到同步不同机器上同一份文件的重要性，为了使多台电脑上文件的版本一致，
     *  小团使用了一个版本管理软件进行同步，该软件会比较文件之间的差别并汇报冲突，所有冲突都被解决才能完成同
     *  步。比如在上-次同步之后，小团将A机器上的文件1修改成了版本f1,并在1没有同步到B机器 上时将B机器上的文件1
     *  修改成了版本f2,则版本管理软件会检测到这一冲突并汇报给小团。 否则版本管理软件会直接使用新版的文件覆盖另
     *  一台机器上的旧版文件，此时不会汇报冲突。
     *  在上一次同步之后，小团修改了他的游戏本上的许多文件和老爷机上的许多文件。现在给出这些被情改的文件的编
     *  号，请你求出版本管理软件会汇报多少个文件的冲突。
     *
     *  输入描述：
     *  第一行有三个正整数， n(1<=n<=1000000000), m1（1<=m1<=30000）, m2（1<=m2<=30000）
     *  代表文件总数，游戏本上的文件被修改了多少次，以及老爷机上的文件被修改了多少次。
     *  文件编号为1-n小团的每次修改都会影响到编号属于一个连续区间中的所有文件。
     *  第二行和第三行中各有m1个正整数，代表游戏本上每次修改被影响到的文件范围。第二行中的m个数代表m1
     *  次修改中的左端点，第三行中的m1个数代表m1次修改的右端点。
     *  第四行和第五行中各有m2个正整数，代表老爷机上每次修改被影响到的文件范围。第二行中的m2个数代表m2
     *  次修改中的左端点，第三行中的m2个数代表m2次修改的右端点。
     *
     *  输出描述：
     *  输出小国的版本管理牧许会汇报多少个冲突。即有多少个文件在老爷机和游戏本上都修改过。
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m1 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int[][] arr1 = new int[m1][2];
        int[][] arr2 = new int[m2][2];
        for (int i = 0; i < m1; i++) {
            arr1[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < m1; i++) {
            arr1[i][1] = scanner.nextInt();
        }
        for (int i = 0; i < m2; i++) {
            arr2[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < m2; i++) {
            arr2[i][1] = scanner.nextInt();
        }
        Arrays.sort(arr1, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(arr2, Comparator.comparingInt(a -> a[0]));
        System.out.println(fun(n, arr1, arr2));
    }

    private static int fun(int n, int[][] arr1, int[][] arr2) {
        int i = 0, j = 0;
        int res = 0;
        while (i < arr1.length && j < arr2.length){
            // 两个区间的最大左边界
            int max_left = Math.max(arr1[i][0], arr2[j][0]);
            // 两个区间的最小右边界
            int min_right = Math.min(n, Math.min(arr1[i][1], arr2[j][1]));
            if (max_left <= min_right){
                res += min_right - max_left + 1;
            }
            if (arr1[i][1] < arr2[j][1]){
                i++;
            }else {
                j++;
            }
        }
        return res;
    }
}
