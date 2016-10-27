/**
 *
 */
package gov.nia.nrs.dialect;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.usertype.UserType;

/**
 * @author Clare
 *
 */
public class NStringUserType implements UserType {

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable, java.lang.Object)
     */
    @Override
    public Object assemble(Serializable arg0, Object arg1) throws HibernateException {
        return deepCopy(arg0);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
     */
    @Override
    public Object deepCopy(Object arg0) throws HibernateException {
        return arg0 == null ? null : arg0.toString();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
     */
    @Override
    public Serializable disassemble(Object arg0) throws HibernateException {
        return (Serializable) deepCopy(arg0);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#equals(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean equals(Object arg0, Object arg1) throws HibernateException {
        if (arg0 == null) {
            return arg1 == null;
        }

        return arg0.equals(arg1);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
     */
    @Override
    public int hashCode(Object arg0) throws HibernateException {
        return arg0.hashCode();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#isMutable()
     */
    @Override
    public boolean isMutable() {
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, java.lang.String[], org.hibernate.engine.spi.SessionImplementor, java.lang.Object)
     */
    @Override
    public Object nullSafeGet(ResultSet arg0, String[] arg1, SessionImplementor arg2, Object arg3) throws HibernateException, SQLException {
        String result = arg0.getString(arg1[0]);

        return result == null || result.trim().length() == 0 ? null : result;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement, java.lang.Object, int, org.hibernate.engine.spi.SessionImplementor)
     */
    @Override
    public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2, SessionImplementor arg3) throws HibernateException, SQLException {
        if (arg1 == null) {
            arg0.setNull(arg2, Types.NVARCHAR);
        } else {
            arg0.setNString(arg2, arg1.toString());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#replace(java.lang.Object, java.lang.Object, java.lang.Object)
     */
    @Override
    public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {
        return deepCopy(arg0);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#returnedClass()
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Class returnedClass() {
        return String.class;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#sqlTypes()
     */
    @Override
    public int[] sqlTypes() {
        return new int[] {Types.NVARCHAR};
    }

}
