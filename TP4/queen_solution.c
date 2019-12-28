#include "stdio.h"

#define N 3

int paths[N][N];

void memoizePathCount() {
    for (int i = 0; i < N; i++) {
        paths[i][0] = 1;
        paths[0][i] = 1;
    }

    for (int i = 1; i < N; i++) {
        for (int j = 1; j < N; j++) {
            paths[i][j] = paths[i - 1][j] + paths[i][j - 1] + paths[i - 1][j - 1];
        }
    }
}

int main() {
    memoizePathCount();
        printf("Queen - Solution : The number of path is %d\n", paths[N - 1][N - 1]);
}
