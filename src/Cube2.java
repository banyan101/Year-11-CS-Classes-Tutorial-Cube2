public class Cube2 {
    private Cube basicCube;
    private String color;

    public Cube2() {
        basicCube = new Cube();
        this.color = "black";
    }

    public Cube2(int side) {
        this();
        basicCube.setSide(side);
    }

    public Cube2(int side, String color) {
        this(side);
        setColor(color);
    }

    public int getSide() {
        return basicCube.getSide();
    }

    public void setSide(int side) {
        basicCube.setSide(side);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null) {
            this.color = "black";
        } else {
            this.color = color;
        }
    }

    public int calculateVolume() {
        return basicCube.calculateVolume();
    }

    public int calculateSurfaceArea() {
        return basicCube.calculateSurfaceArea();
    }

    public Cube2 add(Cube2 otherCube) {
        if (otherCube == null) {
            throw new IllegalArgumentException( );
        }

        int newSide = hypotenuseFromLegs(getSide(), otherCube.getSide());
        return new Cube2(newSide, this.color);
    }

    public Cube2 minus(Cube2 otherCube) {
        if (otherCube == null) {
            throw new IllegalArgumentException();
        }

        if (getSide() <= otherCube.getSide()) {
            throw new IllegalArgumentException();
        }

        int newSide = legFromHypotenuseAndLeg(getSide(), otherCube.getSide());
        return new Cube2(newSide, this.color);
    }

    private int hypotenuseFromLegs(int firstSide, int secondSide) {
        long sumSquares = 1L * firstSide * firstSide + 1L * secondSide * secondSide;
        int hypotenuse = (int) Math.sqrt(sumSquares);
        if ((long) hypotenuse * hypotenuse != sumSquares) {
            throw new IllegalArgumentException();
        }
        return hypotenuse;
    }

    private int legFromHypotenuseAndLeg(int hypotenuse, int leg) {
        if (hypotenuse <= leg) {
            throw new IllegalArgumentException();
        }

        long difference = 1L * hypotenuse * hypotenuse - 1L * leg * leg;
        int result = (int) Math.sqrt(difference);
        if ((long) result * result != difference) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public String toString() {
        return "Cube{side=" + getSide() + ", color=\"" + color + "\"}";
    }
}
