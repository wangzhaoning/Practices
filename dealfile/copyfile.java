package qxy;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
public class test {
    public static void main(String[] args) {
        //fileChannelCopy fcc = new fileChannelCopy();
        File resfile = new File("E:\\view.xml");
        if(resfile.exists()) {
            if(resfile.isFile()) {

            }else {
                System.out.println("不是一个文件");
            }
        }else {
            System.out.println("F:\\view.sql不存在");
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
            in = fis.getChannel();// 得到对应的文件通道
            out= fos.getChannel();// 得到对应的文件通道
            long start = System.currentTimeMillis();
            in.transferTo(0, in.size(), out);// 连接两个通道，并且从in通道读取，然后写入out通道
            long end = System.currentTimeMillis();
            System.out.println("运行时间："+(start-end)+"毫秒");
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
