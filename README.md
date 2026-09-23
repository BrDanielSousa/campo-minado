# Campo Minado

Jogo clássico de quebra-cabeça implementado em Java para o terminal. O jogador deve abrir os campos seguros, marcar as minas e completar o tabuleiro sem detonar uma explosão.

A aplicação foi desenvolvida como um projeto didático de **Programação Orientada a Objetos**, com a lógica do jogo separada da interface de console.

## Funcionalidades

- Tabuleiro configurado inicialmente com **6 linhas, 6 colunas e 6 minas** em `Program.java`.
- Abertura de campos seguros.
- Marcação e desmarcação de campos suspeitos.
- Abertura em cascata de vizinhos quando o campo não possui minas ao redor.
- Exibição da quantidade de minas próxima de cada campo aberto.
- Revelação do tabuleiro ao encontrar uma mina.
- Reinício do tabuleiro para iniciar outra partida.
- Encerramento do jogo por meio do comando `sair`.

## Tecnologias

- **Java 11**
- **Programação Orientada a Objetos**
- **JUnit 5** para os testes automatizados
- **Eclipse** como ambiente de desenvolvimento configurado no projeto

A aplicação não utiliza bibliotecas externas em tempo de execução. O projeto também não possui arquivos Maven (`pom.xml`) ou Gradle (`build.gradle`).

## Arquitetura

- `application/Program.java`: ponto de entrada da aplicação e configuração inicial do tabuleiro.
- `modelo/Campo.java`: representa um campo e controla seu estado, marcação, abertura e relacionamento com os vizinhos.
- `modelo/Tabuleiro.java`: cria os campos, estabelece as relações de vizinhança, prepara as minas e verifica a vitória.
- `visao/TabuleiroConsole.java`: exibe o jogo e interpreta os comandos digitados pelo jogador.
- `excecao/`: exceções específicas para a explosão e para o encerramento do jogo.

## Estrutura de pastas

```text
campo-minado/
├── src/
│   └── student/project/campominado/
│       ├── application/
│       ├── excecao/
│       ├── modelo/
│       └── visao/
├── test/
│   └── student/project/campominado/modelo/
├── .classpath
├── .project
└── README.md
```

## Como executar

### Pré-requisitos

- JDK 11 instalado;
- acesso ao terminal ou ao Eclipse.

### Pelo Eclipse

1. Importe a pasta do projeto como **Existing Projects into Workspace**.
2. Localize `src/student/project/campominado/application/Program.java`.
3. Clique com o botão direito no arquivo e selecione **Run As > Java Application**.

### Pelo PowerShell

Execute os comandos abaixo a partir da raiz do projeto:

```powershell
New-Item -ItemType Directory -Force ".\bin" | Out-Null
$sources = Get-ChildItem -Path ".\src" -Recurse -Filter "*.java"
javac -encoding UTF-8 -d ".\bin" $sources.FullName
java -cp ".\bin" student.project.campominado.application.Program
```

## Como jogar

O jogo solicita as coordenadas no formato `linha,coluna`. As coordenadas começam em zero e usam a mesma ordem da configuração do tabuleiro.

Exemplo de entrada:

```text
Digite (x, y): 0, 0
1_abrir ou 2_(des)marcar: 1
```

- **`1`**: abre o campo selecionado.
- **`2`**: marca ou desmarca o campo selecionado.
- **`sair`**: encerra a aplicação.
- Depois da partida, **`n`** encerra o jogo; qualquer outra resposta inicia uma nova partida.

Na representação do tabuleiro:

- `?` representa um campo fechado;
- `x` representa um campo marcado;
- `*` representa uma mina;
- um número indica a quantidade de minas nos oito vizinhos;
- um espaço representa um campo aberto sem minas próximas.

## Testes

O arquivo `test/student/project/campominado/modelo/CampoTest.java` contém testes JUnit 5 para relações de vizinhança, marcação, abertura de campos e propagação da abertura para os vizinhos.

Para executá-los no Eclipse, clique com o botão direito em `CampoTest.java` e selecione **Run As > JUnit Test**.

## Limitações atuais

- A interface disponível é exclusivamente por console.
- As dimensões e a quantidade de minas são definidas diretamente em `Program.java`.
- O projeto não possui dependências declaradas para execução dos testes pela linha de comando.
- A entrada numérica e as coordenadas informadas pelo jogador ainda não são validadas.
- A rotina de distribuição das minas deve ser revisada para garantir a quantidade configurada.
- Os testes automatizados atualmente concentram-se na classe `Campo`.

