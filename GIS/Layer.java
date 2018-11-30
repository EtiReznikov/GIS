package GIS;

import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class Layer extends HashSet<GisElement>implements GIS_layer{

	private Long creation_Time;

	private static final long serialVersionUID = 1L;

	@Override
	public Metadata get_Meta_data() {
		Metadata metadata=new Metadata(creation_Time);
		return metadata;
	}

	public Layer() {
		this.creation_Time=System.currentTimeMillis();
	}







}
