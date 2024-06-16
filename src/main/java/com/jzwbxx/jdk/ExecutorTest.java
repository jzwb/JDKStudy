package com.jzwbxx.jdk;

import java.util.concurrent.Executor;

/**
 * 任务执行
 * 将提交任务和任务执行机制分离出来
 */
public class ExecutorTest {

    public static void main(String[] args) {
        Executor myExecutor = new MyExecutor();
        // 提交任务
        myExecutor.execute(() -> {
            System.out.println("do something");
        });
    }


    static class MyExecutor implements Executor {
        @Override
        public void execute(Runnable command) {
            //任务执行
            System.out.println("MyExecutor execute...");
            command.run();
        }
    }
}