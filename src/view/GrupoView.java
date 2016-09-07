package view;

import ctrl.GrupoCTRL;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Grupo;
import relatorios.Reports;

public class GrupoView extends javax.swing.JFrame {

    private GrupoCTRL GrupoCtrl = new GrupoCTRL(this);
    private DefaultTableModel modeloTabela;
    private static GrupoView _instance = null;

    /**
     * Creates new form ModeloView
     */
    public GrupoView() {
        initComponents();
        this.desabilita();
        GrupoCtrl.atualizaTabelaGrupo();
        modeloTabela = (DefaultTableModel) TblGrupo.getModel();
    }

    public static GrupoView getInstance() {
        if (_instance == null) {
            _instance = new GrupoView();
        }
        return _instance;
    }

    public void setGrupoid(int vGrupoid) {
        if (vGrupoid == 0) {
            jTextFieldgrupoid.setText("");
        } else {
            jTextFieldgrupoid.setText(Integer.toString(vGrupoid));
        }
    }

    public int getGrupoid() {
        int id = 0;
        if (!jTextFieldgrupoid.getText().trim().equals("")) {
            id = Integer.parseInt(jTextFieldgrupoid.getText());
        }
        return id;
    }

    public void setGruponome(String vGruponome) {
        jTextFieldgruponome.setText(vGruponome);
    }

    public String getGruponome() {
        return jTextFieldgruponome.getText();
    }

    public void zeraLinhasTblGrupo() {
        DefaultTableModel dtm = (DefaultTableModel) TblGrupo.getModel();
        dtm.setNumRows(0);

    }

    public void adicionaTblGrupo(int Grupoid, String Gruponome) {
        DefaultTableModel dtm = (DefaultTableModel) TblGrupo.getModel();
        dtm.addRow(new Object[]{Grupoid, Gruponome});
    }

    public void desabilita() {
        jTextFieldgrupoid.setEnabled(false);
        jTextFieldgruponome.setEnabled(false);
        BtConfirmar.setEnabled(false);
        ConfirmarBotao.setEnabled(false);
        jMenuItemSalvar.setEnabled(false);
    }

