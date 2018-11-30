package GIS;

import java.util.HashSet;
import java.util.Iterator;

public class Project extends HashSet<GisElement> implements GIS_layer{

	private Long creation_Time;
	private static final long serialVersionUID = 1L;

	@Override
	public Metadata get_Meta_data() {
		Metadata metadata=new Metadata(creation_Time);
		return metadata;
	}
	public boolean add(Layer layer) {
		Iterator<GisElement> iter=layer.iterator(); 
		while (iter.hasNext())
			this.add(iter.next());
		return true;
	}


	public Project() {
		this.creation_Time=System.currentTimeMillis();
	}

	

}
