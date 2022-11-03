package Controller;

import Model.CheckIn;
import Model.DBConnection;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CheckInController {
    CheckIn prod;
    DBConnection db = new DBConnection();
    
    public boolean saveCheckIn(CheckIn data){
         if(db.connect()){
            PreparedStatement stm;
            try {
                stm = db.conn.prepareStatement("INSERT INTO check_in(prod_id, driver_id, user_id, amount) VALUES(?, ?, ?, ?)");
//                stm.setString(1, data.getName());
//                stm.setDouble(2, data.getAmount());
//                stm.setString(3, data.getUnity());
//                stm.setString(4, data.getDetails());
                stm.execute();
                JOptionPane.showMessageDialog(null, "Entrada Gravada Com Sucesso");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }
        }
        return false;
    }
    
    public ArrayList<CheckIn> getCheckIns(){
        ArrayList<CheckIn> prods = new ArrayList<>();
         if(db.connect()){
             String sql = "SELECT * FROM checkin.*";
               db.runSQL(sql);
            try {
                while(db.res.next()){
                    db.res.first();
//                    prod = new User(db.res.getString("username"), db.res.getString("password"), db.res.getInt("id"), db.res.getString("name"), db.res.getString("last_name"));
//                    users.add(user);
                } 
                
                return prods;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        return null;
    }
    
    
}

