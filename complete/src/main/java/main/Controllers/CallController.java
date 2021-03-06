package main.Controllers;

import main.Models.Call;
import main.Models.CallDoctors;
import main.Models.Doctor;
import main.Models.Session;
import main.Repositoris.CallDoctorsRepository;
import main.Repositoris.CallRepository;
import main.Repositoris.SessionRepository;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vakhtanggelashvili on 12/19/15.
 */
@Controller
public class CallController {
    @RequestMapping("/getmycalls")
    @ResponseBody
    public List<Call> getMyCalls(long sessionId){

        List<Call> calls=new ArrayList<Call>();
        List<CallDoctors> callDoctorses= sessionRepository.findOne(sessionId).getUser().getCallDoctorses();

        for (int i=0;i<callDoctorses.size();i++){
            calls.add(callDoctorses.get(i).getCall());
        }
        return calls;
    }

    @RequestMapping("/getallcalls")
    @ResponseBody
    public List<CallDoctors> getAllCalls(){
        return callDoctorsRepository.findAll();
    }

    @RequestMapping("/registercall")
    @ResponseBody
    public boolean registerCall(String x,String y){

        Call call = new Call(x,y);
        callRepository.save(call);
        try {
            // Prepare JSON containing the GCM message content. What to send and where to send.
            JSONObject jGcmData = new JSONObject();
            JSONObject jData = new JSONObject();
            jData.put("message", x + "/" + y);
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



    @RequestMapping("/getactivecalls")
    @ResponseBody
    public List<Call> getActiveCalls(){
        Date date=new Date();
        long k=date.getTime();
        k=k-1000*1*60*30;
        Date date1=new Date(k);

        return callRepository.findByDate(date1);

    }

    @RequestMapping("/finishcall")
    @ResponseBody
    public boolean finishCall(long sessionId,long callId){
        Session session= sessionRepository.findOne(sessionId);
        Call call=callRepository.findOne(callId);
        CallDoctors callDoctors=new CallDoctors(session.getUser(),call);
        callDoctorsRepository.save(callDoctors);

        return true;


    }

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private CallDoctorsRepository callDoctorsRepository;
    @Autowired
    private CallRepository callRepository;

    public static final String API_KEY = "AIzaSyCUpvuRn8t23JiAjD7oH7xwB9NFbpShBjc";
}


