package main.Controllers;

import main.Models.Call;
import main.Models.CallDoctors;
import main.Repositoris.CallDoctorsRepository;
import main.Repositoris.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by vakhtanggelashvili on 12/19/15.
 */
@Controller
public class CallController {
    @RequestMapping("/getmycalls")
    @ResponseBody
    public List<CallDoctors> getMyCalls(long sessionId){
        return sessionRepository.findOne(sessionId).getUser().getCallDoctorses();
    }

    @RequestMapping("/getallcalls")
    @Autowired
    public List<CallDoctors> getAllCalls(){
        return callDoctorsRepository.findAll();
    }

    @RequestMapping("/registercall")
    @Autowired
    public boolean registerCall(String x,String y){

        Call call = new Call(x,y);


        return true;
    }

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private CallDoctorsRepository callDoctorsRepository;

}
