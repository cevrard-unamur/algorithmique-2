int sum = 0;

for (int i = 0; i < n; i++) {
    for (int j = 5; j < n; j = j + j) {
        sum++;
    }
}