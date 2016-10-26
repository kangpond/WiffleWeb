package gov.nia.nrs.report.bean;

public class ReportQuery {

    private String reportYear;
    private String reportMonth;
    private String reportId;

    public String getReportYear() {
        return reportYear;
    }
    public void setReportYear(String reportYear) {
        this.reportYear = reportYear;
    }
    public String getReportMonth() {
        return reportMonth;
    }
    public void setReportMonth(String reportMonth) {
        this.reportMonth = reportMonth;
    }
    public String getReportId() {
        return reportId;
    }
    public void setReportId(String reportId) {
        this.reportId = reportId;
    }
    @Override
    public String toString() {
        return "ReportQuery [reportYear=" + reportYear + ", reportMonth=" + reportMonth + ", reportId=" + reportId + "]";
    }

}
