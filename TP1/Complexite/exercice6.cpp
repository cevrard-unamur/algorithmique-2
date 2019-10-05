int R1(int n) {
    if (n > 1 ){
        return 1;
    } else {
        return 5 * R1(n - 1);
    }
}