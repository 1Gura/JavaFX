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

    void getSum() {
        double temp = this.n;
        double sum = 0;
        for (int i = 1; i < this.k; i++) {
            temp = temp + temp * this.m/100;
            sum += temp;
        }
        sum = this.n + sum;
        System.out.print("Суммарный путь (цикл for): ");
        System.out.println(sum);

        temp = this.n;
        sum = 0;
        int count = this.k;
        while (count != 1) {
            temp = temp + temp * this.m/100;
            sum += temp;
            count--;
        }
        sum = this.n + sum;
        System.out.print("Суммарный путь (цикл while): ");
        System.out.println(sum);
    }

}
