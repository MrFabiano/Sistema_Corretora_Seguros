package ctrl;

import dao.GrupoDAO;
import dao.UsuarioDAO;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import javax.swing.JOptionPane;
import model.Grupo;
import model.Usuario;
import view.ConsultaGrupoView;
import view.UsuarioView;

public class UsuarioCtrl {

    private UsuarioView form;
    private Usuario obUsuario;
    private ConsultaGrupoView consultaGrupoView;

    public void setConsultaGrupoView(ConsultaGrupoView consultaGrupoView) {
        this.consultaGrupoView = consultaGrupoView;

    }

    public Usuario getObUsuario() {
        return obUsuario;
    }

    public void setObUsuario(Usuario obUsuario) {
        this.obUsuario = obUsuario;
    }

    public UsuarioCtrl() {
    }

    public UsuarioCtrl(UsuarioView form) {
        this.form = form;
    }

    public void novo() { //inicializa os campos do formulário(UsuarioView) e o objeto
        form.setUsuarioid(0);
        form.setUsuarionome("");
        form.setUsuariologin("");
        form.setUsuariosenha("");
        form.setUsuariogrupoid(0);
        form.setUsuariotipo("");
        form.setGruponome("");
        form.setUsuariofoto("semfoto.jpg");
        form.setUsuariorepitasenha("");
        form.habilita();
        form.atualizaFoto();
        obUsuario = null;
    }

