/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import javax.swing.JOptionPane;
import model.inheritance.UserParent;
import model.interfaces.UserInterface;
import ticketbooking.Login;
import ticketbooking.Home;
/**
 *
 * @author test
 */
public class User extends UserParent implements UserInterface {
    // Implement the methods from UserInterface
    @Override
    public void login() {
        // Code for login
        Login login = new Login();
        login.setVisible(true);
          
    }
    
    
    @Override
    public void logout() {
        int a = JOptionPane.showConfirmDialog(null, "Do You Really Want to Logout", "Select", JOptionPane.YES_NO_OPTION);
        Home home = new Home();
        if (a == 0) {
            home.setVisible(false);
            new Login().setVisible(true);
    }
}
    



}