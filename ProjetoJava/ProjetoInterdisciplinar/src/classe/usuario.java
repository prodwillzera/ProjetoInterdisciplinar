/*
 
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
package classe;

/**
 *
 
@author nmare*/
public class usuario {
    private int id;

    private String username;
    
    private String passwords;

    private String tipo;

    public usuario(String username, String passwords, String tipo) {

        this.username = username;

        this.passwords = passwords;
        
        this.tipo = tipo;
    }

    public usuario(int id, String username, String passwords, String tipo) {

        this.id = id;

        this.username = username;

        this.passwords = passwords;
        
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return username;
    }

    public String getpsw() {
        return passwords;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setName(String username) {
        this.username = username;
    }
    
    public void setpsw(String passwords) {
        this.passwords = passwords;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
