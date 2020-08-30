package com.example.itocheck.presenter;

import com.example.itocheck.model.Calc;

public class Presenter implements IPresenter{
    private Calc calc;
    private IViewPresenter view;
    int score=0;

    public Presenter(IViewPresenter view) {
        this.view = view;
        calc = new Calc();
     }

    @Override
    public void calculationScore(boolean a, boolean b, boolean c, boolean d, int e) {
        score = calc.scoreCalculation(a,b,c,d,e);
        if (score<LIMITE) this.view.showAlert(score);
        else this.view.showNormal(score);
    }
}