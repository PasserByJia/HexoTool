import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class NewBlog extends JFrame {
	private TextField prg;
	public NewBlog(String blogPath) {
		JPanel textPanel = new JPanel();
        JLabel messageLabel = new JLabel("请输入新博客标题");
        textPanel.add(messageLabel);
        prg = new TextField(30);
        prg.setText("");
        JScrollPane jsPane =new JScrollPane(prg);
        textPanel.add(jsPane);
        this.add(textPanel,BorderLayout.CENTER);
        JPanel controlPanel = new JPanel();
	    JButton addNum = new JButton("确认");
	    JButton update = new JButton("更新同步");
	    controlPanel.add(addNum);
	    controlPanel.add(update);
	    this.add(controlPanel,BorderLayout.SOUTH);
        addNum.addActionListener(new OkListener(this,blogPath));
        update.addActionListener(new UpdateListener(blogPath));
	    this.setSize(400,100);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.setVisible(true);
	}
	class OkListener implements ActionListener{
    	private NewBlog c;
    	private String blogPath;
    	public OkListener(NewBlog c,String blogPath) {
    		this.c=c;
    		this.blogPath =blogPath;
    	}
    	public void actionPerformed(ActionEvent arg0) {
            String content = prg.getText();
            String cmd = "powershell.exe (cd "+blogPath
            		+" );(hexo new "+content
            		+" );("+blogPath+"\\source\\_posts\\"+content+".md)";
            try{
               File filename = new File(blogPath+"\\source\\_posts\\"+content+".md");
               if(!filename.exists()) {
            	   Runtime.getRuntime().exec(cmd);
            	   prg.setText("");
               }else {
            	   Runtime.getRuntime().exec("powershell.exe "+blogPath+"\\source\\_posts\\"+content+".md");
               }
            }
           catch(Exception e){
                e.printStackTrace();
           }
        }
    }
	class UpdateListener implements ActionListener{
    	private String blogPath;
    	public UpdateListener(String blogPath) {
    		this.blogPath =blogPath;
    	}
    	public void actionPerformed(ActionEvent arg0) {
            String cmd = "cmd.exe /k cd /d "+blogPath + "&& hexo clean && start hexo g -d";
            try{
              Runtime.getRuntime().exec(cmd);
            }
           catch(Exception e){
                e.printStackTrace();
           }
        }
    }
}
