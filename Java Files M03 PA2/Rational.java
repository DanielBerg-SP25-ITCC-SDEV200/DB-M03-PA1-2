import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    // Default constructor: represents 0/1
    public Rational() {
        this.numerator = BigInteger.ZERO;
        this.denominator = BigInteger.ONE;
    }

    // Constructor with numerator and denominator
    public Rational(BigInteger numerator, BigInteger denominator) {
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        // Simplify the rational number by dividing both by their GCD
        BigInteger gcd = gcd(numerator, denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.abs().divide(gcd);

        // Make sure the denominator is positive
        if (denominator.signum() < 0) {
            this.numerator = this.numerator.negate();
            this.denominator = this.denominator.negate();
        }
    }

    // Helper method to calculate the GCD (greatest common divisor)
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        return n.gcd(d);
    }

    // Getters for numerator and denominator
    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    // Addition of two rational numbers
    public Rational add(Rational secondRational) {
        BigInteger n = this.numerator.multiply(secondRational.getDenominator())
                .add(this.denominator.multiply(secondRational.getNumerator()));
        BigInteger d = this.denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Subtraction of two rational numbers
    public Rational subtract(Rational secondRational) {
        BigInteger n = this.numerator.multiply(secondRational.getDenominator())
                .subtract(this.denominator.multiply(secondRational.getNumerator()));
        BigInteger d = this.denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Multiplication of two rational numbers
    public Rational multiply(Rational secondRational) {
        BigInteger n = this.numerator.multiply(secondRational.getNumerator());
        BigInteger d = this.denominator.multiply(secondRational.getDenominator());
        return new Rational(n, d);
    }

    // Division of two rational numbers
    public Rational divide(Rational secondRational) {
        BigInteger n = this.numerator.multiply(secondRational.getDenominator());
        BigInteger d = this.denominator.multiply(secondRational.getNumerator());
        return new Rational(n, d);
    }

    // Convert the rational number to a string representation (e.g., "3/4")
    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator.toString();
        } else {
            return numerator + "/" + denominator;
        }
    }

    // Convert rational number to double
    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    // Compare two rational numbers (used for Comparable interface)
    @Override
    public int compareTo(Rational other) {
        BigInteger diff = this.numerator.multiply(other.denominator)
                .subtract(this.denominator.multiply(other.numerator));
        return diff.signum();
    }

    // Override other required methods from Number class
    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }
}
