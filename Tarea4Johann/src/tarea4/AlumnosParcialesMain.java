package tarea4;

/**
 *  @author Johann
 */

import java.io.File;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * En este main se guardan los distintos datos de un alumno en un fichero
 * binario
 */

public class AlumnosParcialesMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Alumnos alumno[] = new Alumnos[5];

		FileOutputStream ficheroSalida = null;

		DataOutputStream escribirDatosFicheros = null;

		File fichero = null;

		try {
			System.out.println("Introduzca el nombre de fichero: ");
			String nombreFichero = sc.nextLine();
			fichero = new File(nombreFichero);
			ficheroSalida = new FileOutputStream(fichero);
			escribirDatosFicheros = new DataOutputStream(ficheroSalida);

			for (int i = 0; i < alumno.length; i++) {
				System.out.println("Introduzca la Nia del alumno: ");
				int nia = sc.nextInt();
				sc.nextLine();
				escribirDatosFicheros.writeInt(nia);

				System.out.println("Introduzca el nombre del alumno: ");
				String nombre = sc.nextLine();
				escribirDatosFicheros.writeUTF(nombre);

				System.out.println("Introduzca los apellidos del alumno: ");
				String apellidos = sc.nextLine();
				escribirDatosFicheros.writeUTF(apellidos);

				System.out.println("Introduzca el genero del alumno: ");
				char genero = sc.nextLine().charAt(0);
				escribirDatosFicheros.writeChar(genero);

				System.out.println("Introduzca la fecha de nacimiento del alumno(yyyy-MM-dd): ");
				String fechaEntrada = sc.nextLine();
				LocalDate nacimiento = null;
				nacimiento = LocalDate.parse(fechaEntrada);
				escribirDatosFicheros.writeUTF(fechaEntrada);

				System.out.println("Introduzca el cliclo del alumno: ");
				String ciclo = sc.nextLine();
				escribirDatosFicheros.writeUTF(ciclo);

				System.out.println("Introduzca el curso del alumno: ");
				String curso = sc.nextLine();
				escribirDatosFicheros.writeUTF(curso);

				System.out.println("Introduzca el grupo del alumno: ");
				String grupo = sc.nextLine();
				escribirDatosFicheros.writeUTF(grupo);

//				alumno[i] = new Alumnos(nia, nombre, apellidos, genero, nacimiento, ciclo, curso, grupo);

			}
		} catch (DateTimeParseException e) {
			System.out.println("Formato de fecha incorrecto. Inténtalo de nuevo.");
		} catch (InputMismatchException e) {
			System.out.println("Formato incorrecto");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ficheroSalida.close();
				escribirDatosFicheros.close();
				sc.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}