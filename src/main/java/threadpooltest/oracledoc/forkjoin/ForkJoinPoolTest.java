package threadpooltest.oracledoc.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {
    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        // 计算 10 亿项，分割任务的临界值为 1 千万
        PiEstimateTask task = new PiEstimateTask(0, 1_000_000_000, 10_000_000);

        double pi = forkJoinPool.invoke(task); // 阻塞，直到任务执行完毕返回结果

        System.out.println("π 的值：" + pi);

        forkJoinPool.shutdown(); // 向线程池发送关闭的指令
    }
}
