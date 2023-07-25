package charpter5_queue_map;

import java.util.LinkedList;
import java.util.Queue;

public class homework {


    public static void main(String[] args) {
        Queue<Integer> newQueue=new LinkedList<>();
        Queue<Integer> finishQueue=new LinkedList<>();
        //1.向NewQueue里写入新需求：1 2 3 4 5
        for (int i=1;i<=5;i++){
            newQueue.offer(i);
        }
        printQueue(newQueue, finishQueue);

        //2.程序员将1 2 3从NewQueue出队，并写入到FinishQueue中
        finishQueue.offer(newQueue.poll());
        finishQueue.offer(newQueue.poll());
        finishQueue.offer(newQueue.poll());

        printQueue(newQueue,finishQueue);

        //3.产品经理写入新需求，6 7 8 9 10
        for (int i = 6; i <=10; i++) {
            newQueue.offer(i);
        }
        printQueue(newQueue,finishQueue);

        //4.程序员将 4 5 6 7 从NewQueue出队，并写入FinishQueue中
        finishQueue.offer(newQueue.poll());
        finishQueue.offer(newQueue.poll());
        finishQueue.offer(newQueue.poll());
        finishQueue.offer(newQueue.poll());

        printQueue(newQueue,finishQueue);
    }

    public static void printQueue(Queue<Integer> newQueue, Queue<Integer> finishQueue) {
        for (Integer num : newQueue) {
            System.out.println(num);
        }
        for (Integer num : finishQueue) {
            System.out.println(num);
        }
    }
}
