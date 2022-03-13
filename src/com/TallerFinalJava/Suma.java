package com.TallerFinalJava;
import com.TallerFinalJava.Suma;

//Clase suma
public class Suma implements Operacion {

    private float parcialResult;
    private float newValue;

    public float resultado() {
        return this.getParcialResult() + this.getNewValue(); //Realiza la operacion suma
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