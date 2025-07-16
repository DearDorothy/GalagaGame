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
            bulletList.removeIf(Bullet::isOffScreen);
            for(Bullet bullet : bulletList) {
                bullet.moveBullet();
            }
            repaint();
        });
        timer.start();
    }

    private void loadImage() {
        ImageIcon imageIconShipPlayer = new ImageIcon("resources/player.png");
        ImageIcon imageIconBullet = new ImageIcon("resources/bullet.png");

        imageShipPlayer = imageIconShipPlayer.getImage();
        imageBullet = imageIconBullet.getImage();
    }

    @Override
    public void shipIsMoved(ShipPlayerActionEvent event) {
        shipPlayerMovementEvent = event;
        repaint();
    }

    @Override
    public void shipIsFire(ShipPlayerActionEvent event) {
        shipPlayerFireEvent = event;
        bulletList.add(shipPlayerFireEvent.getBullet());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (null == shipPlayerMovementEvent) return;

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(imageShipPlayer,
                shipPlayerMovementEvent.getShip().getX(),
                shipPlayerMovementEvent.getShip().getY(),
                30, 30, this);

        for(Bullet bullet : bulletList) {
            graphics2D.drawImage(imageBullet,
                    bullet.getX(), bullet.getY(),
                    bullet.getSizeBullet(), bullet.getSizeBullet(), this);
        }
    }
}
