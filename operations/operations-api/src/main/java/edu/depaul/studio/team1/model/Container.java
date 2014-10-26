/**
 * 
 */
package edu.depaul.studio.team1.model;

/**
 * Holds vitals collected from a container
 * 
 * @author ptrzyna
 */
public class Container {

	private long id;
	private long agenId;
	private long memTotal;
	private long memUsed;
	private long memFree;
	private String osDescription;
	private String osName;
	private String osDataModel;
	private String primaryIpAddress;
	private String primaryMacAddress;
	private String hostName;
	private String cpuVendor;
	private String cpuModel;
	private int cpuCount;
	private long diskSpaceTotal;
	private long diskSpaceFree;
	private long diskSpaceUsed;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the agenId
	 */
	public long getAgenId() {
		return agenId;
	}

	/**
	 * @param agenId
	 *            the agenId to set
	 */
	public void setAgenId(long agenId) {
		this.agenId = agenId;
	}

	/**
	 * @return the memTotal
	 */
	public long getMemTotal() {
		return memTotal;
	}

	/**
	 * @param memTotal
	 *            the memTotal to set
	 */
	public void setMemTotal(long memTotal) {
		this.memTotal = memTotal;
	}

	/**
	 * @return the memUsed
	 */
	public long getMemUsed() {
		return memUsed;
	}

	/**
	 * @param memUsed
	 *            the memUsed to set
	 */
	public void setMemUsed(long memUsed) {
		this.memUsed = memUsed;
	}

	/**
	 * @return the memFree
	 */
	public long getMemFree() {
		return memFree;
	}

	/**
	 * @param memFree
	 *            the memFree to set
	 */
	public void setMemFree(long memFree) {
		this.memFree = memFree;
	}

	/**
	 * @return the osDescription
	 */
	public String getOsDescription() {
		return osDescription;
	}

	/**
	 * @param osDescription
	 *            the osDescription to set
	 */
	public void setOsDescription(String osDescription) {
		this.osDescription = osDescription;
	}

	/**
	 * @return the osName
	 */
	public String getOsName() {
		return osName;
	}

	/**
	 * @param osName
	 *            the osName to set
	 */
	public void setOsName(String osName) {
		this.osName = osName;
	}

	/**
	 * @return the osDataModel
	 */
	public String getOsDataModel() {
		return osDataModel;
	}

	/**
	 * @param osDataModel
	 *            the osDataModel to set
	 */
	public void setOsDataModel(String osDataModel) {
		this.osDataModel = osDataModel;
	}

	/**
	 * @return the primaryIpAddress
	 */
	public String getPrimaryIpAddress() {
		return primaryIpAddress;
	}

	/**
	 * @param primaryIpAddress
	 *            the primaryIpAddress to set
	 */
	public void setPrimaryIpAddress(String primaryIpAddress) {
		this.primaryIpAddress = primaryIpAddress;
	}

	/**
	 * @return the primaryMacAddress
	 */
	public String getPrimaryMacAddress() {
		return primaryMacAddress;
	}

	/**
	 * @param primaryMacAddress
	 *            the primaryMacAddress to set
	 */
	public void setPrimaryMacAddress(String primaryMacAddress) {
		this.primaryMacAddress = primaryMacAddress;
	}

	/**
	 * @return the hostName
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * @param hostName
	 *            the hostName to set
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	/**
	 * @return the cpuVendor
	 */
	public String getCpuVendor() {
		return cpuVendor;
	}

	/**
	 * @param cpuVendor
	 *            the cpuVendor to set
	 */
	public void setCpuVendor(String cpuVendor) {
		this.cpuVendor = cpuVendor;
	}

	/**
	 * @return the cpuModel
	 */
	public String getCpuModel() {
		return cpuModel;
	}

	/**
	 * @param cpuModel
	 *            the cpuModel to set
	 */
	public void setCpuModel(String cpuModel) {
		this.cpuModel = cpuModel;
	}

	/**
	 * @return the cpuCount
	 */
	public int getCpuCount() {
		return cpuCount;
	}

	/**
	 * @param cpuCount
	 *            the cpuCount to set
	 */
	public void setCpuCount(int cpuCount) {
		this.cpuCount = cpuCount;
	}

	/**
	 * @return the diskSpaceTotal
	 */
	public long getDiskSpaceTotal() {
		return diskSpaceTotal;
	}

	/**
	 * @param diskSpaceTotal
	 *            the diskSpaceTotal to set
	 */
	public void setDiskSpaceTotal(long diskSpaceTotal) {
		this.diskSpaceTotal = diskSpaceTotal;
	}

	/**
	 * @return the diskSpaceFree
	 */
	public long getDiskSpaceFree() {
		return diskSpaceFree;
	}

	/**
	 * @param diskSpaceFree
	 *            the diskSpaceFree to set
	 */
	public void setDiskSpaceFree(long diskSpaceFree) {
		this.diskSpaceFree = diskSpaceFree;
	}

	/**
	 * @return the diskSpaceUsed
	 */
	public long getDiskSpaceUsed() {
		return diskSpaceUsed;
	}

	/**
	 * @param diskSpaceUsed
	 *            the diskSpaceUsed to set
	 */
	public void setDiskSpaceUsed(long diskSpaceUsed) {
		this.diskSpaceUsed = diskSpaceUsed;
	}

}
