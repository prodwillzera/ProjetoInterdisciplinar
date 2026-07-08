/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import connection.connection;
import classe.itemCarrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nmare
 */

public class carrinhoBD {
    public boolean adicionarItem(int idUsuario, int idProduto, int quantidade) {
        String sql = "INSERT INTO carrinho(id_usuario, id_produto, quantidade) VALUES (?, ?, ?)";
        try ( Connection conn = connection.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idProduto);
            stmt.setInt(3, quantidade);
            stmt.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // LISTAR ITENS DO CARRINHO DE UM USUÁRIO, JÁ COM DADOS DO PRODUTO
    public ArrayList<itemCarrinho> listarPorUsuario(int idUsuario) {
        ArrayList<itemCarrinho> lista = new ArrayList<>();
        
        String sql = """
            SELECT p.id AS id_produto, p.nome, c.quantidade, p.preco, p.tamanho FROM carrinho c
            INNER JOIN produto p ON c.id_produto = p.id WHERE c.id_usuario = ?
        """;
        
        try (
            Connection conn = connection.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setInt(1, idUsuario);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getString("nome"));
                    System.out.println(rs.getInt("quantidade"));
                    System.out.println(rs.getDouble("preco"));
                    
                    lista.add(new itemCarrinho(
                        rs.getInt("id_produto"),
                        rs.getString("nome"),
                        rs.getInt("tamanho"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                    ));
                    
                    /*itemCarrinho item = new itemCarrinho(
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                    );*/
                    /*carrinho item = new carrinho(
                        rs.getInt("id"),
                        rs.getInt("id_usuario"),
                        rs.getInt("id_produto"),
                        rs.getInt("quantidade")
                    );
                    lista.add(item);*/
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public boolean removerItem(int idUsuario, int idProduto){
        String sql= """
            DELETE FROM carrinho where id_usuario = ?
            AND id_produto = ?            
        """;
        
        try(Connection conn = connection.conectar(); PreparedStatement stmt = conn.prepareCall(sql)){
            
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idProduto);
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean removerTodosItens(int idUsuario){
        String sql= "DELETE FROM carrinho where id_usuario = ?";
        
        try(Connection conn = connection.conectar(); PreparedStatement stmt = conn.prepareCall(sql)){
            
            stmt.setInt(1, idUsuario);
            
            stmt.executeUpdate();
            
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}