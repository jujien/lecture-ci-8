import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] map = {
                {"*", "*", "*", "*"},
                {"*", "*", "*", "*"},
                {"*", "*", "P", "*"},
                {"*", "*", "*", "*"}
        };

        Scanner scanner = new Scanner(System.in);

        int playerX = 2;
        int playerY = 2;

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
        }
    }

}
