package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        ArrayList<CountryAlternatives> cAlt = new ArrayList<>();


        cAlt.add(new CountryAlternatives("Great Britain",120000,10,50,90000,1));
        cAlt.add(new CountryAlternatives("France",100000,12,60,80000,1));
        cAlt.add(new CountryAlternatives("Belgium",110000,13,80,80000,2));
        cAlt.add(new CountryAlternatives("Germany",90000,15,75,40000,3));
        cAlt.add(new CountryAlternatives("Italy",50000,18,65,30000,6));
        cAlt.add(new CountryAlternatives("Russia",80000,19,75,67000,2));
        cAlt.add(new CountryAlternatives("Spain",90000,20,60,80000,7));
        cAlt.add(new CountryAlternatives("Netherlands",90000,16,90,80000,8));
        cAlt.add(new CountryAlternatives("USA",30000,14,90,80000,7));
        cAlt.add(new CountryAlternatives("Brazil",50000,18,73,30000,10));
        
        double[][] matrix =  new double[10][10];
        double TaxesW = 15, GDPW = 15,CrimeW = 10 ,AverageLivingWageW = 10, RetirementAgeW = 5 ;
        double p, n;
        for (int s = 0; s < cAlt.size(); s++){
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++) {

                    if (i == j)
                        matrix[i][j] = 0;
                    else {
                        p = 0;
                        n = 0;

                        if (cAlt.get(i).getTaxes() < cAlt.get(j).getTaxes())
                            p += TaxesW;
                        else if ((cAlt.get(i).getTaxes() > cAlt.get(j).getTaxes()))
                            n += TaxesW;

                        if (cAlt.get(i).getGDP() > cAlt.get(j).getGDP())
                            p += GDPW;
                        else if ((cAlt.get(i).getGDP() < cAlt.get(j).getGDP()))
                            n += GDPW;

                        if (cAlt.get(i).getCrime() < cAlt.get(j).getCrime())
                            p += CrimeW;
                        else if ((cAlt.get(i).getCrime() > cAlt.get(j).getCrime()))
                            n += CrimeW;

                        if (cAlt.get(i).getAverageLivingWage() > cAlt.get(j).getAverageLivingWage())
                            p += AverageLivingWageW;
                        else if ((cAlt.get(i).getAverageLivingWage() < cAlt.get(j).getAverageLivingWage()))
                            n += AverageLivingWageW;

                        if (cAlt.get(i).getRetirementAge() < cAlt.get(j).getRetirementAge())
                            p += RetirementAgeW;
                        else if ((cAlt.get(i).getRetirementAge() > cAlt.get(j).getRetirementAge()))
                            n += RetirementAgeW;

                        if (n > 0)
                            if ((p / n) > 1)
                                matrix[i][j] =  p / n;
                            else if(n < 0)
                                matrix[i][j] = -1.0;
                    }
                }
            }
        }

        System.out.print("__|  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  |  10 |");
        for(int i = 0; i < 10; i++) {
            System.out.printf("\n%2d|", i+1);
            for (int j = 0; j < 10; j++)
                System.out.printf("%5.2f|", matrix[i][j]);
        }

        double c = 1.0;
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrix[i][j] < c)
                    matrix[i][j] = 0.0;
            }
        }

        int x = 0;//флаг
        int y = 0;//флаг
        System.out.print("\nЛучшие альтернативы:");
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matrix[j][i] > 0.0)
                    x++;
            }
            if (x == 0) {
                System.out.printf("A%d ", i + 1);
                y++;
            }
            x = 0;
        }
        if(y == 0)
            System.out.println("Порог оказался слишком низким. Лучшие альтернативы не выявлены.");

    }
}
