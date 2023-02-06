public class Puente {

    private int coordenadaX;
    private boolean libre;

    public Puente(int coordenadaX) {
        this.coordenadaX = coordenadaX;
        this.libre = true;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }
}
