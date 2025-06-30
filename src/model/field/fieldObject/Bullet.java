package model.field.fieldObject;

public class Bullet extends FieldObject {

    private int size_bullet = 13;

    public Bullet(int x, int y) { super(x, y, 12); }

    public void moveBullet() {
        this.y -= this.speed;
    }

    public boolean isOffScreen() {
        return this.y +this.size_bullet < 0;
    }
}
