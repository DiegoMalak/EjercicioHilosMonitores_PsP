public class Monitor {

    private Puente puente;
    private int barcasEsperando = 0;

    public Monitor(Puente p) {
        this.puente = p;
    }

    public Puente getPuente() {
        return puente;
    }

    public void cruzarPuenteCoche() {
        synchronized (puente) {
            if (puente.isLibre() && barcasEsperando == 0) {
                // paso yo y notificamos a todos los demas
                puente.setLibre(false);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                puente.setLibre(true);
                notify();
            }
            else{
                try {

                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void cruzarPuenteBarca() {
        // si soy coche, y puente vacio y barcas no esperando, paso
        // sino espero.

        synchronized (puente) {
            if (puente.isLibre()) {
                // paso yo y notificamos a todos los demas
                puente.setLibre(false);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                puente.setLibre(true);
                notify();
            }
            else{
                try {
                    barcasEsperando++;
                    wait();
                    barcasEsperando--;
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        // si soy barca, si puente vacio, paso.
        // sino espero.
    }
}
