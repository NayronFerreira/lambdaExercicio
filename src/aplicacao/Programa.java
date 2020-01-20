package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import entidade.Funcionario;

public class Programa {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		String arq = "C:\\Users\\Nayron\\Downloads\\lambda.txt";
		Set<Funcionario> set = new TreeSet<>();

		try (BufferedReader bf = new BufferedReader(new FileReader(arq))) {

			System.out.println("Informe o salário minimo: ");
			double sal = leia.nextDouble();

			String linha = bf.readLine();

			while (linha != null) {
				String[] vet = linha.split(",");
				Funcionario func = new Funcionario(vet[0], vet[1], Double.parseDouble(vet[2]));
				set.add(func);
				linha = bf.readLine();
			}

			set.stream().filter(x -> x.getSalario() >= sal).map(x->x.getEmail()).forEach(System.out::println);
			

			System.out.println("Informe a primeira letra dos nomes que deseja filtra a soma dos salários: ");

			char letra = leia.next().charAt(0);

			System.out.println("Soma dos funcionários que começam com a letra " + letra + ": "
					+ Funcionario.somar(set, x -> x.getNome().charAt(0) == letra));

		} catch (IOException x) {
		}
		leia.close();

	}
}
