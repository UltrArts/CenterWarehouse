package Controller;

import Model.DBConnection;
import Model.Supplier;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SupplierController {
    DBConnection db = new DBConnection();
    Supplier supp;
    
    public boolean save(Supplier data){
        if(db.connect()){
            PreparedStatement stm;
            try {
                stm = db.conn.prepareStatement("INSERT INTO supplier(name, country, address, contact, email, country_cod, nuit, cep, product_type) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)");
                stm.setString(1, data.getName());
                stm.setString(2, data.getCountry());
                stm.setString(3, data.getAddress());
                stm.setString(4, data.getContact());
                stm.setString(5, data.getEmail());
                stm.setInt(6, data.getCountry_cod());
                stm.setInt(7, data.getNuit());
                stm.setString(8, data.getCep());
                stm.setString(9, data.getProdut_type());
                stm.execute();
                JOptionPane.showMessageDialog(null, "Fornecedor Gravado Com Sucesso");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        return false;
    }
    
    
     public ArrayList<Supplier> getSuppliers(){
        ArrayList<Supplier> data = new ArrayList<>();
         if(db.connect()){
             String sql = "SELECT * FROM supplier";
            try {
               db.runSQL(sql);
                while(db.res.next()){
//                    db.res.first();
                   supp = new Supplier(db.res.getInt("id"), db.res.getString("name"), db.res.getString("contact"), db.res.getString("country"), db.res.getString("email"), db.res.getInt("country_cod"), db.res.getInt("nuit"), db.res.getString("cep"), db.res.getString("product_type"),
                           db.res.getString("address"), db.res.getString("updated_at"), db.res.getString("created_at"));
                    data.add(supp);
                } 
                return data;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        return null;
    }
     
     
      
    public boolean update(Supplier data){
        if(db.connect()){
            PreparedStatement stm;
            String sql = "UPDATE supplier SET name=?, country=?, address=?, contact=?, email=?, country_cod=?, nuit=?, cep=?, product_type=? WHERE id=?";
            try {
                stm = db.conn.prepareStatement(sql);
                stm.setString(1, data.getName());
                stm.setString(2, data.getCountry());
                stm.setString(3, data.getAddress());
                stm.setString(4, data.getContact());
                stm.setString(5, data.getEmail());
                stm.setInt(6, data.getCountry_cod());
                stm.setInt(7, data.getNuit());
                stm.setString(8, data.getCep());
                stm.setString(9, data.getProdut_type());
                stm.setInt(10, data.getId());
                stm.execute();
                JOptionPane.showMessageDialog(null, "Fornecedor Actualizado Com Sucesso!");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        
        return false;
    }
    
    
    
}
