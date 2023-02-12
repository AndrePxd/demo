package primertrabajo.arqui.demo.dto;

import java.math.BigDecimal;

public class ApiDto {
    private boolean success;
    private ChangeDto query;
    private InfoDto info;
    private String date;
    private BigDecimal result;

    public ApiDto(boolean success, ChangeDto query, InfoDto info, String date, BigDecimal result) {
        this.success = success;
        this.query = query;
        this.info = info;
        this.date = date;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ChangeDto getQuery() {
        return query;
    }

    public void setQuery(ChangeDto query) {
        this.query = query;
    }

    public InfoDto getInfo() {
        return info;
    }

    public void setInfo(InfoDto info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ApiDto{" +
                "success=" + success +
                ", query=" + query +
                ", info=" + info +
                ", date='" + date + '\'' +
                ", result=" + result +
                '}';
    }
}
