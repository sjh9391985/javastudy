package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

	public static void main(String[] args) {
		
		Queue<String> q = new LinkedList<String>();
		
		q.offer("마이콜");
		q.offer("또치");
		q.offer("도우너");
		
		while(!q.isEmpty()) {
			String s = q.poll();
			System.out.println(s);
		}
		System.out.println("===================");
		
		q.offer("마이콜");
		q.offer("또치");
		q.offer("도우너");
	
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
		
	}
}
