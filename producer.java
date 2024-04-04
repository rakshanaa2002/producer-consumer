import java.util.Random;

public class producer extends Thread
{
    share share;
    int producerNum;

    public producer(share share, int producerNum){
        this.share = share;
        this.producerNum = producerNum;
    }

    @Override
    public void run()
    {
        Random random=new Random();
        while(true)
        {
            try
            {
                share.lock.lock();
                while(share.top>=10){
                    share.full.await();
                }
                int value=random.nextInt(100);
                share.data[share.top]=value;
                share.top+=1;
                System.out.println(producerNum+" Produced --> "+value);
                share.empty.signal();
            }    
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            finally{
                share.lock.unlock();
            }
        }
    }
}
