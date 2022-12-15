package consoCarbonne;

/**
 * La classe Alimentation represente l'empreinte carbonne moyenne de l'alimentation d'un francais en fonction du taux de repas a base de boeuf, et le taux de repas vegetariens.
 * Cet empreinte carbonne est calculée selon la formule suivante: 8 × txBoeuf + 1.6 × (1 − txVege − txBoeuf) + 0.9 × txVege (selon l’hypothèse qu’un repas ni végétarien, ni à base de boeuf est à base de volaille).
 */
public class Alimentation extends ConsoCarbonne {

    //Constructeur
    public Alimentation(double txBoeuf, double txVege) {
        setTxBoeuf(txBoeuf);
        setTxVege(txVege);
        setTxVolaille(txBoeuf, txVege);
        setCalculImpact();
    }
    private double txBoeuf = 0.0;
    private double txVege = 0.0;
    private double txVolaille = 0.0;
    private final double cst1 = 8.0;
    private final double cst2 = 1.6;
    private final double cst3 = 0.9;

    /**
     * Methode permettant de verifier que le taux de repas a base de boeuf est bien compris entre 0 et 1 et de le fixer.
     * @param tb
     */
    //Setters
    public void setTxBoeuf (double tb){
        if(tb >=0 && tb <=1) {
            this.txBoeuf = tb;
            setCalculImpact();
        }
        else System.out.println("Erreur : le taux de repas a base de boeuf doit etre compris entre 0 et 1");
    }

    /**
     * Methode permettant de verifier que le taux de repas vegetariens est bien compris entre 0 et 1 et de le fixer.
     * @param tv
     */
    public void setTxVege (double tv){
        if(tv >=0 && tv <=1) {
            this.txVege = tv;
            setCalculImpact();
        }
        else System.out.println("Erreur : le taux de repas vegetarien doit etre compris entre 0 et 1");
    }

    /**
     * Methode permettant de calculer le taux de repas a base de volaille.
     * @param tb
     * @param tv
     */
    public void setTxVolaille (double tb, double tv){
        double tVo = 1 - tb - tv;
        if(tVo >=0 && tVo <=1) {
            this.txVolaille = tVo;
            setCalculImpact();
        }
        else System.out.println("Erreur : le taux de repas à base de volaille doit etre compris entre 0 et 1");
    }

    /**
     * Methode permettant de calculer l'impact avec la formule: 8 × txBoeuf + 1.6 × (1 − txVege − txBoeuf) + 0.9 × txVege
     */
    public void setCalculImpact (){
        super.setImpact(this.cst1 * this.txBoeuf + this.cst2 * (1 - this.txVege - this.txBoeuf) + this.cst3 * this.txVege);
    }

    //Getters
    public double getTxBoeuf (){
        return this.txBoeuf;
    }
    public double getTxVege (){
        return this.txVege;
    }
    public double getTxVolaille (){
        return this.txVolaille;
    }


    /**
     * Methode detaillant l'empreinte carbonne moyenne d un francais dans le domaine de l'alimentation.
     */
    public static void EmpreinteAlimentation(){
        int viandePoisson = 1144;
        int produitsLaitiersOeuf = 408;
        int boissons = 263;
        int autres = 538 ;
        int sum = viandePoisson + produitsLaitiersOeuf + boissons + autres;
        System.out.println("Details de l empreinte carbonne moyenne d un francais (Alimentation) : ");
        System.out.println("Viande et Poisson : " + viandePoisson);
        System.out.println("Produits laitiers et oeuf : " + produitsLaitiersOeuf);
        System.out.println("Boissons : " + boissons);
        System.out.println("Autres : " + autres);
        System.out.println("Somme: " + sum + "\n");
    }

    @Override
    public String toString() {
        return "Alimentation{" +
                "txBoeuf=" + txBoeuf +
                ", txVege=" + txVege +
                ", txVolaille=" + txVolaille +
                " " + super.toString() +
                "}\n";
    }
}
