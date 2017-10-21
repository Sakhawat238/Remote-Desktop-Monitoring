package RemoteDesktopMonitoring;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Scapture extends Thread {
    ObjectOutputStream OS=null;
    Socket socket=null;
    Robot robot=null;
    Scapture(Socket sc,Robot rb){
        socket=sc;
        robot=rb;
    }
    public void run(){
        try{
            OS = new ObjectOutputStream(socket.getOutputStream());
            //OS.writeObject(rec);
            while(true){
                BufferedImage BI=robot.createScreenCapture(new Rectangle(0,0,1366,768));
                ImageIcon image=new ImageIcon(BI);

                try {
                    OS.writeObject(image);
                    OS.reset();
                }catch (IOException e)   {
                    e.printStackTrace();
                }

                try{
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
