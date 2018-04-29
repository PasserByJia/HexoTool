import java.io.File;
import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.io.FileInputStream;  

public class Main{
	 public static void main(String[] args){
		 File filename = new File("pathFile.txt");
		 if(!filename.exists()) {
			 new CreatPathFile();
		 }else {
			try {
				 InputStreamReader reader = new InputStreamReader(  
		            new FileInputStream(filename)); // 建立一个输入流对象reader  
		            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
		            String line = "";  
		            line = br.readLine(); 
		            System.out.println(line);
		            new NewBlog(line);
			} catch (Exception e) {  
	            e.printStackTrace();  
	        }
		 }
	}
}
