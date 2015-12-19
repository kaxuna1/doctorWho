package main.Controllers;

import main.Models.Doctor;
import main.Repositoris.DoctorRepository;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by vakhtanggelashvili on 10/21/15.
 */
@Controller
public class DoctorController {

    @RequestMapping("/registerdoctor")
    @ResponseBody
    public Doctor createDoctor(@RequestParam(value = "name", required = true, defaultValue = "") String name,
                               @RequestParam(value = "phone", required = true, defaultValue = "") String phone,
                               @RequestParam(value = "pn", required = true, defaultValue = "") String pn,
                               @RequestParam(value = "surname", required = true, defaultValue = "") String surname,
                               @RequestParam(value = "PIN", required = true, defaultValue = "") String PIN){
        Doctor doctor=new Doctor(name,surname,pn,phone,PIN  );
        try {

            doctorRepository.save(doctor);

            return doctor;

        }catch (Exception e){
            return null;
        }

    }
    @RequestMapping("/getdoctors")
    @ResponseBody
    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }





    public static final String API_KEY = "AIzaSyCUpvuRn8t23JiAjD7oH7xwB9NFbpShBjc";
    @Autowired
    private DoctorRepository doctorRepository;
}
