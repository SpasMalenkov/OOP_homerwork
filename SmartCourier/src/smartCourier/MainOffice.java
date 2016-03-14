package smartCourier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainOffice {

	private String name="VELIKOTYRNOVO";
	private Map<Reciever, List<Parcel>> recieverProtocol;
	private List<Parcel> protocols;
	private List<Worker> workerList;
	
	
	
	public MainOffice() {
		this.recieverProtocol = new HashMap<>();
	}
	
	
	public void addParcelToWorkerProtocol(Parcel parcel) {
		int size = workerList.size();
		int random = (int) (Math.random() * size);
		Protocol protocol = new Protocol(parcel.getSender(), parcel.getReciever());
		workerList.get(random).getWorkerProtocol().add(protocol);

	}

	public List<Parcel> getParcelForMainOffice() {
		ArrayList<Parcel> protocolsList = new ArrayList<Parcel>();
		protocols.clear();
		protocolsList.addAll(protocols);
		return protocolsList;

	}
	
	public void takeParcel(Parcel parcel) throws Exception {
		if (parcel != null) {
			this.protocols.add(parcel);
			this.recieverProtocol.put((Reciever) parcel.getReciever(), new LinkedList<Parcel>());
			this.recieverProtocol.get(parcel.getReciever()).add(parcel);

			addParcelToWorkerProtocol(parcel);
		} else {
			throw new Exception("e basi zada4ato 4ovek has");

		}

	}
	
	
	
	
	
	
	
	
}
