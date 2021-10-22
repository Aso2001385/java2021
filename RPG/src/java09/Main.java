package  java09;
import  java09.package2.Dog;

public class Main {
    public static void main(String[] args){
        Dog dog = new Dog();

        //アクセステスト
        dog.name = "二コラ";
        dog.age = 1;
        dog.weight = 12;
        
        dog.testPublic();     //OK
        dog.testProtected();  //NG
        dog.testPrivate();   //NG
    }
}



