import java.util.LinkedList;
public class share {
    LinkedList<Integer> data = new LinkedList<>();
    public synchronized void pro(int value){
        data.add(value);
        notify();
    }
    public synchronized int con() throws InterruptedException{
        while(data.size()==0)
            wait();
        return data.removeFirst();
    }
    public static void main(String[] args) throws InterruptedException {
        share s=new share();
        producer p = new producer(s);
        consumer c = new consumer(s);
        p.start();
        c.start();
        p.join();
        c.join();
    }
}