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
                stm = db.conn.prepareStatement("INSERT INTO product(name, amount, unity, supplier_id) VALUES(?, ?, ?, ?)");
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
    
    
    
    public ArrayList<Product> getProducts(){
        ArrayList<Product> prods = new ArrayList<>();
         if(db.connect()){
             String sql = "SELECT product.* FROM product INNER JOIN supplier ON product.supplier_id = supplier.id";
               db.runSQL(sql);
            try {
                while(db.res.next()){
//                    db.res.first();
                    prod = new Product(db.res.getInt("id"), db.res.getString("name"), db.res.getDouble("amount"), db.res.getString("unity"), db.res.getString("name"), db.res.getInt("supplier_id"));
                    prods.add(prod);
                    JOptionPane.showMessageDialog(null, db.res.getString("name"));
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
    
    
    
     
    public Product updateProduct(Product prod){
        if(db.connect()){
            PreparedStatement stm;
            String sql = "UPDATE dividas SET valorDivida=?, valorAPagar=?, estadoDivida=? WHERE id=?";
            try {
                stm = db.conn.prepareStatement(sql);
//                stm.setFloat(1, valorDivida);
//                stm.setFloat(2, valorAPagar);
                stm.setBoolean(3, true);
//                stm.setInt(4, devedor.getId());
                stm.execute();
                JOptionPane.showMessageDialog(null, "Produto Actulizado Com Sucesso!");
//                return this.clienteLogado(devedor.getId());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Falha ao Ao Actualizar Produto!");
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
//                    prod = new Product(db.res.getString("username"), db.res.getString("password"), db.res.getInt("id"), db.res.getString("name"), db.res.getString("last_name"));
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
