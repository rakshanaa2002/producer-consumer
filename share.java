// import java.util.concurrent.ArrayBlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class share
{
    // ArrayBlockingQueue<Integer> data=new ArrayBlockingQueue<>(10);
    ReentrantLock lock=new ReentrantLock();
    Condition full=lock.newCondition();
    Condition empty=lock.newCondition();
    int[] data=new int[100];
    int top=0;
    public static void main(String[] args)
    {
        share share=new share();
        int producerNum=3;
        int consumeNum=6;
        ExecutorService executor =Executors.newFixedThreadPool(producerNum+consumeNum);
        for (int i=1;i<=producerNum;i++) {
            producer producer=new producer(share,i);
            executor.submit(producer);
        }
        for (int i=1;i<=consumeNum;i++) {
            consumer consumer=new consumer(share,i);
            executor.submit(consumer);
        }
        executor.shutdown();
    }
}
