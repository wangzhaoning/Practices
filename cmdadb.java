package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class cmdadb {
	 public static void main(String[] args) throws Exception {
		 Integer name1=0,name2=0;
		 for(int i=0;i<2;i++) {
			 for(int j=0;j<20;j++) {
				 processBuilderCommand(name1.toString(),name2.toString());
				 name2++;
			 }
			 name2=0;
			 name1++;
		 }
	        
	    }

	private static void processBuilderCommand(String name1,String name2) throws IOException, InterruptedException {
		List<String> commands = new ArrayList<>();
		commands.add("cmd.exe");
		commands.add("/c");
		commands.add("java -jar rdf2rdf-1.0.1-2.3.1.jar University"+name1+"_"+name2+".owl University"+name1+"_"+name2+".nt");
		ProcessBuilder pb =new ProcessBuilder(commands);
		pb.directory(new File("D:\\priavateCode\\uba1.7\\"));//设置工作目录
		Process process = pb.start();
		int status = process.waitFor();
		 
		InputStream in = process.getInputStream();
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = br.readLine();
		while(line!=null) {
		    System.out.println(line);
		    line = br.readLine();
		}
	}
}
