package com.wlg.school.Controllers;


import com.wlg.school.Models.EstudanteModel;
import com.wlg.school.Services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/estudantes")
public class EstudanteController {

    @Autowired
   private  EstudanteService estudanteService;

    @PostMapping
    public ResponseEntity<EstudanteModel> createEstudante(EstudanteModel estudanteModel){
        EstudanteModel request = estudanteService.createEstudante(estudanteModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(estudanteModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);

    }

    @GetMapping
    public ResponseEntity<List<EstudanteModel>> findAll(){
        List<EstudanteModel> request = estudanteService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<EstudanteModel> findByID(Long id){
        return estudanteService.findByID(id);
    }


    @PutMapping("/{id}")
        public EstudanteModel updateEstudante(@PathVariable Long id,@RequestBody EstudanteModel estudanteModel){
            EstudanteModel estudanteModel1 = estudanteService.findByID(id).get();
            estudanteModel1.setNome(estudanteModel.getNome());
            estudanteModel1.setEmail(estudanteModel.getEmail());
            estudanteModel1.setIdade(estudanteModel.getIdade());
            return estudanteService.updateEstudante(id, estudanteModel);
        }
    @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteEstudante(@PathVariable Long id){
            estudanteService.deleteEstudante(id);
            return ResponseEntity.noContent().build();
        }

    }

