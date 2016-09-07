package view;

import ctrl.GrupoCTRL;
import util.EncriptaSenha;
import ctrl.UsuarioCtrl;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Grupo;
import model.Usuario;
import relatorios.Reports;

public class UsuarioView extends javax.swing.JFrame {

    private UsuarioCtrl UsuarioCtrl = new UsuarioCtrl(this);
    private DefaultTableModel modeloTabela;
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form UsuarioView
     */
    public UsuarioView() {
        initComponents();
        this.desabilita();
        UsuarioCtrl.atualizaTabelaUsuario();
        modeloTabela = (DefaultTableModel) TblUsuario.getModel();
        jDateChooserusuariodatacriacao.setDate(new Date());
        this.atualizaFoto();
    }

    public void setUsuarioid(int vUsuarioid) {
        if (vUsuarioid == 0) {
            jTextFieldusuarioid.setText("");
        } else {
            jTextFieldusuarioid.setText(Integer.toString(vUsuarioid));
        }
    }

    public int getUsuarioid() {
        int id = 0;
        if (!jTextFieldusuarioid.getText().trim().equals("")) {
            id = Integer.parseInt(jTextFieldusuarioid.getText());
        }
        return id;
    }

    public void setUsuarionome(String vUsuarionome) {
        jTextFieldusuarionome.setText(vUsuarionome);
    }

    public String getUsuarionome() {
        return jTextFieldusuarionome.getText();
    }

    public void setUsuariologin(String vUsuariologin) {
        jTextFieldusuariologin.setText(vUsuariologin);
    }

    public String getUsuariologin() {
        return jTextFieldusuariologin.getText();
    }

    public void setUsuariosenha(String vUsuariosenha) {
        jPasswordFieldusuariosenha.setText(vUsuariosenha);
    }

    public String getUsuariosenha() {
        return jPasswordFieldusuariosenha.getText();
    }

    public void setUsuariorepitasenha(String vUsuariorepitasenha) {
        jPasswordFieldRepitasenha.setText(vUsuariorepitasenha);
    }

    public String getUsuariorepitasenha() {
        return jPasswordFieldRepitasenha.getText();
    }

    
    public void setUsuariogrupoid(int vUsuariogrupoid) {
        if (vUsuariogrupoid == 0) {
            jTextFieldusuariogrupoid.setText("");
        } else {
            jTextFieldusuariogrupoid.setText(Integer.toString(vUsuariogrupoid));
        }
    }

    public int getUsuariogrupoid() {
        int id = 0;
        if (!jTextFieldusuariogrupoid.getText().trim().equals("")) {
            id = Integer.parseInt(jTextFieldusuariogrupoid.getText());
        }
        return id;
    }

    public void setGruponome(String vGruponome) {
        jTextFielddescricaogrupo.setText(vGruponome);
    }

    public String getGruponome() {
        return jTextFielddescricaogrupo.getText();
    }

    public void setUsuariotipo(String vUsuariotipo) {
        if (vUsuariotipo.equals("A")) {
            jRadioButtonAdministrador.setSelected(true);
        } else if (vUsuariotipo.equals("U")) {
            jRadioButtonUsuario.setSelected(true);
        }
    }

    public String getUsuariotipo() {
        ButtonModel model = buttonGroupNivelUsuario.getSelection();
        return model.getActionCommand();
    }

    public void setUsuariodatacriacao(Date vUsuariodatacriacao) {
        jDateChooserusuariodatacriacao.setDate(vUsuariodatacriacao);
    }

    public Date getUsuariodatacriacao() throws ParseException {
        return jDateChooserusuariodatacriacao.getDate();
    }

    public void setUsuariofoto(String vUsuariofoto) {
        jTextFieldusuariofoto.setText(vUsuariofoto);
    }

    public String getUsuariofoto() {
        return jTextFieldusuariofoto.getText();
    }
    
    public void zeraLinhasTblUsuario() {
        DefaultTableModel dtm = (DefaultTableModel) TblUsuario.getModel();
        dtm.setNumRows(0);
    }

    public void adicionaTblUsuario(int Usuarioid, String Usuarionome, String Usuariologin, String Usuariosenha, String nomeGrupo, String Usuariotipo, Date Usuariodatacriacao, String Usuariofoto) {
        DefaultTableModel dtm = (DefaultTableModel) TblUsuario.getModel();
        dtm.addRow(new Object[]{Usuarioid, Usuarionome, Usuariologin, Usuariosenha, nomeGrupo, Usuariotipo, Usuariodatacriacao, Usuariofoto});

    }

