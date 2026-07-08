/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

/**
 *
 * @author nmare
 */
public class itemCarrinho {

    private int idProduto;
    private String nome;
    private int tamanho;
    private int quantidade;
    private double preco;

    public itemCarrinho(int idProduto, String nome, int tamanho, int quantidade, double preco) {

        this.idProduto = idProduto;
        this.nome = nome;
        this.tamanho = tamanho;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getIdProduto() {
        return idProduto;
    }
    
    public String getNome() {
        return nome;
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }
}
