package ctrl;

import dao.FichaDAO;
import java.util.*;
import javax.swing.JOptionPane;
import model.Ficha;
import view.FichaVIEW;

public class FichaCTRL {

    private FichaVIEW form;
    private Ficha obFicha;
   

    public Ficha getObFicha() {
        return obFicha;
    }

    public void setObFicha(Ficha obFicha) {
        this.obFicha = obFicha;
    }

    public FichaCTRL() {
    }

    public FichaCTRL(FichaVIEW form) {
        this.form = form;
    }

    public void novo() { //inicializa os campos do formulário(FichaView) e o objeto
        form.setIDficha(0);
        form.setNome("");
        form.setFicha("");
        form.setCodigo("");
        form.setRelatorio("");
        form.setQuantidade("");
        form.setPares("");
        form.setNumero("");
        form.setModelo("");
        form.setStatus("");
        form.habilita();
        obFicha = null;
    }

    public void gravar() {

        if (obFicha == null) {

            obFicha = new Ficha();
            obFicha.setIDficha(form.getIDficha());
            obFicha.setNome(form.getNome());
            obFicha.setFicha(form.getFicha());
            obFicha.setCodigo(form.getCodigo());
            obFicha.setRelatorio(form.getRelatorio());
            obFicha.setQuantidade(form.getQuantidade());
            obFicha.setPares(form.getPares());
            obFicha.setNumero(form.getNumero());
            obFicha.setModelo(form.getModelo());
            obFicha.setStatus(form.getStatus());
                     
            String resultado = FichaDAO.incluir(obFicha);

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "Ficha " + obFicha.getNome() + " registrado com Sucesso!", "Cadastro de Fichas", JOptionPane.INFORMATION_MESSAGE);
                novo();
                atualizaTabelaFicha();
                form.desabilita();
            } else {

                // Erros de inclusão que o Oracle possa retornar!
                String erro_oracle1 = "ORA-01400: não é possível inserir NULL em (" + '"' + "EASYSEG" + '"' + "." + '"' + "FICHA" + '"' + "." + '"' + "NOME" + '"' + ")\n";
                String erro_oracle2 = "ORA-00001: restrição exclusiva (EASYSEG.FICHA_UK_01) violada\n";


                //Executa a validação dos erros encontrados
                if (resultado.equals(erro_oracle1)) {
                    JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "NOME" + '"' + " obrigatório não preenchido.", "Cadastro de Fichas", JOptionPane.WARNING_MESSAGE);
                    obFicha = null;
                    } else {
                       if (resultado.equals(erro_oracle2)) {
                         JOptionPane.showMessageDialog(null, "Erro: Campo " + "'" + "NOME" + '"' + " com registro " + obFicha.getNome() + " já cadastrado.", "Cadastro de Ficha", JOptionPane.WARNING_MESSAGE);
                         obFicha = null;
                } else {
                     JOptionPane.showMessageDialog(form, resultado + "\n"
                          + "Informe este erro ao seu suporte técnico!");
                       }
                  }
              }       
            } else {
            obFicha.setIDficha(form.getIDficha());
            obFicha.setNome(form.getNome());
            obFicha.setFicha(form.getFicha());
            obFicha.setCodigo(form.getCodigo());
            obFicha.setRelatorio(form.getRelatorio());
            obFicha.setQuantidade(form.getQuantidade());
            obFicha.setPares(form.getPares());
            obFicha.setNumero(form.getNumero());
            obFicha.setModelo(form.getModelo());
            obFicha.setStatus(form.getStatus());
                     
            String resultado = FichaDAO.alterar(obFicha);

            if (resultado == null) {
                JOptionPane.showMessageDialog(null, "Ficha alterado com sucesso!", "Alteração de Ficha", JOptionPane.INFORMATION_MESSAGE);
                atualizaTabelaFicha();
                novo();
                form.desabilita();

            }

            //Erros de alteração que o Oracle possa retornar!
            String erro_oracle1 = "ORA-01407: não é possível atualizar (" + '"' + "EASYSEG" + '"' + "." + '"' + "FICHA" + '"' + "." + '"' + "NOME" + '"' + ") para NULL\n";
            String erro_oracle2 = "ORA-00001: restrição exclusiva (EASYSEG.FICHA_UK_01) violada\n";


            //Executa a validação dos erros encontrados
            if (resultado.equals(erro_oracle1)) {
                JOptionPane.showMessageDialog(null, "Erro: Campo " + '"' + "NOME" + '"' + " obrigatório não preenchido.", "Cadastro de Fichas", JOptionPane.WARNING_MESSAGE);
                obFicha = null;
                } else {
                    if (resultado.equals(erro_oracle2)) {
                        JOptionPane.showMessageDialog(null, "Erro: Campo " + "'" + "NOME" + '"' + " com registro " + obFicha.getNome() + " já cadastrado.", "Cadastro de Ficha", JOptionPane.WARNING_MESSAGE);
                        obFicha = null;
            } else {
                  JOptionPane.showMessageDialog(form, resultado + "\n"
                       + "Informe este erro ao seu suporte técnico!");
                     }
                 }
            }
       } 
//apaga as linhas existentes e adiciona novas
    public void atualizaTabelaFicha() {

        List<Ficha> listaFicha = null;

        listaFicha = FichaDAO.buscarTodos();

        form.zeraLinhasTblFicha();
        for (int x = 0; x <= listaFicha.size() - 1; x++) {
            form.adicionaTblFicha(listaFicha.get(x).getIDficha(),
                    listaFicha.get(x).getNome(),
                    listaFicha.get(x).getFicha(),
                    listaFicha.get(x).getCodigo(),
                    listaFicha.get(x).getRelatorio(),
                    listaFicha.get(x).getQuantidade(),
                    listaFicha.get(x).getPares(),
                    listaFicha.get(x).getNumero(),
                    listaFicha.get(x).getModelo(),
                    listaFicha.get(x).getStatus());
                    
        }

    }

    public void excluir() {

        if (obFicha == null) {
            JOptionPane.showMessageDialog(null, "Não existe Ficha selecionado para excluir! ", "Exclusão de Ficha", JOptionPane.WARNING_MESSAGE);
        } else {
            Object[] options = {"Sim", "Não"};
            int i = JOptionPane.showOptionDialog(form, "Deseja Excluir o Ficha \n"
                    + obFicha.getIDficha() + " - " + obFicha.getNome() + "?", "Confirmação",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (i == 0) {
                String resultado = FichaDAO.excluir(obFicha);
                if (resultado == null) {
                    JOptionPane.showMessageDialog(null, "Ficha excluído com sucesso!", "Exclusão de Ficha", JOptionPane.INFORMATION_MESSAGE);
                    atualizaTabelaFicha();
                    novo();
                    form.desabilita();
                } else { //se tiver algum erro

                    //Erros de exclusão que o Oracle possa retornar!
                    String erro_oracle1 = "ORA-02292: restrição de integridade (EASYSEG.CIDADE_FK_01) violada - registro filho localizado\n";

                    //Executa a validação dos erros encontrados
                    if (resultado.equals(erro_oracle1)) {
                        JOptionPane.showMessageDialog(null, "Não foi possivel realizar a exclusão do Ficha " + obFicha.getIDficha() + " - " + obFicha.getNome() + ". \n"
                                + "Existe(m) relacionamento(s) com: \n"
                                + "CADASTRO DE SEGURO", "Exclusão de Ficha", JOptionPane.WARNING_MESSAGE);

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


        obFicha = FichaDAO.buscar(id);
        form.setIDficha(obFicha.getIDficha());
        form.setNome(obFicha.getNome());
   
    }

}