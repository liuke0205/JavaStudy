package 笔试真题.华为;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_删数 {
    /**
     * https://www.nowcoder.com/questionTerminal/f9533a71aada4f35867008be22be5b6e
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            int idx = 0;
            while (list.size() > 1){
                idx = (idx + 2) % list.size();
                list.remove(idx);
            }
            System.out.println(list.get(0));
        }
    }
}