    public void validarIteiros(JTextField componente) {
        String stg = componente.getText();
        try {
            int i = Integer.parseInt(stg);
        } catch (Exception e) {
            componente.setText(stg.substring(0, stg.length() - 1));
            JOptionPane.showMessageDialog(this, "Digite apenas números inteiros", "Alerta", JOptionPane.INFORMATION_MESSAGE);
            jTextFieldusuariogrupoid.requestFocus();
        }

    }

       public void desabilita() {
        jTextFieldusuarioid.setEnabled(false);
        jTextFieldusuarionome.setEnabled(false);
        jTextFieldusuariologin.setEnabled(false);
        jPasswordFieldusuariosenha.setEnabled(false);
        jTextFieldusuariogrupoid.setEnabled(false);
        jTextFielddescricaogrupo.setEnabled(false);
        jRadioButtonAdministrador.setEnabled(false);
        jRadioButtonUsuario.setEnabled(false);
        jDateChooserusuariodatacriacao.setEnabled(false);
        BtConfirmar.setEnabled(false);
        ConfirmarBotao.setEnabled(false);
        jButtonConsultaGrupo.setEnabled(false);
        jPasswordFieldRepitasenha.setEnabled(false);
        jTextFieldusuariofoto.setEnabled(false);
        jMenuItemSalvar.setEnabled(false);
        JButtonPesquisaDespartamento.setEnabled(false);

    }

    public void habilita() {
        jTextFieldusuarioid.setEnabled(false);
        jTextFieldusuarionome.setEnabled(true);
        jTextFieldusuariologin.setEnabled(true);
        jPasswordFieldusuariosenha.setEnabled(true);
        jTextFieldusuariogrupoid.setEnabled(true);
        jTextFielddescricaogrupo.setEnabled(true);
        jTextFielddescricaogrupo.setFocusable(false);
        jRadioButtonAdministrador.setEnabled(true);
        jRadioButtonUsuario.setEnabled(true);
        jDateChooserusuariodatacriacao.setEnabled(true);
        BtConfirmar.setEnabled(false);
        ConfirmarBotao.setEnabled(false);
        jButtonConsultaGrupo.setEnabled(true);
        jButtonConsultaGrupo.setFocusable(false);
        TblUsuario.setFocusable(false);
        jPasswordFieldRepitasenha.setEnabled(true);
        jTextFieldusuariofoto.setEnabled(true);
        jTextFieldusuarionome.requestFocus();
        jMenuItemSalvar.setEnabled(true);
        JButtonPesquisaDespartamento.setEnabled(true);
    }

    
    public void atualizaFoto () {
       // lbFoto.setIcon(new ImageIcon("/Programacao/PROJETO_SEGURO/EasySeg/src/Fotos/Usuario"+jTextFieldusuariofoto.getText()));
        lbFoto.setIcon(new ImageIcon("C:\\Programacao\\PROJETO_SEGURO\\EasySeg\\src\\Fotos\\Usuario\\"+jTextFieldusuariofoto.getText()));
       
    }
    
    public void validaSenha (){
       
     //   if (jPasswordFieldusuariosenha.getText().equals(""));
      //       JOptionPane.showMessageDialog(this, "Campo obrigatório não preenchido, digite novamente", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            
             if ( jPasswordFieldRepitasenha.getText().equals(jPasswordFieldusuariosenha.getText())) {
                JOptionPane.showMessageDialog(this, "Senha correta", "Informação", JOptionPane.INFORMATION_MESSAGE);
                 ConfirmarBotao.setEnabled(true);
                 BtConfirmar.setEnabled(true);
             
             }  else{
                    JOptionPane.showMessageDialog(this, "Senha incorreta, confirme novamente", "Atenção", JOptionPane.INFORMATION_MESSAGE);
                    jPasswordFieldRepitasenha.requestFocus();
                    jPasswordFieldRepitasenha.setText(""); 
             
                }
           }     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupNivelUsuario = new javax.swing.ButtonGroup();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jToolBar3 = new javax.swing.JToolBar();
        NovoBotao = new javax.swing.JButton();
        ConfirmarBotao = new javax.swing.JButton();
        EditarBotao = new javax.swing.JButton();
        CancelarBotao = new javax.swing.JButton();
        ExcluirBotao = new javax.swing.JButton();
        PrimeiroBotao = new javax.swing.JButton();
        AnteriorBotao = new javax.swing.JButton();
        ProximoBotao = new javax.swing.JButton();
        UltimoBotao = new javax.swing.JButton();
        JButtonPesquisaDespartamento = new javax.swing.JButton();
        FecharBotao1 = new javax.swing.JButton();
        ImprimirBotao2 = new javax.swing.JButton();
        ImprimirBotao = new javax.swing.JButton();
        FecharBotao = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelusuarioid = new javax.swing.JLabel();
        jTextFieldusuarioid = new javax.swing.JTextField();
        jLabelusuarionome = new javax.swing.JLabel();
        jTextFieldusuarionome = new javax.swing.JTextField();
        jLabelusuariologin = new javax.swing.JLabel();
        jTextFieldusuariologin = new javax.swing.JTextField();
        jLabelusuariosenha = new javax.swing.JLabel();
        jPasswordFieldusuariosenha = new javax.swing.JPasswordField();
        jPasswordFieldRepitasenha = new javax.swing.JPasswordField();
        jLabelusuariodepartamentoid = new javax.swing.JLabel();
        jButtonConsultaGrupo = new javax.swing.JButton();
        jTextFielddescricaogrupo = new javax.swing.JTextField();
        jLabeldepartamentodescricao = new javax.swing.JLabel();
        jLabelusuariosenha1 = new javax.swing.JLabel();
        jTextFieldusuariogrupoid = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jRadioButtonAdministrador = new javax.swing.JRadioButton();
        jRadioButtonUsuario = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelusuariodatacriacao = new javax.swing.JLabel();
        jDateChooserusuariodatacriacao = new com.toedter.calendar.JDateChooser();
        BtConfirmar = new javax.swing.JButton();
        masterScrollPane = new javax.swing.JScrollPane();
        TblUsuario = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jTextFieldusuariofoto = new javax.swing.JTextField();
        jButtonConsultaFoto = new javax.swing.JButton();
        lbFoto = new javax.swing.JLabel();
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

