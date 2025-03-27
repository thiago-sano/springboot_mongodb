# Projeto MongoDB com Spring Boot

# Objetivos:
- Implementar operações de CRUD
- Implementar associações entre objetos
- Realizar consultas com Spring Data e MongoRepository

# Design System:
![img.png](images/img.png)

# Discussão a respeito do modelo de domínio
![img_1.png](images/img_1.png)

O relacionamento, em um banco de dados relacional, ocorreria através de chaves estrangeiras:
![img_2.png](images/img_2.png)

Porém, em um banco de dados orientado a agregados, como o MongoDB, uma solução de relacionamento ficaria da seguinte forma:
![img_3.png](images/img_3.png)
Uma coleçao de usuários tem entidades aninhadas (posts, comentários e autores de comentários) dentro da coleção de usuários.
Esse design é viável apenas quando os usuários tiverem um numero razoavelmente pequeno de posts.

Nota: no diagrama, é apresentado como relação de agregação entre todas as entidades.
Porém, considerando uma relação de agregação em que o todo e a parte possam ser separados, esse conceito aplica-se somente em posts, que podem NÃO TER comentários.
De resto, não existe um post sem user ou um comentário sem user.

Uma outra solução de design seria:
![img_4.png](images/img_4.png)
Cada usuário é uma coleção a parte e possui uma lista de posts.
Os posts é uma outra coleção do banco de dados, que terão entidades aninhadas (autor, comentários e autor dos comentários).

Nota: mais uma vez, a notação de agregação aplica-se somente em posts, que podem NÃO TER comentários.

Conclusão:
Conforme necessidade, se os objetos relacionados possui uma grande importancia, lista;
Porém, se os objetos forem simples ou se a necessidade de acessar todo mundo junto for frequente, aninhado;