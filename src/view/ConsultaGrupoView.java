/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConsultaGrupoView.java
 *
 * Created on 21/01/2013, 19:13:03
 */
package view;

import ctrl.UsuarioCtrl;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Raphael
 */
public class ConsultaGrupoView extends javax.swing.JFrame {

    private UsuarioCtrl ctrl;
    private UsuarioView view;

    public ConsultaGrupoView(UsuarioCtrl ctrl, UsuarioView view) {
        initComponents();
        this.ctrl = ctrl;
        this.view = view;
        ctrl.setConsultaGrupoView(this);
    }

    public void zeraLinha() {
        DefaultTableModel dtm = (DefaultTableModel) jTableGrupo.getModel();
        dtm.setNumRows(0);
    }

    public void preencheTblGrupo(int codigo, String nome) {
        DefaultTableModel dtm = (DefaultTableModel) jTableGrupo.getModel();
        dtm.addRow(new Object[]{codigo, nome});
    }

    public void PegaGrupo() {
        DefaultTableModel dtm = (DefaultTableModel) jTableGrupo.getModel();
        int i = jTableGrupo.getSelectedRow();
        Integer codigo = (Integer) jTableGrupo.getValueAt(i, 0);
        String nome = (String) jTableGrupo.getValueAt(i, 1);
        view.setUsuariogrupoid(codigo);
        view.setGruponome(nome);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldConsultaGrupo = new javax.swing.JTextField();
        BotaoImportar = new javax.swing.JButton();
        BotaoPesquisar = new javax.swing.JButton();
        BotaoIncluir = new javax.swing.JButton();
        BotaoFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableGrupo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta de Grupo");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextFieldConsultaGrupo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldConsultaGrupoPropertyChange(evt);
            }
        });
        jTextFieldConsultaGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldConsultaGrupoKeyTyped(evt);
            }
        });

        BotaoImportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Bt_Importar.png"))); // NOI18N
        BotaoImportar.setText("Importar");
        BotaoImportar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoImportarMouseClicked(evt);
            }
        });

        BotaoPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Bt_Pesquisar.png"))); // NOI18N
        BotaoPesquisar.setText("Pesquisar");
        BotaoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoPesquisarActionPerformed(evt);
            }
        });

        BotaoIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Bt_Novo.png"))); // NOI18N
        BotaoIncluir.setText("Incluir");
        BotaoIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoIncluirActionPerformed(evt);
            }
        });

        BotaoFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Bt_Fechar.PNG"))); // NOI18N
        BotaoFechar.setText("Fechar");
        BotaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldConsultaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BotaoImportar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoFechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldConsultaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoImportar)
                    .addComponent(BotaoPesquisar)
                    .addComponent(BotaoIncluir)
                    .addComponent(BotaoFechar))
                .addContainerGap())
        );

        util.UpperCase consultagrupo = new util.UpperCase();
        consultagrupo.setMaxChars(50);
        jTextFieldConsultaGrupo.setDocument(consultagrupo);

        jTableGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CÓDIGO", "NOME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableGrupo.getTableHeader().setReorderingAllowed(false);
        jTableGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGrupoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableGrupo);
        jTableGrupo.getColumnModel().getColumn(0).setMinWidth(100);
        jTableGrupo.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTableGrupo.getColumnModel().getColumn(0).setMaxWidth(100);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

private void jTextFieldConsultaGrupoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldConsultaGrupoPropertyChange
}//GEN-LAST:event_jTextFieldConsultaGrupoPropertyChange

private void jTextFieldConsultaGrupoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldConsultaGrupoKeyTyped
    if (!jTextFieldConsultaGrupo.getText().equals("")) {
        this.zeraLinha();
        ctrl.preencheTblGrupo(jTextFieldConsultaGrupo.getText());
    }
}//GEN-LAST:event_jTextFieldConsultaGrupoKeyTyped

private void BotaoImportarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoImportarMouseClicked
    if (evt.getClickCount() == 1) {
        this.PegaGrupo();
        this.dispose();

    }
}//GEN-LAST:event_BotaoImportarMouseClicked

private void BotaoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPesquisarActionPerformed
    ctrl.preencheTblGrupo(jTextFieldConsultaGrupo.getText());
}//GEN-LAST:event_BotaoPesquisarActionPerformed

private void BotaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoIncluirActionPerformed
    GrupoView.getInstance().setVisible(true);
    GrupoView.getInstance().habilita();
}//GEN-LAST:event_BotaoIncluirActionPerformed

private void BotaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFecharActionPerformed
    this.dispose();
}//GEN-LAST:event_BotaoFecharActionPerformed

private void jTableGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGrupoMouseClicked
    if (evt.getClickCount() == 2) {
        this.PegaGrupo();
        this.dispose();

    }
}//GEN-LAST:event_jTableGrupoMouseClicked
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoFechar;
    private javax.swing.JButton BotaoImportar;
    private javax.swing.JButton BotaoIncluir;
    private javax.swing.JButton BotaoPesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableGrupo;
    private javax.swing.JTextField jTextFieldConsultaGrupo;
    // End of variables declaration//GEN-END:variables
}