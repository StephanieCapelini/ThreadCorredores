package controller;

import java.util.concurrent.Semaphore;

public class Corredores extends Thread {
	int idThread;
	Semaphore semaforo;
	int percorre;
	
	public Corredores(int idThread, Semaphore semaforo) {
		this.idThread= idThread;
		this.semaforo= semaforo;
	}
	@Override
	public void run() {
		caminhar();
		porta ();
	}
	private void caminhar() {
		while(percorre<=200) {
			int andar=(int)(Math.random()*3)+ 4;
			percorre += andar;
			System.out.println("pessoa #"+ idThread+ " andou "+ andar + " metros ... total= "+ percorre);
		}
	}
	private void porta() {
		try {
			semaforo.acquire();
			System.out.println("pessoa #"+ idThread+ " chegou na porta");
			int tempo= (int)(Math.random()*2)+1;
			sleep(tempo);
			System.out.println("pessoa #"+ idThread+ " passou pela porta");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			semaforo.release();
		}
	}
}
