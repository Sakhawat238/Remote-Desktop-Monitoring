package FileTransfer;

import java.net.*;
import java.io.*;


public class Sender extends Thread{
    ServerSocket svr;
    Socket sct;
    File file;

    public Sender(int port,String fileName) throws IOException{
        svr=new ServerSocket(port);
        file=new File(fileName);


    }
    public void run(){
        try{
            while(true){
                sct=svr.accept();
                sendFile();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void sendFile() throws IOException{
        if(!file.exists()) {
            System.out.println("File does not exist");
            System.exit(-1);
        }

        if (file.exists()) {
            ObjectOutputStream OOS=new ObjectOutputStream(sct.getOutputStream());
            OOS.writeObject(file);
        }
    }

}
