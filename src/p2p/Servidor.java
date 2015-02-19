/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * author Ariel, Carlos e henrique
 */
public class Servidor extends UnicastRemoteObject implements EmailInterface {
    //StringBuffer mensagens

    private int nMensagens = 0;
    private static int nUsuario = 0;
    private List<Mensagem> mensagens = new ArrayList<Mensagem>();
    private ArrayList<Usuario> reUsuario = new ArrayList<Usuario>();
    

    public Servidor() throws RemoteException {
    }

    @Override
    public boolean cadastrarUsu(Usuario usuario) throws RemoteException {

        if (reUsuario.isEmpty()) {
            reUsuario.add(usuario);
            nUsuario++;
            return true;

        } else {
            for (Usuario usu : reUsuario) {
                if (!usu.equals(usuario)) {

                    reUsuario.add(usuario);
                    nUsuario++;
                    return true;
                } else {
                    System.out.println("Usuario ja registrado");
                    System.out.println(usuario.toString());
                    return false;
                }

            }

        }
        return false;
    }

    @Override
    public boolean enviarMens(Mensagem mensagem) throws RemoteException {
        
        return mensagens.add(mensagem);
    }


    public ArrayList<Mensagem> recuperaMensagem(String destinatario) throws RemoteException {
        ArrayList<Mensagem> msg = new ArrayList<Mensagem>();


        for (Mensagem msgs : mensagens) {
            if (msgs.getDestinatio().equals(destinatario)) {
                msg.add(msgs);
            }
        }

        return msg;
    }

    public static void main(String args[]) {

        try {

            //Create and export a remote object
            System.setProperty("java.rmi.server.hostname", "192.168.2.138");

            Servidor obj = new Servidor();
            //EmailInterface stub = (EmailInterface) UnicastRemoteObject.exportObject(obj, 0);
            Registry registry = LocateRegistry.createRegistry(10000);//Register the remote object with a Java RMI registry
            registry = LocateRegistry.getRegistry();
            Naming.bind("rmi://192.168.2.138:10000/EmailInterface", obj);
//            registry.bind("EmailInterface", obj);

            System.out.println("Server Ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

    @Override
    public boolean autenticaUsu(Usuario usuario) throws RemoteException {

        System.out.println(usuario.toString() + " " + reUsuario.get(0));
        if (!reUsuario.isEmpty()) {
            for (Usuario entry : reUsuario) {
                Usuario usuario1 = entry;
                System.out.println("Usuario 1 : " + usuario1);
                if (usuario.equals(usuario1)) {
                    System.out.println(usuario1);
                    System.out.println(usuario.toString());
                    System.out.println("autentico");//autentico
                    return true;
                }



            }

        }
        System.out.println("Nao autentico");//autentico
        return false;
    }

    @Override
    public int getNroMensagem() throws RemoteException {
        return mensagens.size();
    }

    @Override
    public Usuario getUsuario() throws RemoteException {
        return null;
    }
}
