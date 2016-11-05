package content;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Happy extends JFrame{
	private static final int PANEL_WIDTH=900;
	private static final int PANEL_HEIGHT=600;
	public  Happy(){
		MyPanel panel = new MyPanel(PANEL_WIDTH,PANEL_HEIGHT);
		this.add(panel);
		this.setTitle("Happy");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200,50, PANEL_WIDTH, PANEL_HEIGHT);	
        this.setVisible(true);
        this.setResizable(false);
		Thread thread = new Thread (panel);
        thread.start ();
		
	}

}
class MyPanel extends JPanel implements Runnable{
	int width,height;
	int Present_x=0,Present_y=0;
	double font_x, font_y;
	BufferedReader reader = null;
	Image bgImage;
	static int COL=0;
	int ROW=0;
	String font_String;
	String[] font = new String[40];
	int[] linenum = new int [40];
	
	
	
	
	public MyPanel(int width,int height){
		this.width=width;
		this.height=height;
		
		
		
		 try
	        {
			    
	            bgImage = ImageIO.read (new File ("config\\back7.jpg"));
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace ();
	        }
		 try{
			 int i=0;
			 String str=null;
			 reader = new BufferedReader(new InputStreamReader(new FileInputStream("config\\HappyBirthday.txt"), "GBK"));
         
			 while((font_String = reader.readLine())!=null){
				str=font_String.trim();
            	 font[i]= str;
            	 linenum[i]=str.length();
            	 i++;
            	 }
			
		  }catch(IOException e){
				 e.printStackTrace();
		 }
	
	}
	
	public void paint (Graphics g)
    {
	
        super.paint (g);
        g.drawImage (bgImage, 0, 0, width, height, this);
        Font f1= new Font ("宋体", Font.BOLD , 16);
        g.setFont (f1);
        Graphics2D gr2= (Graphics2D)g;
        FontRenderContext context=gr2.getFontRenderContext();
		Rectangle2D bounds=f1.getStringBounds(font[1], context);
		font_x = bounds.getWidth();
		font_y = bounds.getHeight();
	
        g.setColor (Color.black);
     
       
        if(COL>=1){
        	Present_y=0;
        for(int i=0;i<COL;i++){
        	g.drawString(font[i], Present_x, Present_y);
        	 Present_y+=font_y;
          }
        }
         g.drawString (font[COL].substring(0, ROW),Present_x,Present_y);
        
        	 
        
        	
        g.dispose ();
        gr2.dispose();
    }
	
	
	 public AudioClip loadSound ( String filename )
	    {
	        URL url = null;
	        try
	        {
	            url = new URL ("file:" + filename);
	        }
	        catch (MalformedURLException e)
	        {}
	        return JApplet.newAudioClip (url);
	    }

	@Override
	public void run() {
		boolean flag=true;
		AudioClip HappyBirthday = loadSound ("config\\HappyBirthday.wav");
	    HappyBirthday.play();
		while(flag){
			ROW++;
		//	System.out.println(ROW+"  "+linenum[COL]);
			if(ROW==linenum[COL]){
			   ROW=0;
			   COL++;
			   Present_y+=font_y;
			}
			try{
				Thread.sleep(45);
			}catch(Exception e){
				e.printStackTrace();
			}
			this.repaint();
			while(COL==32)
			flag=false;
			
		}
		
	}
	
}

