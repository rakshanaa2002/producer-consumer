
public class consumer extends Thread {
    share s;
    public consumer(share s)
    {
        this.s=s;
    }
    @Override
    public void run()
    {
        for(int i=1;i<=10;i++){
            try {
                int v=s.con();
                System.out.println("Consumed-->"+v);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
