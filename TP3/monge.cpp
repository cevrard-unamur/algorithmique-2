#include <iostream>
#include <climits>

#define M 7
#define N 5

int resultValue[M];
int resultIndex[M];

void smallestEvenElement(int array[M][N], int start, int end, int row) {
    if (row >= M) {
        return;
    }

    int smallestValue = INT_MAX;
    int smallestIndex = -1;

    for (int i = start; i < end; i++) {
        if (array[row][i] < smallestValue) {
            smallestValue = array[row][i];
            smallestIndex = i;
        } 
    }

    resultValue[row] = smallestValue;
    resultIndex[row] = smallestIndex;

    smallestEvenElement(array, smallestIndex, end, row + 2);
}

void smallestOddElement(int array[M][N], int start, int end, int row) {
    if (row >= M) {
        return;
    }
    
    int smallestValue = INT_MAX;
    int smallestIndex = -1;

    for (int i = start; i <= end; i++) {
        if (array[row][i] < smallestValue) {
            smallestValue = array[row][i];
            smallestIndex = i;
        } 
    }

    resultValue[row] = smallestValue;
    resultIndex[row] = smallestIndex;

    smallestOddElement(array, resultIndex[start + 2], resultIndex[end + 2], row + 2);
}

void smallestLeftElement(int array[M][N]) {
    smallestEvenElement(array, 0, N, 0);
    smallestOddElement(array, resultIndex[0], resultIndex[2], 1);
}

int main() {
    int mongeArray[M][N] = {
        { 10, 17, 13, 28, 23 },
        { 17, 22, 16, 29, 23 },
        { 24, 28, 22, 34, 24 },
        { 11, 13,  6, 17,  7 },
        { 45, 44, 32, 37, 23 },
        { 36, 33, 19, 21,  6 },
        { 75, 66, 51, 53, 34 }
    };

    smallestLeftElement(mongeArray);

    std::cout << "The result are ";

    for (int i = 0; i < M; i++) {
        std::cout << resultValue[i] << " ";
    }

    std::cout << std::endl;

    return 0;
}