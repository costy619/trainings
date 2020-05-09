package geometric.problem;


public class Triangle extends Shape {
    private double edge1;
    private double edge2;
    private double edge3;
    private Point point2;
    private Point point3;
    private Point point4;

    public Triangle() {
    }

    @Override
    public double computeArea() {
        double aria = (getPoint2().getX() * (getPoint3().getY() - getPoint4().getY()) + getPoint3().getX() * (getPoint4().getY() - getPoint2().getY()) + getPoint4().getX() * (getPoint2().getY() - getPoint3().getY())) / 2;
        return Math.abs(aria);
    }

    @Override
    public double computePerimeter() {
        edge1 = Math.sqrt((getPoint3().getY() - getPoint2().getY()) * (getPoint3().getY() - getPoint2().getY()) + ((getPoint3().getX() - getPoint2().getX()) * (getPoint3().getX() - getPoint2().getX())));
        edge2 = Math.sqrt((getPoint4().getY() - getPoint2().getY()) * (getPoint4().getY() - getPoint2().getY()) + ((getPoint4().getX() - getPoint2().getX()) * (getPoint4().getX() - getPoint2().getX())));
        edge3 = Math.sqrt((getPoint4().getY() - getPoint3().getY()) * (getPoint4().getY() - getPoint3().getY()) + ((getPoint4().getX() - getPoint3().getX()) * (getPoint4().getX() - getPoint3().getX())));
        double perimetru = edge1 + edge2 + edge3;
        return perimetru;

    }

    @Override
    public void enlarge(double factor) {
        double rezultat = factor;         //????
        // System.out.println(rezultat);
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    public Point getPoint4() {
        return point4;
    }

    public void setPoint4(Point point4) {
        this.point4 = point4;
    }
}