    public void gravar() {
        if (obUsuario == null) {

            obUsuario = new Usuario();
            obUsuario.setUsuarioid(form.getUsuarioid());
            obUsuario.setUsuarionome(form.getUsuarionome());
            obUsuario.setUsuariologin(form.getUsuariologin());
            obUsuario.setUsuariosenha(form.getUsuariosenha());
            obUsuario.setUsuariogrupoid(form.getUsuariogrupoid());
            obUsuario.setUsuariotipo(form.getUsuariotipo());
            try {
                obUsuario.setUsuariodatacriacao(form.getUsuariodatacriacao());
            } catch (ParseException ex) {
                Logger.getLogger(UsuarioCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
            obUsuario.setUsuariofoto(form.getUsuariofoto());
            String resultado = UsuarioDAO.incluir(obUsuario);
            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "Usuário " + obUsuario.getUsuarionome() + " registrado com Sucesso!", "Cadastro de Usuário", JOptionPane.INFORMATION_MESSAGE);
                novo();
                atualizaTabelaUsuario();
                form.desabilita();

            } else {

                // Erros de inclusão que o Oracle possa retornar!
           
           String erro_oracle1 = "ORA-01400: não é possível inserir NULL em (" + '"' + "EASYSEG" + '"' + "." + '"' + "USUARIO" + '"' + "." + '"' + "USUARIONOME" + '"' + ")\n";
           String erro_oracle2 = "ORA-01400: não é possível inserir NULL em (" + '"' + "EASYSEG" + '"' + "." + '"' + "USUARIO" + '"' + "." + '"' + "USUARIOLOGIN" + '"' + ")\n";
           String erro_oracle3 = "ORA-01400: não é possível inserir NULL em (" + '"' + "EASYSEG" + '"' + "." + '"' + "USUARIO" + '"' + "." + '"' + "USUARIOSENHA" + '"' + ")\n";
           String erro_oracle4 = "ORA-01400: não é possível inserir NULL em (" + '"' + "EASYSEG" + '"' + "." + '"' + "USUARIO" + '"' + "." + '"' + "USUARIOGRUPOID" + '"' + ")\n";
           String erro_oracle5 = "ORA-02291: restrição de integridade (" + '"' + "EASYSEG" + '"' + "." + '"' + "USUARIO" + '"' + "." + '"' + "USUARIODATACRIACAO" + '"' + ")\n";
           String erro_oracle6 = "ORA-00001: restrição exclusiva (EASYSEG.USUARIO_UK_01) violada\n";




                //Executa a validação dos erros encontrados
                if (resultado.equals(erro_oracle1)) {
                    JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "NOME" + '"' + " obrigatório não preenchido.", "Cadastro de Usuário", JOptionPane.WARNING_MESSAGE);
                    obUsuario = null;
                } else {
                    if (resultado.equals(erro_oracle2)) {
                        JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "LOGIN" + '"' + " obrigatório não preenchido.", "Cadastro de Usuário", JOptionPane.WARNING_MESSAGE);
                        obUsuario = null;
                    } else {
                        if (resultado.equals(erro_oracle3)) {
                            JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "SENHA" + '"' + " obrigatório não preenchido.", "Cadastro de Usuário", JOptionPane.WARNING_MESSAGE);
                            obUsuario = null;
                        } else {
                            if (resultado.equals(erro_oracle4)) {
                                JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "CÓDIGO DO GRUPO" + '"' + " obrigatório não preenchido.", "Cadastro de Usuário", JOptionPane.WARNING_MESSAGE);
                                obUsuario = null;
                            } else {
                              if (resultado.equals(erro_oracle5)) {
                                  JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "DATA DE CRIAÇÃO" + '"' + " obrigatório não preenchido.", "Cadastro de Usuário", JOptionPane.WARNING_MESSAGE);
                                  obUsuario = null;
                               } else {
                                  if (resultado.equals(erro_oracle6)) {
                                      JOptionPane.showMessageDialog(null, "Erro: Campo " + "'" + "LOGIN" + '"' + " com registro " + obUsuario.getUsuariologin() + " já cadastrado.", "Cadastro de Usuário", JOptionPane.WARNING_MESSAGE);
                                      obUsuario = null;
                                   } else {
                                       JOptionPane.showMessageDialog(form, resultado + "\n"
                                            + "Informe este erro ao seu suporte técnico!");
                                }
                            }
                        }
                    }
                }
            }
          }      
        } else {
            obUsuario.setUsuarioid(form.getUsuarioid());
            obUsuario.setUsuarionome(form.getUsuarionome());
            obUsuario.setUsuariologin(form.getUsuariologin());
            obUsuario.setUsuariosenha(form.getUsuariosenha());
            obUsuario.setUsuariogrupoid(form.getUsuariogrupoid());
            obUsuario.setUsuariotipo(form.getUsuariotipo());
            try {
                obUsuario.setUsuariodatacriacao(form.getUsuariodatacriacao());
            } catch (ParseException ex) {
                Logger.getLogger(UsuarioCtrl.class.getName()).log(Level.SEVERE, null, ex);
            }
            obUsuario.setUsuariofoto(form.getUsuariofoto());
            String resultado = UsuarioDAO.alterar(obUsuario);
            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "Usuário alterado com sucesso!", "Alterando Usuário...", JOptionPane.INFORMATION_MESSAGE);
                atualizaTabelaUsuario();
                novo();
                form.desabilita();
            }

            // Erros de alteração que o Oracle possa retornar!
            String erro_oracle1 = "ORA-01400: não é possível inserir NULL em (" + '"' + "EASYSEG" + '"' + "." + '"' + "USUARIO" + '"' + "." + '"' + "USUARIONOME" + '"' + ")\n";
            String erro_oracle2 = "ORA-01400: não é possível inserir NULL em (" + '"' + "EASYSEG" + '"' + "." + '"' + "USUARIO" + '"' + "." + '"' + "USUARIOLOGIN" + '"' + ")\n";
            String erro_oracle3 = "ORA-01400: não é possível inserir NULL em (" + '"' + "EASYSEG" + '"' + "." + '"' + "USUARIO" + '"' + "." + '"' + "USUARIOSENHA" + '"' + ")\n";
            String erro_oracle4 = "ORA-01400: não é possível inserir NULL em (" + '"' + "EASYSEG" + '"' + "." + '"' + "USUARIO" + '"' + "." + '"' + "USUARIOGRUPOID" + '"' + ")\n";
            String erro_oracle5 = "ORA-02291: restrição de integridade (" + '"' + "EASYSEG" + '"' + "." + '"' + "USUARIO" + '"' + "." + '"' + "USUARIODATACRIACAO" + '"' + ")\n";
            String erro_oracle6 = "ORA-00001: restrição exclusiva (EASYSEG.USUARIO_UK_01) violada\n";





            //Executa a validação dos erros encontrados
          if (resultado.equals(erro_oracle1)) {
                    JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "NOME" + '"' + " obrigatório não preenchido.", "Cadastro de Usuário", JOptionPane.WARNING_MESSAGE);
                    obUsuario = null;
                } else {
                    if (resultado.equals(erro_oracle2)) {
                        JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "LOGIN" + '"' + " obrigatório não preenchido.", "Cadastro de Usuário", JOptionPane.WARNING_MESSAGE);
                        obUsuario = null;
                    } else {
                        if (resultado.equals(erro_oracle3)) {
                            JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "SENHA" + '"' + " obrigatório não preenchido.", "Cadastro de Usuário", JOptionPane.WARNING_MESSAGE);
                            obUsuario = null;
                        } else {
                            if (resultado.equals(erro_oracle4)) {
                                JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "CÓDIGO DO GRUPO" + '"' + " obrigatório não preenchido.", "Cadastro de Usuário", JOptionPane.WARNING_MESSAGE);
                                obUsuario = null;
                            } else {
                              if (resultado.equals(erro_oracle5)) {
                                  JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "DATA DE CRIAÇÃO" + '"' + " obrigatório não preenchido.", "Cadastro de Usuário", JOptionPane.WARNING_MESSAGE);
                                  obUsuario = null;
                               } else {
                                  if (resultado.equals(erro_oracle6)) {
                                      JOptionPane.showMessageDialog(null, "Erro: Campo " + "'" + "NOME" + '"' + " com registro " + obUsuario.getUsuariologin() + " já cadastrado.", "Cadastro de Produto", JOptionPane.WARNING_MESSAGE);
                                      obUsuario = null;
                                   } else {
                                       JOptionPane.showMessageDialog(form, resultado + "\n"
                                            + "Informe este erro ao seu suporte técnico!");
                                }
                            }
                        }
                    }
                }
             }
          }      
       } 

