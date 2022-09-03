public class Converter {
    double stepLength = 75;
    double calForStep = 50;

    double convertToKilometers(int steps) {
        double kilometers = (steps * stepLength) / 1000;
        return kilometers;
    }

    double convertToKiloCal(int steps) {
        double kiloCal = (steps * calForStep) / 1000;
        return kiloCal;

    }


}


