package view;

import ctrl.FichaCTRL;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Ficha;




public class FichaVIEW extends javax.swing.JFrame {

    private FichaCTRL FichaCTRL = new FichaCTRL(this);
    private DefaultTableModel modeloTabela;
    private static FichaVIEW _instance = null;

    /**
     * Creates new form FichaView
     */
    public FichaVIEW() {
        initComponents();
        this.desabilita();
        FichaCTRL.atualizaTabelaFicha();
        modeloTabela = (DefaultTableModel) TblFicha.getModel();
    //    jDateChooserInicio.setDate(new Date());
    //    this.atualizaFoto();
    }

    public static FichaVIEW getInstance() {
        if (_instance == null) {
            _instance = new FichaVIEW();
        }

        return _instance;
    }

    public void setIDficha(int vIDficha) {
        if (vIDficha == 0) {
            jTextFieldIdficha.setText("");
        } else {
            jTextFieldIdficha.setText(Integer.toString(vIDficha));
        }
    }

    public int getIDficha() {
        int id = 0;
        if (!jTextFieldIdficha.getText().trim().equals("")) {
            id = Integer.parseInt(jTextFieldIdficha.getText());
        }
        return id;
    }

    public void setNome(String vNome) {
        jTextFieldNome.setText(vNome);
    }

    public String getNome() {
        return jTextFieldNome.getText();
    }

    public void setFicha(String vFicha) {
        jTextFieldFicha.setText(vFicha);
    }

    public String getFicha() {
        return jTextFieldFicha.getText();
    }

    public void setCodigo(String vCodigo) {
        jFormattedTextFieldCodigo.setText(vCodigo);
    }

    public String getCodigo() {
        return jFormattedTextFieldCodigo.getText();
    }

    public void setRelatorio(String vRelatorio) {
        jFormattedTextFieldRelatorio.setText(vRelatorio);
    }

    public String getRelatorio() {
        return jFormattedTextFieldRelatorio.getText();
    }

    public void setQuantidade(String vQuantidade) {
        jFormattedTextFieldQuantidade.setText(vQuantidade);
    }

    public String getQuantidade() {
        return jFormattedTextFieldQuantidade.getText();
    }

    public void setPares(String vPares) {
        jFormattedTextFieldPares.setText(vPares);
    }

    public String getPares() {
        return jFormattedTextFieldPares.getText();
    }

    public void setNumero(String vNumero) {
        jTextFieldNumero.setText(vNumero);
    }

    public String getNumero() {
        return jTextFieldNumero.getText();
    }

    public void setModelo(String vModelo) {
        jTextFieldModelo.setText(vModelo);
    }

    public String getModelo() {
        return jTextFieldModelo.getText();
    }

     
    public void setStatus(String vStatus) {
        if (vStatus.equals("A")) {
            jRadioButtonAtivo.setSelected(true);
        } else if (vStatus.equals("I")) {
            jRadioButtonInativo.setSelected(true);
        }
    }

    public String getStatus() {
        ButtonModel model = buttonGroupStatus.getSelection();
        return model.getActionCommand();
    }
    
        
    public void zeraLinhasTblFicha() {
        DefaultTableModel dtm = (DefaultTableModel) TblFicha.getModel();
        dtm.setNumRows(0);

    }

    public void adicionaTblFicha(int IDficha, String Nome, String Ficha , String Codigo, String Relatorio, String Quantidade, String Pares, String Numero, String Modelo, String Status) {
        DefaultTableModel dtm = (DefaultTableModel) TblFicha.getModel();
        dtm.addRow(new Object[]{IDficha, Nome, Ficha, Codigo, Relatorio, Quantidade, Pares, Numero, Modelo, Status});

    }

   

    public void desabilita() {
        jTextFieldIdficha.setEnabled(false);
        jTextFieldNome.setEnabled(false);
        jTextFieldFicha.setEnabled(false);
        jFormattedTextFieldCodigo.setEnabled(false);
        jFormattedTextFieldRelatorio.setEnabled(false);
        jFormattedTextFieldQuantidade.setEnabled(false);
        jFormattedTextFieldPares.setEnabled(false);
        jTextFieldNumero.setEnabled(false);
        jTextFieldModelo.setEnabled(false);
        jRadioButtonAtivo.setEnabled(false);
        jRadioButtonInativo.setEnabled(false);
        BtConfirmar.setEnabled(false);
        ConfirmarBotao.setEnabled(false);
        jMenuItemSalvar.setEnabled(false);
        
    }

