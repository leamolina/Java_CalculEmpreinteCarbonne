package consoCarbonne;

import Erreurs.ErrValNeg;

/**
 * La classe ServicesPublics represente le poste de consommation carbone induit par les services publics (justice, police, éducation, sante, ...).
 * NB: Ce poste de consommation carbone à la particularité que tou.te.s les Français ont la meme empreinte de 1.5TCO2eq pour ce poste de consommation.
 */
public final class ServicesPublic extends ConsoCarbonne{

    private static ServicesPublic instance;

    static {
        try {
            instance = new ServicesPublic();
        } catch (ErrValNeg e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Cette methode fixe (elle est la meme pour tous les Francais) l'empreinte carbonne du poste de consommation ServicesPublics
     */
    private ServicesPublic() throws ErrValNeg {
        super();
        super.setImpact(1.5);
    }


    public static ServicesPublic getInstance() throws ErrValNeg {
        if (instance == null) {
            instance = new ServicesPublic();
        }
        return instance;
    }
}

