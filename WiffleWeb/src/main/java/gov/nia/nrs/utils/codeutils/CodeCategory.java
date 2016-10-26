package gov.nia.nrs.utils.codeutils;

/**
 * @author 96003
 * @since Nov 21, 2012
 */
public enum CodeCategory {
    /** [1]申請書(E/D卡)申請事由代碼 */
    APPLY_CASE_REASON_CATEGORY(1),
    /** [2]省縣市代碼 */
    BIRTH_PLACE_CODE_CATEGORY(2),
    /** [3]省籍代碼 */
    BIRTH_PLACE_CATEGORY(3),
    /** [4]申請職業 */
    OCCUPATION_CATEGORY(4),
    /** [5]申請身分代碼 */
    POSITION_CATEGORY(5),
    /** [6]補辦註記 */
    APPLY_TYPE_CATEGORY(6),
    /** [7]領證方式 */
    TAKEAWAY_CATEGORY(7),
    /** [10]婚姻狀況 */
    MARRY_CATEGORY(10),
    /** [11]役別 */
    MILITARY_TYPE_CATEGORY(11),
    /** [12]部會代號 */
    BUREAUNO_CATEGORY(12),
    /** [14]教育程度 */
    EDUCATION_TYPE_CATEGORY(14),
    /** [15]國家地區代號 */
    NATION_CODE_CATEGORY(15),
    /** [16]郵遞區號 */
    ZIP_CODE_CATEGORY(16),
    /** [18]證字代碼 */
    PERMIT_CODE_CATEGORY(18),
    /** [19]役男類別 */
    SOLDIER_MARK_CODE_CATEGORY(19),
    /** [25]出入境別 */
    IMMIGRATION_TYPE_CATEGORY(25),
    /** [26]出入港口 */
    PORT_CATEGORY(26),
    /** [30]組別 */
    UNDERTAKER_TEAM_CATEGORY(30),
    /** [32]設籍狀況 */
    RESIDENT_MARK_CATEGORY(32),
    /** [34]收件單位 */
    RECEIVE_BUREAU_CATEGORY(34),
    /** [37]註參類別 */
    REFERENCE_PERSON_KIND_CATEGORY(37),
    /** [41]管制等級 */
    RESTRAINT_LEVEL_CATEGORY(41),
    /** [42]管制類別 */
    RESTRAINT_TYPE_CATEGORY(42),
    /** [43]管制區分 */
    RESTRAINT_DISTINCT_CATEGORY(43),
    /** [44]管制註號 */
    RESTRAINT_NO_CATEGORY(44),
    /** [45]管制出境原因 */
    RESTRAINT_REASON_CATEGORY(45),
    /** [50]扣證類別 */
    SUSPEND_PERMIT_TYPE_CATEGORY(50),
    /** [51]被保人類別 */
    INSURED_TYPE_CATEGORY(51),
    /** [54]作廢遺失註記 */
    LOST_REMARK_CATEGORY(54),
    /** [55]補辦註記 */
    REISSUEMARK_CATEGORY(55),
    /** [58]加簽.延期.通報.顯示扣證註記 */
    DISPLAYMARK_CATEGORY(58),
    /** [59]延期類別 */
    DECIDETYPE_CATEGORY(59),
    /** [63]核定狀況 */
    DECIDEMARK_CATEGORY(63),
    /** [68]僑別 */
    NATION_OVERSEA_CATEGORY(68),
    /** [69]僑生類別 */
    STUDENT_TYPE_CATEGORY(69),
    /** [70]性別 */
    GENDER_CODE_CATEGORY(70),
    /** [74]存或歿註記 */
    DEAD_MARK_CATEGORY(74),
    /** [98]是否註記 */
    HAS_REMARK_CATEGORY(98),
    /** [115居留原因 */
    RESIDENT_REASON_CATEGORY(115),
    /** [116]任職單位代號 */
    SERVICE_UNIT_CATEGORY(116),
    /** [123]是否註記 */
    REVOKE_MARK_CATEGORY(123),
    /** [124]安檢處置代碼 */
    DISPOSE_NO_CATEGORY(124),
    /** [125]管制單位 */
    RESTRAINT_BUREAU_CATEGORY(125),
    /** [127]安檢案情 */
    CASE_NO_CATEGORY(127),
    /** [141]遺失護照註記 */
    LOST_PASSPORT_REASON_CATEGORY(141),
    /** [152]安檢檔外籍勞工註記 */
    WORK_MARK_CATEGORY(152),
    /** [156]中共人物誌教育程度 */
    EDUCATION_CATEGORY(156),
    /** [157]國籍變更類別 */
    CHANGETYPE_CATEGORY(157),
    /** [174]核轉機關 */
    CONVEY_DEPT_CATEGORY(174),
    /** [180]財政部稅捐單位 */
    TAX_BUREAU_CATEGORY(180),
    /** [181]外交部外人簽證訪華目的代碼 */
    REASON_CATEGORY(181),
    /** [182]外交部外人簽證類別代碼 */
    VISA_KIND_CATEGORY(182),
    /** [183]外交部外人簽證類別代碼 */
    VISA_DEADLINE_CATEGORY(183),
    /** [188]居留事由 */
    RESIDENCE_REASON(188),
    /** [201]通緝職業代碼 */
    OCCUPATION_CATEGORY_4(201),
    /** [202]通緝案由代碼 */
    WANTED_REASON_CATEGORY(202),
    /** [203]通緝單位代碼 */
    WANTED_DEPARTMENT_CATEGORY(203),
    /** [205]通緝處理情形代碼 */
    WANTED_PROCESS_CATEGORY(205),
    /** [206]通緝特殊記號１ */
    WANTED_SPECIAL_MARK1_CATEGORY(206),
    /** [207]通緝撤銷原因代碼 */
    WANTED_REVOKE_REASON_CATEGORY(207),
    /** [208]通緝特殊記號２ */
    WANTED_SPECIAL_MARK2_CATEGORY(208),
    /** [209]罰金單位 */
    PUNISH_UNIT_CATEGORY(209),
    /** [210]通緝戶籍變遷 */
    MOVE_IN_MARK_CATEGORY(210),
    /** [219]大陸政黨背景 */
    RELIGION_CATEGORY(219),
    /** [240]居留狀況 */
    RESIDENCE_STATUS_CATEGORY(240),
    /** [241]警政署報案方式 */
    REPORT_TYPE_CATEGORY(241),
    /** [242]警政署協尋處理情形 */
    SEARCHED_STATUS_CATEGORY(242),
    /** [243]外人行方不明查獲單位 */
    DEPT_CATEGORY(243),
    /** [300]列管檔案類別 */
    FILE_TYPE_CATEGORY(300),
    /** [301]管制（告知）類別 */
    SECURITY_KIND_CATEGORY(301),
    /** [303]單位 */
    INFORM_DEPARTMENT_CATEGORY(303),
    /** [304]結案註記 */
    END_MARK_CATEGORY(304),
    /** [306]涉嫌（處置）代碼 */
    TypeCode_CATEGORY(306),
    /** [313]安檢單位 */
    APPLY_DEPARTMENT_CATEGORY(313),
    /** [316]違規原因代碼 */
    VIOREASONCODE(316),
    /** [318]建檔列管理由 */
    REMARK_REASON_CATEGORY(318),
    /** [319]建檔期限 */
    PERIOD_CATEGORY(319),
    /** [322]兵役狀態 */
    /** [321]PermitType */
    PERMIT_TYPE(321), MilitaryMark_CATEGORY(322),
    /** [324]終端機所在位置代碼 */
    TERMINAL_LOCATION_CATEGORY(324),
    /** [377]??? */
    KIND_CATEGORY(377),
    /** [377]??? */
    RESIDENCE_TYPE_CATEGORY(414),
    /** [449]查詢理由代碼 */
    AUDIT_REMARK_CATEGORY(449),

    AIRPORT_CATEGORY(425),
    /** [998]??? */
    BUREAU_DEPARTMENT_CATEGORY(998),
    /** [999]??? */
    CONTROL_DEPARTMENT_CATEGORY(999),
    /** [501]??? */
    DOCTYPE_CATEGORY(501),
    /** [502]??? */
    DOCCATEGORY_CATEGORY(502),
    /** [61]??? */
    RESIGNTYPE_CATEGORY(61),
    /** [62]??? */
    RECEIVETYPE_CATEGORY(62),
    /** [62]??? */
    RCODE_CATEGORY(991), PROGRAM_NAME_CATEGORY(992), CUSTOMMARK_CATEGORY(315);

    private int code;

    CodeCategory(int code) {
        this.code = code;
    }

    /**
     * @return category value
     */
    public int intValue() {
        return code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
}
