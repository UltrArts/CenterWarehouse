package centerwarehouse;

import Controller.UserController;
import View.Forms.LoginForme;
import View.MainFrame;
import javax.swing.JOptionPane;

public class CenterWarehouse {
    public static void main(String[] args) {
        // TODO code application logic here
//        System.out.print("jhgvcx");
    
//}
          
         UserController userCtrl = new UserController();
          if(userCtrl.getUsers().size() == 0){
              JOptionPane.showMessageDialog(null, "O Sistema precisa efectuar configurações de predefinição! \nPressione Ok para continuar!");
              userCtrl.seed();
          };
//          MainFrame mf = new MainFrame();
//          mf.setVisible(true);
          LoginForme lf = new LoginForme();
          lf.setVisible(true);
//          
    }
}
