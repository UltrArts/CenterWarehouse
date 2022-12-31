package Model.Tables;

import Controller.CheckInController;
import Model.CheckIn;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CheckInTable {
    DefaultTableModel tblmodel = new DefaultTableModel();
    CheckInController checkInCtrl = new CheckInController();
    private int rowIndex;
    
    
    public CheckInTable(DefaultTableModel tblmodel){
        this.tblmodel = tblmodel;
    }

    public int getRowIndex(JTable tbl) {
        return tbl.getSelectedRow();
    }
    
    
    public void list(){
        Object[] row = new Object[8];
        ArrayList<CheckIn> check = checkInCtrl.getCheckIns();
        for(int i = 0; i < check.size(); i++){
            String status;
            row[0] = check.get(i).getId();
            row[1] = check.get(i).getProd_name();
            row[2] = check.get(i).getPrice();
            row[3] = check.get(i).getAmount();
            row[4] = check.get(i).getSupplier();
            row[5] = check.get(i).getExpire_date();
            row[6] = check.get(i).getDriver_name();
            row[7] = check.get(i).getCreated_at();
            
            tblmodel.addRow(row);
                
        }
    }
}
