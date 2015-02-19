/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;
/**
 *
 * @author ariel
 */
public class Descritor {
    
    public int id;
    public String nome;
    public int tamBytes;
    public String path;
    public String ipOrigem;
    
    public Descritor () {
        
    }

    public Descritor(int id, String nome, int tamBytes, String path, String ipOrigem) {
        this.id = id;
        this.nome = nome;
        this.tamBytes = tamBytes;
        this.path = path;
        this.ipOrigem = ipOrigem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTamBytes() {
        return tamBytes;
    }

    public void setTamBytes(int tamBytes) {
        this.tamBytes = tamBytes;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }    

    public String getIpOrigem() {
        return ipOrigem;
    }

    public void setIpOrigem(String ipOrigem) {
        this.ipOrigem = ipOrigem;
    }
    
    
}
