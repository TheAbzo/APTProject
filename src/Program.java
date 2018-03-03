import Crawler.DocumentMaker;
import Crawler.SpiderLeg;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

//TODO: Remove Hashes from links
//TODO: SiteMap
//TODO: Robot.txt
//TODO: Save State
//TODO: Save Frequency to save iterations

public class Program  {
    public static void main(String[] args) {

        int maxDocumentCount = 100;
        AtomicInteger crawlerDocumentCount = new AtomicInteger(0);
        AtomicInteger docMakerDocumentCount = new AtomicInteger(0);
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(maxDocumentCount);
        BlockingQueue<String> docQueue = new ArrayBlockingQueue<>(maxDocumentCount);
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        queue.addAll(Arrays.asList("https://en.wikipedia.org/wiki/Computer_science", "https://www.gcflearnfree.org/computerbasics/what-is-a-computer/1/", "https://www.quora.com/What-are-different-fields-in-computer-science", "http://aihorizon.com/essays/basiccs/general/cs_areas.html"));
        SpiderLeg x = new SpiderLeg(queue, map, docQueue, crawlerDocumentCount, maxDocumentCount);
        SpiderLeg x2 = new SpiderLeg(queue, map, docQueue, crawlerDocumentCount, maxDocumentCount);
        SpiderLeg x3 = new SpiderLeg(queue, map, docQueue, crawlerDocumentCount, maxDocumentCount);
        SpiderLeg x4 = new SpiderLeg(queue, map, docQueue, crawlerDocumentCount, maxDocumentCount);
        SpiderLeg x5 = new SpiderLeg(queue, map, docQueue, crawlerDocumentCount, maxDocumentCount);
        SpiderLeg x6 = new SpiderLeg(queue, map, docQueue, crawlerDocumentCount, maxDocumentCount);
        DocumentMaker y = new DocumentMaker(docQueue,  "/home/ahmad/Desktop/Documents/", docMakerDocumentCount,maxDocumentCount, 4);
        DocumentMaker w = new DocumentMaker(docQueue,  "/home/ahmad/Desktop/Documents/", docMakerDocumentCount,maxDocumentCount, 4);
        x.start();
        x2.start();
        x3.start();
        x4.start();
        x5.start();
        x6.start();
        y.start();
        w.start();


        try {
            x.join();
            x2.join();
            x3.join();
            x4.join();
            x5.join();
            x6.join();
            y.join();
            w.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
