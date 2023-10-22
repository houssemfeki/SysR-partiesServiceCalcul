package PackageServeur;

import java.io.*;
import java.net.*;
public class Serveur {
	
    public static void main(String[] args) {
        try {
            InetAddress adresseServeur = InetAddress.getByName("127.0.0.1");
            ServerSocket ss = new ServerSocket();
            ss.bind(new InetSocketAddress(adresseServeur, 1234));
            System.out.println("Je suis un serveur en attente la connexion d'un client ");
            while (true) {
                Socket clientSocket = ss.accept();
                System.out.println("Un client connecté ");
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                // Lecture du choix de l'opération du client
                int choixOperation = Integer.parseInt(in.readLine());
                int x = Integer.parseInt(in.readLine());		
                int res = 0;
                switch (choixOperation) {
                    case 1:
                        res = x + 5; 
                        break;
                    case 2:
                        res = x - 5; 
                        break;
                    case 3:
                        res = x * 5; 
                        break;
                    case 4:
                        res = x / 5; 
                        break;
                    default:
                        // cas du choix non valide
                }

                // Envoi du résultat au client
                out.println(res);
                // Fermeture des flux et de la connexion
                clientSocket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
