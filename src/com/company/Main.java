package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Trapezium t = new Trapezium(6,5,10,9.949874);
        if(t.isValid()){
            System.out.println(t);
            System.out.println(t.isRight()? "Trapezium is right" : "Trapezium is not right");
        }
        else
            System.out.println("Invalid figure");

        System.out.println(t.toJson() + "\n");
        System.out.println(t.toXML() + "\n");
        t.show();

        List<Trapezium> trapezList = new ArrayList<>();
        trapezList.add(new Trapezium(6,4,3,3));
        trapezList.add(t);

        double totalArea = 0;
        for(Trapezium trap:trapezList)
            totalArea += trap.getArea();


        totalArea = trapezList.stream().mapToDouble(tr->tr.getArea()).sum();

        List<IFigure> figures = new ArrayList<>();
        figures.add(t);
        figures.add(new Trapezium(6,5,3,3));
        double combArea = figures.stream().mapToDouble(tr->tr.getArea()).sum();
    }
}
