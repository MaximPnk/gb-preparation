package lesson1.task3;

import lesson1.task3.model.Circle;
import lesson1.task3.model.Shape;
import lesson1.task3.model.Square;
import lesson1.task3.service.ShapeService;

public class Main {

    private static final ShapeService shapeService;

    static {
        shapeService = new ShapeService();
    }

    public static void main(String[] args) {
        shapeService.description(new Shape("shape-1"));
        shapeService.description(new Circle("circle-1"));
        shapeService.description(new Circle("circle-2"));
        shapeService.description(new Square("square-1"));
    }

}
