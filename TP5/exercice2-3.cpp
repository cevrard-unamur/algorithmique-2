#include <iostream>
#include <vector>

/*
 * The array of coins must be order by descending.
 */
std::vector<int> giveBackChange(int amount, std::vector<int> coins, int startCoins, int endCoins) {
    std::vector<int> moneyBack{};

    if (endCoins < startCoins) {
        return moneyBack;
    }

    int remaining = amount;
    int numberOfCoins;

    for (int i = startCoins; i < endCoins; i++) {
        numberOfCoins = remaining / coins.at(i);
        remaining -= coins.at(i) * numberOfCoins;

        if (numberOfCoins > 0) {
            moneyBack.push_back(coins.at(i));
        }
    }
    
    if (remaining == 0) {
        return moneyBack;
    }

    return giveBackChange(amount, coins, startCoins + 1, endCoins);
}

int main() {
    auto coins = {5, 4, 2};
    auto amount = 0;

    std::cout << "Please enter the amount to give back : ";
    std::cin >> amount;

    auto giveBackCoins = giveBackChange(amount, coins, 0, coins.size());

    for (auto coin : giveBackCoins) {
        std::cout << coin << " " << std::endl;
    }
}