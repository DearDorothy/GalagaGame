package model.field.fieldObject;

public abstract class FieldObject {

    protected int x;
    protected int y;
    protected int speed;

    public FieldObject(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getSpeed() { return speed; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setSpeed(int speed) { this.speed = speed; }
}
