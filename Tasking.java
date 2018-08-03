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

	        // �����ļ������һ���޸�ʱ���
	        lastTime = file.lastModified();

	        // ��ʱ����ÿ�����ж�һ���ļ��Ƿ����䶯�����ж�lastModified�Ƿ�ı�
	        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
	        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
	            @Override
	            public void run() {
	                if (file.lastModified() > lastTime) {
	                	/*������Է��͸�web��*/
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
