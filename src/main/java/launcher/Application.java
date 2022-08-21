package launcher;

import db.ReadFile;
import entity.Bike;
import entity.BikeType;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Application {
    private static final String CSV_DELIMITER = ", ";

    public static void main(String[] args) throws URISyntaxException {
        List<Bike> bikesFromCsv = getDataFromCsv(
                "db_bike.txt", Bike::parseBikeFromCsv);
        bikesFromCsv.forEach(System.out::println);
    }

    private static  List<Bike> getDataFromCsv(String resourceFileName, Function<String[], Bike> mappingDataMethod)
            throws URISyntaxException {
        return ReadFile.getInstance().readFileSource(
                        Objects.requireNonNull(Application.class.getClassLoader().getResource(resourceFileName)).toURI())
                .stream()
                .map(String::valueOf)
                .map(x -> x.split(CSV_DELIMITER))
                .map(mappingDataMethod)
                .collect(Collectors.toList());
    }

}
