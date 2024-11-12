package co.edu.uco.bodyhealty.servicios.application.primaryports.interactor;

public interface InteractorWithoutReturnPut <S ,T> {
	void execute (S id, T data);
}