package pl.prokodzik.hays;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
public class CarsStructured {
    private final List<Integer> firstPricesBag;
    private final List<Integer> secondPricesBag;

    public int sumOfFirstPricesBag() {
        return Optional.ofNullable(getFirstPricesBag().stream().reduce(0, Integer::sum)).orElse(0);
    }

    public int sumOfSecondPricesBag() {
        return Optional.ofNullable(getSecondPricesBag().stream().reduce(0, Integer::sum)).orElse(0);
    }
}
