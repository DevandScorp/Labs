package Lab_9.v_5;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws InterruptedException {
        try (ServerSocket server= new ServerSocket(3345)){
            while(true){
                Socket client = server.accept();
                new Thread(()->{
                    try {
                    DataOutputStream out = new DataOutputStream(client.getOutputStream());
                    DataInputStream in = new DataInputStream(client.getInputStream());
                    out.writeUTF("Our menu:\n" +
                            "\t\t1.Beef steak\n\t\t2.Pancake\n\t\t3.Borsch\n\t\t4.Bouillon\n\t\t5.Open sandwich\n\t\t6.Curd\n\t\t7.Beetroot salad\n\t\t8.Hamburger\n");
                    String entry = in.readUTF();
                    System.out.println("Delivery info: " + entry);

                    out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}