        jTextField1.setText("jTextField1");
        jTextField1.setName("jTextField1"); // NOI18N

        jTextField2.setText("jTextField2");
        jTextField2.setName("jTextField2"); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuário");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jToolBar3.setFloatable(false);
        jToolBar3.setRollover(true);
        jToolBar3.setEnabled(false);
        jToolBar3.setName("jToolBar3"); // NOI18N

        NovoBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Novo.png"))); // NOI18N
        NovoBotao.setText("Inserir");
        NovoBotao.setToolTipText("Inserir");
        NovoBotao.setBorderPainted(false);
        NovoBotao.setFocusable(false);
        NovoBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        NovoBotao.setName("NovoBotao"); // NOI18N
        NovoBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        NovoBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NovoBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(NovoBotao);

        ConfirmarBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        ConfirmarBotao.setText("Confirmar");
        ConfirmarBotao.setToolTipText("Confirmar");
        ConfirmarBotao.setBorderPainted(false);
        ConfirmarBotao.setFocusable(false);
        ConfirmarBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ConfirmarBotao.setName("ConfirmarBotao"); // NOI18N
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
        EditarBotao.setName("EditarBotao"); // NOI18N
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
        CancelarBotao.setName("CancelarBotao"); // NOI18N
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
        ExcluirBotao.setName("ExcluirBotao"); // NOI18N
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
        PrimeiroBotao.setName("PrimeiroBotao"); // NOI18N
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
        AnteriorBotao.setName("AnteriorBotao"); // NOI18N
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
        ProximoBotao.setName("ProximoBotao"); // NOI18N
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
        UltimoBotao.setName("UltimoBotao"); // NOI18N
        UltimoBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        UltimoBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UltimoBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(UltimoBotao);

        JButtonPesquisaDespartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Pesquisar.png"))); // NOI18N
        JButtonPesquisaDespartamento.setText("Grupo");
        JButtonPesquisaDespartamento.setToolTipText("Fechar");
        JButtonPesquisaDespartamento.setBorderPainted(false);
        JButtonPesquisaDespartamento.setFocusable(false);
        JButtonPesquisaDespartamento.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        JButtonPesquisaDespartamento.setName("JButtonPesquisaDespartamento"); // NOI18N
        JButtonPesquisaDespartamento.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        JButtonPesquisaDespartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonPesquisaDespartamentoActionPerformed(evt);
            }
        });
        jToolBar3.add(JButtonPesquisaDespartamento);

        FecharBotao1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Calendario.png"))); // NOI18N
        FecharBotao1.setText("Calendário");
        FecharBotao1.setToolTipText("Fechar");
        FecharBotao1.setBorderPainted(false);
        FecharBotao1.setFocusable(false);
        FecharBotao1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FecharBotao1.setName("FecharBotao1"); // NOI18N
        FecharBotao1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FecharBotao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharBotao1ActionPerformed(evt);
            }
        });
        jToolBar3.add(FecharBotao1);

        ImprimirBotao2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Ajuda.png"))); // NOI18N
        ImprimirBotao2.setText("Ajuda");
        ImprimirBotao2.setToolTipText("Ajuda");
        ImprimirBotao2.setBorderPainted(false);
        ImprimirBotao2.setFocusable(false);
        ImprimirBotao2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImprimirBotao2.setName("ImprimirBotao2"); // NOI18N
        ImprimirBotao2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(ImprimirBotao2);

        ImprimirBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imprimir.png"))); // NOI18N
        ImprimirBotao.setText("Imprimir");
        ImprimirBotao.setToolTipText("Imprimir");
        ImprimirBotao.setBorderPainted(false);
        ImprimirBotao.setFocusable(false);
        ImprimirBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ImprimirBotao.setName("ImprimirBotao"); // NOI18N
        ImprimirBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ImprimirBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(ImprimirBotao);

        FecharBotao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Door.PNG"))); // NOI18N
        FecharBotao.setText("Fechar");
        FecharBotao.setToolTipText("Fechar");
        FecharBotao.setBorderPainted(false);
        FecharBotao.setFocusable(false);
        FecharBotao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        FecharBotao.setName("FecharBotao"); // NOI18N
        FecharBotao.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        FecharBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FecharBotaoActionPerformed(evt);
            }
        });
        jToolBar3.add(FecharBotao);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Cadastrais"));
        jPanel1.setName("jPanel1"); // NOI18N

        jLabelusuarioid.setText("*Cód. Usuário:");
        jLabelusuarioid.setName("jLabelusuarioid"); // NOI18N

        jTextFieldusuarioid.setName("jTextFieldusuarioid"); // NOI18N

        jLabelusuarionome.setText("*Nome:");
        jLabelusuarionome.setName("jLabelusuarionome"); // NOI18N

        jTextFieldusuarionome.setName("jTextFieldusuarionome"); // NOI18N

        jLabelusuariologin.setText("*Login:");
        jLabelusuariologin.setName("jLabelusuariologin"); // NOI18N

        jTextFieldusuariologin.setName("jTextFieldusuariologin"); // NOI18N

        jLabelusuariosenha.setText("*Senha:");
        jLabelusuariosenha.setName("jLabelusuariosenha"); // NOI18N

        jPasswordFieldusuariosenha.setText("jPasswordField1");
        jPasswordFieldusuariosenha.setName("jPasswordFieldusuariosenha"); // NOI18N
        jPasswordFieldusuariosenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldusuariosenhaFocusLost(evt);
            }
        });

        jPasswordFieldRepitasenha.setText("jPasswordField1");
        jPasswordFieldRepitasenha.setName("jPasswordFieldRepitasenha"); // NOI18N
        jPasswordFieldRepitasenha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldRepitasenhaFocusLost(evt);
            }
        });

        jLabelusuariodepartamentoid.setText("*Cód. Grupo:");
        jLabelusuariodepartamentoid.setName("jLabelusuariodepartamentoid"); // NOI18N

        jButtonConsultaGrupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Consulta.png"))); // NOI18N
        jButtonConsultaGrupo.setName("jButtonConsultaGrupo"); // NOI18N
        jButtonConsultaGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaGrupoActionPerformed(evt);
            }
        });

        jTextFielddescricaogrupo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFielddescricaogrupo.setName("jTextFielddescricaogrupo"); // NOI18N

        jLabeldepartamentodescricao.setText("Descrição:");
        jLabeldepartamentodescricao.setName("jLabeldepartamentodescricao"); // NOI18N

        jLabelusuariosenha1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelusuariosenha1.setForeground(new java.awt.Color(0, 0, 153));
        jLabelusuariosenha1.setText("Repita a senha:");
        jLabelusuariosenha1.setName("jLabelusuariosenha1"); // NOI18N

        jTextFieldusuariogrupoid.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextFieldusuariogrupoid.setName("jTextFieldusuariogrupoid"); // NOI18N
        jTextFieldusuariogrupoid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldusuariogrupoidFocusLost(evt);
            }
        });
        jTextFieldusuariogrupoid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldusuariogrupoidKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelusuariodepartamentoid)
                    .addComponent(jLabelusuarioid)
                    .addComponent(jLabelusuarionome)
                    .addComponent(jLabelusuariologin))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextFieldusuariogrupoid, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonConsultaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextFieldusuariologin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabeldepartamentodescricao)
                                    .addComponent(jLabelusuariosenha))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelusuariosenha1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPasswordFieldusuariosenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldRepitasenha, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFielddescricaogrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldusuarionome)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldusuarioid, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelusuarioid)
                    .addComponent(jTextFieldusuarioid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelusuarionome)
                    .addComponent(jTextFieldusuarionome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabeldepartamentodescricao)
                            .addComponent(jTextFielddescricaogrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonConsultaGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelusuariodepartamentoid)
                    .addComponent(jTextFieldusuariogrupoid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldusuariologin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelusuariologin)
                    .addComponent(jLabelusuariosenha)
                    .addComponent(jPasswordFieldusuariosenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldRepitasenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelusuariosenha1))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        util.UpperCase usuarionome = new util.UpperCase();
        usuarionome.setMaxChars(50);
        jTextFieldusuarionome.setDocument(usuarionome);
        util.UpperCase usuariologin = new util.UpperCase();
        usuariologin.setMaxChars(10);
        jTextFieldusuariologin.setDocument(usuariologin);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo de Usuário"));
        jPanel2.setName("jPanel2"); // NOI18N

        buttonGroupNivelUsuario.add(jRadioButtonAdministrador);
        jRadioButtonAdministrador.setText("Administrador");
        jRadioButtonAdministrador.setActionCommand("A");
        jRadioButtonAdministrador.setName("jRadioButtonAdministrador"); // NOI18N

        buttonGroupNivelUsuario.add(jRadioButtonUsuario);
        jRadioButtonUsuario.setSelected(true);
        jRadioButtonUsuario.setText("Usuário");
        jRadioButtonUsuario.setActionCommand("U");
        jRadioButtonUsuario.setName("jRadioButtonUsuario"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonAdministrador)
                    .addComponent(jRadioButtonUsuario))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jRadioButtonAdministrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButtonUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados Diversos"));
        jPanel3.setName("jPanel3"); // NOI18N

        jLabelusuariodatacriacao.setText("Data de Criação:");
        jLabelusuariodatacriacao.setName("jLabelusuariodatacriacao"); // NOI18N

        jDateChooserusuariodatacriacao.setName("jDateChooserusuariodatacriacao"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelusuariodatacriacao)
                .addGap(18, 18, 18)
                .addComponent(jDateChooserusuariodatacriacao, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooserusuariodatacriacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelusuariodatacriacao))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        BtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Bt_Confirmar.png"))); // NOI18N
        BtConfirmar.setText("Confirmar");
        BtConfirmar.setName("BtConfirmar"); // NOI18N
        BtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConfirmarActionPerformed(evt);
            }
        });

        masterScrollPane.setName("masterScrollPane"); // NOI18N

        TblUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Login", "Senha", "Nome Grupo", "Tipo", "Criação", "Foto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TblUsuario.setName("TblUsuario"); // NOI18N
        TblUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblUsuarioMouseClicked(evt);
            }
        });
        TblUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TblUsuarioKeyReleased(evt);
            }
        });
        masterScrollPane.setViewportView(TblUsuario);
        TblUsuario.getColumnModel().getColumn(0).setMinWidth(80);
        TblUsuario.getColumnModel().getColumn(0).setPreferredWidth(80);
        TblUsuario.getColumnModel().getColumn(0).setMaxWidth(80);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Insira a Foto do Usuário"));
        jPanel5.setName("jPanel4"); // NOI18N

        jTextFieldusuariofoto.setFocusable(false);
        jTextFieldusuariofoto.setName("jTextFieldusuariofoto"); // NOI18N

        jButtonConsultaFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Consulta.png"))); // NOI18N
        jButtonConsultaFoto.setName("jButtonConsultaFoto"); // NOI18N
        jButtonConsultaFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultaFotoActionPerformed(evt);
            }
        });

        lbFoto.setName("lbFoto"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextFieldusuariofoto, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonConsultaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonConsultaFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldusuariofoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jMenuBar1.setName("jMenuBar1"); // NOI18N

        jMenu1.setText("Arquivo");
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItemnNovo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemnNovo.setText("Novo");
        jMenuItemnNovo.setName("jMenuItemnNovo"); // NOI18N
        jMenuItemnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemnNovoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemnNovo);

        jMenuItemnEditar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemnEditar.setText("Editar");
        jMenuItemnEditar.setName("jMenuItemnEditar"); // NOI18N
        jMenuItemnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemnEditarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemnEditar);

        jMenuItemCancelar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCancelar.setText("Cancelar");
        jMenuItemCancelar.setName("jMenuItemCancelar"); // NOI18N
        jMenuItemCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCancelarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCancelar);

        jMenuItemExcluir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItemExcluir.setText("Excluir");
        jMenuItemExcluir.setName("jMenuItemExcluir"); // NOI18N
        jMenuItemExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExcluir);

        jMenuItemSalvar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemSalvar.setText("Salvar");
        jMenuItemSalvar.setName("jMenuItemSalvar"); // NOI18N
        jMenuItemSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalvarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSalvar);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jMenu1.add(jSeparator1);

        jMenuItemPrimeiro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItemPrimeiro.setText("Primeiro");
        jMenuItemPrimeiro.setName("jMenuItemPrimeiro"); // NOI18N
        jMenuItemPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPrimeiroActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemPrimeiro);

        jMenuItemProximo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItemProximo.setText("Próximo");
        jMenuItemProximo.setName("jMenuItemProximo"); // NOI18N
        jMenuItemProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProximoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemProximo);

        jMenuItemAnterior.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItemAnterior.setText("Anterior");
        jMenuItemAnterior.setName("jMenuItemAnterior"); // NOI18N
        jMenuItemAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAnteriorActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAnterior);

        jMenuItemUltimo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F8, 0));
        jMenuItemUltimo.setText("Último");
        jMenuItemUltimo.setName("jMenuItemUltimo"); // NOI18N
        jMenuItemUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUltimoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemUltimo);

        jSeparator2.setName("jSeparator2"); // NOI18N
        jMenu1.add(jSeparator2);

        jMenuItemImprimir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemImprimir.setText("Imprimir");
        jMenuItemImprimir.setName("jMenuItemImprimir"); // NOI18N
        jMenuItemImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImprimirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemImprimir);

        jMenuItemFechar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItemFechar.setText("Fechar");
        jMenuItemFechar.setName("jMenuItemFechar"); // NOI18N
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtConfirmar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtConfirmar)
                .addContainerGap())
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

