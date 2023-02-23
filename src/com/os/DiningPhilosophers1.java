package com.os;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author 小黑说Java
 * @ClassName DiningPhilosophers
 * @Description 哲学家就餐问题
 * @date 2022/2/6
 **/
public class DiningPhilosophers1 implements Runnable {

    private final int id;

    public DiningPhilosophers1(int id) {
        this.id = id;
    }

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

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat(id);
            }
        } catch (InterruptedException e) {
        }
    }

    /**
     * 哲学家思考随机时间
     */
    private void think() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(100));
    }

    private void eat(int id) throws InterruptedException {
        // 先拿左边的筷子
        forks[id].acquire();

        // 然后拿右边的筷子
        forks[(id + 4) % 5].acquire();

        // 吃一口饭
        System.out.println("哲学家" + id + "正在吃饭~");
        // 依次放下左边的筷子和右边的筷子
        forks[id].release();
        forks[(id + 4) % 5].release();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new DiningPhilosophers1(i)).start();
        }
    }
}
