package com.wlg.school.Services;

import com.wlg.school.Models.EstudanteModel;
import com.wlg.school.Repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public EstudanteModel createEstudante(EstudanteModel estudanteModel){
        return estudanteRepository.save(estudanteModel);
    }

    public List<EstudanteModel> findAll(){
        return estudanteRepository.findAll();
    }

    public Optional<EstudanteModel> findByID(Long id){
        return estudanteRepository.findById(id);
    }

    public void deleteEstudante(Long id){
        estudanteRepository.deleteById(id);
    }

    public EstudanteModel updateEstudante(Long id,EstudanteModel estudanteModel){
        EstudanteModel estudanteModel1 = estudanteRepository.findById(id).get();
        estudanteModel1.setNome(estudanteModel.getNome());
        estudanteModel1.setEmail(estudanteModel.getEmail());
        estudanteModel1.setIdade(estudanteModel.getIdade());
        return estudanteRepository.save(estudanteModel1);
    }
}
