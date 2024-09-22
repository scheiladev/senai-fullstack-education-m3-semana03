# SENAI Fullstack [Education]

## Resolução dos exercícios da Semana 03

### M3S03 | Ex 1 - Setup

Para completar os exercícios e trabalhar com o projeto base, você precisará configurar um ambiente de desenvolvimento Java com Spring Boot, juntamente com frameworks de teste como JUnit, Mockito e outros.

Utilize o seguinte código como base:
[https://github.com/andresantnunes/Projeto-Base-Exercicios](https://github.com/andresantnunes/Projeto-Base-Exercicios "‌")

### M3S03 | Ex 2 - Testes Unitários para EstudanteService

- Escreva testes unitários com JUnit para os métodos do serviço EstudanteService.
- Use Mockito para mockar o EstudanteRepository no teste do EstudanteService.
- Verifique se os métodos do repositório são chamados corretamente ao executar métodos do serviço.
- 
### M3S03 | Ex 3 - Testes Unitários para TurmaService

- Escreva testes unitários com JUnit para os métodos do serviço TurmaService.
- Use Mockito para mockar o TurmaRepository no teste do TurmaService.
- Verifique se os métodos do repositório são chamados corretamente ao executar métodos do serviço.

### M3S03 | Ex 4 - Testes com Spring para TurmaService

- Crie um teste de integração simples para o TurmaService que carrega o contexto completo do Spring.
- Use o MockBean para gerar as respostas de banco de dados para esse sistema.

### M3S03 | Ex 5 - Teste de Controller EstudanteController

- Use MockMvc para testar os endpoints do EstudanteController.
- Verifique se as respostas HTTP têm o status correto e se o JSON retornado corresponde ao esperado.
- Use o MockBean para gerar as resposta dos services.

### M3S03 | Ex 6 - Funcionalidades com TDD

- Use MockMvc para testar os endpoints do EstudanteController.
- Verifique se as respostas HTTP têm o status correto e se o JSON retornado corresponde ao esperado.
- Use o MockBean para gerar as resposta dos services.

### M3S03 | Ex 7 - Teste de Integração com TurmaController

- Use Spring Test para testar os endpoints do TurmaController.
- Crie um banco de dados com H2 para esse teste.