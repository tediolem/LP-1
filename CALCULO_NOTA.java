public class Main {
    public static void main(String[] args) {
        double P1, E1, E2, X, SUB, API, EXF, media;
        media= 0;
        SUB=0;
        API=0;
        EXF=0;

        P1= 10;
        E1= 5;
        E2= 3;
        X= 1;

        media=(P1*0.5)+(E1*0.2)+(E2*0.3)+X;

        if (media<6) {
            SUB= 6;
            media=media+(SUB*0.15);
        }

        if (media>=6) {
            API = 6;
            media=media+(API*0.5);
        } 

        if (media<6){
            if (media>=4){
                EXF= 6;
                media=EXF;
            }
        }

        if (media>10) {
            media= 10;
        } 

        if (media>=6){
            System.out.println ("Aluno aprovado com media: "+ media);
        }
        else {
            System.out.println ("Aluno reprovado com media: "+ media);
        }

    }
}
