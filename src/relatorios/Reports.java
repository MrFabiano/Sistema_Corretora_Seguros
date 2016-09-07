/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package relatorios;

import dao.ConexaoDAO;
import java.io.InputStream;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Reports {

    private HashMap<String, Object> hash = new HashMap<String, Object>();
    private static Reports _instance = null;

    private Reports() {
    }

    public static Reports getInstance() {
        if (_instance == null) {
            _instance = new Reports();
        }
        return _instance;
    }

    private InputStream Relatorio(String arquivo) {
        InputStream relatorio = Reports.class.getResourceAsStream(arquivo);
        return relatorio;
    }

    public void setParametro(String parametro, Object valor) {
        hash.put(parametro, valor);
    }

    public void Execute(String relatorio) throws JRException {
        JasperPrint jp = JasperFillManager.fillReport(this.Relatorio(relatorio), this.hash, ConexaoDAO.getConexao());
        JasperViewer.viewReport(jp, false);

    }
}
