package com.example.carrosapi.controller;

import com.example.carrosapi.model.Carro;
import com.example.carrosapi.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/potencia")
    public List<Carro> getTop10Potencia() {
        return carroService.getTop10Potencia();
    }

    @GetMapping("/economia")
    public List<Carro> getTop10Economia() {
        return carroService.getTop10Economia();
    }

    @GetMapping("/eletricos")
    public List<Carro> getCarrosEletricos() {
        return carroService.getCarrosEletricos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarroById(@PathVariable Long id) {
        return carroService.getCarroById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carro> createCarro(@RequestBody Carro carro) {
        Carro carroSalvo = carroService.createCarro(carro);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> updateCarro(@PathVariable Long id, @RequestBody Carro carroAtualizado) {
        Carro carroAtualizadoSalvo = carroService.updateCarro(id, carroAtualizado);
        if(carroAtualizadoSalvo != null) {
            return ResponseEntity.ok(carroAtualizadoSalvo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable Long id) {
        carroService.deleteCarro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<Carro> listarTodosCarros() {
        return carroService.listarTodosCarros();
    }
}