package exam.model.role;

import java.io.Serializable;

/**
 * @Author 许恒亮
 * @Version 1.0
 */
public class Teacher implements Serializable {

	private static final long serialVersionUID = -1615504534445176240L;
	
	private String id;
	private String name;
	private String password;
	private boolean modified;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isModified() {
		return modified;
	}
	public void setModified(boolean modified) {
		this.modified = modified;
	}
	
}
