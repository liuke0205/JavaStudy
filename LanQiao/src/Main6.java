import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/4/9 0:20
 */
public class Main6 {
    public static void main(String[] args) {
        int day_ms = 24 * 60 * 60 * 1000;
        Scanner scanner = new Scanner(System.in);
        long time = scanner.nextLong();
        long ms = time % day_ms;
        long h = (ms / (60 * 60 * 1000)) % 24;
        long m = (ms / (60 * 1000)) % 60;
        long s = (ms / 1000) % 60;
        System.out.println(String.format("%02d", h) + ":" + String.format("%02d", m) + ":" + String.format("%02d", s));
    }
}
