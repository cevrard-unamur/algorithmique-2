#include <array>
#include <iostream>

int elementDouble(int T[],int start, int end) {
    int middle = (start + end) / 2;

    if (start == end) {
        return T[middle];
    }

    if (middle == T[middle]) {
        return elementDouble(T, middle + 1, end);
    } else {
        return elementDouble(T, start, middle);
    }
}

int main() {
    int array[] = { 0, 1, 2, 3, 4, 5, 5, 6, 7, 8 };

    std::cout << "Value in double is " << elementDouble(array, 0, sizeof(array) / sizeof(array[0])) << std::endl;

    return 0;
}