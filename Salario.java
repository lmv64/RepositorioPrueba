public class Salario {

	/*
	 * Si el salario bruto es menor de 1000 euros, no se aplicar� ninguna retenci�n.
	 * Para salarios a partir de 1000 euros, y menores de 1500 euros se les aplicar�
	 * un 16%, y a los salarios a partir de 1500 euros se les aplicar� un 18%. El
	 * m�todo nos devolver� salarioBruto * (1-retencion), o una excepci�n si el
	 * salario es menor que cero.
	 */
	public double calculaSalarioNeto(double salarioBruto) throws IllegalArgumentException {
		double retencion = 0;

		if (salarioBruto < 0) {
			throw new IllegalArgumentException("El salario no puede ser menor que cero");
		}

		if (salarioBruto >= 1000 && salarioBruto < 1500) {
			retencion = 0.16;
		} else if (salarioBruto >= 1500) {
			retencion = 0.18;
		}

		return salarioBruto * (1 - retencion);
	}

	/*
	 * El salario base ser� 1000 euros si el empleado es de tipo "vendedor",
	 *  y de 1500 euros si es de tipo "encargado". 
	 *  A esta cantidad se le sumar� una prima de 100 euros si ventasMes 
	 *  es mayor o igual que 1000 euros, y de 200 euros si fuese al menos 
	 *  de 1500 euros. Por �ltimo, cada hora extra se pagar� a 20 euros. 
	 *  Si tipo es vac�o, o ventasMes o horasExtra toman valores negativos 
	 *  el m�todo lanzar� una excepci�n .
	 */
	public double calculaSalarioBruto(String tipo, double ventasMes, double horasExtra)
			throws IllegalArgumentException {
		if (tipo == null || tipo.isEmpty() || ventasMes < 0 || horasExtra < 0) {
			throw new IllegalArgumentException("Los datos proporcionados son inv�lidos");
		}
		double salarioBase;
		double primaVentas = 0;
		final double salarioPorHoraExtra = 20;
		if (tipo.equals("vendedor")) {
			salarioBase = 1000;
		} else if (tipo.equals("encargado")) {
			salarioBase = 1500;
		} else {
			throw new IllegalArgumentException("Tipo de empleado desconocido");
		}
		if (ventasMes >= 1000 && ventasMes < 1500) {
			primaVentas = 100;
		} else if (ventasMes >= 1500) {
			primaVentas = 200;
		}
		return salarioBase + primaVentas + (horasExtra * salarioPorHoraExtra);
	}

}
