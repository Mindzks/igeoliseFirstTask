package entities;

public final class Coordinates {
    private final double longitude;
    private final double latitude;

    public Coordinates( double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        double temp = new Double(longitude);
        return temp;
    }

    public double getLatitude() {
        double temp = new Double(latitude);
        return temp;
    }
}
