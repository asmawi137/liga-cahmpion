package com.example.ligachampion;

public class Club {
    private String name;
    private String logo;
    private String link;
    private String detail;

    public Club() {
    }

    public Club(String name, String logo, String link, String detail) {
        this.name = name;
        this.logo = logo;
        this.link = link;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
