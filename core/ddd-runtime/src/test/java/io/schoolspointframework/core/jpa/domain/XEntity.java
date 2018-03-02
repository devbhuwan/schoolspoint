package io.schoolspointframework.core.jpa.domain;

import io.schoolspointframework.core.ddd.annotations.DddEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Bhuwan Prasad Upadhyay
 */
@DddEntity
public class XEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
