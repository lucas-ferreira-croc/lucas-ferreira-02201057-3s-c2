package com.provacontinuada.repositorio;

import com.provacontinuada.dominio.Lutador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LutadorRepository extends JpaRepository <Lutador,Integer> {

    List<Lutador> findByOrderByForcaGolpeDesc();


    List<Lutador>findByVidaGreaterThan(Double vida);

    List<Lutador>findByVidaLessThanEqual(Double vida);
}
