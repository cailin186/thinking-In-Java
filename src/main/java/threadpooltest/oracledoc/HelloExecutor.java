package threadpooltest.oracledoc;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class HelloExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list1=  new LinkedList<>();
        List<Integer> list2=  new LinkedList<>();
        for(int i=0;i<1000;i++){
            list1.add(i);
            list2.add(i);
        }
        System.out.println(getTotal(list1,list2));

        testFuture2();

        testAsynThread();

    }

    private static void testCallable() {
        int taskSize = 5;
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        Future f = pool.submit(new Callable<Object>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "hellocall";
            }
        });

        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("hellocallend");
    }

    public static int getTotal(final List<Integer> a, final List<Integer> b) throws ExecutionException, InterruptedException {
        Future<Integer> future = Executors.newCachedThreadPool().submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int r = 0;
                for (int num : a) {
                    r += num;
                }
                return r;
            }
        });

        int r = 0;
        for (int num : b) {
            r += num;
        }
        return r + future.get();
    }

    /**
     * 异步执行,但是能返回结果
     */
    public static void testFuture2(){
        long start = System.currentTimeMillis();

        // 等凉菜
        Callable ca1 = new Callable(){

            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "凉菜准备完毕";
            }
        };
        FutureTask<String> ft1 = new FutureTask<String>(ca1);
        new Thread(ft1).start();

        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Callable ca2 = new Callable(){

            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(1000*3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "包子准备完毕";
            }
        };
        FutureTask<String> ft2 = new FutureTask<String>(ca2);
        new Thread(ft2).start();

        try {
            System.out.println(ft1.get());
            System.out.println(ft2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));

    }

    /**
     * 采用线程的方式异步执行两个任务,速度比future快
     */
    public static void  testAsynThread(){
        long start =  System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程1休眠1s");

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2休眠2s");

            }
        }).start();

        System.out.println("采用线程的方式用了多长时间:" + (System.currentTimeMillis()-start));



    }



}
