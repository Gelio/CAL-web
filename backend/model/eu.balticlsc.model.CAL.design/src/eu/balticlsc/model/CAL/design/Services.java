package eu.balticlsc.model.CAL.design;

import org.eclipse.emf.ecore.EObject;

import eu.balticlsc.model.CAL.ApplicationDataPin;
import eu.balticlsc.model.CAL.ConnectableDataPin;
import eu.balticlsc.model.CAL.DataBinding;

/**
 * The services class used by VSM.
 */
public class Services {

    /**
    * See http://help.eclipse.org/neon/index.jsp?topic=%2Forg.eclipse.sirius.doc%2Fdoc%2Findex.html&cp=24 for documentation on how to write service methods.
    */
    public EObject myService(EObject self, String arg) {
       // TODO Auto-generated code
      return self;
    }

    public boolean isValidEdgeSource(EObject self, EObject source) {
    	if (source instanceof ConnectableDataPin) {
        	// TODO: check if it handles nulls
    		var connectableDataPin = (ConnectableDataPin) source;
    		return connectableDataPin.getDataPin().getBinding() == DataBinding.PROVIDED &&
    				connectableDataPin.getOutgoing() == null;
    	}
    	return false;
    }

    public boolean isValidEdgeTarget(EObject self, EObject source, EObject target) {
    	if (!(source instanceof ConnectableDataPin) || !(target instanceof ConnectableDataPin)) {
    		return false;
    	}

    	// TODO: check if it handles nulls
    	var targetConnectableDataPin = (ConnectableDataPin) target;
    	var targetDataPin = targetConnectableDataPin.getDataPin();
    	var sourceConnectableDataPin = (ConnectableDataPin) source;
    	var sourceDataPin = sourceConnectableDataPin.getDataPin();

    	var sourceContainer = sourceDataPin.eContainer();
    	var onDifferentUnitCalls = sourceContainer != targetDataPin.eContainer() ||
    			// Allow connecting ApplicationDataPins directly
    			source instanceof ApplicationDataPin;

    	var targetIncomingDataFlow = targetConnectableDataPin.getIncoming();

    	return targetDataPin.getBinding() == DataBinding.REQUIRED &&
    			// Allows using this function when reconnecting the source of DataFlow
    			(targetIncomingDataFlow == null || targetIncomingDataFlow == self) &&
    			onDifferentUnitCalls;
    }
}
