package dominio;

public class Coche {
	private String nombre, color, año, precio, stock;


	public Coche(String nombre, String color, String año, String precio, String stock) {
		
		this.nombre = nombre;
		this.color = color;
		this.año = año;
		this.precio = precio;
		this.stock = stock;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getAño() {
		return año;
	}


	public void setAño(String año) {
		this.año = año;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public String getStock() {
		return stock;
	}


	public void setStock(String stock) {
		this.stock = stock;
	}
	
}