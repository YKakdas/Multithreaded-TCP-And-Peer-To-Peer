import java.io.IOException;
import java.net.ServerSocket;

public class PeerToPeer {

    // First arg is server port, second is client port
    public static void main(String[] args) throws IOException, InterruptedException {
        new PeerToPeer(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
    }

    public PeerToPeer(int serverPort, int clientPort) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(serverPort);

        Thread server = new ServerWorkerThread(serverSocket); // create server thread for p2p
        Thread client = new ClientWorkerThread(clientPort,0); // create client thread for p2p

        server.start();
        // wait 6 seconds to give some time to run the second p2p, otherwise it will throw an error if the other
        // p2p instance's server is not running already. Or, simply if server port and client port is entered
        // same from the args, single instance of this class can be used for server-client.
        Thread.sleep(6000);
        client.start();

        server.join(); // wait server thread to end
        client.join(); // wait client thread to end

    }
}
