package model.field.fieldObject;

public class Bullet extends FieldObject {

    private final int size_bullet = 15;

    public Bullet(int x, int y) { super(x, y, 12); }

    public void moveBullet() {
        this.y -= this.speed;
    }

    public int getSizeBullet() { return this.size_bullet; }

    public boolean isOffScreen() {
        return this.y + this.size_bullet < 0;
    }
}
