package br.com.hospitalonline.api.Service;

import br.com.hospitalonline.api.Model.Exam;
import br.com.hospitalonline.api.Repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    @Autowired
    ExamRepository examRepository;

    public void create(Exam exam){
        examRepository.save(exam);
    }

    public Exam updateExam(Long examId, Exam examUpdated) {
        Optional<Exam> examOptional = examRepository.findById(examId);
        if (examOptional.isPresent()) {
            Exam exam = examOptional.get();
            exam.setName(examUpdated.getName());
            exam.setDescription(examUpdated.getDescription());
            return examRepository.save(exam);
        } else {
            throw new RuntimeException("Exame não encontrado");
        }
    }

    public List<Exam> findAll(){
        return examRepository.findAll();
    }

    public void deleteExam(Long exameId){
        examRepository.deleteById(exameId);
    }

    public Optional<Exam> findByExamId(Long exameId){
        return examRepository.findById(exameId);
    }
}
