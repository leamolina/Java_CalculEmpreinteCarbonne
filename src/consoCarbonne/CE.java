package consoCarbonne;

public enum CE {
    A, B, C, D, E, F, G;

    //Methode qui renvoie le coefficient multiplicatif
    public static double coefCE (CE ce){
        double coef;
        switch (ce){
            case A :
                coef = 0.005;
                break;
            case B:
                coef = 0.01;
                break;
            case C :
                coef = 0.02;
                break;
            case D :
                coef = 0.035;
                break;
            case E:
                coef = 0.055;
                break;
            case F :
                coef = 0.08;
                break;
            case G:
                coef = 0.1;
                break;
            default :
                coef = 0.0;
        }
        return coef;
    }


}