    public void habilita() {
        jTextFieldgrupoid.setEnabled(false);
        jTextFieldgruponome.setEnabled(true);
        BtConfirmar.setEnabled(true);
        ConfirmarBotao.setEnabled(true);
        TblGrupo.setFocusable(false);
        jTextFieldgruponome.requestFocus();
        jMenuItemSalvar.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar3 = new javax.swing.JToolBar();
        NovoBotao1 = new javax.swing.JButton();
        ConfirmarBotao = new javax.swing.JButton();
        EditarBotao = new javax.swing.JButton();
        CancelarBotao = new javax.swing.JButton();
        ExcluirBotao = new javax.swing.JButton();
        PrimeiroBotao = new javax.swing.JButton();
        AnteriorBotao = new javax.swing.JButton();
        ProximoBotao = new javax.swing.JButton();
        UltimoBotao = new javax.swing.JButton();
        ImprimirBotao = new javax.swing.JButton();
        ImprimirBotao2 = new javax.swing.JButton();
        FecharBotao = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelgruponome = new javax.swing.JLabel();
        jLabelgrupoid = new javax.swing.JLabel();
        jTextFieldgruponome = new javax.swing.JTextField();
        jTextFieldgrupoid = new javax.swing.JTextField();
        masterScrollPane = new javax.swing.JScrollPane();
        TblGrupo = new javax.swing.JTable();
        BtConfirmar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemnNovo = new javax.swing.JMenuItem();
        jMenuItemnEditar = new javax.swing.JMenuItem();
        jMenuItemCancelar = new javax.swing.JMenuItem();
        jMenuItemExcluir = new javax.swing.JMenuItem();
        jMenuItemSalvar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemPrimeiro = new javax.swing.JMenuItem();
        jMenuItemProximo = new javax.swing.JMenuItem();
        jMenuItemAnterior = new javax.swing.JMenuItem();
        jMenuItemUltimo = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemImprimir = new javax.swing.JMenuItem();
        jMenuItemFechar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Grupos de Usuários");
        setResizable(false);

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.setEnabled(false);

        NovoBotao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Novo.png"))); // NOI18N
        NovoBotao1.setText("Inserir");
        NovoBotao1.setToolTipText("Inserir");
        NovoBotao1.setBorderPainted(false);
        NovoBotao1.setFocusable(false);
        NovoBotao1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NovoBotao1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        NovoBotao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoBotao1ActionPerformed(evt);
            }
        });
        jToolBar3.add(NovoBotao1);

        ConfirmarBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        ConfirmarBotao.setText("Confirmar");
        ConfirmarBotao.setToolTipText("Confirmar");
        ConfirmarBotao.setBorderPainted(false);
        ConfirmarBotao.setFocusable(false);
        ConfirmarBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ConfirmarBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ConfirmarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(ConfirmarBotao);

        EditarBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.png"))); // NOI18N
        EditarBotao.setText("Editar");
        EditarBotao.setToolTipText("Editar");
        EditarBotao.setBorderPainted(false);
        EditarBotao.setFocusable(false);
        EditarBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EditarBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        EditarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(EditarBotao);

        CancelarBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Cancelar.png"))); // NOI18N
        CancelarBotao.setText("Cancelar");
        CancelarBotao.setToolTipText("Cancelar");
        CancelarBotao.setBorderPainted(false);
        CancelarBotao.setFocusable(false);
        CancelarBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CancelarBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CancelarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(CancelarBotao);

        ExcluirBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        ExcluirBotao.setText("Excluir");
        ExcluirBotao.setToolTipText("Excluir");
        ExcluirBotao.setBorderPainted(false);
        ExcluirBotao.setFocusable(false);
        ExcluirBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ExcluirBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ExcluirBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(ExcluirBotao);

        PrimeiroBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Primeiro.png"))); // NOI18N
        PrimeiroBotao.setText("Primeiro");
        PrimeiroBotao.setToolTipText("Primeiro");
        PrimeiroBotao.setBorderPainted(false);
        PrimeiroBotao.setFocusable(false);
        PrimeiroBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PrimeiroBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        PrimeiroBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrimeiroBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(PrimeiroBotao);

        AnteriorBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Anterior.png"))); // NOI18N
        AnteriorBotao.setText("Anterior");
        AnteriorBotao.setToolTipText("Anterior");
        AnteriorBotao.setBorderPainted(false);
        AnteriorBotao.setFocusable(false);
        AnteriorBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AnteriorBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        AnteriorBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnteriorBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(AnteriorBotao);

        ProximoBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Proximo.png"))); // NOI18N
        ProximoBotao.setText("Próximo");
        ProximoBotao.setToolTipText("Próximo");
        ProximoBotao.setBorderPainted(false);
        ProximoBotao.setFocusable(false);
        ProximoBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ProximoBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ProximoBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProximoBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(ProximoBotao);

        UltimoBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Ultimo.png"))); // NOI18N
        UltimoBotao.setText("Último");
        UltimoBotao.setToolTipText("Último");
        UltimoBotao.setBorderPainted(false);
        UltimoBotao.setFocusable(false);
        UltimoBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        UltimoBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        UltimoBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UltimoBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(UltimoBotao);

        ImprimirBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imprimir.png"))); // NOI18N
        ImprimirBotao.setText("Imprimir");
        ImprimirBotao.setToolTipText("Imprimir");
        ImprimirBotao.setBorderPainted(false);
        ImprimirBotao.setFocusable(false);
        ImprimirBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImprimirBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ImprimirBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(ImprimirBotao);

        ImprimirBotao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Ajuda.png"))); // NOI18N
        ImprimirBotao2.setText("Ajuda");
        ImprimirBotao2.setToolTipText("Ajuda");
        ImprimirBotao2.setBorderPainted(false);
        ImprimirBotao2.setFocusable(false);
        ImprimirBotao2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImprimirBotao2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(ImprimirBotao2);

        FecharBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Door.PNG"))); // NOI18N
        FecharBotao.setText("Fechar");
        FecharBotao.setToolTipText("Fechar");
        FecharBotao.setBorderPainted(false);
        FecharBotao.setFocusable(false);
        FecharBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FecharBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FecharBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(FecharBotao);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabelgruponome.setText("*Nome:");

        jLabelgrupoid.setText("Código:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelgrupoid)
                    .addComponent(jLabelgruponome))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldgrupoid, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldgruponome, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldgrupoid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldgruponome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelgruponome)))
                    .addComponent(jLabelgrupoid))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        util.UpperCase gruponome = new util.UpperCase();
        gruponome.setMaxChars(50);
        jTextFieldgruponome.setDocument(gruponome);

        TblGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
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
        TblGrupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblGrupoMouseClicked(evt);
            }
        });
        TblGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TblGrupoKeyReleased(evt);
            }
        });
        masterScrollPane.setViewportView(TblGrupo);
        TblGrupo.getColumnModel().getColumn(0).setMinWidth(100);
        TblGrupo.getColumnModel().getColumn(0).setPreferredWidth(100);
        TblGrupo.getColumnModel().getColumn(0).setMaxWidth(100);

        BtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Bt_Confirmar.png"))); // NOI18N
        BtConfirmar.setText("Confirmar");
        BtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConfirmarActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");

        jMenuItemnNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemnNovo.setText("Novo");
        jMenuItemnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemnNovoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemnNovo);

        jMenuItemnEditar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemnEditar.setText("Editar");
        jMenuItemnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemnEditarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemnEditar);

        jMenuItemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCancelar.setText("Cancelar");
        jMenuItemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCancelarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCancelar);

        jMenuItemExcluir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItemExcluir.setText("Excluir");
        jMenuItemExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExcluir);

        jMenuItemSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSalvar.setText("Salvar");
        jMenuItemSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalvarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSalvar);
        jMenu1.add(jSeparator1);

        jMenuItemPrimeiro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItemPrimeiro.setText("Primeiro");
        jMenuItemPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrimeiroActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemPrimeiro);

        jMenuItemProximo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItemProximo.setText("Próximo");
        jMenuItemProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProximoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemProximo);

        jMenuItemAnterior.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItemAnterior.setText("Anterior");
        jMenuItemAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAnteriorActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAnterior);

        jMenuItemUltimo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItemUltimo.setText("Último");
        jMenuItemUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUltimoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemUltimo);
        jMenu1.add(jSeparator2);

        jMenuItemImprimir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemImprimir.setText("Imprimir");
        jMenuItemImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImprimirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemImprimir);

        jMenuItemFechar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItemFechar.setText("Fechar");
        jMenuItemFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFecharActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemFechar);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(masterScrollPane)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtConfirmar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(BtConfirmar)
                .addContainerGap())
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

