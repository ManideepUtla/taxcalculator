package com.neoteric.taxcalculation;

public class Calculation {

    public double TaxCalculation(int annualIncome) {
        double tax = 0;
        if (annualIncome <= 300000) {
            tax = 0;
        } else if (annualIncome <= 600000) {
            tax = (annualIncome - 300000) * 0.05;
        } else if (annualIncome <= 900000) {
            tax = (300000 * 0.05) + ((annualIncome - 600000) * 0.10);
        } else if (annualIncome<=1200000){
            tax = (300000 * 0.05) + (600000 * 0.10) + ((annualIncome - 900000) * 0.15);
        } else if (annualIncome<=1500000){
            tax= (300000*0.05)+(600000*0.15)+(900000*0.15)+((annualIncome-1200000)*0.20);
        } else {
            tax= (300000*0.05)+(600000*0.10)+(900000*0.15)+((annualIncome-1500000)*0.30);
        }

        return tax;
    }

    // This method is for ITR-2
    public double TaxCalculation(int annualIncome, boolean isCompany, boolean isFirm,
                               boolean hasPresumptiveIncome, boolean isPartnershipFirmIncome, boolean isHighIncome) {
        double tax;

        if (annualIncome > 5000000) {
            tax = 0.1 * annualIncome;
        } else {
            tax = 0.15 * annualIncome;
        }

        return tax;
    }

    // This method is for ITR-3
    public double TaxCalculation(int annualIncome, boolean isCompany, boolean isFirm,
                               boolean hasPresumptiveIncome, boolean isPartnershipFirmIncome) {
        double tax;

        if (annualIncome > 10000000) {
            tax = 0.15 * annualIncome;
        } else {
            tax = 0.25 * annualIncome;
        }

        return tax;
    }

    //this method is for ITR-4
    public double TaxCalculation(int annualIncome, boolean isCompany,
                               boolean isFirm, boolean hasPresumptiveIncome) {
        double tax;

        if (annualIncome > 20000000) {
            tax = 0.25 * annualIncome;
        } else {
            tax = 0.37 * annualIncome;
        }

        return tax;
    }

    //this method is for ITR-5
    public double TaxCalculation(int annualIncome, boolean isCompany, boolean isFirm) {
        double tax = annualIncome * 0.37;
        return tax;
    }
}
