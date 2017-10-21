package RemoteDesktopMonitoring;

import java.awt.*;
import javax.swing.*;
import java.net.*;


public class Smain extends Thread{
    int port;
    public Smain(int port){
        this.port=port;
    }
    public void run(){
        try{
            ServerSocket serversocket=new ServerSocket(port);
            Socket socket=serversocket.accept();

            JFrame JF = new JFrame();
            JDesktopPane JD = new JDesktopPane();
            JInternalFrame JI = new JInternalFrame("Client Screen", true, true, true);
            JPanel JP = new JPanel();

            JI.setLayout(new BorderLayout());
            JI.getContentPane().add(JP, BorderLayout.CENTER);
            JI.setSize(1366, 768);
            JD.add(JI);
            JP.setFocusable(true);
            JI.setVisible(true);
            JF.add(JD, BorderLayout.CENTER);
            JF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JF.add(JP);
            JF.setTitle("Server");
            JF.setSize(1366, 768);
            JF.setVisible(true);

            Sreceiver sr=new Sreceiver(socket,JP);
            sr.start();
            Scommand sc=new Scommand(socket,JP);
            sc.start();
        }catch (Exception e){
            e.printStackTrace();

        }
    }

}

