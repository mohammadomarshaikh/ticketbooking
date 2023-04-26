/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author test
 */
public class UserDao {
    
    public static void save(User user){
        String query = "insert into user(name,email,mobileNumber,password,securityQuestion,answer,status) values('"+user.getName()+"','"+user.getEmail()+"','"+user.getMobileNumber()+"','"+user.getPassword()+"','"+user.getSecurityQuestion()+"','"+user.getAnswer()+"','false')";
        
        DBoperations.setDataOrDelete(query,"registered successfully! wait for admin approval");
    }
    
    public static User login(String email, String password){
        User user = null;
        try{
            ResultSet rs = DBoperations.getData("select * from user where email='"+email+"' and password='"+password+"'");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return user;
    }
    
    public static User getSecurityQuestion(String email){
        User user =null;
        try{
            
            ResultSet rs =DBoperations.getData("select * from user where email = '"+ email + "'");
            while(rs.next()){
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
                
            }
           
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        return user;
    }
    
    
    
    
    
    
    public static void update(String email, String newPassword){
        String query = "update user set password = '"+newPassword+"' where email='"+email+"'";
        DBoperations.setDataOrDelete(query,"Password saved Succesfully");
    }
    
    
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DBoperations.getData("select * from user where email like '%"+email+"%'");
            while (rs.next()){
                User user  = new  User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setPassword(rs.getString("password"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        }
        
        
        
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }

        return arrayList;
        
        
        
    }
    
    public static void changeStatus(String email,String status){
        
        String query = "update user set status = '"+status+"' where email='"+email+"'";
      
        DBoperations.setDataOrDelete(query, "Status Changed Succefully");
        
        
    }
    
}
