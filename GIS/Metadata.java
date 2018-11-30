package GIS;

import Geom.Point3D;
import java.awt.Color;

public class Metadata implements Meta_data {

	private String time;
	private Point3D point;
	private String MAC, SSID, AuthMode;
	private Long creation_Time;
	
	public  Metadata(Long creationTime) {
		this.creation_Time=creationTime;
	}
	
	public  Metadata() {
		this.creation_Time=System.currentTimeMillis();
	}


	@Override
	public long getUTC() {
		time=time.replaceAll("[/,:,.,-,-, ]", "");
		Long UTC=Long.parseLong(time);
		return UTC;
	}
	public String toString() {
		return "First seen:"+ this.getTime() +"\n Coordinate:"+ point.toString();
	}
	@Override
	public Point3D get_Orientation() {
		return null;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTime() {
		return time;
	}
	public Point3D getPoint() {
		return point;
	}
	public void setPoint(Point3D point) {
		this.point =new Point3D( point);
	}
	public void setPoint(double x, double y, double z) {
		this.point = new Point3D(x,y,z);

	}
	public String getMAC() {
		return MAC;
	}
	public void setMAC(String mAC) {
		MAC = mAC;
	}
	public String getSSID() {
		return SSID;
	}
	public void setSSID(String sSID) {
		SSID = sSID;
	}
	public String getAuthMode() {
		return AuthMode;
	}
	public void setAuthMode(String authMode) {
		AuthMode = authMode;
	}




}
