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
    CheckIn check_in = new CheckIn();
    
    public boolean saveCheckIn(ArrayList<CheckIn> data){
        for(int i =0; i < data.size();i++){
            promodel = prodCtrl.getProduct(data.get(i).getProd_id());
            if(prodCtrl.increaseProd(promodel.getId(), promodel.getAmount() + data.get(i).getAmount()))
            {
                if(db.connect()){
                   PreparedStatement stm;
                   try {
                       stm = db.conn.prepareStatement("INSERT INTO check_in(prod_id, driver_id, user_id, amount, available_amount, price, expire_date, list_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
                       stm.setInt(1, data.get(i).getProd_id());
                       stm.setInt(2, data.get(i).getDriver_id());
                       stm.setInt(3, 1);
                       stm.setDouble(4, data.get(i).getAmount());
                       stm.setDouble(5, data.get(i).getAvailable_amount());
                       stm.setDouble(6, data.get(i).getPrice());
                       stm.setString(7, data.get(i).getExpire_date());
                       stm.setInt(8, 1);
                       stm.execute();
                   } catch (SQLException ex) {
                       JOptionPane.showMessageDialog(null, "ERRO: "+ex);
                   }
               }
            }
//            JOptionPane.showMessageDialog(null, "Sucesso");
        }
        return false;
    }
    
    public ArrayList<CheckIn> getCheckIns(){
        ArrayList<CheckIn> prods = new ArrayList<>();
         if(db.connect()){
             
//             "SELECT product.*, supplier.name FROM product INNER JOIN supplier ON product.supplier_id = supplier.id";
             String sql = "SELECT check_in.*, product.supplier_id, user.username, " +
                     "driver.last_name, driver.driver_name, product.product_name  FROM check_in " +
                     "INNER JOIN product ON check_in.prod_id = product.id "+
                     "INNER JOIN driver ON check_in.driver_id = driver.id "+
                     "INNER JOIN user ON check_in.user_id = user.id";
               db.runSQL(sql);
               
            try {
                while(db.res.next()){
//                JOptionPane.showMessageDialog(null, " I ARRIVED");
//                    db.res.first();
                    check_in = new CheckIn(db.res.getInt("id"), db.res.getInt("prod_id"),
                            db.res.getInt("driver_id"), db.res.getInt("user_id"),
            db.res.getString("username"),db.res.getString("driver_name") +" "+ db.res.getString("last_name"), db.res.getDouble("amount"),
            db.res.getDouble("available_amount"), db.res.getString("product_name"), String.valueOf(db.res.getInt("supplier_id")),
            db.res.getInt("supplier_id"), db.res.getDouble("price"), db.res.getString("expire_date"), db.res.getString("created_at"));
                    prods.add(check_in);
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

