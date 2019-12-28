#include <iostream>

#define ARRAY_X 7
#define ARRAY_Y 5

void getMinimalLeftCorner(int array[ARRAY_X][ARRAY_Y], int row, int column, int result[2]) {
    if (row == ARRAY_X - 1 && column == ARRAY_Y - 1) {
        result[0] = row;
        result[1] = column;
        return;
    }

    
}

int main() {
    int array[ARRAY_X][ARRAY_Y] = {
        { 10, 17, 13, 28, 23 },
        { 17, 22, 16, 29, 23 },
        { 24, 28, 22, 34, 24 },
        { 11, 13,  6, 17,  7 },
        { 45, 44, 32, 37, 23 },
        { 36, 33, 19, 21,  6 },
        { 75, 66, 51, 53, 34 }
    };

    int minimalForRow;
    int columnOfMinimal;
    int rowOfMinimal;
    int result[2];

    for (int i = 0; i < ARRAY_X - 1; i++) {
        minimalForRow = INT_MAX;

        for (int j = 0; j < ARRAY_Y - 1; j++) {
            if (array[i][j] < minimalForRow) {
                minimalForRow = array[i][j];
                rowOfMinimal = i;
                columnOfMinimal = j;
            }
        }

        getMinimalLeftCorner(array, rowOfMinimal + 1, columnOfMinimal + 1, result);

        std::cout << "Minimal value of row " << i << " is " << array[i][columnOfMinimal] << std::endl;
    }

    return 0;
}