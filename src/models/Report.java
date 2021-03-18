package models;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="reports")

@NamedQueries({
    @NamedQuery(
        name = "getAllReports",
        query = "SELECT r FROM Report AS r ORDER BY r.id DESC"
    ),
    @NamedQuery(
        name = "getSelfReports",
        query = "SELECT r FROM Report AS r WHERE r.user=:user ORDER BY r.id DESC"
        ),
    @NamedQuery(
            name = "getSelfCounts",
            query = "SELECT COUNT(r) FROM Report AS r WHERE r.user=:user "
            ),
    @NamedQuery(
        name = "getReportsCount",
        query = "SELECT COUNT(r) FROM Report AS r"
    ),
    @NamedQuery(
        name="searchReport_budget",
        query="SELECT r FROM Report AS r WHERE r.budget <= :budget "
        ),
    @NamedQuery(
        name="searchReport_place",
        query="SELECT r FROM Report AS r WHERE r.place_prefecture = :place_prefecture "
        ),
    @NamedQuery(
        name="searchReport_industry",
        query="SELECT r FROM Report AS r WHERE r.industry = :industry "
        ),
    @NamedQuery(
        name="searchReport_budget_place",
        query="SELECT r FROM Report AS r WHERE r.budget <= :budget AND r.place_prefecture = :place_prefecture "
        ),
    @NamedQuery(
        name="searchReport_budget_industry",
        query="SELECT r FROM Report AS r WHERE r.budget <= :budget AND r.industry = :industry "
        ),
    @NamedQuery(
        name="searchReport_place_industry",
        query="SELECT r FROM Report AS r WHERE r.place_prefecture = :place_prefecture AND r.industry = :industry "
        ),
    @NamedQuery(
        name="searchReport_budget_place_industry",
        query="SELECT r FROM Report AS r WHERE r.budget <= :budget AND r.place_prefecture = :place_prefecture AND r.industry = :industry "
        )
})

@Entity

public class Report {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "report_date", nullable = false)
    private Date report_date;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name="place_prefecture")
    private String place_prefecture;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name="industry")
    private String industry;

    @Column(name="budget")
    private Integer budget;

    @Column(name = "delete_flag")
    private Integer delete_flag;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="favorites_r",joinColumns=@JoinColumn(name="favorite_Report"),
                               inverseJoinColumns=@JoinColumn(name="favorite_Company"))
    private List<Company> favorite_Company;


    public List<Company> getFavorite_Company() {
        return favorite_Company;
    }

    public void setFavorite_Company(List<Company> favorite_Company) {
        this.favorite_Company = favorite_Company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPlace_prefecture() {
        return place_prefecture;
    }

    public void setPlace_prefecture(String place_prefecture) {
        this.place_prefecture = place_prefecture;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }






}
