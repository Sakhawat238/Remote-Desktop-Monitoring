package RemoteDesktopMonitoring;

import java.awt.*;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.InputEvent;

public class Rcommand extends Thread{
    Scanner scanner=null;
    Socket socket;
    Robot robot;

    Rcommand(Socket sc,Robot rb){
        socket=sc;
        robot=rb;
    }
    public void run(){
        try{
            robot.setAutoWaitForIdle(true);
            scanner = new Scanner(socket.getInputStream());

            while(true){
                int data= scanner.nextInt();
                if(data==-1) {
                    int checkb=scanner.nextInt();
                    if(checkb==1) robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                    else if(checkb==3) robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
                    else if(checkb==2) robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
                    robot.delay(10);
                }
                else if(data ==-2 )
                {
                    int checkb=scanner.nextInt();
                    if(checkb==1) robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                    else if(checkb==3) robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
                    else if(checkb==2) robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
                    robot.delay(10);
                }
                else if (data == -3) robot.mouseMove(scanner.nextInt(),scanner.nextInt());
                else if (data == -4) {

                }
                else if (data == -5) {
                    robot.keyPress(scanner.nextInt());
                    robot.delay(10);
                }
                else if (data == -6) {
                    robot.keyRelease(scanner.nextInt());
                    robot.delay(10);
                }
            }

        }catch(Exception e){}
    }
}

