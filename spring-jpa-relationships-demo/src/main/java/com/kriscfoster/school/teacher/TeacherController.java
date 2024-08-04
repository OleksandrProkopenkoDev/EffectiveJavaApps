package com.kriscfoster.school.teacher;

import com.kriscfoster.school.subject.CreateSubjectDto;
import com.kriscfoster.school.subject.Subject;
import java.util.List;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

  @Autowired private TeacherRepository teacherRepository;

  @GetMapping
  public List<TeacherDto> getTeachers() {
    return teacherRepository.findAll().stream().map(this::toTeacherDto).toList();
  }

  @PostMapping
  public Teacher createTeacher(@RequestBody Teacher teacher) {
    return teacherRepository.save(teacher);
  }

  private TeacherDto toTeacherDto(Teacher teacher) {
    return new TeacherDto(
        teacher.getId(),
        teacher.getName(),
        teacher.getSubjects().stream().map(this::toSubjectDto).collect(Collectors.toSet()));
  }

  private CreateSubjectDto toSubjectDto(Subject subject) {
    return new CreateSubjectDto(subject.getName());
  }
}
