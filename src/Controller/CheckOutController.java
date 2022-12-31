package Controller;

import Model.CheckOut;
import Model.DBConnection;
import Model.Product;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CheckOutController {
    CheckOut prod;
    DBConnection db = new DBConnection();
    CheckOut check_out = new CheckOut();
    Product promodel = new Product();
    ProductController  prodCtrl = new ProductController();
    
//    public boolean saveCheckOut(CheckOut data){
//         if(db.connect()){
//            PreparedStatement stm;
//            try {
//                stm = db.conn.prepareStatement("INSERT INTO check_in(prod_id, driver_id, user_id, amount) VALUES(?, ?, ?, ?)");
////                stm.setString(1, data.getName());
////                stm.setDouble(2, data.getAmount());
////                stm.setString(3, data.getUnity());
////                stm.setString(4, data.getDetails());
//                stm.execute();
//                JOptionPane.showMessageDialog(null, "Entrada Gravada Com Sucesso");
//                return true;
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
//            }
//        }
//        return false;
//    }
//    
    
    public boolean saveCheckOut(CheckOut data){
        promodel = prodCtrl.getProduct(data.getProd_id());
        if(data.getAmount() <= 0){
            JOptionPane.showMessageDialog(null, "Quantidade não permitida");
            return false;
        }else{
            if((promodel.getAmount() - data.getAmount()) < 0){
                JOptionPane.showMessageDialog(null, "Quantidade inferior à desejada");
            }else if(prodCtrl.increaseProd(promodel.getId(), promodel.getAmount() - data.getAmount()))
            {
                if(db.connect()){
                   PreparedStatement stm;
                   try {
                       stm = db.conn.prepareStatement("INSERT INTO check_out(prod_id, user_id, driver_id, store_id, amount) VALUES(?, ?, ?, ?, ?)");
                       stm.setInt(1, data.getProd_id());
                       stm.setInt(2, data.getUser_id());
                       stm.setInt(3, data.getDriver_id());
                       stm.setInt(4, data.getStore_id());
                       stm.setDouble(5, data.getAmount());
                       stm.execute();
                       JOptionPane.showMessageDialog(null, "Saída Gravada Com Sucesso");
                       return true;
                   } catch (SQLException ex) {
                       JOptionPane.showMessageDialog(null, "ERRO: "+ex);
                   }
               }
            }
        }
        return false;
    }
    
    
    public ArrayList<CheckOut> getCheckIns(){
        ArrayList<CheckOut> prods = new ArrayList<>();
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
    
    public ArrayList<CheckOut> getCheckOuts(){
        ArrayList<CheckOut> prods = new ArrayList<>();
         if(db.connect()){
             String sql = "SELECT check_out.*, product.supplier_id, user.username, " +
                     "driver.last_name, product.product_name, store.store_name  FROM check_out " +
                     "INNER JOIN product ON check_out.prod_id = product.id "+
                     "INNER JOIN driver ON check_out.driver_id = driver.id "+
                     "INNER JOIN user ON check_out.user_id = user.id "+
                     "INNER JOIN store ON check_out.store_id = store.id";
               db.runSQL(sql);
               
            try {
                while(db.res.next()){
                    check_out = new CheckOut(db.res.getInt("id"), db.res.getInt("prod_id"),
                            db.res.getInt("driver_id"), db.res.getInt("user_id"),
            db.res.getString("username"),db.res.getString("name") + " "+ db.res.getString("last_name"), db.res.getDouble("amount"),
             db.res.getString("product_name"), db.res.getString("created_at"),  db.res.getInt("store_id"),  db.res.getString("store_name"));
                    prods.add(check_out);
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
