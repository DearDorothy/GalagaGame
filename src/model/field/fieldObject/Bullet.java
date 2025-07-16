package model.field.fieldObject;

public class Bullet extends FieldObject {

    private final int size_bullet = 15;

    public Bullet(int x, int y) { super(x, y, 12); }

    public void moveBullet() {
        y -= speed;
    }

    public int getSizeBullet() { return size_bullet; }

    public boolean isOffScreen() {
        return y + size_bullet < 0;
    }
}
