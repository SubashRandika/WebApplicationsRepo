package org.cinglevue.webapp.pojo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "schoolInformation", namespace = "org.cinglevue.webapp.pojo")
public class SchoolInformation {

	private School school;
	private String subject;
	private double latestY3;
	private double latestY5;
	private double latestY7;
	private double latestY9;
	private double rawGainY3Y5;
	private double factoredGainY3Y5;
	private double glgY3Y5;
	private double latestGainInGainY3Y5;

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getLatestY3() {
		return latestY3;
	}

	public void setLatestY3(double latestY3) {
		this.latestY3 = latestY3;
	}

	public double getLatestY5() {
		return latestY5;
	}

	public void setLatestY5(double latestY5) {
		this.latestY5 = latestY5;
	}

	public double getLatestY7() {
		return latestY7;
	}

	public void setLatestY7(double latestY7) {
		this.latestY7 = latestY7;
	}

	public double getLatestY9() {
		return latestY9;
	}

	public void setLatestY9(double latestY9) {
		this.latestY9 = latestY9;
	}

	public double getRawGainY3Y5() {
		return rawGainY3Y5;
	}

	public void setRawGainY3Y5(double rawGainY3Y5) {
		this.rawGainY3Y5 = rawGainY3Y5;
	}

	public double getFactoredGainY3Y5() {
		return factoredGainY3Y5;
	}

	public void setFactoredGainY3Y5(double factoredGainY3Y5) {
		this.factoredGainY3Y5 = factoredGainY3Y5;
	}

	public double getGlgY3Y5() {
		return glgY3Y5;
	}

	public void setGlgY3Y5(double glgY3Y5) {
		this.glgY3Y5 = glgY3Y5;
	}

	public double getLatestGainInGainY3Y5() {
		return latestGainInGainY3Y5;
	}

	public void setLatestGainInGainY3Y5(double latestGainInGainY3Y5) {
		this.latestGainInGainY3Y5 = latestGainInGainY3Y5;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		builder.append(this.getSchool().getSchoolName()).append("\n");
		builder.append(this.getSubject()).append("\n");
		builder.append(this.getFactoredGainY3Y5()).append("\n");
		builder.append(this.getGlgY3Y5()).append("\n");
		builder.append(this.getLatestGainInGainY3Y5()).append("\n");
		builder.append(this.getLatestY3()).append("\n");
		builder.append(this.getLatestY5()).append("\n");
		builder.append(this.getLatestY7()).append("\n");
		builder.append(this.getLatestY9()).append("\n");
		builder.append(this.getRawGainY3Y5()).append("\n");

		return builder.toString();
	}

}
