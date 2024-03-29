public class consumer extends Thread
{
    share share;
    int consumerNum;
    public consumer(share share, int consumerNum)
    {
        this.share=share;
        this.consumerNum=consumerNum;
    }
    @Override
    public void run()
    {
        try
        {
            while (true)
            {
                while(share.data.isEmpty())
                    Thread.sleep(1);
                int value = share.data.remove();
                System.out.println(consumerNum+" Consumed --> "+value);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
