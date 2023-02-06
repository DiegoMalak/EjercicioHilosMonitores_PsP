public class Main {
    public static void main(String[] args) {
        new Main().ejercicio();
    }

    public void ejercicio() {
        Testigo testigo = new Testigo();
        HiloRelevo hilo1 = new HiloRelevo(testigo);
        HiloRelevo hilo2 = new HiloRelevo(testigo);
        HiloRelevo hilo3 = new HiloRelevo(testigo);
        HiloRelevo hilo4 = new HiloRelevo(testigo);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();

        try {
            hilo1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            hilo2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            hilo3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            hilo4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Relevos finalizado");
    }
}