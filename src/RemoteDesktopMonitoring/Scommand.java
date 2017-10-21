package RemoteDesktopMonitoring;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;


public class Scommand extends Thread{
    JPanel jP;
    PrintWriter print=null;
    Socket st=null;
    Scommand(Socket st,JPanel jP){
        this.st=st;
        this.jP=jP;
    }

    public void run(){
        try {
            print = new PrintWriter(st.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }
        command Cmnd=new command();
        jP.addKeyListener(Cmnd);
        jP.addMouseListener(Cmnd);
        jP.addMouseMotionListener(Cmnd);

    }

    class command implements KeyListener,MouseMotionListener,MouseListener,MouseWheelListener{
        //Key Listener
        public void keyTyped(KeyEvent e){}
        public void	keyPressed(KeyEvent e){
            int temp1=-5;
            print.println(temp1);
            print.println(e.getKeyCode());
            print.flush();
        }
        public void	keyReleased(KeyEvent e){
            int temp2=-6;
            print.println(temp2);
            print.println(e.getKeyCode());
            print.flush();
        }

        //Mouse Listener
        public void mouseClicked(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void	mouseExited(MouseEvent e){}
        public void	mousePressed(MouseEvent e){
            int temp5=-1;
            print.println(temp5);
            print.println(e.getButton());
            print.flush();
        }
        public void	mouseReleased(MouseEvent e){
            int temp6=-2;
            print.println(temp6);
            print.println(e.getButton());
            print.flush();
        }

        //Mouse motion
        public void	mouseDragged(MouseEvent e){}
        public void	mouseMoved(MouseEvent e){
            int temp3=-3;
            print.println(temp3);
            print.println(e.getX());
            print.println(e.getY());
            print.flush();
        }

        //Mouse Wheel
        public void	mouseWheelMoved(MouseWheelEvent e) {
            int temp4 = -4;
            print.println(temp4);
            int notches = e.getWheelRotation();
            print.println(notches);
            print.flush();

        }

    }
}

