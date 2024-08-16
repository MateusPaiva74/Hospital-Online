package br.com.hospitalonline.api.Service;

import br.com.hospitalonline.api.Model.Consultation;
import br.com.hospitalonline.api.Repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Autowired
public class ConsultationService {
    @Autowired
    ConsultationRepository consultationRepository;

    public void create(Consultation consultation){
        consultationRepository.save(consultation);
    }

    public Consultation updateConsultation(Long consultaId, Consultation consultationUpdate) {
        Optional<Consultation> consultationOptional = consultationRepository.findById(consultaId);
        if (consultationOptional.isPresent()) {
            Consultation consultation = consultationOptional.get();
            consultation.setDate(consultationUpdate.getDate());
            consultation.setDoctor(consultationUpdate.getDoctor());
            consultation.setPatient(consultationUpdate.getPatient());
            consultation.setAgreement(consultationUpdate.getAgreement);
            consultation.setExams(consultationUpdate.getExams());
        } else {
            throw new RuntimeException("Consulta não encontrada");
        }
    }

    public List<Consultation> findByAllConsultation(){
        return consultationRepository.findAll();
    }

    public void deleteConsultation(Long consultaId){
        consultationRepository.deleteById(consultaId);
    }

    public Optional<Consultation> findById(Long consultaId){
        return consultationRepository.findById(consultaId);
    }
}
