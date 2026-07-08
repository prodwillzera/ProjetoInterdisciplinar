/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

/**
 *
 * @author nmare
 */
public class carrinho {
    private int id;
    private int idUsuario;
    private int idProduto;
    private int quantidade;

    // usado ao inserir um novo item (ainda sem id gerado)
    public carrinho(int idUsuario, int idProduto, int quantidade) {
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    // usado ao ler um item já existente no banco
    public carrinho(int id, int idUsuario, int idProduto, int quantidade) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}