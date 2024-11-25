package ejercicio2;

public class Articulo {
	private String nomnbre;
	private double precio;
	private double descuento;
	private double iva;
	public Articulo(String nomnbre, double precio, double descuento, double iva) {
		this.nomnbre = nomnbre;
		this.precio = precio;
		this.descuento = descuento;
		this.iva = iva;
	}
	public Articulo() {}
	public String getNomnbre() {
		return nomnbre;
	}
	public void setNomnbre(String nomnbre) {
		this.nomnbre = nomnbre;
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
	@Override
	public String toString() {
		return "Articulo [nomnbre=" + nomnbre + ", precio=" + precio + ", descuento=" + descuento + ", iva=" + iva
				+ "]";
	}
	//funcionalidades
	//descuento aplicado
	public double descuentoAplicado() {return precio*this.descuento;}
	
	//iva aplicado
	public double ivaAplicado() {return precio*this.iva;}
	//precio final
	public double precioDescontado() {
		return precio*(1-this.descuento);	
	}
	public double precioFinal() {
		return precio*(1-this.descuento)*(1-this.iva);
	}
	
	
}
