package main.Models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vakhtanggelashvili on 12/18/15.
 */
@Entity
@Table(name = "CallDoctors")
public class CallDoctors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "callDoctorId")
    private long id;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "callId")
    private Call call;

    @Column
    private Date date;


    public CallDoctors(){

    }

    public CallDoctors(Doctor doctor,Call call){
        this.doctor=doctor;
        this.call=call;
        this.date=new Date();
    }


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Call getCall() {
        return call;
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
