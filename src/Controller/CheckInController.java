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
    ProductController  prodCtrl = new ProductController();
    Product promodel = new Product();
    DBConnection db = new DBConnection();
    
    public boolean saveCheckIn(CheckIn data){
        promodel = prodCtrl.getProduct(data.getProd_id());
        if(data.getAmount() <= 0){
            JOptionPane.showMessageDialog(null, "Quantidade não permitida");
            return false;
        }else{
            if(prodCtrl.increaseProd(promodel.getId(), promodel.getAmount() + data.getAmount()))
            {
                if(db.connect()){
                   PreparedStatement stm;
                   try {
                       stm = db.conn.prepareStatement("INSERT INTO check_in(prod_id, driver_id, user_id, amount, available_amount, price, expire_date) VALUES(?, ?, ?, ?, ?, ?, ?)");
                       stm.setInt(1, data.getProd_id());
                       stm.setInt(2, data.getDriver_id());
                       stm.setInt(3, 1);
                       stm.setDouble(4, data.getAmount());
                       stm.setDouble(5, data.getAvailable_amount());
                       stm.setDouble(6, data.getPrice());
                       stm.setString(7, data.getExpire_date());
                       stm.execute();
                       JOptionPane.showMessageDialog(null, "Entrada Gravada Com Sucesso");
                       return true;
                   } catch (SQLException ex) {
                       JOptionPane.showMessageDialog(null, "ERRO: "+ex);
                   }
               }
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
    
    public ArrayList<CheckIn> getCheckIns(int id){
        ArrayList<CheckIn> prods = new ArrayList<>();
         if(db.connect()){
             String sql = "SELECT * FROM checkin where id = '"+id+ "'";
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

