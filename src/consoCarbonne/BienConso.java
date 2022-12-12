package consoCarbonne;

public class BienConso extends ConsoCarbonne{
    //Constructeur
    public BienConso(){}
    public BienConso(double montant){
        setMontant(montant);
        setCalculImpact();
    }
    private double montant = 0.0;

    //Getters
    public double getMontant() {
        return montant;
    }

    //Setters
    public void setMontant(double montant) {
        if( montant < 0) System.out.println("Le montant ne peut etre negatif ");
        else {
            this.montant = montant;
            setCalculImpact();
        }
    }

    public void setCalculImpact (){
        super.setImpact((1.0/1750.0)*this.montant);
    }

    public static void EmpreinteBienConso(){
        int habillement = 763;
        int autres = 682 ;
        int achatInternetTech = 1180;
        int sum = habillement + autres + achatInternetTech;
        System.out.println("Details de l empreinte carbonne moyenne d un francais (BienConso) : ");
        System.out.println("Habillement : " + habillement);
        System.out.println("Autres biens et services : " + autres);
        System.out.println("Achats et usages Internet et technologies: " + achatInternetTech);
        System.out.println("Somme: " + sum + "\n");

    }

    @Override
    public String toString() {
        return "BienConso{" +
                "montant=" + montant +
                "  " +super.toString() +
                "}\n";
    }
}
