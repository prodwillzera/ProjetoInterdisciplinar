/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

/**
 *
 * @author nmare
 */
public class produto {
    private int id;
    private String nome;
    private int tamanho;
    private double preco;
    private int estoque;

    public produto(int id, String nome, int tamanho, double preco, int estoque) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
        this.preco = preco;
        this.estoque = estoque;
    }

    public int getId() {
        return id; 
    }
    public String getNome() {
        return nome; 
    }
    public int getTamanho() {
        return tamanho; 
    }
    public double getPreco() {
        return preco; 
    }
    public int getEstoque() {
        return estoque; 
    }
}
