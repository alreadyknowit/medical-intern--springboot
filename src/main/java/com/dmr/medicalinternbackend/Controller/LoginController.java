package com.dmr.medicalinternbackend.Controller;

import com.dmr.medicalinternbackend.Entities.Student;
import com.dmr.medicalinternbackend.Service.attending.IAttendingPhysician;
import com.dmr.medicalinternbackend.Service.student.IStudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/login")
public class LoginController {


    private final IStudentService studentService;
    private final IAttendingPhysician attendingPhysician;

    public LoginController(IStudentService studentService, IAttendingPhysician attendingPhysician) {
        this.studentService = studentService;
        this.attendingPhysician = attendingPhysician;
    }

    @PostMapping
    public Object login(@RequestParam long no, @RequestParam String password, @RequestParam String role) throws AuthenticationException {

        if(role.equals("s")){
            return studentService.getStudentLogin(no,password,role);
        }
        else if(role.equals("a")){
            return attendingPhysician.loginAttending(String.valueOf(no),password);
        }
        return null;
    }

    @PostMapping("/check")
    public boolean checkAvailability(@RequestParam String no, String role) throws AuthenticationException {

        if(role.equals("s")){
          return studentService.checkAvailability(Long.parseLong(no));
        }
        else if(role.equals("a")){
            if(no.charAt(0) == '0'){
                no= no.substring(1);
                System.out.println(no);
            }
            return attendingPhysician.checkAvailability(no);
        }
                return false;

    }

}
