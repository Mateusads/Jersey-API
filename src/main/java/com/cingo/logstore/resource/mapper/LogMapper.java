package com.cingo.logstore.resource.mapper;

import com.cingo.logstore.entity.Log;
import com.cingo.logstore.resource.dto.LogRequestDTO;
import com.cingo.logstore.resource.dto.LogResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LogMapper {

        public static Log toEntity(LogRequestDTO logRequestDTO) {
            return Log.builder()
                    .content(logRequestDTO.getContent())
                    .occurrences(+1)
                    .build();
        }

        public static LogResponseDTO toDTO(Log response) {
            return LogResponseDTO.builder()
                    .id(response.getId())
                    .content(response.getContent())
                    .occurrences(response.getOccurrences())
                    .build();
        }

        public static List<LogResponseDTO> toDTOs(List<Log> logs) {
            return logs.stream()
                    .map(LogMapper::toDTO)
                    .collect(Collectors.toList());

        }
    }