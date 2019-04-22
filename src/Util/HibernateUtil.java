package Util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;

import java.util.Map;

public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;
    public static final ThreadLocal<Session> session
            = new ThreadLocal<Session>();

    static {
        try {
            ourSessionFactory = new Configuration().
                    configure("hibernate.cfg.xml").
                    buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void closeSession()
            throws HibernateException {
        Session s = session.get();
        if (s != null)
            s.close();
        session.set(null);
    }
}
