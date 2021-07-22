package com.mineiro.controleponto.controller;

import com.mineiro.controleponto.model.JornadaTrabalho;
import com.mineiro.controleponto.service.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

    @Autowired
    JornadaService jornadaService;

    @PostMapping
    public JornadaTrabalho createJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.saveJornada(jornadaTrabalho);
    }

    @GetMapping("/list")
    public List<JornadaTrabalho> getJornadaList() {
        return jornadaService.findAll();
    }

    @GetMapping("/{idJornada}")
    public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        return ResponseEntity.ok(
                    jornadaService.getById(idJornada)
                    .orElseThrow( () -> new NoSuchElementException("Jornada não encontrada!") )
                );
    }

    @PutMapping
    public JornadaTrabalho updateJornada(@RequestBody JornadaTrabalho jornadaTrabalho) {
        return jornadaService.updateJornada(jornadaTrabalho);
    }

    @DeleteMapping("/{idJornada}")
    public ResponseEntity deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
        try {
            jornadaService.deleteJornada(idJornada);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
    }
}
