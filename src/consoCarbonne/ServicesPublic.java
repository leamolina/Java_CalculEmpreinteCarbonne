package consoCarbonne;

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

