package org.example;

public class ComplexNumber implements Number {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Implement methods from Number interface
    public Number add(Number num) {
        ComplexNumber cnum = (ComplexNumber) num;
        double newReal = this.real + cnum.real;
        double newImaginary = this.imaginary + cnum.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public Number subtract(Number num) {
        ComplexNumber cnum = (ComplexNumber) num;
        double newReal = this.real - cnum.real;
        double newImaginary = this.imaginary - cnum.imaginary;
        return new ComplexNumber(newReal, newImaginary);
    }

    public Number multiply(Number num) {
        ComplexNumber cnum = (ComplexNumber) num;
        double newReal = (this.real * cnum.real) - (this.imaginary * cnum.imaginary);
        double newImaginary = (this.real * cnum.imaginary) + (this.imaginary * cnum.real);
        return new ComplexNumber(newReal, newImaginary);
    }

    public Number divide(Number num) {
        ComplexNumber cnum = (ComplexNumber) num;
        double denominator = (cnum.real * cnum.real) + (cnum.imaginary * cnum.imaginary);
        double newReal = ((this.real * cnum.real) + (this.imaginary * cnum.imaginary)) / denominator;
        double newImaginary = ((this.imaginary * cnum.real) - (this.real * cnum.imaginary)) / denominator;
        return new ComplexNumber(newReal, newImaginary);
    }

    public String toString() {
        return this.real + " + " + this.imaginary + "i";
    }

    // Getter methods
    public double getReal() {
        return this.real;
    }

    public double getImaginary() {
        return this.imaginary;
    }
}
