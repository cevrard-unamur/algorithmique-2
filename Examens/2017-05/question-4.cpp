#include <iostream>
#include <array>
#include <limits>

#define N 4

using namespace std;

int packagesChoice(array<array<int, 2>, N> array, int start, int end);
int packageChoiceRecusivity(array<array<int, 2>, N> array, int start, int end);

int main() {
    array<array<int, 2>, N> orderArray {{
        {{ 7, 2 }},
        {{ 3, 3 }},
        {{ 4, 4 }},
        {{ 2, 8 }}
    }};

    cout << "Best sum : " << packagesChoice(orderArray, 0, N) << endl;

}

int packagesChoice(array<array<int, 2>, N> array, int start, int end) {
    int bestSum = numeric_limits<int>::max();
    int currentSum = 0;

    for (int i = start; i < end; i++) {
        currentSum = packageChoiceRecusivity(array, 0, end - i) + packageChoiceRecusivity(array, end - i, end);

        if (currentSum < bestSum) {
            bestSum = currentSum;
        } 
    } 

    return bestSum;
}

int packageChoiceRecusivity(array<array<int, 2>, N> array, int start, int end) {
    if (start == end) {
        return 0;
    }

    int height = 0;
    int width = 0;

    for (int i = start; i < end; i++) {
        if (array[i][0] > height) {
            height = array[i][0];
        }

        if (array[i][1] > width) {
            width = array[i][1];
        }
    }

    return height * width;
}
