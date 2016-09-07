package ctrl;

import view.GrupoView;
import dao.GrupoDAO;
import model.Grupo;
import java.util.List;
import javax.swing.JOptionPane;

public class GrupoCTRL {

    private GrupoView form;
    private Grupo obGrupo;

    public Grupo getObGrupo() {
        return obGrupo;
    }

    public void setObGrupo(Grupo obGrupo) {
        this.obGrupo = obGrupo;
    }

    public GrupoCTRL() {
    }

    public GrupoCTRL(GrupoView form) {
        this.form = form;
    }

    public void novo() { //inicializa os campos do formulário(GrupoView) e o objeto
        form.setGrupoid(0);
        form.setGruponome("");
        form.habilita();
        obGrupo = null;
    }

    public void gravar() {
        if (obGrupo == null) {

            obGrupo = new Grupo();
            obGrupo.setGrupoid(form.getGrupoid());
            obGrupo.setGruponome(form.getGruponome());
            String resultado = GrupoDAO.incluir(obGrupo);
            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "Grupo " + obGrupo.getGruponome() + " registrado com Sucesso!", "Cadastro de Grupo", JOptionPane.INFORMATION_MESSAGE);
                novo();
                atualizaTabelaGrupo();
                form.desabilita();

            } else {

                // Erros de inclusão que o Oracle possa retornar!
                String erro_oracle1 = "ORA-01400: não é possível inserir NULL em (" + '"' + "EASYSEG" + '"' + "." + '"' + "GRUPO" + '"' + "." + '"' + "GRUPONOME" + '"' + ")\n";
                String erro_oracle2 = "ORA-00001: restrição exclusiva (EASYSEG.GRUPO_UK_01) violada\n";



                //Executa a validação dos erros encontrados
                if (resultado.equals(erro_oracle1)) {
                    JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "NOME" + '"' + " obrigatório não preenchido.", "Cadastro de Grupo", JOptionPane.WARNING_MESSAGE);
                    obGrupo = null;
                } else {
                    if (resultado.equals(erro_oracle2)) {
                        JOptionPane.showMessageDialog(null, "Erro: Campo " + "'" + "NOME" + '"' + " com registro " + obGrupo.getGruponome() + " já cadastrado.", "Cadastro de Grupo", JOptionPane.WARNING_MESSAGE);
                        obGrupo = null;
                    } else {
                        JOptionPane.showMessageDialog(form, resultado + "\n"
                                + "Informe este erro ao seu suporte técnico!");
                    }
                }
            }
        } else {
            obGrupo.setGrupoid(form.getGrupoid());
            obGrupo.setGruponome(form.getGruponome());
            String resultado = GrupoDAO.alterar(obGrupo);
            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "Grupo alterado com sucesso!", "Alterando Grupo...", JOptionPane.INFORMATION_MESSAGE);
                atualizaTabelaGrupo();
                novo();
                form.desabilita();
            }

            // Erros de alteração que o Oracle possa retornar!
            String erro_oracle1 = "ORA-01407: não é possível atualizar (" + '"' + "EASYSEG" + '"' + "." + '"' + "GRUPO" + '"' + "." + '"' + "GRUPONOME" + '"' + ") para NULL\n";
            String erro_oracle2 = "ORA-00001: restrição exclusiva (EASYSEG.GRUPO_UK_01) violada\n";



            //Executa a validação dos erros encontrados
            if (resultado.equals(erro_oracle1)) {
                JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "NOME" + '"' + " obrigatório não preenchido.", "Cadastro de Grupo", JOptionPane.WARNING_MESSAGE);
                obGrupo = null;
            } else {
                if (resultado.equals(erro_oracle2)) {
                    JOptionPane.showMessageDialog(null, "Erro: Campo " + "'" + "NOME" + '"' + " com registro " + obGrupo.getGruponome() + " já cadastrado.", "Cadastro de Grupo", JOptionPane.WARNING_MESSAGE);
                    obGrupo = null;
                } else {
                    JOptionPane.showMessageDialog(form, resultado + "\n"
                            + "Informe este erro ao seu suporte técnico!");
                }
            }
        }
    }

//apaga as linhas existentes e adiciona novas
    public void atualizaTabelaGrupo() {

        List<Grupo> listaGrupo = null;

        listaGrupo = GrupoDAO.buscarTodos();

        form.zeraLinhasTblGrupo();
        for (int x = 0; x <= listaGrupo.size() - 1; x++) {
            form.adicionaTblGrupo(listaGrupo.get(x).getGrupoid(),
                    listaGrupo.get(x).getGruponome());
        }

    }

    public void excluir() {
        if (obGrupo == null) {
            JOptionPane.showMessageDialog(null, "Não existe Grupo selecionado para excluir! ", "Exclusão de Grupo", JOptionPane.WARNING_MESSAGE);
        } else {
            Object[] options = {"Sim", "Não"};
            int i = JOptionPane.showOptionDialog(form, "Deseja excluir o Grupo \n"
                    + obGrupo.getGrupoid() + " - " + obGrupo.getGruponome() + "?", "Confirmação",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (i == 0) {
                String resultado = GrupoDAO.excluir(obGrupo);
                if (resultado == null) {
                    JOptionPane.showMessageDialog(null, "Grupo excluído com sucesso!", "Exclusão de Grupo", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabelaGrupo();
                    novo();
                    form.desabilita();
                } else { //se tiver algum erro
                    String erro_oracle = "ORA-02292: restrição de integridade (EASYSEG.USUARIO_FK_01) violada - registro filho localizado\n";
                    if (resultado.equals(erro_oracle)) {
                        JOptionPane.showMessageDialog(null, "Não foi possivel realizar a exclusão do Grupo: " + obGrupo.getGrupoid() + " - " + obGrupo.getGruponome() + ". \n"
                                + "Existe(m) relacionamento(s) com: \n"
                                + "CADASTRO DE USUÁRIO.", "Exclusão de Grupo", JOptionPane.WARNING_MESSAGE);
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
        obGrupo = new Grupo();
        obGrupo.setGrupoid(id);
        String resultado = GrupoDAO.buscar(obGrupo);
        if (resultado == null) {
            form.setGrupoid(obGrupo.getGrupoid());
            form.setGruponome(obGrupo.getGruponome());
        } else {
            obGrupo = null;
            JOptionPane.showMessageDialog(null, "Grupo não encontrado ... " + resultado, "Procurando Grupo...", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    public Grupo getGrupo(int id) { //esse metodo é usado para capturar evento mause clicked na tebela Usuário
        obGrupo = new Grupo();
        obGrupo.setGrupoid(id);
        String resultado = GrupoDAO.buscar(obGrupo);
        if (resultado == null) {
            return obGrupo;

        } else {
            obGrupo = null;
            JOptionPane.showMessageDialog(null, "Grupo não encontrado ... " + resultado, "Procurando Grupo...", JOptionPane.PLAIN_MESSAGE);
        }
        return null;
    }
}
