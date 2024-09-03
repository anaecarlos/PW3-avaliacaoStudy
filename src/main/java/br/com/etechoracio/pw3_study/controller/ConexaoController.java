package br.com.etechoracio.pw3_study.controller;

import br.com.etechoracio.pw3_study.repository.ConexaoRepository;
import br.com.etechoracio.pw3_study.entity.Conexao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conexao")
public class ConexaoController {
    @Autowired
    private ConexaoRepository repository;
    @GetMapping
    public List<Conexao> listarConexao(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Conexao> buscarPorId(@PathVariable Long id) {
        var resposta = repository.findById(id);
        if (resposta.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(resposta.get());
        }
    }
    @PostMapping
    public ResponseEntity<Conexao> inserir(@RequestBody Conexao conexao){
        repository.save(conexao);
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(conexao));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Conexao> atualizar(@PathVariable Long id, @RequestBody Conexao conexao){
        var existe = repository.findById(id);
        if (!existe.isPresent())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(repository.save(conexao));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Conexao> deletaConexao(@PathVariable Long id, @RequestBody Conexao conexao) {
        Optional<Conexao> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
