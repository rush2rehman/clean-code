package successive_refactoring;

import java.util.ListIterator;

public class BooleanArgumentMarshaller implements ArgumentMarshaller {

    private boolean booleanValue = false;

    @Override
    public void set(ListIterator<String> argumentListIterator) throws ArgumentException {
        booleanValue = true;

    }

    public static boolean getValue(ArgumentMarshaller argumentMarshaller)
    {
        if(argumentMarshaller != null && argumentMarshaller instanceof BooleanArgumentMarshaller)
            return ((BooleanArgumentMarshaller)argumentMarshaller).booleanValue;
        else
            return false;
    }
}
