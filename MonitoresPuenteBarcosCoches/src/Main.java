public class Main {
    public static void main(String[] args) {
        Puente p = new Puente(50);
        Monitor m = new Monitor(p);

        new Barca(200, m).start();
        new Coche(125, m).start();
        new Barca(300, m).start();
        new Coche(200, m).start();
        new Coche(100, m).start();
        new Coche(150, m).start();
        new Barca(200, m).start();
        new Barca(100, m).start();
        new Barca(300, m).start();
        new Barca(400, m).start();
    }
}