package Utilisateur;

import Erreurs.ErrSommeTx;
import Erreurs.ErrTx;
import Erreurs.ErrValNeg;
import consoCarbonne.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.lang.*;


public class EntreeSortie{
    private static Scanner scan = new Scanner(System.in);

    //Constructeur par défaut
    public EntreeSortie(){}


    public static void printMenu() {
        System.out.println("--------------");
        System.out.println("Voici le Menu");
        System.out.println("--------------");
        System.out.println("Tapez 0 pour sortir du menu.");
        System.out.println("Tapez 1 pour initialiser un utilisateur à partir d'un fichier texte.");
        System.out.println("Tapez 2 pour initialiser un utilisateur manuellement (en répondant à une suite de questions).");
    }

    public Utilisateur AffichageUtilisateur() throws ErrTx, ErrValNeg {
        System.out.println("Appel de la fonction 1");
        Utilisateur u = new Utilisateur();
        boolean fin = false;
        do {
            printMenu();
            //System.out.println("Appel de la fonction 2");
            int choixUtiliateur = scan.nextInt();
            scan.nextLine();
            //System.out.println("Appel de la fonction 3");
            switch (choixUtiliateur) {
                case (0):
                    fin = true;
                    break;
                case (1):
                    System.out.println("Entrez le nom du fichier  :");
                    String nom_fichier = scan.nextLine();
                    u = new Utilisateur(nom_fichier);
                    fin = true;
                    break;

                case (2):
                    u = new Utilisateur(0);
                    fin = true;

                    break;
                default:
                    System.out.println("Cette valeur ne fait pas partie des possibilités.");
            }
        } while (!fin);
        return (u);
    }


    protected Utilisateur initialisation_fichier(String nom_fichier) throws ErrTx, ErrValNeg {
        Utilisateur u = new Utilisateur();


            JSONParser jsonParser = new JSONParser();


        try {
                FileReader reader = new FileReader(nom_fichier);
                //Lecture du fichier JSON :
                Object obj = jsonParser.parse(reader);

                JSONObject objet = (JSONObject) obj;
                JSONObject utilisateurObject = (JSONObject) objet.get("Utilisateur");

                Alimentation alimentation = lecture_fichier_alimentation(utilisateurObject);
                BienConso bienConso = lecture_fichier_bienConso(utilisateurObject);
                Collection<Logement> liste_logement = lecture_fichier_listeLogement(utilisateurObject);
                Collection<Voiture> liste_voiture = lecture_fichier_listeVoiture(utilisateurObject);
                Collection <Avion> liste_avion = lecture_fichier_listeAvion(utilisateurObject);
                Collection <Bus> liste_Bus = lecture_fichier_listeBus(utilisateurObject);
                Collection <TGV> liste_tgv = lecture_fichier_listeTgv(utilisateurObject);
                ServicesPublic s = ServicesPublic.getInstance();

                u = new Utilisateur(alimentation, bienConso, liste_logement, liste_voiture, liste_avion, liste_Bus, liste_tgv,s);



            } catch (FileNotFoundException e) {
                System.err.println("Erreur : fichier non trouvé.");
                System.exit(1);
            } catch (IOException e) {
                System.err.println("Erreur : IOException.");
                System.exit(1);
                //e.printStackTrace();
            } catch (ParseException e) {
                System.err.println("Erreur dans l'utilisation du Parse");
                //System.exit(1);
                e.printStackTrace();
            } catch (ErrTx e) {
                throw new RuntimeException(e);
            } catch (ErrValNeg e) {
                throw new RuntimeException(e);
            } catch (ErrSommeTx e) {
            throw new RuntimeException(e);
        }
        //scan.close();
        return u;
    }




    private Alimentation lecture_fichier_alimentation(JSONObject utilisateurObject) throws ErrTx, ErrSommeTx {
        JSONObject alimentationObject = (JSONObject) utilisateurObject.get("alimentation");
        double txBoeuf = (double) alimentationObject.get("txBoeuf");
        double txVege = (double) alimentationObject.get("txVege");
        Alimentation alimentation = new Alimentation(txBoeuf, txVege);
        return (alimentation);
    }

    private BienConso lecture_fichier_bienConso(JSONObject utilisateurObject) throws ErrValNeg {
        JSONObject bienConsoObject = (JSONObject) utilisateurObject.get("bienconso");
        double montant = (double) bienConsoObject.get("montant");
        System.out.println("montant : " + montant);
        BienConso bienConso = new BienConso(montant);
        //BienConso bienConso = new BienConso(montant);
        return (bienConso);
    }

    private Collection <Logement> lecture_fichier_listeLogement(JSONObject utilisateurObject) throws ErrValNeg {
        JSONArray listelogmentArray = (JSONArray) utilisateurObject.get("listelogement");
        Collection<Logement> liste_logement = new ArrayList<>();
        //Collection <Logement> liste_logement = Collection;
        for (int i = 0; i < listelogmentArray.size() ; i++) {
            JSONObject t = (JSONObject) listelogmentArray.get(i);
            long superficie = (Long) t.get("superficie");
            String classe = (String) t.get("classe");
            Logement logement = new Logement((int) superficie, CE.StringToCE(classe));
            liste_logement.add(logement);
        }
        return (liste_logement);
    }


