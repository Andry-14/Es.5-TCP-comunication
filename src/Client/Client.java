package Client;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

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
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            Scanner input = new Scanner(System.in);
            String t2 = input.nextLine();
            printWriter.println((t2));


        } catch (IOException e) {

        }
    }

    public String leggi(){
        String t = "";
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            t = br.readLine();
            System.out.println("SERVER: "+ t);
        } catch (SocketException e){
            System.err.println("System is closed");
        }
        catch (IOException e) {

        }
        return t;
    }

    public void chiudi(){
        try {
            socket.close();
            System.out.println("Il client si è disconesso");
        } catch (IOException e) {

        }
    }
}
