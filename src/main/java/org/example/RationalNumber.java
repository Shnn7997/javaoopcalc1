package org.example;

public class RationalNumber implements Number {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Number add(Number num) {
        RationalNumber rnum = (RationalNumber) num;
        int lcm = findLCM(this.denominator, rnum.denominator);
        int newNumerator = (this.numerator * lcm / this.denominator) + (rnum.numerator * lcm / rnum.denominator);
        return new RationalNumber(newNumerator, lcm);
    }

    public Number subtract(Number num) {
        RationalNumber rnum = (RationalNumber) num;
        int lcm = findLCM(this.denominator, rnum.denominator);
        int newNumerator = (this.numerator * lcm / this.denominator) - (rnum.numerator * lcm / rnum.denominator);
        return new RationalNumber(newNumerator, lcm);
    }

    public Number multiply(Number num) {
        RationalNumber rnum = (RationalNumber) num;
        int newNumerator = this.numerator * rnum.numerator;
        int newDenominator = this.denominator * rnum.denominator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public Number divide(Number num) {
        RationalNumber rnum = (RationalNumber) num;
        int newNumerator = this.numerator * rnum.denominator;
        int newDenominator = this.denominator * rnum.numerator;
        return new RationalNumber(newNumerator, newDenominator);
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    private int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }

    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }
}
