package sample.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import sample.Bubble;
import sample.dao.BubbleDao;

import javax.inject.Inject;
import java.util.List;

/**
 * @author berinle
 */
@Repository
public class BubbleHibernateDao implements BubbleDao {

    @Inject
    private SessionFactory sessionFactory;
    
    public Long addBubble(Bubble b) {
        return (Long) sessionFactory.getCurrentSession().save(b);
    }

    @SuppressWarnings("unchecked")
    public List<Bubble> getBubbles() {
        return sessionFactory.getCurrentSession().createCriteria(Bubble.class).list();
    }
}
