public class MAI {
    public static void main(String[] args){
        float[][] a = new float[5][5];
        double[][] K = {
                {1, 0.25, 0.5, 5, 1.0/6},
                {4, 1, 2, 7, 0.25},
                {2, 0.5, 1, 6, 0.2},
                {1.0/5, 1.0/7, 1.0/6, 1, 1.0/9},
                {6, 4, 5, 9, 1}
        };
        double[][][] k = {{
                {1, 0.2, 1.0/3, 0.5, 4},
                {5, 1, 5, 6, 7},
                {3, 0.2, 1, 2, 6},
                {2, 0.2, 1.0/6, 1, 5},
                {0.25, 1.0/7, 1.0/6, 0.2, 1}},
                {
                        {1, 1.0/7, 0.2, 0.25, 0.25},
                        {7, 1, 4, 5, 5},
                        {5, 0.25, 1, 2, 2},
                        {4, 0.2, 0.5, 1, 1},
                        {4, 0.2, 0.5, 1, 1}},
                {
                        {1, 7, 8, 9, 8},
                        {1.0/7, 1, 4, 5, 4},
                        {1.0/8, 0.25, 1, 2, 1},
                        {1.0/9, 0.2, 0.5, 1, 0.5},
                        {1.0/8, 0.25, 1, 2, 1}},
                {
                        {1, 6, 5, 3, 3},
                        {1.0/6, 1, 0.5, 0.25, 0.25},
                        {0.2, 2, 1, 1.0/3, 1.0/3},
                        {1.0/3, 4, 3, 1, 1},
                        {1.0/3, 4, 3, 1, 1}},
                {
                        {1, 8, 7, 5, 6},
                        {1.0/8, 1, 0.5, 0.2, 1.0/3},
                        {1.0/7, 2, 1, 0.25, 0.5},
                        {0.2, 5, 4, 1, 3},
                        {1.0/6, 3, 2, 1.0/3, 1}}
        };
        double[] S = new double[5];
        double P;
        double[] V = new double[5];
        double[] W2 = new double[5];//Вектор приоритетов
        double Vi;
        for(int i = 0; i < 5; i++) {
            V[i] = 1;
            S[i] = 0;
            for (int j = 0; j < 5; j++) {
                V[i] *= K[i][j];
                S[i] += K[j][i];
            }
            V[i] = Math.pow(V[i], (double)1/5);
        }
        Vi = V[0] + V[1] + V[2] + V[3] + V[4];
        P = 0;
        for(int i = 0; i < 5; i++) {
            W2[i] = V[i] / Vi;
            P += (S[i] * W2[i]);
        }
        System.out.println(" Цель |  K1  |  K2  |  K3  |  K4  |  K5  |  Vi  |  W2i |");
        for(int i = 0; i < 5; i++) {
            System.out.printf("  K%d  |", i+1);
            for (int j = 0; j < 5; j++) {
                System.out.printf("%6.2f|", K[i][j]);
            }
            System.out.printf("%6.2f|", V[i]);
            System.out.printf("%6.2f|\n", W2[i]);
        }
        System.out.printf("Vi = %6.2f\n", Vi);
        if((((P - 5)/4)/1.12) <= 0.10)
            System.out.println("Матрица согласована.");
        else System.out.println("Матрица не согласована.");
        //--------------------------------------------Ki
        double[][] Vk = new double[5][5];
        double[][] W3k = new double[5][5];//Вектор приоритетов
        double[] Vki = new double[5];
        for(int l = 0; l < 5; l++) {
            P = 0;
            for (int i = 0; i < 5; i++) {
                Vk[l][i] = 1;
                S[i] = 0;
                for (int j = 0; j < 5; j++) {
                    Vk[l][i] *= k[l][i][j];
                    S[i] += k[l][j][i];
                }
                Vk[l][i] = Math.pow(Vk[l][i], (double) 1 / 5);
            }
            Vki[l] = Vk[l][0] + Vk[l][1] + Vk[l][2] + Vk[l][3] + Vk[l][4];
            for (int i = 0; i < 5; i++) {
                W3k[l][i] = Vk[l][i] / Vki[l];
                P += (S[i] * W3k[l][i]);
            }
            System.out.printf("  K%d  |  A1  |  A2  |  A3  |  A4  |  A5  |  Vk%d | W3k%d |\n", l+1, l+1, l+1);
            for (int i = 0; i < 5; i++) {
                System.out.printf("  A%d  |", i + 1);
                for (int j = 0; j < 5; j++) {
                    System.out.printf("%6.2f|", k[l][i][j]);
                }
                System.out.printf("%6.2f|", Vk[l][i]);
                System.out.printf("%6.2f|\n", W3k[l][i]);
            }
            System.out.printf("Vk%d = %6.2f\n", l+1, Vki[l]);
            if((((P - 5)/4)/1.12) <= 0.10)
                System.out.println("Матрица согласована.\n");
            else System.out.println("Матрица не согласована.\n");
        }
        double[] W = new double[5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++) {
                W[i] += W2[j]*W3k[j][i];
            }
        }
        System.out.println("Таким образом, приоритеты альтернатив равны:");
        int x = 0;
        for(int i = 0; i < 5; i++){
            System.out.printf("A%d: W%d = %.3f\n", i+1, i+1, W[i]);
            if(W[x] < W[i])
                x = i;
        }
        System.out.println("Следовательно, наиболее перспективным с позиции" +
                " метода анализа иерархий признается выбор альтернативы А" + (x+1));
    }
}

