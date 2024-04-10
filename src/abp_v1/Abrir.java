package abp_v1;

import javax.swing.table.DefaultTableModel;

public class Abrir extends javax.swing.JFrame {
    
    DefaultTableModel df = new DefaultTableModel();
    SQL sql = new SQL();
    Ventana ve;
    String type;
    
    public Abrir(Ventana v) {
        initComponents();        
        ve=v;
        setLocationRelativeTo(null);
    }

    private Abrir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDf(String tipo){
        jTable1.setModel(sql.showReg(ve.User,tipo));
        type=tipo;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jb_Abrir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(254, 250, 224));

        jTable1.setBackground(new java.awt.Color(254, 250, 224));
        jTable1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jb_Abrir.setBackground(new java.awt.Color(221, 184, 146));
        jb_Abrir.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jb_Abrir.setText("Abrir");
        jb_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb_AbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jb_Abrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb_Abrir, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        
    }//GEN-LAST:event_jTable1MouseEntered

    private void jb_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb_AbrirActionPerformed
        if ("Elipse".equals(type)) {
            ve.p.puntoCentroE.setLocation((Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString()) * 10) + ve.p.getWidth() / 2, (Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString()) * 10) + ve.p.getHeight() / 2);
            ve.p.puntoFinalE.setLocation((Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString()) * 10) + ve.p.getWidth() / 2, (Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString()) * 10) + ve.p.getHeight() / 2);
            ve.cont = 4;
            ve.deshabilitar();
            ve.repaint();
            dispose();
        } else {
            if ("Circunferencia".equals(type)) {
                ve.p.puntoCentroC.setLocation((Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString()) * 10) + ve.p.getWidth() / 2, (Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString()) * 10) + ve.p.getHeight() / 2);
                ve.p.puntoTanCM.setLocation((Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString()) * 10) + ve.p.getWidth() / 2, (Integer.parseInt(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString()) * 10) + ve.p.getHeight() / 2);
                ve.cont = 1;
                ve.deshabilitar();
                ve.repaint();
                dispose();
            } else{
                if("Parabola".equals(type)){
                    
                }
            }
        }
    }//GEN-LAST:event_jb_AbrirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Abrir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jb_Abrir;
    // End of variables declaration//GEN-END:variables

}
