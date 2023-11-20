package br.cesmac.connectors;

import br.ufal.aracomp.cosmos.emprestimo.spec.dt.DTUsuario;
import br.ufal.aracomp.cosmos.emprestimo.spec.req.ILimiteReq;
import br.ufal.aracomp.cosmos.limite.spec.dt.DTCliente;
import br.ufal.aracomp.cosmos.limite.spec.prov.ILimiteOps;

public class ConectorSimples implements ILimiteReq{
	
	private ILimiteOps limiteOps;
	
	// construtor
	public ConectorSimples(ILimiteOps limiteOps) {
		this.limiteOps = limiteOps;
	}

	@Override
	public double estimarLimite(DTUsuario usuario) {
			
	DTCliente cliente = new DTCliente(Double.parseDouble(usuario.rendimentos()));
	
		
		return limiteOps.calcularLimite(cliente);
	}
	
}
