package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private int porta;

    public Server(int porta) {
        this.porta = porta;
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Il server è in ascolto");
        } catch (IOException e) {
            System.err.println("errore");
        }
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public Socket attendi() {
        try {
            clientSocket = serverSocket.accept();
            System.out.println("Il server ha accettato la richiesta");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            return clientSocket;
        }

    }


    public void termina(){
        try {
            System.out.println("server disconnesso");
            serverSocket.close();
        } catch (IOException e) {

        }
    }

    public String leggi(){
        String testo = "";
        try {
            InputStream inputStream = clientSocket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            testo = br.readLine();
            System.out.println("CLIENT: "+ testo);
        } catch (IOException e) {

        }
        return testo;
    }

    public String scrivi(){
        String t= "";
        try {
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true);
            Scanner input = new Scanner(System.in);
            t = input.nextLine();
            printWriter.println(t);



        } catch (IOException e) {

        }
        return t;
    }
}