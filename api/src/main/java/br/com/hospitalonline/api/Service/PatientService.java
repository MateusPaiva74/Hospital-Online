package br.com.hospitalonline.api.Service;

import br.com.hospitalonline.api.Model.Patient;
import br.com.hospitalonline.api.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public void create(Patient patient){
        patientRepository.save(patient);
    }

    public List<Patient> findAll(){
        return patientRepository.findAll();
    }

    public Optional<Patient> findByPatientId(Long patientId){
        return patientRepository.findById(patientId);
    }

    public void deleteById(Long patientId){
        patientRepository.deleteById(patientId);
    }

    public void update(Long patientId, Patient patient){
        Optional<Patient> patientFromDb = findById(patientId);
        if (patientFromDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Patient patientUpdate = patientFromDb.get();
        patientUpdate.setName(patientUpdate.getName());
        patientUpdate.setCpf(patientUpdate.getCpf());

        patientRepository.save(patientUpdate);
    }
}
