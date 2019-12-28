#include "stdio.h"

#define N 3

int path[N][N];

void calculatePaths(int i, int j) {
    if (i == 0 && j == 0) {
        path[0][0] = 1;
        return;
    } else {
        if (i == 0) {
            calculatePaths(i, j - 1);

            path[i][j] = path[i][j - 1];
        } else if (j == 0) {
            calculatePaths(i - 1, j);

            path[i][j] = path[i - 1][j];
        } else {
            calculatePaths(i - 1, j);
            calculatePaths(i, j - 1);
            calculatePaths(i - 1, j - 1);

            path[i][j] = path[i - 1][j] +
                path[i][j - 1] +
                path[i - 1][j - 1];
        }
    }
}

int main() {
    calculatePaths(N, N);
    printf("Queen : The number of path is %d\n", path[N - 1][N - 1]);
}