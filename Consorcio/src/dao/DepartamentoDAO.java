package dao;

import java.util.List;

import entidades.Departamento;
import exceptions.EntidadException;

public interface DepartamentoDAO {

	public void insertarDepartamento(Departamento d) throws EntidadException;
	public void deleteDepartamento(int piso, String depto) throws EntidadException;
	public void updateDepartamento(Departamento d, int piso, String depto) throws EntidadException;
	public Departamento getUnDepartamento(int piso, String depto) throws EntidadException;
	public List<Departamento> getDatosDepto() throws EntidadException;
		
//	public List getAllDepartamentos();

}


