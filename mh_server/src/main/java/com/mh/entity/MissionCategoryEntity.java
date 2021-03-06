package com.mh.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by lenovo on 2016/7/26.
 */
@Entity
@Table(name = "mh_mission_category", schema = "mission_help")
public class MissionCategoryEntity {
    private Long id;
    private String name;
    private String iconImgUrl;
    private Boolean open;
    private String notes;
    private Date createTime;

    @Id
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "icon_img_url", nullable = true, length = 255)
    public String getIconImgUrl() {
        return iconImgUrl;
    }

    public void setIconImgUrl(String iconImgUrl) {
        this.iconImgUrl = iconImgUrl;
    }

    @Basic
    @Column(name = "open", nullable = true)
    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    @Basic
    @Column(name = "notes", nullable = true, length = 255)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "create_time", nullable = true)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MissionCategoryEntity that = (MissionCategoryEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (iconImgUrl != null ? !iconImgUrl.equals(that.iconImgUrl) : that.iconImgUrl != null) return false;
        if (open != null ? !open.equals(that.open) : that.open != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (iconImgUrl != null ? iconImgUrl.hashCode() : 0);
        result = 31 * result + (open != null ? open.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }
}
