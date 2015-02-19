/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package p2p;
/**
 *
 * author Ariel, Carlos e henrique
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface EmailInterface extends Remote {
//    Cadastrar um usuário;
//• Enviar uma mensagem para algum usuário;
//• Permitir a um usuário recuperar suas mensagens, mediante autenticação.
//    
    
    // old
    public boolean cadastrarUsu(Usuario usuario) throws RemoteException;
    public boolean enviarMens(Mensagem mensagem) throws RemoteException;
    public ArrayList<Mensagem> recuperaMensagem(String destinatario) throws  RemoteException;
    public boolean autenticaUsu(Usuario usuario) throws RemoteException;
    public int getNroMensagem () throws  RemoteException;
    public Usuario getUsuario () throws RemoteException;
    
    
    
    //new
    //public boolean cadastraArquivo (Descritor arqDescritor) throws RemoteException;
    //public List getListArq () throws RemoteException;
}