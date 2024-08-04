package com.kriscfoster.school.teacher;

import com.kriscfoster.school.subject.CreateSubjectDto;
import java.util.Set;

public record TeacherDto(Long id, String name, Set<CreateSubjectDto> subjects) {}
