package payload;


import com.app.waylearn.Entities.Grupo;

public class RequestGroup {
	
	private Long idTeacher;
	
	private Grupo group;

	public RequestGroup() {
		super();
	}

	public RequestGroup(Long idTeacher, Grupo group) {
		super();
		this.idTeacher = idTeacher;
		this.group = group;
	}

	public Long getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(Long idTeacher) {
		this.idTeacher = idTeacher;
	}

	public Grupo getGrupo() {
		return group;
	}

	public void setGrupo(Grupo group) {
		this.group = group;
	}
	
}
