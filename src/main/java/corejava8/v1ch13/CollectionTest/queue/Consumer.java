package corejava8.v1ch13.CollectionTest.queue;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    protected BlockingQueue<Integer> queue = null;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
           System.out.println("get--"+queue.take()+queue.size());
           System.out.println("get--"+queue.take()+queue.size());
           System.out.println("get--"+queue.take()+queue.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}