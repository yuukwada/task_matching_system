package models;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Table(name="users")
@NamedQueries({
    @NamedQuery(
        name = "getAllUsers",
        query = "SELECT u FROM User AS u ORDER BY u.id DESC"
    ),
    @NamedQuery(
        name = "getUsersCount",
        query = "SELECT COUNT(u) FROM User AS u"
    ),
    @NamedQuery(
        name = "user_checkLoginCodeAndPassword",
        query = "SELECT u FROM User AS u WHERE u.delete_flag = 0 AND u.email = :email AND u.password = :pass"
    ),
    @NamedQuery(
        name = "checkRegisteredCode_u",
        query = "SELECT COUNT(u) FROM User AS u WHERE u.email = :email"
    )
})

@Entity
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="gender")
    private String gender;

    @Column(name="birthday", nullable = true)
    private Date birthday;

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

    @Column(name = "delete_flag")
    private Integer delete_flag;

    @Column(name="image")
    private String image;

    @LazyCollection(LazyCollectionOption.FALSE)

    @ManyToMany
    @JoinTable(name="comments",joinColumns=@JoinColumn(name="user_id"),
                               inverseJoinColumns=@JoinColumn(name="company_id"))
    private List<Company> comment_Company;

    @ManyToMany(mappedBy="favorite_User")
    private List<Company> favorite_Company_C;


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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Company> getComment_Company() {
        return comment_Company;
    }

    public void setComment_Company(List<Company> comment_Company) {
        this.comment_Company = comment_Company;
    }


}

