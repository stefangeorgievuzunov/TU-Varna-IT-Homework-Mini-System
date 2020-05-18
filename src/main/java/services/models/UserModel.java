package services.models;

import entities.Address;
import entities.Skill;

import java.util.List;

public class UserModel {
    private Integer id;
    private String name;
    private String email;
    private String job;
    private String description;
    private String phoneNumber;
    private Address address;
    private List<Skill> socialSkills;
    private List<Skill> programmingSkills;

    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
