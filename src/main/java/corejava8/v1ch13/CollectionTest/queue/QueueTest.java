package corejava8.v1ch13.CollectionTest.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList();
		BlockingQueue<Integer> queue = new ArrayBlockingQueue(1024);
		for(int i=0;i<100;i++){
			list.add(i);
		}
		queue.addAll(list);
		for (int i = 0; i < queue.size(); i++) {
			System.out.println(queue.offer(i));

		}
		for (Integer i : queue) {
			System.out.println("+++" + i);
		}
	
	}

}
