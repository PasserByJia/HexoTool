import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.io.File;  
import java.io.BufferedWriter;  
import java.io.FileWriter; 

public class CreatPathFile extends JFrame {
	private TextField prg;
    public CreatPathFile() {
        JPanel textPanel = new JPanel();
        JLabel messageLabel = new JLabel("�����벩��·��");
        textPanel.add(messageLabel);
        prg = new TextField(30);
        prg.setText("");
        JScrollPane jsPane =new JScrollPane(prg);
        textPanel.add(jsPane);
        this.add(textPanel,BorderLayout.CENTER);
        JPanel controlPanel = new JPanel();
	    JButton addNum = new JButton("ȷ��");
	    controlPanel.add(addNum);
	    this.add(controlPanel,BorderLayout.SOUTH);
        addNum.addActionListener(new OkListener(this));
	    this.setSize(400,100);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setVisible(true);
    }
    class OkListener implements ActionListener{
    	private CreatPathFile c;
    	public OkListener(CreatPathFile c) {
    		this.c=c;
    	}
    	public void actionPerformed(ActionEvent arg0){
            String content = prg.getText();
            File writename = new File("pathFile.txt"); 
            try { 
                writename.createNewFile(); // �������ļ�  
                BufferedWriter out = new BufferedWriter(new FileWriter(writename));  
                out.write(content); // \r\n��Ϊ����  
                out.flush(); // �ѻ���������ѹ���ļ�  
                out.close(); // ���ǵùر��ļ�  
                c.setVisible(false);
                new NewBlog(content);
            }catch (Exception e) {  
                e.printStackTrace();  
            }  
        }
    }
}


