package id.ac.uin.student.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TestController {
    @GetMapping("test1")
    public String getform(com.kelompok1.utspbo.entity.Penduduk penduduk){
        return "indexPenduduk2";
    }

    @PostMapping("/save-student")
    public String submitStudentDetails(@Valid com.kelompok1.utspbo.entity.Penduduk penduduk, Errors errors, Model model){
        if(null != errors && errors.getErrorCount() > 0){
            return "indexPenduduk2";
        }else {
            model.addAttribute("SuccessMsg", "Details saved successfully...");
            return "success";
        }
    }
}
