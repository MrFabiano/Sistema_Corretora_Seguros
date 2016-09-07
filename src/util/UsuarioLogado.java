package util;

import model.Grupo;
import model.Usuario;

public class UsuarioLogado {

    private Usuario us;
    private Grupo dp;
    private static UsuarioLogado _instance;

    public UsuarioLogado() {
    }

    public static UsuarioLogado getInstancia() {
        if (_instance == null) {
            _instance = new UsuarioLogado();
        }

        return _instance;
    }

    public Usuario getUs() {
        return us;
    }

    public void setUs(Usuario us) {
        this.us = us;
    }

    public Grupo getDp() {
        return dp;
    }

    public void setDp(Grupo dp) {
        this.dp = dp;
    }
}
