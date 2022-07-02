package com.dmr.medicalinternbackend.Service.patientLog;

import com.dmr.medicalinternbackend.DAO.*;
import com.dmr.medicalinternbackend.Entities.*;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import com.dmr.medicalinternbackend.dto.requests.PatientLogDto;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientLogService implements IPatientLogService {

    private final PatientLogDataAccess patientLogDataAccess;
    private final CoordinatorDataAccess coordinatorDataAccess;
    private final StudentDataAccess studentDataAccess;
    private final AttendingDataAccess attendingDataAccess;
    private final SpecialityDataAccess specialityDataAccess;
    private final CourseDataAccess courseDataAccess;
    private final ModelMapper modelMapper;

    public PatientLogService(PatientLogDataAccess patientLogDataAccess, CoordinatorDataAccess coordinatorDataAccess, StudentDataAccess studentDataAccess, AttendingDataAccess attendingDataAccess, SpecialityDataAccess specialityDataAccess, CourseDataAccess courseDataAccess, ModelMapper modelMapper) {
        this.patientLogDataAccess = patientLogDataAccess;
        this.coordinatorDataAccess = coordinatorDataAccess;
        this.studentDataAccess = studentDataAccess;
        this.attendingDataAccess = attendingDataAccess;
        this.specialityDataAccess = specialityDataAccess;
        this.courseDataAccess = courseDataAccess;
        this.modelMapper = modelMapper;
    }



    //insert a new form
    @Override
    public PatientLogForm insertForm(PatientLogDto formDto) {
        PatientLogForm form = mapDtoToEntity(formDto);
        return patientLogDataAccess.save(form);
    }


    @Override
    public void deleteForm(int id) {
        PatientLogForm patientLogFormMaybe = patientLogDataAccess.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Form", "ID", id));
        patientLogDataAccess.deleteById(patientLogFormMaybe.getId());
    }

    @Override
    public void deleteAllForms() {
        patientLogDataAccess.deleteAll();
    }


    public PatientLogForm mapDtoToEntity(PatientLogDto dto) {
        //map PatientLogDto to PatientLogForm
        PatientLogForm form = new PatientLogForm();
        Course course = courseDataAccess.findById(dto.getCourseId()).orElseThrow(() ->
                new ResourceNotFoundException("Course", "id", dto.getCourseId()));
        Coordinator coordinator = coordinatorDataAccess.findById(dto.getCoordinatorId()).orElseThrow(() ->
                new ResourceNotFoundException("Coordinator", "id", dto.getCoordinatorId()));
        AttendingPhysician attendingPhysician = attendingDataAccess.findById(dto.getAttendingId()).orElseThrow(() ->
                new ResourceNotFoundException("Attending", "ID", dto.getAttendingId()));
        Student student = studentDataAccess.findById(dto.getStudentId()).orElseThrow(() ->
                new ResourceNotFoundException("Student", "ID", dto.getStudentId()));
        Speciality speciality = specialityDataAccess.findById(dto.getSpecialityId()).orElseThrow(() ->
                new ResourceNotFoundException("Speciality", "Id", dto.getSpecialityId()));
        form.setCoordinator(coordinator);
        form.setCourse(course);
        form.setStudent(student);
        form.setAttending(attendingPhysician);
        form.setSpeciality(speciality);
        form.setKayitNo(dto.getKayitNo());
        form.setCinsiyet(dto.getCinsiyet());
        form.setYas(dto.getYas());
        form.setSikayet(dto.getSikayet());
        form.setAyiriciTani(dto.getAyiriciTani());
        form.setKesinTani(dto.getKesinTani());
        form.setTedaviYontemi(dto.getTedaviYontemi());
        form.setEtkilesimTuru(dto.getEtkilesimTuru());
        form.setKapsam(dto.getKapsam());
        form.setGerceklestigiOrtam(dto.getGerceklestigiOrtam());
        form.setStatus(dto.getStatus());

        return form;
    }
    //TODO: map PatientLogDto to PatientLog Form using modelmapper not manually
/*    public PatientLogForm mapDtoToEntity(PatientLogDto dto){

        TypeMap<PatientLogDto, PatientLogForm> typeMap =
                modelMapper.createTypeMap(dto, PatientLogForm.class);
        PatientLogForm form = new PatientLogForm();

// Define the mappings on the type map
        typeMap.addMappings(mapper -> {

            mapper.map(src -> src.getStudentId(),form.getStudent()::setId);
        });
    }*/

    //FIXME: Use a reasonable way. Dont use if else
    @Override
    public ResponseEntity<List<PatientLogForm>> getFormsById(int studentId,String status) {

        return new ResponseEntity<>(patientLogDataAccess.findByStudentIdAndStatus(studentId,status), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<PatientLogForm>> getFormsAttending(int id, String status) {
        return new ResponseEntity<>(patientLogDataAccess.findByAttendingIdAndStatus(id,status), HttpStatus.OK);
    }

    @Override
    public PatientLogForm updateStatus(PatientLogDto dto, int id) {
        PatientLogForm form =patientLogDataAccess.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Patient log", "id", id));

        Course course = courseDataAccess.findById(dto.getCourseId()).orElseThrow(() ->
                new ResourceNotFoundException("Course", "id", dto.getCourseId()));
        Coordinator coordinator = coordinatorDataAccess.findById(dto.getCoordinatorId()).orElseThrow(() ->
                new ResourceNotFoundException("Coordinator", "id", dto.getCoordinatorId()));
        AttendingPhysician attendingPhysician = attendingDataAccess.findById(dto.getAttendingId()).orElseThrow(() ->
                new ResourceNotFoundException("Attending", "ID", dto.getAttendingId()));
        Student student = studentDataAccess.findById(dto.getStudentId()).orElseThrow(() ->
                new ResourceNotFoundException("Student", "ID", dto.getStudentId()));
        Speciality speciality = specialityDataAccess.findById(dto.getSpecialityId()).orElseThrow(() ->
                new ResourceNotFoundException("Speciality", "Id", dto.getSpecialityId()));
        form.setCoordinator(coordinator);
        form.setCourse(course);
        form.setStudent(student);
        form.setAttending(attendingPhysician);
        form.setSpeciality(speciality);
        form.setKayitNo(dto.getKayitNo());
        form.setCinsiyet(dto.getCinsiyet());
        form.setYas(dto.getYas());
        form.setSikayet(dto.getSikayet());
        form.setAyiriciTani(dto.getAyiriciTani());
        form.setKesinTani(dto.getKesinTani());
        form.setTedaviYontemi(dto.getTedaviYontemi());
        form.setEtkilesimTuru(dto.getEtkilesimTuru());
        form.setKapsam(dto.getKapsam());
        form.setGerceklestigiOrtam(dto.getGerceklestigiOrtam());
        form.setStatus(dto.getStatus());
        patientLogDataAccess.save(form);
        return form;
    }
}

/*   // map PatientLogUpdateDto class to PatientLogForm
    public PatientLogForm mapUpdateDtoToEntity(PatientLogUpdateDto updateDto) {

        return modelMapper.map(updateDto, PatientLogForm.class);
    }*/
   /* PatientLogForm form = patientLogDataAccess.findById(dto.getId()).orElseThrow(()
                -> new ResourceNotFoundException("Patient log", "id", dto.getId()));
        Course course = courseDataAccess.findById(dto.getCourseId()).orElseThrow(() ->
                new ResourceNotFoundException("Course", "id", dto.getCourseId()));
        Coordinator coordinator = coordinatorDataAccess.findById(dto.getCoordinatorId()).orElseThrow(() ->
                new ResourceNotFoundException("Coordinator", "id", dto.getCoordinatorId()));
        AttendingPhysician attendingPhysician = attendingDataAccess.findById(dto.getAttendingId()).orElseThrow(() -> new ResourceNotFoundException("Attending", "ID", dto.getAttendingId()));
        Student student = studentDataAccess.findById(dto.getStudentId()).orElseThrow(() ->
                new ResourceNotFoundException("Student", "ID", dto.getStudentId()));
        Speciality speciality = specialityDataAccess.findById(dto.getSpecialityId()).orElseThrow(() ->
                new ResourceNotFoundException("Speciality", "Id", dto.getSpecialityId()));
        form.setId(dto.getId());
        form.setCoordinator(coordinator);
        form.setCourse(course);
        form.setStudent(student);
        form.setAttending(attendingPhysician);
        form.setSpeciality(speciality);
        form.setKayitNo(dto.getKayitNo());
        form.setCinsiyet(dto.getCinsiyet());
        form.setYas(dto.getYas());
        form.setSikayet(dto.getSikayet());
        form.setAyiriciTani(dto.getAyiriciTani());
        form.setKesinTani(dto.getKesinTani());
        form.setTedaviYontemi(dto.getTedaviYontemi());
        form.setEtkilesimTuru(dto.getEtkilesimTuru());
        form.setKapsam(dto.getKapsam());
        form.setGerceklestigiOrtam(dto.getGerceklestigiOrtam());
        form.setStatus(dto.getStatus());*/
