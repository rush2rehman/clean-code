package com.krahman.effectivejava.createdestroyobject.dependencyinjection;

import java.util.function.Supplier;

/*
When a class's behavior is dependent on another class it is not correct to non instantiable static instances or
singletons. This makes the class non reusable and not testable.
We should allow instantiation of this class with appropriate veriation of the dependency to be injected upon creation.
This is called dependency injection.
This will make the class
1. Testable(as we could inject mocks)
2. Flexible
3. Reusable

Spring has multiple scopes. By default, everyting is singleton. Prototype scope will inject a new object everytime.
 */

public class SpellChecker {

    private static final Dictionary dictionary = new Dictionary();

    private SpellChecker(){} //non instantiable

    //All methods are static
}


class SpellCheckerSingleton{

    private final Dictionary dictionary = new Dictionary();

    private SpellCheckerSingleton(){}

    public static final SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    //methods
}

class SpellCheckerAutoWired1{

    private Dictionary dictionary;

    public SpellCheckerAutoWired1(Dictionary dictionary){
        this.dictionary = dictionary;
    }
}


//Suppliers are a perfect way of specifying DI
class SpellCheckerAutoWired2{

    private Dictionary dictionary;

    public SpellCheckerAutoWired2(Supplier<? extends Dictionary> dictionaryFactory){
        this.dictionary = dictionaryFactory.get();
    }

}

class Dictionary{

}