    public void habilita() {
        jTextFieldIdficha.setEnabled(false);
        jTextFieldNome.setEnabled(true);
        jTextFieldFicha.setEnabled(true);
        jFormattedTextFieldCodigo.setEnabled(true);
        jFormattedTextFieldRelatorio.setEnabled(true);
        jFormattedTextFieldQuantidade.setEnabled(true);
        jFormattedTextFieldPares.setEnabled(true);
        jTextFieldNumero.setEnabled(true);
        jTextFieldModelo.setEnabled(true);
        jRadioButtonAtivo.setEnabled(false);
        jRadioButtonInativo.setEnabled(false);
        BtConfirmar.setEnabled(true);
        ConfirmarBotao.setEnabled(true);
        TblFicha.setFocusable(false);
        jTextFieldNome.requestFocus();
        jMenuItemSalvar.setEnabled(true);
    }

//     public void atualizaFoto () {
//       // lbFoto.setIcon(new ImageIcon("/Programacao/PROJETO_SEGURO/EasySeg/src/Fotos/Usuario"+jTextFieldusuariofoto.getText()));
//        lbFoto.setIcon(new ImageIcon("C:\\Programacao\\PROJETO_SEGURO\\EasySeg\\src\\Fotos\\Ficha\\"+jTextFieldFoto.getText()));
//       
//    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupStatus = new javax.swing.ButtonGroup();
        masterScrollPane = new javax.swing.JScrollPane();
        TblFicha = new javax.swing.JTable();
        BtConfirmar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelestadonome = new javax.swing.JLabel();
        jTextFieldIdficha = new javax.swing.JTextField();
        jLabelestadoid = new javax.swing.JLabel();
        jLabelApelido = new javax.swing.JLabel();
        jTextFieldFicha = new javax.swing.JTextField();
        jLabelCpf = new javax.swing.JLabel();
        jFormattedTextFieldCodigo = new javax.swing.JFormattedTextField();
        jLabelTelefone = new javax.swing.JLabel();
        jFormattedTextFieldRelatorio = new javax.swing.JFormattedTextField();
        jLabelCelular = new javax.swing.JLabel();
        jFormattedTextFieldQuantidade = new javax.swing.JFormattedTextField();
        jLabelCelular2 = new javax.swing.JLabel();
        jFormattedTextFieldPares = new javax.swing.JFormattedTextField();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldNumero = new javax.swing.JTextField();
        jLabelEmailopcional = new javax.swing.JLabel();
        jTextFieldModelo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jRadioButtonAtivo = new javax.swing.JRadioButton();
        jRadioButtonInativo = new javax.swing.JRadioButton();
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
        FecharBotao1 = new javax.swing.JButton();
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
        setTitle("Cadastro de Ficha");
        setResizable(false);

