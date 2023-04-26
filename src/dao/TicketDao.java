/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Tickets;
import java.sql.*;

/**
 *
 * @author test
 */
public class TicketDao {
    public static void save(Tickets tickets){
        String query = "insert into tickets(name,query,priority,status) values('"+tickets.getName()+"','"+tickets.getQuery()+"','"+tickets.getPriority()+"','"+tickets.getStatus()+"')";
        DBoperations.setDataOrDelete(query, "Ticket Booked Successfully");
    }
    
    public static ArrayList<Tickets> getAllRecords(){
        ArrayList<Tickets> arrayList = new ArrayList<>();
        try{
            ResultSet rs =  DBoperations.getData("select * from tickets");
                    while(rs.next()){
                        Tickets tickets = new Tickets();
                        tickets.setId(rs.getInt("id"));
                        tickets.setName(rs.getString("name"));
                        tickets.setQuery(rs.getString("query"));
                        tickets.setPriority(rs.getString("priority"));
                        tickets.setStatus(rs.getString("status"));
                        arrayList.add(tickets);
                        
                        
                        
                    }
        
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    
    
    
    
    
    public static void delete(String id){
        String query = "delete from tickets where id='"+id+"'";
        DBoperations.setDataOrDelete(query, "Ticket Deleted Succesfully");
    }
    
    
}
