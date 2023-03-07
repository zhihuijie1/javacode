package P5;

import com.sun.org.apache.regexp.internal.RE;

public class demo {
    /*
        给定一个很长的数组 (长度 1000w), 通过随机数的方式生成 1-100 之间的整数.
        实现代码, 能够创建两个线程, 对这个数组的所有元素求和.
        其中线程1 计算偶数下标元素的和, 线程2 计算奇数下标元素的和.
        最终再汇总两个和, 进行相加
        记录程序的执行时间.
    */
    public static <lock> void main(String[] args) throws InterruptedException {
        int[] arr = new int[1000_0000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 + 1);
        }
        Object lock = new Object(); // 初始化锁对象
        long a = 0;
        long b = 0;
        long begin = System.currentTimeMillis();
        Thread t1 = new Thread(new Runnable() {
            long temp = 0;

            @Override
            public void run() {
                for (int i = 1; i < arr.length; i = i + 2) {
                    temp = temp + arr[i];
                }
            }

            /**
             * synchronized (lock)
             *             {
             *                 a = a + temp;
             *             }
             */
        });

        Thread t2 = new Thread(new Runnable() {
            long temp = 0;

            @Override
            public void run() {
                for (int i = 1; i < arr.length; i = i + 2) {
                    temp = temp + arr[i];
                }
            }

            /**
             * synchronized (lock)
             *
             *             {
             *                 b = b + temp;
             *             }
             */
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long end = System.currentTimeMillis();
        System.out.println(a + b);
        System.out.println(end - begin);

    }
}

