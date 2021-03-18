package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="favorites_r")
@NamedQueries({
    @NamedQuery(
        name = "getFavoriteCounts",
        query = "SELECT COUNT(f) FROM Favorite_R AS f WHERE f.company = :company"),
    @NamedQuery(
        name = "getFavoritedReports",
        query = "SELECT f.report FROM Favorite_R AS f WHERE f.company = :company"),
    @NamedQuery(
        name = "getFavoriteEmployees",
        query = "SELECT f.company FROM Favorite_R AS f WHERE f.report = :report"),
    @NamedQuery(
        name="getFavoriteId",
        query="SELECT f.id FROM Favorite_R AS f WHERE f.report=:report AND f.company=:company"),
    @NamedQuery(
        name="getFavoriteReportCount",
        query="SELECT COUNT(f) FROM Favorite_R AS f WHERE f.report=:report")
})


@Entity
public class Favorite_R {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="favorite_Company")
    private Company company;

    @ManyToOne
    @JoinColumn(name="favorite_Report")
    private Report report;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }




}
