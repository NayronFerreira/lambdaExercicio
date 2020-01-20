package entidade;

import java.util.Set;
import java.util.function.Predicate;

public class Funcionario  implements Comparable<Funcionario>{

	private String nome;
	private String email;
	private double salario;
	
	public Funcionario (String nome, String email, double salario) {
		this.nome=nome;
		this.email=email;
		this.salario=salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(salario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (Double.doubleToLongBits(salario) != Double.doubleToLongBits(other.salario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario: " + nome + ", email: " + email + ", salario: " + salario;
	}


	@Override
	public int compareTo(Funcionario outro) {
		return email.compareTo(outro.getEmail());
	}
	
	public static double somar(Set <Funcionario> set, Predicate<Funcionario> fun) {
		double soma = 0; 
		
		for(Funcionario x: set) {
			if(fun.test(x)) {
			soma= soma+	x.getSalario();
			}
		}
		
		
		return soma;
	}
	
	
}
