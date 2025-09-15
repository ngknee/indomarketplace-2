package data;

public class Seller extends User{
	protected String namaToko;
	protected String jenisToko;
	protected String descToko;
	
	public Seller(String username, String password, String type, String namaToko, String jenisToko, String descToko) {
		super(username, password, type);
		this.namaToko = namaToko;
		this.jenisToko = jenisToko;
		this.descToko = descToko;
	}

	public String getNamaToko() {
		return namaToko;
	}
	public void setNamaToko(String namaToko) {
		this.namaToko = namaToko;
	}
	public String getJenisToko() {
		return jenisToko;
	}
	public void setJenisToko(String jenisToko) {
		this.jenisToko = jenisToko;
	}
	public String getDescToko() {
		return descToko;
	}
	public void setDescToko(String descToko) {
		this.descToko = descToko;
	}
}
