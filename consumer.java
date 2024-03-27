public class consumer extends Thread {
    share share;
    int consumerNum;
    public consumer(share share,int consumerNum)
    {
        this.share=share;
        this.consumerNum=consumerNum;
    }
    @Override
    public void run()
    {
        try{
            while(true){
                synchronized(share){
                    while(share.data.isEmpty())
                        share.wait();
                    int value=share.data.poll();
                    System.out.println(consumerNum+" Consumed --> "+value);
                    share.notifyAll();
                }
                Thread.sleep(1000);
            }   
        } 
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
