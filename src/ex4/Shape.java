package ex4;

abstract class Shape {

    public abstract double computeArea();
    public abstract double computePerimeter();
    public abstract void enlarge(double factor);
    public boolean isLargerThan(Shape shape) {
        boolean b=true;
        Circle c= new Circle();
        if(this.computeArea()>shape.computeArea()){
            b=false;
        }
        return b;
    }
}
