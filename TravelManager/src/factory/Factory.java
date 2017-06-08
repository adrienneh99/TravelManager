package factory;

import javax.naming.Context;
import javax.naming.InitialContext;

import exceptions.ServiceLoadException;
import services.IService;

/**
 * @author adrienne2
 *
 */
public class Factory {
	
	private Factory() {
    }
	
    private static Factory factory = new Factory();

    /**
     * @return factory - a new instance of Factory
     */
    public static Factory getInstance() {
        return factory;
    }

    /**
     * @param serviceName
     * @return
     * @throws ServiceLoadException
     */
    public IService getService(String serviceName) throws ServiceLoadException {
        try {
        	String implName = getImplName(serviceName);
            Class<?> c = Class.forName(implName);
            return (IService) c.newInstance();
        } catch (Exception excp) {
            serviceName = serviceName + " not loaded";
            throw new ServiceLoadException(serviceName, excp);
        }
    }

    private String getImplName(String serviceName) throws Exception {
		Context iniCtx = new InitialContext();
		Context envCtx = (Context) iniCtx.lookup("java:comp/env");
		return (String)envCtx.lookup(serviceName);
    }

}
