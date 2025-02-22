package grupal6;
/**
 * <h1>Grupal 5 : POO_ABPRO5_</h1>
 * 
 * @author	Cristian Carrillo
 * 			Adrian Fredes
 * 			Matias Claderon
 * 			Jorge Arancibia
 * 
 * <p> Aqui el JAVADOC de este grupal </p> 
 * 
 * @version 1.0. 
 * 
 */

public class Cliente { /** Clase Cliente */
	
	private int rut; 			/** Atributo del tipo Ingreseo rut */
	private String nombres; 	/** Atributo del tipo String nombres */
	private String apellidos;	/** Atributo del tipo String apellidos */
	private String telefono;	/** Atributo del tipo String telefono */
	private String afp;			/** Atributo del tipo String afp */
	private int sds;			/** Atributo del tipo int sds */
	private String direccion;	/** Atributo del tipo String duraccion */
	private String comuna;		/** Atributo del tipo String comuna */
	private int edad;			/** Atributo del tipo int edad */
	/**
	 * @return el rut
	 */
	public int getRut() {
		return rut;
	};
	/**
	 * @param rut para setear el rut
	 */
	public void setRut(int rut) {
		this.rut = rut;
	};
	/**
	 * @return el valor de nombres
	 */
	public String getNombres() {
		return nombres;
	};
	/**
	 * @param nombre para setear nombre
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	};
	/**
	 * @return el valor de apellido
	 */
	public String getApellidos() {
		return apellidos;
	};
	/**
	 * @param apellidos para setear apellido
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	};
	/**
	 * @return el valor de telefono
	 */
	public String getTelefono() {
		return telefono;
	};
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	};
	/**
	 * @return valor de afp
	 */
	public String getAfp() {
		return afp;
	};
	/**
	 * @param afp para setear el valor de afp
	 */
	public void setAfp(String afp) {
		this.afp = afp;
	};
	/**
	 * @return el valor de sds
	 */
	public int getSds() {
		return sds;
	};
	/**
	 * @param sds para setear valor de sds
	 */
	public void setSds(int sds) {
		this.sds = sds;
	};
	/**
	 * @return valor de direccion
	 */
	public String getDireccion() {
		return direccion;
	};
	/**
	 * @param direccion para setear direccion
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	};
	/**
	 * @return el valor de comuna
	 */
	public String getComuna() {
		return comuna;
	};
	/**
	 * @param comuna para setear valor de comuna
	 */
	public void setComuna(String comuna) {
		this.comuna = comuna;
	};
	/**
	 * @return valor de edad
	 */
	public int getEdad() {
		return edad;
	};
	/**
	 * @param edad para setear el valor de edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	};
	
	/**
	 * Constructor basico del objeto Cliente
	 *   
	 */
	public Cliente() {
		
	};
	
	/**
	 * Construye un nuevo objeto Cliente con la información personal y de contacto especificada.
	 * @param rut el número de RUT del cliente
	 * @param nombres los nombres y apellidos del cliente
	 * @param apellidos los apellidos del cliente
	 * @param telefono el número de teléfono del cliente
	 * @param afp la AFP (Administradora de Fondos de Pensiones) del cliente
	 * @param sds el identificador del Sistema de Salud del cliente
	 * @param direccion la dirección del cliente
	 * @param comuna la comuna del cliente
	 * @param edad la edad del cliente
	 * 
	 */
	
	public Cliente(int rut, String nombres, String apellidos, String telefono, String afp, int sds, String direccion, String comuna, int edad) {
		this.rut = rut;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.afp = afp;
		this.sds = sds;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
	};
	
	public String obtenerNombre(String nombres, String apellidos) {
		return nombres +" "+ apellidos;

	}
	public String obtenerSds (int sds) {
		if (sds == 1) {
			return "Fonasa";
		} else {
			return "Isapre";
		}
	}
	
	public void mostrar(){
		System.out.println("\tNombre Completo: "+ obtenerNombre(getNombres(), getApellidos()));
        System.out.println("\tNumero de cel: "+ getTelefono());
        System.out.println("\tRUT Cliente: "+ getRut());
        System.out.println("\tAFP: "+ getAfp());
        System.out.println("\tSistema de Salud: "+ obtenerSds(getSds()));
        System.out.println("\tDireccion: "+ getDireccion());
        System.out.println("\tComuna: "+ getComuna());
        System.out.println("\tEdad: "+ getEdad());
    }

	@Override
	public String toString() {
		return ANSI_GREEN+"Cliente [rut=" +ANSI_RESET+ANSI_CYAN+ rut +ANSI_RESET+ANSI_GREEN
				+ ", nombres=" +ANSI_RESET+ANSI_CYAN+ nombres +ANSI_RESET+ANSI_GREEN
				+ ", apellidos=" +ANSI_RESET+ANSI_CYAN+ apellidos +ANSI_RESET+ANSI_GREEN
				+ ", telefono=" +ANSI_RESET+ANSI_CYAN+ telefono +ANSI_RESET+ANSI_GREEN+ ", afp=" 
				+ANSI_RESET+ANSI_CYAN+ afp +ANSI_RESET+ANSI_GREEN+ ", sds=" +ANSI_RESET+
				ANSI_CYAN+ sds +ANSI_RESET+ANSI_GREEN+ ", direccion=" +ANSI_RESET+ANSI_CYAN
				+ direccion +ANSI_RESET+ANSI_GREEN+ ", comuna=" +ANSI_RESET+ANSI_CYAN+ comuna 
				+ANSI_RESET+ANSI_GREEN+ ", edad=" + edad +ANSI_RESET+ANSI_GREEN+ "]"+ANSI_RESET;
	}

	
	
	
	
	
	
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RESET = "\u001B[0m";

}