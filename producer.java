import java.util.Random;

public class producer extends Thread {
    share share;
    int producerNum;

    public producer(share share, int producerNum) {
        this.share = share;
        this.producerNum = producerNum;
    }

    @Override
    public void run()
    {
        // try
        // {
            Random random=new Random();
            synchronized(share){
            while(true)
            {
                
                //     if(share.data.size()>=10){
                //         Thread.sleep(10);
                //     }
                    // else{
                        int value=random.nextInt(10);
                        share.data[share.top++]=value;
                        System.out.println(producerNum+" Produced --> "+value);
                        // share.notifyAll();
                        // Thread.sleep(500);
                    }
                        
                 }
            // }
        // }
        // catch (InterruptedException e)
        // {
        //     e.printStackTrace();
        // }
    }
}
