package Controller;

import Model.DBConnection;
import Model.Product;
import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductController {
    Product prod;
    DBConnection db = new DBConnection();
    
    public boolean saveProduct(Product data){
         if(db.connect()){
            PreparedStatement stm;
            try {
                stm = db.conn.prepareStatement("INSERT INTO product(product_name, amount, unity, supplier_id) VALUES(?, ?, ?, ?)");
                stm.setString(1, data.getName());
                stm.setDouble(2, data.getAmount());
                stm.setString(3, data.getUnity());
                stm.setInt(4, data.getSupplier_id());
                stm.execute();
                JOptionPane.showMessageDialog(null, "Produto Gravado Com Sucesso");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: O Producto Já Existe No Registo!");
            }
        }
        return false;
    }
    

    public boolean increaseProd(int id, double amount){
        if(db.connect()){
            PreparedStatement stm;
            String sql = "UPDATE product SET amount=? WHERE id=?";
            try {
                stm = db.conn.prepareStatement(sql);
                stm.setDouble(1, amount);
                stm.setInt(2, id);
                stm.execute();
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }

        return false;
    }

    
    public ArrayList<Product> getProducts(){
        ArrayList<Product> prods = new ArrayList<>();
         if(db.connect()){
             String sql = "SELECT product.*, supplier.name FROM product INNER JOIN supplier ON product.supplier_id = supplier.id";
               db.runSQL(sql);
            try {
                while(db.res.next()){
//                    db.res.first();
                    prod = new Product(db.res.getInt("id"), db.res.getString("product_name"), db.res.getDouble("amount"), db.res.getString("unity"), db.res.getString("name"), db.res.getInt("supplier_id"));
                    prods.add(prod);
//                    JOptionPane.showMessageDialog(null, db.res.getString("email"));
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
    
    
    
    
    public ArrayList<Product> getProducts(String search){
        ArrayList<Product> prods = new ArrayList<>();
         if(db.connect()){
             String sql = "SELECT * FROM product WHERE id = '"+search+"' OR name LIKE '%"+search+"%' OR supplier_id = '"+search+"'";
               db.runSQL(sql);
            try {
                while(db.res.next()){
                    db.res.first();
//                    prod = new User(db.res.getString("username"), db.res.getString("password"), db.res.getInt("id"), db.res.getString("name"), db.res.getString("last_name"));
//                    prods.add(user);
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
    
    
     public Product getProduct(int id){
         if(db.connect()){
             String sql = "SELECT * FROM product WHERE id = '"+id+"'";
               db.runSQL(sql);
            try {
                if(db.res.next()){
                    db.res.first();
                    prod = new Product(db.res.getInt("id"), db.res.getString("product_name"), db.res.getDouble("amount"), db.res.getString("unity"), "", db.res.getInt("supplier_id"), db.res.getDouble("amount"));
                    return prod;
                } 
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        return null;
    }
     
     public boolean saveCategory(String text){
         if(db.connect()){
            PreparedStatement stm;
            try {
                stm = db.conn.prepareStatement("INSERT INTO category(name) VALUES(?)");
                stm.setString(1, text);
                stm.execute();
                JOptionPane.showMessageDialog(null, "Categoria Gravada Com Sucesso");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }
        }
        return false;
     }
     
     public ArrayList<String> getCategories(){
         ArrayList<String> cats = new ArrayList<>();
          ArrayList<Product> prods = new ArrayList<>();
         if(db.connect()){
             String sql = "SELECT * FROM category ORDER BY name";
               db.runSQL(sql);
            try {
                while(db.res.next()){
//                    db.res.first();
//                    prod = new User(db.res.getString("username"), db.res.getString("password"), db.res.getInt("id"), db.res.getString("name"), db.res.getString("last_name"));
//                    prods.add(user);
                      cats.add(db.res.getString("name"));
                } 
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: a categoria digitada já existe no repositório!");
            }finally{
                db.Disconnect();
            }
        }
         
         return cats;
     }
    
}
