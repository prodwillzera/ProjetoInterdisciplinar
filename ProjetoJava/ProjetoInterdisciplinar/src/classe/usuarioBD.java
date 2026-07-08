/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import connection.connection;
import classe.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

/**
 *
 * @author nmare
 */
public class usuarioBD {
    public void cadastrar(usuario usuario) {

        String sql
                = "INSERT INTO usuario(username, passwords, tipo) VALUES(?, ?, ?)";

        try (Connection conn = connection.conectar(); PreparedStatement stmt
                = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getName());

            stmt.setString(2, usuario.getpsw());
            
            stmt.setString(3, usuario.getTipo());

            stmt.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public ArrayList<usuario> listarTodosUsuarios() {

        ArrayList<usuario> lista = new ArrayList<>();

        String sql
                = "SELECT * FROM usuario";

        try (
                Connection conn = connection.conectar(); PreparedStatement stmt
                = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                usuario usuario = new usuario(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("passwords"),
                        rs.getString("tipo")
                );

                lista.add(usuario);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return lista;
    }
    
    public ArrayList<usuario> listarTodosStaff() {

        ArrayList<usuario> lista = new ArrayList<>();

        String sql
                = "SELECT * FROM usuario WHERE tipo = 'STAFF'";

        try (
                Connection conn = connection.conectar(); PreparedStatement stmt
                = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                usuario usuario = new usuario(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("passwords"),
                        rs.getString("tipo")
                );

                lista.add(usuario);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return lista;
    }

    public void updatePsw(int id, String novaPSW) {

        String sql
                = "UPDATE usuario SET passwords = ? WHERE id = ?";

        try (
                Connection conn = connection.conectar(); PreparedStatement stmt
                = conn.prepareStatement(sql)) {

            stmt.setString(1, novaPSW);

            stmt.setInt(2, id);

            stmt.executeUpdate();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
    public usuario fazerLogin(String username, String passwords) {
        String sql = "SELECT * FROM usuario WHERE username = ? AND passwords = ?";
        try (
            Connection conn = connection.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {
            stmt.setString(1, username);
            stmt.setString(2, passwords);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new usuario(
                    
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("passwords"),
                    rs.getString("tipo")
                    
                );
            }
            return null; // login falhou
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean atualizarUsuario(usuario u) {
        String sql = "UPDATE usuario SET username = ?, passwords = ?, tipo = ? WHERE id = ?";
        
        try (
            Connection conn = connection.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, u.getName());
            stmt.setString(2, u.getpsw());
            stmt.setString(3, u.getTipo());
            stmt.setInt(4, u.getId());

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean removerUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";
        
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

