package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.dtos.SubjectDtoInterface;
import com.kouemo.studentservice.feature.entities.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

    @Query(nativeQuery = true,
            value=
                    "   select subject.id as subjectId, " +
                            "   subject.name as subjectName," +
                            "   subject.objectives as subjectObjectives," +
                            "   subject.credit as subjectCredit" +
                            " from studentschema.subject as subject " +
                            "where (:search = '' or upper(subject.name) like concat('%',upper(:search),'%')) " +
                            "and (:search='' or upper(subject.objectives) like concat('%',upper(:search),'%')) "
            ,
            countQuery = "select count (*) from (" +
                    "   select subject.id as subjectId, " +
                    "   subject.name as subjectName," +
                    "   subject.objectives as subjectObjectives," +
                    "   subject.credit as subjectCredit" +
                    " from studentschema.subject as subject "+
                    "where (:search = '' or upper(subject.name) like concat('%',upper(:search),'%')) " +
                    "and (:search='' or upper(subject.objectives) like concat('%',upper(:search),'%')) " +
            ")")
    Page<SubjectDtoInterface> findAllBySearch(String search, Pageable pageable);
}
