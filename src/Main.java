import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		GestorEquipo chiki = new GestorEquipo();
		chiki.getEquipos().add(new Equipo("River","Nuñez","river.jpg"));
		chiki.getEquipos().add(new Equipo("Boca","La boca","boqueeee.png"));
		chiki.getEquipos().add(new Equipo("Racing","Avellaneda",""));
		chiki.getEquipos().add(new Equipo("Independiente","Avellaneda",""));
		chiki.getEquipos().get(0).getJugadores().add(new Jugador("Gamaliel",1,"",22));
		chiki.getEquipos().get(0).getJugadores().add(new Jugador("Natanael",2,"",22));
		chiki.getEquipos().get(0).getJugadores().add(new Jugador("Quiroz",3,"",22));

		String[] equipos = new String[chiki.getEquipos().size()];
		
		for (int i = 0; i < chiki.getEquipos().size(); i++) {
			equipos[i] = chiki.getEquipos().get(i).getNombre();
		}
		
		do {
			
		String seleccion = (String) JOptionPane.showInputDialog(null, "Posición", null, 0, null, equipos, equipos[0]);
		
		Equipo seleccionado=chiki.Buscar(seleccion );
		
		int opcion =0;
		do {
				
			String[] opciones = {"Agregar","Eliminar","Salir"}; 
			opcion = JOptionPane.showOptionDialog(null, seleccionado, seleccion,JOptionPane.DEFAULT_OPTION, opcion, new ImageIcon(Main.class.getResource(seleccionado.getFoto()), opciones[0]), opciones, opcion);
			
			switch (opcion) {
			case 0:
				
				String[] posiciones = {"Arquero","Delantero","Mediocampista","Defensor"};
				String posicion = (String) JOptionPane.showInputDialog(null, "Posición", null, 0, null, posiciones, posiciones[0]);
				String nombre = JOptionPane.showInputDialog("Ingrese nombre");
				int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese edad"));
				int camiseta = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero camiseta"));
				if(	seleccionado.AgregarJugador( nombre, camiseta,  posicion,  edad)) {
					JOptionPane.showMessageDialog(null, "Se pudo agregar!");
				}else {
					JOptionPane.showMessageDialog(null, "No se pudo agregar");
					
				}
				break;
			case 1:
				
				if( seleccionado.getJugadores().size() ==0) {
					JOptionPane.showMessageDialog(null, "No hay jugadores");
				}else {
					String[] jugadores = new String[seleccionado.getJugadores().size()];
					for (int i = 0; i < seleccionado.getJugadores().size(); i++) {
						jugadores[i]= Integer.toString(seleccionado.getJugadores().get(i).getNumeroCamiseta());
					}
					 String jugadorselect = (String) JOptionPane.showInputDialog(null,"",null,1, null, jugadores, jugadores[0]);
					if(seleccionado.EliminarJugador(Integer.parseInt(jugadorselect))) {
						JOptionPane.showMessageDialog(null, "Se pudo eliminar");
						
					}else {
						JOptionPane.showMessageDialog(null, "No se pudo eliminar");
	
					}
				}
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Salir");
				break;
				
			default:
				break;
			}
		} while (opcion!=2);
		
		} while (true);
	}

}
