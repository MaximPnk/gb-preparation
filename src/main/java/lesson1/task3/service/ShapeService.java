package lesson1.task3.service;

import lesson1.task3.model.Shape;

public class ShapeService {

    public void description(Shape shape) {
        System.out.println("Describe our figure: it's a " + shape.getName());
    }

}
