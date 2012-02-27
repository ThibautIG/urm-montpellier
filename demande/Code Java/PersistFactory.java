
abstract class PersistFactory {
  private PersistFactory() {
  }

  public static PersistFactory getInstance()
  {
  }

  abstract Teacher createTeacher( ,  ) ;

  private static PersistFactory PersistFactory;

  public abstract Teaching createTeaching() ;

  abstract Booking createBooking() ;

  abstract Feature createFeature() ;

  abstract Schedule createSchedule() ;

  abstract Manager createManager() ;

}
