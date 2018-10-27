package br.com.prontuario.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.com.prontuario.model.Paciente;

public class PacienteTableModel extends AbstractTableModel{

	private final int colNome = 0;
	private final int colQuarto = 1;
	private final int colLeito = 2;
	private final int colId = 3;

	private ArrayList<Paciente> listaPaciente = new ArrayList<Paciente>();

	//Construtores
	public PacienteTableModel() {
		listaPaciente.clear();
	}

	public PacienteTableModel(ArrayList<Paciente> listaPaciente) {
		this.listaPaciente.clear();
		this.listaPaciente.addAll(listaPaciente);
	}

	//Métodos de acesso
	public ArrayList<Paciente> getListaPaciente(){
		return listaPaciente;
	}

	public void setListaPaciente(ArrayList<Paciente> listaPaciente) {
		this.listaPaciente = listaPaciente;
		fireTableDataChanged();
	}

	public Paciente getPaciente(int indice) {
		if(indice< 0 || indice >= listaPaciente.size()){
			return null;
		}
		return listaPaciente.get(indice);
	}

	@Override
	public int getRowCount() {
		return this.listaPaciente.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Paciente paciente = listaPaciente.get(rowIndex);
		Object valorCel = null;

		if(columnIndex == colNome) {
			valorCel = paciente.getNome();
		}
		if(columnIndex == colQuarto) {
			valorCel = paciente.getQuarto();
		}
		if(columnIndex == colLeito) {
			valorCel = paciente.getLeito();
		}if(columnIndex == colId) {
			valorCel = paciente.getId();
		}

		return valorCel;
	}

	public String getColumnName(int column) {

		if(column == colNome) {
			return "Nome";
		}else if(column == colQuarto) {
			return "Quarto";
		}else if(column == colLeito) {
			return "Leito";
		}else if(column == colId) {
			return "ID";
		}

		return "";
	}

}
