package bo;

import java.util.List;

import dao.DepartamentoDAO;
import entidades.Departamento;
import exceptions.EntidadException;

public class DepartamentoBO {

	private DepartamentoDAO deptoDao;
			
		public void insertarDepartamento(Departamento depto) throws EntidadException {
			deptoDao.insertarDepartamento(depto);
		}
		
		public void deleteDepartamento(int piso, String depto)throws EntidadException{
			deptoDao.deleteDepartamento(piso, depto);
		}
			
		
		public void updateDepartamento(Departamento d, int piso, String depto)throws EntidadException{
			deptoDao.updateDepartamento(d, piso, depto);
		}
		
		
		public Departamento getUnDepartamento(int piso, String depto) throws EntidadException{
			return deptoDao.getUnDepartamento(piso, depto);
		}
		
		public List<Departamento> getDatosDepto()throws EntidadException {
			return deptoDao.getDatosDepto();
		}
		
				
		public void setDao(DepartamentoDAO deptoDao) {
			this.deptoDao = deptoDao;
		}
				
		

}
