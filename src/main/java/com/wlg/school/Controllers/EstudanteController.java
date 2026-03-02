package com.wlg.school.Controllers;


import com.wlg.school.Models.EstudanteModel;
import com.wlg.school.Services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/estudantes")
public class EstudanteController {

    @Autowired
    EstudanteService estudanteService;

    @PostMapping
    public EstudanteModel createEstudante(EstudanteModel estudanteModel){
        return estudanteService.createEstudante(estudanteModel);
    }

    @GetMapping
    public List<EstudanteModel> findAll(){
        return estudanteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EstudanteModel> findByID(Long id){
        return estudanteService.findByID(id);
    }
    @DeleteMapping("/{id}")
    public void deleteEstudante(@PathVariable Long id){
        estudanteService.deleteEstudante(id);
    }

    @PutMapping("/{id}")
        public EstudanteModel updateEstudante(@PathVariable Long id,@RequestBody EstudanteModel estudanteModel){
            EstudanteModel estudanteModel1 = estudanteService.findByID(id).get();
            estudanteModel1.setNome(estudanteModel.getNome());
            estudanteModel1.setEmail(estudanteModel.getEmail());
            estudanteModel1.setIdade(estudanteModel.getIdade());
            return estudanteService.updateEstudante(id, estudanteModel);
        }
    }

