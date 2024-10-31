package co.edu.uco.bodyhealty.servicios.application.primaryports.interactor;

public interface InteractorWithoutReturn<T> {
	void execute (T data);
}
