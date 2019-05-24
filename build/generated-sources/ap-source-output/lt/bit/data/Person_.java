package lt.bit.data;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ {

	public static volatile SingularAttribute<Person, String> firstName;
	public static volatile SingularAttribute<Person, String> lastName;
	public static volatile ListAttribute<Person, Address> addresses;
	public static volatile SingularAttribute<Person, Integer> id;
	public static volatile SingularAttribute<Person, BigDecimal> salary;
	public static volatile SingularAttribute<Person, Date> birthDate;
	public static volatile ListAttribute<Person, Contact> contacts;

}

