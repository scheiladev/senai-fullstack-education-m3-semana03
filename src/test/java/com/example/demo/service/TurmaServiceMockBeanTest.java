package com.example.demo.service;

import com.example.demo.database.entities.Estudante;
import com.example.demo.database.entities.Turma;
import com.example.demo.database.repositories.EstudanteRepository;
import com.example.demo.database.repositories.TurmaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("Test")
class TurmaServiceMockBeanTest {

  static Turma turma;
  static  Estudante estudante;

  @MockBean
  private TurmaRepository turmaRepository;

  @Autowired
  private TurmaService turmaService;

  @Mock
  private EstudanteRepository estudanteRepository;

  @InjectMocks
  private EstudanteService estudanteService;

  @BeforeEach
  void init() {
    turma = new Turma(1L, "Fullstack Education", new ArrayList<Estudante>());
    estudante = new Estudante(1L, "Scheila", "18.07", new ArrayList<Turma>());
  }

  @Test
  void cadastrarTurma() {
    when(turmaRepository.save(any(Turma.class))).thenReturn(turma);

    Turma turmaTeste = turmaService.cadastrarTurma("Fullstack Education");

    verify(turmaRepository).save(any(Turma.class));

    assertEquals(turma.getNome(), turmaTeste.getNome());
  }

  @Test
  void listarTurmas() {
    when(turmaRepository.findAll()).thenReturn(List.of(turma));

    List<Turma> turmaTeste = turmaService.listarTurmas();

    verify(turmaRepository).findAll();

    assertEquals(turma.getNome(), turmaTeste.get(0).getNome());
  }

  @Test
  void buscarTurmaPorId() {
    when(turmaRepository.findById(anyLong())).thenReturn(Optional.of(turma));

    Turma turmaTeste = turmaService.buscarTurmaPorId(1L);

    verify(turmaRepository).findById(anyLong());

    assertEquals(turma.getNome(), turmaTeste.getNome());
  }

  @Test
  void atualizarTurma() {
    when(turmaRepository.findById(anyLong())).thenReturn(Optional.of(turma));
    when(turmaRepository.save(any(Turma.class))).thenReturn(turma);

    Turma turmaTeste = turmaService.atualizarTurma(1L, "Education");

    verify(turmaRepository).findById(anyLong());
    verify(turmaRepository).save(any(Turma.class));

    assertEquals("Education", turmaTeste.getNome());
  }

  @Test
  void removerTurma() {
    turmaService.removerTurma(1L);

    verify(turmaRepository).deleteById(anyLong());
  }

  @Test
  void adicionarEstudanteNaTurma() {
    when(turmaRepository.findById(anyLong())).thenReturn(Optional.of(turma));

    Estudante estudanteTeste = turmaService.adicionarEstudanteNaTurma(1L,estudante);

    verify(turmaRepository).findById(anyLong());

    assertEquals(estudante.getMatricula(), estudanteTeste.getMatricula() );
    assertEquals(estudante.getNome(), estudanteTeste.getNome() );
    assertEquals(1, estudanteTeste.getTurma().size());
    assertEquals(turma.getNome(), estudanteTeste.getTurma().get(0).getNome());
  }

  @Test
  void removerEstudanteDaTurma() {
    estudante.getTurma().add(turma);

    when(turmaRepository.findById(anyLong())).thenReturn(Optional.of(turma));

    Estudante estudanteTeste = turmaService.removerEstudanteDaTurma(1L, estudante);

    verify(turmaRepository).findById(anyLong());

    assertEquals(estudante.getMatricula(), estudanteTeste.getMatricula() );
    assertEquals(estudante.getNome(), estudanteTeste.getNome() );
    assertEquals(0, estudanteTeste.getTurma().size() );
  }
}