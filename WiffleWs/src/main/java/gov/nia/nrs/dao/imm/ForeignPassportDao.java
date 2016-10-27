/**
 *
 */
package gov.nia.nrs.dao.imm;

import gov.nia.nrs.dataquery.bean.PassportVo;
import gov.nia.nrs.domain.imm.ForeignPassport;

import java.util.List;

/**
 * @author Jay Lin
 *
 */
public interface ForeignPassportDao {
    public List<ForeignPassport> queryByPassportNoList(List<PassportVo> passportVoList);
}
