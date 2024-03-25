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
        for(int i=1;i<=10;i++){
            Random r=new Random();
            int val=r.nextInt(1000);
            s.pro(val);
            System.out.println("Produced-->"+val);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}