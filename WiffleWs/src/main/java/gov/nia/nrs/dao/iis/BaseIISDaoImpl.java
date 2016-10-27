package gov.nia.nrs.dao.iis;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;

/**
 * @author Clare
 *
 */
@Transactional
public abstract class BaseIISDaoImpl<T, ID extends Serializable> extends GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {

    /*
     * (non-Javadoc)
     * 
     * @see com.googlecode.genericdao.dao.hibernate.HibernateBaseDAO#setSessionFactory(org.hibernate.SessionFactory)
     */
    @Autowired
    @Qualifier("iisSessionFactory")
    @Override
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

}
