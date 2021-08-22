/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmosdeconversion;

/**
 *
 * @author jean
 */
public class transicionPila {
    public int i_estado;
    public String lee;
    public String desApila;
    public int f_estado;
    public String Apila;

    public transicionPila(int i_estado, String lee, String desApila, int f_estado, String Apila) {
        this.i_estado = i_estado;
        this.lee = lee;
        this.desApila = desApila;
        this.f_estado = f_estado;
        this.Apila = Apila;
    }

    public int getI_estado() {
        return i_estado;
    }

    public void setI_estado(int i_estado) {
        this.i_estado = i_estado;
    }

    public String getLee() {
        return lee;
    }

    public void setLee(String lee) {
        this.lee = lee;
    }

    public String getDesApila() {
        return desApila;
    }

    public void setDesApila(String desApila) {
        this.desApila = desApila;
    }

    public int getF_estado() {
        return f_estado;
    }

    public void setF_estado(int f_estado) {
        this.f_estado = f_estado;
    }

    public String getApila() {
        return Apila;
    }

    public void setApila(String Apila) {
        this.Apila = Apila;
    }
    
    

    
    
}
