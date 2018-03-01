import Crawler.DocumentMaker;
import Crawler.SpiderLeg;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

//TODO: Remove Hashes from links
//TODO: SiteMap
//TODO: Robot.txt
//TODO: Save State
//TODO: May be blocking in Document Maker
//TODO: Save Frequency to save iterations

public class Program  {
    public static void main(String[] args) {

        AtomicInteger crawlerDocumentCount = new AtomicInteger(0);
        AtomicInteger docMakerDocumentCount = new AtomicInteger(0);
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(50);
        BlockingQueue<String> docQueue = new ArrayBlockingQueue<>(50);
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        queue.add("https://yts.am");
        SpiderLeg x = new SpiderLeg(queue, map, docQueue, crawlerDocumentCount, 50);
        DocumentMaker y = new DocumentMaker(docQueue,  "/home/ahmad/Desktop/Documents/", docMakerDocumentCount,50, 4);
        SpiderLeg v = new SpiderLeg(queue, map, docQueue, crawlerDocumentCount, 50);
        DocumentMaker w = new DocumentMaker(docQueue,  "/home/ahmad/Desktop/Documents/", docMakerDocumentCount,50, 4);
        x.start();
        y.start();
        v.start();
        w.start();
        try {
            x.join();
            y.join();
            w.join();
            v.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