//apaga as linhas existentes e adiciona novas
    public void atualizaTabelaUsuario() {

        List<Usuario> listaUsuario = null;

        listaUsuario = UsuarioDAO.buscarTodos();

        form.zeraLinhasTblUsuario();
        for (int x = 0; x <= listaUsuario.size() - 1; x++) {
            Grupo obGrupo  = new Grupo();
            if(listaUsuario.get(x).getUsuariogrupoid()!=0){
                obGrupo.setGrupoid(listaUsuario.get(x).getUsuariogrupoid());
                GrupoDAO.buscar(obGrupo);
            }
            form.adicionaTblUsuario(listaUsuario.get(x).getUsuarioid(),
                    listaUsuario.get(x).getUsuarionome(),
                    listaUsuario.get(x).getUsuariologin(),
                    listaUsuario.get(x).getUsuariosenha(),
                    obGrupo.getGruponome(),
                    listaUsuario.get(x).getUsuariotipo(),
                    listaUsuario.get(x).getUsuariodatacriacao(),
                    listaUsuario.get(x).getUsuariofoto());
            
        }

    }

    public void excluir() {
        if (obUsuario == null) {
            JOptionPane.showMessageDialog(null, "Não existe Usuário selecionado para excluir! ", "Exclusão de Usuário", JOptionPane.WARNING_MESSAGE);
        } else {
            Object[] options = {"Sim", "Não"};
            int i = JOptionPane.showOptionDialog(form, "Deseja excluir o Usuário \n"
                    + obUsuario.getUsuarioid() + " - " + obUsuario.getUsuariologin() + "?", "Confirmação",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (i == 0) {
                String resultado = UsuarioDAO.excluir(obUsuario);
                if (resultado == null) {
                    JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso!", "Exclusão de Usuário", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabelaUsuario();
                    novo();
                    form.desabilita();
                } else { //se tiver algum erro
                    String erro_oracle = "ORA-02292: restrição de integridade (EASYSEG.USUARIO_FK_01) violada - registro filho localizado\n";
                    if (resultado.equals(erro_oracle)) {
                        JOptionPane.showMessageDialog(null, "Não foi possível realizar a exclusão do Departamento: " + obUsuario.getUsuarioid() + " - " + obUsuario.getUsuariologin() + ". \n"
                                + "Existe(m) relacionamento(s) com: \n"
                                + "CADASTRO DE PRODUTO.", "Exclusão de Departamento", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
        form.requestFocus();
        form.desabilita();
    }

    public void cancelar() {
        novo();
        form.desabilita();
    }

    public void buscar(int id) {
        obUsuario = new Usuario();
        obUsuario.setUsuarioid(id);
        String resultado = UsuarioDAO.buscar(obUsuario);
        if (resultado == null) {
            form.setUsuarioid(obUsuario.getUsuarioid());
            form.setUsuarionome(obUsuario.getUsuarionome());
            form.setUsuariologin(obUsuario.getUsuariologin());
            form.setUsuariosenha(obUsuario.getUsuariosenha());
            form.setUsuariogrupoid(obUsuario.getUsuariogrupoid());
            form.setUsuariotipo(obUsuario.getUsuariotipo());
            form.setUsuariodatacriacao(obUsuario.getUsuariodatacriacao());
            form.setUsuariofoto(obUsuario.getUsuariofoto());
        } else {
            obUsuario = null;
            JOptionPane.showMessageDialog(null, "Usuário não encontrado ... " + resultado, "Procurando Usuário...", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public void preencheTblGrupo(String texto) { //esse método é utilizado na consulta de departamento
        UsuarioDAO dao = new UsuarioDAO();
        List<Grupo> grupos = dao.ConsultaGrupo(texto);
        consultaGrupoView.zeraLinha();
        for (int i = 0; i < grupos.size(); i++) {
            consultaGrupoView.preencheTblGrupo(grupos.get(i).getGrupoid(), grupos.get(i).getGruponome());
        }
    }
}
