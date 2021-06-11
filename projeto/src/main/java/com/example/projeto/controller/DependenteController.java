package com.example.projeto.controller;


import com.example.projeto.domain.dto.DependenteDTO;
import com.example.projeto.service.DependenteService;
import com.example.projeto.util.Constantes;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dependentes")
@AllArgsConstructor
public class DependenteController {

    private final DependenteService dependenteService;


    @GetMapping
    public ResponseEntity listarTodos(){
        return dependenteService.listarTodos().size() > Constantes.ZERO?
                ResponseEntity.ok(dependenteService.listarTodos()):
                ResponseEntity.status(404).body(Constantes.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody DependenteDTO dependenteDTO){
        return dependenteService.cadastrar(dependenteDTO)?
                ResponseEntity.created(null).body(Constantes.CREATED):
                ResponseEntity.badRequest().body(Constantes.BAD_REQUEST);

    }
    @GetMapping("/{id}")
    public ResponseEntity listarDependentesPessoaFisica(@PathVariable Integer id){
        List<DependenteDTO> dependenteDTO = dependenteService.listarPorFk(id);
        return dependenteDTO.size() == Constantes.ZERO ?
                ResponseEntity.status(204).body(Constantes.NO_CONTENT):
                ResponseEntity.ok(dependenteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Integer id, @RequestBody DependenteDTO dependenteDTO){
        return dependenteService.atualizar(id,dependenteDTO)?
                ResponseEntity.ok(Constantes.UPDATE):
                ResponseEntity.status(404).body(Constantes.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable("id") Integer id){
        return dependenteService.deletar(id)?
                ResponseEntity.ok(Constantes.DELETE):
                ResponseEntity.status(404).body(Constantes.NOT_FOUND);
    }
}
