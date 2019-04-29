package com.lxisoft.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CompletedActivity.class)
public abstract class CompletedActivity_ {

	public static volatile SingularAttribute<CompletedActivity, RegisteredUser> registeredUser;
	public static volatile SingularAttribute<CompletedActivity, Activity> activityid;
	public static volatile SetAttribute<CompletedActivity, Media> proofs;
	public static volatile SingularAttribute<CompletedActivity, Long> id;

}

