package animals;

class Animal {
    public void makeNoise() {}
    public void eat() {}
    public void sleep() {}
    public void roam() {}
}

class Feline extends Animal {
    public void eat() {}
    public void roam() {}
}

class Canine extends Animal {
    public void eat() {}
    public void roam() {}
}

class Hippo extends Animal {
    public void makeNoise() {}
    public void eat() {}
    public void sleep() {}
    public void roam() {}
}

class Dog extends Canine implements Pet {
    public void beFriendly() {}
    public void play() {}
    public void eat() {}
    public void roam() {}
}

class Wolf extends Canine {
    public void eat() {}
    public void roam() {}
}

class Cat extends Feline implements Pet {
    public void beFriendly() {}
    public void play() {}
    public void eat() {}
    public void roam() {}
}

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        Cat myCat = new Cat();
        Hippo myHippo = new Hippo();

        myDog.beFriendly();
        myCat.play();
        myHippo.eat();
    }
}