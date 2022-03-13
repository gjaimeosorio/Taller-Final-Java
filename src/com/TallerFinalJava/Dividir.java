package com.TallerFinalJava;
import com.TallerFinalJava.Dividir;

//Clase dividir
public class Dividir implements Operacion {

    private float parcialResult;
    private float newValue;

    public float resultado() {
        return this.getParcialResult() / this.getNewValue(); //realiza la operacion division
    }

    public float getParcialResult() {
        return parcialResult;
    }

    public void setParcialResult(float parcialResult) {
        this.parcialResult = parcialResult;
    }

    public float getNewValue() {
        return newValue;
    }

    public void setNewValue(float newValue) {
        this.newValue = newValue;
    }
}