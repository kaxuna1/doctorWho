package main.Models;

import javax.persistence.*;
import javax.print.Doc;
import java.util.Date;

/**
 * Created by vakhtanggelashvili on 12/19/15.
 */
@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sessionId")
    private long id;

    @Column
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "doctorId")
    private Doctor doctor;

    @Column
    private boolean isactive;

    public Session(Date createDate,Doctor user){

        this.createDate = createDate;
        this.doctor=user;
        this.isactive=true;
    }
    public Session(){

    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Doctor getUser() {
        return doctor;
    }

    public void setUser(Doctor user) {
        this.doctor = user;
    }

    public long getId() {
        return id;
    }

    public boolean isIsactive() {
        return isactive;
    }

    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }
}

