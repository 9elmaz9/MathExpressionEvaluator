package be.intecbrussel.MathExpressionEvaluator;

import java.lang.invoke.StringConcatException;

public class Potato {


    // initializatie
    // & was private
    public double weight = 5.5;
    public String color = "blue";
    public static String help = "help";

    //System.out.println("hello"); - error,  niet hier ? deze plats niet voor sop
    //BUT

    {
        System.out.println("We made a potato"); // werk- INITIALIZATIE BLOCK , we kunnen kod bhier toevoegen
    } // voor elke new potato schrijf -  We made a potato


    static { // 1 keer uitgevoerd- We made a potato , maar we kunner creeren veel new potato
        System.out.println("We made a potato"); // werk- INITIALIZATIE BLOCK , we kunnen kod bhier toevoegen
    }


    // {  //initializatie block uitgevoerd
    //     this.color = "black";
    // }

    public Potato(String color) {  //construct - color veranderet
        System.out.println("We made a potato");
        this.color = color;
    }


    public Potato(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public Potato(double weight) {
        System.out.println("We made a potato");
        this.weight = weight;
    }

    public static void main(String[] args) {
        System.out.println("We made a potato ");
        // Potato p=new Potato("Yellow");  // verandert color
        // Potato p = new Potato();  // verandert color
        Potato p = new Potato("Yellow", 5.5);  // verandert color
        Potato p2 = new Potato("Yellow", 5.5);  // verandert color
        Potato p3 = new Potato("Yellow", 5.5);  // verandert color
        Potato p4 = new Potato("Yellow", 5.5);  // verandert color
        Potato p5 = new Potato("Yellow", 5.5);  // verandert color
        Potato p6 = new Potato("Yellow", 5.5);  // verandert color


        System.out.println(p.color);
        System.out.println(p.weight);
    }

    public static void whatDidWEMake() {
        System.out.println("A POTATO!!!!!");

    }

}

class Main {
    public static void main(String[] args) {
        //Potato potato;
        Potato.whatDidWEMake();
        //System.out.println(Potato.class);
        System.out.println(Potato.help);

    }

}