package co.edu.uco.bodyhealty.servicios.application.primaryports.interactor;

public interface InteractorWithReturn<T, R> {
	R execute (T data);
}
