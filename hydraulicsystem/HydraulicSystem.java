package hydraulicsystem;

public class HydraulicSystem {
    private final Tube tube;
    private final Pump pump;
    private final Valve valve;
    private final WaterTank tank;

    public HydraulicSystem (Tube t, Pump p, Valve v, WaterTank wt) {
        tube = t;
        pump = p;
        valve = v.open();
        tank = wt;
    }

    public HydraulicSystem () {
        this(new Tube(), new Pump(), new Valve(), new WaterTank());
    }

    /**
     * Tests a certain component of the hydraulic system by injecting a water flow in it.
     * 
     * @param component must be equals to:
     * 1 - to inject a certain water flow in the tube
     * 2 - to inject a certain water flow in the pump
     * 3 - to inject a certain water flow in the valve
     * 4 - to inject a certain water flow in the water tank
     * 
     * @return the output flow of the component if the @param component value is between 1 and 4, otherwise -1 
     */
    public double testComponent (double inputFlow, final int component) {
        double result = 0.f;
        switch(component) {
            case 1:
                result = pump.outputFlow(inputFlow);
                break;
            case 2:
                result = tube.outputFlow(inputFlow);
                break;
            case 3:
                result = valve.outputFlow(inputFlow);
                break;
            case 4:
                result = tank.outputFlow(inputFlow);
                break;
            default:
                result = -1.f;
        }
        return result;
    }

    /**
     * Injects a water flow into a series of components to test the combined behavior
     */
    public double testInSeries (double inputFlow, final int ...components) {
        for (int i : component) {
            
            inputFlow = testComponent(inputFlow, i);
            
            if (inputFlow < 0) {
                return -1.f;
            }
        }
        return inputFlow;
    }

    /**
     * Prints informations of a component in the hydraulic system
     * 
     * @param component must be equals to:
     * 1 - to print tube's informations
     * 2 - to print pump's informations
     * 3 - to print valve's informations
     * 4 - to print water tank's informations
     */
    public boolean printInfo (final int component) {
        switch(component) {
            case 1:
                pump.printInfo();
                break;
            case 2:
                tube.printInfo();
                break;
            case 3:
                valve.printInfo();
                break;
            case 4:
                tank.printInfo();
                break;
            default:
                System.out.println("Invalid component identificator: " + component);
                return false;
        }
        return true;
    }

    /**
     * If is not open yet, the method opens the valve
     */
    public boolean openValve () {
        return valve.open();
    }

    /**
     * If is not closed yet, the method closes the valve
     */
    public boolean closeValve () {
        return valve.close();
    }

    /**
     * Fills the tank with water
     */
    public boolean fillTank () {
        return tank.fill();
    }

    @Override 
    public String toString () {
        return new StringBuilder("Hydraulic system: [\n\t")
            .append(tube)
            .append('\n').append('\t')
            .append(valve)
            .append('\n').append('\t')
            .append(pump)
            .append('\n').append('\t')
            .append(tank)
            .append('\n').append(']')
            .toString();
    }

}