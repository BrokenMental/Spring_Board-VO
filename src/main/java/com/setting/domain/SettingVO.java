package com.setting.domain;

/**
 * Created by Jinuk on 2017-07-11.
 */

public class SettingVO {

    private int Idx;
    private int Parent_idx;
    private String Title;
    private String Contents;
    private int Hit_cnt;
    private String Del_gb;
    private String Crea_dtm;
    private String Crea_id;

    public int getIdx() {
        return Idx;
    }

    public void setIdx(int idx) {
        Idx = idx;
    }

    public int getParent_idx() {
        return Parent_idx;
    }

    public void setParent_idx(int parent_idx) {
        Parent_idx = parent_idx;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContents() {
        return Contents;
    }

    public void setContents(String contents) {
        Contents = contents;
    }

    public int getHit_cnt() {
        return Hit_cnt;
    }

    public void setHit_cnt(int hit_cnt) {
        Hit_cnt = hit_cnt;
    }

    public String getDel_gb() {
        return Del_gb;
    }

    public void setDel_gb(String del_gb) {
        Del_gb = del_gb;
    }

    public String getCrea_dtm() {
        return Crea_dtm;
    }

    public void setCrea_dtm(String crea_dtm) {
        Crea_dtm = crea_dtm;
    }

    public String getCrea_id() {
        return Crea_id;
    }

    public void setCrea_id(String crea_id) {
        Crea_id = crea_id;
    }

    @Override
    public String toString() {
        return "SettingVO{" +
                "Idx=" + Idx +
                ", Parent_idx=" + Parent_idx +
                ", Title='" + Title + '\'' +
                ", Contents='" + Contents + '\'' +
                ", Hit_cnt=" + Hit_cnt +
                ", Del_gb='" + Del_gb + '\'' +
                ", Crea_dtm='" + Crea_dtm + '\'' +
                ", Crea_id='" + Crea_id + '\'' +
                '}';
    }
}
