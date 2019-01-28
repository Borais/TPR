package com.company;

public class CountryAlternatives {
    private String Country;
    private int GDP;//+ tallent
    private int RetirementAge;//+ endurance
    private  int AverageLivingWage;//+ agility
    private int Crime;//- age
    private int Taxes;//- price
    private int prevail = 0;
    private int criteryCounter = 0;

    CountryAlternatives(String Country, int GDP,int Taxes, int RetirementAge, int AverageLivingWage, int Crime){
        this.Country = Country;
        this.GDP = GDP;
        this.Taxes = Taxes;
        this.RetirementAge = RetirementAge;
        this.AverageLivingWage = AverageLivingWage;
        this.Crime = Crime;
    }

    public void setGDP(int GDP) {

        this.GDP = GDP;
    }

    public int getGDP() {

        return GDP;
    }

    public void setRetirementAge(int RetirementAge) {

        this.RetirementAge = RetirementAge;
    }

    public int getRetirementAge() {

        return RetirementAge;
    }

    public void setAverageLivingWage(int AverageLivingWage) {

        this.AverageLivingWage = AverageLivingWage;
    }

    public int getAverageLivingWage() {

        return AverageLivingWage;
    }

    public void setCrime(int age) {

        this.Crime = age;
    }

    public int getCrime() {

        return Crime;
    }

    public void setTaxes(int Taxes) {

        this.Taxes = Taxes;
    }

    public int getTaxes() {
        return Taxes;
    }

    public void setCriteryCounter(int criteryCounter) {

        this.criteryCounter = criteryCounter;
    }

    public int getCriteryCounter() {

        return criteryCounter;
    }

    public void setPrevail(int prevail) {

        this.prevail = prevail;
    }

    public int getPrevail() {

        return prevail;
    }

    @Override
    public String toString(){
        return  this.Country + ":" +this.GDP + "," + this.Taxes + "," + this.RetirementAge + "," + this.AverageLivingWage + "," + this.Crime;

    }
}
