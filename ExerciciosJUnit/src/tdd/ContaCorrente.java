package tdd;

import java.util.ArrayList;

public class ContaCorrente {
	private int saldo;
	private ArrayList<Deposito> depositos;
	private String nome; 
	private int saldoInicial;

	public ContaCorrente() {
		this.saldo = 0;
		this.nome = "James Grenning";
		depositos = new ArrayList<Deposito>();
		this.saldoInicial = 0;
	}
	
	public ContaCorrente(int saldo) {
		this.saldo = saldo;
		depositos = new ArrayList<Deposito>();
		this.saldoInicial = saldo;
	}
	
	public ContaCorrente(String nome) {
		this.nome = nome;
		this.saldo = 0;
		depositos = new ArrayList<Deposito>();
		this.saldoInicial = 0;
	}
	
	public ContaCorrente(String nome, int saldo) {
		this.nome = nome;
		this.saldo = saldo;
		depositos = new ArrayList<Deposito>();
		this.saldoInicial = saldo;
	}
	
	public double saldo() {
		return this.saldo;
	}

	public void creditar(Deposito deposito) {
		this.saldo += deposito.valor;
		depositos.add(deposito);
	}
	
	public String extrato() {
		StringBuilder extrato = new StringBuilder("Conta de " + this.nome + "\n");
		
		extrato.append("Saldo Inicial $" + saldoInicial +"\n");
		extrato.append("Saldo Final $" + saldo + "\n");
		
		if(!depositos.isEmpty()) {
			for (Deposito deposito : depositos) {
				extrato.append(deposito.data.toString());
				extrato.append("\tDeposito\t$" + deposito.valor);
				extrato.append("\n");
			}
		}
		else {
			extrato.append("Nenhuma trasacao realizada\n");
		}

		return extrato.toString();
	}
	
}
