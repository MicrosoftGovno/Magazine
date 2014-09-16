package jpa;

import javax.persistence.*;

@Entity
@Table(name = "article", schema = "", catalog = "")
public class ArticleEntity {
    private Integer articleId;
    private String articleName;
    private String articleText;
    private AdminEntity admin;

    @Id
    @Column(name = "article_id")
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "article_name")
    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    @Basic
    @Column(name = "article_text")
    public String getArticleText() {
        return articleText;
    }

    public void setArticleText(String articleText) {
        this.articleText = articleText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleEntity that = (ArticleEntity) o;

        if (articleId != null ? !articleId.equals(that.articleId) : that.articleId != null) return false;
        if (articleName != null ? !articleName.equals(that.articleName) : that.articleName != null) return false;
        if (articleText != null ? !articleText.equals(that.articleText) : that.articleText != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = articleId != null ? articleId.hashCode() : 0;
        result = 31 * result + (articleName != null ? articleName.hashCode() : 0);
        result = 31 * result + (articleText != null ? articleText.hashCode() : 0);
        return result;
    }

    @ManyToOne
    public AdminEntity getAdmin() {
        return admin;
    }

    public void setAdmin(AdminEntity admin) {
        this.admin = admin;
    }
}
