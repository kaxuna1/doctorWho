package main.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vakhtanggelashvili on 12/18/15.
 */
@Entity
@Table(name = "Calls")
public class Call {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "callId")
    private long id;

    @Column
    private String x;

    @Column
    private String y;

    @Column
    private Date date;

    @OneToMany(mappedBy = "call",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CallDoctors> callDoctorses;

    public Call(String x, String y) {
        this.x = x;
        this.y = y;
        this.date=new Date();
        this.callDoctorses=new ArrayList<CallDoctors>();
    }

    public Call(){

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public List<CallDoctors> getCallDoctorses() {
        return callDoctorses;
    }

    public void setCallDoctorses(List<CallDoctors> callDoctorses) {
        this.callDoctorses = callDoctorses;
    }
}
