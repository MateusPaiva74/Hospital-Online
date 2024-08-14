package br.com.hospitalonline.api.Service;

import br.com.hospitalonline.api.Model.Consultation;
import br.com.hospitalonline.api.Repository.ConsultationRepository;
import br.com.hospitalonline.api.Repository.DoctorRepository;
import br.com.hospitalonline.api.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private ExamRepository examRepository;

    public void cancelAppointment(Long consultationId){}
    Optional<Consultation> consultationOptional = consultationRepository.findById(consultationId);
    if(consultationOptional.isPresent()){
        Consultation consultation = consultationOptional.get();
        consultationRepository.delete(consultation);
    } else{
        throw new RuntimeException("Consulta não encontrada");
    }
}

