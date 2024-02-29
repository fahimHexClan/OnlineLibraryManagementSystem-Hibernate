package Ijse.Bo;



public class BOFactory {
    public static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        User
    }

    public SuperBO getBO(BOTypes boFactory) {
        switch (boFactory) {
            case User:
                return null;
            default:
                return null;
        }
    }


    }

