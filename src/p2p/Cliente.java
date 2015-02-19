/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;
/**
 *
 * @author Ariel, Carlos e henrique
 */
import java.io.File;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Cliente {

    private Cliente() {
    }

    public static void main(String args[]) {
//
//        String host = (args.length < 1) ? null : args[0];
//        String host = "rmi://192.168.0.102:1500/EmailInterface" ;
        int op1, op2;
        Usuario usuario;
        boolean logado;
        Scanner b = new Scanner(System.in);
        boolean sucess = false;
        try {

            Registry registry = LocateRegistry.getRegistry("192.168.2.138", 10000);
            EmailInterface stub = (EmailInterface) registry.lookup("EmailInterface");

            boolean saiu = false;
            logado = false;
            while (!logado && !saiu) {
                usuario = new Usuario();
                op1 = menuAutentica();

                switch (op1) {
                    case 1:
                        System.out.println("Digite o nome do usuario");
                        usuario.setNome(b.nextLine());
                        System.out.println("Digite a senha do usuario");
                        usuario.setSenha(b.nextLine());
                        logado = stub.cadastrarUsu(usuario);
                        if (!logado) {
                            System.out.println("Usuario ja registrado");
                        } else {
                            System.out.println("Usuario registrado com sucesso");
                        }
                        break;
                    case 2:
                        System.out.println("Digite o nome do usuario");
                        usuario.setNome(b.nextLine());
                        System.out.println("Digite a senha do usuario");
                        usuario.setSenha(b.nextLine());
                        logado = stub.autenticaUsu(usuario);
                        if (!logado) {
                            System.out.println("Usuario nao registrado");
                        } else {
                            System.out.println("Usuario logado com sucesso");
                        }
                        break;
                    case 3:
                        logado = false;
                        saiu = true;
                        break;
                }

                while (logado && !saiu) {

                    System.out.println("Logado em " + usuario.getNome());
                    op2 = menu();
                    switch (op2) {
                        case 1:
                            System.out.println("Digite o Destinatario");
                            String destinatario = b.nextLine();
                            System.out.println("Digite o Mensagem");
                            String mensagem = b.nextLine();

                            Mensagem msg = new Mensagem((stub.getNroMensagem() + 1),
                                    usuario.getNome(), destinatario, new GregorianCalendar(), mensagem);
                            System.out.println(msg.toString());
                            stub.enviarMens(msg);

                            break;
                        case 2:
                            ArrayList<Mensagem> mensagens = stub.recuperaMensagem(usuario.getNome());
                            if (mensagens.isEmpty()) {
                                System.out.println("Nao existem mensagens para esse usuario");
                            } else {
                                for (Mensagem mensagem1 : mensagens) {
                                    System.out.println(mensagem1.toString());
                                }
                            }
                            break;
                        case 3:
                            logado = false;
                            break;
                    }

                }
            }
            //String response = stub.sayHello();

            //System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }

    public static int menuAutentica() {
        System.out.println("1 - Registrar");
        System.out.println("2 - Login");
        System.out.println("3 - Sair");
        return ((new Scanner(System.in)).nextInt());
    }
    
    public StringBuilder listFiles(String path){
        String caminho = javax.swing.JOptionPane.showInputDialog(path);  
        StringBuilder sb = new StringBuilder();  
          
        File raiz = new File(caminho);  
 
        for(File f: raiz.listFiles()) {  
            if(f.isFile()) {  
                System.out.println(f.getName());  
                sb.append(f.getName());  
                sb.append("\n");  
            }  
        }  
        return sb;
        //javax.swing.JOptionPane.showMessageDialog(null, sb.toString());  
    }

    public static int menu() {
        System.out.println("1 - Enviar Mensagem");
        System.out.println("2 - Recuperar Mensagens");
        System.out.println("3 - Logout");
        return ((new Scanner(System.in)).nextInt());
    }
}
