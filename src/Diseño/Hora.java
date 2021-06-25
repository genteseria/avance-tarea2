/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Diseño;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class Hora extends Thread{
    private JLabel label;

    public Hora(JLabel label) {
        this.label = label;
    }
    
    public void run(){
        while(true){
            Date date = new Date();
            SimpleDateFormat formatHora = new SimpleDateFormat("hh:mm:ss");
            label.setText(""+formatHora.format(date));
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                System.err.println("Error, en la hora");
            }
        }
    }
    
    
}
