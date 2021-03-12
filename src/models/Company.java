package models;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Table(name="companies")

@NamedQueries({
    @NamedQuery(
        name = "getAllCompanies",
        query = "SELECT c FROM Company AS c ORDER BY c.id DESC"
    ),
    @NamedQuery(
        name = "getCompaniesCount",
        query = "SELECT COUNT(c) FROM Company AS c"
    ),
    @NamedQuery(
        name = "company_checkLoginCodeAndPassword",
        query = "SELECT c FROM Company AS c WHERE c.delete_flag = 0 AND c.email = :email AND c.password = :pass"
        ),
    @NamedQuery(
        name="searchCompany_budget",
        query="SELECT c FROM Company AS c WHERE c.budget <= :budget "
        ),
    @NamedQuery(
        name="searchCompany_place",
        query="SELECT c FROM Company AS c WHERE c.place_prefecture = :place_prefecture "
        ),
    @NamedQuery(
        name="searchCompany_industry",
        query="SELECT c FROM Company AS c WHERE c.industry = :industry "
        ),
    @NamedQuery(
        name="searchCompany_budget_place",
        query="SELECT c FROM Company AS c WHERE c.budget <= :budget AND c.place_prefecture = :place_prefecture "
        ),
    @NamedQuery(
        name="searchCompany_budget_industry",
        query="SELECT c FROM Company AS c WHERE c.budget <= :budget AND c.industry = :industry "
        ),
    @NamedQuery(
        name="searchCompany_place_industry",
        query="SELECT c FROM Company AS c WHERE c.place_prefecture = :place_prefecture AND c.industry = :industry "
        ),
    @NamedQuery(
        name="searchCompany_budget_place_industry",
        query="SELECT c FROM Company AS c WHERE c.budget <= :budget AND c.place_prefecture = :place_prefecture AND c.industry = :industry "
        )
})

@Entity
public class Company {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    @Column(name="phone_number")
    private String phone_number;

    @Column(name="email")
    private String email;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name="place_prefecture")
    private String place_prefecture;

    @Column(name="place_address")
    private String place_address;

    @Column(name="industry")
    private String industry;

    @Column(name="budget")
    private Integer budget;

    @Column(name="achieve")
    private String achieve;

    @Column(name="image")
    private String image;

    @Column(name = "delete_flag")
    private Integer delete_flag;

    @Column(name="achieve_image1")
    private String achieve_image1;

    @Column(name="achieve_image2")
    private String achieve_image2;

    @Column(name="achieve_image3")
    private String achieve_image3;

    @LazyCollection(LazyCollectionOption.FALSE)

    @ManyToMany(mappedBy="favorite_Company")
    private List<Report> favorite_Report;

    @ManyToMany(mappedBy="comment_Company")
    private List<User> comment_User;

//  // 多対多
//  @ManyToMany(mappedBy = "favotiteReports", fetch = FetchType.EAGER)
//  List<Employee> favoritedEmployees;

    public List<Report> getFavorite_Report() {
        return favorite_Report;
    }

    public void setFavorite_Report(List<Report> favorite_Report) {
        this.favorite_Report = favorite_Report;
    }

    public List<User> getComment_User() {
        return comment_User;
    }

    public void setComment_User(List<User> comment_User) {
        this.comment_User = comment_User;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getPlace_prefecture() {
        return place_prefecture;
    }

    public void setPlace_prefecture(String place_prefecture) {
        this.place_prefecture = place_prefecture;
    }

    public String getPlace_address() {
        return place_address;
    }

    public void setPlace_address(String place_address) {
        this.place_address = place_address;
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

    public String getAchieve() {
        return achieve;
    }

    public void setAchieve(String achieve) {
        this.achieve = achieve;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }

    public String getAchieve_image1() {
        return achieve_image1;
    }

    public void setAchieve_image1(String achieve_image1) {
        this.achieve_image1 = achieve_image1;
    }

    public String getAchieve_image2() {
        return achieve_image2;
    }

    public void setAchieve_image2(String achieve_image2) {
        this.achieve_image2 = achieve_image2;
    }

    public String getAchieve_image3() {
        return achieve_image3;
    }

    public void setAchieve_image3(String achieve_image3) {
        this.achieve_image3 = achieve_image3;
    }
}
