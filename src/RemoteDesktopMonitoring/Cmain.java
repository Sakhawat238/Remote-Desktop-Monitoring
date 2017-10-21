package RemoteDesktopMonitoring;

import java.awt.*;
import java.io.ObjectOutputStream;
import java.net.*;


public class Cmain extends Thread{
    Socket socket = null;
    String IP;
    int port;
    Robot robot = null;
    public Cmain(String IP,int port){
        this.IP=IP;
        this.port=port;
    }
    public  void run(){
        try{
            GraphicsEnvironment GE=GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice GD=GE.getDefaultScreenDevice();


            robot=new Robot(GD);
            socket=new Socket(IP,port);

            Scapture scp=new Scapture(socket,robot);
            scp.start();

            Rcommand rc=new Rcommand(socket,robot);
            rc.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
