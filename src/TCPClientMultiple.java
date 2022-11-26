import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPClientMultiple {

    public static void main(String[] args) throws IOException, InterruptedException {
        new TCPClientMultiple();
    }

    // Create multiple clients
    public TCPClientMultiple() {
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        for (int i = 0; i < 8; i++) {
            ClientWorkerThread thread = new ClientWorkerThread(4000, i);
            executorService.submit(thread);
        }
        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

    }
}
