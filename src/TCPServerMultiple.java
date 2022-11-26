import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServerMultiple {

    public static void main(String[] args) throws IOException {
        new TCPServerMultiple();
    }

    // Create multiple servers
    public TCPServerMultiple() throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        ServerSocket serverSocket = new ServerSocket(4000);
        for (int i = 0; i < 8; i++) {
            ServerWorkerThread thread = new ServerWorkerThread(serverSocket);
            executorService.submit(thread);
        }
        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

    }
}
