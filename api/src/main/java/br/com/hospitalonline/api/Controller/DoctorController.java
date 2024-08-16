package br.com.hospitalonline.api.Controller;

import br.com.hospitalonline.api.Model.Consultation;
import br.com.hospitalonline.api.Model.Exam;
import br.com.hospitalonline.api.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @DeleteMapping("/consultation/{consultatio_id}/cancel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelAppointment(@PathVariable Long consultationId){
        doctorService.cancelAppointment(consultationId);
    }

    @PutMapping("/exam/{examId}/reschedule")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Consultation rescheduleAppointment(@PathVariable Long consultaId, @RequestParam String newDate){
        return doctorService.rescheduleAppointment(consultaId, newDate);
    }

    @PutMapping("/exam/{examId}/resultation")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Exam provideExamResults(@PathVariable Long examId, @RequestParam String result){
        return doctorService.examResult(examId, result);
    }
}
