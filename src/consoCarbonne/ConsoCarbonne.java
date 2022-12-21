package consoCarbonne;

/**
 * La classe ConsoCarbonne représente un poste de consommation carbone générique.
 * Elle est la classe mere de toutes les autres.
 * C'est elle qui nous donne l'empreinte carbone de chaque objet qu'utilise un Francais en fonction de son mode de vie.
 */
public abstract class ConsoCarbonne implements Comparable<ConsoCarbonne>  {



    //Constructeur
    public ConsoCarbonne() {
        ConsoCarbonne.counter += 1;
        setId(ConsoCarbonne.counter);
    }
    private double impact = 0 ;
    private int id = 0;
    private static int counter = 0;

    //Getters

    /**
     * @return l'ID correspondant a un iddentifiant unique attribue a l'instance ConsoCarbonne.
     */
    public int getId() {
        return this.id;
    }

    /**
     * @return L'impact de chaque poste de consommation.
     */
    public double getImpact() {
        return impact;
    }

    /**
     *Methode permettant de verifier que l'ID existe et de le fixer.
     * @param counter
     */

    //Setters
    public void setId(int counter) {
        if(counter<0) System.out.println("La valeur ID n'est pas possible");
        else this.id = counter;
    }

    /**
     *Methode permerttant de fixer l'impact
     * @param impact
     */
    public void setImpact(double impact) {
        this.impact = impact;
    }

    /*
    public void abstract setCalculImpact(){
    }
     */

    /**
     * @return une chaîne contenant les informations de la classe ConsoCarbonne en affichant l'ID  attribue a l'instance ConsoCarbonne associe ainsi que son impact
     */
    @Override
    public String toString() {
        return "ConsoCarbonne{" +
                "id=" + id +
                ", impact=" + impact +

                "}";
    }


    /**
     * @param c the object to be compared.
     * @return -1 si la valeur placée en argument est inferieur a c, 0 si elles sont egales, 1 sinon
     */
    @Override
    public int compareTo(ConsoCarbonne c) {
        return Double.compare(this.impact, c.impact);
    }
}
