package MyPackage;

/**
 * Created by Aile (on Valery) on 1/29/2017.
 */
public class Canvas {

    private int width, height;

    //Canvas leftBottomPoint = (0, 0)

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
    }

    private void FitToCanvasSize(Figure figure) {

        if ((figure.rightBorder() - figure.leftBorder()) >= width) {
            figure.resizeXDimension(width);
            figure.translateX(-figure.leftBorder());
        } else if (figure.leftBorder() < 0) {
            figure.translateX(-figure.leftBorder());
        } else if (figure.rightBorder() > width) {
            figure.translateX(width - figure.rightBorder());
        }

        if ((figure.topBorder() - figure.bottomBorder()) >= height) {
            figure.resizeYDimension(height);
            figure.translateY(-figure.bottomBorder());
        } else if (figure.bottomBorder() < 0) {
            figure.translateY(-figure.bottomBorder());
        } else if (figure.topBorder() > height) {
            figure.translateY(height - figure.topBorder());
        }
    }

    public void Resize(int newWidth, int newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    public void Paint(Figure figure) {
        FitToCanvasSize(figure);
        System.out.println(figure.toString());
    }

}
