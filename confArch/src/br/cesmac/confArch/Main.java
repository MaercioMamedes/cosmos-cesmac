package br.cesmac.confArch;


import java.util.ArrayList;

import br.cesmac.connectors.ConectorSimples;
import br.ufal.aracomp.cosmos.emprestimo.impl.ComponentFactory;
import br.ufal.aracomp.cosmos.emprestimo.spec.dt.DTUsuario;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IEmprestimoOps;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;

public class Main {
	public static void main(String[] args) {
		
		// Instanciando Interface Limite(Componente Limite)
		br.ufal.aracomp.cosmos.limite.spec.prov.IManager compLimite = br.ufal.aracomp.cosmos.limite.impl.ComponentFactory.createInstance();
		
		// Intanciando interface provida do Componente Limite
		ILimiteOps limiteOps = (ILimiteOps) compLimite.getProvidedInterface("ILimiteOps");
		
		// conector ILimite(provida) -> IEmprestimo(requerida)
		ConectorSimples conn = new ConectorSimples(limiteOps);
		
		// instanciando Interface Emprestimo(Componente Empréstimo)
		IManager compEmp = ComponentFactory.createInstance();
				
		// Estabelencendo coesão entre os componentes a partir do conector
		compEmp.setRequiredInterface("ILimiteReq", conn);
		
		// instanciando interface Provida do Componente Empréstimo
		IEmprestimoOps empOps = (IEmprestimoOps)compEmp.getProvidedInterface("IEmprestimoOps");
		
		// Instanciando casos de uso
		String salario1 = "1000";
		String salario2 = "1001";
		String salario3 = "1002";
		String salario4 = "1003";
		String salario5 = "1010,50";
		
		DTUsuario usuario1 = new DTUsuario(salario1);
		DTUsuario usuario2 = new DTUsuario(salario2);
		DTUsuario usuario3 = new DTUsuario(salario3);
		DTUsuario usuario4 = new DTUsuario(salario4);
		DTUsuario usuario5 = new DTUsuario(salario5);
		
		// criando lista de usuários		
		ArrayList<DTUsuario> listaUsuarios = new ArrayList<>();
		
		listaUsuarios.add(usuario1);
		listaUsuarios.add(usuario2);
		listaUsuarios.add(usuario3);
		listaUsuarios.add(usuario4);
		listaUsuarios.add(usuario5);
		

		// Calculando empréstimos liberadoss para os usuários
		Integer cont = 1;
		for (DTUsuario usuario: listaUsuarios) {
			Double valor = empOps.liberarEmprestimoAutomatico(usuario);
			System.out.println("Empréstimo liberado para o usuario"+cont+": " + valor);
			cont++;
		}
		
		
	}
}

