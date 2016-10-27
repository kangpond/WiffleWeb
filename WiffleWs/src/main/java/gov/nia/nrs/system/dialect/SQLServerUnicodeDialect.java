/**
 * 
 */
package gov.nia.nrs.system.dialect;

import java.sql.Types;

import org.hibernate.dialect.SQLServer2012Dialect;


/**
 * @author Clare
 *
 */
public class SQLServerUnicodeDialect extends SQLServer2012Dialect {

    /**
     * 
     */
    public SQLServerUnicodeDialect() {
        super();

        registerColumnType(Types.NCHAR, 4000, "nchar($l)");
        registerColumnType(Types.NVARCHAR, 4000, "nvarchar($l)");
        registerColumnType(Types.NVARCHAR, "nvarchar(max)");
        registerColumnType(Types.LONGNVARCHAR, "nvarchar(max)");
        registerColumnType(Types.NCLOB, "nvarchar(max)");
    }

}
