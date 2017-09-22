package br.unifae.poo.pedagio.models;


/**
 * Esta classe � a especializa��o da classe pai veiculo
 * 
 * @author Vinicius Ricardo Zoqueti
 * @author Nicolas
 */
public class Comercial extends Veiculo {
	//esta variavel espesifica o numero de eixos que o veiculo comercial contem 
	private int numeroEixos;
	/**
	 * este construtor � responsavel por alimentar o objeto com as informa��es necessarias/obrigatorias
	 * 
	 * @param placa
	 * @param numeroEixos
	 */
	public Comercial(String placa, int numeroEixos) {
		super(placa);
		this.numeroEixos = numeroEixos;
	}

	/**
	 * este metodo � responsavel por recuperar o numero de eixos atribuidos ao objeto
	 * 
	 * @return
	 */
	public int getNumeroEixos() {
		return numeroEixos;
	}

	/**
	 * este metodo faz o calculo do valor cobrado por eixo no pedagio vezes o numero de eixos do veiculo
	 */
	@Override
	public void calculaValor(double valorEixo) {

		super.calculaValor((valorEixo * numeroEixos));

	}
	
	

}
