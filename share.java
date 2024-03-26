import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class share {
    LinkedList<Integer> data = new LinkedList<>();
    public synchronized void pro(int value) throws InterruptedException{
        data.add(value);
        notify();
    }
    public synchronized int con() throws InterruptedException{
        while(data.size()==0)
            wait();
        Random a=new Random();
        int i=a.nextInt(5);
        notify();
        return data.get(i);
    }
    public static void main(String[] args) throws InterruptedException {
        share s=new share();
        int p=5;
        int c=10;
        ExecutorService pe =Executors.newFixedThreadPool(p);
        ExecutorService ce =Executors.newFixedThreadPool(c);
        for (int i=0;i<p;i++) {
            pe.submit(new producer(s));
        }
        for (int i=0;i<c;i++) {
            ce.submit(new consumer(s));
        }
        pe.shutdown();
        ce.shutdown();
    }
}
