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

@Table(name="favorites_c")
@NamedQueries({
    @NamedQuery(
        name = "getFavoriteCounts_C",
        query = "SELECT COUNT(f) FROM Favorite_C AS f WHERE f.user = :user"),
    @NamedQuery(
        name = "getFavoritedCompanies",
        query = "SELECT f.company FROM Favorite_C AS f WHERE f.user = :user"),
    @NamedQuery(
        name="getFavoriteId_C",
        query="SELECT f.id FROM Favorite_C AS f WHERE f.user=:user AND f.company=:company"),
    @NamedQuery(
        name="getCount_C",
        query="SELECT COUNT(f) FROM Favorite_C AS f WHERE f.company=:company")

})


@Entity
public class Favorite_C {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="favorite_User")
    private User user;

    @ManyToOne
    @JoinColumn(name="favorite_Company_C")
    private Company company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}
