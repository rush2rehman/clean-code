package com.krahman.effectivejava.createdestroyobject.uninstantiable;

/*
To Make sure that Utility/Constant classes are not instantiated
1. A proper comment
2. Private construtor
3. An assertion error
 */

public class JSONUtil {

    public static void someUtility(){

    }
    //To ensure this class is not accidentally instantiated
    private JSONUtil(){
        throw new AssertionError();
    }
}
