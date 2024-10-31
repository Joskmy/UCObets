package co.edu.uco.bodyhealty.servicios.domain;

public interface DomainRule<T> {
	void validate(T data);
	
}
