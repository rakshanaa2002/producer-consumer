import java.util.Random;
public class producer extends Thread{
    share share;
    int producerNum;
    public producer(share share,int producerNum)
    {
        this.share=share;
        this.producerNum=producerNum;
    }
    @Override
    public void run()
    {
        try
        {
            while(true){
                synchronized(share){
                    while(share.data.size()>=10)
                        share.wait();
                    Random random=new Random();
                    int value=random.nextInt(100);
                    share.data.add(value);
                    System.out.println(producerNum+" Produced --> "+value);
                    share.notifyAll();
                }
                Thread.sleep(1000);
            }            
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
