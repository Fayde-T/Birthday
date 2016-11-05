package content;

import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class BrithdayRun {
	private static final int BG_WIDTH=900;
	private static final int BG_HEIGHT=600;
	public BrithdayRun(){
		JFrame frame = new Birthday();
		frame.setTitle("Birthday");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setBounds(200,50,BG_WIDTH,BG_HEIGHT);
		frame.setResizable(false);
		Runnable r= new MyRunnable();
		Thread t = new Thread(r);
		t.start();
		
	}
	class MyRunnable implements Runnable{
		public void run(){
			AudioClip christmas = loadSound ("config\\Sa.wav");
			christmas.play();
		}
	}
	 public AudioClip loadSound ( String filename )
	    {
	        URL url = null;
	        try
	        {
	            url = new URL ("file:" + filename);
	        }
	        catch (MalformedURLException e)
	        {
	        	e.printStackTrace();
	        }
	        return JApplet.newAudioClip (url);
	    }
	/*
public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				new BrithdayRun();
				
			}
		});
		
	}
	*/

}
