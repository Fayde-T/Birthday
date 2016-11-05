package login;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import content.BrithdayRun;
import content.Happy;


public class LoginUI extends JFrame{
	private static final int WIDTH=600;
	private static final int HEIGHT=600;
	static boolean flag=true;
	Container con;
	private JLabel admin;
	private JLabel password;
	private JTextField name;
	private JPasswordField gogo;
	private ImageIcon background;
	
	public LoginUI(){
	       final JFrame frame = new JFrame();
			frame.setVisible(true);
		    frame.setBounds(200, 50, WIDTH, HEIGHT);
		    frame.setTitle("生日快乐");
			frame.setResizable(false);
			Image img=new ImageIcon("config\\2.jpg").getImage();
			setIconImage(img);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Font fontstyle=new Font("华文彩云",Font.BOLD,16);
		
		admin=new JLabel("特约用户:");
		admin.setFont(fontstyle);
	    admin.setBounds(360, 200, 80, 20);
		password=new JLabel("开启密码:");
		password.setFont(fontstyle);
   	    password.setBounds(360, 250, 80, 20);	
		name = new JTextField("周小冰",15);
		name.setFont(fontstyle);
		name.setBounds(450,200,140,20);
		gogo = new JPasswordField();
	    gogo.setBounds(450, 250, 140, 20);
		JButton start= new JButton("梦想之旅");
		start.setBounds(420, 300,120,30);
		start.setFont(fontstyle);
		
		background = new ImageIcon("config\\4.jpg");  // 这是背景图片
		JLabel imgLabel = new JLabel(background);
		
		frame.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		imgLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		 con=frame.getContentPane();
	      con.setLayout(null);
	      ((JPanel) con).setOpaque(false); 
	
	     con.add(admin);
	     con.add(password);
	     con.add(name);
	     con.add(gogo);
	     con.add(start);
	     
	     
	    start.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e) {  
	    		char[] pass=gogo.getPassword();
	    		char[] pw = {'9','6','0','6','2','6'};
	    		if(Arrays.equals(pass, pw)){
	    		    frame.dispose();
	    		     final JFrame frameH=new Happy();
	    		        
	    		        Timer timer = new Timer();
	    			    timer.schedule(new TimerTask() {
	    			      public void run() {
	    			    	  frameH.dispose();
	    			    	  new BrithdayRun();
	                        }
	    			    }, 120000);  
	    			}
	    		else{
	    			JOptionPane.showMessageDialog(frame, "6位阴历生日", "猜一猜",JOptionPane.WARNING_MESSAGE); 
	    		}
	    	}
	    	
	    });
	 
	     
	
	   
	
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				new LoginUI();	
			}
		});
					
	}
	
}




class ImageComponent extends JPanel{
	private static final int DEFAULT_WIDTH=600;
	private static final int DEFAULT_HEIGHT=600;
	private Image image;
	
	public ImageComponent(Image im){
		this.image=im;
		this.setOpaque(true);
	}
	public void paintComponent(Graphics g){
		if(image==null)
			return ;
		int imageWidth=image.getWidth(this);
		int imageHeight=image.getHeight(this);
		
	//	super.paintComponents(g);
	//	g.drawImage(image,0,0,imageWidth,imageHeight,this);
		g.drawImage(image, 0, 0, null);
		for(int i=0;i*imageWidth<=this.getWidth();i++)
			for(int j=0;j*imageHeight<=this.getHeight();j++)
				if(i+j>0)
					g.copyArea(0, 0, imageWidth, imageHeight, imageWidth*i, imageHeight*j);
		
	}
	
	
	
}

