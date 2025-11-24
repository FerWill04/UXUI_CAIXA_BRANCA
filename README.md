# UXUI_CAIXA_BRANCA

# Notação de Grafo de Fluxo
O grafo de fluxo mostra como o código segue seus passos.
No método verificarUsuario(), os principais pontos são:

-Início

-Conectar ao banco

-Criar o comando SQL

-Executar a consulta

-Decisão: usuário existe ou não

-Retornar verdadeiro ou falso

# Complexidade Ciclomática
O método tem:

-1 decisão do try/catch

-1 decisão do if(rs.next())

Total:
Complexidade = 2 + 1 = 3

# Caminhos Básicos
Os caminhos possíveis dentro do método são:

-Usuário encontrado → retorna true

-Usuário NÃO encontrado → retorna false

-Erro na conexão ou consulta → retorna false
