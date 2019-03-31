package com.requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rep;
        do {
            System.out.println("Quel requête souhaitez vous faire ?\n1 - GET\n2 - POST\n\nAppuyez sur une autre touche pour quitter");
            rep = Integer.parseInt(sc.nextLine());
            switch (rep) {
                case 1:
                    System.out.println("Entrez l'URL sur laquelle vous souhaitez faire une requête GET :");
                    String get = sc.nextLine();
                    System.out.println("Voici la réponse :");
                    try {
                        System.out.println(Request.get(get));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    List<String> cles = new ArrayList<String>();
                    List<String> valeurs = new ArrayList<String>();
                    System.out.println("Entrez l'URL sur laquelle vous souhaitez faire une requête POST :");
                    String post = sc.nextLine();
                    System.out.println("Combien de clés possède la requête ?");
                    int nb_cles = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < nb_cles; i++) {
                        System.out.print("Clé = ");
                        cles.add(sc.nextLine());
                        System.out.print("Valeur = ");
                        valeurs.add(sc.nextLine());
                        System.out.println();
                    }
                    System.out.println("Voici la réponse :");
                    try {
                        System.out.println(Request.post(post, cles, valeurs));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        } while (rep == 1 || rep == 2);
    }
}
