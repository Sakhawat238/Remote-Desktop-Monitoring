package RemoteDesktopMonitoring;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.*;
import java.net.*;


public class Sreceiver extends Thread{
    ObjectInputStream OI=null;
    Socket sc=null;
    JPanel jp;

    Sreceiver(Socket sc,JPanel jp){
        this.sc=sc;
        this.jp=jp;
    }

    public void run(){
        try{
            OI=new ObjectInputStream(sc.getInputStream());

        }catch (IOException e){
            e.printStackTrace();
        }
        while(true){
            try{
                ImageIcon imageIcon = (ImageIcon) OI.readObject();
                Image im=imageIcon.getImage();
                im = im.getScaledInstance(1366,768,Image.SCALE_FAST);

                Graphics graphics = jp.getGraphics();
                graphics.drawImage(im,0,0, 1366,768,jp);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
