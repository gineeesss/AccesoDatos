package ejercicio2;
public class Articulo {
	private String descripcion;
	private double precio;
	private double descuento;
	private double iva;
	public Articulo() {	}
	public Articulo(String descripcion, double precio, double descuento, double iva) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.descuento = descuento;
		this.iva = iva;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	//Funcionalidades
	//método de aplicar descuento
	public double descuentoAplicado() {
		return precio*descuento; // si el precio es 70 el secuanto 10% = 7€
	}
	//IVA APLICADO
	public double ivaAplicado() {
		return precio*iva;
		
	}
	//precio ya con el descuento
	public double precioConDescuento() {
		return precio*(1-descuento);//70*(1-0,10)=70*(0,9)=63€
		}
	//precio ya con el descuento y con el IVA
	public double precioConDescuentoIVA() {
		return precio*(1-descuento)*(1+iva);//63€*(1+0.20)=63+12,6=75,6€
	}
	
	

}
