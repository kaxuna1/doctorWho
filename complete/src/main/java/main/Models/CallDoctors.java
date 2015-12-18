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






}
