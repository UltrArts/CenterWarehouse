package Controller;

import Model.DBConnection;
import Model.Driver;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DriverController {
    DBConnection db = new DBConnection();
    Driver driver;
    
    public boolean save(Driver data){
        if(db.connect()){
            PreparedStatement stm;
            try {
                stm = db.conn.prepareStatement("INSERT INTO driver(name, last_name, contact, car_cod) VALUES(?, ?, ?, ?)");
                stm.setString(1, data.getName());
                stm.setString(2, data.getLastname());
                stm.setString(3, data.getContact());
                stm.setString(4, data.getCar_cod());
                stm.execute();
                JOptionPane.showMessageDialog(null, "Motorista Gravado Com Sucesso");
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERRO: "+ex);
            }finally{
                db.Disconnect();
            }
        }
        return false;
    }
    
    
     public ArrayList<Driver> getDrivers(){
        ArrayList<Driver> data = new ArrayList<>();
         if(db.connect()){
             String sql = "SELECT * FROM driver";
            try {
               db.runSQL(sql);
                while(db.res.next()){
//                    db.res.first();
                   driver = new Driver(db.res.getString("car_cod"), db.res.getInt("id"), db.res.getString("name"), db.res.getString("last_name"));
                    data.add(driver);
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
     
}
