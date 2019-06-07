package dealfile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
public class copyfile {
    public static void main(String[] args) {
        //fileChannelCopy fcc = new fileChannelCopy();
        File resfile = new File("E:\\view.xml");
        if(resfile.exists()) {
            if(resfile.isFile()) {

            }else {
                System.out.println("涓嶆槸涓�涓枃浠�");
            }
        }else {
            System.out.println("F:\\view.sql涓嶅瓨鍦�");
            return ;
        }

        File tfile = new File("E:\\test\\view1.xml");
        File filePath = tfile.getParentFile();
        if(!filePath.exists()) {
            filePath.mkdirs();
        }
        try {
            tfile.createNewFile();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        copyFile(resfile,tfile);
    }
    private static void copyFile(File resfile,File tfile) {
        FileInputStream fis=null;
        FileOutputStream fos=null;
        FileChannel in=null;
        FileChannel out = null;
        try {
            fis = new FileInputStream(resfile);
            fos = new FileOutputStream(tfile);
            in = fis.getChannel();// 寰楀埌瀵瑰簲鐨勬枃浠堕�氶亾
            out= fos.getChannel();// 寰楀埌瀵瑰簲鐨勬枃浠堕�氶亾
            long start = System.currentTimeMillis();
            in.transferTo(0, in.size(), out);// 杩炴帴涓や釜閫氶亾锛屽苟涓斾粠in閫氶亾璇诲彇锛岀劧鍚庡啓鍏ut閫氶亾
            long end = System.currentTimeMillis();
            System.out.println("杩愯鏃堕棿锛�"+(start-end)+"姣");
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                in.close();
                fos.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
