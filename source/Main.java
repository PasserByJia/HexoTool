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
		            new FileInputStream(filename)); // ����һ������������reader  
		            BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
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
