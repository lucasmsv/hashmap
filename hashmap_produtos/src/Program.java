import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Map<Integer, Produtos> produtos = new HashMap<Integer, Produtos>();
		
		Scanner input = new Scanner(System.in);
		
		String login, logincadastrado, senha, senhacadastrada, nome, categoria, confirmar_info;
		Double preco;
		Integer op_menu, codigo;

		Calendar cal=Calendar.getInstance();
		Integer hora = cal.get(Calendar.HOUR);
		Integer minuto = cal.get(Calendar.MINUTE);
		Integer segundos = cal.get(Calendar.SECOND);
		String horario = hora + ":" + minuto + ":" + segundos;

		logincadastrado = "";
		senhacadastrada = "";
		
		do
		{
			System.out.print("Login: ");
			login = input.nextLine();
			
			System.out.print("Senha: ");
			senha = input.nextLine();
			
			System.out.print("\n");
		} 
		while (!login.equals(logincadastrado) || !senha.equals(senhacadastrada));
		
		do
		{
			System.out.print("[1] Novo Produto \n[2] Ver Produtos \n[0] Sair \nOpção: ");
			op_menu = Integer.parseInt(input.nextLine());
			System.out.print("\n");

			switch (op_menu)
			{
				case 1:
					System.out.print("Código: ");
					codigo = Integer.parseInt(input.nextLine());
					
					System.out.print("Nome: ");
					nome = input.nextLine();

					System.out.print("Categoria: ");
					categoria = input.nextLine();

					System.out.print("Preço: R$ ");
					preco = Double.parseDouble(input.nextLine());

					System.out.print("\nDeseja confirmar essas informações? (s/n): ");
					confirmar_info = input.nextLine();

					if (confirmar_info.equalsIgnoreCase("s"))
					{
						produtos.put(codigo, new Produtos(nome, categoria, preco, horario));
						System.out.println("\n\t[Dados salvos com sucesso]\n");
					}
					else
					{
						System.out.println("\n\t[Dados não foram salvos]\n");
					}
				break;

				case 2:
					System.out.print(produtos+ "\n\n");
				break;
			}
		}
		while (op_menu != 0);
		
		input.close();

	}

}


class Produtos{
	
	String nome, categoria;
	Integer codigo, hora, minuto, segundos;
	Double preco;
	String horario = hora + ":" + minuto + ":" + segundos;
	
	public Produtos(String nome, String categoria, Double preco, String horario) 
	{
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
		this.horario = horario;
	}
	
	public String toString() 
	{
		return " | Nome: " + nome + " | Categoria: " + categoria + " | Preço: R$ " + preco + " | Horario Cadastro: " + horario + "\n";
	}
}
