package exercism;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Flattener {
    public static List<Object> flatten(List<Object> input) {
        return input
                .stream()
                .flatMap(element -> element instanceof List ?
                        Flattener.flatten((List<Object>) element).stream() :
                        Stream.of(element))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
