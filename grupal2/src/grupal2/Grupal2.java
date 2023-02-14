package grupal2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Grupal2 {

	public static void main(String[] args) {
		
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		boolean power = true;
		while (power) {
			System.out.println("Bienvenido al Sistema de Capacitaciones de la Empresa ''Piquer Dans Les Yeux''");
			System.out.println();
			System.out.println("Que Desea hacer?");
			System.out.println("1 - Crear Cliente");
			System.out.println("2 - Crear Capacitacion");
			System.out.println("3 - Consultar Clientes");
			System.out.println("4 - Consultar Capacitaciones");
			System.out.println("5 - Salir");
			Scanner sc = new Scanner(System.in);
			int opciones = 5;
			try{
                opciones = Integer.parseInt(sc.nextLine());
            } catch (Exception e){
                System.out.println("OPCIÓN NO VALIDA");
            }
			
			switch (opciones) {
				case 1: //Crear Cliente
					Cliente cliente =crearCliente();
					if (cliente != null) {
						List<Capacitacion> capacitaciones = asignarCapacitaciones();
						cliente.setCapacitaciones(capacitaciones);
						clientes.add(cliente);
					}
					
					break;
				case 2: //Crear Capacitacion
					
					Capacitacion capacitacion = crearCapacitacion();
					if (capacitacion != null) {
						//getCapacitaciones().add(capacitacion);
					}
					
					break;
				case 3: // Consultar Clientes
					mostrarClientes(clientes);
					
					break;
				case 4: // Consultar Capacitaciones
			//		mostrarCapacitaciones(List<Capacitacion> capacitaciones);
					
					break;
				case 5:
					System.out.println("Un gusto haberlo ayudado... Hasta luego");
					power = false;
				default:
                    System.out.println("OPCIÓN NO VALIDA");
                    
					
			}
		
			
		}
			
	}
	
	public static Cliente crearCliente() {
		Cliente cliente = new Cliente();
	        try {
	            cliente.setNombreCliente(ingresarNomCliente());
	            cliente.setRutCliente(ingresarRutCliente());
	            cliente.setDirCliente(ingresarDirCliente());
	            cliente.setComunaCliente(ingresarComCliente());
	            cliente.setTelefonoCliente(ingresarTelefono());
	            cliente.setCapacitaciones(new ArrayList<>());
	            System.out.println("CLIENTE CREADO EXITOSAMENTE");
	            return cliente;
	        } catch(Exception e){
	            System.out.println("HUBO UN ERROR. INTENTE DE NUEVO");
	            e.printStackTrace();
	            return null;
	        }
	}
	
	public static Capacitacion crearCapacitacion() {
		Capacitacion capacitacion = new Capacitacion();
		try {
        	capacitacion.setNombreCapacitacion(ingresarNomCap());
        	capacitacion.setDiaCapacitacion(ingresarDiaCap());
        	capacitacion.setHoraCapacitacion(ingresarHoraCap());
        	capacitacion.setLugarCapacitacion(ingresarLugarCap());
        	capacitacion.setDuracionCapacitacion(ingresarDurCap());
        	capacitacion.setCantAsistCapacitacion(ingresarCantAsist());
        	setInfoAsistente(capacitacion);
        	System.out.println("CAPACITACION CREADA EXITOSAMENTE");
            return capacitacion;
        } catch(Exception e){
            System.out.println("HUBO UN ERROR. INTENTE DE NUEVO");
            e.printStackTrace();
            return null;
        }
	}
	
	
	private static void setInfoAsistente(Capacitacion capacitacion) {
		//definir array para nombre asistente y edades
		List<Integer> edades = new ArrayList<Integer>();
		List<String> nombres = new ArrayList<String>();
		//declaro contadores
		int cont = 0;
		int cantAsistentes = capacitacion.getCantAsistCapacitacion();
		//se abre conexión a consola
		Scanner pr = new Scanner(System.in);
		//se inicia el blucle
		while (cont< cantAsistentes) {
			//generar bucle hasta que se  ingrese un nombre
			boolean hayNombre = false;
			while (!hayNombre) {
				System.out.println("Ingrese el nombre del asistente: ");
				String nombre = pr.nextLine();
				if(nombre == null || nombre.equals("") || nombre.length()<3) {
					System.out.println("Nombre no puede estar vacio");
				} else { 
					hayNombre = true;
					nombres.add(nombre);
				}
			}
			
			//generar bucle hasta que se  ingrese edad
			boolean hayEdad = false;
			while (!hayEdad) {
				System.out.println("Ingrese la edad del asistente: ");
				String edad = pr.nextLine();
				if (edad ==  null || edad.isEmpty() || !edad.matches("[0-9]+"))
				{
					System.out.println("Edad no válida");
				} else if (Integer.parseInt(edad)> 120) { 
					System.out.println("Disfrute su jubilación");
				} else  {
					hayEdad = true;
					edades.add(Integer.parseInt(edad));
				}
			}
			cont++;
		}
		
		//se cierra conexión a consola
		//pr.close();
		//se asigna la informaciónde los asistentes
		capacitacion.setNombreAsistenteCap(nombres);
		capacitacion.setEdadAsistenteCap(edades);
	}

	//ingresar Nombre
	public static String ingresarNomCliente() {
		boolean ok = false;
		String nombre = null;
		Scanner pr = new Scanner(System.in);
		while ( ok == false) {
			System.out.print("Favor ingresar Nombre del Cliente: ");
			nombre = pr.nextLine();
			if(nombre == null || nombre.equals("") || nombre.length()<3) {
				System.out.println("Nombre no puede estar vacio");
			} else { 
				ok = true;
			}
		}
		return nombre;
	}
			
	public static int ingresarRutCliente() {
		boolean ok = false;
		int rut = 0;
		while ( ok == false) {
			System.out.print("Favor ingresar el Rut del Cliente: ");
			Scanner pr = new Scanner(System.in);
			boolean esDigito = false;
			String rutS = pr.nextLine();
			if(rutS.matches("[0-9]+") && rutS.length() >8){
                esDigito = true;
            } else {
            	System.out.println("Rut no puede estar vacio, ingresar Rut del Cliente sin puntos ni guion");
				System.out.println("Ingresar RUT: ");
            }
			if(esDigito == true) {
				rut = Integer.parseInt(rutS);
				if(rut > 11111111 && rut > 999999999) {
					System.out.println("Rut no puede estar vacio, ingresar Rut del Cliente sin puntos ni guion");
					System.out.print("Ingresar RUT:");
				} else { 		
					ok = true;
				}
			}
			
		} 
		return rut;
	}		
			
	public static String ingresarDirCliente() {
		boolean ok = false;
		String nombre = null;
		while ( ok == false) {
			System.out.print("Favor ingresar Direccion del Cliente: ");
			Scanner pr = new Scanner(System.in);
			nombre = pr.nextLine();
			if(nombre == null || nombre.equals("")) {
				System.out.println("Direccion no puede estar vacio");
				System.out.print("Ingresar direccion: ");
			} else { 
				ok = true;
			}
		}
		return nombre;
	}
			
	public static String ingresarComCliente() {
		boolean ok = false;
		String nombre = null;
		while ( ok == false) {
			System.out.print("Favor ingresar Comuna del Cliente: ");
			Scanner pr = new Scanner(System.in);
			nombre = pr.nextLine();
			if(nombre == null || nombre.equals("")) {
				System.out.println("Comuna no puede estar vacio");
				System.out.print("Ingresar Comuna: ");
			} else { 
				ok = true;
			}
		}
		return nombre;
	}
			
			//ingresar Telefono
	public static String ingresarTelefono() throws IOException{
	       boolean ok = false;
	       String fono = null;
	       while (!ok) {
	    	   System.out.print("Favor ingresar telefono del Cliente: ");
	           boolean largo = false;
	           boolean esDigito = false;
	           Scanner pr = new Scanner(System.in);
	           fono = pr.nextLine();
	           if(fono.matches("[0-9]+")){
	               esDigito = true;
	           }
	           if(fono.length() >8 && fono.length() <16){
	               largo = true;
	           }
	           ok = esDigito && largo;
	       }
	       return fono;
	}		
		
		

	public static String ingresarNomCap() {
		boolean ok = false;
		String nombrec = null;
		while ( ok == false) {
			System.out.print("Favor ingresar Nombre de la Capacitacion: ");
			Scanner pr = new Scanner(System.in);
			nombrec = pr.nextLine();
			if(nombrec == null || nombrec.equals("") || nombrec.length()<3) {
				System.out.println("Nombre de Capacitacion no puede estar vacio");
			} else { 
				ok = true;
			}
		}
		return nombrec;
	}	
		
	public static String ingresarDiaCap() {
		boolean ok = false;
		String dia = null;
		while ( ok == false) {
			System.out.print("Ingresar dia de la Capacitacion: ");
			Scanner pr = new Scanner(System.in);
			dia = pr.nextLine();
			if(dia == null || dia.equals("")) {
				System.out.println("El Dia no puede estar vacio");
			} else { 
				ok = true;
			}
		}
		return dia;
	}
	
	public static String ingresarHoraCap() {
		boolean ok = false;
		String nombre = null;
		while ( ok == false) {
			System.out.print("Ingresar hora de la Capacitacion: ");
			Scanner pr = new Scanner(System.in);
			nombre = pr.nextLine();
			if(nombre == null || nombre.equals("")) {
				System.out.println("Hora no puede estar vacio");
			} else { 
				ok = true;
			}
		}
		return nombre;
	}
	
	public static String ingresarLugarCap() {
		boolean ok = false;
		String nombre = null;
		while ( ok == false) {
			System.out.print("Ingresar lugar donde se realizara la Capacitacion: ");
			Scanner pr = new Scanner(System.in);
			nombre = pr.nextLine();
			if(nombre == null || nombre.equals("")) {
				System.out.println("Lugar no puede estar vacio");
			} else { 
				ok = true;
			}
		}
		return nombre;
	}
	
	public static int ingresarDurCap() {
		boolean ok = false;
		int dur = 0;
		while ( ok == false) {
			System.out.println("Ingresar la duraccion de la Capacitacion: ");
			Scanner pr = new Scanner(System.in);
			boolean esDigito = false;
			String durS = pr.nextLine();
			if(durS.matches("[0-9]+") ){
                esDigito = true;
            } else {
            	System.out.println("La duracion no puede estar vacio");
            }
			if(esDigito == true) {
				dur = Integer.parseInt(durS);
				if(dur > 11111111 && dur > 999999999) {
					System.out.println("La duracion no puede estar vacio");
				} else { 		
					ok = true;
				}
			}
			
		} 
		return dur;
	}
	
	public static int ingresarCantAsist() {
		boolean ok = false;
		int casis = 0;
		while ( ok == false) {
			System.out.print("Ingresar la Cantidad de Asistentes: ");
			Scanner pr = new Scanner(System.in);
			boolean esDigito = false;
			String cantA = pr.nextLine();
			if(cantA.matches("[0-9]+")){
				casis = Integer.parseInt(cantA);
            } else {
            	System.out.println("la Cantidad de Asistentes no puede estar vacio");
				System.out.println("Ingresar Cantidad de Asistentes:");
            }
				ok = true;
			}
		return casis;
	}

	
	public static void mostrarClientes( List<Cliente> clientes) {
        for (int x = 0; x < clientes.size(); x++){
            System.out.println("Cliente "+(x+1));
            mostrarCliente(clientes.get(x));
        }
    }
	public static void mostrarCliente(Cliente cliente){
        System.out.println("Nombre: "+cliente.getNombreCliente());
        System.out.println("RUN: "+cliente.getRutCliente());
        System.out.println("Nacionalidad: "+cliente.getDirCliente());
        System.out.println("Dirección: "+cliente.getComunaCliente());
        System.out.println("Genero: "+cliente.getTelefonoCliente());
        System.out.println("Correo Electronico: "+cliente.getCapacitaciones());
       // if (cliente.getNotas()!=null){
       //     System.out.println("Notas: "+alumno.getNotas().getAllNotas());
       //   }
        System.out.println("------------------");
    }
	public static void mostrarCapacitaciones( List<Capacitacion> capacitaciones) {
        for (int x = 0; x < capacitaciones.size(); x++){
            System.out.println("Capacitacion "+(x+1));
            mostrarCapacitacion(capacitaciones.get(x));
        }
    }
	public static void mostrarCapacitacion(Capacitacion capacitacion){
        System.out.println("Nombre: "+capacitacion.getNombreCapacitacion());
        System.out.println("RUN: "+capacitacion.getDiaCapacitacion());
        System.out.println("Nacionalidad: "+capacitacion.getHoraCapacitacion());
        System.out.println("Nacionalidad: "+capacitacion.getLugarCapacitacion());
        System.out.println("Dirección: "+capacitacion.getDuracionCapacitacion());
        System.out.println("Dirección: "+capacitacion.getCantAsistCapacitacion());
        System.out.println("------------------");
    //    mostrarAsistentes(asistentes.get(x));
    }
//	public static void mostrarAsistentes( List<NombreAsistenteCap> capacitaciones) {
//		for (int x = 0; x < clientes.size(); x++){
//         System.out.println("Cliente "+(x+1));
//         mostrarCliente(clientes.get(x));
//     }
//     System.out.println("Genero: "+capacitacion.getNombreAsistenteCap());
//     System.out.println("Correo Electronico: "+capacitacion.getEdadAsistenteCap());
//	}
//	 
//	
//	public static void mostrarAsistente(Capacitacion capacitacion){
//		System.out.println("Nombre de Asistente: "+capacitacion.getNombreAsistenteCap());
//        System.out.println("Edad : "+capacitacion.getEdadAsistenteCap());
//        System.out.println("------------------");
//	}
	
	private static List<Capacitacion> asignarCapacitaciones(){
		
		boolean respuestaValida = leerRespuestaCliente();
		List<Capacitacion> capacitaciones = new ArrayList<Capacitacion>();
		while (respuestaValida) { 
			
			Capacitacion cap = crearCapacitacion();
			if (cap != null) {
				capacitaciones.add(cap);
				respuestaValida = false;
			}
		} 
		return capacitaciones;
		
	}
	
	private static boolean leerRespuestaCliente(){ 
		Scanner sc = new Scanner(System.in);
		String respuesta = "n";
		boolean preguntar = true;
		while (preguntar) {
			System.out.print("Desea ingresar capacitaciones a este cliente? y/n: ");
			respuesta = sc.nextLine();
			preguntar = !respuesta.toLowerCase().equals("y") && !respuesta.toLowerCase().equals("n");
			
		}
		return respuesta.toLowerCase().equals("y");
	}
	
//	Finalizado este proceso, debe mostrar por pantalla los datos de la empresa
//	que pidió la capacitación, los datos de la capacitación misma, y la cantidad de personas menores a
//	25 años, entre 26 y 35 años y mayores a 35 años.
	
	public static void mostrardatos(Cliente cliente) {
		System.out.println("La empresa:"+cliente.getNombreCliente()+"");
		
	}
	

}
