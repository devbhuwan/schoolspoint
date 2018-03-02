package io.schoolspointframework.core.jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bhuwan Prasad Upadhyay
 */
public interface EntityRepository extends JpaRepository<XEntity, Integer> {
}
