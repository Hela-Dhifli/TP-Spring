package fr.sorbonne.paris.nord.university.api.Factory;

public interface EntityFactory <E, D>{
	
	E toEntity(D dto);
	D toDto(E entity);

}
