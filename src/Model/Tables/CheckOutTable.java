package Model.Tables;

import Controller.CheckOutController;
import Model.CheckIn;
import Model.CheckOut;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CheckOutTable {
     DefaultTableModel tblmodel = new DefaultTableModel();
    CheckOutController checkOutCtrl = new CheckOutController();
    private int rowIndex;
    
    
    public CheckOutTable(DefaultTableModel tblmodel){
        this.tblmodel = tblmodel;
    }

    public int getRowIndex(JTable tbl) {
        return tbl.getSelectedRow();
    }
    
    
    public void list(){
        Object[] row = new Object[8];
        ArrayList<CheckOut> check = checkOutCtrl.getCheckOuts();
        for(int i = 0; i < check.size(); i++){
            String status;
            row[0] = check.get(i).getId();
            row[1] = check.get(i).getProd_name();
            row[2] = check.get(i).getAmount();
            row[3] = check.get(i).getDriver_name();
            row[4] = check.get(i).getStore();
            row[5] = check.get(i).getCreated_at();
            
            tblmodel.addRow(row);
                
        }
    }
    
}
