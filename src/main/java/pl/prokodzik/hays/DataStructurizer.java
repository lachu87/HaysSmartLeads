package pl.prokodzik.hays;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataStructurizer {

    public CarsStructured order(final Integer[] carPrices) {
        List<Integer> collect = Stream.of(carPrices).sorted().collect(Collectors.toList());
        List<Integer> firstCarsGroup = new LinkedList<>();
        List<Integer> secondCarsGroup = new LinkedList<>();
        for (int i = 0; i < collect.size() / 2; i++) {
            if (i % 2 == 0) {
                firstCarsGroup.add(collect.get(i));
                firstCarsGroup.add(collect.get(collect.size() - 1 - i));
            } else {
                secondCarsGroup.add(collect.get(i));
                secondCarsGroup.add(collect.get(collect.size() - 1 - i));
            }
        }
        return new CarsStructured(firstCarsGroup, secondCarsGroup);
    }

    public int[][] orderOnPrimitives(final Integer[] carPrices) {
        int[][] orderedTable = new int[2][carPrices.length / 2];
        List<Integer> collect = Stream.of(carPrices).sorted().collect(Collectors.toList());
        for (int i = 0; i < collect.size() / 2; i++) {
            orderedTable[i % 2][i] = collect.get(i);
            orderedTable[i % 2][collect.size() / 2 - 1 - i] = collect.get(collect.size() - 1 - i);
        }
        return orderedTable;
    }

}
