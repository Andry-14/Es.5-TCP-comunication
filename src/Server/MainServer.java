package Server;


public class MainServer {
    public static void main(String[] args) {
     Server server = new Server(3000);
     server.attendi();
     String msg ="";

     while(true){
         msg = server.leggi();

         if (msg.equalsIgnoreCase("END")) {
             server.scrivi();
             break;
         }

         String s = server.scrivi();

         if (s.equalsIgnoreCase("END")){
             break;
         }


     }

     server.termina();

    }
}