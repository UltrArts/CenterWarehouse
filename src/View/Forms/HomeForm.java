package View.Forms;

import Model.CardModel;
import Model.TableStatusType;
import java.awt.Color;
import javax.swing.ImageIcon;

public class HomeForm extends javax.swing.JPanel {

    public HomeForm() {
        initComponents();
         card1.setData(new CardModel(new ImageIcon(getClass().getResource("/Imgs/stock.png")), "Stock Total", "200,000", "Aumento 10%"));
        card2.setData(new CardModel(new ImageIcon(getClass().getResource("/Imgs/profit.png")), "Usuários", "5,000", "Aumento 39%"));
        card3.setData(new CardModel(new ImageIcon(getClass().getResource("/Imgs/flag.png")), "Saídas", "100", "Aumento 20%"));
        //  add row tabletable
//        spTable.setVerticalScrollBar(new ScrollBar());
//        spTable.getVerticalScrollBar().setBackground(Color.WHITE);
//        spTable.getViewport().setBackground(Color.WHITE);
//        JPanel p = new JPanel();
//        p.setBackground(Color.WHITE);
//        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        int val = 1000;
        tbTable.addRow(new Object[]{val, "Banana", 30, "3000",TableStatusType.ACTIVO});
        tbTable.addRow(new Object[]{val+1, "Sapatos Casuais Zara", 270, "340",TableStatusType.ACTIVO});
        tbTable.addRow(new Object[]{val+2, "Modem", 40, "230",TableStatusType.INACTIVO});
        tbTable.addRow(new Object[]{val+3, "Pomada De Sapato", 45, "0",TableStatusType.ACTIVO});
        tbTable.addRow(new Object[]{val+4, "Roll On Nivea", 120, "30",TableStatusType.ACTIVO});
        tbTable.addRow(new Object[]{val+5, "Computador Dell Vostro", 30, "2300",TableStatusType.INACTIVO});
        tbTable.addRow(new Object[]{val+6, "Cadernos 180 pg", 20, "600",TableStatusType.INACTIVO});
        tbTable.addRow(new Object[]{val+7, "Compal 0.5l", 30, "3000",TableStatusType.ACTIVO});
        tbTable.addRow(new Object[]{val+8, "Nokia 1110", 270, "340",TableStatusType.INACTIVO});
        tbTable.addRow(new Object[]{val+9, "Bola De Futsal", 40, "230",TableStatusType.ACTIVO});
        tbTable.addRow(new Object[]{val+10, "BRinuedo Tanque De Guerra", 45, "0",TableStatusType.ACTIVO});
        tbTable.addRow(new Object[]{val+11, "Disco Rígido 500G", 120, "30",TableStatusType.ACTIVO});
        tbTable.addRow(new Object[]{val+12, "Chapa Zinco", 30, "2300",TableStatusType.ACTIVO});
        tbTable.addRow(new Object[]{val+13, "Capacete Weiner", 20, "600",TableStatusType.INACTIVO});
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnCards = new javax.swing.JLayeredPane();
        card1 = new View.Components.Card();
        card2 = new View.Components.Card();
        card3 = new View.Components.Card();
        panelBorder1 = new View.PanelBorder();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        tbTable = new View.Table();

        setBackground(new java.awt.Color(220, 220, 220));

        pnCards.setLayout(new java.awt.GridLayout(1, 0, 15, 0));

        card1.setColor1(new java.awt.Color(142, 142, 250));
        card1.setColor2(new java.awt.Color(123, 123, 245));
        pnCards.add(card1);

        card2.setColor1(new java.awt.Color(186, 123, 247));
        card2.setColor2(new java.awt.Color(167, 94, 236));
        pnCards.add(card2);

        card3.setColor1(new java.awt.Color(241, 208, 62));
        card3.setColor2(new java.awt.Color(211, 184, 61));
        pnCards.add(card3);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(103, 101, 101));
        jLabel1.setText("Relatório De Movimento De Produtos");

        spTable.setBorder(null);

        tbTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome Prod", "Entradas", "Saídas", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        spTable.setViewportView(tbTable);

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCards, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnCards, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private View.Components.Card card1;
    private View.Components.Card card2;
    private View.Components.Card card3;
    private javax.swing.JLabel jLabel1;
    private View.PanelBorder panelBorder1;
    private javax.swing.JLayeredPane pnCards;
    private javax.swing.JScrollPane spTable;
    private View.Table tbTable;
    // End of variables declaration//GEN-END:variables
}