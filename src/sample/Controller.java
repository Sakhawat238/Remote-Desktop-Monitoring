package sample;


import FileTransfer.Receiver;
import FileTransfer.Sender;
import RemoteDesktopMonitoring.Cmain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import RemoteDesktopMonitoring.Smain;

public class Controller {

    int n;

    @FXML
    Button dmb,ftb,rsb,rcb,rsbb,rcbb,fts,ftr,ftsb,ftcb;
    @FXML
    TextField rst,rct,rctt,ftstt,ftsttt,ftct,ftctt,ftcttt;

    @FXML
    public void DesktopMontoring(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
        if(event.getSource()==dmb){
            stage=(Stage) dmb.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RDMG.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==rsb){
            stage=(Stage) rsb.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RDMGS.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==rcb){
            stage=(Stage) rcb.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("RDMGC.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==rsbb){
            boolean check=intCheck(rst.getText());
            if(check) {
                Smain sm=new Smain(n);
                sm.start();
            }
        }
        if(event.getSource()==rcbb){
            String str=rct.getText();
            boolean check=intCheck(rctt.getText());
            if(check){
                Cmain cm=new Cmain(str,n);
                cm.start();
            }
        }
        if(event.getSource()==ftb){
            stage=(Stage) ftb.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FTG.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==fts){
            stage=(Stage) fts.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FTGS.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==ftr){
            stage=(Stage) ftr.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("FTGC.fxml"));
            Scene scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        if(event.getSource()==ftsb){
            String str=ftsttt.getText();
            boolean check=intCheck(ftstt.getText());
            if(check){
                Sender sender=new Sender(n,str);
                sender.start();
            }
        }
        if(event.getSource()==ftcb){
            String str1=ftct.getText();
            String str2=ftcttt.getText();
            boolean check=intCheck(ftctt.getText());
            if(check){
                Receiver receiver=new Receiver(str1,n,str2);
                receiver.start();
            }
        }



    }

    public boolean intCheck(String input){
        try{
            n=Integer.parseInt(input);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }







}
