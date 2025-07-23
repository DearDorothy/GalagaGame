package model;

import model.field.Field;
import model.manager_ships.EnemyCommander;
import model.manager_ships.Player;

public class Test {
    public static void main(String[] args) {

        Field field = new Field();
        Player player = new Player(3);
        EnemyCommander enemyCommander = new EnemyCommander(10);

        Game game = new Game(player, enemyCommander, field);
    }
}
