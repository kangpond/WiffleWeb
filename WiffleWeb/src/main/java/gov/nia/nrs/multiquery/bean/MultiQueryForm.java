package gov.nia.nrs.multiquery.bean;

import gov.nia.nrs.multiquery.enums.ChartTypeEnum;
import gov.nia.nrs.multiquery.enums.QueryAttrEnum;
import gov.nia.nrs.multiquery.enums.TableNameEnum;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MultiQueryForm
{
	private String xlsSheetName;
	private List<String> headerList;
	private TreeMap<Integer, QueryAttrEnum> colAttrMap;
	private TreeMap<Integer, QueryAttrEnum> rowAttrMap;
	private TableNameEnum table;
	private String whereFilter;
	private Map<String, String> paramMap;
	/** "列"欄是否需要合計欄。null:預設要合計欄 */
	private Boolean needRowSum;
	/** "欄"欄是否需要合計欄。null:預設要合計欄 */
	private Boolean needColSum;
	private ChartTypeEnum chartType;

	public List<String> getHeaderList()
	{
		return headerList;
	}

	public void setHeaderList(List<String> headerList)
	{
		this.headerList = headerList;
	}

	public String getXlsSheetName()
	{
		return xlsSheetName;
	}

	public void setXlsSheetName(String xlsSheetName)
	{
		this.xlsSheetName = xlsSheetName;
	}

	public TreeMap<Integer, QueryAttrEnum> getColAttrMap()
	{
		return colAttrMap;
	}

	public void setColAttrMap(TreeMap<Integer, QueryAttrEnum> colAttrMap)
	{
		this.colAttrMap = colAttrMap;
	}

	public TreeMap<Integer, QueryAttrEnum> getRowAttrMap()
	{
		return rowAttrMap;
	}

	public void setRowAttrMap(TreeMap<Integer, QueryAttrEnum> rowAttrMap)
	{
		this.rowAttrMap = rowAttrMap;
	}

	public TableNameEnum getTable()
	{
		return table;
	}

	public void setTable(TableNameEnum table)
	{
		this.table = table;
	}

	public String getWhereFilter()
	{
		return whereFilter;
	}

	public void setWhereFilter(String whereFilter)
	{
		this.whereFilter = whereFilter;
	}

	public Map<String, String> getParamMap()
	{
		return paramMap;
	}

	public void setParamMap(Map<String, String> paramMap)
	{
		this.paramMap = paramMap;
	}

	public Boolean getNeedRowSum()
	{
		return needRowSum;
	}

	public void setNeedRowSum(Boolean needRowSum)
	{
		this.needRowSum = needRowSum;
	}

	public Boolean getNeedColSum()
	{
		return needColSum;
	}

	public void setNeedColSum(Boolean needColSum)
	{
		this.needColSum = needColSum;
	}

	public ChartTypeEnum getChartType()
	{
		return chartType;
	}

	public void setChartType(ChartTypeEnum chartType)
	{
		this.chartType = chartType;
	}

	@Override
	public String toString()
	{
		return "MultiQueryForm [xlsSheetName=" + xlsSheetName + ", headerList=" + headerList + ", colAttrMap="
				+ colAttrMap + ", rowAttrMap=" + rowAttrMap + ", table=" + table + ", whereFilter=" + whereFilter
				+ ", paramMap=" + paramMap + ", needRowSum=" + needRowSum + ", needColSum=" + needColSum
				+ ", chartType=" + chartType + "]";
	}
}
