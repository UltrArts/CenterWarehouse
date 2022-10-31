package Model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
public class DBConnection {
//    private static String driver = "com.mysql.jdbc.Driver";
//    private static String url = "jdbc:mysql://localhost:3306/dmi-inf2ano_tech"; 
//    private static String user = "root";                  //'root' is username
//    private static String password = "";      

        private final String DB_URL = "jdbc:mysql://localhost:3306/warehouse";
        private final String PASSWORD = "";
        public Connection conn = null;
        public Statement stmt = null;
        public ResultSet res;
        
    public boolean connect(){ 
        try {
            conn = DriverManager.getConnection(DB_URL,"root",PASSWORD);
//            JOptionPane.showMessageDialog(null, "SUCESSO ");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA CONEXÃO: "+ex);
            return false;
        }
    
    }
    
    public void Disconnect(){
            try {
//                JOptionPane.showMessageDialog(null, "DESCONECTANDO ");
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "FALHA AO FECHAR A CONEXÃO: "+ex);
            }
    }
    
    public void runSQL(String sql){
            try {
                stmt = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                res = stmt.executeQuery(sql);
            } catch (SQLException ex) {
                Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"ERRO DE SQL: "+ex);
            }
    }
    
    
}
