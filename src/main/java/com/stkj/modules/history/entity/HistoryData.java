package com.stkj.modules.history.entity;

import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;

import com.fasterxml.jackson.annotation.JsonFormat;
public class HistoryData {
	
    private Integer id;

    @Excel(name = "时间", exportFormat = "yyyy-MM-dd HH:mm:ss", orderNum = "1", width=30 , height=20)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    private String siteName;

    private String siteNum;
    
    @Excel(name="监测站号",replace = {"1_88888880000001", "2_88888880000002","3_88888880000003","4_88888880000004"},orderNum = "0")
    private String mn;
    
    private Double longtitude;

    private Double latitude;

    private Double aqiindex;

    private Double aqilevel;

    @Excel(name="SO2",orderNum = "2")
    private Double so2;

    @Excel(name="SO2_Flag",orderNum = "3")
    private String so2Flag;

    private Double atmPressure;

    private String atmPressureFlag;

    private String windDirection;

    private String windDirectionFlag;

    private Double windSpeed;

    private String windSpeedFlag;

    @Excel(name="NO2",orderNum = "4")
    private Double no2;

    @Excel(name="NO2_Flag",orderNum = "5",width=15)
    private String no2Flag;

    private Double temperature;

    private String temperatureFlag;

    @Excel(name="TVOC",orderNum = "6")
    private Double tvoc;

    @Excel(name="TVOC_Flag",orderNum = "7",width=15)
    private String tvocFlag;

    @Excel(name="PM2.5",orderNum = "8")
    private Double pm25;

    @Excel(name="PM2.5_Flag",orderNum = "9",width=15)
    private String pm25Flag;

    @Excel(name="PM10",orderNum = "10")
    private Double pm10;

    @Excel(name="PM10_Flag",orderNum = "11",width=15)
    private String pm10Flag;

    @Excel(name="CO",orderNum = "12")
    private Double co;

    @Excel(name="CO_Flag",orderNum = "13")
    private String coFlag;

    @Excel(name="O3",orderNum = "14")
    private Double o3;

    @Excel(name="O3_Flag",orderNum = "15")
    private String o3Flag;

    private Double moisture;

    private String moistrueFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getSiteNum() {
        return siteNum;
    }

    public void setSiteNum(String siteNum) {
        this.siteNum = siteNum == null ? null : siteNum.trim();
    }

    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn == null ? null : mn.trim();
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getAqiindex() {
        return aqiindex;
    }

    public void setAqiindex(Double aqiindex) {
        this.aqiindex = aqiindex;
    }

    public Double getAqilevel() {
        return aqilevel;
    }

    public void setAqilevel(Double aqilevel) {
        this.aqilevel = aqilevel;
    }

    public Double getSo2() {
        return so2;
    }

    public void setSo2(Double so2) {
        this.so2 = so2;
    }

    public String getSo2Flag() {
        return so2Flag;
    }

    public void setSo2Flag(String so2Flag) {
        this.so2Flag = so2Flag == null ? null : so2Flag.trim();
    }

    public Double getAtmPressure() {
        return atmPressure;
    }

    public void setAtmPressure(Double atmPressure) {
        this.atmPressure = atmPressure;
    }

    public String getAtmPressureFlag() {
        return atmPressureFlag;
    }

    public void setAtmPressureFlag(String atmPressureFlag) {
        this.atmPressureFlag = atmPressureFlag == null ? null : atmPressureFlag.trim();
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection == null ? null : windDirection.trim();
    }

    public String getWindDirectionFlag() {
        return windDirectionFlag;
    }

    public void setWindDirectionFlag(String windDirectionFlag) {
        this.windDirectionFlag = windDirectionFlag == null ? null : windDirectionFlag.trim();
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindSpeedFlag() {
        return windSpeedFlag;
    }

    public void setWindSpeedFlag(String windSpeedFlag) {
        this.windSpeedFlag = windSpeedFlag == null ? null : windSpeedFlag.trim();
    }

    public Double getNo2() {
        return no2;
    }

    public void setNo2(Double no2) {
        this.no2 = no2;
    }

    public String getNo2Flag() {
        return no2Flag;
    }

    public void setNo2Flag(String no2Flag) {
        this.no2Flag = no2Flag == null ? null : no2Flag.trim();
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getTemperatureFlag() {
        return temperatureFlag;
    }

    public void setTemperatureFlag(String temperatureFlag) {
        this.temperatureFlag = temperatureFlag == null ? null : temperatureFlag.trim();
    }

    public Double getTvoc() {
        return tvoc;
    }

    public void setTvoc(Double tvoc) {
        this.tvoc = tvoc;
    }

    public String getTvocFlag() {
        return tvocFlag;
    }

    public void setTvocFlag(String tvocFlag) {
        this.tvocFlag = tvocFlag == null ? null : tvocFlag.trim();
    }

    public Double getPm25() {
        return pm25;
    }

    public void setPm25(Double pm25) {
        this.pm25 = pm25;
    }

    public String getPm25Flag() {
        return pm25Flag;
    }

    public void setPm25Flag(String pm25Flag) {
        this.pm25Flag = pm25Flag == null ? null : pm25Flag.trim();
    }

    public Double getPm10() {
        return pm10;
    }

    public void setPm10(Double pm10) {
        this.pm10 = pm10;
    }

    public String getPm10Flag() {
        return pm10Flag;
    }

    public void setPm10Flag(String pm10Flag) {
        this.pm10Flag = pm10Flag == null ? null : pm10Flag.trim();
    }

    public Double getCo() {
        return co;
    }

    public void setCo(Double co) {
        this.co = co;
    }

    public String getCoFlag() {
        return coFlag;
    }

    public void setCoFlag(String coFlag) {
        this.coFlag = coFlag == null ? null : coFlag.trim();
    }

    public Double getO3() {
        return o3;
    }

    public void setO3(Double o3) {
        this.o3 = o3;
    }

    public String getO3Flag() {
        return o3Flag;
    }

    public void setO3Flag(String o3Flag) {
        this.o3Flag = o3Flag == null ? null : o3Flag.trim();
    }

    public Double getMoisture() {
        return moisture;
    }

    public void setMoisture(Double moisture) {
        this.moisture = moisture;
    }

    public String getMoistrueFlag() {
        return moistrueFlag;
    }

    public void setMoistrueFlag(String moistrueFlag) {
        this.moistrueFlag = moistrueFlag == null ? null : moistrueFlag.trim();
    }
}