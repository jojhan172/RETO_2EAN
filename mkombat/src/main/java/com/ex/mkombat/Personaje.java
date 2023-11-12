package com.ex.mkombat;

public abstract class Personaje {
    
    protected String nombrePersonaje;
    protected float vida = 200;
    protected float defensa = 1;
    protected float fuerza = 1;
    protected float danioBase = 20;


    // Constructor method
    public Personaje(String nombrePersonaje){
        this.nombrePersonaje = nombrePersonaje;
        this.Vida(); // Vida
        this.Fuerza(); // fuerza
        this.Defensa(); // Defensa
    }
    
//___________________ Setters and Getters __________________________//
    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public float getDefensa() {
        return defensa;
    }

    public void setDefensa(float defensa) {
        this.defensa = defensa;
    }

    public float getFuerza() {
        return fuerza;
    }

    public void setFuerza(float fuerza) {
        this.fuerza = fuerza;
    }
    
    public float getDanioBase() {
            return danioBase;
    }

    public void setDanioBase(float dañoBase) {
        this.danioBase = dañoBase;
    }

//______________________________END Setters and Getters__________________________//

// this Class methods 
    protected abstract void Vida();
    protected abstract void Fuerza();
    protected abstract void Defensa();

    // Class methods -> Ataques y defensas
    public float ejecutarPatada(float danioBasePersonaje, float fuerza){
        float danioProducido = danioBasePersonaje * fuerza;
        return danioProducido + 10;
	}

    public float ejecutarPunio(float danioBasePersonaje, float fuerza){
        float danioProducido = danioBasePersonaje * fuerza;
        return danioProducido + 5;
    }
}
