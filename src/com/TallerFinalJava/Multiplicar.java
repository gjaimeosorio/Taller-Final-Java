package com.TallerFinalJava;
import com.TallerFinalJava.Multiplicar;

//Clase multiplicar
public class Multiplicar implements Operacion {

    private float parcialResult;
    private float newValue;

    public float resultado() {
        return this.getParcialResult() * this.getNewValue(); //Realiza la operacion multiplicar
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