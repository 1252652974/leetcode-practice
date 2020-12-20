package leetcode.Multithreading;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @ClassName: ZeroEvenOdd
 * @description: 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 * @author: liuliang
 * @create: 2020-12-20 10:25
 */
public class ZeroEvenOdd {
    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }
    Semaphore s0 = new Semaphore(1);
    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(0);


    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            s0.acquire();
            printNumber.accept(0);
            if (i%2 == 0) {
                s1.release();
            } else {
                s2.release();
            }

        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            if (n%2 == 0) {
                s2.acquire();
                printNumber.accept(i);
                s0.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i+=2) {
                if (n%2 == 1) {
                    s1.acquire();
                    printNumber.accept(i);
                    s0.release();
                }
            }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(6);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero1(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "0").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even1(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "jishu").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd1(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "oushu").start();
    }
    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);


    public void zero1(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i++){
            zero.acquire();
            printNumber.accept(0);
            if(i%2==1){
                odd.release();
            }else{
                even.release();
            }
        }
    }

    public void even1(IntConsumer printNumber) throws InterruptedException {
        for (int i=2;i<=n;i+=2){
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public void odd1(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2){
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

}
