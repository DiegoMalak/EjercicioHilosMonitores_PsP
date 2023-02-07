import java.util.Random;

/**
 * 1. Escribe una clase llamada Relevos que simule una carrera de relevos de la siguiente
 * forma:
 * ▪ Cree 4 threads, que se quedarán a la espera de recibir alguna señal para comenzar a
 * correr.
 * ▪ Una vez creados los threads, se indicará que comience la carrera, con lo que uno de
 * los threads deberá empezar a correr.
 * ▪ Cuando un thread termina de correr, pone algún mensaje en pantalla y espera un par
 * de segundos, pasando el testigo a otro de los hilos para que comience a correr, y
 * terminando su ejecución (la suya propia).
 * ▪ Cuando el último thread termine de correr, el padre mostrará un mensaje indicando
 * que todos los hijos han terminado.
 */
public class Relevos extends Thread {
    Thread[] correderos = new Thread[4];
    final int [] turno = {1};
    final Object lock = new Object();

    public Relevos() {
        for (int i = 0; i < correderos.length; i++) {
            int corredor = i;
            correderos[i] = new Thread(() -> {
                synchronized (lock) {
                    try {
                        while (turno[0] != corredor + 1) {
                            lock.wait();
                        }
                        System.out.println("Runner " + (corredor + 1) + " comenzó a correr.");
                        Thread.sleep(2000);
                        System.out.println("Runner " + (corredor + 1) + " terminó de correr.");
                        turno[0]++;
                        lock.notifyAll();
                        if (corredor == 3) {
                            System.out.println("Todos los corredores han terminado.");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}