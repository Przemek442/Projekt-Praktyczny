package pl.sda.racing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Test
    public void shouldSavePigeon() {
        //Given
        Pigeon pigeon = new Pigeon();
        pigeon.setName("Bielik");
        //When
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(pigeon);
        transaction.commit();
        session.close();

        Session sessionTEST = sessionFactory.openSession();
//        CriteriaBuilder criteriaBuilder = sesionTEST.getCriteriaBuilder();
        CriteriaQuery<Pigeon> cr = sessionTEST.getCriteriaBuilder().createQuery(Pigeon.class);
        Root<Pigeon> root = cr.from(Pigeon.class);
        Query<Pigeon> query = sessionTEST.createQuery(cr);
        List<Pigeon> result = query.getResultList();
        sessionTEST.close();
//Then
        assertEquals(1, result.size());
        assertEquals("Bielik", result.get(0).getName());

    }

    void afterTest(){
        sessionFactory.close();
    }
}