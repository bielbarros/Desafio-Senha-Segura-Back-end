# 🔐 Secure Password Validator

Este projeto consiste em um **validador de senhas seguro**, implementado em Java com Spring Boot. O objetivo é garantir que senhas fornecidas por usuários sigam critérios mínimos de segurança, utilizando expressões regulares e boas práticas de validação.

---

## 🚀 Tecnologias Utilizadas

- Java 21+
- Spring Boot
- Expressões Regulares (Regex)
- Micrometer Commons (`StringUtils`)
- Programação Orientada a Objetos

---

## 🎯 Objetivo

O serviço `PasswordService` realiza a validação de senhas com base nos seguintes critérios:

1. ✅ Mínimo de 8 caracteres
2. ✅ Pelo menos uma letra **maiúscula**
3. ✅ Pelo menos uma letra **minúscula**
4. ✅ Pelo menos **um número**
5. ✅ Pelo menos **um caractere especial** (ex: `!@#$%&*()`)

---

## 🧠 Lógica de Validação

Cada critério de validação é implementado em métodos separados e reutilizáveis, seguindo o princípio **Single Responsibility**. O método `validate(String pass)` retorna uma lista com as falhas encontradas.

### Exemplo de Saída:

```bash
[
  "A senha deve possuir pelo menos uma letra maiúscula.",
  "A senha deve possuir pelo menos um caractere especial."
]
```

---

## 📂 Estrutura da Classe

```bash
public class PasswordService {
    
    public List<String> validate(String pass) { ... }

    private static void validateLength(String pass, List<String> failures) { ... }
    private static void validateUppercase(String pass, List<String> failures) { ... }
    private static void validateLowercase(String pass, List<String> failures) { ... }
    private static void validateNumber(String pass, List<String> failures) { ... }
    private static void validateSpecialChars(String pass, List<String> failures) { ... }
}
```

---

## 🧪 Exemplos de Testes (Sugestão)

```java
@Test
void testValidPassword() {
    PasswordService service = new PasswordService();
    List<String> result = service.validate("A1@bcdEf");
    assertTrue(result.isEmpty());
}

@Test
void testMissingUppercase() {
    PasswordService service = new PasswordService();
    List<String> result = service.validate("a1@bcdef");
    assertTrue(result.contains("A senha deve possuir pelo menos uma letra maiúscula."));
}
```

---

## 🛡️ Observações

- A validação é **estática** e sem dependência de banco de dados.
- Pode ser facilmente integrada com camadas REST ou formulários de cadastro.
- Projetado para ser reutilizável em contextos de microserviços ou monolitos.

---

**Gabriel – Full Stack Developer (Java & Angular)**  
**Email:** [gabrielbarrosg11@gmail.com]  
**LinkedIn:** [linkedin.com/in/gabriel-sbarros](#)