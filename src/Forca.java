import java.util.List;
import java.util.ArrayList;


public class Forca {
    private String palavra;
    private int tentativas;
    private List<Character> letrasUsadas;

    public Forca(String palavra) {
        this.palavra = palavra;
        this.tentativas = 6;
        this.letrasUsadas = new ArrayList<Character>();
    }

    public String getPalavraAdv(){
        String res = "";
        for(int i = 0; i < this.palavra.length(); i++){
            if(this.letrasUsadas.contains(this.palavra.charAt(i))){
                res += this.palavra.charAt(i);
            }else{
                res += "_";
            }
        }
        return  res;
    }

    public boolean advLetra(char letra){
        boolean res = false;
        if(this.letrasUsadas.contains(letra)){
            res = false;
        }else{
            this.letrasUsadas.add(letra);
            for(int i = 0; i < this.palavra.length(); i++){
            if(this.palavra.charAt(i) == letra){
                res =  true;
            }
           
        }
         if(res == false){
                this.tentativas--;
            }
    }
    return res;
}

    public int getTentativas(){
        return this.tentativas;
    }
    
    public boolean terminar(){
        boolean res = false;
        if(this.tentativas == 0  || !this.getPalavraAdv().contains("_")){
            res = true;
        }
        return res;
    }

}