private void NovoBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NovoBotaoActionPerformed
    UsuarioCtrl.novo();
}//GEN-LAST:event_NovoBotaoActionPerformed

private void ConfirmarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarBotaoActionPerformed
    UsuarioCtrl.gravar();
}//GEN-LAST:event_ConfirmarBotaoActionPerformed

private void CancelarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarBotaoActionPerformed
    UsuarioCtrl.cancelar();
}//GEN-LAST:event_CancelarBotaoActionPerformed

private void ExcluirBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirBotaoActionPerformed
    UsuarioCtrl.excluir();
}//GEN-LAST:event_ExcluirBotaoActionPerformed

private void FecharBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharBotaoActionPerformed
    this.dispose();
}//GEN-LAST:event_FecharBotaoActionPerformed

private void jButtonConsultaGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaGrupoActionPerformed
    new ConsultaGrupoView(UsuarioCtrl, this).setVisible(true);
}//GEN-LAST:event_jButtonConsultaGrupoActionPerformed

private void BtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConfirmarActionPerformed
    UsuarioCtrl.gravar();
}//GEN-LAST:event_BtConfirmarActionPerformed

    public void passarPrimeiro() {
        TblUsuario.setRowSelectionInterval(TblUsuario.getRowCount() - 1, TblUsuario.getRowCount() - 1);
        UsuarioCtrl.buscar((Integer) modeloTabela.getValueAt(TblUsuario.getRowCount() - 1, 0));

        if (!jTextFieldusuariogrupoid.getText().trim().equals("")) {
            GrupoCTRL ctrlGrupo = new GrupoCTRL();
            Grupo obGrupo = ctrlGrupo.getGrupo(Integer.parseInt(jTextFieldusuariogrupoid.getText()));
            jTextFielddescricaogrupo.setText(obGrupo.getGruponome());// TODO add your handling code here:   
        }
    }

    public void passarProximo() {
        int rowSelected = TblUsuario.getSelectedRow();
        if (rowSelected != 0) {
            TblUsuario.setRowSelectionInterval(rowSelected - 1, rowSelected - 1);
            UsuarioCtrl.buscar((Integer) modeloTabela.getValueAt(rowSelected - 1, 0));

            if (!jTextFieldusuariogrupoid.getText().trim().equals("")) {
                GrupoCTRL ctrlGrupo = new GrupoCTRL();
                Grupo obGrupo = ctrlGrupo.getGrupo(Integer.parseInt(jTextFieldusuariogrupoid.getText()));
                jTextFielddescricaogrupo.setText(obGrupo.getGruponome());// TODO add your handling code here:   
            }
        }
    }

    public void passarAnterior() {
        int rowSelected = TblUsuario.getSelectedRow();
        if (rowSelected + 1 < TblUsuario.getRowCount()) {
            TblUsuario.setRowSelectionInterval(rowSelected + 1, rowSelected + 1);
            UsuarioCtrl.buscar((Integer) modeloTabela.getValueAt(rowSelected + 1, 0));

            if (!jTextFieldusuariogrupoid.getText().trim().equals("")) {
                GrupoCTRL ctrlGrupo = new GrupoCTRL();
                Grupo obGrupo = ctrlGrupo.getGrupo(Integer.parseInt(jTextFieldusuariogrupoid.getText()));
                jTextFielddescricaogrupo.setText(obGrupo.getGruponome());// TODO add your handling code here:   
            }
        }
    }

    private void TblProdutoPropertyChange(java.beans.PropertyChangeEvent evt) {
    }

    public void passarUltimo() {
        TblUsuario.setRowSelectionInterval(0, 0);
        UsuarioCtrl.buscar((Integer) modeloTabela.getValueAt(0, 0));

        if (!jTextFieldusuariogrupoid.getText().trim().equals("")) {
            GrupoCTRL ctrlGrupo = new GrupoCTRL();
            Grupo obGrupo = ctrlGrupo.getGrupo(Integer.parseInt(jTextFieldusuariogrupoid.getText()));
            jTextFielddescricaogrupo.setText(obGrupo.getGruponome());// TODO add your handling code here:   
        }
    }

    public void Imprimir() {
        try {
            Reports.getInstance().Execute("Cadastro_Usuarios.jasper");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

private void jPasswordFieldusuariosenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldusuariosenhaFocusLost
    jPasswordFieldusuariosenha.setText(EncriptaSenha.encripta(jPasswordFieldusuariosenha.getText()));
    jPasswordFieldRepitasenha.requestFocus();
}//GEN-LAST:event_jPasswordFieldusuariosenhaFocusLost

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

private void jMenuItemnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemnNovoActionPerformed
    UsuarioCtrl.novo();
}//GEN-LAST:event_jMenuItemnNovoActionPerformed

