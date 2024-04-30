package multi_client_thread;
import java.io.*;
import java.net.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {

    
    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int portNumber = 5001;
      


        JFrame frame = new JFrame("Minha Interface Gráfica");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criando área de texto
        // Criando uma JTextArea
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(10, 10, 380, 280);

        frame.add(scrollPane);

        JTextArea Alternativa = new JTextArea();
        Alternativa.setLineWrap(true);
        Alternativa.setWrapStyleWord(true);
        Alternativa.setEditable(false);

        JScrollPane scrollPanel = new JScrollPane(Alternativa);
        scrollPanel.setBounds(480, 10, 280, 280);

        frame.add(scrollPanel);
        // Criando um botão
        JButton buttonA = new JButton("A");
        buttonA.setBounds(10, 300, 150, 30);
        frame.add(buttonA);
        JButton buttonB = new JButton("B");
        buttonB.setBounds(170, 300, 150, 30);
        frame.add(buttonB);
        JButton buttonC = new JButton("C");
        buttonC.setBounds(10, 350, 150, 30);
        frame.add(buttonC);
        JButton buttonD = new JButton("D");
        buttonD.setBounds(170, 350, 150, 30);
        frame.add(buttonD);
        // Exibindo o frame
        frame.setLayout(null);
        frame.setVisible(true);
        

        try (Socket echoSocket = new Socket(hostName, portNumber);
             PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Conectado ao servidor. Digite suas mensagens:");

 // Adicionando um ouvinte de eventos ao botão
            buttonA.addActionListener(e->{
                try {
                    out.println("A");
                    String resultado = in.readLine();
                    String[] partes= resultado.split(";");
                    textArea.setText(partes[0].toString()); 
                    Alternativa.setText(partes[1].toString()); 
                } catch (Exception o) {
                    // TODO: handle exception
                    o.printStackTrace();
                }
              
                
                });

                buttonB.addActionListener(e->{
                    try {
                        out.println("B");
                        String resultado = in.readLine();
                        String[] partes= resultado.split(";");
                        textArea.setText(partes[0].toString()); 
                        Alternativa.setText(partes[1].toString()); 
                    } catch (Exception o) {
                        // TODO: handle exception
                        o.printStackTrace();
                    }
                  
                    });
                    buttonC.addActionListener(e->{
                        try {
                            out.println("C");
                            String resultado = in.readLine();
                            String[] partes= resultado.split(";");
                            textArea.setText(partes[0].toString()); 
                            Alternativa.setText(partes[1].toString()); 
                        } catch (Exception o) {
                            // TODO: handle exception
                            o.printStackTrace();
                        }
                      
                        });
                        buttonD.addActionListener(e->{
                            try {
                                out.println("D");
                                String resultado = in.readLine();
                                String[] partes= resultado.split(";");
                                textArea.setText(partes[0].toString()); 
                                Alternativa.setText(partes[1].toString()); 
                            } catch (Exception o) {
                                // TODO: handle exception
                                o.printStackTrace();
                            }
                          
                            });

       
        while (true) {
            /* 
            loop para grantir que o progrma nao 
            feche fora da hora como ocorria antes 
            */
         }

        } catch (UnknownHostException e) {
            System.err.println("Host desconhecido: " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Não foi possível obter E/S para a conexão com " +
                    hostName);
            System.exit(1);
        }
    }
    
}
