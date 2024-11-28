import hydraulicsystem.*;

public class Tester {

    static final int PUMP = 1;
    static final int TUBE = 2;
    static final int VALVE = 3;
    static final int TANK = 4;

    public static void main (String args[]) {
        var hs = new HydraulicSystem();

        System.out.println(hs);

        hs.printInfo(TUBE);
        System.out.println("Tube tested with 100 litres - output: " + hs.testComponent(100, TUBE));

        hs.printInfo(PUMP);
        System.out.println("Pump tested with 100 litres - output: " + hs.testComponent(100, PUMP));

        hs.closeValve();
        hs.printInfo(VALVE);
        System.out.println("Valve tested with 100 litres while closed - output: " + hs.testComponent(100, VALVE));
        hs.openValve();
        hs.printInfo(VALVE);
        System.out.println("Valve tested with 100 litres after being opened - output: " + hs.testComponent(100, VALVE));
        
        hs.printInfo(TANK);
        System.out.println("Water tank tested with 100 litres - output: " + hs.testComponent(100, TANK));
        hs.printInfo(TANK);

        double test = hs.testInSeries(200, TUBE, VALVE);
        System.out.println("200 litres are injected through a tube and an open valve - output: " + test);

        test = hs.testInSeries(100, TUBE, PUMP, TANK);
        System.out.println("100 litres are injected through a tube, a pump and in the tank - output: " + test);
        hs.printInfo(TANK);

        test = hs.testInSeries(100, TANK, TUBE);
        System.out.println("100 litres are injected in the tank and in the tube - output: " + test);
        hs.printInfo(TANK);

        test = hs.testInSeries(40, TUBE, TUBE, TUBE, TUBE, TUBE);
        System.out.println("40 litres are injected in the tube four times - output: " + test);
    }
}