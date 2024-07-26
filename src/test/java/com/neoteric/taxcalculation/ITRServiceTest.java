package com.neoteric.taxcalculation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ITRServiceTest {

    @Test
    public void testITR1() {
        ItrForm form = new ItrForm(/*400000*/);

        ITRService service = new ITRService();
        String formSelected = service.selectFormAndCalculateTax(form);

        assertEquals("ITR Form 1", formSelected);
        assertEquals(7500, service.getCalculatedTax());
    }

    @Test
    public void testITR2() {
        ItrForm form = new ItrForm(/*6000000, true, false, false, false, false*/);

        ITRService service = new ITRService();
        String formSelected = service.selectFormAndCalculateTax(form);

        assertEquals("ITR Form 2", formSelected);
        assertEquals(1800000, service.getCalculatedTax());
    }

    @Test
    public void testITR3() {
        ItrForm form = new ItrForm(/*7000000, false, true, false*/);

        ITRService service = new ITRService();
        String formSelected = service.selectFormAndCalculateTax(form);

        assertEquals("ITR Form 3", formSelected);
        assertEquals(2100000, service.getCalculatedTax());
    }

    @Test
    public void testITR4() {
        ItrForm form = new ItrForm(/*800000, false, false, true*/);

        ITRService service = new ITRService();
        String formSelected = service.selectFormAndCalculateTax(form);

        assertEquals("ITR Form 4", formSelected);
        assertEquals(160000, service.getCalculatedTax());
    }

    @Test
    public void testITR5() {
        ItrForm form = new ItrForm(/*true*/);
        form.annualIncome = 5000000;

        ITRService service = new ITRService();
        String formSelected = service.selectFormAndCalculateTax(form);

        assertEquals("ITR Form 5", formSelected);
        assertEquals(1500000, service.getCalculatedTax());
    }

    @Test
    public void testITR2LowIncome() {
        ItrForm form = new ItrForm(/*4000000, false, false, false, true, false*/);

        ITRService service = new ITRService();
        String formSelected = service.selectFormAndCalculateTax(form);

        assertEquals("ITR Form 2", formSelected);
        assertEquals(800000, service.getCalculatedTax());
    }
}