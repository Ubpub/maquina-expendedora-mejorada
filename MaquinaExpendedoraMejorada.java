public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    //El número del billete
    private int numeroDeBilletesVendidos;
    //Elegir entre máquina con o sin premio
    private boolean maquinaExpendedoraConPremio;
    //Elegir el número másximo de billetes
    private int numeroMaximoDeBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean conPremio, int maximoBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        numeroDeBilletesVendidos = 0;
        maquinaExpendedoraConPremio = conPremio;
        numeroMaximoDeBilletes = maximoBilletes;
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (numeroDeBilletesVendidos < numeroMaximoDeBilletes) {
            if (cantidadIntroducida > 0) {
                balanceClienteActual = balanceClienteActual + cantidadIntroducida;
            }
            else {
                System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
            }  
        }
        else {
            System.out.println("No se puede introducir más dinero porque el máximo de billetes se ha alcanzado");
        }
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta;
        cantidadDeDineroQueFalta = precioBillete - balanceClienteActual;
        if (numeroDeBilletesVendidos < numeroMaximoDeBilletes) {
            if (cantidadDeDineroQueFalta <= 0) {        
                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         
    
                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                //Añade uno al número de billetes vendidos
                numeroDeBilletesVendidos += 1;
            
                if (maquinaExpendedoraConPremio == true) {
                    if (numeroDeBilletesVendidos%3 == 0) {
                        System.out.println("Tienes un descuendo de " + precioBillete*10/100F + " euros");
                        System.out.println();
                    }
                    else {
                        System.out.println();
                    }
                }
                else {
                    System.out.println();
                }
            }
            else {
                System.out.println("Necesitas introducir " + (cantidadDeDineroQueFalta) + " euros mas!");
                System.out.println();
            }
        }
        else {
            System.out.println("Se ha alcanzado el número máximo de billetes vendidos!");
        }
    }
    
    public int getNumeroBilletesVendidos() {
        return numeroDeBilletesVendidos;
    }
    
    public void imprimeNumeroBilletesVendidos () {
        System.out.println("Se han vendido" + numeroDeBilletesVendidos + " billete(s)");
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 
    
    public int vaciarDineroDeLaMaquina() {
        int totalDineroExtraido = -1;
        if (balanceClienteActual !=0) {
            System.out.println("Hay una operación en curso");
        }
        else {
            totalDineroExtraido = totalDineroAcumulado;
            totalDineroAcumulado = 0;
        }
        return totalDineroExtraido;
    }
}
