import java.util.Scanner;
import java.util.Random;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n========== PRACTICA JAVA: BREAK Y CONTINUE ==========");
            System.out.println("1. Ejercicios con BREAK (1 al 20)");
            System.out.println("2. Ejercicios con CONTINUE (1 al 20)");
            System.out.println("3. Ejercicios integradores (1 al 3)");
            System.out.println("0. Salir");
            System.out.print("Elija una opcion: ");
            opcion = leerInt();

            switch (opcion) {
                case 1 -> menuBreak();
                case 2 -> menuContinue();
                case 3 -> menuIntegradores();
                case 0 -> System.out.println("Programa finalizado.");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    static int leerInt() {
        while (!sc.hasNextInt()) {
            System.out.print("Ingrese un numero entero: ");
            sc.next();
        }
        return sc.nextInt();
    }

    static double leerDouble() {
        while (!sc.hasNextDouble()) {
            System.out.print("Ingrese un numero: ");
            sc.next();
        }
        return sc.nextDouble();
    }

    static void menuBreak() {
        int op;
        do {
            System.out.println("\n--- 20 EJERCICIOS CON BREAK ---");
            for (int i = 1; i <= 20; i++) System.out.println(i + ". Ejercicio " + i);
            System.out.println("0. Volver");
            System.out.print("Elija: ");
            op = leerInt();
            switch (op) {
                case 1 -> b1(); case 2 -> b2(); case 3 -> b3(); case 4 -> b4();
                case 5 -> b5(); case 6 -> b6(); case 7 -> b7(); case 8 -> b8();
                case 9 -> b9(); case 10 -> b10(); case 11 -> b11(); case 12 -> b12();
                case 13 -> b13(); case 14 -> b14(); case 15 -> b15(); case 16 -> b16();
                case 17 -> b17(); case 18 -> b18(); case 19 -> b19(); case 20 -> b20();
                case 0 -> { }
                default -> System.out.println("Opcion no valida.");
            }
        } while (op != 0);
    }

    static void menuContinue() {
        int op;
        do {
            System.out.println("\n--- 20 EJERCICIOS CON CONTINUE ---");
            for (int i = 1; i <= 20; i++) System.out.println(i + ". Ejercicio " + i);
            System.out.println("0. Volver");
            System.out.print("Elija: ");
            op = leerInt();
            switch (op) {
                case 1 -> c1(); case 2 -> c2(); case 3 -> c3(); case 4 -> c4();
                case 5 -> c5(); case 6 -> c6(); case 7 -> c7(); case 8 -> c8();
                case 9 -> c9(); case 10 -> c10(); case 11 -> c11(); case 12 -> c12();
                case 13 -> c13(); case 14 -> c14(); case 15 -> c15(); case 16 -> c16();
                case 17 -> c17(); case 18 -> c18(); case 19 -> c19(); case 20 -> c20();
                case 0 -> { }
                default -> System.out.println("Opcion no valida.");
            }
        } while (op != 0);
    }

    static void menuIntegradores() {
        int op;
        do {
            System.out.println("\n--- EJERCICIOS INTEGRADORES ---");
            System.out.println("1. Integrador BREAK");
            System.out.println("2. Integrador CONTINUE");
            System.out.println("3. Integrador BREAK + CONTINUE");
            System.out.println("0. Volver");
            System.out.print("Elija: ");
            op = leerInt();
            switch (op) {
                case 1 -> integrador1(); case 2 -> integrador2(); case 3 -> integrador3();
                case 0 -> { }
                default -> System.out.println("Opcion no valida.");
            }
        } while (op != 0);
    }

    // ==================== EJERCICIOS CON BREAK ====================

    // 1. Registrar notas hasta ingresar 20.
    static void b1() {
        int cantidad = 0; double suma = 0, nota, max = -1, min = 21;
        while (true) {
            System.out.print("Ingrese nota (20 para terminar): "); nota = leerDouble();
            if (nota == 20) break;
            if (nota < 0 || nota > 20) { System.out.println("Nota fuera de rango."); continue; }
            cantidad++; suma += nota; max = Math.max(max, nota); min = Math.min(min, nota);
        }
        System.out.println("Notas: " + cantidad);
        if (cantidad > 0) System.out.println("Promedio: " + suma/cantidad + "\nMaxima: " + max + "\nMinima: " + min);
        else System.out.println("No se registraron notas.");
    }

    // 2. Acceso con maximo 5 intentos.
    static void b2() {
        String claveCorrecta = "java123"; int intento; boolean acceso = false;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Contrasena: ");
            String clave = sc.next();
            if (clave.equals(claveCorrecta)) { intento = i; acceso = true; System.out.println("Acceso concedido en el intento " + intento); break; }
        }
        if (!acceso) System.out.println("Acceso denegado. Agoto los 5 intentos.");
    }

    // 3. Temperaturas hasta superar 95 grados.
    static void b3() {
        int lecturas = 0; double t;
        while (true) {
            System.out.print("Temperatura: "); t = leerDouble(); lecturas++;
            if (t > 95) { System.out.println("Temperatura critica: " + t + " C"); break; }
        }
        System.out.println("Lecturas realizadas: " + lecturas);
    }

    // 4. Determinar si un numero es primo.
    static void b4() {
        System.out.print("Ingrese un numero entero: "); int n = leerInt();
        if (n < 2) { System.out.println("No es primo. No tiene divisores primos."); return; }
        int divisor = 0;
        for (int i = 2; i <= n / 2; i++) if (n % i == 0) { divisor = i; break; }
        if (divisor == 0) System.out.println(n + " es primo.");
        else System.out.println(n + " no es primo. Primer divisor: " + divisor);
    }

    // 5. Cajero automatico.
    static void b5() {
        int op, operaciones = 0;
        do {
            System.out.println("1. Consultar saldo  2. Depositar  3. Retirar  4. Salir");
            System.out.print("Opcion: "); op = leerInt();
            if (op == 4) break;
            if (op >= 1 && op <= 3) { operaciones++; System.out.println("Operacion realizada (simulacion)."); }
            else System.out.println("Opcion incorrecta.");
        } while (true);
        System.out.println("Operaciones realizadas: " + operaciones);
        System.out.println("Sesion cerrada.");
    }

    // 6. Juego de adivinanza.
    static void b6() {
        int secreto = new Random().nextInt(100) + 1, n, intentos = 0;
        do {
            System.out.print("Adivine el numero (1-100): "); n = leerInt(); intentos++;
            if (n == secreto) { System.out.println("Felicitaciones, acertaste."); break; }
            System.out.println(n < secreto ? "El numero es mayor." : "El numero es menor.");
        } while (true);
        System.out.println("Intentos usados: " + intentos);
    }

    // 7. Produccion hasta ingresar cero.
    static void b7() {
        int produccion, total = 0, horas = 0;
        while (true) {
            System.out.print("Produccion de la hora (0 para terminar): "); produccion = leerInt();
            if (produccion == 0) break;
            total += produccion; horas++;
        }
        System.out.println("Total producido: " + total + "\nHoras registradas: " + horas);
    }

    // 8. Buscar codigo ABC123.
    static void b8() {
        String codigo; int revisados = 0;
        while (true) {
            System.out.print("Ingrese codigo (FIN para terminar): "); codigo = sc.next();
            if (codigo.equalsIgnoreCase("FIN")) break;
            revisados++;
            if (codigo.equals("ABC123")) { System.out.println("Codigo encontrado en posicion: " + revisados); break; }
        }
        System.out.println("Codigos revisados: " + revisados);
    }

    // 9. Encuesta de opinion.
    static void b9() {
        int r, cantidad = 0, suma = 0;
        while (true) {
            System.out.print("Respuesta (1-5, 0 para terminar): "); r = leerInt();
            if (r == 0) break;
            if (r < 1 || r > 5) { System.out.println("Respuesta no valida."); continue; }
            cantidad++; suma += r;
        }
        System.out.println("Respuestas: " + cantidad);
        if (cantidad > 0) System.out.println("Promedio: " + (double)suma/cantidad);
    }

    // 10. Transferencias hasta superar S/100000.
    static void b10() {
        int registros = 0; double monto;
        while (true) {
            System.out.print("Monto de transferencia: "); monto = leerDouble(); registros++;
            if (monto > 100000) { System.out.println("Transferencia detectada: S/" + monto); break; }
        }
        System.out.println("Registros procesados: " + registros);
    }

    // 11. Tiempos de respuesta hasta superar 5000 ms.
    static void b11() {
        int registros = 0, tiempo;
        while (true) {
            System.out.print("Tiempo en ms: "); tiempo = leerInt(); registros++;
            if (tiempo > 5000) { System.out.println("Tiempo critico: " + tiempo + " ms"); break; }
        }
        System.out.println("Registros procesados: " + registros);
    }

    // 12. Asistencia hasta escribir FIN.
    static void b12() {
        int total = 0; String nombre;
        while (true) {
            System.out.print("Nombre (FIN para terminar): "); nombre = sc.next();
            if (nombre.equalsIgnoreCase("FIN")) break;
            total++;
        }
        System.out.println("Total de asistentes: " + total);
    }

    // 13. Venta de entradas hasta llegar a 500.
    static void b13() {
        int total = 0, ventas = 0, cantidad;
        while (total < 500) {
            System.out.print("Entradas vendidas en esta venta: "); cantidad = leerInt();
            if (cantidad <= 0) { System.out.println("Cantidad no valida."); continue; }
            total += cantidad; ventas++;
        }
        System.out.println("Total vendido: " + total + "\nVentas realizadas: " + ventas);
    }

    // 14. Primer numero divisible entre 17 y 23.
    static void b14() {
        System.out.print("Ingrese desde que numero buscar: "); int n = leerInt();
        while (true) { if (n % 17 == 0 && n % 23 == 0) { System.out.println("Numero encontrado: " + n); break; } n++; }
    }

    // 15. Inventario hasta stock negativo.
    static void b15() {
        int stock, validos = 0; String producto;
        while (true) {
            System.out.print("Producto: "); producto = sc.next();
            System.out.print("Stock: "); stock = leerInt();
            if (stock < 0) { System.out.println("Producto con error: " + producto); break; }
            validos++;
        }
        System.out.println("Registros validos: " + validos);
    }

    // 16. Control de calidad: el usuario define el rango permitido.
    static void b16() {
        System.out.print("Medida minima permitida: "); double min = leerDouble();
        System.out.print("Medida maxima permitida: "); double max = leerDouble();
        int revisadas = 0; double medida;
        while (true) {
            System.out.print("Medida de pieza: "); medida = leerDouble(); revisadas++;
            if (medida < min || medida > max) { System.out.println("Medida incorrecta: " + medida); break; }
        }
        System.out.println("Piezas revisadas: " + revisadas);
    }

    // 17. Deteccion de fraude: se solicita el limite sospechoso.
    static void b17() {
        System.out.print("Monto desde el cual se considera sospechoso: "); double limite = leerDouble();
        int operaciones = 0; double monto;
        while (true) {
            System.out.print("Monto de operacion: "); monto = leerDouble(); operaciones++;
            if (monto >= limite) { System.out.println("Monto sospechoso: S/" + monto); break; }
        }
        System.out.println("Operaciones revisadas: " + operaciones);
    }

    // 18. Competencia hasta que alguien alcance 100 puntos.
    static void b18() {
        String ganador = ""; int puntos = 0;
        while (true) {
            System.out.print("Nombre del participante: "); String nombre = sc.next();
            System.out.print("Puntaje obtenido: "); puntos = leerInt();
            if (puntos >= 100) { ganador = nombre; break; }
        }
        System.out.println("Ganador: " + ganador + "\nPuntaje final: " + puntos);
    }

    // 19. Pedidos hasta encontrar uno urgente.
    static void b19() {
        int numero, procesados = 0; String estado;
        while (true) {
            System.out.print("Numero de pedido: "); numero = leerInt();
            System.out.print("Estado (normal/urgente): "); estado = sc.next();
            procesados++;
            if (estado.equalsIgnoreCase("urgente")) { System.out.println("Pedido urgente: " + numero); break; }
        }
        System.out.println("Pedidos procesados: " + procesados);
    }

    // 20. Paquetes hasta detectar uno corrupto.
    static void b20() {
        int numero, validos = 0; String estado;
        while (true) {
            System.out.print("Numero de paquete: "); numero = leerInt();
            System.out.print("Estado (valido/corrupto): "); estado = sc.next();
            if (estado.equalsIgnoreCase("corrupto")) { System.out.println("Paquete corrupto: " + numero); break; }
            validos++;
        }
        System.out.println("Paquetes validos procesados: " + validos);
    }

    // ==================== EJERCICIOS CON CONTINUE ====================

    // 1. Promedio de 100 notas validas.
    static void c1() {
        double suma = 0, nota, max = -1, min = 21; int cantidad = 0;
        for (int i = 1; i <= 100; i++) {
            System.out.print("Nota " + i + ": "); nota = leerDouble();
            if (nota < 0 || nota > 20) { System.out.println("Nota ignorada."); continue; }
            suma += nota; cantidad++; max = Math.max(max, nota); min = Math.min(min, nota);
        }
        if (cantidad > 0) System.out.println("Promedio: " + suma/cantidad + "\nMaxima: " + max + "\nMinima: " + min);
        else System.out.println("No hay notas validas.");
    }

    // 2. Edades entre 18 y 65.
    static void c2() {
        int suma = 0, cantidad = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Edad " + i + ": "); int edad = leerInt();
            if (edad < 18 || edad > 65) continue;
            suma += edad; cantidad++;
        }
        System.out.println("Personas validas: " + cantidad);
        if (cantidad > 0) System.out.println("Promedio de edad: " + (double)suma/cantidad);
    }

    // 3. Ignorar ventas negativas.
    static void c3() {
        double total = 0; int validas = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Venta " + i + ": "); double v = leerDouble();
            if (v < 0) continue;
            total += v; validas++;
        }
        System.out.println("Total vendido: S/" + total + "\nVentas validas: " + validas);
    }

    // 4. Mostrar impares del 1 al 100.
    static void c4() {
        for (int i = 1; i <= 100; i++) { if (i % 2 == 0) continue; System.out.print(i + " "); }
        System.out.println();
    }

    // 5. Mostrar vocales de una palabra.
    static void c5() {
        System.out.print("Ingrese una palabra: "); String palabra = sc.next();
        for (int i = 0; i < palabra.length(); i++) {
            char letra = Character.toLowerCase(palabra.charAt(i));
            if ("aeiouáéíóú".indexOf(letra) == -1) continue;
            System.out.print(letra + " ");
        }
        System.out.println();
    }

    // 6. Estadistica de temperaturas entre -10 y 50.
    static void c6() {
        double suma = 0, max = -999, min = 999; int cantidad = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Temperatura " + i + ": "); double t = leerDouble();
            if (t < -10 || t > 50) continue;
            suma += t; cantidad++; max = Math.max(max, t); min = Math.min(min, t);
        }
        if (cantidad > 0) System.out.println("Promedio: " + suma/cantidad + "\nMaxima: " + max + "\nMinima: " + min);
        else System.out.println("No hay temperaturas validas.");
    }

    // 7. Ignorar correos sin @.
    static void c7() {
        for (int i = 1; i <= 5; i++) {
            System.out.print("Correo " + i + ": "); String correo = sc.next();
            if (!correo.contains("@")) continue;
            System.out.println("Correo valido: " + correo);
        }
    }

    // 8. Ignorar velocidades menores de 20.
    static void c8() {
        double suma = 0, mayor = 0; int cantidad = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Velocidad " + i + ": "); double v = leerDouble();
            if (v < 20) continue;
            suma += v; cantidad++; mayor = Math.max(mayor, v);
        }
        if (cantidad > 0) System.out.println("Promedio: " + suma/cantidad + "\nMayor velocidad: " + mayor);
        else System.out.println("No hay velocidades validas.");
    }

    // 9. Palabras con al menos 5 caracteres.
    static void c9() {
        int cantidad = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Palabra " + i + ": "); String p = sc.next();
            if (p.length() < 5) continue;
            cantidad++;
        }
        System.out.println("Palabras validas: " + cantidad);
    }

    // 10. Ignorar pagos repetidos.
    static void c10() {
        double[] pagos = new double[10]; int unicos = 0; double total = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print("Pago " + (i+1) + ": "); double p = leerDouble();
            boolean repetido = false;
            for (int j = 0; j < unicos; j++) if (pagos[j] == p) { repetido = true; break; }
            if (repetido) continue;
            pagos[unicos++] = p; total += p;
        }
        System.out.println("Total acumulado: " + total + "\nPagos unicos: " + unicos);
    }

    // 11. Contar productos con stock mayor que cero.
    static void c11() {
        int disponibles = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Stock del producto " + i + ": "); int stock = leerInt();
            if (stock == 0) continue;
            if (stock > 0) disponibles++;
        }
        System.out.println("Productos disponibles: " + disponibles);
    }

    // 12. Produccion diaria, ignorar ceros.
    static void c12() {
        int total = 0, dias = 0;
        for (int i = 1; i <= 7; i++) {
            System.out.print("Produccion del dia " + i + ": "); int p = leerInt();
            if (p == 0) continue;
            total += p; dias++;
        }
        System.out.println("Produccion acumulada: " + total);
        if (dias > 0) System.out.println("Promedio diario: " + (double)total/dias);
    }

    // 13. Encuesta: respuestas de 1 a 5.
    static void c13() {
        int[] frecuencia = new int[6]; int suma = 0, cantidad = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Respuesta " + i + ": "); int r = leerInt();
            if (r < 1 || r > 5) continue;
            frecuencia[r]++; suma += r; cantidad++;
        }
        for (int i = 1; i <= 5; i++) System.out.println("Respuesta " + i + ": " + frecuencia[i]);
        if (cantidad > 0) System.out.println("Promedio: " + (double)suma/cantidad);
    }

    // 14. Ignorar estudiantes retirados.
    static void c14() {
        int validos = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Nombre: "); String nombre = sc.next();
            System.out.print("Estado (activo/retirado): "); String estado = sc.next();
            if (estado.equalsIgnoreCase("retirado")) continue;
            validos++;
        }
        System.out.println("Asistentes validos: " + validos);
    }

    // 15. Examen: ignorar respuestas vacias; usar '-' para sin responder.
    static void c15() {
        int validas = 0, aciertos = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Respuesta " + i + " (A/B/C/D o -): "); String r = sc.next();
            if (r.equals("-")) continue;
            validas++;
            System.out.print("Respuesta correcta para esta pregunta: "); String correcta = sc.next();
            if (r.equalsIgnoreCase(correcta)) aciertos++;
        }
        System.out.println("Respuestas validas: " + validas);
        if (validas > 0) System.out.println("Porcentaje de aciertos: " + (100.0*aciertos/validas) + "%");
    }

    // 16. Ignorar salarios negativos.
    static void c16() {
        double suma = 0, mayor = 0; int cantidad = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Salario " + i + ": "); double s = leerDouble();
            if (s < 0) continue;
            suma += s; cantidad++; mayor = Math.max(mayor, s);
        }
        if (cantidad > 0) System.out.println("Promedio salarial: " + suma/cantidad + "\nSalario mas alto: " + mayor);
    }

    // 17. Ignorar transacciones menores a S/10.
    static void c17() {
        double total = 0; int cantidad = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Monto de transaccion: "); double m = leerDouble();
            if (m < 10) continue;
            total += m; cantidad++;
        }
        System.out.println("Total procesado: " + total + "\nTransacciones validas: " + cantidad);
    }

    // 18. Ignorar lluvias negativas.
    static void c18() {
        double total = 0; int cantidad = 0;
        for (int i = 1; i <= 7; i++) {
            System.out.print("Lluvia del dia (mm): "); double lluvia = leerDouble();
            if (lluvia < 0) continue;
            total += lluvia; cantidad++;
        }
        System.out.println("Precipitacion acumulada: " + total + " mm");
        if (cantidad > 0) System.out.println("Promedio: " + total/cantidad + " mm");
    }

    // 19. Numeros del 1 al 500, ignorar multiplos de 2, 3 y 5.
    static void c19() {
        int cantidad = 0;
        for (int i = 1; i <= 500; i++) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) continue;
            System.out.print(i + " "); cantidad++;
        }
        System.out.println("\nCantidad encontrada: " + cantidad);
    }

    // 20. Ignorar clientes con datos incompletos.
    static void c20() {
        int validos = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Nombre del cliente: "); String nombre = sc.next();
            System.out.print("Documento: "); String documento = sc.next();
            System.out.print("Telefono: "); String telefono = sc.next();
            if (nombre.isBlank() || documento.isBlank() || telefono.isBlank()) continue;
            validos++;
        }
        System.out.println("Clientes validos: " + validos);
        System.out.println("Porcentaje valido: " + (validos * 10) + "%");
    }

    // ==================== EJERCICIOS INTEGRADORES ====================

    // Integrador 1: 200 notas, terminar al ingresar 20.
    static void integrador1() {
        int cantidad = 0, aprobados = 0, desaprobados = 0;
        double suma = 0, max = -1, min = 21;
        for (int i = 1; i <= 200; i++) {
            System.out.print("Nota " + i + " (20 para terminar): "); double n = leerDouble();
            if (n == 20) break;
            if (n < 0 || n > 20) continue;
            cantidad++; suma += n; max = Math.max(max, n); min = Math.min(min, n);
            if (n >= 11) aprobados++; else desaprobados++;
        }
        System.out.println("Notas validas: " + cantidad);
        if (cantidad > 0) System.out.println("Promedio: " + suma/cantidad + "\nMaxima: " + max + "\nMinima: " + min);
        System.out.println("Aprobados: " + aprobados + "\nDesaprobados: " + desaprobados);
    }

    // Integrador 2: ignorar notas fuera del rango.
    static void integrador2() {
        int validas = 0, invalidas = 0; double suma = 0, max = -1, min = 21;
        for (int i = 1; i <= 200; i++) {
            System.out.print("Nota " + i + ": "); double n = leerDouble();
            if (n < 0 || n > 20) { invalidas++; continue; }
            validas++; suma += n; max = Math.max(max, n); min = Math.min(min, n);
        }
        System.out.println("Notas validas: " + validas + "\nNotas invalidas: " + invalidas);
        if (validas > 0) System.out.println("Promedio: " + suma/validas + "\nMaxima: " + max + "\nMinima: " + min);
    }

    // Integrador 3: ignorar negativos y terminar con 999.
    static void integrador3() {
        int cantidad = 0, suma = 0, mayor = Integer.MIN_VALUE, menor = Integer.MAX_VALUE;
        while (true) {
            System.out.print("Ingrese numero entero (999 para terminar): "); int n = leerInt();
            if (n == 999) break;
            if (n < 0) continue;
            cantidad++; suma += n; mayor = Math.max(mayor, n); menor = Math.min(menor, n);
        }
        System.out.println("Numeros validos: " + cantidad + "\nSuma total: " + suma);
        if (cantidad > 0) System.out.println("Promedio: " + (double)suma/cantidad + "\nMayor: " + mayor + "\nMenor: " + menor);
        else System.out.println("No se ingresaron numeros validos.");
    }
}
