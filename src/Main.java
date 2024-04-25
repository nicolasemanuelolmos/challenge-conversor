import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ConsultaMoneda consulta = new ConsultaMoneda();
        boolean opcion = true;

        while(opcion) {
            String menu = """
                *******************************************************
                Bienvenido al conversor de monedas!
                
                1) Dólar =>> Peso Argentino
                2) Peso Argentino =>> Dólar
                3) Dólar =>> Real brasilero
                4) Real Brasilero =>> Dólar
                5) Dólar =>> Pes Colombiano
                6) Peso Colombiano =>> Dólar
                7) Salir
                Elija una opción valida:
                *******************************************************
                """;
            System.out.println(menu);
            Scanner scan = new Scanner(System.in);
            int teclado = scan.nextInt();

            if(teclado < 7 && teclado >= 1) {
                System.out.println("Ingrese el monto a convertir:");
                int monto = scan.nextInt();

                switch (teclado) {
                    case 1:
                        Moneda moneda = consulta.CalculaMoneda("USD", "ARS", monto);
                        System.out.println("El valor de " + monto + " USD corresponde a " + moneda.conversion_result() + " Pesos Argentinos");
                        break;
                    case 2:
                        Moneda moneda2 = consulta.CalculaMoneda("ARS", "USD", monto);
                        System.out.println("El valor de " + monto + " Pesos Argentinos corresponde a " + moneda2.conversion_result() + " USD");
                        break;
                    case 3:
                        Moneda moneda3 = consulta.CalculaMoneda("USD", "BRL", monto);
                        System.out.println("El valor de " + monto + " USD corresponde a " + moneda3.conversion_result() + " Reales Brasileros");
                        break;
                    case 4:
                        Moneda moneda4 = consulta.CalculaMoneda("BRL", "USD", monto);
                        System.out.println("El valor de " + monto + " Reales Brasileros corresponde a " + moneda4.conversion_result() + " USD");
                        break;
                    case 5:
                        Moneda moneda5 = consulta.CalculaMoneda("USD", "COP", monto);
                        System.out.println("El valor de " + monto + " USD corresponde a " + moneda5.conversion_result() + " Pesos Colombianos");
                        break;
                    case 6:
                        Moneda moneda6 = consulta.CalculaMoneda("COP", "USD", monto);
                        System.out.println("El valor de " + monto + " Pesos Colombianos corresponde a " + moneda6.conversion_result() + " USD");
                        break;
                }
            }else if (teclado == 7){
                opcion = false;
            }else {
                System.out.println("Ingrese una opción válida");
            }
        }
    }
}