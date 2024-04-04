// import java.util.concurrent.ArrayBlockingQueue;

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
        for (int i=1;i<=producerNum;i++)
        {
            producer producer=new producer(share,i);
            producer.start();
        }
        for (int i=1;i<=consumeNum;i++)
        {
            consumer consumer=new consumer(share,i);
            consumer.start();
        }
    }
}
