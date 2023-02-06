public class Contador {

    private int total;

    public Contador() { }

    public int getTotal() {
        return total;
    }

    public synchronized void incrementar() {
        total++;
    }

}
