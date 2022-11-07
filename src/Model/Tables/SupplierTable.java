package Model.Tables;

import Controller.SupplierController;
import Model.Supplier;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SupplierTable {
    DefaultTableModel tblmodel = new DefaultTableModel();
    SupplierController suppCtrl = new SupplierController();
    private int rowIndex;
    
    
    public SupplierTable(DefaultTableModel tblmodel){
        this.tblmodel = tblmodel;
    }

    public int getRowIndex(JTable tbl) {
        return tbl.getSelectedRow();
    }
    
    
    public void list(){
        Object[] row = new Object[12];
        ArrayList<Supplier> user = suppCtrl.getSuppliers();
        for(int i = 0; i < user.size(); i++){
            String status;
//            if(user.get(i).isStatus()) status = "ACTIVO"; else status = "DESACTIVADO";
            row[0] = user.get(i).getId();
            row[1] = user.get(i).getName();
            row[2] = user.get(i).getProdut_type();
            row[3] = user.get(i).getContact();
            row[4] = user.get(i).getEmail();
            row[5] = user.get(i).getCountry();
            row[6] = user.get(i).getCountry_cod();
            row[7] = user.get(i).getAddress();
            row[8] = user.get(i).getNuit();
            row[9] = user.get(i).getCep();
            row[10] = user.get(i).getCreated_at();
            row[11] = user.get(i).getUpdated_at();
            
            tblmodel.addRow(row);
                
        }
    }
}
