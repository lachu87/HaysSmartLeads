package pl.prokodzik.hays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class DataStructurizerTest {
    DataStructurizer dataStructurizer;

    @BeforeEach
    void init() {
        dataStructurizer = new DataStructurizer();
    }

    @Test
        //Happy Path
    void should_work_the_same_using_primitives() {
        //given:
        final Integer[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        //when:
        CarsStructured carsStructured = dataStructurizer.order(input);
        int[][] primitives = dataStructurizer.orderOnPrimitives(input);

        //then:
        Assertions.assertEquals(carsStructured.sumOfFirstPricesBag(), Arrays.stream(primitives[0]).sum());
        Assertions.assertEquals(carsStructured.sumOfSecondPricesBag(), Arrays.stream(primitives[1]).sum());
    }

    @Test
    //Happy Path
    void should_split_evenly() {
        //given:
        final Integer[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        //when:
        CarsStructured carsStructured = dataStructurizer.order(input);

        //then:
        Assertions.assertEquals(carsStructured.sumOfFirstPricesBag(), carsStructured.sumOfSecondPricesBag());
    }

    @Test
    //A bit more complex
    void should_split_evenly_reverse_order() {
        //given:
        final Integer[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        ArrayUtils.reverse(input);

        //when:
        CarsStructured carsStructured = dataStructurizer.order(input);

        //then:
        Assertions.assertEquals(carsStructured.sumOfFirstPricesBag(), carsStructured.sumOfSecondPricesBag());
    }

    @Test
        //Even more complex
    void should_split_evenly_even_more_complex() {
        //given:
        final Integer[] input = {2800, 6500, 1500, 4200, 800, 6800, 7200, 3800, 1250, 1000, 1186,
                1275, 1337, 1488, 15222, 16782, 1746, 1898, 1955, 2020};

        //when:
        CarsStructured carsStructured = dataStructurizer.order(input);

        //then:
        Assertions.assertEquals(4835, Math.abs(carsStructured.sumOfFirstPricesBag() - carsStructured.sumOfSecondPricesBag()));
    }
}