int fct (int a, int b) {
    if (a == 0) {
        return 0;
    } else {
        return fct(a - 1, b) + b;
    }
}