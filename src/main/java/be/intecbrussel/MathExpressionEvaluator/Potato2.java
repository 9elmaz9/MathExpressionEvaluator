package be.intecbrussel.MathExpressionEvaluator;

public class Potato2 {
    public static void main(String[] args) {
        Potato2 potato2[]=new Potato2[5];
        potato2[0]=new Potato2();
        potato2[1]=new Potato2();
        potato2[2]=new Potato2();
        potato2[3]=new Potato2();
        potato2[4]=new Potato2();

       // countPotatoes(potato2);
        Potato2 superPotato=new Potato2();

        //countPotatoes(new Potato2(),new Potato2(),new Potato2(),new Potato2(),new Potato2(),new Potato2(),new Potato2(),superPotato);

    }

    public  static void countPotatoes(int a,Potato2... potatoes){
   // public void countPotatoes(Potato2[] potatoes){    original
        System.out.println(potatoes.length);
    }
}
