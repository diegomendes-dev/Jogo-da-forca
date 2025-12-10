import java.util.Random;

public class App {
    public static void main(String[] listaPalavras) throws Exception {
        if(listaPalavras.length  == 0){
            System.out.println("Nenhum valor informado");
            System.out.println("Use esse comando: java App.java palavra1 palavra2 palavra3");
            return;
        }
        ConsoleUi forca = new ConsoleUi();
        Random pala = new Random();
        int indice = pala.nextInt(listaPalavras.length);
        String palavra = listaPalavras[indice].toUpperCase();
        Forca jogo = new Forca(palavra);
        while (!jogo.terminar()) {
            forca.forca(jogo.getTentativas());
            forca.mensagem("palavra: " + jogo.getPalavraAdv());
            char letra = forca.lerLetra();
            boolean acertou = jogo.advLetra(letra);
            if(acertou){
                forca.mensagem("Voce acertou a letra");
            }else{
                forca.mensagem("Voce errou a letra");
            }
        }
        forca.forca(jogo.getTentativas());
        if(jogo.getTentativas() == 0){
            System.out.println("Voce perdeu a palavra era" + palavra);
        }else{
            System.out.println("Parabens voce ganhou, palavra e: " + palavra  );
        }

    }
}
