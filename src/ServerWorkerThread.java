import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWorkerThread extends Thread {

    private ServerSocket serverSocket;

    public ServerWorkerThread(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    // Simple TCP Server, sends and receives a string
    @Override
    public void run() {
        try {

            DataInputStream input;
            DataOutputStream output;

            Socket socket = serverSocket.accept();

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());

            String msg = "Hello client";

            output.write(msg.getBytes());
            output.flush();

            byte[] receiveBuffer = new byte[1024];
            int numberOfReadChars = input.read(receiveBuffer);
            String receivedMessage = new String(receiveBuffer, 0, numberOfReadChars);
            System.out.println(receivedMessage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
