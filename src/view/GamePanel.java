package view;

import model.field.fieldObject.Bullet;
import presenter.ShipPlayerPresenter;
import model.event.ShipPlayerActionEvent;
import model.event.ShipPlayerActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements ShipPlayerActionListener{

    private ShipPlayerActionEvent shipPlayerMovementEvent;
    private ShipPlayerActionEvent shipPlayerFireEvent;
    private ShipPlayerPresenter shipPlayerPresenter;
    private Image imageShipPlayer;
    private Image imageBullet;

    private List<Bullet> bulletList = new ArrayList<>();

    public GamePanel(ShipPlayerPresenter shipPlayerPresenter) {
        this.shipPlayerPresenter = shipPlayerPresenter;
        setBackground(Color.BLACK);

        loadImage();

        Timer timer = new Timer(25, e -> {
            this.shipPlayerPresenter.hundleInput();
            this.bulletList.removeIf(Bullet::isOffScreen);
            for(Bullet bullet : this.bulletList) {
                bullet.moveBullet();
            }
            repaint();
        });
        timer.start();
    }

    private void loadImage() {
        ImageIcon imageIconShipPlayer = new ImageIcon("resources/player.png");
        ImageIcon imageIconBullet = new ImageIcon("resources/bullet.png");

        this.imageShipPlayer = imageIconShipPlayer.getImage();
        this.imageBullet = imageIconBullet.getImage();
    }

    @Override
    public void shipIsMoved(ShipPlayerActionEvent event) {
        this.shipPlayerMovementEvent = event;
        repaint();
    }

    @Override
    public void shipIsFire(ShipPlayerActionEvent event) {
        this.shipPlayerFireEvent = event;
        this.bulletList.add(shipPlayerFireEvent.getBullet());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (null == shipPlayerMovementEvent) return;

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(this.imageShipPlayer,
                shipPlayerMovementEvent.getShip().getX(),
                shipPlayerMovementEvent.getShip().getY(),
                30, 30, this);

        for(Bullet bullet : this.bulletList) {
            graphics2D.drawImage(this.imageBullet,
                    bullet.getX(), bullet.getY(),
                    bullet.getSizeBullet(), bullet.getSizeBullet(), this);
        }
    }
}
