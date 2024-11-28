package hydraulicsystem;

public interface Component {
    /**
     * Given an incoming water flow, calculates the output water flow 
     */
    public double outputFlow (double inputFlow);

    /**
     * Prints each information about the component
     */
    public void printInfo ();
}