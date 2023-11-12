package com.ex.mkombat.entities;

import com.ex.mkombat.Agil;
import com.ex.mkombat.Personaje;

public class ChunLi extends Personaje {
    
    public ChunLi(String nombrePersonaje) {
        super(nombrePersonaje);
    }

    @Override
    public void setDanioBase(float danioBase) {
        Agil agil = new Agil();
        float dañoExtra = agil.getExtraFuerza();
        float dañoInicial = this.danioBase;
        float dañoFinal = dañoExtra + dañoInicial;
        super.setDanioBase(dañoFinal);
        agil = null;
    }

    @Override
    protected void Vida() {
        Agil agil = new Agil();
        this.vida = agil.getExtraVida() + getVida();
        agil = null;
    }

    @Override
    protected void Defensa() {
        Agil agil = new Agil();
        this.defensa = agil.getExtraDefensa() + getDefensa();
        agil = null;
    }

    @Override
    protected void Fuerza() {
        Agil agil = new Agil();
        this.fuerza = agil.getExtraFuerza() + getFuerza();
        agil = null;
    }
}

