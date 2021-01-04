package BO;

import BO.Custom.Impl.CourseBOImpl;
import BO.Custom.Impl.RegistrationBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    public enum BOTypes {
        STUDENT , REGISTER , COURSE;
    }
    public SuperBO getBO(BOTypes types) {
        switch (types) {
              case COURSE:
                  return new CourseBOImpl();
            case REGISTER:
                return new RegistrationBOImpl();

            default:
                return null;

        }
    }
}
