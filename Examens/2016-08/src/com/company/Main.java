package com.company;

public class Main {

    public static void main(String[] args) {
		Integer[] verticalPrices1 = { 2, 1, 3, 1, 4 };
		Integer[] horizontalPrices1 = { 4, 1, 2 };

		int solution1 = Solver.GetBestPrice(verticalPrices1, horizontalPrices1);

		System.out.println("The price for this configuration (1) is " + solution1);

		Integer[] verticalPrices2 = { 10, 2, 1, 5 };
		Integer[] horizontalPrices2 = { 3, 4, 1 };

		int solution2 = Solver.GetBestPrice(verticalPrices2, horizontalPrices2);

		System.out.println("The price for this configuration (2) is " + solution2);
    }
}
