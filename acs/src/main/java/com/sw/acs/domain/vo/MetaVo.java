package com.sw.acs.domain.vo;

/**
 * @author 周良聪
 */
public class MetaVo {
    private String title;
    private String icon;
    private boolean noCache;

    public MetaVo() {
    }

    public MetaVo(String title, String icon, boolean noCache) {
        this.title = title;
        this.icon = icon;
        this.noCache = noCache;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isNoCache() {
        return noCache;
    }

    public void setNoCache(boolean noCache) {
        this.noCache = noCache;
    }

    @Override
    public String toString() {
        return "MetaVo{" +
                "title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                ", noCache=" + noCache +
                '}';
    }
}
