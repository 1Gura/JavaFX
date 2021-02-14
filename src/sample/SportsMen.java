package sample;

public class SportsMen {
    private int n; //километры
    private int m; //проценты дневной нормы
    private int k; //кол-во дней

    public SportsMen(int n, int m, int k) {
        this.n = n;
        this.m = m;
        this.k = k;
    }

    double[] getSum() {
        double array[] = new double[2];
        double temp = this.n;
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 1; i < this.k; i++) {
            temp = temp + temp * this.m/100;
            sum1 += temp;
        }
        sum1 = this.n + sum1;

        temp = this.n;
        int count = this.k;
        while (count != 1) {
            temp = temp + temp * this.m/100;
            sum2 += temp;
            count--;
        }
        sum2 = this.n + sum2;
        array[0] = sum1;
        array[1] = sum2;
        return array;
    }

}
