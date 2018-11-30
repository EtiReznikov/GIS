package GIS;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;

public class GisElement implements GIS_element {
	private Metadata metadata;
	
	public GisElement( Metadata metadata) {
		this.setMetadata(metadata);
	}
	public GisElement( GisElement gis) {
		this.setMetadata(gis.getMetadata());
	}



	@Override
	public Geom_element getGeom() {
		return this.metadata.getPoint();
	}

	@Override
	public Meta_data getData() {
		return this.metadata;
	}

	@Override
	public void translate(Point3D vec) {
	MyCoords coord=new MyCoords();
	
	this.metadata.setPoint((coord.add(this.metadata.getPoint(), vec)));
		
	}

	private void setPoint(Point3D point) {
		metadata.setPoint(point);
		
	}

	public void setPoint(double x, double y, double z) {
		metadata.setPoint(x,y,z);
		
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public Metadata getMetadata() {
		return metadata;
	}
	public Point3D getPoint() {
		return this.getMetadata().getPoint();
	}

}
