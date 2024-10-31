package co.edu.uco.bodyhealty.servicios.application.usecase;

public interface UseCaseWithoutReturn<D> {
	void execute(D domain);
}
