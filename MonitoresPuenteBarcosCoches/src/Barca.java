import java.util.Random;

public class Barca extends Thread {

    private Monitor m;

    private int coordenadaX;

    public Barca(int coordenadaX, Monitor m) {
        this.coordenadaX = coordenadaX;
        this.m = m;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    @Override
    public void run() {
        while (this.getCoordenadaX() > this.m.getPuente().getCoordenadaX()) {
            try {
                Thread.sleep(new Random((int) (Math.random() * 30)).nextInt());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            this.coordenadaX -= 1;
        }

        // he llegado al puente, pido paso al controlador (monitor)
        m.cruzarPuenteBarca();

        while (this.getCoordenadaX() > 0) {
            try {
                Thread.sleep(new Random((int) (Math.random() * 30)).nextInt());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            this.coordenadaX -= 1;
        }
    }

}
