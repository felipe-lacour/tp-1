import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Equipo {

	private String nombre;
	private String ciudad;
	private String foto;
	private LinkedList<Jugador> jugadores = new LinkedList<Jugador>();
	
	

	public Equipo(String nombre, String ciudad, String foto) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.foto = foto;
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public LinkedList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(LinkedList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}
	
	public boolean AgregarJugador(String nombre, int numeroCamiseta, String posicion, int edad) {
		for (Jugador jugador : jugadores) {
			if(jugador.getNumeroCamiseta()==numeroCamiseta) {
				JOptionPane.showMessageDialog(null, "Se repite numero de camiseta");
				return false;
			}
		}
		
		//Validar datos
		this.getJugadores().add(new Jugador(nombre,numeroCamiseta,posicion,edad));
		
		return true;
		
	}
	
	public boolean EliminarJugador( int numeroCamiseta) {
		
		
		for (Jugador jugador : jugadores) {
			if(jugador.getNumeroCamiseta()==numeroCamiseta) {
				JOptionPane.showMessageDialog(null, "Se encontró");
				this.getJugadores().remove(this.getJugadores().indexOf(jugador));
				return true;
			}
		}
		
		
		return false;
		
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", ciudad=" + ciudad + ", foto=" + foto + ", jugadores=" + jugadores + "]";
	}

	
	
}
