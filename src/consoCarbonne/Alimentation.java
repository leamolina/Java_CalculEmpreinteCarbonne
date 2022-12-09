package consoCarbonne;

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

    //Setters
    public void setTxBoeuf (double tb){
        if(tb >=0 && tb <=1) {
            this.txBoeuf = tb;
            setCalculImpact();
        }
        else System.out.println("Erreur : le taux de repas a base de boeuf doit etre compris entre 0 et 1");
    }
    public void setTxVege (double tv){
        if(tv >=0 && tv <=1) {
            this.txVege = tv;
            setCalculImpact();
        }
        else System.out.println("Erreur : le taux de repas vegetarien doit etre compris entre 0 et 1");
    }
    public void setTxVolaille (double tb, double tv){
        double tVo = 1 - tb - tv;
        if(tVo >=0 && tVo <=1) {
            this.txVolaille = tVo;
            setCalculImpact();
        }
        else System.out.println("Erreur : le taux de repas à base de volaille doit etre compris entre 0 et 1");
    }
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


    //Methode detaillant l empreinte carbonne moyenne d un francais dans ce domaine
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
