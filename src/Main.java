import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[][] map = {
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"}
        };

        Scanner scanner = new Scanner(System.in);

        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map.length; j++)
                points.add(new Point(i, j));

        Point point = random(points);

        int playerX = point.x;
        int playerY = point.y;

        point = random(points);

        int enemyFirstX = point.x;
        int enemyFirstY = point.y;

        point = random(points);

        int enemySecondX = point.x;
        int enemySecondY = point.y;

        point = random(points);
        int giftX = point.x;
        int giftY = point.y;

        map[enemyFirstX][enemyFirstY] = "E";
        map[playerX][playerY] = "P";
        map[enemySecondX][enemySecondY] = "e";
        map[giftX][giftY] = "G";

        while (true) {
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    System.out.print(map[j][i] + " ");
                }
                System.out.println();
            }

            System.out.println("Nhap ky tu ban phim: ");
            String key = scanner.next();

            map[playerX][playerY] = "*";

            switch (key) {
                case "w":
                    playerY -= 1;
                    break;
                case "s":
                    playerY += 1;
                    break;
                case "a":
                    playerX -= 1;
                    break;
                case "d":
                    playerX += 1;
                    break;
            }
            if (playerY == -1) playerY = map.length - 1;
            if (playerY == map.length) playerY = 0;
            if (playerX == -1) playerX = map.length - 1;
            if (playerX == map.length)  playerX = 0;

            map[playerX][playerY] = "P";

            if (playerX == giftX && playerY == giftY) {
                System.out.println("win");
                break;
            }

            if ((playerX == enemyFirstX && playerY == enemyFirstY) || (playerX == enemySecondX && playerY == enemySecondY)) {
                System.out.println("Lost");
                break;
            }

            map[enemyFirstX][enemyFirstY] = "*";
            map[enemySecondX][enemySecondY] = "*";
            map[giftX][giftY] = "G";

            enemyFirstX = (enemyFirstX + 1) % map.length;
            map[enemyFirstX][enemyFirstY] = "E";


            enemySecondY = (enemySecondY + 1) % map.length;
            map[enemySecondX][enemySecondY] = "e";

            if ((playerX == enemyFirstX && playerY == enemyFirstY) || (playerX == enemySecondX && playerY == enemySecondY)) {
                System.out.println("Lost");
                break;
            }


        }
    }



    static Point random(ArrayList<Point> list) {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.remove(index);
    }

}
