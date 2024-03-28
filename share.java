import java.util.concurrent.ArrayBlockingQueue;
public class share
{
    ArrayBlockingQueue<Integer> data = new ArrayBlockingQueue<>(10);
    public static void main(String[] args)
    {
        share share=new share();
        int producerNum=5;
        int consumerNum=6;
        for (int i=1;i<=producerNum;i++)
        {
            producer producer=new producer(share,i);
            producer.start();
        }
        for (int i=1;i<=consumerNum;i++)
        {
            consumer consumer=new consumer(share,i);
            consumer.start();
        }
    }
}
