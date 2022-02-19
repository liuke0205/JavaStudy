package com.liuke.case3;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author liuke
 * @date 2022/2/18 0:24
 */
public class CuratorLock {
    public static void main(String[] args) {
        // 创建分布式锁1
        InterProcessMutex lock1 = new InterProcessMutex(getCuratorFrameWork(), "/locks");

        InterProcessMutex lock2 = new InterProcessMutex(getCuratorFrameWork(), "/locks");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock1.acquire();
                    System.out.println("线程1 获取到锁！");
                    Thread.sleep(2000);
                    lock1.release();
                    System.out.println("线程1 释放锁！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock2.acquire();
                    System.out.println("线程2 获取到锁！");
                    Thread.sleep(2000);
                    lock2.release();
                    System.out.println("线程2 释放锁！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static CuratorFramework getCuratorFrameWork() {
        ExponentialBackoffRetry policy = new ExponentialBackoffRetry(3000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString("127.0.0.1:2181").connectionTimeoutMs(20000)
                .sessionTimeoutMs(20000)
                .retryPolicy(policy).build();

        client.start();
        System.out.println("zookeeper 启动成功！");
        return client;
    }
}
