package successive_refactoring;

import com.sun.org.apache.xpath.internal.Arg;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class IntegerArgumentMarshaller implements ArgumentMarshaller {

    private int integerValue;

    @Override
    public void set(ListIterator<String> argumentListIterator) throws ArgumentException {

        try {
            String argument = argumentListIterator.next();
            integerValue = Integer.parseInt(argument);
        }
        catch(NoSuchElementException | NumberFormatException e){
            throw new ArgumentException();
        }
     }

     public static int getValue(ArgumentMarshaller argumentMarshaller) throws ArgumentException {
         if(argumentMarshaller != null && argumentMarshaller instanceof IntegerArgumentMarshaller){
             return ((IntegerArgumentMarshaller)argumentMarshaller).integerValue;
         }
         else{
             return 0;
         }
     }
}
