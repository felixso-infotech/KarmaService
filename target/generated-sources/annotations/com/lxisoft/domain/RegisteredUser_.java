package com.lxisoft.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RegisteredUser.class)
public abstract class RegisteredUser_ {

	public static volatile SingularAttribute<RegisteredUser, String> firstName;
	public static volatile SingularAttribute<RegisteredUser, String> lastName;
	public static volatile SingularAttribute<RegisteredUser, Long> noOfCoins;
	public static volatile SingularAttribute<RegisteredUser, Long> noOfSilverMedals;
	public static volatile SingularAttribute<RegisteredUser, Long> phoneNumber;
	public static volatile SingularAttribute<RegisteredUser, Media> profilePic;
	public static volatile SetAttribute<RegisteredUser, CompletedActivity> completedActivities;
	public static volatile SingularAttribute<RegisteredUser, Long> id;
	public static volatile SingularAttribute<RegisteredUser, Long> noOfBronzeMedals;
	public static volatile SingularAttribute<RegisteredUser, Long> noOfGoldMedals;
	public static volatile SingularAttribute<RegisteredUser, String> email;

}