    private Collection<Voiture> lecture_fichier_listeVoiture(JSONObject utilisateurObject) throws ErrValNeg {
        JSONArray listevoitureArray = (JSONArray) utilisateurObject.get("listeVoiture");
        Collection<Voiture> liste_voiture = new ArrayList<>();
        for (int i = 0; i < listevoitureArray.size() ; i++) {
            JSONObject v = (JSONObject) listevoitureArray.get(i);
            String taille = (String) v.get("taille");
            Boolean possede = (Boolean) v.get("possede");
            long kilomAnnee = (long) v.get("kilomAnnee");
            long amortissement = (long) v.get("amortissement");
            Voiture voiture = new Voiture(Taille.StringToTaille(taille),possede, (int) kilomAnnee, (int) amortissement);
            liste_voiture.add(voiture);
        }
        return (liste_voiture);
    }

    private Collection <Avion> lecture_fichier_listeAvion(JSONObject utilisateurObject) throws ErrValNeg {
        JSONArray listeAvionArray = (JSONArray) utilisateurObject.get("listeAvion");
        Collection<Avion> liste_avion = new ArrayList<>();
        for (int i = 0; i < listeAvionArray.size() ; i++) {
            JSONObject a = (JSONObject) listeAvionArray.get(i);
            long kilomAnnee = (long) a.get("kilomAnnee");
            Avion avion = new Avion((int) kilomAnnee);
            liste_avion.add(avion);
        }
        return(liste_avion);
    }


    private Collection <Bus> lecture_fichier_listeBus(JSONObject utilisateurObject) throws ErrValNeg {
        JSONArray listeBusArray = (JSONArray) utilisateurObject.get("listeBus");
        ArrayList<Bus> liste_bus = new ArrayList<>();
        for (int i = 0; i < listeBusArray.size() ; i++) {
            JSONObject b = (JSONObject) listeBusArray.get(i);
            long kilomAnnee = (long) b.get("kilomAnnee");
            String type = (String) b.get("type");
            System.out.println(type);
            TypeB typeB = TypeB.E.StringToTypeB(type);
            System.out.println(typeB.getCoef());
            Bus bus = new Bus((int)kilomAnnee, typeB);
            System.out.println("tot");
            liste_bus.add(bus);
        }
        return(liste_bus);
    }

    private Collection <TGV> lecture_fichier_listeTgv(JSONObject utilisateurObject) throws ErrValNeg {
        JSONArray listeTgvArray = (JSONArray) utilisateurObject.get("listeTGV");
        ArrayList<TGV> liste_tgv = new ArrayList<>();
        for (int i = 0; i < listeTgvArray.size() ; i++) {
            JSONObject a = (JSONObject) listeTgvArray.get(i);
            long kilomAnnee = (long) a.get("kilomAnnee");
            TGV tgv = new TGV((int)kilomAnnee);
            liste_tgv.add(tgv);
        }
        return(liste_tgv);
    }



    Utilisateur initialisation_manuelle() throws ErrValNeg, ErrTx {
        //Etape 1 : alimentation :
        System.out.println("Initialisation de la catégorie Alimentation ");
        Alimentation a = initialisation_manuelle_alimentation();

        //Etape 2 : BienConso :
        System.out.println("Initialisation de la catégorie BienConso :");
        BienConso c = initialisation_manuelle_bienConso();

        //Etape 3 : Liste Logement :
        System.out.println("Initialisation de la catégorie Logements : ");
        System.out.println("Combien de logements possedez-vous ?");
        int nb = scan.nextInt();

        Collection<Logement> liste_logement = initialisation_manuelle_listeLogement(nb);

        //Etape 4 : Voiture :
        System.out.println("Initialisation de la catégorie Voitures");
        System.out.println("Combien de voitures possédez-vous ?");
        nb = scan.nextInt();

        Collection<Voiture> liste_voiture = initialisation_manuelle_listeVoiture(nb);


        //Etape 5 : Avion :
        System.out.println("Initialisation de la catégorie Trajets en Avion");
        System.out.println("Combien de trajets en avion souhaitez-vous ajouter ? (1 aller = 1 trajet)");
        nb = scan.nextInt();

        Collection<Avion> liste_avion = initialisation_manuelle_listeAvion(nb);


        //Etape 6 : Bus :
        System.out.println("Initialisation de la catégorie Bus");
        System.out.println("Combien de trajets en Bus souhaitez-vous ajouter ?");
        nb = scan.nextInt();

        Collection<Bus> liste_bus = initialisation_manuelle_listeBus(nb);

        //Etape 7 : TGV
        System.out.println("Initialisation de la catégorie TGV");
        System.out.println("Combien de trajets en TGV souhaitez-vous ajouter ?");
        nb = scan.nextInt();

        Collection<TGV> liste_tgv = initialisation_manuelle_listeTgv(nb);


        //Etape 8 : Services Public:
        ServicesPublic s = ServicesPublic.getInstance();

        //Etape finale :
        Utilisateur u = new Utilisateur(a, c, liste_logement, liste_voiture, liste_avion,  liste_bus, liste_tgv, s);
        return (u);

    }

