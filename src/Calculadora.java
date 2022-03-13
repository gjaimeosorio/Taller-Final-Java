//se importan las librerias
import java.io.IOException;
import java.util.Scanner;

import com.TallerFinalJava.Resultado;
import com.TallerFinalJava.Suma;
import com.TallerFinalJava.Resta;
import com.TallerFinalJava.Dividir;
import com.TallerFinalJava.Modulo;
import com.TallerFinalJava.Multiplicar;

//Clase principal
public class Calculadora {

    private static boolean bandera = true, firstTime = true;
    private static int opcion;
    private static Scanner input;
    private static float result = 0;
    private static Suma suma = new Suma();
    private static Resta resta = new Resta();
    private static Multiplicar multiplicar = new Multiplicar();
    private static Dividir dividir = new Dividir();
    private static Modulo modulo = new Modulo();
    private static Resultado resultado = new Resultado();
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    
    //Ejecucion del programa principal
    public static void main(String[] args) throws Exception {
        System.out.println(ANSI_GREEN + "Bienvenido a los talleres de Java de Gabriel Jaime Osorio Hernández." + ANSI_RESET);
        do {
            try {
                menu();
                opcion = capturarOpcion();
                limpiarPantalla();
                bandera = evaluarOpcion(opcion, args);
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "El número ingresado no corresponde a una opción válida. Intente de nuevo!" + ANSI_RESET);
            }
        } while (bandera == true);
    }

    //Menu principal
    private static void menu() {
        System.out.println("Escoja la operación que desea ejecutar:");
        System.out.println("1. Sumar (+)");
        System.out.println("2. Restar (-)");
        System.out.println("3. Multiplicar (*)");
        System.out.println("4. Dividir (/)");
        System.out.println("5. Módulo de la división (%)");
        System.out.println("6. Borrar (AC)");
        System.out.println("0. Salir del programa");
    }

    private static int capturarOpcion() {
        input = new Scanner(System.in);
        return Integer.parseInt(input.nextLine());
    }

    //Ingreso de un valor en punto flotante
    private static float capturarFloat() {
        input = new Scanner(System.in);
        return Float.parseFloat(input.nextLine());
    }

    private static void solicitarFloatA() {
        System.out.println("Por favor ingrese el primer número:");
    }

    private static void solicitarFloatB() {
        System.out.println("Por favor ingrese el segundo número:");
    }

    //Ingreso por primera vez a la calculadora o borrar (AC)
    private static void firstTime() {
        if(firstTime) {
            solicitarFloatA();
            result = capturarFloat();
            firstTime = false;
        }
    }

    //Ejecucion del codigo segun operacion
    private static boolean evaluarOpcion(int opcion, String[] args) throws IOException {
        switch (opcion) {
            case 1:
                firstTime();
                suma.setParcialResult(result);
                solicitarFloatB();
                result = capturarFloat();
                suma.setNewValue(result);
                result = resultado.calculaResultado(suma);
                System.out.println(ANSI_GREEN + "Resultado parcial: " + result + ANSI_RESET);
                return true;
            case 2:
                firstTime();
                resta.setParcialResult(result);
                solicitarFloatB();
                result = capturarFloat();
                resta.setNewValue(result);
                result = resultado.calculaResultado(resta);
                System.out.println(ANSI_GREEN + "Resultado parcial: " + result + ANSI_RESET);
                return true;
            case 3:
                firstTime();
                multiplicar.setParcialResult(result);
                solicitarFloatB();
                result = capturarFloat();
                multiplicar.setNewValue(result);
                result = resultado.calculaResultado(multiplicar);
                System.out.println(ANSI_GREEN + "Resultado parcial: " + result + ANSI_RESET);
                return true;
            case 4:
                firstTime();
                dividir.setParcialResult(result);
                solicitarFloatB();
                result = capturarFloat();
                while(result == 0.0) { //Verifica divisio por 0.0
                    System.out.println(ANSI_RED + "Error! No es posible dividir por 0!" + ANSI_RESET);
                    solicitarFloatB();
                    result = capturarFloat();
                    System.out.println(result);
                }
                dividir.setNewValue(result);
                result = resultado.calculaResultado(dividir);
                System.out.println(ANSI_GREEN + "Resultado parcial: " + result + ANSI_RESET);
                return true;
            case 5:
                firstTime();
                modulo.setParcialResult(result);
                solicitarFloatB();
                result = capturarFloat();
                while(result == 0.0) { //Verifica divisio por 0.0
                    System.out.println(ANSI_RED + "Error! No es posible dividir por 0!" + ANSI_RESET);
                    solicitarFloatB();
                    result = capturarFloat();
                    System.out.println(result);
                }
                modulo.setNewValue(result);
                result = resultado.calculaResultado(modulo);
                System.out.println(ANSI_GREEN + "Resultado parcial: " + result + ANSI_RESET);
                return true;
            case 6:
                firstTime = true;
                System.out.println(ANSI_GREEN + "Resultado parcial: 0" + ANSI_RESET);
                return true;
            case 0:
                return false;
            default:
                System.out.println(ANSI_RED + "Opción incorrecta, favor escoja el taller que desea ver!" + ANSI_RESET);
        }
        return true;
    }

    //Borrar pantalla
    private static void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