private void jMenuItemnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemnEditarActionPerformed
    if (UsuarioCtrl.getObUsuario() == null) {
        JOptionPane.showMessageDialog(this, "Selecione primeiro um Usuário", "Alerta!", JOptionPane.WARNING_MESSAGE);
    } else {
        this.habilita();

    }
}//GEN-LAST:event_jMenuItemnEditarActionPerformed

private void jMenuItemCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCancelarActionPerformed
    UsuarioCtrl.cancelar();
}//GEN-LAST:event_jMenuItemCancelarActionPerformed

private void jMenuItemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirActionPerformed
    UsuarioCtrl.excluir();
}//GEN-LAST:event_jMenuItemExcluirActionPerformed

private void jMenuItemSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalvarActionPerformed
    UsuarioCtrl.gravar();
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

private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    jTextFieldusuarionome.setNextFocusableComponent(jTextFieldusuariogrupoid);
    jTextFieldusuariogrupoid.setNextFocusableComponent(jTextFielddescricaogrupo);
    jTextFielddescricaogrupo.setNextFocusableComponent(jTextFieldusuariologin);
    jTextFieldusuariologin.setNextFocusableComponent(jPasswordFieldusuariosenha);
    jPasswordFieldusuariosenha.setNextFocusableComponent(jRadioButtonAdministrador);
    jRadioButtonAdministrador.setNextFocusableComponent(jRadioButtonUsuario);
}//GEN-LAST:event_formWindowOpened

