/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

/**
 *
 * @author nmare
 */
public class Sessao {
    private static usuario usuarioLogado;

    public static void setUsuarioLogado(usuario u) {
        usuarioLogado = u;
    }

    public static usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}
