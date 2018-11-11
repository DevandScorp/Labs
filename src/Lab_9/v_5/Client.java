package Lab_9.v_5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable{
    private Socket clientSocket;

    public Client(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try(BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream oos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream ois = new DataInputStream(clientSocket.getInputStream()))
        {
            System.out.println("User attended delivery server.");
            System.out.println(ois.readUTF());
            System.out.println("Write your dishes numbers and delivery address");
            String clientCommand = br.readLine();
            oos.writeUTF(clientCommand);
            oos.flush();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        new Thread(new Client(new Socket("localhost",3345))).start();
    }


}
