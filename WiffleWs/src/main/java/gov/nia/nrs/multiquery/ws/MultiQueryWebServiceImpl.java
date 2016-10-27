package gov.nia.nrs.multiquery.ws;

import gov.nia.nrs.dao.MultiQueryDao;
import gov.nia.nrs.domain.iis.DataSetting;
import gov.nia.nrs.multiquery.bean.ChartData;
import gov.nia.nrs.multiquery.bean.CityChartData;
import gov.nia.nrs.multiquery.bean.CityTipsData;
import gov.nia.nrs.multiquery.bean.DataSettingBean;
import gov.nia.nrs.multiquery.bean.MultiQueryForm;
import gov.nia.nrs.multiquery.bean.QueryAttrInfo;
import gov.nia.nrs.multiquery.bean.QueryAttrStorage;
import gov.nia.nrs.multiquery.enums.CityLocationEnum;
import gov.nia.nrs.multiquery.enums.QueryAttrEnum;
import gov.nia.nrs.multiquery.enums.TableNameEnum;
import gov.nia.nrs.utils.StringUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Resource;

import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Alignment;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MultiQueryWebServiceImpl implements MultiQueryWebService
{
	private static final Logger logger = Logger.getLogger(MultiQueryWebServiceImpl.class);

	@Resource
	MultiQueryDao multiQueryDao;

	@Override
	public List<DataSettingBean> queryDataSetting(String codeId) throws Exception
	{
		logger.debug("queryDataSetting, codeId=" + codeId);
		if (StringUtil.isEmpty(codeId))
		{
			logger.error("queryDataSetting format error");
			throw new Exception("format error");
		}

		List<DataSettingBean> resultList = new ArrayList<DataSettingBean>();
		try
		{
//			List<DataSetting> dataSettingList = multiQueryDao.queryDataSetting(codeId);
			List<DataSetting> dataSettingList = getAttrDataSetting(codeId);
			if (dataSettingList != null && dataSettingList.size() > 0)
			{
				for (DataSetting ds : dataSettingList)
				{
					DataSettingBean data = new DataSettingBean();
					BeanUtils.copyProperties(ds, data);
					resultList.add(data);
				}
				return resultList;
			}
			return null;
		}
		catch (Exception e)
		{
			logger.error("queryDataSetting error", e);
			throw e;
		}
	}

	@Override
	public List<DataSettingBean> queryDataSettingByList(List<String> codeIdList) throws Exception
	{
		logger.debug("queryDataSettingByList, codeIdList=" + codeIdList);
		if (codeIdList == null || codeIdList.size() <= 0)
		{
			logger.error("queryDataSettingByList format error");
			throw new Exception("format error");
		}

		List<DataSettingBean> resultList = new ArrayList<DataSettingBean>();
		try
		{
			List<DataSetting> dataSettingList = multiQueryDao.queryDataSettingByList(codeIdList);
			if (dataSettingList != null && dataSettingList.size() > 0)
			{
				for (DataSetting ds : dataSettingList)
				{
					DataSettingBean data = new DataSettingBean();
					BeanUtils.copyProperties(ds, data);
					resultList.add(data);
				}
				return resultList;
			}
			return null;
		}
		catch (Exception e)
		{
			logger.error("queryDataSettingByList error", e);
			throw e;
		}
	}

	private List<DataSetting> getAttrDataSetting(String codeId) throws Exception
	{
		return getAttrDataSetting(codeId, null);
	}

	private List<DataSetting> getAttrDataSetting(String codeId, Map<String, String> paramMap) throws Exception
	{
		List<DataSetting> dsList = new ArrayList<DataSetting>();
		if (codeId.contains("-"))
		{
			String startCodeId = codeId.split("-")[0];
			String endCodeId = codeId.split("-")[1];

			List<String> codeIdList = new ArrayList<String>();
			for (int i = Integer.parseInt(startCodeId); i <= Integer.parseInt(endCodeId); i++)
			{
				codeIdList.add(String.valueOf(i));
			}
			dsList = multiQueryDao.queryDataSettingByList(codeIdList);
		}
		else
		{
			if (codeId.startsWith("Z"))
			{
				if (QueryAttrStorage.Instance().getAttrMap().containsKey(codeId))
				{
					Map<String, String> attrMap = QueryAttrStorage.Instance().getAttrMap().get(codeId);
					for (String key : attrMap.keySet())
					{
						DataSetting ds = new DataSetting();
						ds.setCodeDataValue(key);
						ds.setCodeDataValueDesc(attrMap.get(key));
						dsList.add(ds);
					}
				}
				else
				{
					logger.error("getAttrDataSetting error, codeId=" + codeId);
				}
			}
			else if (codeId.startsWith("Y"))
			{
				if (QueryAttrEnum.CityTown.getCodeId().equals(codeId))
				{
					List<DataSetting> cityTownList = groupCityTownDs(QueryAttrEnum.CityA, QueryAttrEnum.TownshipA, paramMap);
					dsList.addAll(cityTownList);
				}
				else if (QueryAttrEnum.TwSpCityTown.getCodeId().equals(codeId))
				{
					List<DataSetting> cityTownList = groupCityTownDs(QueryAttrEnum.TwSpCity, QueryAttrEnum.TwSpTownship, paramMap);
					dsList.addAll(cityTownList);
				}
				else if (QueryAttrEnum.YearMonth.getCodeId().equals(codeId))
				{
					int sYear = Calendar.getInstance().get(Calendar.YEAR);
					int eYear = Calendar.getInstance().get(Calendar.YEAR);
					if (paramMap != null && StringUtil.isNumeric(paramMap.get("sYear")))
						sYear = Integer.parseInt(paramMap.get("sYear"));
					if (paramMap != null && StringUtil.isNumeric(paramMap.get("eYear")))
						eYear = Integer.parseInt(paramMap.get("eYear"));
					int sMonth = 1;
					int eMonth = 12;
					if (paramMap != null && StringUtil.isNumeric(paramMap.get("sMonth")))
						sMonth = Integer.parseInt(paramMap.get("sMonth"));
					if (paramMap != null && StringUtil.isNumeric(paramMap.get("eMonth")))
						eMonth = Integer.parseInt(paramMap.get("eMonth"));

					for(int year = sYear; year <= eYear; year++)
					{
						for (int month = 1; month <= 12; month++)
						{
							if (year == sYear && month < sMonth) {
								continue;//尚未到達第一年起始月份
							}

							StringBuffer value = new StringBuffer();
							value.append(String.format("%s_%d", QueryAttrEnum.Year.getColumnName(), year));
							value.append(String.format(",%s_%s", QueryAttrEnum.Month.getColumnName(),
									StringUtil.padLeft(String.valueOf(month), 2, '0')));
							StringBuffer desc = new StringBuffer();
							desc.append(String.format("%d年%s月", year, StringUtil.padLeft(String.valueOf(month), 2, '0')));

							//組合新的年月DataSetting
							DataSetting yearMonthDs = new DataSetting();
							yearMonthDs.setCodeDataValue(value.toString());
							yearMonthDs.setCodeDataValueDesc(desc.toString());
							dsList.add(yearMonthDs);

							if (year == eYear && month == eMonth)
							{
								break;//已到達最後一年終止月份
							}
						}
					}
				}
			}
			else if (codeId.startsWith("X"))
			{
				String cId = codeId.substring(1, codeId.length());
				dsList = getAttrDataSetting(cId);
			}
			else
			{
				dsList = multiQueryDao.queryDataSetting(codeId);
			}
		}
		return dsList;
	}

	private List<DataSetting> groupCityTownDs(QueryAttrEnum cityEnum, QueryAttrEnum townEnum,
			Map<String, String> paramMap) throws Exception
	{
		List<DataSetting> dsList = new ArrayList<DataSetting>();
		List<DataSetting> cityDsList = getAttrDataSetting(cityEnum.getCodeId(), paramMap);
		for (DataSetting cityDs : cityDsList)
		{
			if (paramMap != null && !StringUtil.isEmpty(paramMap.get(cityEnum.getColumnName()))
					&& !paramMap.get(cityEnum.getColumnName()).equals(cityDs.getCodeDataValue()))
			{
				// 若有傳縣市的CodeDataValue，則只顯示該縣市的資料
				continue;
			}
			List<DataSetting> townDsList = multiQueryDao.queryTownDs(cityDs.getCodeDataValue());
			for (DataSetting townDs : townDsList)
			{
				if (paramMap != null && !StringUtil.isEmpty(paramMap.get(townEnum.getColumnName()))
						&& !paramMap.get(townEnum.getColumnName()).equals(townDs.getCodeDataValue()))
				{
					// 若有傳鄉鎮的CodeDataValue，則只顯示該鄉鎮的資料
					continue;
				}
				StringBuffer value = new StringBuffer();
				value.append(String.format("%s_%s", cityEnum.getColumnName(), cityDs.getCodeDataValue()));
				value.append(String.format(",%s_%s", townEnum.getColumnName(), townDs.getCodeDataValue()));

				StringBuffer desc = new StringBuffer();
				desc.append(String.format("%s%s", cityDs.getCodeDataValueDesc(), townDs.getCodeDataValueDesc()));

				//組合新的城市鄉鎮DataSetting
				DataSetting cityTownDs = new DataSetting();
				cityTownDs.setCodeDataValue(value.toString());
				cityTownDs.setCodeDataValueDesc(desc.toString());
				dsList.add(cityTownDs);
			}
		}
		return dsList;
	}

	@Override
	public List<DataSettingBean> queryTownDs(String cityCodeValue) throws Exception
	{
		logger.debug("queryTownDs, cityCodeValue=" + cityCodeValue);
		if (StringUtil.isEmpty(cityCodeValue))
		{
			logger.error("queryTownDs format error");
			throw new Exception("format error");
		}

		List<DataSettingBean> resultList = new ArrayList<DataSettingBean>();
		try
		{
			List<DataSetting> dataSettingList = multiQueryDao.queryTownDs(cityCodeValue);
			if (dataSettingList != null && dataSettingList.size() > 0)
			{
				for (DataSetting ds : dataSettingList)
				{
					DataSettingBean data = new DataSettingBean();
					BeanUtils.copyProperties(ds, data);
					resultList.add(data);
				}
				return resultList;
			}
			return null;
		}
		catch (Exception e)
		{
			logger.error("queryTownDs error", e);
			throw e;
		}
	}

	@Override
	public String dlReport(MultiQueryForm multiQueryForm) throws Exception
	{
		logger.debug("dlReport, multiQueryForm=" + ReflectionToStringBuilder.toString(multiQueryForm));

		String reportPath = genMultiQueryReport(multiQueryForm);
		logger.debug("dlReport, reportPath=" + reportPath);
		File file = new File(reportPath);
		if (!file.exists())
		{
			logger.error("dlReport, file is not exists");
			return null;
		}
		else
		{
			return new String(Base64.encodeBase64(FileUtils.readFileToByteArray(file)));
		}
	}

	private String genMultiQueryReport(MultiQueryForm form)
	{
		logger.debug("genMultiQueryReport");
		String reportPath = "";
		WritableWorkbook wwb = null;
		try
		{
			String webContentPath = getClass().getResource("/").getPath().replace("WEB-INF/classes/", "");
			reportPath = webContentPath + "report/MultiQueryReport.xls";
			File tempFile = new File(reportPath);
			logger.debug("genMultiQueryReport, file=" + tempFile.getPath());

			if (tempFile.exists())
			{
				tempFile.delete();
			}

			WorkbookSettings workbookSettings = new WorkbookSettings();
			workbookSettings.setUseTemporaryFileDuringWrite(true); // 使用暫存檔(防止記憶體爆掉)
			workbookSettings.setLocale(new Locale("zh", "TW")); // 設定語系

			wwb = Workbook.createWorkbook(new FileOutputStream(tempFile), workbookSettings);
			//WritableSheet ws = wwb.createSheet(form.getNoticeType().toString(), 0);
			WritableSheet sheet = wwb.createSheet(form.getXlsSheetName(), 0);

			WritableFont headerFont = new WritableFont(WritableFont.createFont("新細明體"), 12);
			WritableCellFormat headerFormat = new WritableCellFormat(headerFont);
			//cellFormat.setWrap(true);// 字串依格子大小顯示, 不顯示全部
			headerFormat.setWrap(false);// 字串不管格子大小, 顯示全部

			WritableFont contentFont = new WritableFont(WritableFont.createFont("新細明體"), 12);
			WritableCellFormat contentFormat = new WritableCellFormat(contentFont);
			contentFormat.setWrap(false);// 字串不管格子大小, 顯示全部

			int rowIdx = 0;
			int colIdx = 0;
			rowIdx = genTitle(sheet, rowIdx, form);

			Map<Integer, QueryAttrInfo> rowAttrMap = getAttrMap(form.getRowAttrMap(), form.getNeedRowSum(), form.getParamMap());
			logger.debug("genRowAttr, rowAttrMap=" + rowAttrMap);
			Map<Integer, QueryAttrInfo> colAttrMap = getAttrMap(form.getColAttrMap(), form.getNeedColSum(), form.getParamMap());
			logger.debug("genColAttr, colAttrMap=" + colAttrMap);

			colIdx = genRowHeader(sheet, headerFormat, (rowIdx + form.getColAttrMap().size()), colIdx, rowAttrMap);
			rowIdx = genColHeader(sheet, headerFormat, rowIdx, colIdx, colAttrMap);
			logger.debug("genMultiQueryReport, rowIdx=" + rowIdx + ", colIdx=" + colIdx);
			genContent(sheet, contentFormat, rowIdx, colIdx, rowAttrMap, colAttrMap, form);

			wwb.write();
		}
		catch (Exception e)
		{
			logger.error("genMultiQueryReport error", e);
		}
		finally
		{
			if (wwb != null)
			{
				try
				{
					wwb.close();
				}
				catch (Exception e)
				{
					logger.error("genMultiQueryReport wwb close error", e);
				}
			}
		}
		return reportPath;
	}

	/**
	 * 產生Excel標題資料列
	 * @param ws
	 * @throws Exception
	 */
	private int genTitle(WritableSheet ws, Integer rowIdx, MultiQueryForm form) throws Exception
	{
		if (form == null || form.getHeaderList() == null || form.getHeaderList().size() <= 0)
		{
			logger.error("genTitle error, header is null");
			throw new Exception("header is null");
		}

		logger.debug("genTitle, rowIdx=" + rowIdx);

		WritableFont font = new WritableFont(WritableFont.createFont("新細明體"), 16);
		WritableCellFormat cellFormat = new WritableCellFormat(font);
		cellFormat.setWrap(false);// 字串不管格子大小, 顯示全部
		cellFormat.setAlignment(Alignment.CENTRE);

		// 標題列
		for (String header : form.getHeaderList())
		{
			Label titleCell = new Label(0, rowIdx, header);
			titleCell.setCellFormat(cellFormat);
			ws.addCell(titleCell);
			ws.mergeCells(0, rowIdx, 8, rowIdx);
			rowIdx += 1;
		}
		rowIdx += 1;//多空格一列
//		Label titleCell = new Label(0, rowIdx, form.getXlsSheetName());
//		titleCell.setCellFormat(cellFormat);
//		ws.addCell(titleCell);
//		ws.mergeCells(0, rowIdx, 8, rowIdx);
//		rowIdx += 1;
		return rowIdx;
	}

	private Map<Integer, QueryAttrInfo> getAttrMap(TreeMap<Integer, QueryAttrEnum> attrEnumMap, Boolean needSum
			, Map<String, String> paramMap) throws Exception
	{
		TreeMap<Integer, QueryAttrEnum> groupAttrMap = attrEnumMap;
		groupAttrMap = groupAttr(groupAttrMap, QueryAttrEnum.TownshipA, QueryAttrEnum.CityA, QueryAttrEnum.CityTown);
		groupAttrMap = groupAttr(groupAttrMap, QueryAttrEnum.Month, QueryAttrEnum.Year, QueryAttrEnum.YearMonth);

		int span = 1;
		Map<Integer, QueryAttrInfo> attrMap = new TreeMap<Integer, QueryAttrInfo>();
		for (int attrNo = (groupAttrMap.size() - 1); attrNo >= 0; attrNo--)
		{
			int dsMapIndex = 0;
			Map<Integer, DataSetting> dsMap = new TreeMap<Integer, DataSetting>();
			// needSum是否需要合計欄，若為null，預設需要合計欄
			if (attrNo == (groupAttrMap.size() - 1) && (needSum == null || needSum))
			{
				// 末端屬性多一欄:合計
				DataSetting totalDs = new DataSetting();
				totalDs.setCodeDataValue("-1");
				totalDs.setCodeDataValueDesc("合計");
				dsMap.put(dsMapIndex, totalDs);
				dsMapIndex++;
			}

			String codeId = groupAttrMap.get(attrNo).getCodeId();
			List<DataSetting> dsList = getAttrDataSetting(codeId, paramMap);
			for (DataSetting ds : dsList)
			{
				dsMap.put(dsMapIndex, ds);
				dsMapIndex++;
			}

			QueryAttrInfo info = new QueryAttrInfo();
			info.setCodeId(codeId);
			info.setDsMap(dsMap);
			info.setAttrSpan(span);
			info.setAttrCnt(dsMap.size());
			info.setAttrColumnName(groupAttrMap.get(attrNo).getColumnName());
			info.setAttrColumnDesc(groupAttrMap.get(attrNo).getDesc());
			attrMap.put(attrNo, info);
			// 越外層的屬性，一個屬性跨越欄越多
			span = span * info.getAttrCnt();
		}
		return attrMap;
	}

	/**
	 * 組合屬性Map
	 * @param attrEnumMap
	 * @param matchAttr
	 * @param removeAttr
	 * @param newAttr
	 * @return
	 */
	private TreeMap<Integer, QueryAttrEnum> groupAttr(TreeMap<Integer, QueryAttrEnum> attrEnumMap
			, QueryAttrEnum matchAttr, QueryAttrEnum removeAttr, QueryAttrEnum newAttr)
	{
		TreeMap<Integer, QueryAttrEnum> groupMap = new TreeMap<Integer, QueryAttrEnum>();
		boolean isContain = false;
		for (int key : attrEnumMap.keySet())
		{
			if (attrEnumMap.get(key) == matchAttr)
				isContain = true;
		}
		int index = 0;
		for (int key : attrEnumMap.keySet())
		{
			if (!isContain)
			{
				groupMap.put(index, attrEnumMap.get(key));
				index++;
			}
			else
			{
				if (attrEnumMap.get(key) == matchAttr)
				{
					groupMap.put(index, newAttr);
					index++;
				}
				else if (attrEnumMap.get(key) != removeAttr)
				{
					groupMap.put(index, attrEnumMap.get(key));
					index++;
				}
			}
		}
		return groupMap;
	}

	/**
	 * 產生Excel複合縱軸欄位標題
	 * @param ws
	 * @param headerFormat
	 * @param rowIdx
	 * @param colIdx
	 * @param rowAttrMap
	 * @return
	 * @throws Exception
	 */
	private int genRowHeader(WritableSheet ws, WritableCellFormat headerFormat, int rowIdx, int colIdx,
			Map<Integer, QueryAttrInfo> rowAttrMap) throws Exception
	{
		logger.debug("genRowHeader, rowIdx=" + rowIdx + ", colIdx=" + colIdx);

		// 起始欄索引座標
		int x = colIdx;
		int totalRowCnt = rowAttrMap.get(0).getAttrCnt() * rowAttrMap.get(0).getAttrSpan();
		Iterator<Entry<Integer, QueryAttrInfo>> iterator = rowAttrMap.entrySet().iterator();
		while (iterator.hasNext())
		{
			QueryAttrInfo rowInfo = iterator.next().getValue();
			logger.debug("genRowHeader, rowInfo=" + ReflectionToStringBuilder.toString(rowInfo));
			int repeatAttrCnt = (totalRowCnt / (rowInfo.getAttrCnt() * rowInfo.getAttrSpan()));
			logger.debug("genRowHeader, repeatAttrCnt=" + repeatAttrCnt);

			// 起始列索引座標
			int y = rowIdx;
			for (int i = 1; i <= repeatAttrCnt; i++)
			{
				Map<Integer, DataSetting> dsMap = rowInfo.getDsMap();
				for (Integer key : dsMap.keySet())
				{
					StringBuffer cellVal = new StringBuffer();
					cellVal.append(dsMap.get(key).getCodeDataValueDesc());
					cellVal.append("(" + dsMap.get(key).getCodeDataValue() + ")");//XXX
					Label cell = new Label(x, y, cellVal.toString());
					cell.setCellFormat(headerFormat);
					ws.addCell(cell);
					y += rowInfo.getAttrSpan();
				}
			}
			x += 1;
		}
		return x;
	}

	/**
	 * 產生Excel複合橫軸欄位標題
	 * @param ws
	 * @param headerFormat
	 * @param rowIdx
	 * @param colIdx
	 * @param colAttrMap
	 * @return
	 * @throws Exception
	 */
	private int genColHeader(WritableSheet ws, WritableCellFormat headerFormat, int rowIdx, int colIdx,
			Map<Integer, QueryAttrInfo> colAttrMap) throws Exception
	{
		logger.debug("genColHeader, rowIdx=" + rowIdx + ", colIdx=" + colIdx);

		int y = rowIdx;
		int totalColCnt = colAttrMap.get(0).getAttrCnt() * colAttrMap.get(0).getAttrSpan();
		Iterator<Entry<Integer, QueryAttrInfo>> iterator = colAttrMap.entrySet().iterator();
		while (iterator.hasNext())
		{
			QueryAttrInfo colInfo = iterator.next().getValue();
			logger.debug("genColHeader, colInfo=" + ReflectionToStringBuilder.toString(colInfo));
			int repeatAttrCnt = (totalColCnt / (colInfo.getAttrCnt() * colInfo.getAttrSpan()));
			logger.debug("genColHeader, repeatAttrCnt=" + repeatAttrCnt);

			// 起始X座標
			int x = colIdx; //0 + form.getRowAttr().size();
			for (int i = 1; i <= repeatAttrCnt; i++)
			{
				Map<Integer, DataSetting> dsMap = colInfo.getDsMap();
				for (Integer key : dsMap.keySet())
				{
					StringBuffer cellVal = new StringBuffer();
					cellVal.append(dsMap.get(key).getCodeDataValueDesc());
					cellVal.append("(" + dsMap.get(key).getCodeDataValue() + ")");//XXX
					Label cell = new Label(x, y, cellVal.toString());
					cell.setCellFormat(headerFormat);
					ws.addCell(cell);
					ws.mergeCells(x, y, x + (colInfo.getAttrSpan() - 1), y);
					x += colInfo.getAttrSpan();
				}
			}
			y += 1;
		}
		return y;
	}

	private String columnName(int index)
	{
		int div = index + 1;
		StringBuffer result = new StringBuffer();
		int mod = 0;

		while (div > 0)
		{
			mod = (div - 1) % 26;
			result.insert(0, (char) (65 + mod));//65是A
			div = (int) ((div - mod) / 26);
		}
		return result.toString();
	}

	private String getSelectColumn(TableNameEnum table, String preStr)
	{
		String selectColStr = preStr;
		if (table == TableNameEnum.ForeignSpouseHist)
		{
			if (selectColStr.contains(QueryAttrEnum.TwSpPosition.getColumnName()))
			{
				// 針對台配身份額外修改Select語句
				StringBuffer twSpPos = new StringBuffer();
				twSpPos.append(String.format("isnull(nullif(%s,' '),'0')", QueryAttrEnum.TwSpouseNativeMark.getColumnName()));
				twSpPos.append("+");
				twSpPos.append(String.format("isnull(nullif(%s,' '),'0')", QueryAttrEnum.TwSpouseType.getColumnName()));
				twSpPos.append("+");
				twSpPos.append(String.format("isnull(nullif(%s,' '),'0')", QueryAttrEnum.TwSpouseVeteranMark.getColumnName()));
				twSpPos.append(" as TwSpPosition");
				selectColStr = selectColStr.replaceAll(QueryAttrEnum.TwSpPosition.getColumnName(), twSpPos.toString());
			}
		}
		return selectColStr;
	}

	private String getGroupbyColumn(TableNameEnum table, String preStr)
	{
		String groupStr = preStr;
		if (table == TableNameEnum.ForeignSpouseHist)
		{
			if (groupStr.contains(QueryAttrEnum.TwSpPosition.getColumnName()))
			{
				// 針對台配身份額外修改GroupBy語句
				StringBuffer twSpPos = new StringBuffer();
				twSpPos.append(QueryAttrEnum.TwSpouseNativeMark.getColumnName());
				twSpPos.append(",");
				twSpPos.append(QueryAttrEnum.TwSpouseType.getColumnName());
				twSpPos.append(",");
				twSpPos.append(QueryAttrEnum.TwSpouseVeteranMark.getColumnName());
				groupStr = groupStr.replaceAll(QueryAttrEnum.TwSpPosition.getColumnName(), twSpPos.toString());
			}
		}
		return groupStr;
	}

	/**
	 * 依據縱軸、橫軸選取的屬性欄位(QueryAttrInfo)，來Group by屬性欄位、Count筆數的SQL
	 * @param form
	 * @param rowAttrMap-縱軸欄位Map
	 * @param colAttrMap-橫軸欄位Map
	 * @return
	 */
	private String getSql(MultiQueryForm form, Map<Integer, QueryAttrInfo> rowAttrMap, Map<Integer, QueryAttrInfo> colAttrMap)
	{
		if (form == null || form.getTable() == null)
		{
			logger.error("getSql error, has no table");
			return "";
		}

		StringBuffer colNames = new StringBuffer();
		if (rowAttrMap != null && rowAttrMap.size() > 0)
		{
			for (Integer key : rowAttrMap.keySet())
			{
				colNames.append(rowAttrMap.get(key).getAttrColumnName());
				if (key < (rowAttrMap.size() - 1))
				{
					colNames.append(", ");
				}
			}
		}

		if (colAttrMap != null && colAttrMap.size() > 0)
		{
			if (rowAttrMap != null && rowAttrMap.size() > 0)
			{
				colNames.append(", ");
			}

			for (Integer key : colAttrMap.keySet())
			{
				colNames.append(colAttrMap.get(key).getAttrColumnName());
				if (key < (colAttrMap.size() - 1))
				{
					colNames.append(",");
				}
			}
		}

		StringBuffer sql = new StringBuffer();
		if (!StringUtil.isEmpty(form.getTable().getCountColumn()))
		{
			String cntCol = form.getTable().getCountColumn();
			sql.append("select " + colNames.toString() + ", Sum(" + cntCol + ") as Cnt from " + form.getTable());
		}
		else
		{
			sql.append("select " + getSelectColumn(form.getTable(), colNames.toString()) + ", count(*) as Cnt from " + form.getTable());
		}
		sql.append(" where 1=1");
		if (form != null && !StringUtil.isEmpty(form.getWhereFilter()))
			sql.append(" " + form.getWhereFilter());
		sql.append(" group by " + getGroupbyColumn(form.getTable(), colNames.toString()));
		sql.append(" order by " + colNames.toString());
		return sql.toString();
	}

	private void genContent(WritableSheet ws, WritableCellFormat contentFormat, int rowIdx, int colIdx,
			Map<Integer, QueryAttrInfo> rowAttrMap, Map<Integer, QueryAttrInfo> colAttrMap, MultiQueryForm form) throws Exception
	{
		logger.debug("genContent, rowIdx=" + rowIdx + ", colIdx=" + colIdx
				+ ", rowAttrMap=" + rowAttrMap + ", colAttrMap=" + colAttrMap);

		String sql = getSql(form, rowAttrMap, colAttrMap);
		logger.debug("genContent, sql=" + sql);

		Map<String, Integer> rowCntMap = multiQueryDao.getRowCntDataMap(sql, rowAttrMap, colAttrMap);
		logger.debug("genContent, rowCntMap.size=" + rowCntMap.size());
		logger.debug("genContent, rowCntMap=" + rowCntMap);

		// 最內層的列屬性
		QueryAttrInfo innerRowAttr = rowAttrMap.get(rowAttrMap.size() - 1);
		// 最內層的欄位屬性
		QueryAttrInfo innerColAttr = colAttrMap.get(colAttrMap.size() - 1);

		int totalRowCnt = rowAttrMap.get(0).getAttrCnt() * rowAttrMap.get(0).getAttrSpan();
		int totalColCnt = colAttrMap.get(0).getAttrCnt() * colAttrMap.get(0).getAttrSpan();
		for (int r = 0; r < totalRowCnt; r++)
		{
			for (int c = 0; c < totalColCnt; c++)
			{
				//Map<String, Object> rowMap = rowDataMapList.get(rowMapIdx);
				if (r % innerRowAttr.getAttrCnt() == 0 && (form.getNeedRowSum() == null || form.getNeedRowSum()))
				{
					// 代表r列的所有合計欄(等於縱軸內層屬性相加)
					int cellX = c + colIdx;
					int cellY = r + rowIdx;
					//加2的原因是因為索引的起始是0，Excel起始是1，另一個1是因為合計欄是從下一列才開始的Sum的
					String startCell = columnName(cellX) + (cellY + 2);
					String endCell = columnName(cellX) + (cellY + 2 + innerRowAttr.getAttrCnt() - 2);
					String sum = "SUM(" + startCell + ":" + endCell + ")";
					Formula formula = new Formula(cellX, cellY, sum);
					formula.setCellFormat(contentFormat);
					ws.addCell(formula);
				}
				else
				{
					//logger.debug("genContent, innerColAttr=" + innerColAttr);
					if (c % innerColAttr.getAttrCnt() == 0 && (form.getNeedColSum() == null || form.getNeedColSum()))
					{
						//代表縱軸合計欄(等於橫軸內層屬性相加)
						int cellX = c + colIdx;
						int cellY = r + rowIdx;
						//cellX加1是因為合計"列"是從下一"欄"才開始的Sum的，cellY加1是因為索引的起始是0，Excel起始是1
						String startCell = columnName(cellX + 1) + (cellY + 1);
						String endCell = columnName(cellX + 1 + (innerColAttr.getAttrCnt() - 2)) + (cellY + 1);
						String sum = "SUM(" + startCell + ":" + endCell + ")";
						Formula formula = new Formula((c + colIdx), (r + rowIdx), sum);
						formula.setCellFormat(contentFormat);
						ws.addCell(formula);
					}
					else
					{
//						String key = getCellAttrKey(rowAttrMap, colAttrMap, r, c);
//						int cellValue = getRowCnt(rowCntMap, key);
						List<String> keyList = getCellAttrKeyList(rowAttrMap, colAttrMap, r, c);
						int cellValue = 0;
						for (String key : keyList)
						{
							cellValue += getRowCnt(rowCntMap, key);
						}
						Number cell = new Number((c + colIdx), (r + rowIdx), cellValue);
						cell.setCellFormat(contentFormat);
						ws.addCell(cell);
					}
				}
			}
		}
	}

	/**
	 * 依縱軸座標(橫軸)座標 取得 多維度Excel屬性資訊 對應的DataSetting
	 * @param attrInfo
	 * @param cellIndex - 縱軸座標/橫軸座標
	 * @return
	 */
	private DataSetting getAttrInfoDS(QueryAttrInfo attrInfo, int cellIndex)
	{
		// 欄或列索引(cellIndex)除以屬性間隔(AttrSpan)取商，商再mod屬性個數(AttrCnt)代表該屬性的DataSettingMap的第幾個項目(dsMapIndex)
		int dsMapIndex = (cellIndex / attrInfo.getAttrSpan()) % attrInfo.getAttrCnt();
		return attrInfo.getDsMap().get(dsMapIndex);
	}

//	/**
//	 * 取得縱軸座標(橫軸)座標對應的縱軸(橫軸)欄位屬性 組合而且的key
//	 * @param rowAttrMap
//	 * @param colAttrMap
//	 * @param r
//	 * @param c
//	 * @return 縱軸屬性1_CodeDataValue_縱軸屬性2_CodeDataValue...橫軸屬性1_CodeDataValue_橫軸屬性2_CodeDataValue...
//	 */
//	private String getCellAttrKey(Map<Integer, QueryAttrInfo> rowAttrMap, Map<Integer, QueryAttrInfo> colAttrMap,
//			int r, int c)
//	{
//		StringBuffer keySb = new StringBuffer();
//		if (rowAttrMap != null && rowAttrMap.size() > 0)
//		{
//			Iterator<Entry<Integer, QueryAttrInfo>> rowIter = rowAttrMap.entrySet().iterator();
//			while (rowIter.hasNext())
//			{
//				Entry<Integer, QueryAttrInfo> rowAttrEntry = rowIter.next();
//				DataSetting ds = getAttrInfoDS(rowAttrEntry.getValue(), r);
//				if (ds != null)
//				{
//					keySb.append(getOneAttrDsKey(rowAttrEntry.getValue(), ds));
//					if (rowIter.hasNext())
//						keySb.append(",");
//				}
//			}
//		}
//
//		if (colAttrMap != null && colAttrMap.size() > 0)
//		{
//			if (rowAttrMap != null && rowAttrMap.size() > 0)
//			{
//				keySb.append(",");
//			}
//
//			Iterator<Entry<Integer, QueryAttrInfo>> colIter = colAttrMap.entrySet().iterator();
//			while (colIter.hasNext())
//			{
//				Entry<Integer, QueryAttrInfo> colAttrEntry = colIter.next();
//				DataSetting ds = getAttrInfoDS(colAttrEntry.getValue(), c);
//				if (ds != null)
//				{
//					keySb.append(getOneAttrDsKey(colAttrEntry.getValue(), ds));
//					if (colIter.hasNext())
//						keySb.append(",");
//				}
//			}
//		}
//		return keySb.toString();
//	}

//	private String getOneAttrDsKey(QueryAttrInfo attrInfo, DataSetting ds)
//	{
//		StringBuffer key = new StringBuffer();
//		if (attrInfo.getAttrColumnName().contains(","))
//		{
//			// 如果ColumnName包含逗點，代表為組合欄位(例如、縣市_鄉鎮)，則直接使用CodeDataValue
//			key.append(ds.getCodeDataValue());
//		}
//		else
//		{
//			key.append(attrInfo.getAttrColumnName() + "_");
//			key.append(ds.getCodeDataValue());
//		}
//		return key.toString();
//	}

	/**
	 * 取得縱軸座標(橫軸)座標對應的縱軸(橫軸)欄位屬性 組合而且的key
	 * @param rowAttrMap
	 * @param colAttrMap
	 * @param r
	 * @param c
	 * @return 縱軸屬性1_CodeDataValue_縱軸屬性2_CodeDataValue...橫軸屬性1_CodeDataValue_橫軸屬性2_CodeDataValue...
	 */
	private List<String> getCellAttrKeyList(Map<Integer, QueryAttrInfo> rowAttrMap,
			Map<Integer, QueryAttrInfo> colAttrMap, int r, int c)
	{
		List<String> keyList = new ArrayList<String>();

		StringBuffer keySb = new StringBuffer();
		List<MultiKey> mKeyList = new ArrayList<MultiKey>();
		if (rowAttrMap != null && rowAttrMap.size() > 0)
		{
			Iterator<Entry<Integer, QueryAttrInfo>> rowIter = rowAttrMap.entrySet().iterator();
			while (rowIter.hasNext())
			{
				Entry<Integer, QueryAttrInfo> rowAttrEntry = rowIter.next();
				DataSetting ds = getAttrInfoDS(rowAttrEntry.getValue(), r);
				if (ds != null)
				{
					MultiKey mKey = getOneAttrDsMultiKey(rowAttrEntry.getValue(), ds);
					mKeyList.add(mKey);
					keySb.append(mKey.getKey());
					if (rowIter.hasNext())
						keySb.append(",");
				}
			}
		}

		if (colAttrMap != null && colAttrMap.size() > 0)
		{
			if (rowAttrMap != null && rowAttrMap.size() > 0)
			{
				keySb.append(",");
			}

			Iterator<Entry<Integer, QueryAttrInfo>> colIter = colAttrMap.entrySet().iterator();
			while (colIter.hasNext())
			{
				Entry<Integer, QueryAttrInfo> colAttrEntry = colIter.next();
				DataSetting ds = getAttrInfoDS(colAttrEntry.getValue(), c);
				if (ds != null)
				{
					MultiKey mKey = getOneAttrDsMultiKey(colAttrEntry.getValue(), ds);
					mKeyList.add(mKey);
					keySb.append(mKey.getKey());
					if (colIter.hasNext())
						keySb.append(",");
				}
			}
		}
		String key = keySb.toString();
		if (!key.contains("-1"))
		{
			keyList.addAll(addMultiKey(mKeyList, key));
		}
		return keyList;
	}

	private Set<String> addMultiKey(List<MultiKey> mKeyList, String preKey)
	{
		Map<String, String> keyMap = new HashMap<String, String>();
		for (MultiKey mKey : mKeyList)
		{
			Set<String> keySet = addMultiKey(mKey, preKey);
			for (String k : keySet)
			{
				keyMap.put(k, null);
			}
		}
		return keyMap.keySet();
	}

	private Set<String> addMultiKey(MultiKey mKey, String preKey)
	{
		Map<String, String> keyMap = new HashMap<String, String>();
		if (mKey.getMultiKeyCode() != null && mKey.getMultiKeyCode().size() > 0)
		{
			for (String keyCode : mKey.getMultiKeyCode())
			{
				String replaceKey = preKey.replace("#" + mKey.getColumnName() + "#", keyCode);
				keyMap.put(replaceKey, null);
			}
		}
		else
		{
			keyMap.put(preKey, null);
		}
		return keyMap.keySet();
	}

	/**
	 * 依據QueryAttrInfo裡面的欄位資訊來組成Key，才能Mapping SQL查詢結果的Value
	 * @param attrInfo
	 * @param ds
	 * @return
	 */
	private MultiKey getOneAttrDsMultiKey(QueryAttrInfo attrInfo, DataSetting ds)
	{
		List<String> multiKeyCode = new ArrayList<String>();

		MultiKey mKey = new MultiKey();
		mKey.setColumnName(attrInfo.getAttrColumnName());

		StringBuffer key = new StringBuffer();
		if (attrInfo.getAttrColumnName().contains(","))
		{
			// 如果ColumnName包含逗點，代表為組合欄位(例如、縣市_鄉鎮)，則直接使用CodeDataValue
			key.append(ds.getCodeDataValue());
		}
		else if (ds.getCodeDataValue().contains(":"))
		{
			String startKeyCode = ds.getCodeDataValue().split(":")[0];
			String endKeyCode = ds.getCodeDataValue().split(":")[1];
			if (!StringUtil.isNumeric(startKeyCode) || !StringUtil.isNumeric(endKeyCode))
			{
				logger.error("getOneAttrDsMultiKey format error");
			}
			else
			{
				for (int i = Integer.parseInt(startKeyCode); i <= Integer.parseInt(endKeyCode); i++)
				{
					multiKeyCode.add(String.valueOf(i));
				}
				mKey.setMultiKeyCode(multiKeyCode);
			}
			key.append(attrInfo.getAttrColumnName() + "_");
			key.append("#" + attrInfo.getAttrColumnName() + "#");
		}
		else if (ds.getCodeDataValue().contains(";"))
		{
			String[] keyCodeArray = ds.getCodeDataValue().split(";");
			for (String keyCode : keyCodeArray)
			{
				multiKeyCode.add(String.valueOf(keyCode));
			}
			mKey.setMultiKeyCode(multiKeyCode);
			key.append(attrInfo.getAttrColumnName() + "_");
			key.append("#" + attrInfo.getAttrColumnName() + "#");
		}
		else
		{
			key.append(attrInfo.getAttrColumnName() + "_");
			key.append(ds.getCodeDataValue());
		}
		mKey.setKey(key.toString());
		return mKey;
	}

	/**
	 * 依所有縱軸+橫軸的屬性當成Key，取得對應的Count筆數
	 * @param rowCntMap
	 * @param key
	 * @return
	 */
	private int getRowCnt(Map<String, Integer> rowCntMap, String key)
	{
		if (!StringUtil.isEmpty(key) && rowCntMap != null && rowCntMap.containsKey(key))
		{
			return rowCntMap.get(key);
		}
		return 0;
	}

	@Override
	public ChartData queryChartData(MultiQueryForm multiQueryForm) throws Exception
	{
		logger.debug("queryChartData, multiQueryForm=" + multiQueryForm);
		if (multiQueryForm == null || multiQueryForm.getRowAttrMap() == null)
		{
			logger.error("queryChartData format error");
			return null;
		}

		ChartData chartData = new ChartData();
		String xName = "";

		Map<Integer, QueryAttrInfo> attrInfoMap = getAttrMap(multiQueryForm.getRowAttrMap(), multiQueryForm.getNeedRowSum()
				, multiQueryForm.getParamMap());

		logger.debug("queryChartData, attrInfoMap=" + ReflectionToStringBuilder.toString(attrInfoMap));

		if (attrInfoMap.size() == 1)
		{
			// 一個屬性的圖形
			//[['x', '月'], ['資料1', 300, 100, 250, 150, 300, 150], ['資料2', 100, 200, 150, 50, 100, 250],	['資料3', 200, 100, 50, 100, 200, 150]]
			//QueryAttrInfo attrInfo1 = attrInfoMap.get(0);
			//xName = QueryAttrEnum.getByCode(attrInfo1.getCodeId()).getDesc();
			chartData.setDataList(get1AttrChartDataList(multiQueryForm, attrInfoMap));
		}
		else if(attrInfoMap.size() == 2)
		{
			// 兩個屬性的圖形
			//[['x', '一月', '二月', '三月', '四月', '五月', '六月'], ['資料1', 30, 200, 100, 400, 150, 250],['資料2', 50, 20, 10, 40, 15, 25],['資料3', 60, 100, 70, 120, 85, 150]]
			QueryAttrInfo attrInfo1 = attrInfoMap.get(0);
			QueryAttrInfo attrInfo2 = attrInfoMap.get(1);

			xName = QueryAttrEnum.getByCode(attrInfo1.getCodeId()).getDesc();
			xName += " / " + QueryAttrEnum.getByCode(attrInfo2.getCodeId()).getDesc();
			chartData.setDataList(get2AttrChartDataList(multiQueryForm, attrInfoMap));
		}
		chartData.setxName(xName);
		chartData.setyName("人");
		logger.debug("queryChartData, chartData=" + ReflectionToStringBuilder.toString(chartData));
		return chartData;
	}

	/**
	 * 取得一維屬性的圖資料
	 * @param form
	 * @param attrInfoMap
	 * @return
	 * @throws Exception
	 */
	private List<List<String>> get1AttrChartDataList(MultiQueryForm form, Map<Integer, QueryAttrInfo> attrInfoMap)
			throws Exception
	{
		QueryAttrInfo attrInfo1 = attrInfoMap.get(0);

		Map<String, Integer> cntMap = queryCntMap(form);
		logger.debug("get1AttrChartDataList, cntMap=" + cntMap);

		List<List<String>> dataList = new ArrayList<List<String>>();

//		// 第一個屬性
//		if (form.getChartType() != ChartTypeEnum.Pie)
//		{
//			List<String> xAttr = new ArrayList<String>();
//			xAttr.add("x");
//			xAttr.add(attrInfo1.getAttrColumnDesc());
//			dataList.add(xAttr);
//		}

		for (int r = 0; r < attrInfo1.getDsMap().size(); r++)
		{
			List<String> cntList = new ArrayList<String>();
			String codeDesc = attrInfo1.getDsMap().get(r).getCodeDataValueDesc();
			cntList.add(codeDesc);
//			String cntKey = getOneAttrDsKey(attrInfo1, attrInfo1.getDsMap().get(r));
//			int cnt = getRowCnt(cntMap, cntKey);
			List<String> keyList = new ArrayList<String>();
			MultiKey mKey = getOneAttrDsMultiKey(attrInfo1, attrInfo1.getDsMap().get(r));
			keyList.addAll(addMultiKey(mKey, mKey.getKey()));
			int cnt = 0;
			for (String key : keyList)
			{
				cnt += getRowCnt(cntMap, key);
			}
			//logger.debug("get1AttrChartDataList, get cntKey:" + cntKey + ", cnt:" + cnt);
			cntList.add(String.valueOf(cnt));
			dataList.add(cntList);
		}
		return dataList;
	}

	/**
	 * 取得二維屬性的圖資料
	 * @param form
	 * @param attrInfoMap
	 * @return
	 * @throws Exception
	 */
	private List<List<String>> get2AttrChartDataList(MultiQueryForm form, Map<Integer, QueryAttrInfo> attrInfoMap)
			throws Exception
	{
		QueryAttrInfo attrInfo1 = attrInfoMap.get(0);
		QueryAttrInfo attrInfo2 = attrInfoMap.get(1);
		attrInfo1.setAttrSpan(1);//因為AttrSpan會影響getAttrInfoDS取得的DataSetting的索引對應
		attrInfo2.setAttrSpan(1);//因為AttrSpan會影響getAttrInfoDS取得的DataSetting的索引對應

		List<List<String>> dataList = new ArrayList<List<String>>();

		//第一個屬性
		List<String> xAttr = new ArrayList<String>();
		xAttr.add("x");

		Map<Integer, DataSetting> dsMap = attrInfo1.getDsMap();
		for (Integer key : dsMap.keySet())
		{
			StringBuffer attr1Desc = new StringBuffer();
			attr1Desc.append(dsMap.get(key).getCodeDataValueDesc());
			//cellVal.append("(" + dsMap.get(key).getCodeDataValue() + ")");
			xAttr.add(attr1Desc.toString());
		}
		dataList.add(xAttr);

		Map<String, Integer> cntMap = queryCntMap(form);
		logger.debug("getChartDataList, cntMap=" + cntMap);

		TreeMap<Integer, QueryAttrInfo> rMap = new TreeMap<Integer, QueryAttrInfo>();
		rMap.put(0, attrInfo1);
		TreeMap<Integer, QueryAttrInfo> cMap = new TreeMap<Integer, QueryAttrInfo>();
		cMap.put(0, attrInfo2);
		// 依照二維屬性圖的架構，要先loop第2欄屬性，再loop第1欄屬性
		for (int c = 0; c < attrInfo2.getDsMap().size(); c++)
		{
			List<String> cntList = new ArrayList<String>();
			String codeDesc = attrInfo2.getDsMap().get(c).getCodeDataValueDesc();
			cntList.add(codeDesc);
			for (int r = 0; r < attrInfo1.getDsMap().size(); r++)
			{
//				String rowKey = getOneAttrDsKey(attrInfo1, attrInfo1.getDsMap().get(r));
//				String colKey = getOneAttrDsKey(attrInfo2, attrInfo2.getDsMap().get(c));
//				String cntKey = String.format("%s,%s", rowKey, colKey);
//				int cnt = getRowCnt(cntMap, cntKey);
				List<String> keyList = getCellAttrKeyList(rMap, cMap, r, c);
				int cnt = 0;
				for (String key : keyList)
				{
					cnt += getRowCnt(cntMap, key);
				}
				//logger.debug("getChartDataList, get cntKey:" + cntKey + ", cnt:" + cnt);
				cntList.add(String.valueOf(cnt));
			}
			dataList.add(cntList);
		}
		return dataList;
	}

	private Map<String, Integer> queryCntMap(MultiQueryForm multiQueryForm) throws Exception
	{
		logger.debug("queryCntMap, multiQueryForm=" + multiQueryForm);
		Map<String, Integer> cntMap = new HashMap<String, Integer>();
		try
		{
			Map<Integer, QueryAttrInfo> rowAttrMap = getAttrMap(multiQueryForm.getRowAttrMap(), false, multiQueryForm.getParamMap());
			logger.debug("queryCntMap, rowAttrMap=" + rowAttrMap);

			String sql = getSql(multiQueryForm, rowAttrMap, null);
			logger.debug("queryCntMap, sql=" + sql);

			cntMap = multiQueryDao.getRowCntDataMap(sql, rowAttrMap, null);
		}
		catch (Exception e)
		{
			logger.error("queryCntMap error", e);
		}
		return cntMap;
	}

	@Override
	public CityChartData queryCityChartData(MultiQueryForm multiQueryForm) throws Exception
	{
		logger.debug("queryCityChartData, multiQueryForm=" + multiQueryForm);

		CityChartData cityChartData = new CityChartData();

		/*QueryAttrEnum attrEnum = QueryAttrEnum.CityA;

		Map<Integer, DataSetting> dsMap = new TreeMap<Integer, DataSetting>();
		List<DataSetting> dsList = getAttrDataSetting(attrEnum.getCodeId());
		for (int i = 0; i < dsList.size(); i++)
		{
			dsMap.put(i, dsList.get(i));
		}

		QueryAttrInfo info = new QueryAttrInfo();
		info.setCodeId(attrEnum.getCodeId());
		info.setDsMap(dsMap);
		info.setAttrSpan(1);
		info.setAttrCnt(dsMap.size());
		info.setAttrColumnName(attrEnum.getColumnName());

		Map<Integer, QueryAttrInfo> attrMap = new TreeMap<Integer, QueryAttrInfo>();
		attrMap.put(0, info);*/

		Map<Integer, QueryAttrInfo> attrMap = getAttrMap(multiQueryForm.getRowAttrMap(), false, multiQueryForm.getParamMap());
		logger.debug("queryCityChartData, attrMap=" + attrMap);

		String sql = getSql(multiQueryForm, attrMap, null);
		logger.debug("queryCityChartData, sql=" + sql);
		Map<String, Integer> cntMap = multiQueryDao.getRowCntDataMap(sql, attrMap, null);
		logger.debug("queryCityChartData, cntMap=" + cntMap);

		QueryAttrInfo attrInfo = attrMap.get(0);

		// key:縣市名(台北市), value:統計數(Count)
		Map<String, Integer> dataMap = new HashMap<String, Integer>();
		// 人數資訊顯示框
		List<CityTipsData> cityTipsList = new ArrayList<CityTipsData>();
		for (int r = 0; r < attrInfo.getDsMap().size(); r++)
		{
			DataSetting ds = attrInfo.getDsMap().get(r);
			String codeDesc = ds.getCodeDataValueDesc();
			String cntKey = String.format("%s_%s", attrInfo.getAttrColumnName(), ds.getCodeDataValue());
			int cnt = getRowCnt(cntMap, cntKey);
			dataMap.put(codeDesc, cnt);

			CityLocationEnum location = CityLocationEnum.getByCode(ds.getCodeDataValue());
			CityTipsData tipsData = new CityTipsData();
			tipsData.setCodeDataValue(ds.getCodeDataValue());
			tipsData.setCodeDataValueDesc(ds.getCodeDataValueDesc());
			tipsData.setLon(location.getLon());
			tipsData.setLat(location.getLat());
			tipsData.setX2(location.getX2());
			tipsData.setY2(location.getY2());
			tipsData.setCnt(cnt);
			cityTipsList.add(tipsData);
		}
		cityChartData.setMaxCnt(getMaxCnt(cntMap));
		cityChartData.setDataMap(dataMap);
		cityChartData.setCityTipsList(cityTipsList);
		logger.debug("queryCityChartData, cityChartData=" + cityChartData);
		return cityChartData;
	}

	private int getMaxCnt(Map<String, Integer> cntMap)
	{
		int max = 0;
		if (cntMap != null)
		{
			for (String key : cntMap.keySet())
			{
				if (cntMap.get(key) != null && cntMap.get(key) > max)
				{
					max = cntMap.get(key);
				}
			}
		}
		return max;
	}

	private class MultiKey
	{
		private String columnName;
		private String key;
		private List<String> multiKeyCode;

		public String getColumnName()
		{
			return columnName;
		}

		public void setColumnName(String columnName)
		{
			this.columnName = columnName;
		}

		public String getKey()
		{
			return key;
		}

		public void setKey(String key)
		{
			this.key = key;
		}

		public List<String> getMultiKeyCode()
		{
			return multiKeyCode;
		}

		public void setMultiKeyCode(List<String> multiKeyCode)
		{
			this.multiKeyCode = multiKeyCode;
		}
	}

	public static void main(String[] args) throws Exception
	{
		MultiQueryWebServiceImpl service = new MultiQueryWebServiceImpl();

		TreeMap<Integer, QueryAttrEnum> rowAttrEnumMap = new TreeMap<Integer, QueryAttrEnum>();
		rowAttrEnumMap.put(0, QueryAttrEnum.FsType);

		TreeMap<Integer, QueryAttrEnum> colAttrEnumMap = new TreeMap<Integer, QueryAttrEnum>();
		colAttrEnumMap.put(0, QueryAttrEnum.TwSpPosition);
		colAttrEnumMap.put(1, QueryAttrEnum.Age);

		MultiQueryForm form = new MultiQueryForm();
		form.setTable(TableNameEnum.ForeignSpouseHist);

		List<String> headerList = new ArrayList<String>();
		headerList.add("測試報表");
		headerList.add("測試第二行");
		form.setHeaderList(headerList);
		form.setXlsSheetName("測試報表");
		form.setRowAttrMap(rowAttrEnumMap);
		form.setColAttrMap(colAttrEnumMap);

		Map<Integer, QueryAttrInfo> rowAttrMap = service.getAttrMap(form.getRowAttrMap(), form.getNeedRowSum(),	form.getParamMap());
		logger.debug("genRowAttr, rowAttrMap=" + rowAttrMap);
		Map<Integer, QueryAttrInfo> colAttrMap = service.getAttrMap(form.getColAttrMap(), form.getNeedColSum(),	form.getParamMap());
		logger.debug("genColAttr, colAttrMap=" + colAttrMap);

		int totalRowCnt = rowAttrMap.get(0).getAttrCnt() * rowAttrMap.get(0).getAttrSpan();
		int totalColCnt = colAttrMap.get(0).getAttrCnt() * colAttrMap.get(0).getAttrSpan();
		int cnt = 0;
		for (int r = 0; r < totalRowCnt; r++)
		{
			for (int c = 0; c < totalColCnt; c++)
			{
				List<String> keyList = new ArrayList<String>();
				keyList = service.getCellAttrKeyList(rowAttrMap, colAttrMap, r, c);
//				keyList.add(service.getCellAttrKey(rowAttrMap, colAttrMap, r, c));
				if (keyList != null)
				{
					for (String key : keyList)
					{
						System.out.println("\tkey=" + key);
						cnt++;
					}
				}
			}
		}
		System.out.println("cnt=" + cnt);
	}
}
