import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Como no especifica como pasarle el texto al hilo, lo pido por teclado.
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase: ");
        String frase = sc.nextLine();
        sc.close();

        // Tienen que tener todos el mismo contador(monitor).
        Contador c = new Contador();

        HiloContadorVocales h1 = new HiloContadorVocales(frase, 'a', c);
        HiloContadorVocales h2 = new HiloContadorVocales(frase, 'e', c);
        HiloContadorVocales h3 = new HiloContadorVocales(frase, 'i', c);
        HiloContadorVocales h4 = new HiloContadorVocales(frase, 'o', c);
        HiloContadorVocales h5 = new HiloContadorVocales(frase, 'u', c);

        // Inicializo los hilos.
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();

        // Bloquea hasta que el Thread se complete.
        // Hacemos el join para que el main no termine antes que los hilos.
        // Y metemos cada join en un try-catch por separado para que si falla uno, no se
        // pare el resto.
        try {
            h1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            h2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            h3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            h4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            h5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("El número de vocales es: " + c.getTotal());
    }
}