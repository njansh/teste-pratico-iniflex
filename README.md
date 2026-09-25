# Teste Prático - Iniflex

Projeto desenvolvido como parte do processo seletivo para a Iniflex, com o objetivo de demonstrar conceitos de Orientação a Objetos, manipulação de coleções, formatação de dados e boas práticas com a linguagem Java.

---

## 🛠️ Tecnologias Utilizadas

* **Java 17** (LTS)
* **Java Time API** (`LocalDate`, `Period`, `DateTimeFormatter`)
* **Java Math** (`BigDecimal`, `RoundingMode`)
* **Java Stream API** & **Collections Framework**

---

## 📂 Estrutura do Projeto

```text
src/
└── com/
    └── nadson/
        └── testepratico_iniflex/
            ├── Pessoa.java       # Entidade base (nome, dataNascimento)
            ├── Funcionario.java  # Entidade filha estendendo Pessoa (salario, funcao)
            └── Principal.java    # Classe executável contendo os cenários de teste

```

---

## 📋 Requisitos Implementados

1. **Modelagem de Dados**:
* Criação da classe `Pessoa` com `nome` (`String`) e `dataNascimento` (`LocalDate`).
* Criação da classe `Funcionario` que herda de `Pessoa`, contendo `salario` (`BigDecimal`) e `funcao` (`String`).


2. **Fluxo de Execução (`Principal`)**:
* **3.1**: Inserção dos 10 funcionários mantendo a ordem e dados da tabela.
* **3.2**: Remoção do funcionário "João" da lista.
* **3.3**: Impressão dos funcionários com formatação personalizada de datas (`dd/MM/yyyy`) e valores monetários no padrão brasileiro (`R$ #.##0,00`).
* **3.4**: Aplicação e persistência de 10% de aumento salarial para todos os colaboradores.
* **3.5 & 3.6**: Agrupamento em `Map<String, List<Funcionario>>` por função e exibição organizada por cargo.
* **3.8**: Filtragem dos colaboradores que fazem aniversário nos meses de outubro (10) e dezembro (12).
* **3.9**: Identificação dinâmica do funcionário de maior idade com exibição de nome e cálculo de anos via `Period`.
* **3.10**: Ordenação alfabética dos funcionários.
* **3.11**: Cálculo e exibição do somatório total dos salários.
* **3.12**: Proporção individual calculada em relação ao salário mínimo base de R$ 1.212,00.



---

## 🚀 Como Executar

### Pré-requisitos

* JDK 17 ou superior instalado.
* Git instalado.

### Passos

1. Clone o repositório:
```bash
git clone [https://github.com/njansh/teste-pratico-iniflex.git](https://github.com/njansh/teste-pratico-iniflex.git)

```


2. Abra o projeto na sua IDE de preferência (IntelliJ IDEA, Eclipse, VS Code).
3. Execute o método `main` presente na classe `com.nadson.testepratico_iniflex.Principal`.

Caso prefira rodar via terminal:

```bash
# Compilar
javac -d out src/com/nadson/testepratico_iniflex/*.java

# Executar
java -cp out com.nadson.testepratico_iniflex.Principal

```
