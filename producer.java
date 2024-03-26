import java.util.Random;
public class producer extends Thread{
    share s;
    public producer(share s)
    {
        this.s=s;
    }
    @Override
    public void run()
    {
        try
        {
            Random r=new Random();
            int val=r.nextInt(100);
            s.pro(val);
            System.out.println("Produced-->"+val);
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
