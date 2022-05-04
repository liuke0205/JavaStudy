package 笔试真题.腾讯;

import java.util.*;


public class Main2_tengxun {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a int整型一维数组 
     * @return int整型
     */
    public int getNumber (int[] a) {
        Set<Integer> ans = countPrimes(a.length);
        List<Integer> list = new ArrayList<>();
        for (int j : a) {
            list.add(j);
        }
        while (list.size() > 1){
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (ans.contains(i+1)) {
                    cur.add(list.get(i));
                }
            }
            list = new ArrayList<>(cur);
        }
        return list.get(0);
    }

    public Set<Integer> countPrimes(int n){
        List<Integer> primes = new ArrayList<>();
        Set<Integer> ans = new HashSet<>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1){
                primes.add(i);
                ans.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0){
                    break;
                }
            }
        }
        return ans;
    }
}