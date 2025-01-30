public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

   @Override
   public double getArea() {
        return radius * radius * Math.PI;
   }
    
    public double getDiameter() {
        return 2 * radius;
    }
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public boolean equals(Circle c){
        if(this.compareTo(c) == 0){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int compareTo(Circle o) {
        return (int)(this.getRadius()-o.getRadius());
    }
    public void printCircle() {
        System.out.println("The circle is created" + getDateCreated() + "and the radius is" + radius);
    }
}