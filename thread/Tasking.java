package Unit21;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.WatchService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
public class Tasking {
	 private long lastTime;

	    @Test
	    public void testFileUpdate() {
	        File file = new File("./appserver.xml");

	        // 首先文件的最近一次修改时间戳
	        lastTime = file.lastModified();

	        // 定时任务，每秒来判断一下文件是否发生变动，即判断lastModified是否改变
	        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
	        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
	            @Override
	            public void run() {
	                if (file.lastModified() > lastTime) {
	                	/*这里可以发送给web端*/
	                    //System.out.println("file update! time : " + file.lastModified());
	                    lastTime = file.lastModified();
	                }
	            }
	        },0, 1, TimeUnit.SECONDS);


	        try {
	            Thread.sleep(1000 * 60);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	
}
