package hydraulicsystem;

public class Pump implements Component {
    private final double boostFactor;

    public Pump (double boostFactor) {
        this.boostFactor = boostFactor;
    }

    public Pump () {
        this(1.2);
    }

    /**
     * Boosts the incoming flow by multiplying by the enhance factor
     */
    public double outputFlow (double inputFlow) {
        return (inputFlow * boostFactor);
    }

    public void printInfo () {
        System.out.println(new StringBuilder("Pump {boost factor: ")
            .append(boostFactor) 
            .append("}")
            .toString());
    }

    @Override
    public String toString () {
        return new StringBuilder("Pump {boost factor: ")
            .append(boostFactor) 
            .append("}")
            .toString();
    }
} 
