package management;

import entities.Agente;
import utils.ConsoleUtils;

import java.util.ArrayList;

public class AgenteManager {
    private ArrayList<Agente> agentes;
    int nivel;

    public AgenteManager(int nivel) {
        this.agentes = new ArrayList<>();
        this.nivel = nivel;
    }

    public void registrarAgente() {
        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente: ");
        ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

        String nombre = ConsoleUtils.leerTexto("Ingrese el nombre del agente: ");
        String habilidad = ConsoleUtils.leerTexto("Ingrese la habilidad especial del agente: ");

        Agente nuevoAgente = new Agente(id, nombre, habilidad);
        agentes.add(nuevoAgente);
        System.out.println("Agente registrado con éxito.");
    }

    public void mostrarAgentes() {
        if (agentes.isEmpty()) {
            System.out.println("No hay agentes registrados.");
            return;
        }
        System.out.println("=== Lista de Agentes ===");
        for (Agente agente : agentes) {
            System.out.println(agente);
        }
    }

    public int incrementarNivel(int nivel){
        System.out.println("El agente ha incrementado su nivel: " +nivel);
        return this.nivel++;
    }

public void mostrarNivel (){
    if (nivel == 1) {
        System.out.println("El nivel del agente es: " +nivel);
    }else{
        System.out.println("El nivel del agente se ha incrementado y ahora es: " +nivel);
    }
}
    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Agentes ===");
            System.out.println("1. Registrar Agente");
            System.out.println("2. Mostrar Agentes");
            System.out.println("3. Mostrar nivel");
            System.out.println("4, Incrementar nivel..");
            System.out.println("5. salir");
            int opcion = ConsoleUtils.leerEntero("Seleccione una opción: ");
            ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

            switch (opcion) {
                case 1 -> registrarAgente();
                case 2 -> mostrarAgentes();
                case 3 -> mostrarNivel();
                case 4 -> incrementarNivel(nivel);
                case 5 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}