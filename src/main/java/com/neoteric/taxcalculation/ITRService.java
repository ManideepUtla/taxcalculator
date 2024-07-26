package com.neoteric.taxcalculation;

public class ITRService {
    public double TaxCalculation;

    // Method to select the ITR form and calculate tax
    public String selectFormAndCalculateTax(ItrForm form) {
        Calculation taxService = new Calculation();

        String selectedForm = "";
        if (form.annualIncome <= 5000000 && !form.hasMultipleProperties && !form.hasOtherHouse && !form.hasSaleOfInvestment
                && !form.hasForeignSources && !form.hasAgricultureIncome && !form.isPartnershipFirmIncome && !form.isBusinessProfessionIncome
                && !form.hasPresumptiveIncome && !form.isFirm) {
            selectedForm = "ITR Form 1";
            TaxCalculation = taxService.TaxCalculation(form.annualIncome);
        } else if (form.hasMultipleProperties || form.hasOtherHouse || form.hasSaleOfInvestment
                || form.hasForeignSources || form.hasAgricultureIncome) {
            selectedForm = "ITR Form 2";
            TaxCalculation = taxService.TaxCalculation(form.annualIncome, false, false,
                    false, false, form.annualIncome > 5000000);
        } else if (form.isPartnershipFirmIncome || form.isBusinessProfessionIncome) {
            selectedForm = "ITR Form 3";
            TaxCalculation = taxService.TaxCalculation(form.annualIncome, false, false,
                    false, true);
        } else if (form.hasPresumptiveIncome) {
            selectedForm = "ITR Form 4";
            TaxCalculation = taxService.TaxCalculation(form.annualIncome, false,
                    false, true);
        } else if (form.isFirm) {
            selectedForm = "ITR Form 5";
            TaxCalculation = taxService.TaxCalculation(form.annualIncome, false, true);
        }
        return selectedForm;
    }

    public double getCalculatedTax() {
        return TaxCalculation;
    }


}
