package launcher;

import db.ReadFile;
import entity.Bike;
import entity.BikeType;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;


public class Application {
    private static final String CSV_DELIMITER = ", ";

    public static void main(String[] args) throws URISyntaxException {
        Bike bike = Bike.builder()
                .withWheelsRadius(27)
                .withBikeType(BikeType.CLASSIC)
                .withModel("Camanche")
                .build();
        System.out.println(bike);

        List<Bike> bikesFromCsv = getDataFromCsv(
                "db_bike.txt", Bike::parseBikeFromCsv);
        bikesFromCsv.forEach(System.out::println);
    }

    private static <T> List<T> getDataFromCsv(String resourceFileName, Function<String[], T> mappingDataMethod)
            throws URISyntaxException {
        return ReadFile.getInstance().readFileSource(
                        Objects.requireNonNull(
                                Application.class.getClassLoader().getResource(resourceFileName))
                                .toURI())
                .stream()
                .map(String::valueOf)
                .map(x -> x.split(CSV_DELIMITER))
                .map(mappingDataMethod)
                .toList();
    }

}
