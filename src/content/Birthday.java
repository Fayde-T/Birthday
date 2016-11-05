package content;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Birthday extends JFrame {
	private static final int BG_WIDTH=900;
	private static final int BG_HEIGHT=600;
	private ImageComponent bg1;
	private ImageComponent bg2;
	private ImageComponent bg3;
	private ImageComponent bg4;
	private ImageComponent bg5;
	private Timer timer;
	Container C;

	private int count=0;
	
	
	public Birthday(){	
			bg1 = new ImageComponent(new ImageIcon("config\\bk1.jpg").getImage());
			bg1.setBounds(0, 0, BG_WIDTH, BG_HEIGHT);
			bg1.setLayout(null);	
			C = this.getContentPane();
			C.add(bg1);
			timer = new Timer();
			timer.schedule(new BgChange(),0,30000);
			
			}
	
	public void ChangePanel(){
		
		if(count==0){
			bg1 = new ImageComponent(new ImageIcon("config\\bk1.jpg").getImage());
			bg1.setBounds(0, 0, BG_WIDTH, BG_HEIGHT);
			bg1.setLayout(null);
			C.removeAll();
			C.add(bg1);
			this.repaint();
			
		}else if(count==1){
			bg2 = new ImageComponent(new ImageIcon("config\\bk2.jpg").getImage());
			bg2.setBounds(0, 0, BG_WIDTH, BG_HEIGHT);
			bg2.setLayout(null);
			C.removeAll();
			C.add(bg2);
			this.repaint();
			
		}else if(count==2){
			bg3 = new ImageComponent(new ImageIcon("config\\bk3.jpg").getImage());
			bg3.setBounds(0, 0, BG_WIDTH, BG_HEIGHT);
			bg3.setLayout(null);
			C.removeAll();
			C.add(bg3);
			this.repaint();
		}else if(count==3){
			bg4 = new ImageComponent(new ImageIcon("config\\bk4.jpg").getImage());
			bg4.setBounds(0, 0, BG_WIDTH, BG_HEIGHT);
			bg4.setLayout(null);
			C.removeAll();
			C.add(bg4);
			this.repaint();
		}else if(count==4){
			bg5 = new ImageComponent(new ImageIcon("config\\bk6.jpg").getImage());
			bg5.setBounds(0, 0, BG_WIDTH, BG_HEIGHT);
			bg5.setLayout(null);
			C.removeAll();
			C.add(bg5);
			this.repaint();
			count=-1;
		}
		
		
	
	}
	
	class BgChange extends TimerTask{
		public void run(){
			ChangePanel();
			count++;
		}
	}

	
	 

class ImageComponent extends JPanel{
	private int  LOCATION_X=20;
	private int  LOCATION_Y=50;
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
		
//		super.paintComponents(g);
//		g.drawImage(image,0,0,imageWidth,imageHeight,this);
		
		g.drawImage(image, 0, 0, null);
		for(int i=0;i*imageWidth<=this.getWidth();i++)
			for(int j=0;j*imageHeight<=this.getHeight();j++)
				if(i+j>0)
				g.copyArea(0, 0, imageWidth, imageHeight, imageWidth*i, imageHeight*j);
		
		
		Graphics2D g2=(Graphics2D)g;
		Font f1= new Font("微软雅黑",Font.BOLD,18);
		g2.setFont(f1);
		
        BufferedReader reader = null;
        try {
        	switch(count){
        	case 0 :  reader = new BufferedReader(
        			new InputStreamReader(new FileInputStream("config\\pome6.txt"), "GBK")); break;
        	case 1 :  reader = new BufferedReader(
        			new InputStreamReader(new FileInputStream("config\\gogo.txt"), "GBK")); break;
        	case 2 :  reader = new BufferedReader(
        			new InputStreamReader(new FileInputStream("config\\gogo2.txt"), "GBK")); break;
        	case 3 :  reader = new BufferedReader(
        			new InputStreamReader(new FileInputStream("config\\pome4.txt"), "GBK")); break;
        	case 4 :  reader = new BufferedReader(
        			new InputStreamReader(new FileInputStream("config\\pome5.txt"), "GBK")); break;
        	default:  break;  
        	}
           
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
            	FontRenderContext context=g2.getFontRenderContext();
        		Rectangle2D bounds=f1.getStringBounds(tempString, context);
        	//	double x= bounds.getWidth();
        		double y=bounds.getHeight();
        		LOCATION_Y+=(int)y;
        	    g2.drawString(tempString, LOCATION_X , LOCATION_Y);
            }
            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        
        
        
   	}
	
}



}





