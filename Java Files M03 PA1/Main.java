public class Main {
    // Main.java: Main class to test GeometricObject and Triangle
    public static void main(String[] args) {
      Circle A = new Circle(1.0);
      Circle B = new Circle(1.0);
      Circle C = new Circle(2.0);
      System.out.println("Circle A is equal to Circle B: ");
      System.out.println(A.equals(B));
      System.out.println("Circle A is equal to Circle C: ");
      System.out.println(A.equals(C));
    }
}
  
