import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerSingle {

    public static void main(String[] args) throws IOException {
        new TCPServerSingle();
    }

    // Single threaded server
    public TCPServerSingle() throws IOException {

        ServerSocket serverSocket = new ServerSocket(4000);
        while (true) {

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

            socket.close();
        }

    }
}
