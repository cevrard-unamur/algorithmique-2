#include <iterator>
#include <iostream>

bool elementBetween(int T[],int start, int end, int a, int b) {
    int middle = (start + end) / 2;

    if (start > end) {
        return false;
    } else if (b < T[middle]) {
        return elementBetween(T, start, middle - 1, a, b);
    } else if (a > T[middle]) {
        return elementBetween(T, middle + 1, end, a, b);
    } else {
        return true;
    }
}

int main() {
    int array[] = { 6, 8, 10, 12, 16, 20, 25};

    std::cout << "Value is between a and b " << (elementBetween(array, 0, sizeof(array) / sizeof(array[0]), 11, 13) ? "true" : "false") << std::endl;

    return 0;
}