package com.example.carrosapi.service;

import com.example.carrosapi.model.Carro;
import com.example.carrosapi.model.TipoCarro;
import com.example.carrosapi.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getTop10Potencia() {
        return carroRepository.findTop10ByPotenciaOrderByPotenciaDesc();
    }

    public List<Carro> getTop10Economia() {
        return carroRepository.findTop10ByEconomiaOrderByEconomiaDesc();
    }

    public List<Carro> getCarrosEletricos() {
        return carroRepository.findByTipo(TipoCarro.ELETRICO);
    }

    public Optional<Carro> getCarroById(Long id) {
        return carroRepository.findById(id);
    }

    public Carro createCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public Carro updateCarro(Long id, Carro carroAtualizado) {
        return carroRepository.findById(id)
                .map(carro -> {
                    carroAtualizado.setId(id);
                    return carroRepository.save(carroAtualizado);
                })
                .orElse(null);
    }

    public void deleteCarro(Long id) {
        carroRepository.deleteById(id);
    }

    public List<Carro> listarTodosCarros() {
        return carroRepository.findAll();
    }
}