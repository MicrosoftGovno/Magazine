package jpa;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "admin", schema = "", catalog = "")
public class AdminEntity {
    private Integer adminId;
    private String adminName;
    private List<ArticleEntity> articles;

    @Id
    @Column(name = "admin_id")
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    @Basic
    @Column(name = "admin_name")
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (adminId != null ? !adminId.equals(that.adminId) : that.adminId != null) return false;
        if (adminName != null ? !adminName.equals(that.adminName) : that.adminName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = adminId != null ? adminId.hashCode() : 0;
        result = 31 * result + (adminName != null ? adminName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "admin")
    public List<ArticleEntity> getArticles() {
        return articles;
    }

    public void setArticles(List<ArticleEntity> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return adminName;
    }
}
