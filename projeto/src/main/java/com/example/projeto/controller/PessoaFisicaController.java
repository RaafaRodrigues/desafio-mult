package com.example.projeto.controller;



import com.example.projeto.domain.dto.PessoaFisicaDTO;
import com.example.projeto.domain.entity.PessoaFisica;
import com.example.projeto.service.PessoaFisicaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
@AllArgsConstructor
public class PessoaFisicaController {

    private final PessoaFisicaService
            pessoaFisicaService;

    @GetMapping
    public ResponseEntity <List<PessoaFisicaDTO>> listarTodos(){
        return pessoaFisicaService.listarTodos().size()>0?ResponseEntity.ok(pessoaFisicaService.listarTodos()):ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PessoaFisica> cadastrar(@RequestBody PessoaFisicaDTO pessoaFisicaDTO){
        return pessoaFisicaService.cadastrar(pessoaFisicaDTO)?
                ResponseEntity.created(null).build():
                ResponseEntity.badRequest().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<PessoaFisicaDTO> listarUmaPessoa(@PathVariable Integer id){
        PessoaFisicaDTO pessoaFisicaDTO = pessoaFisicaService.listarPorId(id);
        return pessoaFisicaDTO.getId() == null? ResponseEntity.noContent().build():ResponseEntity.ok(pessoaFisicaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizar(@PathVariable("id") Integer id, @RequestBody PessoaFisicaDTO pessoaFisicaDTO){
        return pessoaFisicaService.atualizar(id,pessoaFisicaDTO)? ResponseEntity.ok().build(): ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable("id") Integer id){
        return pessoaFisicaService.deletar(id)? ResponseEntity.ok().build():ResponseEntity.notFound().build();
    }
}
