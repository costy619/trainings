package ex4;
class Circle extends Shape {

    private Point point;
    private double radius;
    public Circle(){
    }

    @Override
    public double computeArea() {
        double arie= getRadius()*getRadius()*3.14;
        return arie;
    }

    @Override
    public double computePerimeter() {
        return getRadius()*2*3.14;
    }

    @Override
    public void enlarge(double factor) {

    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
