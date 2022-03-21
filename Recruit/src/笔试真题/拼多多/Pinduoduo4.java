package 笔试真题.拼多多;

import java.util.Arrays;
import java.util.Scanner;


public class Pinduoduo4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            String res = fun(n, k, s);
            if(res == null) System.out.println(-1);
            else System.out.println(res);
        }
    }

    private static String fun(int n, int k, String s){
        int[] cnt = new int[27];
        for(int i=0; i<n; i++)
            cnt[s.charAt(i) - 'a']++;

        int sum = 0, flag = 1;
        for(int i=0; i<=25; i++)
            sum += get(cnt[i], k);

        if(sum == 0) return s;
        else if(n%k != 0) return null;
        else{
            StringBuilder sb = new StringBuilder();
            for(int i=n-1;i>=0;i--){
                sum = sum - get(cnt[s.charAt(i)-'a'], k) + get(--cnt[s.charAt(i)-'a'], k);
                for(int j=s.charAt(i)-'a'+1; j<=25; j++) //枚举放哪个字母
                {
                    int las = sum;
                    sum = sum - get(cnt[j], k) + get(++cnt[j], k);
                    if((i+1)+sum <= n)
                    {
                        for(int pos=0; pos<i; pos++)
                            sb.append(s.charAt(pos));
                        sb.append((char)(j + 'a'));
                        for(int pos=1;pos<=n-sum-(i+1);pos++)
                            sb.append('a');
                        for(int w=0;w<=25;w++)
                        {
                            int f = get(cnt[w], k);
                            while(f != 0){
                                f--;
                                sb.append((char)(w + 'a'));
                            }
                        }
                        flag = 0;
                        break;
                    }
                    cnt[j]--; sum = las;
                }
                if(flag == 0)  break;
            }
            return sb.toString();
        }
    }

    private static int get(int x, int k){
        return (k - x%k) % k;
    }
}