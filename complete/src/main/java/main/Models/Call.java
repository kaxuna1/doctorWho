package main.Models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by vakhtanggelashvili on 12/18/15.
 */
@Entity
@Table(name = "Call")
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
}
