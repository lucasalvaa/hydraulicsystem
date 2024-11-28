package hydraulicsystem;

public class WaterTank implements Component {
    private final double maxCapacity;
    private double waterInside;

    public WaterTank (double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.waterInside = 0.0;
    }

    public WaterTank () {
        this(200.0);
    }

    /**
     * Inserts the incoming water in the tank.
     * 
     * If the addition exceeds the maximum capacity threshold, the tank is filled
     * and the excess water is sent to the output flow.
     */
    public double outputFlow (double inputFlow) {
        /**
         * If the water injected could be cointaned in the tank, the output flow is empty.
         */
        if (waterInside + inputFlow <= maxCapacity) {
            waterInside += inputFlow;
            return 0.0;
        }
        /**
         * Else, the tank is filled and the exceeded water is sent to the output flow.
         */
        else {
            inputFlow = (waterInside + inputFlow) - maxCapacity;
            this.fill();
            return inputFlow;
        } 
    }

    /**
     * Check if the tank is empty.
     */
    public boolean isEmpty () {
        return waterInside == 0.f;
    }

    /**
     * Removes a certain amount of water from the tank.
     * If the required amount of water exceeds the amount of water contained in the tank, nothing happens.
     */
    public double getOutWater (double amount) {
        if (!isEmpty() && (0 <= waterInside - amount)) {
            waterInside -= amount;
            return amount;
        }

        return 0.f;
    }

    /**
     * Fills the tank with water.
     */
    public boolean fill () {
        waterInside = maxCapacity;
        return true;
    }

    public void printInfo () {
        System.out.println(new StringBuilder("Water Tank {maximum capacity: ")
            .append(maxCapacity) 
            .append(", water inside: ").append(waterInside)
            .append("}")
            .toString());
    }

    @Override
    public String toString () {
        return new StringBuilder("Water Tank {maximum capacity: ")
            .append(maxCapacity) 
            .append(", water inside: ").append(waterInside)
            .append("}")
            .toString();
    }
}