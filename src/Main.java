import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Color> colors;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What Difficulty do you want to play in?");
        String diff = sc.nextLine().toUpperCase().replaceAll(" ","");
        //default difficulty is medium
        int size = 14;
        int hues = 6;
        int tries = 25;

        switch (diff){
            case "EASY":
                System.out.println("Easy difficulty");
                size = 10;
                hues = 5;
                tries = 14;
                break;
            case "MEDIUM":
                System.out.println("Medium difficulty");
                break;
            case "HARD":
                System.out.println("Hard difficulty");
                size = 22;
                hues = 8;
                tries = 52;
                break;
            default:
                System.out.println("invalid input, loading medium difficulty");
                break;
        }
        loadColors(hues);
        Frame frame = new Frame(size,tries);
        frame.run();
    }

    static void loadColors(int i){
        colors = new ArrayList<>();
        ArrayList<Color> allColors = new ArrayList<>();
        allColors.add(Color.BLUE);
        allColors.add(Color.RED);
        allColors.add(Color.GREEN);
        allColors.add(Color.YELLOW);
        allColors.add(Color.CYAN);
        allColors.add(Color.PINK);
        allColors.add(Color.MAGENTA);
        allColors.add(Color.WHITE);
        Random r = new Random();
        for (int j = 0; j < i; j++) {
            colors.add(allColors.get(j));
        }
    }
}
