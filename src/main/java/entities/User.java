package entities;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String job;
    private String description;
    @XmlElement(name="phone-number")
    private String phoneNumber;
    private Address address;
    @XmlElementWrapper(name="social-skills")
    @XmlElement(name="social-skill")
    private List<Skill> socialSkills;
    @XmlElementWrapper(name="programming-skills")
    @XmlElement(name="programming-skill")
    private List<Skill> programmingSkills;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Skill> getSocialSkills() {
        return socialSkills;
    }

    public void setSocialSkills(List<Skill> socialSkills) {
        this.socialSkills = socialSkills;
    }

    public List<Skill> getProgrammingSkills() {
        return programmingSkills;
    }

    public void setProgrammingSkills(List<Skill> programmingSkills) {
        this.programmingSkills = programmingSkills;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            return id.equals(user.id);
        }
        return false;
    }
}
