package entity;

public enum BikeType {
    ELECTRIC("electric"),
    CLASSIC("classic"),
    MOTO("combustion engine"),
    UNKNOWN("unknown bike type");

    private final String bikeType;

    BikeType(String bikeTypeName) {
        this.bikeType = bikeTypeName;
    }

    public String getBikeType() {
        return bikeType;
    }

    public static BikeType getBikeTypeByString(String bikeTypeName) {
        return switch (bikeTypeName) {
            case "classic" -> CLASSIC;
            case "combustion engine" -> MOTO;
            case "electric" -> ELECTRIC;
            default -> UNKNOWN;
        };
    }



}

