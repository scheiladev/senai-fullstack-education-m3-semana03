package com.example.demo.service;

import com.example.demo.database.entities.Estudante;
import com.example.demo.database.repositories.EstudanteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EstudanteServiceTest {

  static Estudante estudante;

  @Mock
  private EstudanteRepository estudanteRepository;

  @InjectMocks
  private EstudanteService estudanteService;

  @BeforeEach
  void setUp() {
    estudante = new Estudante(1L, "Scheila", "18.07", Collections.emptyList());
  }

  @Test
  void cadastrarEstudante() {
    when(estudanteRepository.save(any(Estudante.class))).thenReturn(estudante);

    Estudante estudanteTeste = estudanteService.cadastrarEstudante("Scheila", "18.07");

    verify(estudanteRepository).save(any(Estudante.class));

    assertEquals(estudante.getNome(), estudanteTeste.getNome());
    assertEquals(estudante.getMatricula(), estudanteTeste.getMatricula());
  }

  @Test
  void listarEstudantes() {
    when(estudanteRepository.findAll()).thenReturn(List.of(estudante));

    List<Estudante> estudanteTeste = estudanteService.listarEstudantes();

    verify(estudanteRepository).findAll();

    assertEquals(estudante.getNome(), estudanteTeste.get(0).getNome());
    assertEquals(estudante.getMatricula(), estudanteTeste.get(0).getMatricula());
  }

  @Test
  void buscarEstudantePorId() {
    when(estudanteRepository.findById(anyLong())).thenReturn(Optional.of(estudante));

    Estudante estudanteTeste = estudanteService.buscarEstudantePorId(1L);

    verify(estudanteRepository).findById(anyLong());

    assertEquals(estudante.getNome(), estudanteTeste.getNome());
    assertEquals(estudante.getMatricula(), estudanteTeste.getMatricula());
  }

  @Test
  void atualizarEstudante() {
    when(estudanteRepository.findById(anyLong())).thenReturn(Optional.of(estudante));
    when(estudanteRepository.save(any(Estudante.class))).thenReturn(estudante);

    Estudante estudanteTeste = estudanteService.atualizarEstudante(1L, "Rodrigo", "26.10");

    verify(estudanteRepository).findById(anyLong());
    verify(estudanteRepository).save(any(Estudante.class));

    assertEquals("Rodrigo", estudanteTeste.getNome());
  }

  @Test
  void removerEstudante() {
    estudanteService.removerEstudante(1L);

    verify(estudanteRepository).deleteById(anyLong());
  }
}