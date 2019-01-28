public class ZLP {

    public static void main(String[] args) {

        double[] a1 = {16, 1/5, 6, 3};
        double[] a2 = {12, 2/5, 5, 4};
        double[] a0 = {1200, 30, 600, 300};

        double[][] c = {
                {0, 1, 2, 0},
                {3, 16, 12, 1200},
                {4, 0.2, 0.4, 30},
                {5, 6, 5, 600},
                {6, 3, 4, 300},
                {0, 0, 0, 0}};

        double[] cj = {260, 300};

        double[] cb = {0, 0, 0, 0};

        for (int i = 0; i < 4; i++) {
            c[5][1] += cb[i] * a1[i];
            c[5][2] += cb[i] * a2[i];
            c[5][3] += cb[i] * a0[i];
        }
        c[5][1] -= cj[0];
        c[5][2] -= cj[1];

        //вывод таблицы на экран
        System.out.printf("______Cj_|%5.0f|%5.0f|_____|\n", cj[0], cj[1]);
        System.out.printf("Cb_|_____|_x%1.0f__|_x%1.0f__|_A%1.0f__|\n", c[0][1], c[0][2], c[0][3]);
        for (int i = 1; i < 5; i++) {
            System.out.printf("%3.0f|_x%1.0f__|", cb[i-1], c[i][0]);
            for (int j = 1; j < 4; j++) {
                System.out.printf("%5.1f|", c[i][j]);
            }
            System.out.printf("\n");
        }
        System.out.printf("___|__f__|%5.0f|%5.0f|%5.0f|\n\n", c[5][1], c[5][2], c[5][3]);

        double[] tmp = new double[4];

        while ((c[5][1] < 0) || (c[5][2] < 0)) {
            //поиск разрешающего столбца и разрешающей строки
            int n; //разрешающий столбец
            if (c[5][1] < c[5][2])
                n = 1;
            else
                n = 2;
            for (int i = 1; i < 5; i++) {
                if (c[i][n] > 0)
                    tmp[i - 1] = c[i][3] / c[i][n];
                else
                    tmp[i - 1] = 999.00;
            }
            int m = 1; //разрешающая строка
            for (int i = 1; i < 4; i++) {
                if (tmp[0] > tmp[i]) {
                    tmp[0] = tmp[i];
                    m = i + 1;
                }
            }
            //заполняем новую таблицу
            for (int i = 1; i < 6; i++) {
                for (int j = 1; j < 4; j++) {
                    if ((i != m) && (j != n))
                        c[i][j] = (c[i][j] * c[m][n] - c[i][n] * c[m][j]) / c[m][n];
                }
            }
            for (int i = 1; i < 6; i++) {
                for (int j = 1; j < 4; j++) {
                    if ((i == m) && (j != n))
                        c[i][j] /= c[m][n];
                    if ((i != m) && (j == n))
                        c[i][j] /= c[m][n] * (-1);
                }
            }
            //меняем местами иксы и переворачиваем разрешающий элемент
            double x;
            x = c[0][n];
            c[0][n] = c[m][0];
            c[m][0] = x;
            x = cj[n-1];
            cj[n-1] = cb[m-1];
            cb[m-1] = x;
            c[m][n] = 1 / c[m][n];
            //вывод таблицы на экран
            System.out.printf("______Cj_|%5.0f|%5.0f|_____|\n", cj[0], cj[1]);
            System.out.printf("Cb_|_____|_x%1.0f__|_x%1.0f__|_A%1.0f__|\n", c[0][1], c[0][2], c[0][3]);
            for (int i = 1; i < 5; i++) {
                System.out.printf("%3.0f|_x%1.0f__|", cb[i-1], c[i][0]);
                for (int j = 1; j < 4; j++) {
                    System.out.printf("%5.1f|", c[i][j]);
                }
                System.out.printf("\n");
            }
            System.out.printf("___|__f__|%5.0f|%5.0f|%5.1f|\n\n", c[5][1], c[5][2], c[5][3]);
        }
        System.out.printf("Ответ: f(x) = %.1f, x1 = %.1f, x2 = %.1f.", c[5][3], c[4][3], c[2][3]);
    }
}
