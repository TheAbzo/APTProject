/*package Crawler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class StateSaver extends Thread {
    private ConcurrentHashMap<String, Integer> urlMap;
    private BlockingQueue<String> urlQueue;
    private BlockingQueue<String> documentQueue;
    private AtomicInteger documentCount;
    private int maxDocumentCount;

    public StateSaver(BlockingQueue<String> urlQueue, ConcurrentHashMap<String, Integer> urlMap, BlockingQueue<String> documentQueue, AtomicInteger documentCount, int maxDocumentCount) {
        this.urlQueue = urlQueue;
        this.urlMap = urlMap;
        this.documentQueue = documentQueue;
        this.documentCount = documentCount;
        this.maxDocumentCount = maxDocumentCount;
    }

    @Override
    public void run(){
        synchronized (urlMap.)
        try {
            try (PrintWriter out = new PrintWriter("State.txt")) {
                out.println(documentCount.get());
                out.println(maxDocumentCount);
                for(String s : documentQueue){
                    out.print(s + " ");
                }
                out.println();
                for(String s : urlQueue){
                    out.print(s + " ");
                }
                out.println();
                for( Map.Entry<String, Integer> s : urlMap.entrySet()){
                    out.print(s.getKey() + "|" + s.getValue() + " ");
                }
                out.println();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
*/