        TblFicha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Ficha", "Codigo", "Relatorio", "Quantidade", "Pares", "Numero", "Modelo", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblFicha.getTableHeader().setReorderingAllowed(false);
        TblFicha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblFichaMouseClicked(evt);
            }
        });
        TblFicha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                TblFichaPropertyChange(evt);
            }
        });
        TblFicha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TblFichaKeyReleased(evt);
            }
        });
        TblFicha.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                TblFichaVetoableChange(evt);
            }
        });
        masterScrollPane.setViewportView(TblFicha);
        TblFicha.getColumnModel().getColumn(0).setMinWidth(80);
        TblFicha.getColumnModel().getColumn(0).setPreferredWidth(80);
        TblFicha.getColumnModel().getColumn(0).setMaxWidth(80);

        BtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Bt_Confirmar.png"))); // NOI18N
        BtConfirmar.setText("Confirmar");
        BtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConfirmarActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jLabelestadonome.setText("*Nome:");

        jLabelestadoid.setText("Código:");

        jLabelApelido.setText("*Ficha:");

        jTextFieldFicha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFichaActionPerformed(evt);
            }
        });

        jLabelCpf.setText("Codigo:");

        jLabelTelefone.setText("Relatório:");

        jLabelCelular.setText("Quantidade:");

        jLabelCelular2.setText("Pares:");

        jLabelEmail.setText("Numero:");

        jLabelEmailopcional.setText("Modelo:");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Situação"));

        buttonGroupStatus.add(jRadioButtonAtivo);
        jRadioButtonAtivo.setSelected(true);
        jRadioButtonAtivo.setText("Ativo");
        jRadioButtonAtivo.setActionCommand("A");

        buttonGroupStatus.add(jRadioButtonInativo);
        jRadioButtonInativo.setText("Inativo");
        jRadioButtonInativo.setActionCommand("I");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButtonAtivo)
                .addGap(18, 18, 18)
                .addComponent(jRadioButtonInativo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonAtivo)
                    .addComponent(jRadioButtonInativo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApelido)
                    .addComponent(jLabelCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelestadoid)
                    .addComponent(jLabelestadonome)
                    .addComponent(jLabelEmailopcional, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldIdficha, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldNome)
                    .addComponent(jTextFieldFicha)
                    .addComponent(jTextFieldNumero)
                    .addComponent(jTextFieldModelo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFormattedTextFieldQuantidade)
                            .addComponent(jFormattedTextFieldCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelCelular2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jFormattedTextFieldPares, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldRelatorio))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldIdficha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelestadoid))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelestadonome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApelido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCpf)
                    .addComponent(jFormattedTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefone)
                    .addComponent(jFormattedTextFieldRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCelular)
                    .addComponent(jFormattedTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCelular2)
                    .addComponent(jFormattedTextFieldPares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmailopcional)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        util.UpperCase corretornome = new util.UpperCase();
        corretornome.setMaxChars(50);
        jTextFieldNome.setDocument(corretornome);
        util.UpperCase corretorapelido = new util.UpperCase();
        corretorapelido.setMaxChars(20);
        jTextFieldFicha.setDocument(corretorapelido);
        util.LowerCase corretoremail = new util.LowerCase();
        corretoremail.setMaxChars(100);
        jTextFieldNumero.setDocument(corretoremail);
        util.LowerCase corretoremailopcional = new util.LowerCase();
        corretoremailopcional.setMaxChars(100);
        jTextFieldModelo.setDocument(corretoremailopcional);

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

        FecharBotao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Door.PNG"))); // NOI18N
        FecharBotao1.setText("Fechar");
        FecharBotao1.setToolTipText("Fechar");
        FecharBotao1.setBorderPainted(false);
        FecharBotao1.setFocusable(false);
        FecharBotao1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FecharBotao1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FecharBotao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharBotao1ActionPerformed(evt);
            }
        });
        jToolBar3.add(FecharBotao1);

        jMenu1.setText("Arquivo");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 114, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(masterScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtConfirmar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConfirmarActionPerformed
        FichaCTRL.gravar();
    }//GEN-LAST:event_BtConfirmarActionPerformed

    private void NovoBotao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoBotao1ActionPerformed
        FichaCTRL.novo();
}//GEN-LAST:event_NovoBotao1ActionPerformed

    private void ConfirmarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarBotaoActionPerformed
        FichaCTRL.gravar();
}//GEN-LAST:event_ConfirmarBotaoActionPerformed

    private void CancelarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBotaoActionPerformed
        FichaCTRL.cancelar();
}//GEN-LAST:event_CancelarBotaoActionPerformed

    private void ExcluirBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirBotaoActionPerformed
        FichaCTRL.excluir();
}//GEN-LAST:event_ExcluirBotaoActionPerformed

private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jTextFieldNomeActionPerformed

    public void passarPrimeiro() {
        TblFicha.setRowSelectionInterval(TblFicha.getRowCount() - 1, TblFicha.getRowCount() - 1);
        FichaCTRL.buscar((Integer) modeloTabela.getValueAt(TblFicha.getRowCount() - 1, 0));
   }

    public void passarAnterior() {
        int rowSelected = TblFicha.getSelectedRow();
        if (rowSelected + 1 < TblFicha.getRowCount()) {
            TblFicha.setRowSelectionInterval(rowSelected + 1, rowSelected + 1);
            FichaCTRL.buscar((Integer) modeloTabela.getValueAt(rowSelected + 1, 0));
         
        }
    }

    private void TblPaisPropertyChange(java.beans.PropertyChangeEvent evt) {
    }

    public void passarProximo() {
        int rowSelected = TblFicha.getSelectedRow();
        if (rowSelected != 0) {
            TblFicha.setRowSelectionInterval(rowSelected - 1, rowSelected - 1);
            FichaCTRL.buscar((Integer) modeloTabela.getValueAt(rowSelected - 1, 0));

        }
    }

    public void passarUltimo() {
        TblFicha.setRowSelectionInterval(0, 0);
        FichaCTRL.buscar((Integer) modeloTabela.getValueAt(0, 0));

    }

