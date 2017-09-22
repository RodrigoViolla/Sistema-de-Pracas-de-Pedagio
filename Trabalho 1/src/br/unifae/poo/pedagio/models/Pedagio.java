package br.unifae.poo.pedagio.models;

import br.unifae.poo.pedagio.constants.Values;

public class Pedagio {
	// esta variavel � responsavel por armazenar o ultimo codigo que foi gerado
	// ao
	// se inserir um registro de pedagio, para que o codigo nunca se repita,
	// ele � estatico devido a ele pertencer a classe n�o ao objeto.
	private static int ultimoCodigo;
	// esta variavel � responsavel pela identifica��o unica de cada registro .
	private int codigo;
	// esta variavel � responsavel por armazenar o nome de cada pra�a de
	// pedagio.
	private String nome;
	// esta variavel � responsavel por armazenar o local aonde se encontra a
	// pra�a(o edere�o).
	private String local;
	// esta variavel � responsavel por defiinir o valor a ser cobrado por eixo
	// naquela pra�a de pedagio
	private double valorEixo;
	// Este vetor � responsavel por armazenar os veiculos dos tipos
	// utilitarios/passeio
	private UtilitarioPasseio[] utilitarioPasseio = new UtilitarioPasseio[Values.NUMERO_MAX_VEICULOS];
	// Este vetor � responsavel por armazenar os veiculos do tipo Comercial
	private Comercial[] comercial = new Comercial[Values.NUMERO_MAX_VEICULOS];
	// esta variavel identifica quantos veiculos dos tipos Utilitario/Passeio j�
	// foram armazenados
	// no objeto para que n�o ultrapasse o limite de vetor "utilitarioPasseio"
	private int qtdUtilitarioPasseio = 0;
	// esta variavel identifica quantos veiculos do tipo Comercial j� foram
	// armazenados
	// no objeto para que n�o ultrapasse o limite de vetor "comercial"
	private int qtdComercial = 0;

	/**
	 * Este contrutor armazena as infor��es obrigatorias do objeto pedagio
	 * 
	 * @param nome
	 * @param local
	 * @param valorEixo
	 */
	public Pedagio(String nome, String local, double valorEixo) {
		this.codigo = ++ultimoCodigo;// acrescenta um novo codigo impedindo que
										// ele se repita
		this.nome = nome;// nome da pra�a
		this.local = local;// local aonde a pra�a de pedagio se encontra
		this.valorEixo = valorEixo;// valor cobrado por eixo
	}

	/**
	 * Este metodo � responsavel por adicionar veiculos dos tipos
	 * Utilitario/Passeio ao objeto pedagio.
	 * 
	 * @param veiculo
	 * @return
	 */
	public boolean addUtilitarioPasseio(UtilitarioPasseio veiculo) {
		// o metodo abaixo esta passando o valor por eixo para ser calculado o
		// total a se pagar
		veiculo.calculaValor(valorEixo);

		// a condi��o abaixo � responsavel por verificar se ainda existem
		// espa�os livres no vetor
		if (utilitarioPasseio.length > qtdUtilitarioPasseio) {
			utilitarioPasseio[qtdUtilitarioPasseio] = veiculo;
			qtdUtilitarioPasseio++;
			return true;
		}
		return false;

	}

	/**
	 * Este metodo � responsavel por adicionar veiculos do tipo Comercial ao
	 * objeto pedagio.
	 * 
	 * @param veiculo
	 * @return
	 */

	public boolean addComercial(Comercial veiculo) {
		// o metodo abaixo esta passando o valor por eixo para ser calculado o
		// total a se pagar
		veiculo.calculaValor(valorEixo);
		// a condi��o abaixo � responsavel por verificar se ainda existem
		// espa�os livres no vetor
		if (comercial.length > qtdComercial) {
			comercial[qtdComercial] = veiculo;
			qtdComercial++;
			return true;
		}
		return false;
	}

	/**
	 * Este metodo � responsavel por recuperar o codigo atribuido ao objeto
	 * pedagio
	 * 
	 * @return
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * Este metodo � responsavel por recuperar o nome atribuido ao objeto
	 * pedagio
	 * 
	 * @return
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Este metodo � responsavel por recuperar o local(Endere�o) atribuido ao
	 * objeto pedagio
	 * 
	 * @return
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * Este metodo � responsavel por recuperar o valor por eixo atribuido ao
	 * objeto pedagio
	 * 
	 * @return
	 */
	public double getValorEixo() {
		return valorEixo;
	}

	/**
	 * Recupera todos os veiculos Utilitario/Passeio que foram registrados no
	 * objeto
	 * 
	 * @return
	 */
	public UtilitarioPasseio[] getUtilitarioPasseio() {
		return utilitarioPasseio;
	}

	/**
	 * Recupera todos os veiculos Comerciais que foram registrados no objeto
	 * 
	 * @return
	 */
	public Comercial[] getComercial() {
		return comercial;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		builder.append("C�digo: ").append(String.valueOf(this.codigo))
				.append("\t");
		builder.append("Local: ").append(this.local).append("\n");
		

		return builder.toString();
	}

}
