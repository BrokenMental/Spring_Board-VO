package com.setting.domain;

/**
 * Created by Jinuk on 2017-07-11.
 */

public class SettingVO {

    private int idx;
    private int parent_idx;
    private String title;
    private String contents;
    private int hit_cnt;
    private String del_gb;
    private String crea_dtm;
    private String crea_id;

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getHit_cnt() {
        return hit_cnt;
    }

    public void setHit_cnt(int hit_cnt) {
        this.hit_cnt = hit_cnt;
    }

    public String getDel_gb() {
        return del_gb;
    }

    public void setDel_gb(String del_gb) {
        this.del_gb = del_gb;
    }

    public String getCrea_dtm() {
        return crea_dtm;
    }

    public void setCrea_dtm(String crea_dtm) {
        this.crea_dtm = crea_dtm;
    }

    public String getCrea_id() {
        return crea_id;
    }

    public void setCrea_id(String crea_id) {
        this.crea_id = crea_id;
    }

    public int getParent_idx() {
        return parent_idx;
    }

    public void setParent_idx(int parent_idx) {
        this.parent_idx = parent_idx;
    }

    @Override
    public String toString() {
        return "SettingVO{" +
                "idx=" + idx +
                ", parent_idx=" + parent_idx +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", hit_cnt=" + hit_cnt +
                ", del_gb='" + del_gb + '\'' +
                ", crea_dtm='" + crea_dtm + '\'' +
                ", crea_id='" + crea_id + '\'' +
                '}';
    }
}