//    public void Imprimir() {
//        try {
//            Reports.getInstance().Execute("Cadastro_Ficha.jasper");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

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

private void EditarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBotaoActionPerformed
    if (FichaCTRL.getObFicha() == null) {
        JOptionPane.showMessageDialog(this, "Selecione primeiro um Ficha", "Alerta!", JOptionPane.WARNING_MESSAGE);
    } else {
        this.habilita();
    }
}//GEN-LAST:event_EditarBotaoActionPerformed

private void jMenuItemnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemnNovoActionPerformed
    FichaCTRL.novo();
}//GEN-LAST:event_jMenuItemnNovoActionPerformed

private void jMenuItemnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemnEditarActionPerformed
    if (FichaCTRL.getObFicha() == null) {
        JOptionPane.showMessageDialog(this, "Selecione primeiro um Ficha", "Alerta!", JOptionPane.WARNING_MESSAGE);
    } else {
        this.habilita();

    }
}//GEN-LAST:event_jMenuItemnEditarActionPerformed

private void jMenuItemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCancelarActionPerformed
    FichaCTRL.cancelar();
}//GEN-LAST:event_jMenuItemCancelarActionPerformed

private void jMenuItemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirActionPerformed
    FichaCTRL.excluir();
}//GEN-LAST:event_jMenuItemExcluirActionPerformed

private void jMenuItemSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalvarActionPerformed
    FichaCTRL.gravar();
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
  //  Imprimir();
}//GEN-LAST:event_jMenuItemImprimirActionPerformed

private void jMenuItemFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFecharActionPerformed
    this.dispose();
}//GEN-LAST:event_jMenuItemFecharActionPerformed

private void FecharBotao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharBotao1ActionPerformed
    this.dispose();
}//GEN-LAST:event_FecharBotao1ActionPerformed

