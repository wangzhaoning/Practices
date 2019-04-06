/*package practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class copyFile {
	 public static void main(String[] args) throws IOException {
		 File source = new File("E:\\testCollection\\LUBM0.nt");
		 Integer count=1;
		 for(int i=0;i<100;i++) {
			 File dest = new File("E:\\testCollection\\LUBM"+count+".nt");
			 copyFileUsingJava7Files(source,dest);
			 count++;
		 }
		
	}
	 
	 private static void copyFileUsingJava7Files(File source, File dest)
		        throws IOException {    
		        Files.copy(source.toPath(), dest.toPath());
		}
}*/
package practice;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
 
public class CopyntFile {
 
	public static void main(String[] args) throws IOException {
		String source=args[0];
		Integer total=Integer.valueOf(args[1]);
		String para=args[2];
		if(para.equals("all")) {
			createTotalFile(source,total);
		}else {
			createManyFile(source,total);
		}
		
	}

	private static void createManyFile(String source, Integer total) {
		File dir1 = new File("qxyNeedLUBMFile");
		dir1.mkdir();
		Integer count=0;
		try {
			 for(int i=0;i<total;i++) {
				 FileReader fileReader = new FileReader(source);
				Writer writer = new FileWriter(new File("qxyNeedLUBMFile\\LUBM"+count+".nt"));
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String str;
				while ((str = bufferedReader.readLine()) != null) {
					writer.write(str.replace("University0","University"+count) + "\r\n");
				}
				writer.close();
				bufferedReader.close();
				fileReader.close();
				count++;
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void createTotalFile(String source,Integer total) throws IOException {
		Integer count=0;
		Writer writer = new FileWriter(new File("all100.nt"));
		String str;
		for(int i=0;i<total;i++) {
			FileReader fileReader = new FileReader(source);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((str = bufferedReader.readLine()) != null) {
				writer.write(str.replace("University0","University"+count) + "\r\n");
			}
			bufferedReader.close();
			fileReader.close();
			count++;
		}
		writer.close();
	 }
}

