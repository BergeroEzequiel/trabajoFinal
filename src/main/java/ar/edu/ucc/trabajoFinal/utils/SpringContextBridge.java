package ar.edu.ucc.trabajoFinal.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import ar.edu.ucc.trabajoFinal.service.AlertaService;
import ar.edu.ucc.trabajoFinal.service.NodoService;
import ar.edu.ucc.trabajoFinal.service.SpringContextBridgedServices;
import ar.edu.ucc.trabajoFinal.service.UmbralService;

@Component 
public class SpringContextBridge 
        implements SpringContextBridgedServices, ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Autowired
    private NodoService nodoService;
    
    @Autowired
    private UmbralService umbralService;
    
    @Autowired
    private AlertaService alertaService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) 
            throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * A static method to lookup the SpringContextBridgedServices Bean in 
     * the applicationContext. It is basically an instance of itself, which 
     * was registered by the @Component annotation.
     *
     * @return the SpringContextBridgedServices, which exposes all the 
     * Spring services that are bridged from the Spring context.
     */
    public static SpringContextBridgedServices services() {
        return applicationContext.getBean(SpringContextBridgedServices.class);
    }

	@Override
	public UmbralService getUmbralService() {
		return this.umbralService;
	}

	@Override
	public <T> T getService(Class<T> serviceType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlertaService getAlertaService() {
		return this.alertaService;
	}

	@Override
	public NodoService getNodoService() {
		return this.nodoService;
	}

}