private void EditarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarBotaoActionPerformed
    if (UsuarioCtrl.getObUsuario() == null) {
        JOptionPane.showMessageDialog(this, "Selecione primeiro um Usuário", "Alerta!", JOptionPane.WARNING_MESSAGE);
    } else {
        this.habilita();

    }
}//GEN-LAST:event_EditarBotaoActionPerformed

private void FecharBotao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FecharBotao1ActionPerformed
    // TODO add your handling code here:
}//GEN-LAST:event_FecharBotao1ActionPerformed

private void JButtonPesquisaDespartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonPesquisaDespartamentoActionPerformed
    new ConsultaGrupoView(UsuarioCtrl, this).setVisible(true);
}//GEN-LAST:event_JButtonPesquisaDespartamentoActionPerformed

    private void jPasswordFieldRepitasenhaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldRepitasenhaFocusLost
        jPasswordFieldRepitasenha.setText(EncriptaSenha.encripta(jPasswordFieldRepitasenha.getText()));  
        this.validaSenha();
    }//GEN-LAST:event_jPasswordFieldRepitasenhaFocusLost

    private void jButtonConsultaFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultaFotoActionPerformed
          try
          {
              JFileChooser busca_foto = new JFileChooser();
              busca_foto.setCurrentDirectory(new File("C:\\Programacao\\PROJETO_SEGURO\\EasySeg\\src\\Fotos\\Usuario"));
              busca_foto.setDialogTitle("Carregar imagem do Usuário");
              busca_foto.showOpenDialog(this);
              String foto = ""+busca_foto.getSelectedFile().getName();
              jTextFieldusuariofoto.setText(foto);
              lbFoto.setIcon(new ImageIcon("C:\\Programacao\\PROJETO_SEGURO\\EasySeg\\src\\Fotos\\Usuario\\"+jTextFieldusuariofoto.getText()));
          }
          catch (Exception erro)
          {
         JOptionPane.showMessageDialog(null, "Não foi possívelcarregar a foto.");
        }    
    }//GEN-LAST:event_jButtonConsultaFotoActionPerformed

    private void TblUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblUsuarioMouseClicked
    DefaultTableModel model = (DefaultTableModel) TblUsuario.getModel();
    int linhaClicada = TblUsuario.getSelectedRow();
    int cepid = (Integer) model.getValueAt(linhaClicada, 0);
    UsuarioCtrl.buscar(cepid);
    if (!jTextFieldusuariogrupoid.getText().trim().equals("")) {
        GrupoCTRL ctrlGrupo = new GrupoCTRL();
        Grupo obGrupo = ctrlGrupo.getGrupo(Integer.parseInt(jTextFieldusuariogrupoid.getText()));
        jTextFielddescricaogrupo.setText(obGrupo.getGruponome());// TODO add your handling code here:   
        this.atualizaFoto();  }
    }//GEN-LAST:event_TblUsuarioMouseClicked

    private void TblUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TblUsuarioKeyReleased
    DefaultTableModel model = (DefaultTableModel) TblUsuario.getModel();
    int linhaClicada = TblUsuario.getSelectedRow();
    int usuarioid = (Integer) model.getValueAt(linhaClicada, 0);
    UsuarioCtrl.buscar(usuarioid);
    if (!jTextFieldusuariogrupoid.getText().trim().equals("")) {
        GrupoCTRL ctrlGrupo = new GrupoCTRL();
        Grupo obGrupo = ctrlGrupo.getGrupo(Integer.parseInt(jTextFieldusuariogrupoid.getText()));
        jTextFielddescricaogrupo.setText(obGrupo.getGruponome());// TODO add your handling code here:
        this.atualizaFoto();
          }
    
    }//GEN-LAST:event_TblUsuarioKeyReleased

    private void jTextFieldusuariogrupoidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldusuariogrupoidKeyReleased
         validarIteiros(jTextFieldusuariogrupoid);
    }//GEN-LAST:event_jTextFieldusuariogrupoidKeyReleased

    private void jTextFieldusuariogrupoidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldusuariogrupoidFocusLost
    GrupoCTRL ctrlGrupo = new GrupoCTRL();
    Grupo obGrupo = ctrlGrupo.getGrupo(Integer.parseInt(jTextFieldusuariogrupoid.getText()));
    jTextFielddescricaogrupo.setText(obGrupo.getGruponome());

    }//GEN-LAST:event_jTextFieldusuariogrupoidFocusLost

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
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioView().setVisible(true);
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
    private javax.swing.JButton FecharBotao1;
    private javax.swing.JButton ImprimirBotao;
    private javax.swing.JButton ImprimirBotao2;
    private javax.swing.JButton JButtonPesquisaDespartamento;
    private javax.swing.JButton NovoBotao;
    private javax.swing.JButton PrimeiroBotao;
    private javax.swing.JButton ProximoBotao;
    private javax.swing.JTable TblUsuario;
    private javax.swing.JButton UltimoBotao;
    private javax.swing.ButtonGroup buttonGroupNivelUsuario;
    private javax.swing.JButton jButtonConsultaFoto;
    private javax.swing.JButton jButtonConsultaGrupo;
    private com.toedter.calendar.JDateChooser jDateChooserusuariodatacriacao;
    private javax.swing.JLabel jLabeldepartamentodescricao;
    private javax.swing.JLabel jLabelusuariodatacriacao;
    private javax.swing.JLabel jLabelusuariodepartamentoid;
    private javax.swing.JLabel jLabelusuarioid;
    private javax.swing.JLabel jLabelusuariologin;
    private javax.swing.JLabel jLabelusuarionome;
    private javax.swing.JLabel jLabelusuariosenha;
    private javax.swing.JLabel jLabelusuariosenha1;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordFieldRepitasenha;
    private javax.swing.JPasswordField jPasswordFieldusuariosenha;
    private javax.swing.JRadioButton jRadioButtonAdministrador;
    private javax.swing.JRadioButton jRadioButtonUsuario;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFielddescricaogrupo;
    private javax.swing.JTextField jTextFieldusuariofoto;
    private javax.swing.JTextField jTextFieldusuariogrupoid;
    private javax.swing.JTextField jTextFieldusuarioid;
    private javax.swing.JTextField jTextFieldusuariologin;
    private javax.swing.JTextField jTextFieldusuarionome;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JLabel lbFoto;
    private javax.swing.JScrollPane masterScrollPane;
    // End of variables declaration//GEN-END:variables
}
