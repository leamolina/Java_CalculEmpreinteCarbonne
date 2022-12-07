package consoCarbonne;

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

    public int getId() {
        return this.id;
    }
    public double getImpact() {
        return impact;
    }

    //Setters
    public void setId(int counter) {
        if(counter<0) System.out.println("La valeur ID n'est pas possible");
        else this.id = counter;
    }
    public void setImpact(double impact) {
        this.impact = impact;
    }

    /*
    public void abstract setCalculImpact(){
    }
     */

    @Override
    public String toString() {
        return "ConsoCarbonne{" +
                "id=" + id +
                ", impact=" + impact +

                "}";
    }



    @Override
    public int compareTo(ConsoCarbonne c) {
        if (this.impact < c.impact) {
            return -1;
        }
        if (this.impact == c.impact) {
            return 0;
        }
        return 1;
    }
}
