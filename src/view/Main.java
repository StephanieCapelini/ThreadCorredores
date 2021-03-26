package view;

import java.util.concurrent.Semaphore;

import controller.Corredores;

public class Main {

	public static void main(String[] args) {
		
		Semaphore semaforo= new Semaphore(1);
		for(int idThread= 1; idThread<5; idThread++) {
			Corredores c= new Corredores(idThread, semaforo);
			c.start();
		}
				
	}

}
