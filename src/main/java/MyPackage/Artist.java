package MyPackage;

import java.util.*;

/**
 * Created by Valery on 1/27/2017.
 */
public class Artist {

    private ArrayList<Figure> figures;

    private void Init() {

        String figureName = "";
        Random randomizer = new Random();
        int newrandom = 0;
        int[] parameters = new int[4];

        for (int number = 0; number < 100; number++) {

            switch (randomizer.nextInt(4)) {
                case 0: figureName = "Square"; break;
                case 1: figureName = "Oval"; break;
                case 2: figureName = "Circle"; break;
                case 3: figureName = "Rectangular"; break;
            };
            parameters[0] = randomizer.nextInt();
            parameters[1] = randomizer.nextInt();
            parameters[2] = randomizer.nextInt(1000000) + 1;
            parameters[3] = randomizer.nextInt(1000000) + 1;
            figures.add(FigureFactory.getInstance().getFigure(figureName, parameters));

        }

    }

    public Artist() {
        figures = new ArrayList<Figure>(0);
        Init();
    }

    public void Paint(int quantity) {

        for (int number = 0; number < quantity; number++) {
            if (figures.isEmpty()) {
                Init();
            }
            System.out.println("#" + number + ":" + figures.remove(0).toString());
        }

    }

}
