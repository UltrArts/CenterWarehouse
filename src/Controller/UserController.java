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
                stm = db.conn.prepareStatement("INSERT INTO user(name, last_name, bi, address, contact, username, password, profile) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                stm.setString(1, data.getName());
                stm.setString(2, data.getLastname());
                stm.setString(3, data.getBi());
                stm.setString(4, data.getAdress());
                stm.setString(5, data.getContact());
                stm.setString(6, data.getUsername());
                stm.setString(7, data.getPassword());
                stm.setString(8, data.getProfile());
                stm.execute();
                JOptionPane.showMessageDialog(null, "Usuário Gravado Com Sucesso");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        return false;
    }
    
    
    public boolean userStatusUpdate(int id, boolean status){
        if(db.connect()){
            PreparedStatement stm;
            String sql = "UPDATE user SET status=? WHERE id=?";
            try {
                stm = db.conn.prepareStatement(sql);
                stm.setBoolean(1, status);
                stm.setInt(2, id);
                stm.execute();
                if(status)
                    JOptionPane.showMessageDialog(null, "Usuário Activado Com Sucesso!");
                else
                    JOptionPane.showMessageDialog(null, "Usuário Desactivado Com Sucesso!");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        
        return false;
    }
    
    public boolean updateUser(User us){
        if(db.connect()){
            PreparedStatement stm;
            String sql;
            if(us.getUsername().equals("~~~~"))
                sql = "UPDATE user SET name=?, last_name=?, bi=?, address=?, contact=?, profile=? WHERE id=?";
            else
                sql = "UPDATE user SET  password=? WHERE id=?";
            try {
                stm = db.conn.prepareStatement(sql);
                if(us.getUsername().equals("~~~~")){
                    stm.setString(1, us.getName());
                    stm.setString(2, us.getLastname());
                    stm.setString(3, us.getBi());
                    stm.setString(4, us.getAdress());
                    stm.setString(5, us.getContact());
                    stm.setString(6, us.getProfile());
                    stm.setInt(7, us.getId());
                }else{
                    stm.setString(1, us.getPassword());
                    stm.setInt(2, us.getId());
                }
                stm.execute();
                JOptionPane.showMessageDialog(null, "Dados Actualizados Com Sucesso!");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        
        return false;
    }
    
    public void seed(){
        user = new User("admin", "warehouse", " " , " " , " " , " " , " ");
        saveUser(user);
    }
    
    public ArrayList<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
         if(db.connect()){
             String sql = "SELECT * FROM user";
            try {
               db.runSQL(sql);
                while(db.res.next()){
//                    db.res.first();
                    user = new User(db.res.getString("username"), db.res.getString("password"), db.res.getInt("id"),  db.res.getString("bi"), db.res.getString("name"), db.res.getString("last_name"), db.res.getString("address"), db.res.getString("contact"), db.res.getString("profile"), db.res.getBoolean("status"), db.res.getString("created_at"), db.res.getString("updated_at"));
                    users.add(user);
                } 
                return users;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        return null;
    }
    
    
    public ArrayList<User> getUsers(String search){
        ArrayList<User> users = new ArrayList<>();
         if(db.connect()){
             String sql = "SELECT * FROM user WHERE id = '"+search+"' OR name LIKE '%"+search+"%' OR last_name LIKE '%"+search+"%' OR bi LIKE '%"+search+"%' OR address LIKE '%"+search+"%' OR username LIKE '%"+search+"%'";
               db.runSQL(sql);
            try {
                while(db.res.next()){
                    db.res.first();
                     user = new User(db.res.getString("username"), db.res.getString("password"), db.res.getInt("id"),  db.res.getString("bi"), db.res.getString("name"), db.res.getString("last_name"), db.res.getString("address"), db.res.getString("contact"), db.res.getString("profile"), db.res.getBoolean("status"), db.res.getString("created_at"), db.res.getString("updated_at"));
                    users.add(user);
                } 
                return users;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        return null;
    }
    
    
    public User getUser(int id){
         if(db.connect()){
             String sql = "SELECT * FROM user WHERE id = '"+id+"'";
               db.runSQL(sql);
            try {
                if(db.res.next()){
                    db.res.first();
                    user = new User(db.res.getString("username"), db.res.getString("password"), db.res.getInt("id"),  db.res.getString("bi"), db.res.getString("name"), db.res.getString("last_name"), db.res.getString("address"), db.res.getString("contact"), db.res.getString("profile"), db.res.getBoolean("status"), db.res.getString("created_at"), db.res.getString("updated_at"));
                    return user;
                } 
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        return null;
    }
    
    
    public User login(String username,String password){
        if(db.connect()){
             String sql = "SELECT * FROM user WHERE username = '"+username+"' AND password = '"+password+"'";
            db.runSQL(sql);
            try {
                if(db.res.next()){
                    if(! db.res.getBoolean("status")){
                        JOptionPane.showMessageDialog(null, "Lamentámos! Mas Não Poderá Etrar Com a Conta DESACTIVADA!\nPor Favor Contacte O Administrador");
                        return null;
                    }
                    db.res.first();
                    User loggedUser = new User(db.res.getString("username"), db.res.getString("password"), db.res.getInt("id"), db.res.getString("name"), db.res.getString("last_name"));
                    return loggedUser;
                }        
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
                
        return null;
    }
    
    
    
    
}
