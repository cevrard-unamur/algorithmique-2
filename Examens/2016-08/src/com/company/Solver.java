package com.company;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solver {
    private static int currentVerticalCuts = 1;
    private static int currentHorizontalCuts = 1;

    private static int currentVerticalPriceIndex = 0;
    private static int currentHorizontalPriceIndex = 0;

    private static int totalPrice = 0;

    public static int GetBestPrice(Integer[] verticalPrices, Integer[] horizontalPrices) {
        currentVerticalCuts = 1;
        currentHorizontalCuts = 1;
        currentVerticalPriceIndex = 0;
        currentHorizontalPriceIndex = 0;

        totalPrice = 0;

        Arrays.sort(verticalPrices, Collections.reverseOrder());
        Arrays.sort(horizontalPrices, Collections.reverseOrder());

        for (int i = 0; i < verticalPrices.length + horizontalPrices.length; i++) {
            if (currentHorizontalPriceIndex == horizontalPrices.length || currentVerticalPriceIndex == verticalPrices.length) {
                if (currentVerticalPriceIndex < verticalPrices.length) {
                    HandleCut(verticalPrices, horizontalPrices, Direction.Vertical);
                }
                if (currentHorizontalPriceIndex < horizontalPrices.length) {
                    HandleCut(verticalPrices, horizontalPrices, Direction.Horizontal);
                }
            } else {
                if (verticalPrices[currentVerticalPriceIndex] > horizontalPrices[currentHorizontalPriceIndex]) {
                    HandleCut(verticalPrices, horizontalPrices, Direction.Vertical);
                } else if (horizontalPrices[currentHorizontalPriceIndex] > verticalPrices[currentVerticalPriceIndex]) {
                    HandleCut(verticalPrices, horizontalPrices, Direction.Horizontal);
                } else {
                    if (currentVerticalCuts <= currentHorizontalCuts) {
                        HandleCut(verticalPrices, horizontalPrices, Direction.Vertical);
                    } else {
                        HandleCut(verticalPrices, horizontalPrices, Direction.Horizontal);
                    }
                }
            }
        }

        return  totalPrice;
    }

    private static void HandleCut(Integer[] verticalPrices, Integer[] horizontalPrices, Direction direction) {
        switch (direction) {
            case Vertical:
                totalPrice += verticalPrices[currentVerticalPriceIndex] * currentHorizontalCuts;
                currentVerticalCuts++;
                currentVerticalPriceIndex++;
                break;
            case Horizontal:
                totalPrice += horizontalPrices[currentHorizontalPriceIndex] * currentVerticalCuts;
                currentHorizontalCuts++;
                currentHorizontalPriceIndex++;
                break;
        }
    }
}
