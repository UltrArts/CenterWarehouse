
package View;

import Event.EventMenuSelected;
import Model.DBConnection;
import View.Forms.CheckInForm;
import View.Forms.CheckOutForm;
import View.Forms.HistoricForm;
import View.Forms.HomeForm;
import View.Forms.LoginForme;
import View.Forms.ProductForm;
import View.Forms.ProfileForm;
import View.Forms.StoreForm;
import View.Forms.SuppliersForm;
import View.Forms.UserForm;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JOptionPane;


public class MainFrame extends javax.swing.JFrame {
    private HomeForm dashboard;
    private ProductForm prodForm;
    private StoreForm storeForm;
    private SuppliersForm supForm;
    private CheckInForm inForm;
    private CheckOutForm outForm;
    private UserForm userForm;
    private HistoricForm histForm;
    private ProfileForm profileForm;
    public MainFrame() {
        initComponents();        
        setBackground(new Color(0, 0, 0,0 ));
        dashboard = new HomeForm();
        prodForm = new ProductForm();
        storeForm = new StoreForm();
        supForm = new SuppliersForm();
        inForm = new CheckInForm();
        outForm = new CheckOutForm();
        userForm = new UserForm();
        histForm = new HistoricForm();
        profileForm = new ProfileForm();
         menuPanel.initMoving(MainFrame.this);
         menuPanel.addEventMenuSelected(new EventMenuSelected() {
            @Override
//             menuList1.addItem(new MenuModel("1", "DASHBOARD", MenuModel.MenuType.MENU));
//        menuList1.addItem(new MenuModel("2", "PRODUTOS", MenuModel.MenuType.MENU));
//        menuList1.addItem(new MenuModel("3", "LOJAS", MenuModel.MenuType.MENU));
//        menuList1.addItem(new MenuModel("4", "FORNECEDOR", MenuModel.MenuType.MENU));
//        menuList1.addItem(new MenuModel("5", "ENTRADAS", MenuModel.MenuType.MENU));
//        menuList1.addItem(new MenuModel("6", "SAÍDAS", MenuModel.MenuType.MENU));
//        menuList1.addItem(new MenuModel("", "", MenuModel.MenuType.EMPTY));
//        
//        menuList1.addItem(new MenuModel("", "ADMINISTRAÇÃO", MenuModel.MenuType.TITLE));
//        menuList1.addItem(new MenuModel("", "", MenuModel.MenuType.EMPTY));
//        menuList1.addItem(new MenuModel("7", "USUÁRIOS", MenuModel.MenuType.MENU));
//        menuList1.addItem(new MenuModel("8", "HISTÓRICO", MenuModel.MenuType.MENU));
//        menuList1.addItem(new MenuModel("", "", MenuModel.MenuType.EMPTY));
//        menuList1.addItem(new MenuModel("", "CONFIGURAÇÕES", MenuModel.MenuType.TITLE));
//        menuList1.addItem(new MenuModel("", "", MenuModel.MenuType.EMPTY));
//        menuList1.addItem(new MenuModel("9", "PERFIL", MenuModel.MenuType.MENU));
            public void selected(int index) {
                DBConnection db = new DBConnection();
                switch (index) {
                    case 0:
                        setForm(dashboard);
                        break;
                    case 1:
                        setForm(prodForm);
                        break;
                    case 2:
                        setForm(storeForm);
                        break;
                    case 3:
                        setForm(supForm);
                        break;
                    case 4:
                        setForm(inForm);
                        break;
                    case 5:
                        setForm(outForm);
                        break;
                    case 9:
                        setForm(userForm);
                        break;
                    case 10:
                        setForm(histForm);
                        break;
                    case 14:
                        setForm(profileForm);
                        break;
                    case 15:
                        exit();
                        break;
                    default:
                        break;
                }
            }
        });
        //  set when system open start with home form
        setForm(new HomeForm());
    }
    
    private void exit(){
         if(JOptionPane.showConfirmDialog(null, "Tem certeza quepretende Sair?") == 0){
            JOptionPane.showMessageDialog(null,"Adeus, Volte Sempre!");
            dispose();
            LoginForme lf = new LoginForme();
            lf.setVisible(true);
        }
    }
    
    
    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new View.PanelBorder();
        menuPanel = new View.Components.MenuPanel();
        footerPanel2 = new View.Components.FooterPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelBorder1.setBackground(new java.awt.Color(220, 220, 220));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Edson Da Cruz & João Baciquete");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Center Warehouse");

        javax.swing.GroupLayout footerPanel2Layout = new javax.swing.GroupLayout(footerPanel2);
        footerPanel2.setLayout(footerPanel2Layout);
        footerPanel2Layout.setHorizontalGroup(
            footerPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, footerPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        footerPanel2Layout.setVerticalGroup(
            footerPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(footerPanel2Layout.createSequentialGroup()
                .addGroup(footerPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(footerPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 974, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(menuPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(footerPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Components.FooterPanel footerPanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainPanel;
    private View.Components.MenuPanel menuPanel;
    private View.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
