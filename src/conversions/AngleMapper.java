package conversions;

public class AngleMapper {

    public static double degreesToRadians = (Math.PI/180);

    public static double degreesToRadians(double degrees) {
        return degrees * degreesToRadians;
    }
}
