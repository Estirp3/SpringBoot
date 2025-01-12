package validadorPal;

public class ValidaroPal {

    public boolean setPalindromo(String escr){
        String limpio = escr.toLowerCase().replaceAll("s+","");
        String invertido = new StringBuilder(limpio).reverse().toString();
        return limpio.equals(invertido);
    }

    //otra solucion con los indices
    public boolean isPalindrome(String word){
        int largo = word.length();
        for (int i = 0; i < largo / 2; i++){
            if(word.charAt(i) != word.charAt(largo - i -1)){
                return false;
            }
        }
        return true;
    }
}
