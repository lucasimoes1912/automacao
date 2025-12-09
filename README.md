# AUTOMAÇÃO AHGORA - FILTRO E ANÁLISE DE SOLICITAÇÕES

Criei esse projeto com o intuito de resolver um problema bem comum: Um volume gigantesco de solicitações pendentes na plataforma da folha de ponto, o que acabou ocasionando um problema para minha supervisora, fora a questão de que acaba atrasando o fechamento da folha de  ponto e ocupa muito tempo de trabalho para resolver solicitações uma por uma.

A ideia é automatizar esse processo de análise e decisão do que fazer com todas as solicitações: O sistema busca os funcionários cadastrados de acordo com o perfil do usuário no Ahgora, podendo usar filtros como a chefia imediata, e analisa as solicitações de ajuste que os mesmos fizeram. O programa verificar se os horários solicitados batem com a jornada de trabalho de 8 horas do funcionário, levando em consideração a tolerância de 11 minutos a mais ou menos na jornada diária que a própria plataforma possui.
Se estiver dentro disso -> Aprova.
Se estiver fora -> Recusa.
E solicitações que necessitam de uma análise mais precisa, como abonos, atestados, etc. Ele deixa pendente.

Por enquanto a integração real com a API da plataforma Ahgora ainda não está no programa, o que está sendo usado é um mock que usei durante o desenvolvimento para testar o programa sem precisar das informações da API real.

## O QUE JÁ FUNCIONA:
- Processamento de funcionários;
- Filtro por chefia imediata (opcional);
- Análise de solicitações com:
    1- Cálculo automático da jornada de trabalho do funcionário;
    2- Tolerância de 11 minutos para mais ou menos;
- Aprovação, recusa, pendência conforme o tipo de solicitação;
- Código organizado em estrutura MVC.