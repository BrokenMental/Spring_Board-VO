package com.setting.domain;

/**
 * Created by Jinuk on 2017-07-11.
 */

public class SettingVO {

    private int bno;
    private String title;
    private String contents;
    private int root;
    private int pno;
    private int cno;
    private int depth;
    private String id;
    private String today;
    private int hit;

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
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

    public int getRoot() { return root; }

    public void setRoot(int root) { this.root = root; }

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToday() {
        return today;
    }

    public void setToday(String day) {
        this.today = day;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    @Override
    public String toString() {
        return "SettingVO{" +
                "bno=" + bno +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", root=" + root +
                ", pno=" + pno +
                ", cno=" + cno +
                ", depth=" + depth +
                ", id='" + id + '\'' +
                ", today='" + today + '\'' +
                ", hit=" + hit +
                '}';
    }
}
