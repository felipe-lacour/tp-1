import java.util.LinkedList;

public class GestorEquipo {

	private LinkedList<Equipo> Equipos = new LinkedList<Equipo>();

	public LinkedList<Equipo> getEquipos() {
		return Equipos;
	}

	public void setEquipos(LinkedList<Equipo> equipos) {
		Equipos = equipos;
	}

	@Override
	public String toString() {
		return "GestorEquipo [Equipos=" + Equipos + "]";
	}

	public Equipo Buscar(String nombre) {
		for (int i = 0; i < this.getEquipos().size(); i++) {
			if(this.getEquipos().get(i).getNombre().equals(nombre)) {
				return this.getEquipos().get(i);
			}
		}
		return null;
	}

}
