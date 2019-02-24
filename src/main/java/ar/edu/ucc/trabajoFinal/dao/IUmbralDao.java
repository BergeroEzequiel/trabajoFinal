package ar.edu.ucc.trabajoFinal.dao;

import java.util.List;

import ar.edu.ucc.trabajoFinal.model.Umbral;

public interface IUmbralDao extends DaoGenerico<Umbral, Long>{
	
	public Umbral getUmbralGenericoByVariable(String nombreVariable);

	public List<Umbral> getUmbralesEspByNodo(Long idNodo);
	
	public List<Umbral> getUmbralesGenericos();
        
        /**
         * Este método pone activo = false.
         * La razón es que no se puede eliminar un umbral especifico ya que tiene restriccion
         * de clave foránea con alertas.
         * Devuelve el umbral Genérico que pertenezca a la variable del especifico desactivado.
         * @param id
         */
        public Umbral deleteUmbralEspecifico(Long id);
	
}
