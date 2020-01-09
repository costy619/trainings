package geometric.problem;

public class Rectangle extends Shape {
    double length;
    double  height;
    private Point ul;
    private Point ur;
    private Point lr;
    private Point ll;
    public Rectangle(){
    }
    @Override
    public double computeArea(){
        length = Math.sqrt( (getUr().getX()- getUl().getX()) * (getUr().getX()- getUl().getX())  + (getUr().getY()- getUl().getY()) * (getUr().getY()- getUl().getY()) ); //calculates length
        height = Math.sqrt( (getUr().getX()- getLr().getX()) * (getUr().getX()- getLr().getX())  + (getUr().getY()- getLr().getY()) * (getUr().getY()- getLr().getY()) ); //calculates height
        return(length * height);
    }
    @Override
    public double computePerimeter() {
        double perimeter=2*(length +height);
        return perimeter;
    }

    @Override
    public void enlarge(double factor) {

    }

    public Point getUl() {
        return ul;
    }

    public void setUl(Point ul) {
        this.ul = ul;
    }

    public Point getUr() {
        return ur;
    }

    public void setUr(Point ur) {
        this.ur = ur;
    }

    public Point getLr() {
        return lr;
    }

    public void setLr(Point lr) {
        this.lr = lr;
    }

    public Point getLl() {
        return ll;
    }

    public void setLl(Point ll) {
        this.ll = ll;
    }
}
