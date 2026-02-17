package Client;

import java.io.*;
import java.net.Socket;

public class Client {
    private String nome;
    private String colore;
    private Socket socket;

    public Client(String nome, String colore) {
        this.nome = nome;
        this.colore = colore;

    }

    public Client(String nome){
        this.nome = nome;

    }

    public int connetti (String nomeServer, int portaServer){
        try {
            socket = new Socket(nomeServer, portaServer);
            System.out.println("Client " + nome + ": il client è connesso");
            return 1;
        } catch (IOException e) {
            System.err.println("errore cliente");
        }
        return 1;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void scrivi(){
        try {
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.println("CIAO");
            printWriter.flush();

        } catch (IOException e) {

        }
    }

    public void leggi(){
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String testo = br.readLine();
            System.out.println("SERVER: "+ testo);
        } catch (IOException e) {

        }
    }

    public void chiudi(){
        try {
            socket.close();
            System.out.println("Il client si è disconesso");
        } catch (IOException e) {

        }
    }
}
