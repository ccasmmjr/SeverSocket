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
            String[] gab = new String[15];
            gab[0]="A";
            gab[1]="B";
            gab[2]="C";
            gab[3]="B";
            gab[4]="D";
            gab[5]="D";
            gab[6]="A";
            gab[7]="A";
            gab[8]="C";
            gab[9]="B";
            gab[10]="A";
            gab[11]="D";
            gab[12]="B";
            gab[13]="B";
            gab[14]="D";
            while(questoes <= 15){
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
                    out.println("Qual o menor país do mundo ;A)Mônaco B)Vaticano C)San Marino D)Malta");

                        break;
                    case 2:
                    out.println("Em qual local da Ásia o português é língua oficial ;A)Índia B)Moçambique C)Macau D)Filipinas");

                        break;
                    case 3:
                    out.println("Quantos digitos tem o número PI ;A)Dezenas B)Infinitos C)Centenas D)Milhares");

                        break;
                    case 4:
                    out.println("Quem pintou o teto da Capela Sistina ;A)Da Vinci B)Donatello C)Botticelli D)Michelangelo");
  
                        break;
                    case 5:
                    out.println("Qual a capital do Canadá; A) Vancouver B) Toronto C) Montreal D) Ottawa");
                        
                         break;
                    case 6:
                    out.println("Por quantos anos Fidel Castro governou; A) 49 B) 32 C) 55 D) 46");
                        
                         break;
                    case 7:
                    out.println("Em que continente fica localizado o país Quirguistão; A) Ásia B) África C) Oceania D) Europa");
                        
                         break;
                     case 8:
                    out.println("Quem ganhou a copa do mundo de futebol em 94; A) Itália B) Alemanha C) Brasil D) Argentina");
                        
                         break;
                     case 9:
                    out.println("De qual franquia é o personagem Link; A) Resident Evil B) Zelda C) Sonic D) Mario");
                        
                         break;
                     case 10:
                    out.println("Qual dessas marcas de carro é alemã; A) AUDI B) FIAT C) CITROEN D) CHEVROLET");
                        
                         break;
                     case 11:
                    out.println("Qual a capital da República Tcheca; A) Londres B) Belgrado C) Bruxelas D) Praga");
                        
                         break;
                     case 12:
                    out.println("Em que ano acabou a segunda guerra mundial; A) 1918 B) 1945 C) 1994 D) 1967");
                        
                         break;

                         case 13:
                    out.println("Quem é o atual ditador da Coréia do Norte; A) Xi Jinping B) Kim Jong-un C) Kim Jong-il D) Qin Shihuang ");
                        
                         break;
                         case 14:
                    out.println("Quem criou a fórmula da gravidade; A) Einstein B) Tesla C) Oppenheimer D) Newton");
                        
                         break;
                         case 15:
                    out.println("Pontuação do cliente:" + pontuacao);
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
