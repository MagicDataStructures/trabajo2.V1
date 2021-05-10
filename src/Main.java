import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static LinkedList<String> contenedores = new LinkedList<String>();
    public static LinkedList<String> Pilaregistro = new LinkedList<String>();
    public static LinkedList<Integer> ConPilas = new LinkedList<Integer>();
    public static LinkedList<Integer> PilaVacia = new LinkedList<Integer>();
    public static LinkedList<Integer> PilaCupo = new LinkedList<Integer>();
    public static List<List<String>> Con = new ArrayList<List<String>>();

    public static LinkedList<String> vehiculos = new LinkedList<String>();
    public static LinkedList<String> Colaregistro = new LinkedList<String>();
    public static LinkedList<Integer> VehColas = new LinkedList<Integer>();
    public static LinkedList<Integer> ColaVacia = new LinkedList<Integer>();
    public static LinkedList<Integer> ColaCupo = new LinkedList<Integer>();
    public static List<List<String>> Veh = new ArrayList<List<String>>();

    //public static Stack<Integer> pilaCon = new Stack<>();
    //public static Queue<Integer> colaVeh
    public static void main(String[] args) {

        // MANEJO DE UN PUERTO
        // se crearan las clases de los respectivos contenedores y vehiculos

        // inicializaremos los pilas de 5 contenedores (988) y colas de 15 automoviles (369)

        // Agregando los contenedores al puerto (988 en total)
        for (int k = 0; k < 200; k++) {
            Con.add(new ArrayList<String>());
        }
        for (int i = 0; i < 198; i++) {
            for (int j = 0; j < 5; j++) {
                Con.get(i).add("" + i + j);
                Pilaregistro.add("" + i + j);
                ConPilas.add(i + 1);
            }
        }
        Con.get(197).remove(4);
        Con.get(197).remove(3);
        Pilaregistro.remove(989);
        Pilaregistro.remove(988);
        for (int i = 0; i < 12; i++) {
            Pilaregistro.add("");
        }
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                ConPilas.add(199);
            } else {
                ConPilas.add(200);
            }
        }
        PilaVacia.add(200);
        PilaVacia.add(199);
        PilaCupo.add(198);

        /*for (int fds = 0; fds < Con.size(); fds++) {
            System.out.print(" "+ Con.get(fds));
        }
        System.out.println();*/

        // Agregando los vehiculos al puerto (369 en total)
        for (int h = 0; h < 25; h++) {
            Veh.add(new ArrayList<String>());
        }
        for (int i = 0; i < 25; i++) {
            for (int j = 0; j < 15; j++) {
                Veh.get(i).add("0" + i + j);
                Colaregistro.add("" + i + j);
                VehColas.add(i + 1);
            }
        }
        /*Veh.get(197).remove(4);
        Veh.get(197).remove(3);
        Colaregistro.remove(989);
        Colaregistro.remove(988);
        for(int i = 0 ; i < 12 ; i++){
            Colaregistro.add("");
        }
        for(int i = 0; i< 10 ; i++){
            if(i < 5){
                VehColas.add(199);
            }
            else{
                VehColas.add(200);
            }
        }
        ColaVacia.add(200);
        ColaVacia.add(199);
        ColaCupo.add(198);*/

        for (int fds = 0; fds < Veh.size(); fds++) {
            System.out.print(" " + Veh.get(fds));
        }
        System.out.println();

        for (int i = 0; i < Colaregistro.size(); i++) {
            System.out.print(" " + Colaregistro.get(i));
        }
        System.out.println();

        /*for (int i = 0; i < VehColas.size(); i++) {
            System.out.print(" "+ VehColas.get(i));
        }
        System.out.println();*/

        for (int i = 0; i < ColaVacia.size(); i++) {
            System.out.print(" " + ColaVacia.get(i));
        }
        System.out.println();

        String option;

        while (true) {
            System.out.println("Bienvenido al sistema Cargo Imaginary Company");
            System.out.println("Escoja la opción que más se adecue a sus necesidades ");
            System.out.println("Elija el operario de acuerdo a lo que dessea: ");
            System.out.println("INGRESE ÚNICAMENTE NÚMEROS ENTEROS");
            System.out.println("1. Operario contenedores ");
            System.out.println("2. Operario vehiculos ");
            System.out.println("3. Salir ");
            option = input.next();
            if (option.equals("1")) {
                SistemaContenedores();
            } else if (option.equals("2")) {
                SistemaVehiculos();
            } else if (option.equals("3")) {
                break;
            }
        }

    }

    private static void SistemaContenedores() {
        System.out.println("Bienvenido al sistema de contenedores");
        System.out.println("Escoja una de las siguientes opciones:");
        System.out.println("Ingrese unicamente numeros enteros ");
        System.out.println("1. Entregar un contendeodr");
        System.out.println("2. Recibir un contendeodr");
        System.out.println("3. Mover un contendeodr");
        String opcion = input.next();
        if (opcion.equals("1")) {
            EntregarContenedor();
        } else if (opcion.equals("2")) {
            RecibirContenedor();
        } else if (opcion.equals("3")) {
            MoverContenedor();
        } else {
            return;
        }

    }

    private static void EntregarContenedor() {
        System.out.println("Dijite el código del contenedor que desea entregar");
        String Pila_code = input.next();
        int z = Pilaregistro.indexOf(Pila_code);
        while(z == -1){
            System.out.println("Este codigo no está registrado, ingrese un codigo registrado");
            Pila_code = input.next();
            z = Pilaregistro.indexOf(Pila_code);
        }
        int PilaPasada = ConPilas.get(z);
        int pila_i_time = Con.get(PilaPasada - 1).indexOf(Pila_code);
        int pila_i_tama = Con.get(PilaPasada - 1).size();
        System.out.println("El el contenedor con el codigo "+ Pila_code + " está en la pila  "+ PilaPasada);
        Con.get(PilaPasada -1).remove(Pila_code);
        Pilaregistro.remove(Pila_code);
        Pilaregistro.add(z,"");
        System.out.println("Pila anterior "+ Con.get(PilaPasada-1));

        /* Entrega parte 2*/
        if(Con.get(PilaPasada-1).isEmpty()){
            PilaVacia.add(PilaPasada);
        }
        else if(Con.get(PilaPasada-1).size() == 4){
            PilaCupo.add(PilaPasada);
        }
        System.out.println("El contenedor con el codigo  "+ Pila_code + "  fue entregado con éxito, los demás contenedores que se tuvieron que mover fueron indexados otra vez a la pila");
        int tiempo_entregar_pila = 180 + (pila_i_tama -1 - pila_i_time)*(60);
        System.out.println("El tiempo que se demoro en entregar el contenedor "+Pila_code+" Es de :" + tiempo_entregar_pila+" Segundos ");


    }

    private static void RecibirContenedor() {

        int totalC = 0;
        int Total = 1000;
        for(int i =0 ; i < 1000 ; i++){
            String condata = Pilaregistro.get(i);
            if(condata.equals("")){
                totalC = totalC + 1;
            }
        }
        Total = Total - totalC;
        System.out.println("Total de contenedores " + Total);
        if(Total == 990){
            System.out.println("¡ CUIDADO ! , YA ESTÁ EN EL LÍMITE DE CONTENEDORES DISPONIBLES 990");
        }
        else{
            System.out.println("Dijite el código del contenedor que desea agregar");
            String Pila_code = input.next();
            int z = Pilaregistro.indexOf(Pila_code);
            while(z != -1){
                System.out.println("Este codigo YA está registrado, ingrese un codigo  NUEVO");
                Pila_code = input.next();
                z = Pilaregistro.indexOf(Pila_code);
            }
            System.out.println("En que pila lo desea agregar ?, Pilas vacías:  "+PilaVacia+"  Pilas con Cupo: "+PilaCupo);
            int PilaFutura = input.nextInt();
            while(PilaFutura >200 || PilaFutura < 1){
                System.out.println("Esta pila no existe, dijite una en el intervalo de 1 a 200");
                PilaFutura = input.nextInt();
            }
            int TamPilaFutura = Con.get(PilaFutura-1).size();
            while(TamPilaFutura == 5){
                System.out.println("Esta pila esta completa, debe usar otra. Las pilass vacías son: "+PilaVacia+" Las pilas con cupo son: "+PilaCupo);
                PilaFutura = input.nextInt();
                TamPilaFutura = Con.get(PilaFutura-1).size();
            }
            Con.get(PilaFutura-1).add(Pila_code);
            int pila_i_time = Con.get(PilaFutura - 1).indexOf(Pila_code);
            int pila_llegada = ConPilas.indexOf(PilaFutura) + pila_i_time ;
            Pilaregistro.remove(pila_llegada);
            Pilaregistro.add(pila_llegada,Pila_code);
            System.out.println("Pila Actual  "+ Con.get(PilaFutura -1));

            /* Agrega parte 2*/
            if(Con.get(PilaFutura-1).size() == 5){
                PilaCupo.remove(PilaCupo.indexOf(PilaFutura));
            }
            else if(Con.get(PilaFutura-1).size() == 1){
                PilaVacia.remove(PilaVacia.indexOf(PilaFutura));
                PilaCupo.add(PilaFutura);
            }
            System.out.println("El apilamiento del contenedor con el código "+ Pila_code + " A la pila "+PilaFutura+ " Fue un éxito y demoró 180 Segundos");

            /* Parte final */
            System.out.println("Desea saber el número de contenedores en el puerto hasta el momento ?, Contestar Si o No");
            int totalC2 = 0;
            int Total2 = 1000;
            for(int i =0 ; i < 1000 ; i++){

                String condata = Pilaregistro.get(i);
                if(condata.equals("")){
                    totalC2 = totalC2 + 1;
                }
            }
            Total2 = Total2 - totalC2;
            String pregunta1 = input.next();
            if(pregunta1.equals("Si")   || pregunta1.equals("si") || pregunta1.equals("SI")){
                System.out.println("El número total de contenedores es: "+Total);
            }

            System.out.println("Desea acceder a la información de alguna pila de contenedores ?, en caso de que SI quiera, Conteste Si o No");
            String pregunta2 = input.next();
            if(pregunta2.equals("Si") || pregunta2.equals("SI") || pregunta2.equals("si")){
                System.out.println("Dijite el número de la pila que quiere consultar, el numero debe ser de uno a docientos (1,200)");
                int pre2 = input.nextInt();
                while(pre2 > 200 || pre2 < 1){
                    System.out.println("Solo se permiten numeros de 1 a 200");
                    pre2 = input.nextInt();
                }
                System.out.println("Los contenedores en la pila "+ pre2 +" son "+Con.get(pre2-1));
            }

    }

    }

    private static void MoverContenedor() {
        System.out.println("Digite el codigo del contenedor que desea mover:");
        String Pila_code = input.next();
        int z = Pilaregistro.indexOf(Pila_code);
        while (z == -1) {
            System.out.println("Este codigo no está registrado, ingrese un codigo registrado");
            Pila_code = input.next();
            z = Pilaregistro.indexOf(Pila_code);
        }
        int PilaPasada = ConPilas.get(z);
        int pila_i_time = Con.get(PilaPasada - 1).indexOf(Pila_code);
        int pila_i_tama = Con.get(PilaPasada - 1).size();
        System.out.println("El el contenedor con el codigo " + Pila_code + " está en la pila  " + PilaPasada);
        System.out.println("A que pila desea mover el contenedor ? ");
        int PilaFutura = input.nextInt();
        while (PilaFutura > 200 || PilaFutura < 1) {
            System.out.println("Esta pila no existe, dijite una en el intervalo de 1 a 200");
            PilaFutura = input.nextInt();
        }
        int TamPilaFutura = Con.get(PilaFutura - 1).size();
        while (TamPilaFutura == 5) {
            System.out.println("Esta pila esta completa, debe usar otra. Las pilass vacías son: " + PilaVacia + " Las pilas con cupo son: " + PilaCupo);
            PilaFutura = input.nextInt();
            TamPilaFutura = Con.get(PilaFutura - 1).size();
        }
        Con.get(PilaFutura - 1).add(Pila_code);
        Con.get(PilaPasada - 1).remove(Pila_code);
        Pilaregistro.remove(Pila_code);
        int pila_llegada = ConPilas.indexOf(PilaFutura) + pila_i_time;
        Pilaregistro.add(pila_llegada, Pila_code);
        System.out.println("Pila anterior " + Con.get(PilaPasada - 1));
        System.out.println("Pila Actual  " + Con.get(PilaFutura - 1));

        /* Mover parte 2*/
        if (Con.get(PilaPasada - 1).isEmpty()) {
            PilaVacia.add(PilaPasada);
        } else if (Con.get(PilaPasada - 1).size() < 5 && Con.get(PilaPasada - 1).size() > 0) {
            if (PilaCupo.indexOf(PilaPasada) == -1) {
                PilaCupo.add(PilaPasada);
            }
        }
        if (Con.get(PilaFutura - 1).size() == 5) {
            PilaCupo.remove(PilaCupo.indexOf(PilaFutura));
        } else if (Con.get(PilaFutura - 1).size() < 5 && Con.get(PilaFutura - 1).size() > 0) {
            if (PilaCupo.indexOf(PilaFutura) == -1) {
                PilaCupo.add(PilaFutura);
            }
            if (Con.get(PilaFutura - 1).size() == 1) {
                PilaVacia.remove(PilaVacia.indexOf(PilaFutura));
            }
        }
        if (PilaCupo.indexOf(PilaPasada) != -1 && PilaVacia.indexOf(PilaPasada) != -1) {
            PilaCupo.remove(PilaCupo.indexOf(PilaPasada));
        }
        /* Tiempo de movención */
        System.out.println("El contenedor fue movido con éxito, los demás contenedores que se tuvieron que mover fueron indexados otra vez a la pila");
        int tiempo_mover_pila = 60 + (pila_i_tama - 1 - pila_i_time) * (60);
        System.out.println("El tiempo que se demoro en mover el contenedor " + Pila_code + " a la pila  " + PilaFutura + " Es :" + tiempo_mover_pila + " Segundos ");

    }


    private static void SistemaVehiculos() {
        System.out.println("Bienvenido al sistema de vehiculos");
        System.out.println("Escoja una de las siguientes opciones:");
        System.out.println("Ingrese unicamente numeros enteros ");
        System.out.println("1. Entregar un vehiculo");
        System.out.println("2. Recibir un vehiculo");
        System.out.println("3. Mover un vehiculo");
        String opcion = input.next();
        if (opcion.equals("1")) {
            EntregarVehiculo();
        } else if (opcion.equals("2")) {
            RecibirVeniculo();
        } else if (opcion.equals("3")) {
            MoverVehiculo();
        } else {
            return;
        }
    }

    private static void EntregarVehiculo() {

        System.out.println("Dijite el código del vehiculo que desea entregar");
        String Cola_code = input.next();
        int z = Colaregistro.indexOf(Cola_code);
        while(z == -1){
            System.out.println("Este codigo no está registrado, ingrese un codigo registrado");
            Cola_code = input.next();
            z = Pilaregistro.indexOf(Cola_code);
        }
        int ColaPasada = VehColas.get(z);
        int cola_i_time = Con.get(ColaPasada - 1).indexOf(Cola_code);
        int cola_i_tama = Con.get(ColaPasada - 1).size();
        System.out.println("El el vehiculo con el codigo "+ Cola_code + " está en la cola  "+ ColaPasada);
        Veh.get(ColaPasada -1).remove(Cola_code);
        Colaregistro.remove(Cola_code);
        Colaregistro.add(z,"");
        System.out.println("Cola anterior "+ Veh.get(ColaPasada-1));


        if(Veh.get(ColaPasada-1).isEmpty()){
            ColaVacia.add(ColaPasada);
        }
        else if(Veh.get(ColaPasada-1).size() == 4){
            ColaCupo.add(ColaPasada);
        }
        System.out.println("El vehiculo con el codigo  "+ Cola_code + "  fue entregado con éxito, los demás contenedores que se tuvieron que mover fueron indexados otra vez a la pila");
        int tiempo_entregar_cola = 380 + (cola_i_tama -1 - cola_i_time)*(20);
        System.out.println("El tiempo que se demoro en entregar el vehiculo "+Cola_code+" Es de :" + tiempo_entregar_cola+" Segundos ");


    }

    private static void RecibirVeniculo() {

        int totalC = 0;
        int Total = 375;
        for(int i =0 ; i < 375 ; i++){
            String Vehdata = Colaregistro.get(i);
            if(Vehdata.equals("")){
                totalC = totalC + 1;
            }
        }
        Total = Total - totalC;
        System.out.println("Total de vehiculos " + Total);
        if(Total == 371){
            System.out.println("¡ CUIDADO ! , YA ESTÁ EN EL LÍMITE DE VEHICULOS DISPONIBLES 990");
        }
        else{
            System.out.println("Digite el código del vehiculo que desea recibir");
            String Cola_code = input.next();
            int z = Colaregistro.indexOf(Cola_code);
            while(z != -1){
                System.out.println("Este codigo YA está registrado, ingrese un codigo  NUEVO");
                Cola_code = input.next();
                z = Colaregistro.indexOf(Cola_code);
            }
            System.out.println("En que cola lo desea recibir ?, Colas vacías:  "+ColaVacia+"  Colas con Cupo: "+ColaCupo);
            int ColaFutura = input.nextInt();
            while(ColaFutura >25 || ColaFutura < 1){
                System.out.println("Esta cola no existe, dijite una en el intervalo de 1 a 25");
                ColaFutura = input.nextInt();
            }
            int TooColaFutura = Con.get(ColaFutura-1).size();
            while(TooColaFutura == 5){
                System.out.println("Esta cola esta completa, debe usar otra. Las colas vacías son: "+ColaVacia+" Las pilas con cupo son: "+ColaCupo);
                ColaFutura = input.nextInt();
                TooColaFutura = Con.get(ColaFutura-1).size();
            }



            if(Veh.get(ColaFutura-1).size() == 5){
                ColaCupo.remove(ColaCupo.indexOf(ColaFutura));
            }
            else if(Veh.get(ColaFutura-1).size() == 1){
                ColaVacia.remove(ColaVacia.indexOf(ColaFutura));
                ColaCupo.add(ColaFutura);
            }
            System.out.println("El apilamiento del vehiculo con el código "+ ColaFutura + " A la cola "+ColaFutura+ " Fue un éxito y demoró 180 Segundos");


            /* Parte final */
            System.out.println("Desea saber el número de vehiculos en el puerto hasta el momento ?, Contestar Si o No");
            int totalV2 = 0;
            int Total_2 = 1000;
            for(int i =0 ; i < 1000 ; i++){

                String condata = Pilaregistro.get(i);
                if(condata.equals("")){
                    totalV2 = totalV2 + 1;
                }
            }
            Total_2 = Total_2 - totalV2;
            String pregunta1 = input.next();
            if(pregunta1.equals("Si")   || pregunta1.equals("si") || pregunta1.equals("SI")){
                System.out.println("El número total de vehiculos es: "+Total_2);
            }

            System.out.println("Desea acceder a la información de alguna cola de vehiculos ?, en caso de que SI quiera, Conteste Si o No");
            String pregunta2 = input.next();
            if(pregunta2.equals("Si") || pregunta2.equals("SI") || pregunta2.equals("si")){
                System.out.println("Dijite el número de la cola que quiere consultar, el numero debe ser de uno a veinticinco (1,25)");
                int preV2 = input.nextInt();
                while(preV2 > 25 || preV2 < 1){
                    System.out.println("Solo se permiten numeros de 1 a 200");
                    preV2 = input.nextInt();
                }
                System.out.println("Los contenedores en la pila "+ preV2 +" son "+Veh.get(preV2-1));
            }


        }

    }

    private static void MoverVehiculo() {

        System.out.println("Digite el codigo del vehiculo que desea mover:");
        String Cola_code = input.next();
        int z = Colaregistro.indexOf(Cola_code);
        while (z == -1) {
            System.out.println("Este codigo no está registrado, ingrese un codigo registrado");
            Cola_code = input.next();
            z = Colaregistro.indexOf(Cola_code);
        }
        int ColaPasada = VehColas.get(z);
        int cola_i_time = Veh.get(ColaPasada - 1).indexOf(Cola_code);
        int cola_i_tama = Veh.get(ColaPasada - 1).size();
        System.out.println("El el vehiculo con el codigo " + Cola_code + " está en la cola  " + ColaPasada);
        System.out.println("A que cola desea mover el vehiculo ? ");
        int ColaFutura = input.nextInt();
        while (ColaFutura > 25 || ColaFutura < 1) {
            System.out.println("Esta cola no existe, dijite una en el intervalo de 1 a 25");
            ColaFutura = input.nextInt();
        }
        int TooColaFutura = Veh.get(ColaFutura - 1).size();
        while (TooColaFutura == 15) {
            System.out.println("Esta cola esta completa, debe usar otra. Las colas vacías son: " + ColaVacia + " Las colas con cupo son: " + ColaCupo);
            ColaFutura = input.nextInt();
            TooColaFutura = Veh.get(ColaFutura - 1).size();
        }
        Veh.get(ColaFutura - 1).add(Cola_code);
        Veh.get(ColaPasada - 1).remove(Cola_code);
        Colaregistro.remove(Cola_code);
        int cola_llegada = VehColas.indexOf(ColaFutura) + cola_i_time;
        Pilaregistro.add(cola_llegada, Cola_code);
        System.out.println("Cola anterior " + Veh.get(ColaPasada - 1));
        System.out.println("Cola Actual  " + Veh.get(ColaFutura - 1));


        if (Veh.get(ColaPasada - 1).isEmpty()) {
            ColaVacia.add(ColaPasada);
        } else if (Veh.get(ColaPasada - 1).size() < 15 && Veh.get(ColaPasada - 1).size() > 0) {
            if (ColaCupo.indexOf(ColaPasada) == -1) {
                ColaCupo.add(ColaPasada);
            }
        }
        if (Veh.get(ColaFutura - 1).size() == 15) {
            ColaCupo.remove(ColaCupo.indexOf(ColaFutura));
        } else if (Veh.get(ColaFutura - 1).size() < 15 && Veh.get(ColaFutura - 1).size() > 0) {
            if (ColaCupo.indexOf(ColaFutura) == -1) {
                ColaCupo.add(ColaFutura);
            }
            if (Veh.get(ColaFutura - 1).size() == 1) {
                ColaVacia.remove(ColaVacia.indexOf(ColaFutura));
            }
        }
        if (PilaCupo.indexOf(ColaPasada) != -1 && PilaVacia.indexOf(ColaPasada) != -1) {
            ColaCupo.remove(ColaCupo.indexOf(ColaPasada));
        }
        /* Tiempo que tardan */
        System.out.println("El vehiculo fue movido con éxito, los demás contenedores que se tuvieron que mover fueron indexados otra vez a la cola");
        int tiempo_mover_cola = 20 + (cola_i_tama - 1 - cola_i_time) * (20);
        System.out.println("El tiempo que se demoro en mover el contenedor " + Cola_code + " a la pila  " + ColaFutura + " Es :" + tiempo_mover_cola + " Segundos ");


    }
}

