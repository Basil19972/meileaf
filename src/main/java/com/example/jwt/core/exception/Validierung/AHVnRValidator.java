package com.example.jwt.core.exception.Validierung;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Collections;

public class AHVnRValidator implements ConstraintValidator<AHVNrValidation, String> {

    @Override
    public void initialize(AHVNrValidation ahvNrValidation) {
    }

    @Override
    public boolean isValid(String contactField, ConstraintValidatorContext cxt) {

        String AHVNr = contactField.toString();
       String AHVNrnew = AHVNr.replace("." ,"");

        char[] AHVNrchars = AHVNrnew.toCharArray();
        ArrayList<Integer> AHVNrOriginal = new ArrayList<Integer>();
        ArrayList<Integer> AHVNrinarraywhitout = new ArrayList<Integer>();
        ArrayList<Integer> AHVNRCalc = new ArrayList<Integer>();


        //Fill OrArray
        for(int i = 0; i< AHVNrchars.length; i++){
            Integer Zahl = Integer.parseInt(String.valueOf(AHVNrchars[i]));
            AHVNrOriginal.add(Zahl);
        }

        //Fill WhitoutArray
        for(int i = 0; i< AHVNrchars.length-1; i++){
            Integer Zahl = Integer.parseInt(String.valueOf(AHVNrchars[i]));
            AHVNrinarraywhitout.add(Zahl);
        }
        //Arraylit reverse
        Collections.reverse(AHVNrinarraywhitout);

        //Multiplications
        for (int i = 0; i < AHVNrinarraywhitout.size(); i++) {

            if(i %2 == 0){
               int z1 = AHVNrinarraywhitout.get(i);
                int z2 = z1 * 3;
                AHVNRCalc.add(z2);
                AHVNRCalc.add(AHVNrinarraywhitout.get(i+1));
            }

        }


        //Summe
        int sum = 0;
        for(int i = 0; i < AHVNRCalc.size(); i++) {
            sum += AHVNRCalc.get(i);
        }



        int prüfziffer;
        if(sum %10 == 0){
            prüfziffer = 0;
        }else{
            prüfziffer = 10 - sum%10;
        }

        //nCheck if Prüffsumme is valid
        Boolean CalcValid = false;
        if (prüfziffer == AHVNrOriginal.get(AHVNrOriginal.size()-1)){
            CalcValid = true;
        }



        return contactField != null && contactField.matches("^756\\.(\\d{4})\\.(\\d{4})\\.(\\d{2})$")
                && CalcValid == true;

    }
}
