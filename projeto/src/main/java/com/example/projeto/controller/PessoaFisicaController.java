package com.example.projeto.controller;



import com.example.projeto.domain.dto.PessoaFisicaDTO;
import com.example.projeto.service.PessoaFisicaService;
import com.example.projeto.util.Constantes;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
@AllArgsConstructor
public class PessoaFisicaController {

    private final PessoaFisicaService
            pessoaFisicaService;

    @GetMapping
    public ResponseEntity  listarTodos(){
        return pessoaFisicaService.listarTodos().size() > Constantes.ZERO?
                ResponseEntity.ok(pessoaFisicaService.listarTodos()):
                ResponseEntity.status(204).body(Constantes.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody PessoaFisicaDTO pessoaFisicaDTO){
        return pessoaFisicaService.cadastrar(pessoaFisicaDTO)?
                ResponseEntity.created(null).body(Constantes.CREATED):
                ResponseEntity.badRequest().body(Constantes.BAD_REQUEST);

    }

    @GetMapping("/{id}")
    public ResponseEntity listarUmaPessoa(@PathVariable Integer id){
        PessoaFisicaDTO pessoaFisicaDTO = pessoaFisicaService.listarPorId(id);
        return pessoaFisicaDTO.getId() == null?
                ResponseEntity.status(404).body(Constantes.NOT_FOUND):
                ResponseEntity.ok(pessoaFisicaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Integer id, @RequestBody PessoaFisicaDTO pessoaFisicaDTO){
        return pessoaFisicaService.atualizar(id,pessoaFisicaDTO)?
                ResponseEntity.ok(Constantes.UPDATE):
                ResponseEntity.status(400).body(Constantes.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable("id") Integer id){
        return pessoaFisicaService.deletar(id)?
                ResponseEntity.ok(Constantes.DELETE):
                ResponseEntity.status(404).body(Constantes.NOT_FOUND);
    }
}
