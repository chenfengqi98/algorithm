package com.os;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author chen
 * @date 2022/2/10
 * @desc 哲学家进餐
 */
public class DiningPhilosophers implements Runnable {

    private final int id;

    private static final Random random = new Random(System.currentTimeMillis());

    private static final Semaphore[] forks = new Semaphore[5];

    // 初始化信号量,每个信号量为1，代表1只筷子
    static {
        forks[0] = new Semaphore(1);
        forks[1] = new Semaphore(1);
        forks[2] = new Semaphore(1);
        forks[3] = new Semaphore(1);
        forks[4] = new Semaphore(1);
    }

    public DiningPhilosophers(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eat() throws InterruptedException {
        // 拿左边的筷子
        forks[id].acquire();
        // 拿右边的筷子
        forks[(id + 4) % 5].acquire();
        System.out.println("哲学家+" + id + "正在吃饭~");
        TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
        System.out.println("哲学家+" + id + "吃完了~");
        forks[id].release();
        forks[(id + 4) % 5].release();
    }

    public void think() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new DiningPhilosophers(i)).start();
        }
    }
}
