package currencyConverter;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
  Main() {
	  new ContentPanel();
   
  }

  public static void main(String[] args) {
	  
	  MainWindow jrframe = new MainWindow();
	    jrframe.setVisible(true);  
  }
   
}

class ContentPanel extends JPanel {  
  Image bgimage = null;
       
  ContentPanel() { 
    MediaTracker mt = new MediaTracker(this);
    bgimage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\OneDrive\\Desktop\\1.jpg");
    mt.addImage(bgimage, 100);
    try {
      mt.waitForAll();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    int imwidth = bgimage.getWidth(null);
    int imheight = bgimage.getHeight(null);
    g.drawImage(bgimage, 100, 100, null);
  }
}