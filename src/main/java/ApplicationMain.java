import dao.EngineDao;
import dao.EngineDaoImpl;
import model.Engine;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

public class ApplicationMain {

    public static void main(String[] args) {

        SessionFactory factory = HibernateUtil.getSessionFactory();

        try {
            EngineDao<Engine, String> engineDAO = new EngineDaoImpl(factory);

            // CREATE
            final Engine engine = new Engine();
            engine.setModel("engine_model_03");
            engine.setPower(12345);
            engineDAO.create(engine);
            final Engine result = engineDAO.read("engine_model_03");
            System.out.println("Created : " + result);

            // UPDATE
            result.setPower(54321);
            engineDAO.update(result);
            final Engine update = engineDAO.read("engine_model_03");
            System.out.println("Updated : " + update);

            // DELETE
            engineDAO.delete(new Engine("engine_model_03", 54321));
            System.out.println("Deleted(empty obj) : " + engineDAO.read("engine_model_03"));
        } finally {
            if (factory != null) {
                HibernateUtil.shutdown();
            }
        }
    }
}