private void jMenuItemnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemnNovoActionPerformed
    GrupoCtrl.novo();
}//GEN-LAST:event_jMenuItemnNovoActionPerformed

private void jMenuItemnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemnEditarActionPerformed
    if (GrupoCtrl.getObGrupo() == null) {
        JOptionPane.showMessageDialog(this, "Selecione primeiro um Grupo", "Alerta!", JOptionPane.WARNING_MESSAGE);
    } else {
        this.habilita();

    }
}//GEN-LAST:event_jMenuItemnEditarActionPerformed

private void jMenuItemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCancelarActionPerformed
    GrupoCtrl.cancelar();
}//GEN-LAST:event_jMenuItemCancelarActionPerformed

private void jMenuItemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirActionPerformed
    GrupoCtrl.excluir();
}//GEN-LAST:event_jMenuItemExcluirActionPerformed

private void jMenuItemSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalvarActionPerformed
    GrupoCtrl.gravar();
}//GEN-LAST:event_jMenuItemSalvarActionPerformed

private void jMenuItemPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPrimeiroActionPerformed
    passarPrimeiro();
}//GEN-LAST:event_jMenuItemPrimeiroActionPerformed

private void jMenuItemProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProximoActionPerformed
    passarProximo();
}//GEN-LAST:event_jMenuItemProximoActionPerformed

