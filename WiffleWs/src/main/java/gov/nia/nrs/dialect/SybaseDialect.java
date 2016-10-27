/**
 *
 */
package gov.nia.nrs.dialect;

import org.hibernate.dialect.SybaseASE15Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

/**
 * @author Clare
 *
 */
public class SybaseDialect extends SybaseASE15Dialect {

    /**
     *
     */
    public SybaseDialect() {
        super.registerFunction("dateadd", new StandardSQLFunction("dateadd", StandardBasicTypes.DATE));
    }

}
