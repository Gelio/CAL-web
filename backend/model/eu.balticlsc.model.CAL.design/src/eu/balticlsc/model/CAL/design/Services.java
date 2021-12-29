package eu.balticlsc.model.CAL.design;

import org.eclipse.emf.ecore.EObject;

import eu.balticlsc.model.CAL.ApplicationDataPin;
import eu.balticlsc.model.CAL.ConnectableDataPin;
import eu.balticlsc.model.CAL.DataBinding;
import eu.balticlsc.model.CAL.DataPin;
import eu.balticlsc.model.CAL.Multiplicity;

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

    	var targetConnectableDataPin = (ConnectableDataPin) target;
    	var targetDataPin = targetConnectableDataPin.getDataPin();
    	var sourceConnectableDataPin = (ConnectableDataPin) source;

    	var onDifferentUnitCalls = sourceConnectableDataPin.eContainer() != targetConnectableDataPin.eContainer() ||
    			// Allow connecting ApplicationDataPins directly to each other
    			source instanceof ApplicationDataPin;

    	var targetIncomingDataFlow = targetConnectableDataPin.getIncoming();

    	return targetDataPin.getBinding() == DataBinding.REQUIRED &&
    			// Allows using this function when reconnecting the source of DataFlow
    			(targetIncomingDataFlow == null || targetIncomingDataFlow == self) &&
    			onDifferentUnitCalls;
    }

    public String getDataPinIconPath(EObject self) {
    	if (!(self instanceof DataPin)) {
    		return null;
    	}

    	var dataPin = (DataPin) self;
    	var dataPart = dataPin.getDataMultiplicity() == Multiplicity.SINGLE ? "single-data" : "multiple-data";
    	var tokenPart = dataPin.getTokenMultiplicity() == Multiplicity.SINGLE ? "single-token" : "multiple-tokens";

    	return dataPart + "-" + tokenPart + ".png";
    }
}