private void jMenuItemAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAnteriorActionPerformed
    passarAnterior();
}//GEN-LAST:event_jMenuItemAnteriorActionPerformed

private void jMenuItemUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUltimoActionPerformed
    passarUltimo();
}//GEN-LAST:event_jMenuItemUltimoActionPerformed

private void jMenuItemImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImprimirActionPerformed
    Imprimir();
}//GEN-LAST:event_jMenuItemImprimirActionPerformed

private void jMenuItemFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFecharActionPerformed
    this.dispose();
}//GEN-LAST:event_jMenuItemFecharActionPerformed

private void NovoBotao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoBotao1ActionPerformed
    GrupoCtrl.novo();
}//GEN-LAST:event_NovoBotao1ActionPerformed

private void ConfirmarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarBotaoActionPerformed
    GrupoCtrl.gravar();
}//GEN-LAST:event_ConfirmarBotaoActionPerformed

private void EditarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBotaoActionPerformed
    if (GrupoCtrl.getObGrupo() == null) {
        JOptionPane.showMessageDialog(this, "Selecione primeiro um Grupo", "Alerta!", JOptionPane.WARNING_MESSAGE);
    } else {
        this.habilita();
    }
}//GEN-LAST:event_EditarBotaoActionPerformed

private void CancelarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBotaoActionPerformed
    GrupoCtrl.cancelar();
}//GEN-LAST:event_CancelarBotaoActionPerformed

private void ExcluirBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirBotaoActionPerformed
    GrupoCtrl.excluir();
}//GEN-LAST:event_ExcluirBotaoActionPerformed

private void PrimeiroBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrimeiroBotaoActionPerformed
    passarPrimeiro();
}//GEN-LAST:event_PrimeiroBotaoActionPerformed

private void AnteriorBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnteriorBotaoActionPerformed
    passarAnterior();
}//GEN-LAST:event_AnteriorBotaoActionPerformed

private void ProximoBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProximoBotaoActionPerformed
    passarProximo();
}//GEN-LAST:event_ProximoBotaoActionPerformed

private void UltimoBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UltimoBotaoActionPerformed
    passarUltimo();
}//GEN-LAST:event_UltimoBotaoActionPerformed

private void ImprimirBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirBotaoActionPerformed
    Imprimir();
}//GEN-LAST:event_ImprimirBotaoActionPerformed

private void FecharBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharBotaoActionPerformed
    this.dispose();
}//GEN-LAST:event_FecharBotaoActionPerformed

