/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pc2;

/**
 *
 * @author Joaquin
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private List<Paciente> pacientes;
    private List<Medico> medicos;

    public Main() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
    }

    public static void main(String[] args) {
        Main sistema = new Main();
        sistema.menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("--- Menú ---");
            System.out.println("1. Registrar datos de pacientes");
            System.out.println("2. Eliminar datos de un paciente");
            System.out.println("3. Modificar datos de un paciente");
            System.out.println("4. Mostrar el peso que más se repite");
            System.out.println("5. Mostrar cantidad de pacientes con peso que más se repite");
            System.out.println("6. Mostrar peso mayor y menor");
            System.out.println("7. Dividir rango de pesos y mostrar cantidad por rango");
            System.out.println("8. Mostrar lista de pacientes ordenados por apellidos");
            System.out.println("9. Indicar qué doctor atendió a un paciente");
            System.out.println("10. Buscar doctores por especialidad");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarDatosPaciente();
                    break;
                case 2:
                    eliminarDatosPaciente();
                    break;
                case 3:
                    modificarDatosPaciente();
                    break;
                case 4:
                    mostrarPesoQueMasSeRepite();
                    break;
                case 5:
                    mostrarCantidadPacientesConPesoRepetido();
                    break;
                case 6:
                    mostrarPesoMayorYMenor();
                    break;
                case 7:
                    dividirRangoDePesos();
                    break;
                case 8:
                    mostrarListaPacientesOrdenadosPorApellidos();
                    break;
                case 9:
                    indicarDoctorQueAtendioPaciente();
                    break;
                case 10:
                    buscarDoctoresPorEspecialidad();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private void registrarDatosPaciente() {
       Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del paciente:");
        System.out.print("DNI: ");
        String dni = scanner.next();
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Dirección: ");
        String direccion = scanner.next();
        System.out.print("Peso: ");
        double peso = scanner.nextDouble();
        System.out.print("Temperatura: ");
        double temperatura = scanner.nextDouble();

        Paciente nuevoPaciente = new Paciente(dni, nombre, direccion, peso, temperatura);
        pacientes.add(nuevoPaciente);

        System.out.println("Paciente registrado con éxito.");
    }

    private void eliminarDatosPaciente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la posición del paciente a eliminar: ");
        int posicion = scanner.nextInt();

        if (posicion >= 0 && posicion < pacientes.size()) {
            pacientes.remove(posicion);
            System.out.println("Paciente eliminado con éxito.");
        } else {
            System.out.println("Posición no válida. Intente nuevamente.");
        }
    }

    private void modificarDatosPaciente() {
       Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la posición del paciente a modificar: ");
        int posicion = scanner.nextInt();

        if (posicion >= 0 && posicion < pacientes.size()) {
            Paciente paciente = pacientes.get(posicion);

            System.out.println("Ingrese los nuevos datos del paciente:");
            System.out.print("Nombre: ");
            paciente.setNombre(scanner.next());
            System.out.print("Dirección: ");
            paciente.setDireccion(scanner.next());
            System.out.print("Peso: ");
            paciente.setPeso(scanner.nextDouble());
            System.out.print("Temperatura: ");
            paciente.setTemperatura(scanner.nextDouble());

            System.out.println("Datos del paciente modificados con éxito.");
        } else {
            System.out.println("Posición no válida. Intente nuevamente.");
        }
    }

    private void mostrarPesoQueMasSeRepite() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        Map<Double, Integer> frecuenciaPesos = new HashMap<>();

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            frecuenciaPesos.put(peso, frecuenciaPesos.getOrDefault(peso, 0) + 1);
        }

        double pesoMasRepetido = Collections.max(frecuenciaPesos.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("El peso que más se repite es: " + pesoMasRepetido);
    }

    private void mostrarCantidadPacientesConPesoRepetido() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        Map<Double, Integer> frecuenciaPesos = new HashMap<>();

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            frecuenciaPesos.put(peso, frecuenciaPesos.getOrDefault(peso, 0) + 1);
        }

        double pesoMasRepetido = Collections.max(frecuenciaPesos.entrySet(), Map.Entry.comparingByValue()).getKey();
        int cantidadPacientes = frecuenciaPesos.get(pesoMasRepetido);

        System.out.println("La cantidad de pacientes con el peso que más se repite es: " + cantidadPacientes);
    }

    private void mostrarPesoMayorYMenor() {
         if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        double pesoMayor = Double.MIN_VALUE;
        double pesoMenor = Double.MAX_VALUE;

        for (Paciente paciente : pacientes) {
            double peso = paciente.getPeso();
            pesoMayor = Math.max(pesoMayor, peso);
            pesoMenor = Math.min(pesoMenor, peso);
        }

        System.out.println("Peso mayor: " + pesoMayor);
        System.out.println("Peso menor: " + pesoMenor);
    }

    private void dividirRangoDePesos() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        int rango1 = 0;
        int rango2 = 0;
        int rango3 = 0;
        int rango4 = 0;

        for (Paciente paciente : pacientes);
    }
    
    private void mostrarListaPacientesOrdenadosPorApellidos() {
       
    }

    private void indicarDoctorQueAtendioPaciente() {
       
    }

    private void buscarDoctoresPorEspecialidad() {
       
    }
}
