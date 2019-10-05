int fct(int n) {
    int i, j, c = 0;

    for (i = 1; i <= n; i++) {
        for (j = i; j >= 1; j--) {
            c = i + j;
        }
    }

    if (n > 0) {
        for (i = 4; i >= 1; i--) {
            fct(n/2);
        }
    }
}