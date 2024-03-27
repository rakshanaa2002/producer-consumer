import java.util.LinkedList;
public class share {
    LinkedList<Integer> data=new LinkedList<>();    
    public static void main(String[] args)throws InterruptedException {
        share share=new share();
        int producerNum=5;
        int consumeNum=6;
        for(int i=1;i<=producerNum;i++){
            producer producer=new producer(share, i);
            producer.start();
        }
        for(int i=1;i<=consumeNum;i++){
            consumer consumer=new consumer(share, i);
            consumer.start();
        }
    }
}
