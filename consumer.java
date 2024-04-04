public class consumer extends Thread
{
    share share;
    int consumerNum;

    public consumer(share share, int consumerNum){
        this.share=share;
        this.consumerNum=consumerNum;
    }

    @Override
    public void run()
    {
        while (true)
        {
            try
            {
                share.lock.lock();
                while(share.top<=0){
                    share.empty.await();
                }
                int value = share.data[--share.top];
                System.out.println(consumerNum+" Consumed --> "+value);
                share.full.signal();
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
