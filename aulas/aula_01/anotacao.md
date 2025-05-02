# 📌 Evolução do Ecossistema Java Corporativo

## 📝 Introdução  
Notas sobre a transição do Java EE tradicional para Spring Framework e, finalmente, Spring Boot, além de orientações iniciais de setup no Spring Initializr.

---

## 🎯 Linha do Tempo

| Ano  | Tecnologia                       | Características principais                                            |
|------|----------------------------------|------------------------------------------------------------------------|
| —    | **Java EE (J2EE)**               | • Padrão corporativo pesado e complexo<br>• EJB, Servlets, XML extensivo |
| 2003 | **Spring Framework**             | • Simplificar o Java EE<br>• Inversão de Controle & Injeção de Dependências<br>• Modular, mas ainda com muita configuração manual |
| 2014 | **Spring Boot**                  | • Auto-configuração e simplicidade<br>• Servidores embutidos<br>• Ideal para microsserviços e cloud |

---

## 🔧 Spring Initializr (https://start.spring.io/)

1️⃣ **Projeto**  
- **Type**: Maven Project  
- **Language**: Java  
- **Spring Boot**: 3.4.4 (Java 21)  

## 2️⃣ Coordenadas do Maven

| Campo        | Valor de Exemplo             |
|--------------|-------------------------------|
| **Group**    | `br.com.mercadolivre.nomedoprojeto` |
| **Artifact** | `ml-users`                    |
| **Name**     | `ml-users`                    |
| **Packaging**| `jar` ou `war`                 |
| **Java**     | `21`                           |

**Observação:**
- **Group**: no curso da Ada, estamos usando o domínio invertido `tech.ada`.
- **Packaging**:
   - `jar`: executado dentro da JVM.
   - `war`: implantado dentro de um container web (ex.: Tomcat, WildFly).


3️⃣ **Dependências mínimas**  
- Spring Web

4️⃣ **Gerar**  
- Clique em **GENERATE**  
- Descompacte o ZIP gerado em seu diretório de trabalho  

---

## 🔍 Estrutura Gerada (`pom.xml`)

Dentro de:
```xml
<dependencies>
  <!-- Aqui estão todas as bibliotecas que o Spring Initializr incluiu -->
</dependencies>
```
→ É nesse bloco que você verá cada dependência baixada pelo Maven.

---

## 🚀 Teste Inicial

1. Navegue até o diretório do projeto no terminal.  
2. Execute:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Acesse no navegador:
   ```
   http://localhost:8080
   ```
4. Se aparecer erro padrão do Spring Boot, significa que o servidor embutido está funcionando corretamente.

---