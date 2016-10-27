/**
 * 
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.Variants;

import java.util.List;

/**
 * @author Clare
 *
 */
public interface VariantsDao {

  /**
   * @param words
   * @return
   */
  public List<Variants> getVariantsByRank1(List<String> words);

}
