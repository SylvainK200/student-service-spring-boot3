package com.kouemo.studentservice.feature.repositories;

import com.kouemo.studentservice.feature.dtos.ExaminationDtoInterface;
import com.kouemo.studentservice.feature.entities.Examination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExaminationRepository extends JpaRepository<Examination,Long> {

    @Query(nativeQuery = true,
            value = "select ex.rating as rating," +
                    "   ex.session as session," +
                    "   ex.date_examination as dateExamination," +
                    "   ex.id as id," +
                    "   professor.id as professorId," +
                    "   professor.name as professorName," +
                    "   professor.email_address as emailAddress," +
                    "   professor.phone_number as professorPhoneNumber," +
                    "   student.name as studentName," +
                    "   student.id as studentId," +
                    "   student.phone_number as studentPhoneNumber," +
                    "   student.email_address as studentEmailAddress ," +
                    "   subject.id as subjectId, " +
                    "   subject.name as subjectName," +
                    "   subject.objectives as subjectObjectives," +
                    "   subject.credit as subjectCredit " +
                    "from studentschema.examination as ex " +
                    "left join studentschema.subject as subject on ex.subject_id = subject.id " +
                    "left join studentschema.feature_user as professor on ex.professor_id = professor.id " +
                    "left join studentschema.feature_user as student on ex.student_id = student.id " +
                   "where (:search = '' or upper(subject.name) like concat('%',upper(:search),'%')) " +
                    "and (:search='' or upper(subject.objectives) like concat('%',upper(:search),'%')) " +
                    "and (:search='' or upper(student.name) like concat('%',upper(:search),'%')) " +
                    "and (:search= '' or upper(student.email_address) like concat('%',upper(:search),'%')) " +
                    "and (:search='' or upper(professor.name) like concat('%',upper(:search),'%')) " +
                    "and (:search= '' or upper(professor.email_address) like concat('%',upper(:search),'%')) ",

            countQuery = " select count(*) from (" +
                    "select ex.rating as rating " +
                    "from studentschema.examination as ex " +
                    "left join studentschema.subject as subject on ex.subject_id = subject.id " +
                    "left join studentschema.feature_user as professor on ex.professor_id = professor.id " +
                    "left join studentschema.feature_user as student on ex.student_id = student.id " +
                    "where (:search = '' or upper(subject.name) like concat('%',upper(:search),'%')) " +
                    "and (:search='' or upper(subject.objectives) like concat('%',upper(:search),'%')) " +
                    "and (:search='' or upper(student.name) like concat('%',upper(:search),'%')) " +
                    "and (:search= '' or upper(student.email_address) like concat('%',upper(:search),'%')) " +
                    "and (:search='' or upper(professor.name) like concat('%',upper(:search),'%')) " +
                    "and (:search= '' or upper(professor.email_address) like concat('%',upper(:search),'%')) "+
            ") ")
    Page<ExaminationDtoInterface> findAllBySearch(String search, Pageable pageable);
}
