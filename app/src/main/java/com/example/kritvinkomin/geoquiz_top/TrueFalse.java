package com.example.kritvinkomin.geoquiz_top;

/**
 * Created by kritvinkomin on 9/20/15.
 */
public class TrueFalse {
    int mQuestion;
    boolean mtrueQuestion;


    public TrueFalse (int question , boolean trueQuestion){
        mQuestion = question;
        mtrueQuestion = trueQuestion;
    }

    public int getQuestion(){
        return  mQuestion;
    }
    public boolean isTrueQuestion (){
        return mtrueQuestion;
    }


}
