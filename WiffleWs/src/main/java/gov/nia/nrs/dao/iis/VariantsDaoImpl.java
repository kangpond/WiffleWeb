/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.Variants;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Clare
 *
 */
@Repository("variantsDao")
@Transactional
public class VariantsDaoImpl extends BaseIISDaoImpl<Variants, String> implements VariantsDao {

  /*
   * (non-Javadoc)
   *
   * @see gov.nia.dao.VariantsDao#getVariantsByRank1(java.util.List)
   */
  @SuppressWarnings("unchecked")
  @Override
  public List<Variants> getVariantsByRank1(List<String> words) {
    return getSession().createQuery("from Variants where id.rank1 in (:words)")
        .setParameterList("words", words).list();
  }

}
