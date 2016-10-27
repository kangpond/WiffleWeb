/**
 *
 */
package gov.nia.nrs.dao.imm;

import gov.nia.nrs.dataquery.bean.PassportVo;
import gov.nia.nrs.domain.imm.Passengers;

import java.util.List;

/**
 * @author Jay Lin
 *
 */
public interface PassengersDao {
    public List<Passengers> queryByPassportNoList(List<PassportVo> passportVoList);

    public List<Passengers> queryByPersonId(String personId, String birthDate);

    public List<Passengers> queryByFirstRecvNo(String firstReceiveNo);
}
