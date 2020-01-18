package geometric.problem;

public class MainShapes {
    int cc;
    public static void main(String[] args) {
        Circle circle = getCircle();
        Triangle triangle = getTriangle();
        Rectangle rectangle = getRectangle();
        getArray(circle, triangle, rectangle);
        afisariEx1(circle, triangle, rectangle);
        int c  = 0 ;
        System.out.println(c);

    }

    private static void getArray(Circle circle, Triangle triangle, Rectangle rectangle) {
        Shape[] shapesArray = new Shape[3];
        shapesArray[0] = circle;
        shapesArray[1] = triangle;
        shapesArray[2] = rectangle;
    }

    private static Rectangle getRectangle() {
        Rectangle rectangle = new Rectangle();
        Point p5 = new Point(10, 10);
        Point p6 = new Point(10, 28);
        Point p7 = new Point(46, 28);
        Point p8 = new Point(46, 10);
        rectangle.setUl(p6);
        rectangle.setUr(p7);
        rectangle.setLl(p5);
        rectangle.setLr(p8);
        return rectangle;
    }

    private static Triangle getTriangle() {
        Triangle triangle = new Triangle();
        Point p2 = new Point(2, 1);
        Point p3 = new Point(10, 1);
        Point p4 = new Point(6, 7.928);
        triangle.setPoint2(p2);
        triangle.setPoint3(p3);
        triangle.setPoint4(p4);
        return triangle;
    }

    private static Circle getCircle() {
        Circle circle = new Circle();
        Point p1 = new Point(1, 1);
        circle.setRadius(2);
        circle.setPoint(p1);
        return circle;
    }

    private static void afisariEx1(Circle circle, Triangle triangle, Rectangle rectangle) {
        circle.computeArea();
        triangle.computeArea();
        triangle.computePerimeter();
        rectangle.computeArea();
        rectangle.computePerimeter();
        if (circle.isLargerThan(triangle) == false) {
            System.out.println("cercul mai mare");
        } else System.out.println("triunghiul este mai mare");
        double sumofArea = circle.computeArea() + triangle.computeArea() + rectangle.computeArea();
        double sumofPerimeters = circle.computePerimeter() + triangle.computePerimeter() + rectangle.computePerimeter();
        System.out.println("Suma tuturor ariilor este " + sumofArea);
        System.out.println("Suma tuturor perimetrelor este " + sumofPerimeters);
    }
}
