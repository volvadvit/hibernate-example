import dao.DAO;
import dao.EngineDAO;
import model.Car;
import model.Engine;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration().configure().buildSessionFactory()) {

            DAO<Engine, Integer> dao = new EngineDAO(factory);

//            read(dao);
//            update(dao);
//            delete(dao);
//            create(dao);
        }
    }

    private static void read(DAO<Engine, Integer> engineDao) {
        final Engine result = engineDao.read(1);
        System.out.println("Read: " + result);
    }

    private static void update(DAO<Engine, Integer> engineDao) {
        final Engine result = engineDao.read(1);
        result.setCarMark("lada");
        engineDao.update(result);
        System.out.println("Updated: " + engineDao.read(1));
    }

    private static void create(DAO<Engine, Integer> carDao) {
        Engine engine = new Engine();
        engine.setCarMark("test-mark");
        engine.setPower(1000);
        engine.setName("test-name");

        Car car1 = new Car();
        car1.setMark("test-mark");
        car1.setCost(10);

        Car car2 = new Car();
        car2.setMark("test-mark");
        car2.setCost(20);

        Set<Car> cars = new HashSet<>();
        cars.add(car1);
        cars.add(car2);
        engine.setCars(cars);

        carDao.create(engine);
    }


    private static void delete(DAO<Engine, Integer> engineDao) {
        Engine engine = engineDao.read(1);
        engineDao.delete(engine);
        System.out.println("After delete: " + engineDao.read(1));
    }
}