    private Alimentation initialisation_manuelle_alimentation() throws ErrTx {
        Alimentation a = new Alimentation();
        System.out.println("Entrez le taux de consommation moyen de Boeuf par repas (un nombre compris entre 0 et 1) : ");
        double txBoeuf = scan.nextDouble();
        a.setTxBoeuf(txBoeuf);
        System.out.println("Entrez le taux de consomation moyen de légumes par repas (un nombre compris entre 0 et 1 ) : ");
        double txVege = scan.nextDouble();
        a.setTxVege(txVege);
        return (a);
    }

    private BienConso initialisation_manuelle_bienConso() throws ErrValNeg {
        BienConso b = new BienConso();
        System.out.println("Entrez le montant de vos dépenses anuelles");
        int montant = scan.nextInt();
        b.setMontant(montant);
        return (b);
    }

    private Collection<Logement> initialisation_manuelle_listeLogement(int nb) throws ErrValNeg {
        //Logement l = new Logement;
        ArrayList<Logement> liste_logement = new ArrayList<>();
        for (int i=0; i<nb;i++) {
            System.out.println("Initialisation du logement numéro " + (i+1) + ":");
            Logement l = new Logement();
            CE ce = CE.A;
            l.setCe(ce.StringToCEBis());
            System.out.println("Entrez la superficie du logement numéro " + (i+1) +":");
            int superficie = scan.nextInt();
            l.setSuperficie(superficie);
            liste_logement.add(l);
        }
        return(liste_logement);
    }



    private Collection<Voiture> initialisation_manuelle_listeVoiture(int nb) throws ErrValNeg {
        ArrayList<Voiture> liste_voiture = new ArrayList<>();
        for (int i=0 ; i<nb; i++){
            System.out.println("Initialisation de la voiture numéro " + (i+1) + ":");
            Voiture v = new Voiture();
            v.setTaille(Taille.StringToTailleBis());
            System.out.println("Entrez \"true\" vous possédez la voiture numéro " + (i+1) + ", \"false\" sinon");
            boolean possede = scan.nextBoolean();
            v.setPossede(possede);
            System.out.println("Entrez le nombre de kilomètres parcourus en moyenne en un an avec la voiture numéro " + (i+1) + ":");
            int kilomAnnee = scan.nextInt();
            v.setKilomAnnee(kilomAnnee);
            System.out.println("Entrez l'amortissement de la voiture numéro "+ (i+1) +":");
            int amortissement = scan.nextInt();
            v.setAmortissement(amortissement);
            liste_voiture.add(v);
        }
        return (liste_voiture);
    }



    private Collection<Avion> initialisation_manuelle_listeAvion(int nb) throws ErrValNeg {
        ArrayList<Avion> liste_avion = new ArrayList<>();
        for (int i=0 ; i<nb; i++){
            System.out.println("Initialisation du trajet en avion numéro " + (i+1) + ":");
            Avion a = new Avion();
            System.out.println("Entrez le nombre de kilomètres parcourus durant le trajet numéro " + (i+1) + " :");
            int kilomAnnee = scan.nextInt();
            a.setKilomAnnee(kilomAnnee);
            liste_avion.add(a);
        }
        return (liste_avion);
    }

    private Collection<Bus> initialisation_manuelle_listeBus(int nb) throws ErrValNeg {
        ArrayList<Bus> liste_bus = new ArrayList<>();
        for (int i=0 ; i<nb; i++){
            System.out.println("Initialisation du trajet en bus numéro " + (i+1) + ":");
            Bus b = new Bus();
            System.out.println("Entrez le nombre de kilomètres parcourus durant le trajet numéro " + (i+1) + " :");
            int kilomAnnee = scan.nextInt();
            b.setKilomAnnee(kilomAnnee);
            liste_bus.add(b);
        }
        return (liste_bus);
    }

    private Collection<TGV> initialisation_manuelle_listeTgv(int nb) throws ErrValNeg {
        ArrayList<TGV> liste_tgv = new ArrayList<>();
        for (int i=0 ; i<nb; i++){
            System.out.println("Initialisation du trajet en TGV numéro " + (i+1) + ":");
            TGV t = new TGV();
            System.out.println("Entrez le nombre de kilomètres parcourus durant le trajet numéro " + (i+1) + " :");
            int kilomAnnee = scan.nextInt();
            t.setKilomAnnee(kilomAnnee);
            liste_tgv.add(t);
        }
        return (liste_tgv);
    }


}
