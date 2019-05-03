package com.lxisoft.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Activity.class)
public abstract class Activity_ {

	public static volatile SingularAttribute<Activity, String> description;
	public static volatile SetAttribute<Activity, Media> files;
	public static volatile SingularAttribute<Activity, InstructionVideo> instructionVideo;
	public static volatile SetAttribute<Activity, CompletedActivity> completedActivities;
	public static volatile SingularAttribute<Activity, Long> id;
	public static volatile SingularAttribute<Activity, String> title;
	public static volatile SingularAttribute<Activity, String> successMessage;
	public static volatile SingularAttribute<Activity, String> url;

}

