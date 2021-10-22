package  java09.package2;

import  java09.package1.Animal;

public class Dog extends Animal {
    public void test(){        
        name = "二コラ";
        age = 1;
        weight = 12;

        testPublic();     //OK
        testProtected();  //OK
        testPrivate();   //NG
    }
}
