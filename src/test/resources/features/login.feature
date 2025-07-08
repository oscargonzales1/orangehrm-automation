@all
Feature: Login Feature

  @login-success
  Scenario: Login exitoso
    Given que el usuario accede a la aplicación
    When inicia sesión con usuario válido
    Then debe visualizar el dashboard

  @login-failed
  Scenario: Login fallido
    Given que el usuario accede a la aplicación
    When inicia sesión con usuario inválido
    Then debe mostrarse un mensaje de error