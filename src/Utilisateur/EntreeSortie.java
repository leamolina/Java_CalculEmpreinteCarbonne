package Utilisateur;
import consoCarbonne.*;
//import java.io.IOException;
//import java.lang.invoke.*;
import java.util.*;
import java.io.*;




public class EntreeSortie implements Serializable{
    private static Scanner scan = new Scanner(System.in);

    //Constructeur par défaut
    public EntreeSortie() {
    }


    public static void printMenu() {
        System.out.println("--------------");
        System.out.println("Voici le Menu");
        System.out.println("--------------");
        System.out.println("Tapez 0 pour sortir du menu.");
        System.out.println("Tapez 1 pour initialiser un utilisateur à partir d'un fichier texte.");
        System.out.println("Tapez 2 pour initialiser un utilisateur manuellement.");
    }

    public Utilisateur AffichageUtilisateur() {
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
                    u = initialisation_fichier();
                    fin = true;
                    break;

                case (2):
                    //u = initialisation_manuelle();
                    break;
                default:
                    System.out.println("Cette valeur ne fait pas partie des possibilités.");
            }
        } while (!fin);
        scan.close();
        System.out.println(u.toString());
        return (u);
    }

    //On travaillera sur cette methode a la fin ( cest la plus dure)

    //On considère qu'une



    private static Utilisateur initialisation_fichier() {
        Utilisateur u = new Utilisateur();

        try {
            System.out.println("Entrez le nom du fichier  :");
            String nom_fichier = scan.nextLine();
            ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(new File(nom_fichier))) ;
            oos.writeObject(u) ;
            oos.close() ;

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(nom_fichier))) ;
            Utilisateur copy =
                    (Utilisateur) ois.readObject() ;
            //u = (Utilisateur) ois.readObject();

            ois.close();


            return (copy);
        }

        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*


    private static Utilisateur initialisation_fichier(){

        Utilisateur u = new Utilisateur();
        try {
            System.out.println("Entrez le nom du fichier  :");
            String nom_fichier = scan.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(nom_fichier));
            String ligne = reader.readLine();

            //Premiere ligne : Alimentation
            if (ligne != null) {
                Alimentation a = initialisation_fichier_alimentation(ligne);
                u.setAlimentation(a);
                ligne = reader.readLine();

                //Deuxieme ligne : BienConso
                if (ligne != null) {
                    BienConso b = initialisation_fichier_bienConso(ligne);
                    u.setBienConso(b);
                    ligne = reader.readLine();

                    //Troisieme ligne : ListeLogement
                    if (ligne != null) {
                        ArrayList<Logement> liste_logement = initialisation_fichier_listeLogement(ligne);
                        u.setCollection_logement(liste_logement);
                        ligne = reader.readLine();

                        //Quatrieme ligne : ListeVoiture
                        if (ligne != null) {
                            ArrayList<Voiture> liste_voiture = initialisation_fichier_listeVoiture(ligne);
                            u.setCollection_voiture(liste_voiture);
                            ligne = reader.readLine();

                            //Cinquieme ligne : ListeAvion
                            if(ligne!= null){
                                ArrayList<Avion> liste_avion = initialisation_fichier_listeAvion(ligne);
                                u.setCollection_avion(liste_avion);
                                ligne = reader.readLine();

                                //Sixieme ligne : Liste Bus
                                if(ligne!= null){
                                    ArrayList<Bus> liste_bus = initialisation_fichier_listeBus(ligne);
                                    u.setCollection_bus(liste_bus);
                                    ligne = reader.readLine();

                                    //Septieme ligne : ListeTGV
                                    if (ligne != null){
                                        ArrayList<TGV> liste_tgv = initialisation_fichier_listeTgv(ligne);
                                        u.setCollection_tgv(liste_tgv);
                                        ligne = reader.readLine();

                                        //Huitieme ligne : on vérifie qu'il n'y a plus rien
                                        if(ligne !=null) System.out.println("Erreur : le nombre de lignes du fichier n'est pas compatible ( il y en a en trop) ");

                                    } else System.out.println("Erreur : le nombre de lignes du fichier n'est pas compatible (il en manque)");
                                } else System.out.println("Erreur : le nombre de lignes du fichier n'est pas compatible (il en manque)");
                            } else System.out.println("Erreur : le nombre de lignes du fichier n'est pas compatible (il en manque)");
                        } else System.out.println("Erreur : le nombre de lignes du fichier n'est pas compatible (il en manque)");
                    } else System.out.println("Erreur : le nombre de lignes du fichier n'est pas compatible (il en manque)");
                } else System.out.println("Erreur : le nombre de lignes du fichier n'est pas compatible (il en manque)");
            } else System.out.println("Erreur : le nombre de lignes du fichier n'est pas compatible (il en manque)");

            reader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    return(u);
     }


    private static Alimentation initialisation_fichier_alimentation(String ligne){
        Alimentation a = new Alimentation();
        System.out.println("La ligne d'alimentation est : " + ligne);
         String[] mots = ligne.split(" ");
         System.out.println("nb de mots : " + mots.length);
         //On verifie qu'il y a bien deux mots differents
         if (mots.length !=2) {
             System.out.println("Erreur de mise en page");
             System.exit(0);
         }

         //Normalement le premier mot c'est "Alimentation" ;
         if(!mots[0].equals("Alimentation")){
             System.out.println("Erreur : le premier mot est censé etre le nom de la catégorie (ici Alimentation).");
             System.exit(0);
         }
         //Si c'est bon on peut lire les infos de l'alimentation
         //Le deuxieme mot est du type{txBoeuf,txVege,...} et contient tous les attributs d'une alimentation

        mots[1] = mots[1].replaceAll("\\{", "").replaceAll("\\}","");
         String[] liste_attributs = mots[1].split(";");

         //On verifie qu'il y a bien deux attributs
         if(liste_attributs.length !=2){
             System.out.println("Erreur : pas le bon nombre d'attributs. Il y en a" + liste_attributs.length + " et 2 sont attendus.");
             System.exit(0);
         }

         //On lit les deux attributs (les setters feront les tests necessaires)
         double txBoeuf = Double.parseDouble(liste_attributs[0]);
         a.setTxBoeuf(txBoeuf);
         double txVege = Double.parseDouble(liste_attributs[1]);
         a.setTxVege(txVege);
         //System.out.println("To string d alilentation");
         //System.out.println(a.toString());
         return(a);
     }



    private static ArrayList<Logement> initialisation_fichier_listeLogement(String ligne){
        ArrayList liste_logement = new ArrayList();
        System.out.println("La ligne de Logements est : " + ligne);
        String[] mots = ligne.split(" ");
        System.out.println("nb de mots : " + mots.length);
        if (mots.length <2) {
            System.out.println("Erreur de mise en page");
            System.exit(0);
        }

        //Normalement les premier mot est "ListeLogement"
        if(!mots[0].equals("ListeLogement")){
            System.out.println("Erreur : le premier mot est censé etre le nom de la catégorie (ici ListeLogement).");
            System.exit(0);
        }

        //Si c est bon on peut lire les infos des Logements
        //On recupere les prochains mots un à un
        //Chaque mot est la liste des attributs d'un logement

        for (int i=1; i<mots.length; i++){
            Logement l = new Logement();
            mots[i] = mots[i].replaceAll("\\{", "").replaceAll("\\}","");
            String[] liste_attributs = mots[i].split(";");

            //On verifie qu'il y a bien deux attributs
            if(liste_attributs.length !=2){
                System.out.println("Erreur : pas le bon nombre d'attributs. Il y en a" + liste_attributs.length + " et 2 sont attendus.");
                System.exit(0);
            }

            //On lit les deux attributs sans rien vérifier (les setters feront les verifications necessaires)
            int superficie = Integer.parseInt(liste_attributs[0]);
            l.setSuperficie(superficie);

        }


        return(liste_logement);
    }

    private static Logement initialisation_fichier_logement(String ligne){
        Logement l = new Logement();
        return(l);
    }




    private static BienConso initialisation_fichier_bienConso(String ligne){
        BienConso b = new BienConso();
        String[] mots = ligne.split(" ");
        //On verifie qu'il y a bien deux mots differents
        if (mots.length !=2) {
            System.out.println("Erreur de mise en page");
            System.exit(0);
        }

        //Normalement le premier mot c'est "BienConso" ;
        if(!mots[0].equals("BienConso")){
            System.out.println("Erreur : le premier mot est censé etre le nom de la catégorie (ici BienConso).");
            System.exit(0);
        }
        //Si c'est bon on peut lire les infos de l'alimentation
        //Le deuxieme mot est du type{txBoeuf,txVege,...} et contient tous les attributs d'une alimentation
        mots[1] = mots[1].replaceAll("\\{", "").replaceAll("\\}","");
        String[] liste_attributs = mots[1].split(";");

        //On verifie qu'il y a bien un attribut
        if(liste_attributs.length !=1){
            System.out.println("Erreur : pas le bon nombre d'attributs. Il y en a" + liste_attributs.length + " et 1 seul est attendu.");
            System.exit(0);
        }

        //On lit l'attribut (les setters feront les tests necessaires)
        double montant = Double.parseDouble(liste_attributs[0]);
        b.setMontant(montant);

        return(b);
    }

    private static ArrayList<Transport> initialisation_fichier_listeTransport(String ligne){
        ArrayList liste_transport = new ArrayList();
        return(liste_transport);
    }

    private static Voiture initialisation_fichier_Voiture(String ligne){
        Voiture v = new Voiture();
        String[] mots = ligne.split(" ");
        //On verifie qu'il y a bien deux mots differents
        if (mots.length !=0) {
            System.out.println("Erreur de mise en page");
            System.exit(0);
        }

        //Normalement le premier mot c'est "Voiture" ;
        if(!mots[0].equals("Voiture")){
            System.out.println("Erreur : le premier mot est censé etre le nom de la catégorie (ici Voiture).");
            System.exit(0);
        }
        //Si c'est bon on peut lire les infos de la voiture
        //Le deuxieme mot est du type{att1, att2,...} et contient tous les attributs d'une voiture
        mots[1] = mots[1].replaceAll("{}", "");
        String[] liste_attributs = mots[1].split(";");

        //On verifie qu'il y a bien un attribut
        if(liste_attributs.length !=4){
            System.out.println("Erreur : pas le bon nombre d'attributs. Il y en a" + liste_attributs.length + " et 4 sont attendus.");
            System.exit(0);
        }

        //On lit les attributs (les setters feront les tests necessaires)

        //Taille :
        if(liste_attributs[0].equals("P")) v.setTaille(Taille.P);
        else if (liste_attributs[0].equals("G")) v.setTaille(Taille.G);
        else {
            System.out.println("Erreur : la taille de la voiture n'est pas compatible.");
            System.exit(0);
        }
        //Possede :
        if(liste_attributs[1].equals("true")) v.setPossede(true);
        else if (liste_attributs[1].equals("false")) v.setPossede(false);
        else {
            System.out.println("Erreur : l'attribut Possede de la voiture n'est pas compatible.");
            System.exit(0);
        }
        int kilomAnnee = Integer.parseInt(liste_attributs[2]);
        v.setKilomAnnee(kilomAnnee);
        int amortissement = Integer.parseInt(liste_attributs[3]);
        v.setAmortissement(amortissement);

        return(v);
    }

    private static Avion initialisation_fichier_Avion(String ligne){
        Avion a = new Avion();
        return(a);
    }


    private static TGV initialisation_fichier_TGV(String ligne){
        TGV t = new TGV();
        return(t);
    }

    private static Bus initialisation_fichier_Bus(String ligne){
        Bus b = new Bus();
        return(b);
    }






















    private Utilisateur initialisation_manuelle(){
        //Etape 1 : alimentation :
        System.out.println("Initialisation de l'Alimentation ");
        Alimentation a = initialisation_manuelle_alimentation();

        //Etape 2 : BienConso :
        System.out.println("Initialisation de BienConso :");
        BienConso c = initialisation_manuelle_bienConso();

        //Etape 3 : Logement :
        System.out.println("Initialisation des logements : ");
        System.out.println("Combien de logement souhaitez vous ajouter ?");
        int nb = scan.nextInt();
        ArrayList<Logement> liste_logement = initialisation_manuelle_logement(nb);

        //Etape 4 : Transport :
        System.out.println("Initialisation des transport");
        System.out.println("Combien de transport souhaitez vous ajouter ?");
        nb = scan.nextInt();
        ArrayList<Transport> liste_transport = initialisation_manuelle_transport(nb);

        //Etape 5 : Services Public:
        ServicesPublic s = ServicesPublic.getInstance();

        //Etape finale :
        Utilisateur u = new Utilisateur(a, c, liste_logement, liste_transport, s);
        return (u);

    }

    private Alimentation initialisation_manuelle_alimentation(){
        Alimentation a = new Alimentation();
        System.out.println("Entrer le taux de Boeuf : ");
        int txBoeuf = scan.nextInt();
        a.setTxBoeuf(txBoeuf);
        System.out.println("Entre le taux de legume ");
        int txVege = scan.nextInt();
        a.setTxVege(txVege);
        return (a);
    }

    private BienConso initialisation_manuelle_bienConso(){
        BienConso b = new BienConso();
        System.out.println("Entre le montant des depenses anuelles");
        int montant = scan.nextInt();
        b.setMontant(montant);
        return (b);
    }

    private ArrayList<Logement> initialisation_manuelle_logement(int nb){
        ArrayList liste_logement = new ArrayList();
        for (int i=0; i<nb;i++) {
            System.out.println("Creation d'un logement");
            Logement l = new Logement();
            CE ce = CE.A;
            l.setCe(ce.StringToCE());
            System.out.println("Entrer la superficie du logement : ");
            int superficie = scan.nextInt();
            l.setSuperficie(superficie);
            liste_logement.add(l);
        }
        return(liste_logement);
    }



    private ArrayList<Transport> initialisation_manuelle_transport(int nb){
        ArrayList liste_transport = new ArrayList();
        for (int i=0 ; i<nb; i++){
            Transport t =  creation_transport();
            liste_transport.add(t);
        }
        return (liste_transport);
    }

    private Transport creation_transport(){
        System.out.println("Creation d'un transport");
        System.out.println("Entrez 0 si vous voulez ajouter un Avion");
        System.out.println("Entrez 1 si vous voulez ajouter une Voiture");
        System.out.println("Entrez 2 si vous voulez ajouter un Bus ");
        System.out.println("Entrez 3 si vous voulez ajouter un TGV");
        boolean fin = false;
        Transport t = new Transport();
        do{
            int type_logement = scan.nextInt();
            int nbKm = 0;
            switch(type_logement){
                case(0):
                    //creation d'un Avion
                    System.out.println("Entrez le nombre de kilometres :");
                    nbKm = scan.nextInt();
                    t = new Avion(nbKm);
                    fin = true;
                    break;
                case(1):
                    //creation d'une voiture
                    System.out.println("Entrez le nombre de kilometres :");
                    nbKm = scan.nextInt();
                    Voiture v = new Voiture();
                    boolean fin_v = false;
                    System.out.println("Entrez 1 si l'utilisateur possede une voiture, 0 sinon ");
                    int x = scan.nextInt();
                    do {
                        if (x == 0) {
                            v.setPossede(false);
                            v.setKilomAnnee(0);
                            v.setAmortissement(0);
                        } else if (x == 1) {
                            v.setPossede(true);
                            System.out.println("Entrez l'amortissement.");
                            int amortissement = scan.nextInt();
                            v.setAmortissement(amortissement);
                            Taille taille = Taille.P;
                            v.setTaille(taille.StringToTaille());
                        }
                    }while(fin_v == false);
                    t = v;
                    break;
                case(2):
                    //creation d'un Bus
                    Bus b = new Bus();
                    System.out.println("Entrez le nombre de kilometres :");
                    nbKm = scan.nextInt();
                    TypeB type = TypeB.M;
                    b.setType(type);
                    b.setKilomAnnee(nbKm);
                    t = b;
                    fin = true;
                    break;
                case(3):
                    //creation d'un TGV
                    TGV tgv = new TGV();
                    System.out.println("Entrez le nombre de kilometres :");
                    nbKm = scan.nextInt();
                    tgv.setKilomAnnee(nbKm);
                    t = tgv;
                    fin = true;
                    break;
                default :
                    System.out.println("Cette valeur ne fait pas partie des possibilités.");
            }
        }while(!fin);
        scan.close();
        return(t);
    }

     */


}
