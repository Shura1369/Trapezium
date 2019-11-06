package com.company;

public class Trapezium implements IInfo, IFigure{
    private double lowerBase;
    private double upperBase;
    private double leftSide;
    private double rightSide;
    private double leftAngle;
    private double rightAngle;
    private double midLine;
    private double height;

    //constructors
    public Trapezium() {    }


    public Trapezium(double lowerBase, double upperBase, double leftSide,
                     double rightSide) {
        this.lowerBase = lowerBase;
        this.upperBase = upperBase;
        this.leftSide = leftSide;
        this.rightSide = rightSide;
        //this.leftAngle = leftAngle;
        this.leftAngle = Math.acos((Math.pow(leftSide, 2) + Math.pow(lowerBase - upperBase, 2) - Math.pow(rightSide, 2))
            / (2 * leftSide * (lowerBase - upperBase)));
        //this.rightAngle = rightAngle;
        this.rightAngle = Math.acos((Math.pow(rightSide, 2 ) + Math.pow(lowerBase - upperBase, 2) - Math.pow(leftSide, 2))
            /(2 * rightSide * (lowerBase - upperBase)));
        midLine = (lowerBase + upperBase) / 2;
        height = leftSide * Math.sin(leftAngle);
    }

    //getters setters
    public double getLowerBase() {
        return lowerBase;
    }

    public void setLowerBase(double lowerBase) {
        this.lowerBase = lowerBase;
    }

    public double getUpperBase() {
        return upperBase;
    }

    public void setUpperBase(double upperBase) {
        this.upperBase = upperBase;
    }

    public double getLeftSide() {
        return leftSide;
    }

    public void setLeftSide(double leftSide) {
        this.leftSide = leftSide;
    }

    public double getRightSide() {
        return rightSide;
    }

    public void setRightSide(double rightSide) {
        this.rightSide = rightSide;
    }

    public double getLeftAngle() {
        return leftAngle;
    }

    public double getRightAngle() {
        return rightAngle;
    }

    public double getMidLine() {
        return midLine;
    }

    public double getHeight() {
        return height;
    }
    public double getPerimeter(){
        return upperBase + lowerBase + rightSide + leftSide;
    }

    public double getArea(){
        return midLine * height;
    }

    public Boolean isValid(){
        if(leftSide < height || rightSide < height)
            return false;
        else if(lowerBase <= upperBase)
            return false;
        else if(leftSide == rightSide && leftSide == height)
            return false;
        return true;
    }

    public Boolean isIsosceles(){
        return leftAngle == rightAngle;
    }

    public Boolean isRight(){
        return Math.round(leftAngle * 180 / Math.PI) == 90 || Math.round(rightAngle * 180 / Math.PI) == 90;
    }

    @Override
    public String toString() {
        return String.format("Lower base: %.2f\nUpper base: %.2f\nLeft side: %.2f" +
                "\nRight side: %.2f\nLeft angle: %.2f\nRight angle: %.2f" +
                 "\nMidline: %.2f\nHeight: %.2f\nPerimeter: %.2f\nArea: %.2f",
                this.lowerBase, this.upperBase, this.leftSide, this.rightSide,
                this.leftAngle * 180 / Math.PI, this.rightAngle * 180 / Math.PI,
                this.midLine, this.height, this.getPerimeter(), this.getArea());
    }

    @Override
    public String toJson() {
        return String.format("\"Upper base\" : %.2f\n\"Lower base\" : %.2f\n" +
                "\"Left side\" : %.2f\n\"Right side\" : %.2f", upperBase, lowerBase, leftSide, rightSide);
    }

    @Override
    public String toXML() {
        return String.format("<Trapezium>\n<upperBase>%.2f</upperBase>\n" +
                "<lowerBase>%.2f</lowerBase>\n<leftSide>%.2f</leftSide>\n" +
                "<rightSide>%.2f</rightSide>\n</Trapezium>",upperBase, lowerBase, leftSide,
                rightSide);
    }

    @Override
    public void show() {
        System.out.printf("Lower base: %.2f\nUpper base: %.2f\nLeft side: %.2f" +
                        "\nRight side: %.2f\nLeft angle: %.2f\nRight angle: %.2f" +
                        "\nMidline: %.2f\nHeight: %.2f\nPerimeter: %.2f\nArea: %.2f",
                this.lowerBase, this.upperBase, this.leftSide, this.rightSide,
                this.leftAngle * 180 / Math.PI, this.rightAngle * 180 / Math.PI,
                this.midLine, this.height, this.getPerimeter(), this.getArea());
    }


}
