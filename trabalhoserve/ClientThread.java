package multi_client_thread;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

class ClientThread implements Runnable {
    private Socket clientSocket;

    public ClientThread(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        int questoes=0;
        int pontuacao=0;
        int firstinput=0;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String inputLine;
            String[] gab = new String[5];
            gab[0]="A";
            gab[1]="B";
            gab[2]="C";
            gab[3]="B";
            gab[4]="D";
            while(questoes <= 5){
            if ((inputLine = in.readLine()) != null) {
                if (firstinput!=1) {
                    firstinput=1;
                }else{
                    if(gab[questoes].toString().equals(inputLine)){
                        pontuacao++;
                    }
                    questoes++;
                }
                System.out.println("Mensagem recebida do cliente: " + inputLine);
                switch (questoes) {
                    case 0:
                    out.println("Quanto e 1+1 ;A)2 B)1 C)3 D)4");
                    
                        break;
                    case 1:
                    out.println("Quanto e 1-1 ;A)2 B)0 C)3 D)4");

                        break;
                    case 2:
                    out.println("Quanto e 2*1 ;A)10 B)0 C)2 D)4");

                        break;
                    case 3:
                    out.println("Quanto e 2*2 ;A)10 B)4 C)2 D)4");

                        break;
                    case 4:
                    out.println("Quanto e 2/2 ;A)10 B)4 C)2 D)1");
  
                        break;
                    case 5:
                    out.println("Potuacao do cliente: " + pontuacao);
                         break;
                    default:
                        break;
                }
                
            }

        }
        } catch (IOException e) {
            System.out.println("Erro ao lidar com o cliente: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Erro ao fechar o socket do cliente: " + e.getMessage());
            }
        }

    }
}
