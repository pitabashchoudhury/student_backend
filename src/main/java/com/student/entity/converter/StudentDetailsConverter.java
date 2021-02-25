package com.student.entity.converter;

import com.student.dto.StudentDetailDTO;
import com.student.entity.StudentDetails;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeToken;

import java.util.List;

public class StudentDetailsConverter {


    private StudentDetailsConverter(){

    }


    public static void getStudentDetailsEntityFromDto(StudentDetailDTO source, StudentDetails destination) {

        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<StudentDetailDTO, StudentDetails>() {
            @Override
            protected void configure() {
                skip(destination.getStudentId());
            }
        });
        mapper.map(source, destination);
    }

    public static StudentDetailDTO getStudentDetailsDtoFromEntity(StudentDetails studentDetails) {
        return getStudentDetailsDtoMapperWithTypeMap().map(studentDetails, StudentDetailDTO.class);
    }

    private static ModelMapper getStudentDetailsDtoMapperWithTypeMap() {
        ModelMapper mapper = getStudentDetailsDtoMapper();
        mapper.typeMap(StudentDetails.class, StudentDetailDTO.class).setPostConverter(context -> {
            return context.getDestination();
        });

        return mapper;
    }

    private static ModelMapper getStudentDetailsDtoMapper() {

        ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<StudentDetails, StudentDetailDTO>() {
            @Override
            protected void configure() {
//                skip(destination.getPassword());
            }
        });
        return mapper;
    }

    public static List<StudentDetailDTO> getListStudentDetailsDtoFromEntityList(List<StudentDetails> studentDetails) {
        return new ModelMapper().map(studentDetails, new TypeToken<List<StudentDetailDTO>>() {
        }.getType());
    }
}
