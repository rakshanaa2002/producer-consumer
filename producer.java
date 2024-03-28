import java.util.Random;
public class producer extends Thread
{
    share share;
    int producerNum;
    public producer(share share, int producerNum)
    {
        this.share=share;
        this.producerNum=producerNum;
    }
    @Override
    public void run()
    {
        try {
            Random random=new Random();
            while (true)
            {
                if(share.data.size()>5)
                {
                    Thread.sleep(1);
                }
                else
                {
                    int value=random.nextInt(100);
                    share.data.add(value);
                    System.out.println(producerNum+" Produced --> "+value);
                    Thread.sleep(10);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
