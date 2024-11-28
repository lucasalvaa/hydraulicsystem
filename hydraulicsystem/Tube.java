package hydraulicsystem;

public class Tube implements Component {
    private final double loss;

    public Tube (double loss) {
        this.loss = loss;
    }

    public Tube () {
        this(10.0);
    }

    public double outputFlow (double inputFlow) {
        return (inputFlow - loss) >= 0
            ? (inputFlow - loss)
            : 0.0;
    }

    public void printInfo () {
        System.out.println(new StringBuilder("Tube {loss: ")
            .append(loss) 
            .append("}")
            .toString());
    }

    @Override
    public String toString () {
        return new StringBuilder("Tube {loss: ")
            .append(loss) 
            .append("}")
            .toString();
    }
}