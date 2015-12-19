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



    @RequestMapping("/sm")
    @ResponseBody
    public boolean sendMessage(String m){
        try {
            // Prepare JSON containing the GCM message content. What to send and where to send.
            JSONObject jGcmData = new JSONObject();
            JSONObject jData = new JSONObject();
            jData.put("message", m);
            // Where to send GCM message.

            jGcmData.put("to", "/topics/global");

            // What to send in GCM message.
            jGcmData.put("data", jData);

            // Create connection to send GCM Message request.
            URL url = new URL("https://android.googleapis.com/gcm/send");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestProperty("Authorization", "key=" + API_KEY);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // Send GCM message content.
            OutputStream outputStream = conn.getOutputStream();
            outputStream.write(jGcmData.toString().getBytes());

            // Read GCM response.
            InputStream inputStream = conn.getInputStream();
            String resp = IOUtils.toString(inputStream);
            System.out.println(resp);
            System.out.println("Check your device/emulator for notification or logcat for " +
                    "confirmation of the receipt of the GCM message.");
        } catch (IOException e) {
            System.out.println("Unable to send GCM message.");
            System.out.println("Please ensure that API_KEY has been replaced by the server " +
                    "API key, and that the device's registration token is correct (if specified).");
            e.printStackTrace();
        }
        return true;
    }

    public static final String API_KEY = "AIzaSyCUpvuRn8t23JiAjD7oH7xwB9NFbpShBjc";
    @Autowired
    private DoctorRepository doctorRepository;
}
