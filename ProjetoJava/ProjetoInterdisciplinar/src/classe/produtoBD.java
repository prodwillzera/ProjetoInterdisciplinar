/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import connection.connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nmare
 */
public class produtoBD {

    // Busca o produto certo pelo nome + tamanho selecionados nos combos
    public produto buscarPorNomeETamanho(String nome, int tamanho) {
        String sql = "SELECT * FROM produto WHERE nome = ? AND tamanho = ?";
        try (
            Connection conn = connection.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, nome);
            stmt.setInt(2, tamanho);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("tamanho"),
                        rs.getDouble("preco"),
                        rs.getInt("estoque")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // não encontrado
    }
    
    public ArrayList<produto> buscarTodosProdutos() {

        ArrayList<produto> lista = new ArrayList<>();

        String sql = "SELECT * FROM produto";

        try (
            Connection conn = connection.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                produto p = new produto(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getInt("tamanho"),
                    rs.getDouble("preco"),
                    rs.getInt("estoque")
                );

                lista.add(p);
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
    public boolean removerProduto(int id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        
        try (
            Connection conn = connection.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
            ) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
        }
    }

}
