package 笔试真题.腾讯;

import java.util.*;

public class Main_最小代价2 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]tmp= new int[n][2];
        for(int i = 0;i<n;i++){
            tmp[i][0]=sc.nextInt();
        }
        for(int i = 0;i<n;i++){
            tmp[i][1]= sc.nextInt();
        }
        Arrays.sort(tmp,new Comparator<int []>(){
            public int compare(int[]o1,int[]o2){
                if(o1[0]==o2[0])return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer o1,Integer o2){
                return o2-o1;
            }
        });
        int cur = tmp[0][0];
        long all = 0;
        long ans = 0;
        for(int[]price:tmp){
            if(!queue.isEmpty() && price[0]!=cur){
                while(!queue.isEmpty() && price[0]!=cur++){
                    all -= queue.poll();
                    ans+=all;
                }
                cur=price[0];
            }
            queue.add(price[1]);
            all+=price[1];
        }
        while(!queue.isEmpty()){
            all-=queue.poll();
            ans+=all;
        }
        System.out.println(ans);
    }
}