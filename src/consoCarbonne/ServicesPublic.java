package consoCarbonne;
/*
public class ServicesPublic {

    //Constructeur
    private ServicesPublic(double valeur){
        this.valeur = valeur;
    }

    //Instance unique pré-initialisée
    private static ServicesPublic INSTANCE = new ServicesPublic();

    //Point d'accès pour l'instance unique du singleton
    public static ServicesPublic getInstance(){
        return INSTANCE;
    }

    /*
    ETAPE 1 :
    créer un attribut statique qui va permettre de stocker l’unique instance de la classe

    ETAPE 2 :
    dans le pseudo constructeur on va tester cet attribut.
    Si celui-ci est nul alors on crée une instance de la classe et on stocke sa valeur dans cet attribut.
    Sinon c’est que l’attribut possède déjà une instance de la classe.
    Dans tous les cas la méthode retourne la valeur de l’attribut possédant l’unique instance de la classe.

    private static ServicesPublic instance;
    private double valeur = 1.5;




}
*/


/**
 * La classe ServicesPublics représente le poste de consommation carbone induit par les services publics (justice, police, éducation, santé, ...).
 * NB: Ce poste de consommation carbone à la particularité que tou.te.s les Français.e.s ont la même empreinte de 1.5TCO2eq pour ce poste de consommation.
 */
public final class ServicesPublic extends ConsoCarbonne{

    private static ServicesPublic instance = new ServicesPublic();


    /**
     * Cette methode fixe(car elle est la meme pour tout.es les Francais.e.s) l'empreinte carbonne du poste de consommation ServicesPublics
     */
    private ServicesPublic() {
        super.setImpact(1.5);
    }


    public static ServicesPublic getInstance() {
        if (instance == null) {
            instance = new ServicesPublic();
        }
        return instance;
    }
}