private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
 //   Imprimir();
}//GEN-LAST:event_jMenu1ActionPerformed

    private void jTextFieldFichaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldFichaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldFichaActionPerformed

    private void TblFichaVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_TblFichaVetoableChange

    }//GEN-LAST:event_TblFichaVetoableChange

    private void TblFichaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TblFichaKeyReleased
    DefaultTableModel model = (DefaultTableModel) TblFicha.getModel();
    int linhaClicada = TblFicha.getSelectedRow();
    int idficha = (Integer) model.getValueAt(linhaClicada, 0);
    String nome = (String) model.getValueAt(linhaClicada, 1);
    String ficha = (String) model.getValueAt(linhaClicada, 2);
    String codigo = (String) model.getValueAt(linhaClicada, 3);
    String relatorio = (String) model.getValueAt(linhaClicada, 4);
    String quantidade = (String) model.getValueAt(linhaClicada, 5);
    String pares = (String) model.getValueAt(linhaClicada, 6);
    String numero = (String) model.getValueAt(linhaClicada, 7);
    String modelo = (String) model.getValueAt(linhaClicada, 8);
    String status = (String) model.getValueAt(linhaClicada, 9);
    
  
    jTextFieldIdficha.setText(Integer.toString(idficha));
    jTextFieldNome.setText(nome);
    jTextFieldFicha.setText(ficha);
    jFormattedTextFieldCodigo.setText(codigo);
    jFormattedTextFieldRelatorio.setText(relatorio);
    jFormattedTextFieldQuantidade.setText(quantidade);
    jFormattedTextFieldPares.setText(pares);
    jTextFieldNumero.setText(numero);
    jTextFieldModelo.setText(modelo);
    jRadioButtonAtivo.setSelected("A".equals(status) ? true : false);
    jRadioButtonInativo.setSelected("I".equals(status) ? true : false);
   
    
    Ficha obFicha = new Ficha();
    obFicha.setIDficha(idficha);
    obFicha.setNome(nome);
    obFicha.setFicha(ficha);
    obFicha.setCodigo(codigo);
    obFicha.setRelatorio(relatorio);
    obFicha.setQuantidade(quantidade);
    obFicha.setPares(pares);
    obFicha.setNumero(numero);
    obFicha.setModelo(modelo);
    obFicha.setStatus(status);
    
    
    FichaCTRL.setObFicha(obFicha);
 // this.atualizaFoto();
     
    }//GEN-LAST:event_TblFichaKeyReleased

    private void TblFichaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_TblFichaPropertyChange

    }//GEN-LAST:event_TblFichaPropertyChange

    private void TblFichaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblFichaMouseClicked
    DefaultTableModel model = (DefaultTableModel) TblFicha.getModel();
    int linhaClicada = TblFicha.getSelectedRow();
    int idficha = (Integer) model.getValueAt(linhaClicada, 0);
    String nome = (String) model.getValueAt(linhaClicada, 1);
    String ficha = (String) model.getValueAt(linhaClicada, 2);
    String codigo = (String) model.getValueAt(linhaClicada, 3);
    String relatorio = (String) model.getValueAt(linhaClicada, 4);
    String quantidade = (String) model.getValueAt(linhaClicada, 5);
    String pares = (String) model.getValueAt(linhaClicada, 6);
    String numero = (String) model.getValueAt(linhaClicada, 7);
    String modelo = (String) model.getValueAt(linhaClicada, 8);
    String status = (String) model.getValueAt(linhaClicada, 9);
    
  
    jTextFieldIdficha.setText(Integer.toString(idficha));
    jTextFieldNome.setText(nome);
    jTextFieldFicha.setText(ficha);
    jFormattedTextFieldCodigo.setText(codigo);
    jFormattedTextFieldRelatorio.setText(relatorio);
    jFormattedTextFieldQuantidade.setText(quantidade);
    jFormattedTextFieldPares.setText(pares);
    jTextFieldNumero.setText(numero);
    jTextFieldModelo.setText(modelo);
    jRadioButtonAtivo.setSelected("A".equals(status) ? true : false);
    jRadioButtonInativo.setSelected("I".equals(status) ? true : false);
   
    
    Ficha obFicha = new Ficha();
    obFicha.setIDficha(idficha);
    obFicha.setNome(nome);
    obFicha.setFicha(ficha);
    obFicha.setCodigo(codigo);
    obFicha.setRelatorio(relatorio);
    obFicha.setQuantidade(quantidade);
    obFicha.setPares(pares);
    obFicha.setNumero(numero);
    obFicha.setModelo(modelo);
    obFicha.setStatus(status);
    
    
    FichaCTRL.setObFicha(obFicha);

       
    }//GEN-LAST:event_TblFichaMouseClicked

    /**
     * @param args the command line arguments
     *
     *
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FichaVIEW().setVisible(true);
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
    private javax.swing.JButton FecharBotao1;
    private javax.swing.JButton NovoBotao1;
    private javax.swing.JButton PrimeiroBotao;
    private javax.swing.JButton ProximoBotao;
    private javax.swing.JTable TblFicha;
    private javax.swing.JButton UltimoBotao;
    private javax.swing.ButtonGroup buttonGroupStatus;
    private javax.swing.JFormattedTextField jFormattedTextFieldCodigo;
    private javax.swing.JFormattedTextField jFormattedTextFieldPares;
    private javax.swing.JFormattedTextField jFormattedTextFieldQuantidade;
    private javax.swing.JFormattedTextField jFormattedTextFieldRelatorio;
    private javax.swing.JLabel jLabelApelido;
    private javax.swing.JLabel jLabelCelular;
    private javax.swing.JLabel jLabelCelular2;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEmailopcional;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelestadoid;
    private javax.swing.JLabel jLabelestadonome;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButtonAtivo;
    private javax.swing.JRadioButton jRadioButtonInativo;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField jTextFieldFicha;
    private javax.swing.JTextField jTextFieldIdficha;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JScrollPane masterScrollPane;
    // End of variables declaration//GEN-END:variables

    
}
