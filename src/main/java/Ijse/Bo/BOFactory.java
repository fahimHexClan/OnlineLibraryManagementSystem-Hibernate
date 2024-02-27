package Ijse.Bo;


import lk.Ijse.Bo.custom.impl.StudentBoImpl;

public class BOFactory {
    public static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        Student
    }

    public SuperBO getBO(BOTypes boFactory) {
        switch (boFactory) {
            case Student:
                return (SuperBO) new StudentBoImpl();
            default:
                return null;
        }
    }


    }

