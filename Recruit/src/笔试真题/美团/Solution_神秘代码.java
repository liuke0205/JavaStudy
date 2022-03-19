package 笔试真题.美团;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;
import javafx.scene.transform.Scale;

import java.util.Scanner;

/**
 * @author liuke
 * @date 2022/3/19 10:01
 */
public interface Solution_神秘代码 {
    /**
     * 第二題：神秘代码！！！！！！！！！！！！！！
     * @param args
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        String str = scanner.next();
        String result = null;
        switch (t){
            case 1: result = encryption(str);break;
            case 2: result = decrypt(str);break;
        }
        System.out.println(result);
    }

    /**
     * 加密过程
     * @param str
     * @return 加密结果
     *         // abcdefg -加密> dcebfag
     *         // abcdef -加密> cdbeaf
     */
    static String encryption(String str) {
        int len = str.length();
        int i = (len - 1) / 2;
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        sb.append(str.charAt(i));
        while (i - idx >= 0 || i + idx <= len - 1){
            if (len % 2 == 0){
                if (i + idx <= len - 1){
                    sb.append(str.charAt(i + idx));
                }
                if (i - idx >= 0){
                    sb.append(str.charAt(i - idx));
                }
            }else {
                if (i - idx >= 0){
                    sb.append(str.charAt(i - idx));
                }
                if (i + idx <= len - 1){
                    sb.append(str.charAt(i + idx));
                }
            }
            idx++;
        }
        return sb.toString();
    }

    /**
     * 解密过程
     * @param str
     * @return 解密结果    没问题，，  加密还有点问题
     */
    static String decrypt(String str) {
        StringBuilder sb = new StringBuilder();
        int i = str.length() - 2;
        while (i >= 0){
            sb.append(str.charAt(i));
            i -= 2;
        }
        int j = (str.length() % 2 == 0) ? 1 : 0;
        while (j < str.length()){
            sb.append(str.charAt(j));
            j += 2;
        }
        return sb.toString();
    }
}
