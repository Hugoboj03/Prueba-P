import java.util.ArrayList;
import java.util.Scanner;

public class Pokemon {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        String tipos[] = new String[] {"Fuego", "Planta", "Agua", "Tierra", "Roca", "Electrico", "Acero", "Siniestro", "Fantasma", "Normal", "Psiquico", "Hada", "Veneno", "Volador", "Dragon", "Lucha", "Bicho", "Hielo"};
        String letras = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789!¡?¿_-.";
        ArrayList<Integer> stats = new ArrayList<>();
        int sumaLetra = 0;
        int sumaLetra2 = 0;
        long mul = 1;
        int hp = 0;
        int atk = 0;
        int def = 0;
        int spa = 0;
        int spd = 0;
        int spe = 0;
        int statsTotal = 780;
        int division = 251;

        for(int i = 5; i < 256; i++){
            stats.add(i);

        }

        System.out.println("Dime tu nombre o nick");
        String nombre = leer.nextLine();

        for(int i = 0; i < nombre.length(); i++){
            char caracter = nombre.charAt(i);
            for(int j = 0; j < letras.length(); j++){
                if(letras.charAt(j)==caracter){
                    sumaLetra = sumaLetra + j;
                    if(caracter=='a'){
                        mul = mul * 61;
                    }else{
                        mul = mul * j;
                    }
                }
            }
        }

        if(sumaLetra%2 == 0){
            String nombre2 = nombre.substring(nombre.length()/2, nombre.length());
            for(int i = 0; i < nombre2.length(); i++){
                char caracter = nombre2.charAt(i);
                for(int j = 0; j < letras.length(); j++){
                    if(letras.charAt(j)==caracter){
                        sumaLetra2 = sumaLetra2 + j;
                    }
                }
            }
        }

        int tipoResultado = sumaLetra%18;
        int tipoResultado2 = sumaLetra2%18;

        if(tipos[tipoResultado].equals(tipos[tipoResultado2])){
            System.out.println("Tipo: ["+tipos[tipoResultado]+"]");
        }else {
            System.out.println("Tipos: ["+tipos[tipoResultado]+"] "+"["+tipos[tipoResultado2]+"]");
        }

        for(int i = 0; i < 6; i++){
            int statMeter = (int) ((mul%division)+5);
            mul = mul - sumaLetra;
            statsTotal = statsTotal - statMeter;

            if(i == 0){
                hp = statMeter;
            } else if (i == 1) {
                atk = statMeter;
            } else if (i == 2) {
                def = statMeter;
            } else if (i == 3) {
                spa = statMeter;
            } else if (i == 4) {
                spd = statMeter;
            }else {
                spe = statMeter;
            }

            if(statsTotal<=270){
                division = 62;
            }
        }

        System.out.println("HP: "+hp);
        System.out.println("Atk: "+atk);
        System.out.println("Def: "+def);
        System.out.println("Spa: "+spa);
        System.out.println("Spd: "+spd);
        System.out.println("Spe: "+spe);

    }


}
