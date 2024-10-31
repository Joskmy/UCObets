package co.edu.uco.bodyhealty.servicios.application.usecase;

public interface UseCaseWithReturn<D, R> {
	R execute(D domain);
}
