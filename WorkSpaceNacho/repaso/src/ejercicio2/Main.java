package ejercicio2;

public class Main {
	/*
	 * 2. Escriba un programa que visualice el precio final de compra de una
	 * camiseta cuyo precio es 15€. La camiseta tiene un descuento del 20% y el IVA
	 * aplicable es del 17% La salida tendrá el siguiente formato: Artículo:
	 * Camiseta Precio base: 15€ Descuento aplicado: 3€ Importe con IVA: 14.04
	 */

	public static void main(String[] args) {
		Articulo articulo=new Articulo("Camiseta",15,0.20,0.17);
		System.out.println("Articulo : "+articulo.getDescripcion());
		System.out.println("Precio base : "+articulo.getPrecio()+" €");
		System.out.println("Descuento aplicado : "+articulo.descuentoAplicado()+" €");
		System.out.println("Importe IVA incluido : "+articulo.precioConDescuentoIVA()+" €");
	}

}
