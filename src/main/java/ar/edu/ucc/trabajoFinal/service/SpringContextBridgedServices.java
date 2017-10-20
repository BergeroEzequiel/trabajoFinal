package ar.edu.ucc.trabajoFinal.service;

public interface SpringContextBridgedServices {
	UmbralService getUmbralService();
	AlertaService getAlertaService();
	<T> T getService(Class<T> serviceType);
}
