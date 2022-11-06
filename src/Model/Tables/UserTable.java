package Model.Tables;

import Controller.UserController;
import Model.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserTable {
    DefaultTableModel tblmodel = new DefaultTableModel();
    UserController userCtrl = new UserController();
    private int rowIndex;
    
    
    public UserTable(DefaultTableModel tblmodel){
        this.tblmodel = tblmodel;
    }

    public int getRowIndex(JTable tbl) {
        return tbl.getSelectedRow();
    }
    
    public void list(){
        Object[] row = new Object[11];
        ArrayList<User> user = userCtrl.getUsers();
        for(int i = 0; i < user.size(); i++){
            String status;
            if(user.get(i).isStatus()) status = "ACTIVO"; else status = "DESACTIVADO";
            row[0] = user.get(i).getId();
            row[1] = user.get(i).getName();
            row[2] = user.get(i).getLastname();
            row[3] = user.get(i).getBi();
            row[4] = user.get(i).getAdress();
            row[5] = user.get(i).getContact();
            row[6] = user.get(i).getUsername();
            row[7] = user.get(i).getProfile();
            row[8] = status;
            row[9] = user.get(i).getCreated_at();
            row[10] = user.get(i).getUpdated_at();
            
            tblmodel.addRow(row);
                
        }
    }
}
