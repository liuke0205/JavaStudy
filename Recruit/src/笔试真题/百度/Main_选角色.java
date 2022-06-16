package 笔试真题.百度;
import java.util.*;

/**
 * @author liuke
 * @date 2022/6/15 21:58
 */
public class Main_选角色 {
    /**
     * https://www.nowcoder.com/questionTerminal/3bb34509886441bba290bcc99d76b58d
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();//输入需要测试的组数
        //对每一组单独进行循环
        for (int count = 0; count < num; count++) {
            int numOfPerson = sc.nextInt();//输入小伙伴人数
            sc.nextLine();//声明下面两行要输入的字符串
            //接收用户输入的小伙伴期望的戏份时长的字符串，并将其转换为数组
            int[] arrPerson = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            //接收用户输入的剧组还有的戏份时长的字符串，并将其转换为数组
            int[] movie = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] result = new int[numOfPerson];//新建一个数组来存放答案，长度与小伙伴人数一样
            //开始进行匹配
            Arrays.sort(movie);//对movie数组中的数据进行从小到大排序
            //使用二分法进行循环
            //原理就是将arrPerson[i]与排序后的movie使用二分法比较找到左边界
            for (int i = 0; i < numOfPerson; i++) {
                int l = 0;
                int r = movie.length - 1;
                while (l <= r) {
                    int mid = l + (r - l) / 2;
                    if (arrPerson[i] <= movie[mid])
                        r = mid - 1;
                    if (arrPerson[i] > movie[mid])
                        l = mid + 1;
                }
                result[i] = movie.length - l;//数组长度-左边界，得到所有大于arrPerson[i]的个数
            }
            //现在拿到了结果数组result[]，将数组转换成字符串输出
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < numOfPerson; j++) {
                sb.append(result[j] + " ");
            }
            //删除最后一位数字后面的空格，因为添加数字的时候格式是【数字+空格】
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
