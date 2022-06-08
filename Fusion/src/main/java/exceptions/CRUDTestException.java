package exceptions;

public class CRUDTestException extends Exception{

    public CRUDTestException(String m){
        super(m);
    }

    public CRUDTestException(String m, Throwable t){
        super(m, t);
    }

}
