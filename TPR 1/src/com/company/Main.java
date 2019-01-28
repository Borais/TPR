package com.company;



public class Main {

    public static void main(String[] args) {
        CountrysAlternatives[] sAlt = new CountrysAlternatives[10];

        CountrysAlternatives[] sAltSort = new CountrysAlternatives[10];

        CountrysAlternatives[] sAltSorted = new CountrysAlternatives[10];



        //список стран-альтернатив

        //Alt1
        sAlt[0] = new CountrysAlternatives();
        sAlt[0].setAverageLivingWage(90000);
        sAlt[0].setGDP(120000);
        sAlt[0].setCrimelvl(1);
        sAlt[0].setTaxes(10);
        sAlt[0].setRetirementAge(50);

        //Alt2
        sAlt[1] = new CountrysAlternatives();
        sAlt[1].setAverageLivingWage(80000);
        sAlt[1].setGDP(100000);
        sAlt[1].setCrimelvl(1);
        sAlt[1].setTaxes(12);
        sAlt[1].setRetirementAge(60);

        //Alt3
        sAlt[2] = new CountrysAlternatives();
        sAlt[2].setAverageLivingWage(80000);
        sAlt[2].setGDP(110000);
        sAlt[2].setCrimelvl(2);
        sAlt[2].setTaxes(13);
        sAlt[2].setRetirementAge(80);

        //Alt4
        sAlt[3] = new CountrysAlternatives();
        sAlt[3].setAverageLivingWage(40000);
        sAlt[3].setGDP(90000);
        sAlt[3].setCrimelvl(3);
        sAlt[3].setTaxes(15);
        sAlt[3].setRetirementAge(75);

        //Alt5
        sAlt[4] = new CountrysAlternatives();
        sAlt[4].setAverageLivingWage(30000);
        sAlt[4].setGDP(50000);
        sAlt[4].setCrimelvl(6);
        sAlt[4].setTaxes(18);
        sAlt[4].setRetirementAge(65);

        //Alt6
        sAlt[5] = new CountrysAlternatives();
        sAlt[5].setAverageLivingWage(67000);
        sAlt[5].setGDP(80000);
        sAlt[5].setCrimelvl(2);
        sAlt[5].setTaxes(19);
        sAlt[5].setRetirementAge(75);

        //Alt7
        sAlt[6] = new CountrysAlternatives();
        sAlt[6].setAverageLivingWage(80000);
        sAlt[6].setGDP(900000);
        sAlt[6].setCrimelvl(7);
        sAlt[6].setTaxes(20);
        sAlt[6].setRetirementAge(60);

        //Alt8
        sAlt[7] = new CountrysAlternatives();
        sAlt[7].setAverageLivingWage(80000);
        sAlt[7].setGDP(900000);
        sAlt[7].setCrimelvl(8);
        sAlt[7].setTaxes(16);
        sAlt[7].setRetirementAge(90);

        //Alt9
        sAlt[8] = new CountrysAlternatives();
        sAlt[8].setAverageLivingWage(80000);
        sAlt[8].setGDP(30000);
        sAlt[8].setCrimelvl(7);
        sAlt[8].setTaxes(14);
        sAlt[8].setRetirementAge(90);

        //Alt10
        sAlt[9] = new CountrysAlternatives();
        sAlt[9].setAverageLivingWage(30000);
        sAlt[9].setGDP(50000);
        sAlt[9].setCrimelvl(10);
        sAlt[9].setTaxes(18);
        sAlt[9].setRetirementAge(73);


        //циклы для сравнения критериев альтернатив
        for(int i = 0; i < 10; i++){

            for(int j = 1; j < 10; j++ ){

                if(sAlt[i].getRetirementAge() <= sAlt[j].getRetirementAge()){

                    sAlt[i].setCriteryCounter(+1);

                }else{sAlt[j].setCriteryCounter(+1); }

                if(sAlt[i].getCrimelvl() <= sAlt[j].getCrimelvl()){
                    sAlt[j].setCriteryCounter(+1);

                }else  { sAlt[i].setCriteryCounter(+1);}

                if(sAlt[i].getGDP() >= sAlt[j].getGDP()){
                    sAlt[j].setCriteryCounter(+1);

                }else  {sAlt[i].setCriteryCounter(+1);}

                if(sAlt[i].getTaxes() <= sAlt[j].getTaxes()){
                    sAlt[j].setCriteryCounter(+1);

                }else  { sAlt[i].setCriteryCounter(+1);}

                if(sAlt[i].getAverageLivingWage() >= sAlt[j].getAverageLivingWage()){
                    sAlt[j].setCriteryCounter(+1);

                }else  {sAlt[j].setCriteryCounter(+1);}

                if(sAlt[i].getCriteryCounter() >= 5){
                    sAlt[j].prevail +=1;
                }
                if(sAlt[j].getCriteryCounter() >=5){
                    sAlt[i].prevail +=1;
                }

            }
        }

        for(int i =0;i < 10; i++){

            if(sAlt[i].prevail == 0){
                sAltSort[i] = new CountrysAlternatives();
                sAltSort[i] = sAlt[i];
            }

        }




        //сравнение по  сравнительной планке
            СALevel сaLevel = new СALevel();
        for(int i = 0; i < sAltSort.length; i++){
            if((sAltSort[i].getAverageLivingWage() >= сaLevel.AverageLivingWageReach)//+
                    && (sAltSort[i].getTaxes() <= сaLevel.TaxesReach)//-
                    && (sAltSort[i].getGDP() >= сaLevel.GDPReach)//+
                    &&(sAltSort[i].getCrimelvl() <= сaLevel.CrimelvlReach)//-
                    && (sAltSort[i].getRetirementAge() <= сaLevel.RetirementAgeReach)){//-
                if(sAltSort[i] !=null){
                    sAltSorted[i] = new CountrysAlternatives();

                sAltSorted[i] = sAltSort[i];
            }else break;
        }


            if (sAltSorted[0] == null){
                System.out.println("All Aternatives List is empty");
            }else
                if(sAltSorted[1] == null){System.out.printf("\n Alternative number:%d \n Retirement Age: %d \n Average Living Wage:%d \n Crime Level: %d \n Taxes:%d \n GDP:%d \n \n It's the best country to live in \n" , 1, sAltSorted[0].getRetirementAge(), sAltSorted[0].getAverageLivingWage(), sAltSorted[0].getCrimelvl(), sAltSorted[0].getTaxes(), sAltSorted[0].getGDP());}
                else{





                int z = 0;
                for(int ir = 0; ir < sAltSorted.length; ir++){
                    for (int j =1; j< sAltSorted.length; j++){
                        if(sAltSorted[ir].getAverageLivingWage() > sAltSorted[j].getAverageLivingWage()){
                            z++;
                        }
                    }
                    if(z == sAltSorted.length){
                        System.out.println(sAltSorted[i]);
                    }else {z = 0;}
                }

                for(int id = 0; id < 10; id++){
                    System.out.printf("\n Alternative number:%d \n Retirement Age: %d \n Average Living Wage:%d \n crime Level:%d \n Taxes:%d \n GDP:%d \n \n It's the best country to live in \n " , id, sAltSorted[id].getRetirementAge(), sAltSorted[id].getAverageLivingWage(), sAltSorted[id].getCrimelvl(), sAltSorted[id].getTaxes(), sAltSorted[id].getGDP());
                }
            }

    }
}
}

