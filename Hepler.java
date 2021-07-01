/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Thuy Linh
 */
public class Hepler {
  public  static boolean checkRong(JTextField tf, String mss ){
        if(tf.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, mss);
          
            tf.requestFocus();
            return true;
        }
        return false;
    }
    public static boolean checkLuong(JTextField tf, String mss ){
        if(Double.parseDouble(tf.getText())<5000000)
        {
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            
            return true;
        }
        return false;
    }
    public static boolean checkTuoi(JTextField tf, String mss ){
        if(Integer.parseInt(tf.getText())<16||Integer.parseInt(tf.getText())>55)
        {
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
           
            return true;
        }
        return false;
    }
    public static boolean checkSo(JTextField tf, String mss ){
        try {
         double so= Double.parseDouble(tf.getText());
         return false;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
           
            return true;
        }
    }
    public static boolean checkMail(JTextField tf, String mss){
        String mail = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(!tf.getText().matches(mail)){
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            
            return true;
        }
        return false;
    }
    public static boolean checkTen(JTextField tf , String mss ){
        String ten ="^[a-zA-Z]$";
        if(!tf.getText().matches(ten)){
            JOptionPane.showMessageDialog(null, mss);
            tf.requestFocus();
            return true;
        }
        return false;
    }
    
}
