package multi_client_thread;
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 5001;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor iniciado na porta " + port + ".");

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Novo cliente conectado: " + clientSocket.getInetAddress().getHostAddress());
                    Thread thread = new Thread(new ClientThread(clientSocket));
                    thread.start();
                } catch (IOException e) {
                    System.out.println("Erro ao aceitar a conexão do cliente: " + e.getMessage());
                }
            }
            // serverSocket.close(); // O servidor nunca alcança este ponto devido ao loop infinito
        }
    }
}

