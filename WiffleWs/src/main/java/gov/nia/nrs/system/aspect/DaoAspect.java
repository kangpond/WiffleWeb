/**
 * 
 */
package gov.nia.nrs.system.aspect;

import gov.nia.nrs.utils.DomainUtils;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Clare
 *
 */
@Aspect
public class DaoAspect {

    /**
     * 
     */
    @Value("${maintain-host}")
    private String maintainHost;

    /**
     * 
     */
    @Before("execution(boolean com.googlecode.genericdao.dao.hibernate.GenericDAOImpl.save(..)) && args(entity)")
    public void beforeSave(Object entity) {
        try {
            PropertyUtils.setProperty(entity, "maintainHost", maintainHost);
        } catch (Exception e) {

        }

        try {
            PropertyUtils.setProperty(entity, "lastUpdateTime", new Date());
        } catch (Exception e) {

        }
    }

    /**
     * 
     */
    @Before("execution(boolean[] com.googlecode.genericdao.dao.hibernate.GenericDAOImpl.save(..)) && args(entitys)")
    public void beforeSave(Object[] entitys) {
        for (Object entity : entitys) {
            beforeSave(entity);
        }
    }

}
