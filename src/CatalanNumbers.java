public class CatalanNumbers {
    int n;
    int res;

    public CatalanNumbers(int n) {
        this.n = n;
        this.res = calculateCatalanNum(this.n);
    }

    public int getRes() {
        return this.res;
    }

    public static int calculateCatalanNum(int n) {
        int[] catalanNum = new int[n + 1];
        catalanNum[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalanNum[i] += catalanNum[j] * catalanNum[i - j - 1];
            }
        }
        return catalanNum[n];
    }
}
