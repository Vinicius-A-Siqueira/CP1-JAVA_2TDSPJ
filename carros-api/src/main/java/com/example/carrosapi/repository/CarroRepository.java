package com.example.carrosapi.repository;

import com.example.carrosapi.model.Carro;
import com.example.carrosapi.model.TipoCarro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

    @Query("SELECT c FROM Carro c ORDER BY c.potencia DESC")
    List<Carro> findTop10ByPotenciaOrderByPotenciaDesc();

    @Query("SELECT c FROM Carro c ORDER BY c.economia DESC")
    List<Carro> findTop10ByEconomiaOrderByEconomiaDesc();

    List<Carro> findByTipo(TipoCarro tipo);
}