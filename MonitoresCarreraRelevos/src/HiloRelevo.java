import java.util.Random;

public class HiloRelevo extends Thread {

    private Testigo testigo;

    public HiloRelevo(Testigo testigo) {
        this.testigo = testigo;
    }

    @Override
    public void run() {
        System.out.println("Hilo " + getName() + " esperando a la salida");
        synchronized (testigo) {

            try {
                System.out.println("Hilo " + getName() + " wait()");
                testigo.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(new Random().nextInt(1000 * 2));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Hilo " + getName() + " finalizado, pasa el testigo");
            testigo.notify();
        }
    }
}