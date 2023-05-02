package part04;

abstract class Fruit {
    private final float weight;
    private boolean isInBox;
    private int location;

    public float getWeight() {
        return weight;
    }

    public boolean isInBox() {
        return isInBox;
    }

    public void setInBox(boolean inBox) {
        isInBox = inBox;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }
}