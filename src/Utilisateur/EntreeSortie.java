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

/**
 * La classe EntreeSortie permet de gerer toutes les interactions avec l'utilisateur
 * En particulier l'initialisation d'un utilisateur selon deux methodes : par lecture de fichier ou en repondant a une serie de questions.
 */
public class EntreeSortie{
    private final Scanner scan = new Scanner(System.in);

    //Constructeur par défaut
    public EntreeSortie(){}


    /**
     * Methode qui permet d'afficher le menu interactif.
     */
    public static void printMenu() {
        System.out.println("Tapez 0 pour initialiser un utilisateur à partir d'un fichier texte.");
        System.out.println("Tapez 1 pour initialiser un utilisateur manuellement (en répondant à une suite de questions).");
    }

    /**
     * @return l'utilisateur cree
     * @throws ErrTx Exception en cas de taux non compris entre 0 et 1.
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    public Utilisateur CreationUtilisateur() throws ErrTx, ErrValNeg {
        Utilisateur u = new Utilisateur();
        boolean fin = false;
        do {
            printMenu();
            int choixUtiliateur = scan.nextInt();
            scan.nextLine();
            switch (choixUtiliateur) {
                case (0) -> {
                    System.out.println("Entrez le nom du fichier  :");
                    String nom_fichier = scan.nextLine();
                    System.out.println("\n");
                    u = new Utilisateur(nom_fichier);
                    fin = true;
                }
                case (1) -> {
                    u = new Utilisateur(0);
                    fin = true;
                }
                default -> System.out.println("Cette valeur ne fait pas partie des possibilités.");
            }
        } while (!fin);
        return (u);
    }

    /**
     *
     * @param nom_fichier est le nom du fichier texte
     * @return renvoie le nouvel utilisateur cree a partir d un fichier texte
     */
    protected Utilisateur initialisation_fichier(String nom_fichier) {
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
                Bus bus = lecture_fichier_bus(utilisateurObject);
                Collection <TGV> liste_tgv = lecture_fichier_listeTgv(utilisateurObject);
                ServicesPublic s = ServicesPublic.getInstance();

                u = new Utilisateur(alimentation, bienConso, liste_logement, liste_voiture, liste_avion, bus, liste_tgv,s);



            } catch (FileNotFoundException e) {
                System.err.println("Erreur : fichier non trouvé.");
                System.exit(1);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                System.err.println("Erreur dans l'utilisation du parse. Vérifier le format du fichier texte.");
                e.printStackTrace();
            } catch (ErrTx e) {
                e.getMessage();
            } catch (ErrValNeg e) {
                e.getMessage();
            } catch (ErrSommeTx e) {
                e.getMessage();
        }
        return u;
    }


    /**
     * La methode va parcourir l'objet JSON et recuperer les differents attributs du poste de consommation alimentation.
     * @param utilisateurObject l'objet recupere grace au JSONParser, representant l'utilisateur.
     * @return renvoie la consommation carbonne de la categorie Alimentation
     * @throws ErrTx Exception en cas de taux non compris entre 0 et 1.
     * @throws ErrSommeTx Exception en cas de somme de taux non egale a 1.
     */
    private Alimentation lecture_fichier_alimentation(JSONObject utilisateurObject) throws ErrTx, ErrSommeTx {
        JSONObject alimentationObject = (JSONObject) utilisateurObject.get("alimentation");
        double txBoeuf = (double) alimentationObject.get("txBoeuf");
        double txVege = (double) alimentationObject.get("txVege");
        return (new Alimentation(txBoeuf, txVege));
    }

    /**
     * La methode va parcourir l'objet JSON et recuperer les differents attributs du poste de consommation bienConso.
     * @param utilisateurObject l'objet recupere grace au JSONParser, representant l'utilisateur.
     * @return renvoie la consommation carbonne de la categorie Alimentation
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    private BienConso lecture_fichier_bienConso(JSONObject utilisateurObject) throws ErrValNeg {
        JSONObject bienConsoObject = (JSONObject) utilisateurObject.get("bienconso");
        double montant = (double) bienConsoObject.get("montant");
        return (new BienConso(montant));
    }

    /**
     * La methode va parcourir l'objet JSON et recuperer les differents attributs de chaque logement composant la liste_logement de l utilisateur.
     * @param utilisateurObject l'objet recupere grace au JSONParser, representant l'utilisateur.
     * @return renvoie une collection de Logement
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    private Collection <Logement> lecture_fichier_listeLogement(JSONObject utilisateurObject) throws ErrValNeg {
        JSONArray listelogmentArray = (JSONArray) utilisateurObject.get("listelogement");
        Collection<Logement> liste_logement = new ArrayList<>();
        for (int i = 0; i < listelogmentArray.size() ; i++) {
            JSONObject t = (JSONObject) listelogmentArray.get(i);
            long superficie = (Long) t.get("superficie");
            String classe = (String) t.get("classe");
            Logement logement = new Logement((int) superficie, CE.StringToCE(classe));
            liste_logement.add(logement);
        }
        return (liste_logement);
    }

    /**
     * La methode va parcourir l'objet JSON et recuperer les differents attributs de chaque voiture composant la liste_voiture de l utilisateur.
     * @param utilisateurObject l'objet recupere grace au JSONParser, representant l'utilisateur.
     * @return renvoie une collection de voitures
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    private Collection<Voiture> lecture_fichier_listeVoiture(JSONObject utilisateurObject) throws ErrValNeg {
        JSONArray listevoitureArray = (JSONArray) utilisateurObject.get("listeVoiture");
        Collection<Voiture> liste_voiture = new ArrayList<>();
        for (int i = 0; i < listevoitureArray.size() ; i++) {
            JSONObject v = (JSONObject) listevoitureArray.get(i);
            Boolean possede = (Boolean) v.get("possede");
            if (possede) {
                String taille = (String) v.get("taille");
                long kilomAnnee = (long) v.get("km");
                long amortissement = (long) v.get("amortissement");
                Voiture voiture = new Voiture(Taille.StringToTaille(taille), possede, (int) kilomAnnee, (int) amortissement);
                liste_voiture.add(voiture);
            }
        }
        return (liste_voiture);
    }

    /**
     * La methode va parcourir l'objet JSON et recuperer les differents attributs de chaque trajet d avion composant la liste_avion de l utilisateur.
     * @param utilisateurObject l'objet recupere grace au JSONParser, representant l'utilisateur.
     * @return renvoie une collection de trajets d avion
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */

    private Collection <Avion> lecture_fichier_listeAvion(JSONObject utilisateurObject) throws ErrValNeg {
        JSONArray listeAvionArray = (JSONArray) utilisateurObject.get("listeAvion");
        Collection<Avion> liste_avion = new ArrayList<>();
        for (int i = 0; i < listeAvionArray.size() ; i++) {
            JSONObject a = (JSONObject) listeAvionArray.get(i);
            long kilomAnnee = (long) a.get("km");
            Avion avion = new Avion((int) kilomAnnee);
            liste_avion.add(avion);
        }
        return(liste_avion);
    }

    /**
     * La methode va parcourir l'objet JSON et recuperer les differents attributs du poste de consommation Bus.
     * @param utilisateurObject
     * @return renvoie la consommation carbonne de la categorie Bus de l'Utilisateur
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    private Bus lecture_fichier_bus(JSONObject utilisateurObject) throws ErrValNeg {
        JSONObject busObject = (JSONObject) utilisateurObject.get("bus");
        Bus b = new Bus();
        long km = (long) busObject.get("km");
        if(km!=0) {
            String type = (String) busObject.get("type");
            b.setType(TypeB.StringToTypeB(type));
        }
        return (b);
    }

    /**
     * La methode va parcourir l'objet JSON et recuperer les differents attributs de chaque trajet de TGV composant la liste_tgv de l utilisateur.
     * @param utilisateurObject l'objet recupere grace au JSONParser, representant l'utilisateur.
     * @return renvoie une collection de trajets de TGV
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    private Collection <TGV> lecture_fichier_listeTgv(JSONObject utilisateurObject) throws ErrValNeg {
        JSONArray listeTgvArray = (JSONArray) utilisateurObject.get("listeTGV");
        ArrayList<TGV> liste_tgv = new ArrayList<>();
        for (int i = 0; i < listeTgvArray.size() ; i++) {
            JSONObject a = (JSONObject) listeTgvArray.get(i);
            long kilomAnnee = (long) a.get("km");
            TGV tgv = new TGV((int)kilomAnnee);
            liste_tgv.add(tgv);
        }
        return(liste_tgv);
    }


    /**
     * Cette methode permet l'initialisation manuelle d'un utilisateur
     * @return l'utilisateur cree manuellement
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     * @throws ErrTx Exception en cas de taux non compris entre 0 et 1.
     */
    Utilisateur initialisation_manuelle() throws ErrValNeg, ErrTx {
        Utilisateur u = new Utilisateur();
        //Etape 1 : alimentation :
        System.out.println("Initialisation de la catégorie Alimentation ");
        Alimentation a = initialisation_manuelle_alimentation();
        System.out.println("\n");
        u.setAlimentation(a);

        //Etape 2 : BienConso :
        System.out.println("Initialisation de la catégorie BienConso :");
        BienConso c = initialisation_manuelle_bienConso();
        System.out.println("\n");
        u.setBienConso(c);

        //Etape 3 : Liste Logement :
        System.out.println("Initialisation de la catégorie Logements : ");
        System.out.println("Combien de logements possedez-vous ?");
        int nb = scan.nextInt();
        if(nb != 0) { //Si l'utilisateur entre 0, alors la liste_logement sera celle par défaut (une liste contenant un unique logement par défaut)
            Collection<Logement> liste_logement = initialisation_manuelle_listeLogement(nb);
            u.setCollection_logement(liste_logement);
            System.out.println("\n");

        }

        //Etape 4 : Voiture :
        System.out.println("Initialisation de la catégorie Voitures");
        System.out.println("Combien de voitures possédez-vous ?");
        nb = scan.nextInt();
        if(nb != 0) {
            Collection<Voiture> liste_voiture = initialisation_manuelle_listeVoiture(nb);
            u.setCollection_voiture(liste_voiture);
            System.out.println("\n");

        }


        //Etape 5 : Avion :
        System.out.println("Initialisation de la catégorie Trajets en Avion");
        System.out.println("Combien de trajets en avion souhaitez-vous ajouter ? (1 aller = 1 trajet)");
        nb = scan.nextInt();
        if (nb !=0) {
            Collection<Avion> liste_avion = initialisation_manuelle_listeAvion(nb);
            u.setCollection_avion(liste_avion);
            System.out.println("\n");
        }

        //Etape 6 : Bus :
        System.out.println("Initialisation de la catégorie Bus");
        Bus b = initialisation_manuelle_bus();
        u.setBus(b);
        System.out.println("\n");

        //Etape 7 : TGV
        System.out.println("Initialisation de la catégorie TGV");
        System.out.println("Combien de trajets en TGV souhaitez-vous ajouter ? (1 aller = 1 trajet)");
        nb = scan.nextInt();
        if(nb != 0) {
            Collection<TGV> liste_tgv = initialisation_manuelle_listeTgv(nb);
            u.setCollection_tgv(liste_tgv);
            System.out.println("\n");
        }

        //Etape 8 : Services Public:
        ServicesPublic s = ServicesPublic.getInstance();
        u.setService(s);
        System.out.println("\n");

        //Etape finale :
        return (u);

    }

    /**
     * Cette methode permet l'initialisation manuelle du poste de consommation Alimentation
     * @return le poste de consommation Alimentation saisi manuellement
     * @throws ErrTx Exception en cas de taux non compris entre 0 et 1.
     */
    private Alimentation initialisation_manuelle_alimentation() throws ErrTx {
        Alimentation a = new Alimentation();
        System.out.println("Entrez le taux de consommation moyen de Boeuf par repas (un nombre compris entre 0 et 1) : ");
        System.out.println("Remarque : Pour les virgules, il faut écrire \",\" et non \".\" .");
        double txBoeuf = scan.nextDouble();
        a.setTxBoeuf(txBoeuf);
        System.out.println("Entrez le taux de consommation moyen de légumes par repas (un nombre compris entre 0 et 1 ) : ");
        double txVege = scan.nextDouble();
        a.setTxVege(txVege);
        return (a);
    }

    /**
     * Cette methode permet l'initialisation manuelle du poste de consommation BienConso
     * @return le poste de consommation BienConso saisi manuellement
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    private BienConso initialisation_manuelle_bienConso() throws ErrValNeg {
        BienConso b = new BienConso();
        System.out.println("Entrez le montant de vos dépenses annuelles");
        int montant = scan.nextInt();
        b.setMontant(montant);
        return (b);
    }

    /**
     * Cette methode permet l'initialisation manuelle du poste de consommation Logement
     * @param nb correspond au nombre de logement que l'utilsateur possede
     * @return le poste de consommation Logement saisi manuellement
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    private Collection<Logement> initialisation_manuelle_listeLogement(int nb) throws ErrValNeg {
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


    /**
     * Cette methode permet l'initialisation manuelle du poste de consommation Voiture
     * @param nb correspond au nombre de voiture que l'utilsateur possede
     * @return le poste de consommation Voiture saisi manuellement
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    private Collection<Voiture> initialisation_manuelle_listeVoiture(int nb) throws ErrValNeg {
        ArrayList<Voiture> liste_voiture = new ArrayList<>();
        for (int i=0 ; i<nb; i++){
            Voiture v = new Voiture();

            System.out.println("Entrez \"true\" vous possédez la voiture numéro " + (i+1) + ", \"false\" sinon");
            boolean possede = scan.nextBoolean();
            v.setPossede(possede);
            if(possede) { //Si l'utilisateur possede bien la voiture, on peut fixer les attributs de la classe. Sinon, les attributs par défauts seront choisis.
                System.out.println("Initialisation de la voiture numéro " + (i + 1) + ":");
                Taille taille = Taille.G;
                v.setTaille(taille.StringToTailleBis());
                System.out.println("Entrez le nombre de kilomètres parcourus en moyenne en un an avec la voiture numéro " + (i + 1) + ":");
                int km = scan.nextInt();
                v.setKm(km);
                System.out.println("Entrez l'amortissement de la voiture numéro " + (i + 1) + ":");
                int amortissement = scan.nextInt();
                v.setAmortissement(amortissement);
            }
            liste_voiture.add(v);
        }
        return (liste_voiture);
    }


    /**
     * Cette methode permet l'initialisation manuelle du poste de consommation Avion
     * @param nb correspond au nombre de trajet d'avion effectues par l'utilsateur
     * @return le poste de consommation Avion saisi manuellement
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    private Collection<Avion> initialisation_manuelle_listeAvion(int nb) throws ErrValNeg {
        ArrayList<Avion> liste_avion = new ArrayList<>();
        for (int i=0 ; i<nb; i++){
            System.out.println("Initialisation du trajet en avion numéro " + (i+1) + ":");
            Avion a = new Avion();
            System.out.println("Entrez le nombre de kilomètres parcourus durant le trajet numéro " + (i+1) + " :");
            int km = scan.nextInt();
            a.setKm(km);
            liste_avion.add(a);
        }
        return (liste_avion);
    }

    /**
     * Cette methode permet l'initialisation manuelle du poste de consommation Bus
     * @return le poste de consommation Bus saisi manuellement
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    private Bus initialisation_manuelle_bus() throws ErrValNeg {
        Bus b = new Bus();
        System.out.println("Entrez le nombre de kilomètres parcourus par ans en Bus:");
        int km = scan.nextInt();
        b.setKm(km);
        if(km !=0) { //On considere qu'il est inutile de demander à l'utilisateur le type de Bus qu'il utilise s'il a entré avant qu'il n'utilisait pas le bus
            TypeB type = TypeB.M;
            b.setType(type.StringToTypeBBis());
        }

        return (b);
    }

    /**
     * Cette methode permet l'initialisation manuelle du poste de consommation TGV
     * @param nb correspond au nombre de trajet en TGV effectues par l'utilsateur
     * @return le poste de consommation TGV saisi manuellement
     * @throws ErrValNeg Exception en cas d entree d une valeur negative pour certains attributs de la classe
     */
    private Collection<TGV> initialisation_manuelle_listeTgv(int nb) throws ErrValNeg {
        ArrayList<TGV> liste_tgv = new ArrayList<>();
        for (int i=0 ; i<nb; i++){
            System.out.println("Initialisation du trajet en TGV numéro " + (i+1) + ":");
            TGV t = new TGV();
            System.out.println("Entrez le nombre de kilomètres parcourus durant le trajet numéro " + (i+1) + " :");
            int km = scan.nextInt();
            t.setKm(km);
            liste_tgv.add(t);
        }
        return (liste_tgv);
    }


}
