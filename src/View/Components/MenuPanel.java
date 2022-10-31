
package View.Components;

import Event.EventMenuSelected;
import Model.MenuModel;
import com.sun.prism.paint.Gradient;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;

public class MenuPanel extends javax.swing.JPanel {

   private EventMenuSelected event;
    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
        menuList1.addEventMenuSelected(event);
    }
    public MenuPanel() {
        initComponents();
        setOpaque(false);
        menuList1.setOpaque(false);
        this.init();
    }
    
    
    private void init(){
        menuList1.addItem(new MenuModel("1", "DASHBOARD", MenuModel.MenuType.MENU));
        menuList1.addItem(new MenuModel("2", "PRODUTOS", MenuModel.MenuType.MENU));
        menuList1.addItem(new MenuModel("3", "LOJAS", MenuModel.MenuType.MENU));
        menuList1.addItem(new MenuModel("4", "FORNECEDOR", MenuModel.MenuType.MENU));
        menuList1.addItem(new MenuModel("5", "ENTRADAS", MenuModel.MenuType.MENU));
        menuList1.addItem(new MenuModel("6", "SAÍDAS", MenuModel.MenuType.MENU));
        menuList1.addItem(new MenuModel("", "", MenuModel.MenuType.EMPTY));
        
        menuList1.addItem(new MenuModel("", "ADMINISTRAÇÃO", MenuModel.MenuType.TITLE));
        menuList1.addItem(new MenuModel("", "", MenuModel.MenuType.EMPTY));
        menuList1.addItem(new MenuModel("7", "USUÁRIOS", MenuModel.MenuType.MENU));
        menuList1.addItem(new MenuModel("8", "HISTÓRICO", MenuModel.MenuType.MENU));
        menuList1.addItem(new MenuModel("", "", MenuModel.MenuType.EMPTY));
        menuList1.addItem(new MenuModel("", "CONFIGURAÇÕES", MenuModel.MenuType.TITLE));
        menuList1.addItem(new MenuModel("", "", MenuModel.MenuType.EMPTY));
        menuList1.addItem(new MenuModel("9", "PERFIL", MenuModel.MenuType.MENU));
        menuList1.addItem(new MenuModel("10", "SAIR", MenuModel.MenuType.MENU));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel1 = new View.Components.HeaderPanel();
        pnMoving = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menuList1 = new View.MenuList<>();

        pnMoving.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imgs/logo_light.png"))); // NOI18N
        jLabel1.setText("Warehouse");

        javax.swing.GroupLayout pnMovingLayout = new javax.swing.GroupLayout(pnMoving);
        pnMoving.setLayout(pnMovingLayout);
        pnMovingLayout.setHorizontalGroup(
            pnMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMovingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnMovingLayout.setVerticalGroup(
            pnMovingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnMovingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMoving, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(menuList1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMoving, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(menuList1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintChildren(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#1CB5E0"), 0,  getHeight(), Color.decode("#000046"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        g2.fillRect(getWidth()-20, 0, getWidth(), getHeight());
        super.paintChildren(grphcs); //To change body of generated methods, choose Tools | Templates.
    }

    private int x,y;
    public void initMoving(JFrame frame){
        pnMoving.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                x = e.getX();
                y = e.getY();
            }
        });
        pnMoving.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e){
                frame.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Components.HeaderPanel headerPanel1;
    private javax.swing.JLabel jLabel1;
    private View.MenuList<String> menuList1;
    private javax.swing.JPanel pnMoving;
    // End of variables declaration//GEN-END:variables
}
