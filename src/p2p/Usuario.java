/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.io.Serializable;

/**
 *
 * author Ariel, Carlos e henrique
 */
public class Usuario implements Serializable {
    private String nome;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String senha) {
      
        this.nome = nome;
        this.senha = senha;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

 
    public boolean equals(Usuario obj) {
        if (obj.nome.equals(this.nome) ){
            return true;
       }
        return false;
    }

    @Override
    public String toString() {
        return "Usuario: "+this.nome+ " Senha: "+this.senha;
    }
    
    
}
