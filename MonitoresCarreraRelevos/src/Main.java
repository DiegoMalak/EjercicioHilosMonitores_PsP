public class Main {
    public static void main(String[] args) {
        Relevos relevos = new Relevos();
        for (Thread thread : relevos.correderos) {
            thread.start();
        }
        synchronized (relevos.lock) {
            relevos.lock.notifyAll();
        }
    }
}


