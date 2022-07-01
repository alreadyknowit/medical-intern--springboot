package com.dmr.medicalinternbackend.Service.patientLog;

import com.dmr.medicalinternbackend.DAO.*;
import com.dmr.medicalinternbackend.Entities.*;
import com.dmr.medicalinternbackend.Exception.ResourceNotFoundException;
import com.dmr.medicalinternbackend.dto.requests.PatientLogDto;
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

    //gets only one form using id .../patient-logs/19
    @Override
    public PatientLogForm getById(int id) {
        return patientLogDataAccess.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Form", "ID", id));
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
    @SuppressWarnings({"OptionalUsedAsFieldOrParameterType", "ConstantConditions"})
    public ResponseEntity<List<PatientLogForm>> getFormsById(int studentId,String status) {

        return new ResponseEntity<>(patientLogDataAccess.findByStudentIdAndStatus(studentId,status), HttpStatus.OK);
      /*  if (studentId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.
                    findByStudentIdAndStatus(studentId.get(), status), HttpStatus.OK);
        else if (coordinatorId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.
                    findAllByCoordinatorIdAndStatus(coordinatorId.get(), status), HttpStatus.OK);
        else if (attendingId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.
                    findAllByAttendingIdAndStatus(attendingId.get(), status), HttpStatus.OK);
        else if (studentId.isPresent() && attendingId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.
                    findAllByStudentIdAndAttendingIdAndStatus(studentId.get(),
                            attendingId.get(), status), HttpStatus.OK);
        else if (studentId.isPresent() && coordinatorId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.
                    findAllByStudentIdAndCoordinatorIdAndStatus(studentId.get(),
                            coordinatorId.get(), status), HttpStatus.OK);
        else if (attendingId.isPresent() & coordinatorId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.
                    findAllByAttendingIdAndCoordinatorIdAndStatus(attendingId.get(),
                            coordinatorId.get(), status), HttpStatus.OK);
        else if (studentId.isPresent() && coordinatorId.isPresent() && attendingId.isPresent())
            return new ResponseEntity<>(patientLogDataAccess.
                    findAllByStudentIdAndAttendingIdAndCoordinatorIdAndStatus(
                            studentId.get(), attendingId.get(),
                            coordinatorId.get(), status), HttpStatus.OK);
        else throw new ResourceNotFoundException("Patient Logs", "id", -1);*/


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
