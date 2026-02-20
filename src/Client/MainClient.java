package Client;

public class MainClient {
    public static void main(String[] args) {
       Client client = new Client("Andrea");
       client.connetti("localhost",3000);
        String m ="";

        while(true){

            client.scrivi();
            m = client.leggi();

            if (m.equalsIgnoreCase("FINE")){
                System.out.println("il client si sta disconnetendo");
                break;
            }

        }
        client.chiudi();


        }
}
