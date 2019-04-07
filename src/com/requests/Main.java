package com.requests;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CloudifyRequest cr = new CloudifyRequest("http://localhost:3000");
        Map<String, String> mp = new HashMap<>();
        int rep;
        do {

            System.out.println("Quel requête souhaitez vous faire ?\n1 - GET\n2 - POST\n3 - PUT\n\nAppuyez sur une autre touche pour quitter");
            rep = Integer.parseInt(sc.nextLine());
            switch (rep) {
                case 1:
                    //System.out.println("Entrez l'URL sur laquelle vous souhaitez faire une requête GET :");
                    //String get = sc.nextLine();
                    System.out.println("Voici la réponse :");
                    try {
                        System.out.println(cr.get("/user", "", mp));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Voici la réponse :");
                    try {
                        System.out.println(cr.post("/user", "{\"email\":\"test2De@LAppli.Java\",\"password\":\"regardezjojo\"}", mp));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Voici la réponse :");
                    try {
                        System.out.println(cr.put("/user", "{\"email\":\"test3De@LAppli.Java\",\"password\":\"vivekonosuba\"}", mp));
                    }
                    catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        } while (rep == 1 || rep == 2 || rep == 3);
    }
}
