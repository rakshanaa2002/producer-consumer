public class consumer extends Thread
{
    share share;
    int consumerNum;

    public consumer(share share, int consumerNum){
        this.share=share;
        this.consumerNum=consumerNum;
    }

    @Override
    public void run() {
        // try
        // {
            synchronized(share)
                {
            while (true) 
            {
                
                //     while(share.data.isEmpty())
                //          share.wait();
                    Integer value = share.data[share.top];
                    System.out.println(consumerNum+" Consumed --> "+value+share.top);
                    share.top--;
        //             Thread.sleep(50);
        //             share.notifyAll();
                }
        //     }
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        }
    }
}
