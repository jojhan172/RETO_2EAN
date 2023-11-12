package com.ex.mkombat.entities;

import com.ex.mkombat.Fortachon;
import com.ex.mkombat.Personaje;

public class Ryu extends Personaje {
    
    public Ryu(String nombrePersonaje) {
        super(nombrePersonaje);
    }

    @Override
    public void setDanioBase(float dañoBase) {
        Fortachon fortachon = new Fortachon();
        float dañoExtra = fortachon.getExtraFuerza();
        float dañoInicial = this.danioBase;
        float dañoFinal = dañoExtra + dañoInicial;
        super.setDanioBase(dañoFinal);
        fortachon = null;
    }

    @Override
    protected void Vida() {
        Fortachon fortachon = new Fortachon();
        this.vida = fortachon.getExtraVida() + getVida();
        fortachon = null;
    }

    @Override
    protected void Defensa() {
        Fortachon fortachon = new Fortachon();
        this.defensa = fortachon.getExtraDefensa() + getDefensa();
        fortachon = null;
    }

    @Override
    protected void Fuerza() {
        Fortachon fortachon = new Fortachon();
        this.fuerza = fortachon.getExtraFuerza() + getFuerza();
        fortachon = null;
    }
}

