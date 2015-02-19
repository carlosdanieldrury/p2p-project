/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package p2p;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Ariel, Carlos e henrique
 */
public class Mensagem implements Serializable {


    private int id;
    private String remetente;
    private GregorianCalendar data;
    private String texto;
    private String destinatario;

    public Mensagem(int id, String remetente, String destinatario, GregorianCalendar data, String texto) {
        this.id = id;
        this.remetente = remetente;
        this.data = data;
        this.texto = texto;
        this.destinatario = destinatario;
               
    }

    public Mensagem() {
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public GregorianCalendar getData() {
        return data;
    }

    public void setData(GregorianCalendar data) {
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "Remetente: "+this.remetente+
                " Destinatario: "+this.destinatario+
                " Data: "+this.data.get(Calendar.DAY_OF_MONTH)+"/"+ this.data.get(Calendar.MONTH)+
                "/"+this.data.get(Calendar.YEAR)+" Hora: " +this.data.get(Calendar.HOUR_OF_DAY)+":"+this.data.get(Calendar.MINUTE)+
                ":"+this.data.get(Calendar.SECOND)+
                " Mensagem: "+this.texto;
                
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestinatio() {
        return destinatario;
    }

    public void setDestinatio(String destinatio) {
        this.destinatario = destinatio;
    }
    
}
