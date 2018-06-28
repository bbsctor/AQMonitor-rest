package com.stkj.AQMonitor.module.endpoint.entity;

public class StationMn {
    private Integer id;

    private String siteName;

    private String mnAlias;

    private String mn;

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

    public String getMnAlias() {
        return mnAlias;
    }

    public void setMnAlias(String mnAlias) {
        this.mnAlias = mnAlias == null ? null : mnAlias.trim();
    }

    public String getMn() {
        return mn;
    }

    public void setMn(String mn) {
        this.mn = mn == null ? null : mn.trim();
    }
}