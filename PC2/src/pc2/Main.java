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
       
    }

    private void eliminarDatosPaciente() {
        
    }

    private void modificarDatosPaciente() {
       
    }

    private void mostrarPesoQueMasSeRepite() {
        
    }

    private void mostrarCantidadPacientesConPesoRepetido() {
        
    }

    private void mostrarPesoMayorYMenor() {
        
    }

    private void dividirRangoDePesos() {
        
    }

    private void mostrarListaPacientesOrdenadosPorApellidos() {
       
    }

    private void indicarDoctorQueAtendioPaciente() {
       
    }

    private void buscarDoctoresPorEspecialidad() {
       
    }
}