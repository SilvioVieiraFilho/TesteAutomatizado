Feature: Funcionalidade Signup

  Scenario: Registrar um novo usuário com dados válidos
    Given que o navegador está aberto
    And o usuário acessa a URL "https://demo.automationtesting.in/Index.html"
    When o usuário clica no botão "btn1"
    And preenche o campo de e-mail com "nino_silvio@hotmail.com"
    And preenche o campo de senha com "12345"
    And clica no botão "enterbtn"
    Then uma mensagem de erro "Invalid User Name or PassWord" deve ser exibida
