package com.lxisoft.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Media.class)
public abstract class Media_ {

	public static volatile SingularAttribute<Media, String> fileName;
	public static volatile SingularAttribute<Media, byte[]> file;
	public static volatile SingularAttribute<Media, Activity> activity;
	public static volatile SingularAttribute<Media, CompletedActivity> completedActivity;
	public static volatile SingularAttribute<Media, Long> id;
	public static volatile SingularAttribute<Media, String> fileContentType;

}

