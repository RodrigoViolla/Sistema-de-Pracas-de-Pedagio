package br.unifae.poo.pedagio.repository;

import br.unifae.poo.pedagio.constants.Values;
import br.unifae.poo.pedagio.models.Comercial;
import br.unifae.poo.pedagio.models.Pedagio;
import br.unifae.poo.pedagio.models.UtilitarioPasseio;

public class PedagioRepository {
	// este vetor � o local aonde se armazena todos os cadastros de pedagios
	private Pedagio[] pedagios = new Pedagio[Values.NUMERO_MAX_PEDAGIO];
	// esta variavel idenntifica quantos registros de pedagio ja foram
	// armazenados no vetor "pedagios"
	// para que o limite n�o seja ultrapassado, ela � estatica porque seguue a
	// logico do vetor que
	// � pertencente a classe e n�o ao objeto.
	private int qtdPedagio = 0;

	/**
	 * Este metodo � responsavel por armazenar um novo registro de pedagio
	 * 
	 * @param pedagio
	 * @return
	 */
	public boolean add(Pedagio pedagio) {
		// a condi��o abaixo � responsavel por verificar se ainda existem
		// espa�os livres no vetor
		if (pedagios.length > qtdPedagio) {
			pedagios[qtdPedagio] = pedagio;
			qtdPedagio++;
			return true;
		}

		return false;
	}

	public Pedagio[] getPedagios() {
		return pedagios;
	}

	public boolean addUtilitarioPasseio(Pedagio pedagio, UtilitarioPasseio veiculo) {
		int index = 0;
		for (Pedagio pedagio2 : pedagios) {
			if (pedagio2.getCodigo() == pedagio.getCodigo()) {
				pedagios[index].addUtilitarioPasseio(veiculo);
				return true;
			}
			index++;
		}
		return false;
	}
	
	public boolean addComercial(Pedagio pedagio, Comercial veiculo) {
		int index = 0;
		for (Pedagio pedagio2 : pedagios) {
			if (pedagio2.getCodigo() == pedagio.getCodigo()) {
				pedagios[index].addComercial(veiculo);
				return true;
			}
			index++;
		}
		return false;
	}
}
