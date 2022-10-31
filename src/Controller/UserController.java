package Controller;

import Model.DBConnection;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UserController {
    User user;
    DBConnection db = new DBConnection();
    
    public boolean saveUser(User data){
         if(db.connect()){
            PreparedStatement stm;
            try {
                stm = db.conn.prepareStatement("INSERT INTO user(name, last_name, bi, address, contact, username, password) VALUES(?, ?, ?, ?, ?, ?, ?)");
                stm.setString(1, data.getName());
                stm.setString(2, data.getLastname());
                stm.setString(3, data.getBi());
                stm.setString(4, data.getAdress());
                stm.setString(5, data.getContact());
                stm.setString(6, data.getUsername());
                stm.setString(7, data.getPassword());
                stm.execute();
                JOptionPane.showMessageDialog(null, "Usuário Gravado Com Sucesso");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }
        }
        return false;
    }
    
    public void seed(){
        user = new User("admin", "warehouse", " " , " " , " " , " " , " ");
        saveUser(user);
    }
    
    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<User>();
         if(db.connect()){
             String sql = "SELECT * FROM user";
               db.runSQL(sql);
            try {
                while(db.res.next()){
                    db.res.first();
                    user = new User(db.res.getString("username"), db.res.getString("password"), db.res.getInt("id"), db.res.getString("name"), db.res.getString("last_name"));
                    users.add(user);
                }        
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha de login: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        return users;
    }
    
    
    public User login(String username,String password){
        if(db.connect()){
             String sql = "SELECT * FROM user WHERE username = '"+username+"' AND password = '"+password+"'";
               db.runSQL(sql);
            try {
                if(db.res.next()){
                    JOptionPane.showMessageDialog(null, "BEM-VINDO");
                    db.res.first();
                    User loggedUser = new User(db.res.getString("username"), db.res.getString("password"), db.res.getInt("id"), db.res.getString("name"), db.res.getString("last_name"));
                    return loggedUser;
                }        
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha de login: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        return null;
    }
    
    
    
    
}
