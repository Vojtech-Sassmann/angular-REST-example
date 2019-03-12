package cz.sassmann.webappdemo;

import java.util.Objects;

/**
 * @author Vojtech Sassmann <vojtech.sassmann@gmail.com>
 */
public class PerunInstance {

	private Long id;

	private String owner;

	private String url;

	private String version;

	public PerunInstance() {
	}

	public PerunInstance(String owner, String url, String version) {
		this.owner = owner;
		this.url = url;
		this.version = version;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PerunInstance that = (PerunInstance) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(owner, that.owner) &&
				Objects.equals(url, that.url) &&
				Objects.equals(version, that.version);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, owner, url, version);
	}
}
