package br.com.fiap.contatos.controller;

import br.com.fiap.contatos.model.Contato;
import br.com.fiap.contatos.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ContatoCotroller {

    @Autowired
    private ContatoService contatoService;

    @PostMapping("/contatos")
    public Contato salvar(@RequestBody Contato contato){
        System.out.println(contato);
        return contatoService.gravar(contato);
    }

    @GetMapping("/contatos")
    public List<Contato> listarTodosOsContatos(){
        return contatoService.listarTodosOsContatos();
    }

    @GetMapping("/contatos/{id}")
    public ResponseEntity<Contato> buscarContatoPorId(@PathVariable Long id){

        try {
            Contato contato = contatoService.buscarPorId(id);
            return ResponseEntity.ok(contato);
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

}
