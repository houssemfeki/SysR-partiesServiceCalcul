package PackageClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        try {
        	
            InetAddress adresseServeur = InetAddress.getByName("127.0.0.1");
            Socket s = new Socket(adresseServeur, 1234);
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            // Le client est demandé de taper un entier X au clavier
            System.out.println("Donner un nombre : ");
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            System.out.println("1.+ | 2.- | 3.* | 4./ ");
            int choixOperation = scanner.nextInt();
            // Envoie des données au serveur sous forme de chaînes
            out.println(choixOperation);
            out.println(x);
            // Réception et affichage du résultat du serveur
            int res = Integer.parseInt(in.readLine());
            System.out.println("Résultat de l'opération : " + res);
            // Fermeture des flux et de la connexion
            out.close();
            in.close();
            s.close();
            // Fermeture du scanner
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
