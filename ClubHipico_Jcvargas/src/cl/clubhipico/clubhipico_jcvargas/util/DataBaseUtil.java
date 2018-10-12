package cl.clubhipico.clubhipico_jcvargas.util;

import java.util.List;

import cl.clubhipico.clubhipico_jcvargas.controller.BaseController;

public class DataBaseUtil<T> implements BaseController<T> {

	@Override
	public boolean insert(T object) {
		// TODO Auto-generated method stub
		System.out.println("Insert " + object);
		return true;
	}

	@Override
	public boolean update(T object) {
		// TODO Auto-generated method stub
		System.out.println("Update " + object);
		return true;
	}

	@Override
	public boolean delete(T object) {
		// TODO Auto-generated method stub
		System.out.println("Delete " + object);
		return true;
	}

	@Override
	public T select(T object) {
		// TODO Auto-generated method stub
		System.out.println("Select " + object);
		return null;
	}

	@Override
	public List<T> list(T object) {
		// TODO Auto-generated method stub
		System.out.println("List " + object);
		return null;
	}

	@Override
	public List<T> list() {
		// TODO Auto-generated method stub
		System.out.println("List ");
		return null;
	}
	

}
