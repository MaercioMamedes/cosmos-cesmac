package br.cesmac.confArch;


import br.cesmac.connectors.ConectorSimples;
import br.ufal.aracomp.cosmos.emprestimo.impl.ComponentFactory;
import br.ufal.aracomp.cosmos.emprestimo.spec.dt.DTUsuario;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IEmprestimoOps;
import br.ufal.aracomp.cosmos.emprestimo.spec.prov.IManager;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;

public class Main {
	public static void main(String[] args) {
		IManager compEmp = ComponentFactory.createInstance();
		
		// instance Ilimte
		
		br.ufal.aracomp.cosmos.limite.spec.prov.IManager compLimite =  br.ufal.aracomp.cosmos.limite.impl.ComponentFactory.createInstance();
		// required interface
		
		ILimiteOps limiteOps = (ILimiteOps) compLimite.getProvidedInterface("ILimiteOps");
		
		// conector
		
		ConectorSimples conn = new ConectorSimples(limiteOps);
		
				
		compEmp.setRequiredInterface("ILimiteReq", conn);
				
		// executar interface provida
		DTUsuario user = new DTUsuario("1001");
		IEmprestimoOps empOps = (IEmprestimoOps)compEmp.getProvidedInterface("IEmprestimoOps");
		Double valor = empOps.liberarEmprestimoAutomatico(user);
		System.out.println(valor);
	}
}

