package com.example.itocheck.model;

public class Calc implements ICalc{


/*
    public static final int NORMAL = 3;
    public static final int REGULAR = 2;
    public static final int MALAS = 1;
*/
    public static final int LUCES_APART = 10;
    public static final int ELEM_BANO = 40;
    public static final int ELEM_COCINA =30;
    public static final int ELEM_DORM = 20;


    @Override
    public int scoreCalculation(boolean a, boolean b, boolean c, boolean d, int e) {
        int score =0;
        if (a) score+=LUCES_APART;
        if (b) score+=ELEM_BANO;
        if (c) score+=ELEM_COCINA;
        if (d) score+=ELEM_DORM;
        return score*e;
    }


}
