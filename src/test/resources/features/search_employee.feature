@all
Feature: Buscar empleado

  @buscar-empleado
  Scenario: Buscar a Alexa en módulo PIM
    Given que el usuario inicia sesión en OrangeHRM
    When busca el empleado "Alexa"
    Then se deben mostrar los resultados