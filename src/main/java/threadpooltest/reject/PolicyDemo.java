package threadpooltest.reject;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * threadpoolpolicy测试
 * @author cailin
 *
 */
public class PolicyDemo {

    public static void main(String[] args) {

        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(1));

        // pool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//直接抛出异常
//        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy()); //task-0,task-1 running
//      pool.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());//task-0,task9 running
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
//        task-2 is running.
//        task-0 is running.
//        task-3 is running.
//        task-1 is running.
//        task-5 is running.
//        task-4 is running.
//        task-7 is running.
//        task-6 is running.
//        task-9 is running.
//        task-8 is running.


        try {
            // 新建10个任务，并将它们添加到线程池中
            for (int i = 0; i < 10; i++) {
//                Runnable myTask = new Task("task-"+i);
                Runnable myTask =  new Task("task-"+i);
                pool.execute(myTask);
            }
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
            // 关闭线程池
            pool.shutdown();
        }
    }
}