private void TblGrupoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblGrupoMouseClicked
    DefaultTableModel model = (DefaultTableModel) TblGrupo.getModel();
    int linhaClicada = TblGrupo.getSelectedRow();
    int grupoid = (Integer) model.getValueAt(linhaClicada, 0);
    String gruponome = (String) model.getValueAt(linhaClicada, 1);

    jTextFieldgrupoid.setText(Integer.toString(grupoid));
    jTextFieldgruponome.setText(gruponome);

    Grupo obGrupo = new Grupo();
    obGrupo.setGrupoid(grupoid);
    obGrupo.setGruponome(gruponome);

    GrupoCtrl.setObGrupo(obGrupo);
}//GEN-LAST:event_TblGrupoMouseClicked

    public void passarPrimeiro() {
        TblGrupo.setRowSelectionInterval(TblGrupo.getRowCount() - 1, TblGrupo.getRowCount() - 1);
        GrupoCtrl.buscar((Integer) modeloTabela.getValueAt(TblGrupo.getRowCount() - 1, 0));
    }

    public void passarProximo() {
        int rowSelected = TblGrupo.getSelectedRow();
        if (rowSelected != 0) {
            TblGrupo.setRowSelectionInterval(rowSelected - 1, rowSelected - 1);
            GrupoCtrl.buscar((Integer) modeloTabela.getValueAt(rowSelected - 1, 0));
        }
    }

    public void passarAnterior() {
        int rowSelected = TblGrupo.getSelectedRow();
        if (rowSelected + 1 < TblGrupo.getRowCount()) {
            TblGrupo.setRowSelectionInterval(rowSelected + 1, rowSelected + 1);
            GrupoCtrl.buscar((Integer) modeloTabela.getValueAt(rowSelected + 1, 0));
        }

    }

    private void TblGrupoPropertyChange(java.beans.PropertyChangeEvent evt) {
    }

    public void passarUltimo() {
        TblGrupo.setRowSelectionInterval(0, 0);
        GrupoCtrl.buscar((Integer) modeloTabela.getValueAt(0, 0));
    }

    public void Imprimir() {
        try {
            Reports.getInstance().Execute("Cadastro_Grupos.jasper");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

private void BtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConfirmarActionPerformed
    GrupoCtrl.gravar();
}//GEN-LAST:event_BtConfirmarActionPerformed

    private void TblGrupoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TblGrupoKeyReleased
        DefaultTableModel model = (DefaultTableModel) TblGrupo.getModel();
        int linhaClicada = TblGrupo.getSelectedRow();
        int idpais = (Integer) model.getValueAt(linhaClicada, 0);
        String nome = (String) model.getValueAt(linhaClicada, 1);

        jTextFieldgrupoid.setText(Integer.toString(idpais));
        jTextFieldgruponome.setText(nome);

        Grupo obGrupo = new Grupo();
        obGrupo.setGrupoid(idpais);
        obGrupo.setGruponome(nome);

        GrupoCtrl.setObGrupo(obGrupo);
    }//GEN-LAST:event_TblGrupoKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GrupoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GrupoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GrupoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GrupoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GrupoView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnteriorBotao;
    private javax.swing.JButton BtConfirmar;
    private javax.swing.JButton CancelarBotao;
    private javax.swing.JButton ConfirmarBotao;
    private javax.swing.JButton EditarBotao;
    private javax.swing.JButton ExcluirBotao;
    private javax.swing.JButton FecharBotao;
    private javax.swing.JButton ImprimirBotao;
    private javax.swing.JButton ImprimirBotao2;
    private javax.swing.JButton NovoBotao1;
    private javax.swing.JButton PrimeiroBotao;
    private javax.swing.JButton ProximoBotao;
    private javax.swing.JTable TblGrupo;
    private javax.swing.JButton UltimoBotao;
    private javax.swing.JLabel jLabelgrupoid;
    private javax.swing.JLabel jLabelgruponome;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAnterior;
    private javax.swing.JMenuItem jMenuItemCancelar;
    private javax.swing.JMenuItem jMenuItemExcluir;
    private javax.swing.JMenuItem jMenuItemFechar;
    private javax.swing.JMenuItem jMenuItemImprimir;
    private javax.swing.JMenuItem jMenuItemPrimeiro;
    private javax.swing.JMenuItem jMenuItemProximo;
    private javax.swing.JMenuItem jMenuItemSalvar;
    private javax.swing.JMenuItem jMenuItemUltimo;
    private javax.swing.JMenuItem jMenuItemnEditar;
    private javax.swing.JMenuItem jMenuItemnNovo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField jTextFieldgrupoid;
    private javax.swing.JTextField jTextFieldgruponome;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JScrollPane masterScrollPane;
    // End of variables declaration//GEN-END:variables
}
