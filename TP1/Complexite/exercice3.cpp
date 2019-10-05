void fct(int n) {
    int sum = 0;
    
    for (int i = 5; i <= n - 5; i++) {
        for (int j = i - 5; j < i + 5; j++) {
            sum = i + j;
        }
    }
}