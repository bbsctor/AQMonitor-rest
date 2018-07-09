package com.stkj.modules.endpoint.entity;

public class StationInfo {
    private Integer id;

    private String siteName;

    private Integer siteNum;

    private String province;

    private String city;

    private String area;

    private Integer devicecounts;
    
    private String point;

    public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public Integer getSiteNum() {
        return siteNum;
    }

    public void setSiteNum(Integer siteNum) {
        this.siteNum = siteNum;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public Integer getDevicecounts() {
        return devicecounts;
    }

    public void setDevicecounts(Integer devicecounts) {
        this.devicecounts = devicecounts;
    }
}