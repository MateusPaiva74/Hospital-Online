package br.com.hospitalonline.api.Service;

import br.com.hospitalonline.api.Model.Consultation;
import br.com.hospitalonline.api.Model.Doctor;
import br.com.hospitalonline.api.Model.Exam;
import br.com.hospitalonline.api.Repository.ConsultationRepository;
import br.com.hospitalonline.api.Repository.DoctorRepository;
import br.com.hospitalonline.api.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ExamRepository examRepository;

    public void create(Doctor doctor){
        doctorRepository.save(doctor);
    }

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findById(Long doctorId){
        return doctorRepository.findById(doctorId);
    }

    public void cancelAppointment(Long consultationId) {
        Optional<Consultation> consultationOptional = consultationRepository.findById(consultationId);
        if (consultationOptional.isPresent()) {
            Consultation consultation = consultationOptional.get();
            consultationRepository.delete(consultation);
        } else {
            throw new RuntimeException("Consulta não encontrada");
        }
    }
    public Consultation rescheduleAppointment(Long consultationId, String newDate){
        Optional<Consultation> consultationOptional1 = consultationRepository.findById(consultationId);
        if (consultationOptional1.isPresent()){
            Consultation consultation = consultationOptional1.get();
            consultation.setDate(newDate);
            return consultationRepository.save(consultation);
        } else {
            throw new RuntimeException("Consulta não encontrada");
        }
    }

    public Exam examResult(Long examId, String result) {
        Optional<Exam> examOptional = examRepository.findById(examId);
        if (examOptional.isPresent()) {
            Exam exam = examOptional.get();
            exam.setDescription(result);
            return examRepository.save(exam);
        } else {
            throw new RuntimeException("Exame não encontrado");
        }
    }
}