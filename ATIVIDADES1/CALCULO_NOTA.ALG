algoritmo "Calculo_Nota"

var
   P1, E1, E2, X, SUB, API, EXF: real
   media: real

inicio

   escreva("Digite a nota da P1: ")
   leia(P1)

   escreva("Digite a nota da E1: ")
   leia(E1)

   escreva("Digite a nota da E2: ")
   leia(E2)

   escreva("Digite a nota da Atividade extra: ")
   leia(X)

   media <- P1 * 0.5 + E1 * 0.2 + E2 * 0.3 + X

   se media>5.9 entao
      escreva("Digite a nota da API: ")
      leia(API)
      se media<10 entao
         API <- API * 0,5
         media <- media+API
         se media>10 entao
            media<- 10
         fimse
      fimse
   fimse

   se media<6 entao
      escreva("Digite a nota da SUB: ")
      leia(SUB)
      sub<- sub * 0,15
      media <- media+sub
   fimse

   se media>3.9 entao
      se media<6 entao
         escreva("Digite a nota do Exame final: ")
         leia(EXF)
         se EXF>media entao
            media <- EXF
         fimse
      fimse
   fimse
   se media>10 entao
      media<- 10
   fimse
   escreval("=========================================")
   se media>5.9 entao
      escreval("Média final: ", media)
      escreval("Situação: Aprovado")
   senao
      escreval("Média final: ", media)
      escreval("Situação: Reprovado")

   fimse
fimalgoritmo
