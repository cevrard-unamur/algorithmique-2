void fct(int n) {
    int sum = 0;
    int m = n * n * n;
    int i;

    for (int i = 1; i < m; i *= 2) {
        sum = sum + 1;
    }
}