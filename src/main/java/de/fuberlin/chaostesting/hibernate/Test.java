package de.fuberlin.chaostesting.hibernate;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name="TEST_INFORMATION")
public class Test {	
	@Id	@GeneratedValue
	@Column(name="test_id")
	private int id;
	@Column(name="test_von")
	private String von;
	@Column(name="test_nach")
	private String nach;
	@Column(name="test_zeitpunkt")
	private Date zeitpunkt;
	@Column(name="test_reisende")
	private String reisende;
	@Column(name="test_klasse")
	private String klasse;
	@Column(name="test_Angebot")
	private boolean angebot;
	@Column(name="test_sparpreis")
	private boolean sparpreis;
	@Column(name="test_flexpreis")
	private boolean flexpreis;
	
	public Test() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVon() {
		return von;
	}

	public void setVon(String von) {
		this.von = von;
	}

	public String getNach() {
		return nach;
	}

	public void setNach(String nach) {
		this.nach = nach;
	}

	public Date getZeitpunkt() {
		return zeitpunkt;
	}

	public void setZeitpunkt(Date zeitpunkt) {
		this.zeitpunkt = zeitpunkt;
	}

	public String getReisende() {
		return reisende;
	}

	public void setReisende(String reisende) {
		this.reisende = reisende;
	}

	public String getKlasse() {
		return klasse;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}

	public boolean isAngebot() {
		return angebot;
	}

	public void setAngebot(boolean angebot) {
		this.angebot = angebot;
	}

	public boolean isSparpreis() {
		return sparpreis;
	}

	public void setSparpreis(boolean sparpreis) {
		this.sparpreis = sparpreis;
	}

	public boolean isFlexpreis() {
		return flexpreis;
	}

	public void setFlexpreis(boolean flexpreis) {
		this.flexpreis = flexpreis;
	}

	public void register() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(this);
		
		session.getTransaction().commit();
	}
	
	public static List<Test> list(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Test> tests = session.createQuery("FROM Test", Test.class).getResultList();
		
		session.getTransaction().commit();
		
		return tests;
	}
	
	public String toXML(){
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
				+"<angebotsAnfrage msgVersion=\"1.0\">"
				+"<allgemeineAngaben wagenKlasse_e=\"KLASSE_"+klasse+"\"/>"
				+"<reisender typ_e=\"ERWACHSENER\" anzahl=\""+reisende+"\"/>"
				+"<verbindungsParameter zeitpunkt=\""+zeitpunkt+"\" >"
				+"<halt bahnhof=\""+von+"\"/>"
				+"<halt bahnhof=\""+nach+"\"/>"
				+"</verbindungsParameter>"
				+"</angebotsAnfrage>";		
		return xml;
	}
	
	public static Test byId(int id) {
		Test theTest = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		theTest = session.get(Test.class, id);
		
		session.close();
		
		return theTest;
	}
}
