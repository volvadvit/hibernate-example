import dao.EngineDao;
import dao.EngineDaoImpl;
import model.Engine;
import org.hibernate.SessionFactory;
import util.HibernateSessionFactory;

public class ApplicationMain {

    public static void main(String[] args) {

        SessionFactory factory = HibernateSessionFactory.getSessionFactory();

        try {
            EngineDao<Engine, String> engineDAO = new EngineDaoImpl(factory);

            // CREATE
            final Engine engineForUpdate = new Engine("engine_model_01", 12345);
            final Engine engineForDelete = new Engine("engine_model_03", 12345);
            engineDAO.create(engineForUpdate);
            engineDAO.create(engineForDelete);

            // READ
            final Engine result = engineDAO.read("engine_model_03");
            System.out.println("CREATE : " + result);

            // UPDATE
            result.setPower(54321);
            engineDAO.update(result);
            final Engine update = engineDAO.read("engine_model_03");
            System.out.println("UPDATE : " + update);

            // DELETE
            engineDAO.delete(new Engine("engine_model_03", 54321));
            System.out.println("AFTER DELETE : " + engineDAO.read("engine_model_03"));

            // SAVE OR UPDATE
            engineForUpdate.setPower(54321);
            engineDAO.saveOrUpdate(engineForUpdate);
            System.out.println("SAVE OR UPDATE :" + engineDAO.read("engine_model_01"));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            // SHUTDOWN CONNECTION
            if (factory != null) {
                HibernateSessionFactory.shutdown();
            }
        }
    }
}