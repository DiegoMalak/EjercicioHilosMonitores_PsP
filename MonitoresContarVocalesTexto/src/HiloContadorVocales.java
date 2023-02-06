import java.util.Random;

public class HiloContadorVocales extends Thread {

    private String texto;
    private char vocal;
    private Contador contador;

    public HiloContadorVocales(String texto, char vocal, Contador contador) {
        super("Hilo " + vocal);
        this.texto = texto;
        this.vocal = vocal;
        this.contador = contador;
    }

    @Override
    public void run() {
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            try {
                // simular lo que tarda una persona en comprobar si la letra es igual
                Thread.sleep(new Random().nextInt(100 + 1));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (caracter == vocal) {
                System.out.println(getName() + " ha encontrado una "
                        + vocal + " en la posición "
                        + i + " y llama a incrementar");
                contador.incrementar();
            }
        }
    }

}
