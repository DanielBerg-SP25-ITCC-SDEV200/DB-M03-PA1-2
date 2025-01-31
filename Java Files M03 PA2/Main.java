import java.math.BigInteger;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
// Prompt the user to enter two Rational numbers
Scanner input = new Scanner(System.in);
System.out.print("Enter rational r1 with numerator and denominator separated by a space: ");
String n1 = input.next();
String d1 = input.next();

System.out.print("Enter rational r2 with numerator and denominator separated by a space: ");
String n2 = input.next();
String d2 = input.next();

// Create Rational objects
Rational r1 = new Rational(
  new BigInteger(n1), new BigInteger(d1));
Rational r2 = new Rational(
  new BigInteger(n2), new BigInteger(d2));

// Display results
System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
System.out.println(r2 + " is " + r2.doubleValue());
}
}