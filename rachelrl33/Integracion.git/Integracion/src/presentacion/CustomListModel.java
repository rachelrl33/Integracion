package presentacion;

import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;

import dominio.Coche;



public class CustomListModel extends AbstractListModel {
	private ArrayList<Coche> lista = new ArrayList<>();

	
	@Override
	public int getSize() {
		return lista.size();
	}
	@Override
	public Object getElementAt(int index) {
		Coche p = lista.get(index);
		return p.getNombre();
	}
	
	public void addCoche(Coche p ){
		lista.add(p);
		this.fireIntervalAdded(this, getSize(), getSize()+1);
		 }
	
	public void eliminarCoche(int index0){
		lista.remove(index0);
		this.fireIntervalRemoved(index0, getSize(), getSize()+1);
	}
	
	public Coche getCoche(int index){
		return lista.get(index);
	}
	
	
	public void modificarCoche(Coche p, int index) {
		Coche aux = lista.get(index);
		aux.setNombre(p.getNombre());
		aux.setAño(p.getAño());
		aux.setColor(p.getColor());
		aux.setPrecio(p.getPrecio());
		aux.setStock(p.getStock());
		
		lista.remove(p);
		lista.add(aux);
	}
	
	
	
	
	
}

