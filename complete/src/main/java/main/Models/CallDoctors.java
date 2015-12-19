package main.Models;

import javax.persistence.*;

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

    public CallDoctors(){

    }

    public CallDoctors(Doctor doctor,Call call){
        this.doctor=doctor;
        this.call=call;

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
}
