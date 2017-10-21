package FileTransfer;

import java.io.*;
import java.net.*;


public class Receiver extends Thread{
    int port;
    String ip;
    String target;
    File fl;
    Socket skt=null;
    ObjectInputStream OIS = null;
    public Receiver(String ip,int port,String filename){
        this.ip=ip;
        this.port=port;
        target=filename;
    }
    public void run(){
        try{
            skt=new Socket(ip,port);
            OIS = new ObjectInputStream(skt.getInputStream());

            fl=(File)OIS.readObject();
            copy(fl,target);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void copy(File originalFile, String targetFile) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        in = new FileInputStream(originalFile);
        out = new FileOutputStream(targetFile);
        int c;

        while ((c = in.read()) != -1) {
            out.write(c);
        }

        out.close();
        in.close();

    }

}

