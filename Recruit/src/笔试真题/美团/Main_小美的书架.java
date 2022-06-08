package 笔试真题.美团;

import java.util.*;

public class Main_小美的书架 {
    /**
     * https://www.nowcoder.com/questionTerminal/b34000b87e92468d86f380dc02c97eb9
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        // 书本，如果为0代表不在书架上，如果非0代表在某个书架上
        int[] book = new int[n + 1];
        // 书架，0代表未加锁，非0代表加锁
        int[] bookShelf = new int[m + 1];
        // 小团手肿的书
        Set<Integer> books = new HashSet<>();
        scanner.nextLine();
        while (q-- > 0){
            String[] strings = scanner.nextLine().split(" ");
            int[] nums = new int[strings.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }
            if (nums[0] == 1){
                int a = nums[1], b = nums[2];
                // 书在小团手上 -> 无效
                if (books.contains(a)){
                    continue;
                }
                // 书在书架上，原行已上锁 -> 无效
                if (book[a] != 0 && bookShelf[book[a]] != 0){
                    continue;
                }
                // 书被放到一个上锁的书架上 -> 无效
                if (bookShelf[b] != 0){
                    continue;
                }
                book[a] = b;
            }else if (nums[0] == 2){
                // 对书架加锁
                int x = nums[1];
                if (bookShelf[x] == 0){
                    bookShelf[x] = 1;
                }
            }else if (nums[0] == 3){
                // 对书架解锁
                int x = nums[1];
                if (bookShelf[x] == 1){
                    bookShelf[x] = 0;
                }
            }else if (nums[0] == 4){
                int x = nums[1];
                if (book[x] != 0 && bookShelf[book[x]] == 0){
                    System.out.println(book[x]);
                    books.add(x);
                    book[x] = 0;
                }else {
                    System.out.println("-1");
                }
            }else {
                int x = nums[1];
                books.remove(x);
            }
        }
    }
}
