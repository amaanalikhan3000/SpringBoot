package com.workshop.demo;

import com.workshop.demo.models.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class EmployeeSearchDao {

    private final EntityManager em;

    public List<Employee> findAllBySimpleQuery(
            String firstName, String lastName, String email
    ) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        // select * from Employee

        Root<Employee> root = criteriaQuery.from(Employee.class);

        /* prepare WHERE clause WHERE ~ Predicate
         where first LIKE "%ali%"  */
        Predicate firstNamePredicate = criteriaBuilder
                .like(root.get("firstname"), "%" + firstName + "%");

        Predicate lastNamePredicate = criteriaBuilder
                .like(root.get("lastname"), "%" + lastName + "%");

        Predicate emailPredicate = criteriaBuilder
                .like(root.get("email"), "%" + email + "%");

        Predicate firstNameorLastNamePredicate = criteriaBuilder
                .or(firstNamePredicate, lastNamePredicate);
        /* final query select * from employee where firstName  like "%ali%" */


        var andEmailPredicate = criteriaBuilder.and(firstNameorLastNamePredicate, emailPredicate);
        criteriaQuery.where(andEmailPredicate);

        TypedQuery<Employee> query = em.createQuery(criteriaQuery);

        return query.getResultList();
    }

}
