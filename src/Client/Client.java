package Client;

import java.io.IOException;
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
}
