package main.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vakhtanggelashvili on 11/29/15.
 */
@Entity
@Table(name = "Doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "doctorId")
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String personalNumber;


    @Column
    private String phone;

    @Column
    private String PIN;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CallDoctors> callDoctorses;



    public Doctor(String name, String surname,String personalNumber,String phone,String PIN) {
        this.name = name;
        this.personalNumber = personalNumber;
        this.phone=phone;
        this.surname=surname;
        this.PIN=PIN;
        this.callDoctorses=new ArrayList<CallDoctors>();
    }
    public Doctor(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public List<CallDoctors> getCallDoctorses() {
        return callDoctorses;
    }

    public void setCallDoctorses(List<CallDoctors> callDoctorses) {
        this.callDoctorses = callDoctorses;
    }
}
