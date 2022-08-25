package entity;

import lombok.*;

import java.util.Arrays;
import java.util.List;



/**
 * NOTE: You should need to uncomment <b>@Builder</b> annotation and comment <b>@NoArgsConstructor</b> one
 * if you'll use Lombok standard builder
 * NOTE: If you want to use custom builder, then you'll need to uncomment <b>@NoArgsConstructor</b> annotation
 * and comment <b>@Builder</b> one
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
//@Builder
public class Bike {
    private double wheelsRadius;
    private String model;
    private BikeType bikeType;
    private List<String> accessories;
    private String description;

    /**
     * This method is needed just for shorten of BikeBuilder call
     *
     * @return BikeBuilder
     */
    public static BikeBuilder builder() {
        return  BikeBuilder.bikeBuilder();
    }

    public static Bike parseBikeFromCsv(String[] strings) {
        return builder()
                .withWheelsRadius(Double.parseDouble(strings[0]))
                .withModel(strings[1])
                .withBikeType(BikeType.getBikeTypeByString(strings[2]))
                .withAccessories(Arrays.stream(strings[3].split("; ")).toList())
                .withDescription(strings[4])
                .build();
    }

    @Override
    public String toString() {
        return "Bike{" +
                "wheelsRadius=" + wheelsRadius +
                ", model='" + model + '\'' +
                ", bikeType=" + bikeType +
                ", accessories=" + accessories +
                ", description='" + description + '\'' +
                '}';
    }


    public static final class BikeBuilder {
        private final Bike bike;

        private BikeBuilder() {
            this.bike = new Bike();
        }

        public static BikeBuilder bikeBuilder() {
            return new BikeBuilder();
        }

        public BikeBuilder withWheelsRadius(double wheelsRadius) {
            bike.setWheelsRadius(wheelsRadius);
            return this;
        }

        public BikeBuilder withModel(String model) {
            bike.setModel(model);
            return this;
        }

        public BikeBuilder withBikeType(BikeType bikeType) {
            bike.setBikeType(bikeType);
            return this;
        }

        public BikeBuilder withAccessories(List<String> accessories) {
            bike.setAccessories(accessories);
            return this;
        }

        public BikeBuilder withDescription(String description) {
            bike.setDescription(description);
            return this;
        }

        public Bike build() {
            return bike;
        }
    }
}
