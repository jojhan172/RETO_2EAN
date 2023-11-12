package com.ex.mkombat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.util.random;

import com.ex.mkombat.entities.ChunLi;
import com.ex.mkombat.entities.Ryu;


public class Main {
	
	// Metodo para instanciar personajes sin tener que repetir este codigo por cada jugardor de la partida. 
	public static Personaje elejirPersonajes(){
		Scanner scanner = new Scanner(System.in);
		int eleccionPersonaje = scanner.nextInt();
		if (eleccionPersonaje == 1){
			Ryu jp = new Ryu("Ryu");
			System.out.println("Elejiste a Ryu!");
			return jp;
		}
		else if(eleccionPersonaje == 2){
			ChunLi jp = new ChunLi("ChunLi");
			System.out.println("Elejiste a Chun Li!");
			return jp;
		}
		else{
			System.out.println("Personaje no encontrado, elige una opción correcta");
			elejirPersonajes();
			return null;
		}
	}

	// funcion para ejecutar el menu de ataques
	public static void ejecutarAtaques(Personaje atacante,Personaje defensor, int tipoAtaque){ // 1 == patada ----- 2 == punio
		if (tipoAtaque == 1){
			float danioProducido = atacante.ejecutarPatada(atacante.getDanioBase(), atacante.getFuerza());
			float dañoReal = defensor.getDefensa()*danioProducido;
			if (defensor.getVida() < dañoReal){
				defensor.setVida(0);
			}
			else{
				defensor.setVida(defensor.getVida()-dañoReal);
			}			
		}
		else if(tipoAtaque == 2){
			float danioProducido = atacante.ejecutarPunio(atacante.getDanioBase(), atacante.getFuerza());
			float dañoReal = defensor.getDefensa()*danioProducido;
			if (defensor.getVida() < dañoReal){
				defensor.setVida(0);
			}
			else{
				defensor.setVida(defensor.getVida()-dañoReal);
			}
		}
	}

	public static void verificarGanador(Personaje jp1, Personaje jp2){
		System.out.println("Turno del jugador dos. \n"+jp1.getNombrePersonaje()+" "+jp1.getVida()+" PS --------"+jp2.getNombrePersonaje()+" "+jp2.getVida()+ "\n");
		if(jp1.getVida() < 1){
			System.out.println("El jugador dos es el ganador. Felicidades "+jp2.getNombrePersonaje());
		}
		else{
			System.out.println("El jugador uno es el ganador. Felicidades "+jp1.getNombrePersonaje());
		}
	} 
    public static void main(String[] args) {
		
		System.out.println("¡Bienvenido al juego! Presiona 1 para empezar la partida");
		Scanner scanner = new Scanner(System.in);
		int jugar = scanner.nextInt();
		
		List<Personaje> datosPersonaje = new ArrayList<>(); // Lista con los datos de todos los personajes del programa

		datosPersonaje.add(new Ryu("Ryu")); // Aqui instanciamos un personaje para mostrar sus datos
		datosPersonaje.add(new ChunLi("Chun LI"));
		datosPersonaje.add(new Ryu("Ryden"));
		
		int iteracionFor = 0;
		int iteracionWhile = 0;
		Personaje jp1 = null;
		Personaje jp2 = null;
		while (jugar == 1){
			
			if (iteracionFor < 2){
				System.out.println("Aquí tienes todos nuestros personajes");
				int contador = 0;
				for (Personaje personaje : datosPersonaje) {
					contador += 1;
					System.out.println("-------------------- " + contador + " ------------------");
					System.out.println("Nombre: " + personaje.getNombrePersonaje());
					System.out.println("Vida: " + personaje.getVida());
					System.out.println("Fuerza: " + personaje.getFuerza());
					System.out.println("Defensa: " + personaje.getDefensa());

					System.out.println("----------------------------------------");
					System.out.println();
					System.out.println("iteración: "+iteracionFor);
					iteracionFor += 1;
				}
				// Jugardor 1 
				System.out.println("Digita el numero del personaje que desea elegir el primer jugador");	
				jp1 = elejirPersonajes();
				System.out.println("\n");
				
				// Jugardor 2
				System.out.println("Digita el numero del personaje que desea elegir el segundo jugador");
				jp2 = elejirPersonajes();
				System.out.println("\n");
				
				System.out.println("Iniciemos el juego");
				System.out.println("Recuerda que el daño de cada ataque puede variar segun la defensa de tu enemgio, puede subir o bajar.\n");

				System.out.println(jp1.getNombrePersonaje() + " Vs. "+jp2.getNombrePersonaje()+"n");


			}

			if (jp1.getVida() > 0 && jp2.getVida() > 0){
				if (iteracionWhile%2 == 0){
					System.out.println("Turno del jugador uno. \n"+jp1.getNombrePersonaje()+" "+jp1.getVida()+" PS -------- "+jp2.getNombrePersonaje()+" "+jp2.getVida()+ "\n");
					System.out.println("Presiona 1 para ejecutar patada\nPresiona 2 para ejecutar un puño");
					int tipoAtaque = scanner.nextInt();
					ejecutarAtaques(jp1, jp2, tipoAtaque);
					
				}
				else if(iteracionWhile%2 != 0){
					System.out.println("Turno del jugador dos. \n"+jp1.getNombrePersonaje()+" "+jp1.getVida()+" PS --------"+jp2.getNombrePersonaje()+" "+jp2.getVida()+ "\n");
					System.out.println("Presiona 1 para ejecutar patada\nPresiona 2 para ejecutar un puño");
					int tipoAtaque = scanner.nextInt();
					ejecutarAtaques(jp2, jp1, tipoAtaque);
				}
			}
			iteracionWhile +=1;
			if (jp1.getVida() < 1 || jp2.getVida() < 1){
				verificarGanador(jp1, jp2);
				System.out.println("\nDigita uno para jugar otra partida o presiona dos para salir");
				jugar = scanner.nextInt();
				if (jugar == 1){
					jp1 = null;
					jp2 = null;
					iteracionWhile = 0;
					iteracionFor = 0;
				}
				else{
					iteracionWhile = 1;
				}
			}
		}
		scanner.close();
	}
   
}