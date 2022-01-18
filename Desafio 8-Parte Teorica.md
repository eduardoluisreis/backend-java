# A- O que são exceptions

O conceito de exceção foi o mecanismo criado para que o seu programa simplesmente não fosse finalizado ao encontrar problemas em sua execução.

No processo de desenvolvimento de programas de computador , há a possibilidade de ocorrer erros imprevistos durante sua execução, estes erros são conhecidos como exceções; objetos que sinalizam que ocorreu algum problema no tempo de execução de um programa e podem ser provenientes de erros de lógica ou acesso a dispositivos ou arquivos externos, por exemplo, erro ao acessar um índice de vetor que esteja além de seu tamanho ou ao dividir um numero por zero.
Para contornar isso, criamos as **Exceptions ou Exceções**, regras e códigos que serão lançados como tratamento para possíveis erros informados ao programa, evitando que o sistema quebre ou finalize.

Por exemplo, num aplicativo de calculadora, por algum motivo o usuário tenta executar a seguinte operação ***10/0( Dez dividido por zero)***. Sabidamente, divisões por zero são indeterminações matemáticas, logo a operação não será executada e o programa apresentaria um erro de execução. Para contornar isso, poderíamos programar para exibir uma mensagem do tipo: "**Não é possível fazer divisão por zero"** Quando fazemos isso, estamos **tratando a exceção** de divisão por zero. 

# B- Qual é o funcionamento do **try** , **catch** e **finally**

O conjunto de blocos ***try-catch-finally***, atua capturando as possíveis exceções no código, com o objetivo de impedir fluxos inesperados, ele mesmo determina o que deve ser feito na ocorrência da exceção.

No bloco ***try*** , colocamos o código que pode gerar a exceção.

O bloco catch vem logo após o ***try*** e dentro deste bloco, colocamos o tratamento da exceção que eventualmente ocorra no bloco ***try***. A exceção, pode não ocorrer necessariamente, mas caso ocorra, o código inserido tratará a mesma evitando comportamento indesejado mostrando uma mensagem definida pelo desenvolvedor ao usuário.

Bloco ***finally***, o código contido neste bloco será executado sempre após cada bloco try/catch independente da execução ter passado pelo ***catch***. Ao contrário dos blocos ***catch*** , só podemos ter um bloco ***finally*** por cada bloco ***try***.

*Como dito, o bloco ***finally*** será executado sempre após cada bloco **try/catch**, independente se o código foi executado com sucesso ou mesmo se ocorreu uma exceção, exceto se, antes dele e dentro do ***try*** ou ***catch*** houver algum código que interrompa a execução definitiva do programa.

Ex:. Tendo o código **System.exit(0);** antes do ***finally***, o programa parará imediatamente ali, não executando o ***finally***.



# C- Qual a relação entre try,catch, finally e throws



### try, catch e finally

Capturam e tratam as exceções.

### throws

A palavra reservada **throws** vai na assinatura do método e indica que este método poderá lançar uma exceção que deve ou ser relançada ou capturada pelo método que a está chamando.



# D- Para que serve a annotation @ExceptionHandler?

Anotação @ExceptionHandler: recebe a exceção a ser tratada e deve ser lançada em cada classe Controller do sistema.

Anotação @ControllerAdvice: é utilizada para tratar exceções de forma global, com esta anotação, basta colocar na classe que concentrara os tratamentos globais.



# E- Para que serve o comando throw?

Imagine uma situação em que não é desejado que uma exceção seja tratada na própria classe ou método, mas sim em outro que venha lhe chamar. Para solucionar tal situação utilizamos o **comando throws** na assinatura do método com a possível exceção que o mesmo poderá a vir lançar.



# F- Para que serve a annotation @ControllerAdvice?

Anotação @ControllerAdvice: é utilizada para tratar exceções de forma global, com esta anotação, basta colocar na classe que concentrara os tratamentos globais.