import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientWorkerThread extends Thread {

    private int port;
    private int clientNum;

    public ClientWorkerThread(int port, int clientNum) {
        this.port = port;
        this.clientNum = clientNum;
    }

    // Simple TCP Client, sends and receives a string
    @Override
    public void run() {
        Socket socket = null;
        try {

            socket = new Socket(InetAddress.getByName("127.0.0.1"), port);

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            byte[] receiveBuffer = new byte[1024];
            int numberOfReadChars = input.read(receiveBuffer);

            String receivedMessage = new String(receiveBuffer, 0, numberOfReadChars);
            System.out.println(receivedMessage);

            Thread.sleep( clientNum * 1000); // wait for demonstration purposes
            output.write(("Hello server! I am client " + clientNum).getBytes());
            output.flush();

            socket.close();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
