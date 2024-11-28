package hydraulicsystem;

public class Valve implements Component {
    private boolean isOpen;

    public Valve () {
        this.isOpen = false;
    }

    /**
     * Check if the valve is open (true) of closed (false).
     */
    public boolean isOpen () {
        return isOpen;
    }

    /**
     * Regulates the water flow.
     * If the valve is closed, the output flow will be empty.
     */
    public double outputFlow (double inputFlow) {
        return isOpen ? inputFlow : 0.0;
    }

    /**
     * If is not open yet, the method opens the valve
     */
    public boolean open () {
        if (isOpen) {
            return false;
        }

        isOpen = true;
        return true;
    }

    /**
     * If is not closed yet, the method closes the valve.
     */
    public boolean close () {
        if (!isOpen) {
            return false;
        }

        isOpen = false;
        return true;
    }

    public void printInfo () {
        System.out.println(new StringBuilder("Valve {is opened: ")
            .append(isOpen) 
            .append("}")
            .toString());
    }

    @Override
    public String toString () {
        return new StringBuilder("Valve {is opened: ")
            .append(isOpen) 
            .append("}")
            .toString();
    }
}