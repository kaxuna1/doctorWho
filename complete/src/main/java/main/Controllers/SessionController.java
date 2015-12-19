package main.Controllers;

import main.Models.Doctor;
import main.Models.Session;
import main.Repositoris.DoctorRepository;
import main.Repositoris.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by vakhtanggelashvili on 12/19/15.
 */
@Controller
public class SessionController {
    @RequestMapping("/loginapi")
    @ResponseBody
    public Session login(String phone, String pin){
        Session session;
        Doctor user;
        List<Doctor> users=userDao.findByPhoneAndPin(phone,pin);

        if(users.size()==0){
            return null;
        }else{
            user=users.get(0);
            session=new Session(new Date(),user);
            user.getSessions().add(session);
            userDao.save(user);
            return session;
        }
    }
    @RequestMapping("/logout")
    @ResponseBody
    public Session logout(String sessionId){
        Session session=sessionDao.findOne(Long.parseLong(sessionId));
        session.setIsactive(false);
        sessionDao.save(session);
        return session;
    }
    @RequestMapping("/getsessionstatus")
    @ResponseBody
    public Session sessionStatus(String sessionId){
        Session session=sessionDao.findOne(Long.parseLong(sessionId));
        return session;
    }
    @Autowired
    private DoctorRepository userDao;
    @Autowired
    private SessionRepository sessionDao;
}

